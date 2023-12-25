package com.example.productmanagement.repository;


import com.example.productmanagement.model.Product;

import java.util.List;

public interface IProductRepository {
    List<Product> findAll();
    void save(Product product);
    Product findById(int id);
    void remove(int id);
    List<Product> findByName(String name);
}
