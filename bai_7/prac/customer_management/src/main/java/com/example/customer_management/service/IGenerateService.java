package com.example.customer_management.service;

import com.example.customer_management.model.Province;

import java.util.List;
import java.util.Optional;

public interface IGenerateService<T> {
    Iterable<T> findAll();

    void save(T t);

    Optional<T> findById(Long id);

    void remove(Long id);
}