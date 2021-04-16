package com.tiendat.demo.Model;

import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@Table(name = "ChiPhiContHang_ContHang")
public class ChiPhiContHang_ContHang implements Serializable {

    private static final long serialVersionUID = 3311460032337133990L;

    @EmbeddedId
    private ChiPhiContHang_ContHangPK id;

    @Column(name = "tien")
    private Long tien;

    @MapsId("idContHang")
    @ManyToOne(fetch = FetchType.LAZY,
            cascade = {CascadeType.MERGE,CascadeType.DETACH,CascadeType.REFRESH})
    @JoinColumn(name = "contHang_id" , foreignKey= @ForeignKey(name = "Fk_ChiPhiContHang_contHang"), nullable = true)
    private ContHang contHang;

    @MapsId("idChiPhiContHang")
    @ManyToOne(fetch = FetchType.LAZY,
            cascade = {CascadeType.MERGE,CascadeType.DETACH,CascadeType.REFRESH})
    @JoinColumn(name = "LoaiChiPhiContHang_id" , foreignKey= @ForeignKey(name = "Fk_ChiPhiContHang_LoaiChiPhiContHang"), nullable = true)
    private LoaiChiPhiContHang loaiChiPhiContHang;

    public ChiPhiContHang_ContHang() {
    }

    public ChiPhiContHang_ContHangPK getId() {
        return id;
    }

    public void setId(ChiPhiContHang_ContHangPK id) {
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

    public LoaiChiPhiContHang getLoaiChiPhiContHang() {
        return loaiChiPhiContHang;
    }

    public void setLoaiChiPhiContHang(LoaiChiPhiContHang loaiChiPhiContHang) {
        this.loaiChiPhiContHang = loaiChiPhiContHang;
    }

    public LoaiChiPhiContHang getE(){
        return loaiChiPhiContHang;
    }

    public String getNoiDung(){
        return loaiChiPhiContHang.getTen();
    }
}
