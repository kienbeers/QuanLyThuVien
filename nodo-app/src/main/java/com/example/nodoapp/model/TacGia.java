package com.example.nodoapp.model;

import javax.persistence.*;

@Entity(name = "danhvinh_tacgia")
public class TacGia {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "tg_id")
    private Integer id;
    @Column(name = "tg_ma")
    private Integer ma;
    @Column(name = "tg_ten")
    private String ten;
    @Column(name="tg_sdt")
    private String sdt;
    @Column(name="tg_diachi")
    private String diaChi;
    @Column(name="tg_mota")
    private String moTa;

public TacGia() {
    }

    public TacGia(Integer ma, String ten, String sdt, String diaChi, String moTa) {
        this.ma = ma;
        this.ten = ten;
        this.sdt = sdt;
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

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
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
