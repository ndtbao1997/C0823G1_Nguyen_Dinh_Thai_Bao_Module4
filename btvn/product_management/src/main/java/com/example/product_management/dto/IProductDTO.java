package com.example.product_management.dto;

import java.util.List;

public interface IProductDTO {
    Long getId();
    String getName();
    Long getPrice();
    Long getQuantity();
    String getImage();

    String getCategoryName();
}
