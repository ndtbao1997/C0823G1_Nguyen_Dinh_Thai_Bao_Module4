package com.example.product_management.service;

import com.example.product_management.dto.IProductDTO;
import com.example.product_management.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface IProductService {
    Page<IProductDTO> findAllDTO(Pageable pageable);

    Optional<Product> findById(Long id);
//    Iterable<Product> findAll();
//
//    Page<Product> findAll(Pageable pageable);
//
//    void save(Product product);
}
