package com.example.nodoapp.service;

import com.example.nodoapp.model.MuonSach;

import java.util.List;

public interface MuonSachService {

    public List<MuonSach> getAllMuonSach();
    public MuonSach getById(Integer id);
    public MuonSach create(MuonSach muonSach);
    public MuonSach update(MuonSach muonSach);
    public void delete(Integer id);
}
