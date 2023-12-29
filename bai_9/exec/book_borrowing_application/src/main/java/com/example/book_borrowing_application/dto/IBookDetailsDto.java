package com.example.book_borrowing_application.dto;

import java.time.LocalDateTime;

public interface IBookDetailsDto {
    Integer getId();
    LocalDateTime getDateTime();
    String getRandomCode();
    String getBookName();
    String getNameUser();
}
