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
    @Column(name = "coPhaiNguyenChuyen")
    private boolean coPhaiNguyenChuyen;

    @OneToMany(fetch = FetchType.LAZY,
            cascade = {CascadeType.MERGE,CascadeType.DETACH,CascadeType.REFRESH},
            mappedBy = "loaiCongViec")
    private Set<CongViec> congViecSet = new HashSet<CongViec>(0);

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

    public Set<CongViec> getCongViecSet() {
        return congViecSet;
    }

    public void setCongViecSet(Set<CongViec> congViecSet) {
        this.congViecSet = congViecSet;
    }
}
