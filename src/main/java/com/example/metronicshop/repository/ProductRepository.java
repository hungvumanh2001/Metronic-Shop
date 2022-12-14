package com.example.metronicshop.repository;

import com.example.metronicshop.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    Page<Product> findAll(Pageable pageable);

    Page<Product> findAllByTitleContains(Pageable pageable, String key);

    Page<Product> findAllByCategoryId(Pageable pageable, Long id);

    Page<Product> findAllByPriceBetween(Pageable pageable, float from, float to);

    Page<Product> findAllBySaleBetween(Pageable pageable, float from, float to);

    Product findAllById(Long id);
}
