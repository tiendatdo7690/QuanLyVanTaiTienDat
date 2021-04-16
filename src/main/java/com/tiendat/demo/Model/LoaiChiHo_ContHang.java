package com.tiendat.demo.Model;

import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@Table(name = "LoaiChiHo_ContHang")
public class LoaiChiHo_ContHang implements Serializable {

    private static final long serialVersionUID = 1381839026279139950L;

    @EmbeddedId
    private LoaiChiHo_ContHangPK id;

    @Column(name = "tien")
    private Long tien;

    @MapsId("idConHang")
    @ManyToOne(fetch = FetchType.LAZY,
            cascade = {CascadeType.MERGE,CascadeType.DETACH,CascadeType.REFRESH})
    @JoinColumn(name = "contHang_id" , foreignKey= @ForeignKey(name = "Fk_ChiHo_contHang"), nullable = true)
    private ContHang contHang;

    @MapsId("idLoaiChiHo")
    @ManyToOne(fetch = FetchType.LAZY,
            cascade = {CascadeType.MERGE,CascadeType.DETACH,CascadeType.REFRESH})
    @JoinColumn(name = "LoaiChiHo_id" , foreignKey= @ForeignKey(name = "Fk_ChiHo_LoaiChiHo"), nullable = true)
    private LoaiChiHo loaiChiHo;

    public LoaiChiHo_ContHang() {
    }

    public LoaiChiHo_ContHangPK getId() {
        return id;
    }

    public void setId(LoaiChiHo_ContHangPK id) {
        this.id = id;
    }

    public Long getTien() {
        return tien;
    }

    public void setTien(Long tien) {
        this.tien = tien;
    }

    public ContHang getContHang() {
        return contHang;
    }

    public void setContHang(ContHang contHang) {
        this.contHang = contHang;
    }

    public LoaiChiHo getLoaiChiHo() {
        return loaiChiHo;
    }

    public void setLoaiChiHo(LoaiChiHo loaiChiHo) {
        this.loaiChiHo = loaiChiHo;
    }

    public String getNoiDung(){
        return loaiChiHo.getTen();
    }

    public LoaiChiHo getE(){
        return loaiChiHo;
    }
}
