package com.example.nodoapp.model;

import javax.persistence.*;
import java.sql.Date;

@Entity(name = "danhvinh_bandoc")
public class BanDoc {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "bd_id")
    private Integer id;
    @Column(name = "bd_ma")
    private Integer ma;
    @Column(name = "bd_ten")
    private String ten;
    @Column(name="bd_diachi")
    private String diaChi;
    @Column(name="bd_sdt")
    private String sdt;
    @Column(name="ngay_sinh")
    private Date ngaySinh;
    @Column(name="ngay_tao")
    private Date ngayTao;
    @Column(name="hang")
    private Integer hang;

    public BanDoc() {
    }

    public BanDoc(Integer ma, String ten, String diaChi, String sdt, Date ngaySinh, Date ngayTao, Integer hang) {
        this.ma = ma;
        this.ten = ten;
        this.diaChi = diaChi;
        this.sdt = sdt;
        this.ngaySinh = ngaySinh;
        this.ngayTao = ngayTao;
        this.hang = hang;
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

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public Date getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(Date ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public Date getNgayTao() {
        return ngayTao;
    }

    public void setNgayTao(Date ngayTao) {
        this.ngayTao = ngayTao;
    }

    public Integer getHang() {
        return hang;
    }

    public void setHang(Integer hang) {
        this.hang = hang;
    }
}
