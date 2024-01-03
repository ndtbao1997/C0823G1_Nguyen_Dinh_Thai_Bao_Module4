package com.example.blogappilication.service;

import com.example.blogappilication.model.Blog;

import java.util.Optional;

public interface IGenerateService<T> {
    Iterable<T> findAll();

    Blog save(T t);

    Optional<T> findById(Integer id);

    void remove(Integer id);
}