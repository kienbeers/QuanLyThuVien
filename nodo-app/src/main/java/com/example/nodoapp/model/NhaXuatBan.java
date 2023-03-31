package com.example.nodoapp.model;

import javax.persistence.*;

@Entity(name = "danhvinh_nhasanxuat")
public class NhaXuatBan {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "nsx_id")
    private Integer id;
    @Column(name = "nxb_ma")
    private Integer ma;
    @Column(name = "nxb_ten")
    private String ten;
    @Column(name="trangThai")
    private Integer trangThai;
    @Column(name="nxb_diachi")
    private String diaChi;
    @Column(name="nxb_mota")
    private String moTa;

    public NhaXuatBan() {
    }

    public NhaXuatBan(Integer ma, String ten, Integer trangThai, String diaChi, String moTa) {
        this.ma = ma;
        this.ten = ten;
        this.trangThai = trangThai;
        this.diaChi = diaChi;
        this.moTa = moTa;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getMa() {
        return ma;
    }

    public void setMa(Integer ma) {
        this.ma = ma;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public Integer getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(Integer trangThai) {
        this.trangThai = trangThai;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }
}
