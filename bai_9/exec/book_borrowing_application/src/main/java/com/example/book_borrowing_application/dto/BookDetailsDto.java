package com.example.book_borrowing_application.dto;

import com.example.book_borrowing_application.model.BookDetails;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class BookDetailsDto {
    private Integer id;
    private LocalDateTime dateTime;
    private String randomCode;
    private String bookName;
    private String userName;

    public BookDetailsDto(BookDetails bookDetails) {
        this.id = bookDetails.getId();
        this.dateTime = bookDetails.getDateTime();
        this.randomCode = bookDetails.getRandomCode();
        this.bookName = bookDetails.getBook().getBookName();
        this.userName = bookDetails.getUser().getNameUser();
    }

    public BookDetailsDto() {
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public void setRandomCode(String randomCode) {
        this.randomCode = randomCode;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

}
