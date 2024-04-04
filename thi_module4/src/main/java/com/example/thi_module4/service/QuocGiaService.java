package com.example.thi_module4.service;

import com.example.thi_module4.model.QuocGia;
import com.example.thi_module4.repository.IQuocGiaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QuocGiaService implements IQuocGiaService{
    @Autowired
    private IQuocGiaRepository iQuocGiaRepository;
    @Override
    public Iterable<QuocGia> findAll() {
        return iQuocGiaRepository.findAll();
    }
}
