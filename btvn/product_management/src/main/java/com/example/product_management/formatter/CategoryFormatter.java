package com.example.product_management.formatter;


import com.example.product_management.model.Category;
import com.example.product_management.service.ICategoryService;
import org.springframework.format.Formatter;

import java.util.Locale;
import java.util.Optional;

public class CategoryFormatter implements Formatter<Category> {
    private final ICategoryService iCategoryService;

    public CategoryFormatter(ICategoryService iCategoryService) {
        this.iCategoryService = iCategoryService;
    }

    @Override
    public Category parse(String text, Locale locale) {
        Optional<Category> categoryOptional = iCategoryService.findById(Long.parseLong(text));
        return categoryOptional.orElse(null);
    }

    @Override
    public String print(Category object, Locale locale) {
        return "[" + object.getId() + "," + object.getName() + "]";
    }
}
