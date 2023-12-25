package com.example.productmanagementapplication.repository;

import com.example.productmanagementapplication.model.Product;

import java.util.List;

public interface IProductRepository {
    List<Product> findAll();
    void save(Product product);
    Product findById(int id);
    void update(int id, Product product);
    void remove(int id);

    boolean checkId(int id);

    List<Product> findByName(String name);
}
