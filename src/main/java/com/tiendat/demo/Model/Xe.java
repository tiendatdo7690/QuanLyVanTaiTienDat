package com.tiendat.demo.Model;

import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Xe")
public class Xe implements Serializable {

    private static final long serialVersionUID = -8994226113123412852L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Long id;

    @Type(type="org.hibernate.type.StringNVarcharType")
    @Column(name = "bienSo", length = 255)
    private String bienSo;

    @org.hibernate.annotations.Type(type="true_false")
    @Column(name = "trangThai")
    private boolean trangThai;

    @Column(name = "namSX")
    private int namSX;

    @Type(type="org.hibernate.type.StringNVarcharType")
    @Column(name = "hieuXe", length = 255)
    private String hieuXe;

    @ManyToOne(fetch = FetchType.LAZY,
            cascade = {CascadeType.MERGE,CascadeType.DETACH,CascadeType.REFRESH})
    @JoinColumn(name = "taiXe_id" , foreignKey= @ForeignKey(name = "Fk_taiXe_xe"), nullable = true)
    private TaiXe taiXe;

    @OneToMany(fetch = FetchType.LAZY,
            cascade = {CascadeType.MERGE,CascadeType.DETACH,CascadeType.REFRESH},
            mappedBy = "xe")
    private Set<ChiPhiXetXe> chiPhiXetXeSet = new HashSet<ChiPhiXetXe>();

    @OneToMany(fetch = FetchType.LAZY,
            cascade = {CascadeType.MERGE,CascadeType.DETACH,CascadeType.REFRESH},
            mappedBy = "xe")
    private Set<ChiPhiDau> chiPhiDauSet = new HashSet<ChiPhiDau>();

    @OneToMany(fetch = FetchType.LAZY,
            cascade = {CascadeType.MERGE,CascadeType.DETACH,CascadeType.REFRESH},
            mappedBy = "xe")
    private Set<ChiPhiThayNhot> chiPhiThayNhotSet = new HashSet<ChiPhiThayNhot>();

    @OneToMany(fetch = FetchType.LAZY,
            cascade = {CascadeType.MERGE,CascadeType.DETACH,CascadeType.REFRESH},
            mappedBy = "xe")
    private Set<ChiPhiVoXe> chiPhiVoXeSet = new HashSet<ChiPhiVoXe>();

    @OneToMany(fetch = FetchType.LAZY,
            cascade = {CascadeType.MERGE,CascadeType.DETACH,CascadeType.REFRESH},
            mappedBy = "xe")
    private Set<ChiPhiXeKhac> chiPhiXeKhacSet = new HashSet<ChiPhiXeKhac>();

    public Xe() {
    }

    public Xe(Long id, String bienSo, int namSX, String hieuXe, TaiXe taiXe, Set<ChiPhiXetXe> chiPhiXetXeSet,
              Set<ChiPhiDau> chiPhiDauSet, Set<ChiPhiThayNhot> chiPhiThayNhotSet, Set<ChiPhiVoXe> chiPhiVoXeSet,
              Set<ChiPhiXeKhac> chiPhiXeKhacSet) {
        this.id = id;
        this.bienSo = bienSo;
        this.namSX = namSX;
        this.hieuXe = hieuXe;
        this.taiXe = taiXe;
        this.chiPhiXetXeSet = chiPhiXetXeSet;
        this.chiPhiDauSet = chiPhiDauSet;
        this.chiPhiThayNhotSet = chiPhiThayNhotSet;
        this.chiPhiVoXeSet = chiPhiVoXeSet;
        this.chiPhiXeKhacSet = chiPhiXeKhacSet;
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

    public String getBienSo() {
        return bienSo;
    }

    public void setBienSo(String bienSo) {
        this.bienSo = bienSo;
    }

    public int getNamSX() {
        return namSX;
    }

    public void setNamSX(int namSX) {
        this.namSX = namSX;
    }

    public String getHieuXe() {
        return hieuXe;
    }

    public void setHieuXe(String hieuXe) {
        this.hieuXe = hieuXe;
    }

    public TaiXe getTaiXe() {
        return taiXe;
    }

    public void setTaiXe(TaiXe taiXe) {
        this.taiXe = taiXe;
    }

    public Set<ChiPhiXetXe> getChiPhiXetXeSet() {
        return chiPhiXetXeSet;
    }

    public void setChiPhiXetXeSet(Set<ChiPhiXetXe> chiPhiXetXeSet) {
        this.chiPhiXetXeSet = chiPhiXetXeSet;
    }

    public Set<ChiPhiDau> getChiPhiDauSet() {
        return chiPhiDauSet;
    }

    public void setChiPhiDauSet(Set<ChiPhiDau> chiPhiDauSet) {
        this.chiPhiDauSet = chiPhiDauSet;
    }

    public Set<ChiPhiThayNhot> getChiPhiThayNhotSet() {
        return chiPhiThayNhotSet;
    }

    public void setChiPhiThayNhotSet(Set<ChiPhiThayNhot> chiPhiThayNhotSet) {
        this.chiPhiThayNhotSet = chiPhiThayNhotSet;
    }

    public Set<ChiPhiVoXe> getChiPhiVoXeSet() {
        return chiPhiVoXeSet;
    }

    public void setChiPhiVoXeSet(Set<ChiPhiVoXe> chiPhiVoXeSet) {
        this.chiPhiVoXeSet = chiPhiVoXeSet;
    }

    public Set<ChiPhiXeKhac> getChiPhiXeKhacSet() {
        return chiPhiXeKhacSet;
    }

    public void setChiPhiXeKhacSet(Set<ChiPhiXeKhac> chiPhiXeKhacSet) {
        this.chiPhiXeKhacSet = chiPhiXeKhacSet;
    }


}
