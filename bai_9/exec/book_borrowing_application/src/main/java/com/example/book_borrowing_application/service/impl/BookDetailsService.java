package com.example.book_borrowing_application.service.impl;

import com.example.book_borrowing_application.model.BookDetails;
import com.example.book_borrowing_application.repository.IBookDetailsRepository;
import com.example.book_borrowing_application.service.IBookDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BookDetailsService implements IBookDetailsService {
    @Autowired
    private IBookDetailsRepository iBookDetailsRepository;

    @Override
    public Iterable<BookDetails> findAll() {
        return iBookDetailsRepository.findAll();
    }

    @Override
    public void save(BookDetails bookDetails) {
        iBookDetailsRepository.save(bookDetails);
    }

    @Override
    public Optional<BookDetails> findById(Integer id) {
        return iBookDetailsRepository.findById(id);
    }

    @Override
    public void remove(Integer id) {
        iBookDetailsRepository.deleteById(id);
    }
}
