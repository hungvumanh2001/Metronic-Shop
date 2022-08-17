package com.example.metronicshop.service;

import com.example.metronicshop.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ProductService {
    Iterable<Product> findAll();
    void save(Product product);
    Page<Product> findAllByCategoryId(Pageable pageable,Long id);
    Iterable<Product> findAllByPriceBetween(float from,float to);
    Iterable<Product> findAllBySaleBetween(float from,float to);
}
