package com.example.shopping_cart_application.service;

import com.example.shopping_cart_application.model.Product;

import java.util.Optional;

public interface IProductService {
    Iterable<Product> findAll();

    Optional<Product> findById(Integer id);
}
