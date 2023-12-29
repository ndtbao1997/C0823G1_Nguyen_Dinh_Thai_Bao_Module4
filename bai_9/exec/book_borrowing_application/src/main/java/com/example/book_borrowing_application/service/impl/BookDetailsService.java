package com.example.book_borrowing_application.service.impl;

import com.example.book_borrowing_application.dto.BookDetailsDto;
import com.example.book_borrowing_application.dto.IBookDetailsDto;
import com.example.book_borrowing_application.model.BookDetails;
import com.example.book_borrowing_application.repository.IBookDetailsRepository;
import com.example.book_borrowing_application.service.IBookDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
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

    @Override
    public List<BookDetailsDto> getAll(){
        List<BookDetails> bookDetails = (List<BookDetails>) findAll();
        List<BookDetailsDto> bookDetailsDtos = new ArrayList<>();
        for (BookDetails b: bookDetails){
            bookDetailsDtos.add(new BookDetailsDto(b));
        }
        return bookDetailsDtos;
    }

    @Override
    public boolean checkRandomCode(Integer idPay, String randomCode) {
        Optional<BookDetails> bookDetails = iBookDetailsRepository.findById(idPay);
        return bookDetails.filter(details -> Objects.equals(details.getRandomCode(), randomCode)).isPresent();
    }

    @Override
    public List<IBookDetailsDto> getListBookDetailsDto() {
        return iBookDetailsRepository.getListBookDetailsDto();
    }
}
