package com.example.productmanagement.model;

import javax.persistence.*;

@Entity
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private Long price;
    private String describee;
    private String producer;

    public Product() {
    }

    public Product(int id, String name, Long price, String describee, String producer) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.describee = describee;
        this.producer = producer;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public String getDescribee() {
        return describee;
    }

    public void setDescribee(String describe) {
        this.describee = describe;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }
}