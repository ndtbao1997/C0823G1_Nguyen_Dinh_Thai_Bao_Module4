package com.example.registerformuser.service;

import com.example.registerformuser.model.Use;

import java.util.Optional;

public interface IUseService {
    void save(Use use);
    Iterable<Use> findAll();

    Optional<Use> findByEmail(String value);
}
