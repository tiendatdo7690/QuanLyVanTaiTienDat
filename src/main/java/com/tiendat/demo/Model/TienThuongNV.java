package com.tiendat.demo.Model;

import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "TienThuongNV")
public class TienThuongNV implements Serializable {

    private static final long serialVersionUID = 4506668474404584082L;

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
    @JoinColumn(name = "nhanVien_id" , foreignKey= @ForeignKey(name = "Fk_nhanVien_TienThuongNV"), nullable = true)
    private NhanVien nhanVien;

    public TienThuongNV() {
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

    public NhanVien getNhanVien() {
        return nhanVien;
    }

    public void setNhanVien(NhanVien nhanVien) {
        this.nhanVien = nhanVien;
    }
}
