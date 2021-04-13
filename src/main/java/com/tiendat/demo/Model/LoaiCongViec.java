package com.tiendat.demo.Model;

import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "LoaiCongViec")
public class LoaiCongViec implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Long id;

    @Type(type="org.hibernate.type.StringNVarcharType")
    @Column(name = "ten", length = 255)
    private String ten;

    @org.hibernate.annotations.Type(type="true_false")
    @Column(name = "nguyenChuyenHang")
    private boolean nguyenChuyenHang;

    @OneToMany(fetch = FetchType.LAZY,
            cascade = {CascadeType.MERGE,CascadeType.DETACH,CascadeType.REFRESH},
            mappedBy = "loaiCongViec")
    private Set<LoaiCongViec_ChuyenHang> loaiCongViec_chuyenHangSet = new HashSet<LoaiCongViec_ChuyenHang>(0);

    public LoaiCongViec() {
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

    public Set<LoaiCongViec_ChuyenHang> getLoaiCongViec_chuyenHangSet() {
        return loaiCongViec_chuyenHangSet;
    }

    public void setLoaiCongViec_chuyenHangSet(Set<LoaiCongViec_ChuyenHang> loaiCongViec_chuyenHangSet) {
        this.loaiCongViec_chuyenHangSet = loaiCongViec_chuyenHangSet;
    }

    public boolean isNguyenChuyenHang() {
        return nguyenChuyenHang;
    }

    public void setNguyenChuyenHang(boolean nguyenChuyenHang) {
        this.nguyenChuyenHang = nguyenChuyenHang;
    }

    @Override
    public String toString() {
        return ten;
    }
}
