package com.example.nodoapp.service.impl;

import com.example.nodoapp.model.TacGia;
import com.example.nodoapp.repository.TacGiaRepository;
import com.example.nodoapp.service.TacGiaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TacGiaImpl implements TacGiaService {
    @Autowired
    private TacGiaRepository tacGiaRepository;
    @Override
    public List<TacGia> getAllTacGia() {
        return tacGiaRepository.findAll();
    }

    @Override
    public TacGia getById(Integer id) {
        return tacGiaRepository.findById(id).orElse(null);
    }

    @Override
    public TacGia create(TacGia tacGia) {
        return tacGiaRepository.save(tacGia) ;
    }

    @Override
    public TacGia update(TacGia tacGia) {
        return tacGiaRepository.save(tacGia);
    }

    @Override
    public void delete(Integer id) {
        tacGiaRepository.deleteById(id);
    }
}
