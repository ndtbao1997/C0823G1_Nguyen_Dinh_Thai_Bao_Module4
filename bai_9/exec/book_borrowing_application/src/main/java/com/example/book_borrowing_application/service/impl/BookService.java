package com.example.book_borrowing_application.service.impl;

import com.example.book_borrowing_application.model.Book;
import com.example.book_borrowing_application.repository.IBookRepository;
import com.example.book_borrowing_application.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BookService implements IBookService {
    @Autowired
    private IBookRepository iBookRepository;

    @Override
    public Iterable<Book> findAll() {
        return iBookRepository.findAll();
    }

    @Override
    public void save(Book book) {
        iBookRepository.save(book);
    }

    @Override
    public Optional<Book> findById(Integer id) {
        return iBookRepository.findById(id);
    }

    @Override
    public void remove(Integer id) {
        iBookRepository.deleteById(id);
    }
}
