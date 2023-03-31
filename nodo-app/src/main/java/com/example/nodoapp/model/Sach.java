package com.example.nodoapp.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.sql.Date;

@Entity(name = "danhvinh_sach")
public class Sach {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "sach_id")
    private Integer id;
    @Column(name = "sach_ma")
    private Integer ma;
    @Column(name = "sach_ten")
    private String ten;
    @Column(name = "sach_chude")
    private String chuDe;
    @Column(name = "sach_mota")
    private String moTa;
    @Column(name = "namxuatban")
    private Date namXuatBan;
    @Column(name = "so_luong_con")
    private Integer soLuongCon;
    @Column(name = "so_luong_muon")
    private Integer soLuongDaMuon;
    @Column(name="tong_so_luong")
    private Integer tongSoLuong;
    @JoinColumn(name = "nsx_id")
    @ManyToOne
    private NhaXuatBan nxbId;
    @JoinColumn(name = "tg_id")
    @ManyToOne
    private TacGia tgId;

    public Sach() {
    }

    public Sach(Integer ma, String ten, String chuDe, String moTa, Date namXuatBan, Integer soLuongCon, Integer soLuongDaMuon, Integer tongSoLuong, NhaXuatBan nxbId, TacGia tgId) {
        this.ma = ma;
        this.ten = ten;
        this.chuDe = chuDe;
        this.moTa = moTa;
        this.namXuatBan = namXuatBan;
        this.soLuongCon = soLuongCon;
        this.soLuongDaMuon = soLuongDaMuon;
        this.tongSoLuong = tongSoLuong;
        this.nxbId = nxbId;
        this.tgId = tgId;
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

    public String getChuDe() {
        return chuDe;
    }

    public void setChuDe(String chuDe) {
        this.chuDe = chuDe;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public Date getNamXuatBan() {
        return namXuatBan;
    }

    public void setNamXuatBan(Date namXuatBan) {
        this.namXuatBan = namXuatBan;
    }

    public Integer getSoLuongCon() {
        return soLuongCon;
    }

    public void setSoLuongCon(Integer soLuongCon) {
        this.soLuongCon = soLuongCon;
    }

    public Integer getSoLuongDaMuon() {
        return soLuongDaMuon;
    }

    public void setSoLuongDaMuon(Integer soLuongDaMuon) {
        this.soLuongDaMuon = soLuongDaMuon;
    }

    public Integer getTongSoLuong() {
        return tongSoLuong;
    }

    public void setTongSoLuong(Integer tongSoLuong) {
        this.tongSoLuong = tongSoLuong;
    }

    public NhaXuatBan getNxbId() {
        return nxbId;
    }

    public void setNxbId(NhaXuatBan nxbId) {
        this.nxbId = nxbId;
    }

    public TacGia getTgId() {
        return tgId;
    }

    public void setTgId(TacGia tgId) {
        this.tgId = tgId;
    }
}
