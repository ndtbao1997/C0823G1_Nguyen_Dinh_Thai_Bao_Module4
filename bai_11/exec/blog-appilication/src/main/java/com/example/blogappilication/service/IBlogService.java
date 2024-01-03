package com.example.blogappilication.service;

import com.example.blogappilication.model.Blog;
import com.example.blogappilication.model.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IBlogService extends IGenerateService<Blog>{
    Page<Blog> findAll(Pageable pageable);

    Page<Blog> findAllByOrderByPublishDateDesc(Pageable pageable);

    Page<Blog> findAllByTitleContaining(String search, Pageable pageable);

    Iterable<Blog> findAllByCategory(Category category);
}
