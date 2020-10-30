package com.tiendat.demo.Model;

import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;

@Entity
@Table(name = "ChiPhiVoMooc")
public class ChiPhiVoMooc implements Serializable {

    private static final long serialVersionUID = 6866040488039762905L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Long id;

    @Column(name = "tien")
    private Long tien;

    @Column(name = "soLuong")
    private int soLuong;

    @Type(type="org.hibernate.type.DateType")
    @Column(name = "ngay")
    private Date ngay;

    @ManyToOne(fetch = FetchType.LAZY,
            cascade = {CascadeType.MERGE,CascadeType.DETACH,CascadeType.REFRESH})
    @JoinColumn(name = "mooc_id" , foreignKey= @ForeignKey(name = "Fk_mooc_ChiPhiVoMooc"), nullable = true)
    private Mooc mooc;


    public ChiPhiVoMooc() {
    }

    public Mooc getMooc() {
        return mooc;
    }

    public void setMooc(Mooc mooc) {
        this.mooc = mooc;
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

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public Date getNgay() {
        return ngay;
    }

    public void setNgay(Date ngay) {
        this.ngay = ngay;
    }
}
