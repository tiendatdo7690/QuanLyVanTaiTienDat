package com.tiendat.demo.Model;

import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;

@Entity
@Table(name = "HoaDonVao")
public class HoaDonVao implements Serializable {


    private static final long serialVersionUID = -7705313648190108883L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Long id;

    @Type(type="org.hibernate.type.StringNVarcharType")
    @Column(name = "soHoaDon", length = 255)
    private String soHoaDon;

    @Type(type="org.hibernate.type.DateType")
    @Column(name = "ngay")
    private Date ngay;

    @Column(name = "tien")
    private Long tien;

    @ManyToOne(fetch = FetchType.LAZY,
            cascade = {CascadeType.MERGE,CascadeType.DETACH,CascadeType.REFRESH})
    @JoinColumn(name = "congTyBanHang_id" , foreignKey= @ForeignKey(name = "Fk_congTyBanHang_HoaDonVao"), nullable = true)
    private CongTyBanHang congTyBanHang;

    public HoaDonVao() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSoHoaDon() {
        return soHoaDon;
    }

    public void setSoHoaDon(String soHoaDon) {
        this.soHoaDon = soHoaDon;
    }

    public Date getNgay() {
        return ngay;
    }

    public void setNgay(Date ngay) {
        this.ngay = ngay;
    }

    public Long getTien() {
        return tien;
    }

    public void setTien(Long tien) {
        this.tien = tien;
    }

    public CongTyBanHang getCongTyBanHang() {
        return congTyBanHang;
    }

    public void setCongTyBanHang(CongTyBanHang congTyBanHang) {
        this.congTyBanHang = congTyBanHang;
    }
}
