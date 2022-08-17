package com.example.metronicshop.repository;

import com.example.metronicshop.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
//    List<Product> findAll();
    Page<Product> findAllByCategoryId(Pageable pageable,Long id);
    Iterable<Product>findAllByPriceBetween(float from,float to);
    Iterable<Product>findAllBySaleBetween(float from,float to);
}
