package com.example.nodoapp.service.impl;

import com.example.nodoapp.model.MuonSach;
import com.example.nodoapp.repository.MuonSachRepository;
import com.example.nodoapp.service.MuonSachService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MuonSachImpl implements MuonSachService {

    @Autowired
    private MuonSachRepository muonSachRepository;

    @Override
    public List<MuonSach> getAllMuonSach() {
        return muonSachRepository.findAll();
    }

    @Override
    public MuonSach getById(Integer id) {
        return muonSachRepository.findById(id).orElse(null);
    }

    @Override
    public MuonSach create(MuonSach muonSach) {
        return muonSachRepository.save(muonSach);
    }

    @Override
    public MuonSach update(MuonSach muonSach) {
        return muonSachRepository.save(muonSach);
    }

    @Override
    public void delete(Integer id) {
        muonSachRepository.deleteById(id);
    }
}
