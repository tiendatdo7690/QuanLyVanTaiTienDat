package com.tiendat.demo.Model;

import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;

@Entity
@Table(name = "TienUngTaiXe")
public class TienUngTaiXe implements Serializable {

    private static final long serialVersionUID = 5658094572242875382L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Long id;

    @Type(type="org.hibernate.type.DateType")
    @Column(name = "ngay")
    private Date ngay;

    @Column(name = "tien")
    private Long tien;

    @ManyToOne(fetch = FetchType.LAZY,
            cascade = {CascadeType.MERGE,CascadeType.DETACH,CascadeType.REFRESH})
    @JoinColumn(name = "bangLuongTaiXe_id" , foreignKey= @ForeignKey(name = "Fk_bangLuongTaiXe_TienUngTaiXe"), nullable = true)
    private BangLuongTaiXe bangLuongTaiXe;

    public TienUngTaiXe() {
    }

    public BangLuongTaiXe getBangLuongTaiXe() {
        return bangLuongTaiXe;
    }

    public void setBangLuongTaiXe(BangLuongTaiXe bangLuongTaiXe) {
        this.bangLuongTaiXe = bangLuongTaiXe;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getNgay() {
        return ngay;
    }

    public void setNgay(Date ngay) {
        this.ngay = ngay;
    }

    public Long getTien() {
        return tien;
    }

    public void setTien(Long tien) {
        this.tien = tien;
    }
}
