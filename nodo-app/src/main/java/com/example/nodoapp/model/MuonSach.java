package com.example.nodoapp.model;

import javax.persistence.*;
import java.sql.Date;

@Entity(name = "danhvinh_muonsach")
public class MuonSach {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ms_id")
    private Integer id;
    @JoinColumn(name="bd_id")
    @ManyToOne
    private BanDoc bd_id;
    @JoinColumn(name="sach_id")
    @ManyToOne
    private Sach sach_id;
    @Column(name ="so_luong")
    private Integer soLuong;
    @Column(name ="ngay_muon")
    private Date ngayMuon;
    @Column(name ="ngay_tra")
    private Date ngayTra;
    @Column(name ="ms_trang_thai")
    private Integer trangThai;
    @Column(name ="ghichu")
    private String ghichu;

    public MuonSach() {
    }

    public MuonSach(Integer id, BanDoc bd_id, Sach sach_id, Integer soLuong, Date ngayMuon, Date ngayTra, Integer trangThai, String ghichu) {
        this.id = id;
        this.bd_id = bd_id;
        this.sach_id = sach_id;
        this.soLuong = soLuong;
        this.ngayMuon = ngayMuon;
        this.ngayTra = ngayTra;
        this.trangThai = trangThai;
        this.ghichu = ghichu;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public BanDoc getBd_id() {
        return bd_id;
    }

    public void setBd_id(BanDoc bd_id) {
        this.bd_id = bd_id;
    }

    public Sach getSach_id() {
        return sach_id;
    }

    public void setSach_id(Sach sach_id) {
        this.sach_id = sach_id;
    }

    public Integer getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(Integer soLuong) {
        this.soLuong = soLuong;
    }

    public Date getNgayMuon() {
        return ngayMuon;
    }

    public void setNgayMuon(Date ngayMuon) {
        this.ngayMuon = ngayMuon;
    }

    public Date getNgayTra() {
        return ngayTra;
    }

    public void setNgayTra(Date ngayTra) {
        this.ngayTra = ngayTra;
    }

    public Integer getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(Integer trangThai) {
        this.trangThai = trangThai;
    }

    public String getGhichu() {
        return ghichu;
    }

    public void setGhichu(String ghichu) {
        this.ghichu = ghichu;
    }
}
