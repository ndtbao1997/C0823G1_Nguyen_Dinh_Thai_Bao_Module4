package com.example.book_borrowing_application.repository;

import com.example.book_borrowing_application.dto.BookDetailsDto;
import com.example.book_borrowing_application.dto.IBookDetailsDto;
import com.example.book_borrowing_application.model.BookDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IBookDetailsRepository extends JpaRepository<BookDetails, Integer> {
    @Query(value = "select book_details.id as id, book_details.date_time as dateTime,book_details.random_code as randomCode, book.book_name as bookName , user.name_user as nameUser from book_details\n" +
            "join book on book.id = book_details.book_id\n" +
            "join user on user.id = book_details.user_id;", nativeQuery = true)
    List<IBookDetailsDto> getListBookDetailsDto();
}
