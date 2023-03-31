package com.example.nodoapp.service.impl;

import com.example.nodoapp.model.BanDoc;
import com.example.nodoapp.repository.BanDocRepository;
import com.example.nodoapp.service.BanDocService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BanDocImpl implements BanDocService {
    @Autowired
    private BanDocRepository banDocRepository;

    @Override
    public List<BanDoc> getAllBanDoc() {
        return banDocRepository.findAll();
    }

    @Override
    public BanDoc getById(Integer id) {
        return banDocRepository.findById(id).orElse(null);
    }

    @Override
    public BanDoc create(BanDoc banDoc) {
        return banDocRepository.save(banDoc);
    }

    @Override
    public BanDoc update(BanDoc banDoc) {
        return banDocRepository.save(banDoc);
    }

    @Override
    public void delete(Integer id) {
        banDocRepository.deleteById(id);
    }
}
