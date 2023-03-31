package com.example.nodoapp.service;

import com.example.nodoapp.model.Sach;

import java.util.List;

public interface SachService {
    public List<Sach> getAllSach();
    public Sach getById(Integer id);
    public Sach create(Sach sach);
    public Sach update(Sach sach);
    public void delete(Integer id);

}
