package com.example.book_borrowing_application.repository;

import com.example.book_borrowing_application.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IBookRepository extends JpaRepository<Book,Integer> {
}
