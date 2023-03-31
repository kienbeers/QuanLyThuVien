package com.example.nodoapp.service;

import com.example.nodoapp.model.BanDoc;

import java.util.List;

public interface BanDocService {
    public List<BanDoc> getAllBanDoc();
    public BanDoc getById(Integer id);
    public BanDoc create(BanDoc banDoc);
    public BanDoc update(BanDoc banDoc);
    public void delete(Integer id);
}
