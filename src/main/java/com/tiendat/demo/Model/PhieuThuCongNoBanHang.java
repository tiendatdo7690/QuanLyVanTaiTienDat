package com.tiendat.demo.Model;

import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;

@Entity
@Table(name = "PhieuThuCongNoBanHang")
public class PhieuThuCongNoBanHang implements Serializable {

    private static final long serialVersionUID = 8275136112771027045L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Long id;

    @Column(name = "tien")
    private Long tien;

    @Type(type="org.hibernate.type.DateType")
    @Column(name = "ngay")
    private Date ngay;

    @ManyToOne(fetch = FetchType.LAZY,
            cascade = {CascadeType.MERGE,CascadeType.DETACH,CascadeType.REFRESH})
    @JoinColumn(name = "congNoBanHang_id" , foreignKey= @ForeignKey(name = "Fk_congNoBanHang_PhieuThuCongNoBanHang"), nullable = true)
    private CongNoBanHang congNoBanHang;

    public PhieuThuCongNoBanHang() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getTien() {
        return tien;
    }

    public void setTien(Long tien) {
        this.tien = tien;
    }

    public Date getNgay() {
        return ngay;
    }

    public void setNgay(Date ngay) {
        this.ngay = ngay;
    }

    public CongNoBanHang getCongNoBanHang() {
        return congNoBanHang;
    }

    public void setCongNoBanHang(CongNoBanHang congNoBanHang) {
        this.congNoBanHang = congNoBanHang;
    }
}
