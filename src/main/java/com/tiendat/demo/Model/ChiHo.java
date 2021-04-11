package com.tiendat.demo.Model;

import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@Table(name = "ChiHo")
public class ChiHo implements Serializable {

    private static final long serialVersionUID = 1381839026279139950L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Long id;

    @Column(name = "tien")
    private Long tien;

    @ManyToOne(fetch = FetchType.LAZY,
            cascade = {CascadeType.MERGE,CascadeType.DETACH,CascadeType.REFRESH})
    @JoinColumn(name = "contHang_id" , foreignKey= @ForeignKey(name = "Fk_ChiHo_contHang"), nullable = true)
    private ContHang contHang;

    @ManyToOne(fetch = FetchType.LAZY,
            cascade = {CascadeType.MERGE,CascadeType.DETACH,CascadeType.REFRESH})
    @JoinColumn(name = "LoaiChiHo_id" , foreignKey= @ForeignKey(name = "Fk_ChiHo_LoaiChiHo"), nullable = true)
    private LoaiChiHo loaiChiHo;

    public ChiHo() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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
}
