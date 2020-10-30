package com.tiendat.demo.Model;

import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "CongNoMuaHang")
public class CongNoMuaHang implements Serializable {


    private static final long serialVersionUID = -5617982892314899605L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Long id;

    @Type(type="org.hibernate.type.StringNVarcharType")
    @Column(name = "ten", length = 255)
    private String ten;

    @Column(name = "tien")
    private Long tien;

    @Type(type="org.hibernate.type.DateType")
    @Column(name = "ngayBatDau")
    private Date ngayBatDau;

    @Type(type="org.hibernate.type.DateType")
    @Column(name = "ngayKetThuc")
    private Date ngayKetThuc;

    @ManyToOne(fetch = FetchType.LAZY,
            cascade = {CascadeType.MERGE,CascadeType.DETACH,CascadeType.REFRESH})
    @JoinColumn(name = "congTyBanHang_id" , foreignKey= @ForeignKey(name = "Fk_congTyBanHang_CongNoMuaHang"), nullable = true)
    private CongTyBanHang congTyBanHang;

    @OneToMany(fetch = FetchType.LAZY,
            cascade = {CascadeType.MERGE,CascadeType.DETACH,CascadeType.REFRESH},
            mappedBy = "congNoMuaHang")
    private Set<PhieuChiCongNoMuaHang> phieuChiCongNoMuaHangSet = new HashSet<PhieuChiCongNoMuaHang>(0);

    public CongNoMuaHang() {
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

    public Long getTien() {
        return tien;
    }

    public void setTien(Long tien) {
        this.tien = tien;
    }

    public Date getNgayBatDau() {
        return ngayBatDau;
    }

    public void setNgayBatDau(Date ngayBatDau) {
        this.ngayBatDau = ngayBatDau;
    }

    public Date getNgayKetThuc() {
        return ngayKetThuc;
    }

    public void setNgayKetThuc(Date ngayKetThuc) {
        this.ngayKetThuc = ngayKetThuc;
    }

    public CongTyBanHang getCongTyBanHang() {
        return congTyBanHang;
    }

    public void setCongTyBanHang(CongTyBanHang congTyBanHang) {
        this.congTyBanHang = congTyBanHang;
    }

    public Set<PhieuChiCongNoMuaHang> getPhieuChiCongNoMuaHangSet() {
        return phieuChiCongNoMuaHangSet;
    }

    public void setPhieuChiCongNoMuaHangSet(Set<PhieuChiCongNoMuaHang> phieuChiCongNoMuaHangSet) {
        this.phieuChiCongNoMuaHangSet = phieuChiCongNoMuaHangSet;
    }
}
