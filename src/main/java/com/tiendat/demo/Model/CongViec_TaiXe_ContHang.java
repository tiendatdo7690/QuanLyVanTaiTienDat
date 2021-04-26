package com.tiendat.demo.Model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "Cong_Viec_Tai_Xe_Cont_Hang")
public class CongViec_TaiXe_ContHang implements Serializable {

    private static final long serialVersionUID = 6247028557353736502L;

    @EmbeddedId
    private  CongViec_TaiXe_ContHangPK id;

    @MapsId("conthangid")
    @ManyToOne(fetch = FetchType.LAZY,
            cascade = {CascadeType.MERGE,CascadeType.DETACH,CascadeType.REFRESH})
    @JoinColumn(name = "cont_Hang_id" , foreignKey= @ForeignKey(name = "Fk_CongViec_ContHang"), nullable = true)
    private ContHang contHang;

    @MapsId("taixeid")
    @ManyToOne(fetch = FetchType.LAZY,
            cascade = {CascadeType.MERGE,CascadeType.DETACH,CascadeType.REFRESH})
    @JoinColumn(name = "tai_Xe_id" , foreignKey= @ForeignKey(name = "Fk_CongViec_TaiXe"), nullable = true)
    private TaiXe taiXe;

    @MapsId("loaiCongViec_ChuyenHangId")
    @ManyToOne(fetch = FetchType.LAZY,
            cascade = {CascadeType.MERGE,CascadeType.DETACH,CascadeType.REFRESH})
//    @JoinColumn(name = "cong_Viec_id" , foreignKey= @ForeignKey(name = "Fk_CongViec_LoaiCongViec"), nullable = true)
//    @JoinColumns({
//            @JoinColumn(name="loaicongviec_id", referencedColumnName="loaiCongViec"),
//            @JoinColumn(name="Chuyen_Hang_id", referencedColumnName="chuyenHang")
//    })
    private LoaiCongViec_ChuyenHang loaiCongViec_chuyenHang;

    public CongViec_TaiXe_ContHang() {
    }


    public CongViec_TaiXe_ContHangPK getId() {
        return id;
    }

    public void setId(CongViec_TaiXe_ContHangPK id) {
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

    public LoaiCongViec_ChuyenHang getLoaiCongViec_chuyenHang() {
        return loaiCongViec_chuyenHang;
    }

    public void setLoaiCongViec_chuyenHang(LoaiCongViec_ChuyenHang loaiCongViec_chuyenHang) {
        this.loaiCongViec_chuyenHang = loaiCongViec_chuyenHang;
    }

    public String getTenTaiXe(){
        return taiXe.getTen();
    }


}
