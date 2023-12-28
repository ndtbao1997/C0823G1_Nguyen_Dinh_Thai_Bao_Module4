package com.example.registerformuser.service;

import com.example.registerformuser.model.Use;
import com.example.registerformuser.repository.IUseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UseService implements IUseService{
    @Autowired
    private IUseRepository iUseRepository;

    @Override
    public void save(Use use) {
        iUseRepository.save(use);
    }

    @Override
    public Iterable<Use> findAll() {
        return iUseRepository.findAll();
    }

    @Override
    public Optional<Use> findByEmail(String value) {
        return iUseRepository.findByEmail(value);
    }
}
