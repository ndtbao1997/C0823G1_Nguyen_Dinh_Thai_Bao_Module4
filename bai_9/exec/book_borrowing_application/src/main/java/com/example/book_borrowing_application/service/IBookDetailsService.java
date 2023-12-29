package com.example.book_borrowing_application.service;

import com.example.book_borrowing_application.dto.BookDetailsDto;
import com.example.book_borrowing_application.dto.IBookDetailsDto;
import com.example.book_borrowing_application.model.BookDetails;

import java.util.List;

public interface IBookDetailsService extends IGenerateService<BookDetails> {
    List<BookDetailsDto> getAll();

    boolean checkRandomCode(Integer idPay, String randomCode);

    List<IBookDetailsDto> getListBookDetailsDto();
}
