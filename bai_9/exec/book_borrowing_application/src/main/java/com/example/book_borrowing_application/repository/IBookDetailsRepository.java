package com.example.book_borrowing_application.repository;

import com.example.book_borrowing_application.model.BookDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IBookDetailsRepository extends JpaRepository<BookDetails,Integer> {
}
