package com.example.book_borrowing_application.model;

import jakarta.persistence.*;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Entity
@Table(name = "book_details")
public class BookDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private LocalDateTime dateTime;

    @Getter
    private String randomCode;

    @ManyToOne
    @JoinColumn(name = "book_id",referencedColumnName = "id")
    private Book book;

    @ManyToOne
    @JoinColumn(name = "user_id",referencedColumnName = "id")
    private User user;

    public BookDetails(Integer id, LocalDateTime dateTime, String randomCode, Book book, User user) {
        this.id = id;
        this.dateTime = dateTime;
        this.randomCode = randomCode;
        this.book = book;
        this.user = user;
    }

    public BookDetails() {
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setRandomCode(String randomCode) {
        this.randomCode = randomCode;
    }
}
