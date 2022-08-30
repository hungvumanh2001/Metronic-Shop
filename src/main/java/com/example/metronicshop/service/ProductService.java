package com.example.metronicshop.service;

import com.example.metronicshop.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ProductService {
    Page<Product> findAll(Pageable pageable);
    void save(Product product);
    Page<Product> findAllByCategoryId(Pageable pageable,Long id);
    Iterable<Product> findAllByPriceBetween(float from,float to);
    Iterable<Product> findAllBySaleBetween(Pageable pageable, float from,float to);
    Product findById(Long id);
}
