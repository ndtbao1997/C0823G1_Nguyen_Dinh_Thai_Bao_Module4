package com.example.customer_management.repository;

import com.example.customer_management.model.Province;
import org.springframework.data.repository.CrudRepository;

public interface IProvinceRepository extends CrudRepository<Province, Long> {
}