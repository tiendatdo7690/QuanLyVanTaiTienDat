package com.tiendat.demo.Model;

import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "ContHang")
public class ContHang implements Serializable {


    private static final long serialVersionUID = 992342996924918497L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Long id;

    @Type(type="org.hibernate.type.StringNVarcharType")
    @Column(name = "soCont", length = 255)
    private String soCont;

    @Type(type="org.hibernate.type.StringNVarcharType")
    @Column(name = "soSeal", length = 255)
    private String soSeal;

    @ManyToOne(fetch = FetchType.LAZY,
            cascade = {CascadeType.MERGE,CascadeType.DETACH,CascadeType.REFRESH})
    @JoinColumn(name = "loaihang_id" , foreignKey= @ForeignKey(name = "Fk_loaihang_contHang"), nullable = true)
    private LoaiHang loaiHang;



    @Type(type="org.hibernate.type.DateType")
    @Column(name = "ngayKetThuc")
    private Date ngay;

    @ManyToOne(fetch = FetchType.LAZY,
            cascade = {CascadeType.MERGE,CascadeType.DETACH,CascadeType.REFRESH})
    @JoinColumn(name = "cangLay_id" , foreignKey= @ForeignKey(name = "Fk_cangLay_contHang"), nullable = true)
    private Cang cangLay;

    @ManyToOne(fetch = FetchType.LAZY,
            cascade = {CascadeType.MERGE,CascadeType.DETACH,CascadeType.REFRESH})
    @JoinColumn(name = "cangHa_id" , foreignKey= @ForeignKey(name = "Fk_cangHa_contHang"), nullable = true)
    private Cang cangHa;

    @ManyToOne(fetch = FetchType.LAZY,
            cascade = {CascadeType.MERGE,CascadeType.DETACH,CascadeType.REFRESH})
    @JoinColumn(name = "xe_id" , foreignKey= @ForeignKey(name = "Fk_xe_contHang"), nullable = true)
    private Xe xe;

    @OneToMany(fetch = FetchType.LAZY,
            cascade = {CascadeType.MERGE,CascadeType.DETACH,CascadeType.REFRESH},
            mappedBy = "contHang")
    private Set<CongViec_TaiXe_ContHang> congViecTaiXeContHangSet = new HashSet<CongViec_TaiXe_ContHang>(0);

    @OneToMany(fetch = FetchType.LAZY,
            cascade = {CascadeType.MERGE,CascadeType.DETACH,CascadeType.REFRESH},
            mappedBy = "contHang")
    private Set<LoaiChiHo_ContHang> loaiChiHoContHangSet = new HashSet<LoaiChiHo_ContHang>();

    @OneToMany(fetch = FetchType.LAZY,
            cascade = {CascadeType.MERGE,CascadeType.DETACH,CascadeType.REFRESH},
            mappedBy = "contHang")
    private Set<ChiPhiContHang_ContHang> chiPhiContHangContHangSets = new HashSet<ChiPhiContHang_ContHang>();

    public ContHang() {
    }

    public Date getNgay() {
        return ngay;
    }

    public void setNgay(Date ngay) {
        this.ngay = ngay;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSoCont() {
        return soCont;
    }

    public void setSoCont(String soCont) {
        this.soCont = soCont;
    }

    public String getSoSeal() {
        return soSeal;
    }

    public void setSoSeal(String soSeal) {
        this.soSeal = soSeal;
    }

    public LoaiHang getLoaiHang() {
        return loaiHang;
    }

    public void setLoaiHang(LoaiHang loaiHang) {
        this.loaiHang = loaiHang;
    }

    public Cang getCangLay() {
        return cangLay;
    }

    public void setCangLay(Cang cangLay) {
        this.cangLay = cangLay;
    }

    public Cang getCangHa() {
        return cangHa;
    }

    public void setCangHa(Cang cangHa) {
        this.cangHa = cangHa;
    }

    public Xe getXe() {
        return xe;
    }

    public void setXe(Xe xe) {
        this.xe = xe;
    }

    public Set<LoaiChiHo_ContHang> getLoaiChiHoContHangSet() {
        return loaiChiHoContHangSet;
    }

    public void setLoaiChiHoContHangSet(Set<LoaiChiHo_ContHang> loaiChiHoContHangSet) {
        this.loaiChiHoContHangSet = loaiChiHoContHangSet;
    }

    public Set<ChiPhiContHang_ContHang> getChiPhiContHangContHangSets() {
        return chiPhiContHangContHangSets;
    }

    public Set<CongViec_TaiXe_ContHang> getCongViecTaiXeContHangSet() {
        return congViecTaiXeContHangSet;
    }

    public void setCongViecTaiXeContHangSet(Set<CongViec_TaiXe_ContHang> congViecTaiXeContHangSet) {
        this.congViecTaiXeContHangSet = congViecTaiXeContHangSet;
    }

    public void setChiPhiContHangContHangSets(Set<ChiPhiContHang_ContHang> chiPhiContHangContHangSets) {
        this.chiPhiContHangContHangSets = chiPhiContHangContHangSets;
    }


}
