package com.example.product_management.service.impl;

import com.example.product_management.model.Category;
import com.example.product_management.repository.ICategoryRepository;
import com.example.product_management.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CategoryServiceImpl implements ICategoryService {
    @Autowired
    private ICategoryRepository iCategoryRepository;
    @Override
    public Optional<Category> findById(Long i) {
        return iCategoryRepository.findById(i);
    }
}
