package com.example.nodoapp.service;

import com.example.nodoapp.model.TacGia;

import java.util.List;

public interface TacGiaService {
    public List<TacGia> getAllTacGia();
    public TacGia getById(Integer id);
    public TacGia create(TacGia tacGia);
    public TacGia update(TacGia tacGia);
    public void delete(Integer id);

}
