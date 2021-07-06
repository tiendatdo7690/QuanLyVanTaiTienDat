package com.tiendat.demo.Model;

import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "TaiXe")
public class TaiXe implements Serializable {

    private static final long serialVersionUID = -7144062797793070741L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Long id;

    @Type(type="org.hibernate.type.StringNVarcharType")
    @Column(name = "ten", length = 255)
    private String ten;

    @Type(type="org.hibernate.type.DateType")
    @Column(name = "ngaySinh")
    private Date ngaySinh;

    @Type(type="org.hibernate.type.StringNVarcharType")
    @Column(name = "queQuan", length = 255)
    private String queQuan;

    @org.hibernate.annotations.Type(type="true_false")
    @Column(name = "trangThai")
    private boolean trangThai;

    @OneToOne(fetch = FetchType.LAZY,
            cascade = {CascadeType.MERGE,CascadeType.DETACH,CascadeType.REFRESH})
    @JoinColumn(name = "xe_id" , foreignKey= @ForeignKey(name = "Fk_xe_TaiXe"),
            referencedColumnName = "id", nullable = false, unique = true)
    private Xe xe;

    @OneToMany(fetch = FetchType.LAZY,
            cascade = {CascadeType.MERGE,CascadeType.DETACH,CascadeType.REFRESH},
            mappedBy = "taiXe")
    private Set<BangLuongTaiXe> bangLuongTaiXeSet = new HashSet<BangLuongTaiXe>(0);

    @OneToMany(fetch = FetchType.LAZY,
            cascade = {CascadeType.MERGE,CascadeType.DETACH,CascadeType.REFRESH},
            mappedBy = "taiXe")
    private Set<LuongCoBanTaiXe> luongCoBanTaiXeSet = new HashSet<LuongCoBanTaiXe>(0);

    @OneToMany(fetch = FetchType.LAZY,
            cascade = {CascadeType.MERGE,CascadeType.DETACH,CascadeType.REFRESH},
            mappedBy = "taiXe")
    private Set<TienUngTaiXe> tienUngTaiXes = new HashSet<TienUngTaiXe>(0);

    @OneToMany(fetch = FetchType.LAZY,
            cascade = {CascadeType.MERGE,CascadeType.DETACH,CascadeType.REFRESH},
            mappedBy = "taiXe")
    private Set<CongViec_TaiXe_ContHang> congViecTaiXeContHangSet = new HashSet<CongViec_TaiXe_ContHang>(0);

    public TaiXe() {
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

    public Date getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(Date ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public String getQueQuan() {
        return queQuan;
    }

    public void setQueQuan(String queQuan) {
        this.queQuan = queQuan;
    }

    public Xe getXe() {
        return xe;
    }

    public void setXe(Xe xe) {
        this.xe = xe;
    }

    public Set<BangLuongTaiXe> getBangLuongTaiXeSet() {
        return bangLuongTaiXeSet;
    }

    public void setBangLuongTaiXeSet(Set<BangLuongTaiXe> bangLuongTaiXeSet) {
        this.bangLuongTaiXeSet = bangLuongTaiXeSet;
    }

    public Set<LuongCoBanTaiXe> getLuongCoBanTaiXeSet() {
        return luongCoBanTaiXeSet;
    }

    public void setLuongCoBanTaiXeSet(Set<LuongCoBanTaiXe> luongCoBanTaiXeSet) {
        this.luongCoBanTaiXeSet = luongCoBanTaiXeSet;
    }

    public Set<CongViec_TaiXe_ContHang> getCongViecTaiXeContHangSet() {
        return congViecTaiXeContHangSet;
    }

    public void setCongViecTaiXeContHangSet(Set<CongViec_TaiXe_ContHang> congViecTaiXeContHangSet) {
        this.congViecTaiXeContHangSet = congViecTaiXeContHangSet;
    }

    public Set<TienUngTaiXe> getTienUngTaiXes() {
        return tienUngTaiXes;
    }

    public void setTienUngTaiXes(Set<TienUngTaiXe> tienUngTaiXes) {
        this.tienUngTaiXes = tienUngTaiXes;
    }

    @Override
    public String toString() {
        return ten;
    }
}
