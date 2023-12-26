package com.example.customer_management.repository;


import com.example.customer_management.model.Customer;
import com.example.customer_management.model.Province;
import org.springframework.data.repository.CrudRepository;

public interface ICustomerRepository extends CrudRepository<Customer, Long> {
    Iterable<Customer> findAllByProvince(Province province);
}