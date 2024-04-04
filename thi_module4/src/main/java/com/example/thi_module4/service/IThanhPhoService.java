package com.example.thi_module4.service;

import com.example.thi_module4.dto.IThanhPhoDTO;
import com.example.thi_module4.model.ThanhPho;

import java.util.Optional;

public interface IThanhPhoService {
    Iterable<IThanhPhoDTO> getListThanhPhoDTO();

    void save(ThanhPho thanhPho);

    Optional<ThanhPho> findById(Integer id);

    void deleteById(Integer idDelete);
}
