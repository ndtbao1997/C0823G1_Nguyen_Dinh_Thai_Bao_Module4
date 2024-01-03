package com.example.product_management.service;

import com.example.product_management.model.Category;

import java.util.Optional;

public interface ICategoryService {
    Optional<Category> findById(Long i);
}
