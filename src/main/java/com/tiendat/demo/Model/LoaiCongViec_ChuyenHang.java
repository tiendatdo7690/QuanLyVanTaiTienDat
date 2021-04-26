package com.tiendat.demo.Model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "LoaiCongViec_ChuyenHang")
public class LoaiCongViec_ChuyenHang implements Serializable {

    @EmbeddedId
    private  LoaiCongViec_ChuyenHangPK id;

    @MapsId("loaiCongViecId")
    @ManyToOne(fetch = FetchType.LAZY,
            cascade = {CascadeType.MERGE,CascadeType.DETACH,CascadeType.REFRESH})
    @JoinColumn(name = "LoaiCongViec_Id" , foreignKey= @ForeignKey(name = "Fk_LoaiCongViecCongViec_LoaiCongViec"), nullable = true)
    private LoaiCongViec loaiCongViec;

    @MapsId("chuyenHangId")
    @ManyToOne(fetch = FetchType.LAZY,
            cascade = {CascadeType.MERGE,CascadeType.DETACH,CascadeType.REFRESH})
    @JoinColumn(name = "Chuyen_Hang_Id" , foreignKey= @ForeignKey(name = "Fk_LoaiCongViecChuyenHang_ChuyenHang"), nullable = true)
    private ChuyenHang chuyenHang;

    @Column(name = "tiencong")
    private Long tienCong;

    public LoaiCongViec_ChuyenHang() {
    }


    public LoaiCongViec_ChuyenHangPK getId() {
        return id;
    }

    public void setId(LoaiCongViec_ChuyenHangPK id) {
        this.id = id;
    }

    public LoaiCongViec getLoaiCongViec() {
        return loaiCongViec;
    }

    public void setLoaiCongViec(LoaiCongViec loaiCongViec) {
        this.loaiCongViec = loaiCongViec;
    }

    public ChuyenHang getChuyenHang() {
        return chuyenHang;
    }

    public void setChuyenHang(ChuyenHang chuyenHang) {
        this.chuyenHang = chuyenHang;
    }

    public Long getTienCong() {
        return tienCong;
    }

    public void setTienCong(Long tienCong) {
        this.tienCong = tienCong;
    }

    public String getTen(){
        return loaiCongViec.getTen();
    }

    public Boolean getNguyenChuyen(){
        return loaiCongViec.isNguyenChuyenHang();
    }
}
