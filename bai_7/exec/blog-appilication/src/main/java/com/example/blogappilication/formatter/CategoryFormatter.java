package com.example.blogappilication.formatter;

import com.example.blogappilication.model.Category;
import com.example.blogappilication.service.ICategoryService;
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
        Optional<Category> categoryOptional = iCategoryService.findById(Integer.parseInt(text));
        return categoryOptional.orElse(null);
    }

    @Override
    public String print(Category object, Locale locale) {
        return "[" + object.getId() + "," + object.getName() + "]";
    }
}
