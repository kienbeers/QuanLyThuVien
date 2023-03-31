package com.example.nodoapp.service.impl;

import com.example.nodoapp.model.Sach;
import com.example.nodoapp.repository.SachRepository;
import com.example.nodoapp.service.SachService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SachImpl implements SachService {
    @Autowired
    private SachRepository sachRepository;
    @Override
    public List<Sach> getAllSach() {
        return sachRepository.findAll();
    }

    @Override
    public Sach getById(Integer id) {
        return sachRepository.findById(id).orElse(null);
    }

    @Override
    public Sach create(Sach sach) {
        return sachRepository.save(sach) ;
    }

    @Override
    public Sach update(Sach sach) {
        return sachRepository.save(sach);
    }

    @Override
    public void delete(Integer id) {
        sachRepository.deleteById(id);
    }
}
