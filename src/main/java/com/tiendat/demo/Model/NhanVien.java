package com.tiendat.demo.Model;

import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "NhanVien")
public class NhanVien implements Serializable {

    private static final long serialVersionUID = -4820188549912409813L;

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

    @Type(type="org.hibernate.type.DateType")
    @Column(name = "ngaySinh")
    private Date ngaySinh;

    @Type(type="org.hibernate.type.StringNVarcharType")
    @Column(name = "soDienThoai", length = 255)
    private String soDienThoai;

    @Type(type="org.hibernate.type.StringNVarcharType")
    @Column(name = "eMail", length = 255)
    private String eMail;

    @org.hibernate.annotations.Type(type="true_false")
    @Column(name = "trangThai")
    private boolean trangThai;

    @OneToMany(fetch = FetchType.LAZY,
            cascade = {CascadeType.MERGE,CascadeType.DETACH,CascadeType.REFRESH},
            mappedBy = "nhanVien")
    private Set<TienUngNhanVien> tienUngNhanVienSet = new HashSet<TienUngNhanVien>(0);

    @OneToMany(fetch = FetchType.LAZY,
            cascade = {CascadeType.MERGE,CascadeType.DETACH,CascadeType.REFRESH},
            mappedBy = "nhanVien")
    private Set<TienThuongNV> tienThuongNVSet = new HashSet<TienThuongNV>(0);

    @OneToMany(fetch = FetchType.LAZY,
            cascade = {CascadeType.MERGE,CascadeType.DETACH,CascadeType.REFRESH},
            mappedBy = "nhanVien")
    private Set<PhieuChiLuongNhanVien> phieuChiLuongNhanVienSet = new HashSet<PhieuChiLuongNhanVien>(0);

    public NhanVien() {
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

    public Date getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(Date ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public String getSoDienThoai() {
        return soDienThoai;
    }

    public void setSoDienThoai(String soDienThoai) {
        this.soDienThoai = soDienThoai;
    }

    public String geteMail() {
        return eMail;
    }

    public void seteMail(String eMail) {
        this.eMail = eMail;
    }

    public Set<TienUngNhanVien> getTienUngNhanVienSet() {
        return tienUngNhanVienSet;
    }

    public void setTienUngNhanVienSet(Set<TienUngNhanVien> tienUngNhanVienSet) {
        this.tienUngNhanVienSet = tienUngNhanVienSet;
    }

    public Set<TienThuongNV> getTienThuongNVSet() {
        return tienThuongNVSet;
    }

    public void setTienThuongNVSet(Set<TienThuongNV> tienThuongNVSet) {
        this.tienThuongNVSet = tienThuongNVSet;
    }

    public Set<PhieuChiLuongNhanVien> getPhieuChiLuongNhanVienSet() {
        return phieuChiLuongNhanVienSet;
    }

    public void setPhieuChiLuongNhanVienSet(Set<PhieuChiLuongNhanVien> phieuChiLuongNhanVienSet) {
        this.phieuChiLuongNhanVienSet = phieuChiLuongNhanVienSet;
    }
}
