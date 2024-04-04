package com.example.blogappilication.service;

import com.example.blogappilication.model.Blog;
import com.example.blogappilication.model.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IBlogService extends IGenerateService<Blog>{
    List<Blog> findAll(Integer page);

    Page<Blog> findAllByOrderByPublishDateDesc(Pageable pageable);

    Page<Blog> findAllByTitleContaining(String search, Pageable pageable);
    Iterable<Blog> findAllByTitleContaining(String search);

    Iterable<Blog> findAllByCategory(Category category);
}
