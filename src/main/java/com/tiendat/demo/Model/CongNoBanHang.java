package com.tiendat.demo.Model;

import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "CongNoBanHang")
public class CongNoBanHang implements Serializable {


    private static final long serialVersionUID = 4883324969515696636L;

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
    @JoinColumn(name = "chuHang_id" , foreignKey= @ForeignKey(name = "Fk_ChiHo_CongNoBanHang"), nullable = true)
    private ChuHang chuHang;

    @OneToMany(fetch = FetchType.LAZY,
            cascade = {CascadeType.MERGE,CascadeType.DETACH,CascadeType.REFRESH},
            mappedBy = "congNoBanHang")
    private Set<PhieuThuCongNoBanHang> phieuThuCongNoBanHangSet = new HashSet<PhieuThuCongNoBanHang>(0);

    public CongNoBanHang() {
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

    public ChuHang getChuHang() {
        return chuHang;
    }

    public void setChuHang(ChuHang chuHang) {
        this.chuHang = chuHang;
    }

    public Set<PhieuThuCongNoBanHang> getPhieuThuCongNoBanHangSet() {
        return phieuThuCongNoBanHangSet;
    }

    public void setPhieuThuCongNoBanHangSet(Set<PhieuThuCongNoBanHang> phieuThuCongNoBanHangSet) {
        this.phieuThuCongNoBanHangSet = phieuThuCongNoBanHangSet;
    }
}
