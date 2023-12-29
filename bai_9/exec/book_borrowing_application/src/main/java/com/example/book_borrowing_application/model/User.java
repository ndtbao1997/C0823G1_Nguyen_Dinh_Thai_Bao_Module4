package com.example.book_borrowing_application.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;

import java.util.List;

@Getter
@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nameUser;

    private String phoneNumber;

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

    public void setId(Integer id) {
        this.id = id;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setNameUser(String nameUser) {
        this.nameUser = nameUser;
    }

    public void setBookDetailsList(List<BookDetails> bookDetailsList) {
        this.bookDetailsList = bookDetailsList;
    }
}
