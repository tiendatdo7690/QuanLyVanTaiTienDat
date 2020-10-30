package com.tiendat.demo.Model;

import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;

@Entity
@Table(name = "TienTaiXe")
public class TienTaiXe implements Serializable {

    private static final long serialVersionUID = 2953403900553953351L;

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
    @JoinColumn(name = "chuyenHang_id" , foreignKey= @ForeignKey(name = "Fk_chuyenHang_TienTaiXe"), nullable = true)
    private ChuyenHang chuyenHang;

    public TienTaiXe() {
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

    public ChuyenHang getChuyenHang() {
        return chuyenHang;
    }

    public void setChuyenHang(ChuyenHang chuyenHang) {
        this.chuyenHang = chuyenHang;
    }
}
