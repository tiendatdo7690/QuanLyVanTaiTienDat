package com.tiendat.demo.Model;

import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@Table(name = "ChiPhiContHang")
public class ChiPhiContHang implements Serializable {

    private static final long serialVersionUID = 3311460032337133990L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Long id;

    @Column(name = "tien")
    private Long tien;

    @Type(type="org.hibernate.type.StringNVarcharType")
    @Column(name = "ten", length = 255)
    private String ten;

    @ManyToOne(fetch = FetchType.LAZY,
            cascade = {CascadeType.MERGE,CascadeType.DETACH,CascadeType.REFRESH})
    @JoinColumn(name = "contHang_id" , foreignKey= @ForeignKey(name = "Fk_ChiPhiContHang_contHang"), nullable = true)
    private ContHang contHang;

    public ChiPhiContHang() {
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

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public ContHang getContHang() {
        return contHang;
    }

    public void setContHang(ContHang contHang) {
        this.contHang = contHang;
    }
}
