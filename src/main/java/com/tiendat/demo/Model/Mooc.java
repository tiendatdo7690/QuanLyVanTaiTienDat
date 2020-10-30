package com.tiendat.demo.Model;

import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Mooc")
public class Mooc implements Serializable {

    private static final long serialVersionUID = -1465157796443750036L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Long id;

    @Type(type="org.hibernate.type.StringNVarcharType")
    @Column(name = "bienSo", length = 255)
    private String bienSo;

    @Column(name = "namSanXuat")
    private int namSanXuat;

    @Type(type="org.hibernate.type.StringNVarcharType")
    @Column(name = "hieu", length = 255)
    private String hieu;

    @org.hibernate.annotations.Type(type="true_false")
    @Column(name = "trangThai")
    private boolean trangThai;

    @OneToMany(fetch = FetchType.LAZY,
            cascade = {CascadeType.MERGE,CascadeType.DETACH,CascadeType.REFRESH},
            mappedBy = "mooc")
    private Set<ChiPhiXetMooc> chiPhiXetMoocSet = new HashSet<ChiPhiXetMooc>(0);

    @OneToMany(fetch = FetchType.LAZY,
            cascade = {CascadeType.MERGE,CascadeType.DETACH,CascadeType.REFRESH},
            mappedBy = "mooc")
    private Set<ChiPhiMoocKhac> chiPhiMoocKhacSet = new HashSet<ChiPhiMoocKhac>(0);

    @OneToMany(fetch = FetchType.LAZY,
            cascade = {CascadeType.MERGE,CascadeType.DETACH,CascadeType.REFRESH},
            mappedBy = "mooc")
    private Set<ChiPhiVoMooc> chiPhiVoMoocSet = new HashSet<ChiPhiVoMooc>(0);


    public Mooc() {
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

    public int getNamSanXuat() {
        return namSanXuat;
    }

    public void setNamSanXuat(int namSanXuat) {
        this.namSanXuat = namSanXuat;
    }

    public String getHieu() {
        return hieu;
    }

    public void setHieu(String hieu) {
        this.hieu = hieu;
    }

    public Set<ChiPhiXetMooc> getChiPhiXetMoocSet() {
        return chiPhiXetMoocSet;
    }

    public void setChiPhiXetMoocSet(Set<ChiPhiXetMooc> chiPhiXetMoocSet) {
        this.chiPhiXetMoocSet = chiPhiXetMoocSet;
    }

    public Set<ChiPhiMoocKhac> getChiPhiMoocKhacSet() {
        return chiPhiMoocKhacSet;
    }

    public void setChiPhiMoocKhacSet(Set<ChiPhiMoocKhac> chiPhiMoocKhacSet) {
        this.chiPhiMoocKhacSet = chiPhiMoocKhacSet;
    }

    public Set<ChiPhiVoMooc> getChiPhiVoMoocSet() {
        return chiPhiVoMoocSet;
    }

    public void setChiPhiVoMoocSet(Set<ChiPhiVoMooc> chiPhiVoMoocSet) {
        this.chiPhiVoMoocSet = chiPhiVoMoocSet;
    }
}
