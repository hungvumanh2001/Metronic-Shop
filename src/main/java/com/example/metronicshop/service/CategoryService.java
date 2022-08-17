package com.example.metronicshop.service;

import com.example.metronicshop.model.Category;
import org.springframework.stereotype.Service;

import java.util.List;

public interface CategoryService {
    List<Category> findAll();
}
