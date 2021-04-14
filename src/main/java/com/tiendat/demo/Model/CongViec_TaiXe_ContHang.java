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

    @ManyToOne(fetch = FetchType.LAZY,
            cascade = {CascadeType.MERGE,CascadeType.DETACH,CascadeType.REFRESH})
    @JoinColumn(name = "tai_Xe_id" , foreignKey= @ForeignKey(name = "Fk_CongViec_TaiXe"), nullable = true)
    private TaiXe taiXe;

    @MapsId("congviecid")
    @ManyToOne(fetch = FetchType.LAZY,
            cascade = {CascadeType.MERGE,CascadeType.DETACH,CascadeType.REFRESH})
    @JoinColumn(name = "cong_Viec_id" , foreignKey= @ForeignKey(name = "Fk_CongViec_LoaiCongViec"), nullable = true)
    private CongViec congViec;

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

    public CongViec getCongViec() {
        return congViec;
    }

    public void setCongViec(CongViec congViec) {
        this.congViec = congViec;
    }

    public String getTenTaiXe(){
        return taiXe.getTen();
    }


}
