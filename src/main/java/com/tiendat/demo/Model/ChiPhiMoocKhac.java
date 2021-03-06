package com.tiendat.demo.Model;

import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;


@Entity
@Table(name = "ChiPhiMoocKhac")
public class ChiPhiMoocKhac implements Serializable {

    private static final long serialVersionUID = 1281903245915603442L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Long id;

    @Column(name = "tien")
    private Long tien;

    @Type(type="org.hibernate.type.StringNVarcharType")
    @Column(name = "noiDung", length = 255)
    private String noiDung;

    @Type(type="org.hibernate.type.DateType")
    @Column(name = "ngay")
    private Date ngay;

    @ManyToOne(fetch = FetchType.LAZY,
            cascade = {CascadeType.MERGE,CascadeType.DETACH,CascadeType.REFRESH})
    @JoinColumn(name = "mooc_id" , foreignKey= @ForeignKey(name = "Fk_mooc_ChiPhiMoocKhac"), nullable = true)
    private Mooc mooc;

    public ChiPhiMoocKhac() {
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

    public String getNoiDung() {
        return noiDung;
    }

    public void setNoiDung(String noiDung) {
        this.noiDung = noiDung;
    }

    public Date getNgay() {
        return ngay;
    }

    public void setNgay(Date ngay) {
        this.ngay = ngay;
    }

    public Mooc getMooc() {
        return mooc;
    }

    public void setMooc(Mooc mooc) {
        this.mooc = mooc;
    }
}
