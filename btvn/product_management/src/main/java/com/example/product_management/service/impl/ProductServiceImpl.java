package com.example.product_management.service.impl;

import com.example.product_management.dto.IProductDTO;
import com.example.product_management.model.Product;
import com.example.product_management.repository.IProductRepository;
import com.example.product_management.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductServiceImpl implements IProductService {
    @Autowired
    private IProductRepository iProductRepository;
    @Override
    public Page<IProductDTO> findAllDTO(Pageable pageable) {
        return iProductRepository.findAllDTO(pageable);
    }

    @Override
    public Optional<Product> findById(Long id) {
        return iProductRepository.findById(id);
    }
}
