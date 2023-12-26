package com.example.customer_management.service;

import com.example.customer_management.model.Customer;
import com.example.customer_management.model.Province;

public interface ICustomerService  extends IGenerateService<Customer>{
    Iterable<Customer> findAllByProvince(Province province);
}
