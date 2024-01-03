package com.example.shopping_cart_application.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "product")
@Getter
@Setter
public class Product {
    @Getter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Getter
    private String name;
    @Getter
    private Long price;
    private String image;

    public Product() {
    }

    public Product(Integer id, String name, Long price, String image) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.image = image;
    }
}
