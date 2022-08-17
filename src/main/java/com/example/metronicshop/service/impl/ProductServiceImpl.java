package com.example.metronicshop.service.impl;

import com.example.metronicshop.model.Product;
import com.example.metronicshop.repository.ProductRepository;
import com.example.metronicshop.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository repository;
    //phân trang sản phẩm
    @Override
    public Page<Product> findAll(Pageable page) {
        return repository.findAll(page);
    }

    @Override
    public void save(Product product) {
        repository.save(product);
    }

    @Override
    public Page<Product> findAllByCategoryId(Pageable page,Long id) {
        return repository.findAllByCategoryId(page,id);
    }

    @Override
    public Iterable<Product> findAllByPriceBetween(float from, float to) {
        return repository.findAllByPriceBetween(from,to);
    }

    @Override
    public Iterable<Product> findAllBySale(float sale) {
        return repository.findAllBySale(sale);
    }
}
