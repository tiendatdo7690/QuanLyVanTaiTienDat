package com.tiendat.demo.Model;

import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "CongTyBanHang")
public class CongTyBanHang implements Serializable {


    private static final long serialVersionUID = -2374528884240853017L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Long id;

    @Type(type="org.hibernate.type.StringNVarcharType")
    @Column(name = "ten", length = 255)
    private String ten;

    @Type(type="org.hibernate.type.StringNVarcharType")
    @Column(name = "loaiCty", length = 255)
    private String loaiCty;

    @Type(type="org.hibernate.type.StringNVarcharType")
    @Column(name = "soDienThoai", length = 255)
    private String soDienThoai;

    @Type(type="org.hibernate.type.StringNVarcharType")
    @Column(name = "diaChi", length = 255)
    private String diaChi;

    @org.hibernate.annotations.Type(type="true_false")
    @Column(name = "trangThai")
    private boolean trangThai;

    @OneToMany(fetch = FetchType.LAZY,
            cascade = {CascadeType.MERGE,CascadeType.DETACH,CascadeType.REFRESH},
            mappedBy = "congTyBanHang")
    private Set<CongNoMuaHang> congNoMuaHangSet = new HashSet<CongNoMuaHang>(0);

    public CongTyBanHang() {
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

    public String getLoaiCty() {
        return loaiCty;
    }

    public void setLoaiCty(String loaiCty) {
        this.loaiCty = loaiCty;
    }

    public String getSoDienThoai() {
        return soDienThoai;
    }

    public void setSoDienThoai(String soDienThoai) {
        this.soDienThoai = soDienThoai;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public boolean isTrangThai() {
        return trangThai;
    }

    public void setTrangThai(boolean trangThai) {
        this.trangThai = trangThai;
    }

    public Set<CongNoMuaHang> getCongNoMuaHangSet() {
        return congNoMuaHangSet;
    }

    public void setCongNoMuaHangSet(Set<CongNoMuaHang> congNoMuaHangSet) {
        this.congNoMuaHangSet = congNoMuaHangSet;
    }
}
