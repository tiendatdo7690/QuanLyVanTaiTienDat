package com.tiendat.demo.Model;

import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;

@Entity
@Table(name = "TienThuongTX")
public class TienThuongTX implements Serializable {

    private static final long serialVersionUID = -8560822141624460486L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Long id;

    @Type(type="org.hibernate.type.StringNVarcharType")
    @Column(name = "noiDung", length = 255)
    private String noiDung;

    @Column(name = "tien")
    private Long tien;

    @Type(type="org.hibernate.type.DateType")
    @Column(name = "ngay")
    private Date ngay;

    @ManyToOne(fetch = FetchType.LAZY,
            cascade = {CascadeType.MERGE,CascadeType.DETACH,CascadeType.REFRESH})
    @JoinColumn(name = "bangLuongTaiXe_id" , foreignKey= @ForeignKey(name = "Fk_bangLuongTaiXe_TienThuongTX"), nullable = true)
    private BangLuongTaiXe bangLuongTaiXe;

    public TienThuongTX() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNoiDung() {
        return noiDung;
    }

    public void setNoiDung(String noiDung) {
        this.noiDung = noiDung;
    }

    public Long getTien() {
        return tien;
    }

    public void setTien(Long tien) {
        this.tien = tien;
    }

    public Date getNgay() {
        return ngay;
    }

    public void setNgay(Date ngay) {
        this.ngay = ngay;
    }

    public BangLuongTaiXe getBangLuongTaiXe() {
        return bangLuongTaiXe;
    }

    public void setBangLuongTaiXe(BangLuongTaiXe bangLuongTaiXe) {
        this.bangLuongTaiXe = bangLuongTaiXe;
    }
}
