package com.example.metronicshop.service;



import com.example.metronicshop.model.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.Optional;

public interface UserService extends UserDetailsService {
    void save(User user);

    Iterable<User> findAll();


    User findByUsername(String username);

    User getCurrentUser();

    Optional<User> findById(Integer id);

    UserDetails loadUserById(Integer id);

    boolean checkLogin(User user);

    boolean isRegister(User user);

    boolean isCorrectConfirmPassword(User user);

}