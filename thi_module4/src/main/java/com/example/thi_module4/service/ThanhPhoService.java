package com.example.thi_module4.service;

import com.example.thi_module4.dto.IThanhPhoDTO;
import com.example.thi_module4.model.ThanhPho;
import com.example.thi_module4.repository.IThanhPhoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ThanhPhoService implements IThanhPhoService{
    @Autowired
    private IThanhPhoRepository iThanhPhoRepository;
    @Override
    public Iterable<IThanhPhoDTO> getListThanhPhoDTO() {
        return iThanhPhoRepository.getListThanhPhoDTO();
    }

    @Override
    public void save(ThanhPho thanhPho) {
        iThanhPhoRepository.save(thanhPho);
    }

    @Override
    public Optional<ThanhPho> findById(Integer id) {
        return iThanhPhoRepository.findById(id);
    }

    @Override
    public void deleteById(Integer idDelete) {
        iThanhPhoRepository.deleteById(idDelete);
    }
}
