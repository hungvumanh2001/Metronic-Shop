package com.example.metronicshop.controller;

import com.example.metronicshop.model.Cart;
import com.example.metronicshop.model.JwtResponse;
import com.example.metronicshop.model.Role;
import com.example.metronicshop.model.User;
import com.example.metronicshop.repository.UserRepository;
import com.example.metronicshop.service.impl.JwtService;
import com.example.metronicshop.service.RoleService;
import com.example.metronicshop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@RestController
@PropertySource("classpath:application.properties")
@CrossOrigin("*")
public class UserController {
    @Autowired
    private AuthenticationManager authenticationManager;


    @Autowired
    private JwtService jwtService;

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleService roleService;

    @Autowired
    private PasswordEncoder passwordEncoder;


    @GetMapping
    public ResponseEntity<Iterable<User>> showAllUser() {
        Iterable<User> users = userService.findAll();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }
    @GetMapping("/id")
    public ResponseEntity<Optional<User>>findById(@PathVariable Long id)
    {
        Optional<User> user=userService.findById(id);

        return new ResponseEntity<>(user,HttpStatus.OK);
    }
    @PostMapping("/register")
    public ResponseEntity<User> createUser(@RequestBody User user, BindingResult bindingResult) {
        if (bindingResult.hasFieldErrors()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        Iterable<User> users = userService.findAll();
        for (User currentUser : users) {
            if (currentUser.getUsername().equals(user.getUsername())) {
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
        }
        if (!userService.isCorrectConfirmPassword(user)) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        if (user.getRoles() != null) {
            Role role = roleService.findByName("ROLE_ADMIN");
            Set<Role> roles = new HashSet<>();
            roles.add(role);
            user.setRoles(roles);
        } else {
            Role role1 = roleService.findByName("ROLE_USER");
            Set<Role> roles1 = new HashSet<>();
            roles1.add(role1);
            user.setRoles(roles1);
        }
//        user.setPassword(passwordEncoder.encode(user.getPassword()));
//        user.setConfirmPassword(passwordEncoder.encode(user.getConfirmPassword()));
        user.setPassword(user.getPassword());
        user.setConfirmPassword(user.getConfirmPassword());
        userService.save(user);
        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody User user) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);

        String jwt = jwtService.generateTokenLogin(authentication);
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        User currentUser = userService.findByUsername(user.getUsername());
        return ResponseEntity.ok(new JwtResponse(jwt, (long) currentUser.getId(), userDetails.getUsername(), userDetails.getAuthorities()));
    }

    @PutMapping("/update-user/{id}")
    public ResponseEntity updateCart(@PathVariable Long id, @RequestBody User user) {
        Optional<User> oldUser = userRepository.findById(id);
        if (!oldUser.isPresent()) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        user.setId(id);
        userRepository.save(user);
        return new ResponseEntity(HttpStatus.OK);
    }
}
