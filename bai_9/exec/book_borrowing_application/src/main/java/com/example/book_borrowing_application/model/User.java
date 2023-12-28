package com.example.book_borrowing_application.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String phoneNumber;
    private String nameUser;

    @OneToMany(mappedBy = "user")
    private List<BookDetails> bookDetailsList;

    public User(Integer id, String phoneNumber, String nameUser, List<BookDetails> bookDetailsList) {
        this.id = id;
        this.phoneNumber = phoneNumber;
        this.nameUser = nameUser;
        this.bookDetailsList = bookDetailsList;
    }

    public User() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getNameUser() {
        return nameUser;
    }

    public void setNameUser(String nameUser) {
        this.nameUser = nameUser;
    }

    public List<BookDetails> getBookDetailsList() {
        return bookDetailsList;
    }

    public void setBookDetailsList(List<BookDetails> bookDetailsList) {
        this.bookDetailsList = bookDetailsList;
    }
}
