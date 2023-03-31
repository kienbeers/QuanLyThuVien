package com.example.nodoapp.service;

import com.example.nodoapp.model.NhaXuatBan;

import java.util.List;

public interface NhaXuatBanService {

    public List<NhaXuatBan> getAllNhaXuatBan();
    public NhaXuatBan getById(Integer id);
    public NhaXuatBan create(NhaXuatBan nhaXuatBan);
    public NhaXuatBan update(NhaXuatBan nhaXuatBan);
    public void delete(Integer id);

}
