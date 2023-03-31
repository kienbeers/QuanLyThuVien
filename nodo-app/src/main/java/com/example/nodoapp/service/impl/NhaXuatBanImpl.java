package com.example.nodoapp.service.impl;

import com.example.nodoapp.model.NhaXuatBan;
import com.example.nodoapp.repository.NhaXuatBanRepository;
import com.example.nodoapp.service.NhaXuatBanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NhaXuatBanImpl implements NhaXuatBanService {
    @Autowired
    private NhaXuatBanRepository nhaXuatBanRepository;
    @Override
    public List<NhaXuatBan> getAllNhaXuatBan() {
        return nhaXuatBanRepository.findAll();
    }

    @Override
    public NhaXuatBan getById(Integer id) {
        return nhaXuatBanRepository.findById(id).orElse(null);
    }

    @Override
    public NhaXuatBan create(NhaXuatBan nhaXuatBan) {
        return nhaXuatBanRepository.save(nhaXuatBan) ;
    }

    @Override
    public NhaXuatBan update(NhaXuatBan nhaXuatBan) {
        return nhaXuatBanRepository.save(nhaXuatBan);
    }

    @Override
    public void delete(Integer id) {
        nhaXuatBanRepository.deleteById(id);
    }
}
