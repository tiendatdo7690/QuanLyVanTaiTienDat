package com.tiendat.demo.Model;

import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "ChuyenHang")
public class ChuyenHang implements Serializable {

    private static final long serialVersionUID = 9087946255496366821L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Long id;

    @Type(type="org.hibernate.type.StringNVarcharType")
    @Column(name = "tenChuyenHang", length = 255)
    private String tenChuyenHang;

    @Type(type="org.hibernate.type.StringNVarcharType")
    @Column(name = "diaChiNoiDen", length = 255)
    private String diaChiNoiDen;

    @org.hibernate.annotations.Type(type="true_false")
    @Column(name = "trangThai")
    private boolean trangThai;

    @ManyToOne(fetch = FetchType.LAZY,
            cascade = {CascadeType.MERGE,CascadeType.DETACH,CascadeType.REFRESH})
    @JoinColumn(name = "chuHang_id" , foreignKey= @ForeignKey(name = "Fk_chuHang_ChuyenHang"), nullable = true)
    private ChuHang chuHang;

    @OneToMany(fetch = FetchType.LAZY,
            cascade = {CascadeType.MERGE,CascadeType.DETACH,CascadeType.REFRESH},
            mappedBy = "chuyenHang")
    private Set<GiaCuoc> giaCuocSet = new HashSet<GiaCuoc>(0);

    @OneToMany(fetch = FetchType.LAZY,
            cascade = {CascadeType.MERGE,CascadeType.DETACH,CascadeType.REFRESH},
            mappedBy = "chuyenHang")
    private Set<TienTaiXe> tienTaiXeSet = new HashSet<TienTaiXe>(0);

    @OneToMany(fetch = FetchType.LAZY,
            cascade = {CascadeType.MERGE,CascadeType.DETACH,CascadeType.REFRESH},
            mappedBy = "chuyenHang")
    private Set<ContHang> contHangSet = new HashSet<ContHang>(0);

    public ChuyenHang() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTenChuyenHang() {
        return tenChuyenHang;
    }

    public void setTenChuyenHang(String tenChuyenHang) {
        this.tenChuyenHang = tenChuyenHang;
    }

    public String getDiaChiNoiDen() {
        return diaChiNoiDen;
    }

    public void setDiaChiNoiDen(String diaChiNoiDen) {
        this.diaChiNoiDen = diaChiNoiDen;
    }

    public ChuHang getChuHang() {
        return chuHang;
    }

    public void setChuHang(ChuHang chuHang) {
        this.chuHang = chuHang;
    }

    public Set<GiaCuoc> getGiaCuocSet() {
        return giaCuocSet;
    }

    public void setGiaCuocSet(Set<GiaCuoc> giaCuocSet) {
        this.giaCuocSet = giaCuocSet;
    }

    public Set<TienTaiXe> getTienTaiXeSet() {
        return tienTaiXeSet;
    }

    public void setTienTaiXeSet(Set<TienTaiXe> tienTaiXeSet) {
        this.tienTaiXeSet = tienTaiXeSet;
    }

    public Set<ContHang> getContHangSet() {
        return contHangSet;
    }

    public void setContHangSet(Set<ContHang> contHangSet) {
        this.contHangSet = contHangSet;
    }
}
