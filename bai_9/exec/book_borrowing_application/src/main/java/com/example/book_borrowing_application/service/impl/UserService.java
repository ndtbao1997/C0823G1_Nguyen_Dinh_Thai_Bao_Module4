package com.example.book_borrowing_application.service.impl;

import com.example.book_borrowing_application.model.User;
import com.example.book_borrowing_application.repository.IUserRepository;
import com.example.book_borrowing_application.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService implements IUserService {
    @Autowired
    private IUserRepository iUserRepository;


    @Override
    public Iterable<User> findAll() {
        return iUserRepository.findAll();
    }

    @Override
    public void save(User user) {
        iUserRepository.save(user);
    }

    @Override
    public Optional<User> findById(Integer id) {
        return iUserRepository.findById(id);
    }

    @Override
    public void remove(Integer id) {
        iUserRepository.deleteById(id);
    }
}
