package com.example.blogappilication.repository;

import com.example.blogappilication.model.Category;
import org.springframework.data.repository.CrudRepository;

public interface ICategoryRepository extends CrudRepository<Category,Integer> {
}
