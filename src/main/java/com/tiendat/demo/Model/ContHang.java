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

    @Type(type="org.hibernate.type.StringNVarcharType")
    @Column(name = "loaiHang", length = 255)
    private String loaiHang;

    @ManyToOne(fetch = FetchType.LAZY,
            cascade = {CascadeType.MERGE,CascadeType.DETACH,CascadeType.REFRESH})
    @JoinColumn(name = "chuyenHang_id" , foreignKey= @ForeignKey(name = "Fk_chuyenHang_contHang"), nullable = true)
    private ChuyenHang chuyenHang;

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

    @ManyToOne(fetch = FetchType.LAZY,
            cascade = {CascadeType.MERGE,CascadeType.DETACH,CascadeType.REFRESH})
    @JoinColumn(name = "taiXe_id" , foreignKey= @ForeignKey(name = "Fk_taiXe_contHang"), nullable = true)
    private TaiXe taiXe;

    @OneToMany(fetch = FetchType.LAZY,
            cascade = {CascadeType.MERGE,CascadeType.DETACH,CascadeType.REFRESH},
            mappedBy = "contHang")
    private Set<ChiHo> chiHoSet = new HashSet<ChiHo>();

    @OneToMany(fetch = FetchType.LAZY,
            cascade = {CascadeType.MERGE,CascadeType.DETACH,CascadeType.REFRESH},
            mappedBy = "contHang")
    private Set<ChiPhiContHang> chiPhiContHangSets = new HashSet<ChiPhiContHang>();

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

    public String getLoaiHang() {
        return loaiHang;
    }

    public void setLoaiHang(String loaiHang) {
        this.loaiHang = loaiHang;
    }

    public ChuyenHang getChuyenHang() {
        return chuyenHang;
    }

    public void setChuyenHang(ChuyenHang chuyenHang) {
        this.chuyenHang = chuyenHang;
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

    public TaiXe getTaiXe() {
        return taiXe;
    }

    public void setTaiXe(TaiXe taiXe) {
        this.taiXe = taiXe;
    }

    public Set<ChiHo> getChiHoSet() {
        return chiHoSet;
    }

    public void setChiHoSet(Set<ChiHo> chiHoSet) {
        this.chiHoSet = chiHoSet;
    }

    public Set<ChiPhiContHang> getChiPhiContHangSets() {
        return chiPhiContHangSets;
    }

    public void setChiPhiContHangSets(Set<ChiPhiContHang> chiPhiContHangSets) {
        this.chiPhiContHangSets = chiPhiContHangSets;
    }


}