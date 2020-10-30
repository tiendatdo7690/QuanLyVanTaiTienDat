package com.tiendat.demo.Model;

import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "ChuHang")
public class ChuHang implements Serializable {

    private static final long serialVersionUID = -9197640742574712253L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Long id;

    @Type(type="org.hibernate.type.StringNVarcharType")
    @Column(name = "ten", length = 255)
    private String ten;

    @Type(type="org.hibernate.type.StringNVarcharType")
    @Column(name = "diaChi", length = 255)
    private String diaChi;

    @Type(type="org.hibernate.type.StringNVarcharType")
    @Column(name = "maSoThue", length = 255)
    private String maSoThue;

    @org.hibernate.annotations.Type(type="true_false")
    @Column(name = "trangThai")
    private boolean trangThai;

    @OneToMany(fetch = FetchType.LAZY,
            cascade = {CascadeType.MERGE,CascadeType.DETACH,CascadeType.REFRESH},
            mappedBy = "chuHang")
    private Set<ChuyenHang> chuyenHangSet = new HashSet<ChuyenHang>(0);

    @OneToMany(fetch = FetchType.LAZY,
            cascade = {CascadeType.MERGE,CascadeType.DETACH,CascadeType.REFRESH},
            mappedBy = "chuHang")
    private Set<CongNoBanHang> congNoBanHangSet = new HashSet<CongNoBanHang>(0);

    public ChuHang() {
    }

    public boolean isTrangThai() {
        return trangThai;
    }

    public void setTrangThai(boolean trangThai) {
        this.trangThai = trangThai;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getMaSoThue() {
        return maSoThue;
    }

    public void setMaSoThue(String maSoThue) {
        this.maSoThue = maSoThue;
    }

    public Set<ChuyenHang> getChuyenHangSet() {
        return chuyenHangSet;
    }

    public void setChuyenHangSet(Set<ChuyenHang> chuyenHangSet) {
        this.chuyenHangSet = chuyenHangSet;
    }

    public Set<CongNoBanHang> getCongNoBanHangSet() {
        return congNoBanHangSet;
    }

    public void setCongNoBanHangSet(Set<CongNoBanHang> congNoBanHangSet) {
        this.congNoBanHangSet = congNoBanHangSet;
    }
}
