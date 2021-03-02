package com.tiendat.demo.Model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "CongViec")
public class CongViec implements Serializable {

    private static final long serialVersionUID = 6247028557353736502L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY,
            cascade = {CascadeType.MERGE,CascadeType.DETACH,CascadeType.REFRESH})
    @JoinColumn(name = "ContHang_Id" , foreignKey= @ForeignKey(name = "Fk_CongViec_ContHang"), nullable = true)
    private ContHang contHang;

    @ManyToOne(fetch = FetchType.LAZY,
            cascade = {CascadeType.MERGE,CascadeType.DETACH,CascadeType.REFRESH})
    @JoinColumn(name = "TaiXe_Id" , foreignKey= @ForeignKey(name = "Fk_CongViec_TaiXe"), nullable = true)
    private TaiXe taiXe;

    @ManyToOne(fetch = FetchType.LAZY,
            cascade = {CascadeType.MERGE,CascadeType.DETACH,CascadeType.REFRESH})
    @JoinColumn(name = "LoaiCongViec_Id" , foreignKey= @ForeignKey(name = "Fk_CongViec_LoaiCongViec"), nullable = true)
    private LoaiCongViec loaiCongViec;

    public CongViec() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ContHang getContHang() {
        return contHang;
    }

    public void setContHang(ContHang contHang) {
        this.contHang = contHang;
    }

    public TaiXe getTaiXe() {
        return taiXe;
    }

    public void setTaiXe(TaiXe taiXe) {
        this.taiXe = taiXe;
    }

    public LoaiCongViec getLoaiCongViec() {
        return loaiCongViec;
    }

    public void setLoaiCongViec(LoaiCongViec loaiCongViec) {
        this.loaiCongViec = loaiCongViec;
    }
}
