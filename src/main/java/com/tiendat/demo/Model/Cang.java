package com.tiendat.demo.Model;

import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;


@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="Loai_Cang",
        discriminatorType = DiscriminatorType.STRING)
public abstract class Cang implements Serializable {

    private static final long serialVersionUID = -7217264131535951505L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    protected Long id;

    @Type(type="org.hibernate.type.StringNVarcharType")
    @Column(name = "ten", length = 255)
    protected String ten;

    @Type(type="org.hibernate.type.StringNVarcharType")
    @Column(name = "dia_Chi", length = 255)
    protected String diaChi;

    @Type(type="org.hibernate.type.StringNVarcharType")
    @Column(name = "so_Dien_Thoai", length = 255)
    protected String soDienThoai;

    @Type(type="org.hibernate.type.StringNVarcharType")
    @Column(name = "e_Mail", length = 255)
    protected String email;

    @org.hibernate.annotations.Type(type="true_false")
    @Column(name = "trang_Thai")
    protected boolean trangThai;



    public Cang() {
    }

    public Cang(Long id, String ten, String diaChi, String soDienThoai, String eMail, boolean trangThai) {
        this.id = id;
        this.ten = ten;
        this.diaChi = diaChi;
        this.soDienThoai = soDienThoai;
        this.email = eMail;
        this.trangThai = trangThai;
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

    public String getSoDienThoai() {
        return soDienThoai;
    }

    public void setSoDienThoai(String soDienThoai) {
        this.soDienThoai = soDienThoai;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public abstract String getLoaiCang();

    @Override
    public String toString() {
        return ten;
    }
}
