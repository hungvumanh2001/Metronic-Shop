package com.example.metronicshop.service.impl;

import com.example.metronicshop.model.Category;
import com.example.metronicshop.repository.CategoryRepository;
import com.example.metronicshop.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    CategoryRepository categoryRepository;
    @Override
    public List<Category> findAll() {
        return categoryRepository.findAll();
    }
}
