package com.example.metronicshop.controller;

import com.example.metronicshop.model.Product;
import com.example.metronicshop.repository.ProductRepository;
import com.example.metronicshop.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@Controller
@CrossOrigin("*")
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping("/{id}")
    public ResponseEntity<Product> findById(@PathVariable Long id) {
        Product product = productService.findById(id);
        if (product == null)
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(product, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<Iterable<Product>> findAll(@PageableDefault(size = 3) Pageable page) {
        Iterable<Product> products = productService.findAll(page);
        if (products == null)
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    @GetMapping("/search-by-cateId")
    public ResponseEntity<Iterable<Product>> findAllByCateId(@PageableDefault(size = 3) Pageable page, @RequestParam Long id) {
        Iterable<Product> products = productService.findAllByCategoryId(page, id);
        if (products == null)
            return new ResponseEntity<>(products, HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    @GetMapping("/price-between")
    public ResponseEntity<Iterable<Product>> findAllByPriceBetween(@RequestParam float from, @RequestParam float to) {
        Iterable<Product> products = productService.findAllByPriceBetween(from, to);
        if (products == null)
            return new ResponseEntity<>(products, HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    //tất cả những sản phẩm đc sale
    @GetMapping("/sale-between")
    public ResponseEntity<Iterable<Product>> findAllBySaleBetween(@PageableDefault(size = 4) Pageable page, @RequestParam float from, @RequestParam float to) {
        Iterable<Product> products = productService.findAllBySaleBetween(page, from, to);
        if (products == null)
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(products, HttpStatus.OK);
    }
}
