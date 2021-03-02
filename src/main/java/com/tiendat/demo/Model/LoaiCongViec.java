package com.tiendat.demo.Model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "LoaiCongViec")
public class LoaiCongViec implements Serializable {

    private static final long serialVersionUID = 4278937675314155055L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Long id;

    @Column(name = "tiencong")
    private Long tienCong;

    @ManyToOne(fetch = FetchType.LAZY,
            cascade = {CascadeType.MERGE,CascadeType.DETACH,CascadeType.REFRESH})
    @JoinColumn(name = "ChuyenHang_Id" , foreignKey= @ForeignKey(name = "Fk_LoaiCongViec_ChuyenHang"), nullable = true)
    private ChuyenHang chuyenHang;

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

    public Long getTienCong() {
        return tienCong;
    }

    public void setTienCong(Long tienCong) {
        this.tienCong = tienCong;
    }

    public ChuyenHang getChuyenHang() {
        return chuyenHang;
    }

    public void setChuyenHang(ChuyenHang chuyenHang) {
        this.chuyenHang = chuyenHang;
    }

    public Set<CongViec> getCongViecSet() {
        return congViecSet;
    }

    public void setCongViecSet(Set<CongViec> congViecSet) {
        this.congViecSet = congViecSet;
    }
}
