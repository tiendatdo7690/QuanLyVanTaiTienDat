package com.tiendat.demo.Model;

import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

//11/4 thêm côt tên
@Entity
@Table(name = "CongViec")
public class CongViec implements Serializable {

    private static final long serialVersionUID = 4278937675314155055L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Long id;

    @Column(name = "tiencong")
    private Long tienCong;

    @OneToMany(fetch = FetchType.LAZY,
            cascade = {CascadeType.MERGE,CascadeType.DETACH,CascadeType.REFRESH},
            mappedBy = "congViec")
    private Set<LoaiCongViec_ChuyenHang> loaiCongViec_chuyenHangSet = new HashSet<LoaiCongViec_ChuyenHang>(0);

    @OneToMany(fetch = FetchType.LAZY,
            cascade = {CascadeType.MERGE,CascadeType.DETACH,CascadeType.REFRESH},
            mappedBy = "congViec")
    private Set<CongViec_TaiXe_ContHang> congViecTaiXeContHangSet = new HashSet<CongViec_TaiXe_ContHang>(0);

    public CongViec() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getTienCong() {
        return tienCong;
    }

    public void setTienCong(Long tienCong) {
        this.tienCong = tienCong;
    }

    public Set<CongViec_TaiXe_ContHang> getCongViecTaiXeContHangSet() {
        return congViecTaiXeContHangSet;
    }

    public void setCongViecTaiXeContHangSet(Set<CongViec_TaiXe_ContHang> congViecTaiXeContHangSet) {
        this.congViecTaiXeContHangSet = congViecTaiXeContHangSet;
    }

    public Set<LoaiCongViec_ChuyenHang> getLoaiCongViec_chuyenHangSet() {
        return loaiCongViec_chuyenHangSet;
    }

    public void setLoaiCongViec_chuyenHangSet(Set<LoaiCongViec_ChuyenHang> loaiCongViec_chuyenHangSet) {
        this.loaiCongViec_chuyenHangSet = loaiCongViec_chuyenHangSet;
    }
}
