package com.example.book_borrowing_application.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "book")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer quantity;
    private String bookName;

    @OneToMany(mappedBy = "book")
    private List<BookDetails> bookDetailsList;

    public Book(Integer id, Integer quantity, String bookName, List<BookDetails> bookDetailsList) {
        this.id = id;
        this.quantity = quantity;
        this.bookName = bookName;
        this.bookDetailsList = bookDetailsList;
    }

    public Book() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public List<BookDetails> getBookDetailsList() {
        return bookDetailsList;
    }

    public void setBookDetailsList(List<BookDetails> bookDetailsList) {
        this.bookDetailsList = bookDetailsList;
    }
}
