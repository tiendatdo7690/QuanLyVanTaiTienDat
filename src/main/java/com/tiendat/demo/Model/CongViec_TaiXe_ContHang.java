package com.tiendat.demo.Model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "CongViec_TaiXe_ContHang")
public class CongViec_TaiXe_ContHang implements Serializable {

    private static final long serialVersionUID = 6247028557353736502L;

    @Id
    @ManyToOne(fetch = FetchType.LAZY,
            cascade = {CascadeType.MERGE,CascadeType.DETACH,CascadeType.REFRESH})
    @JoinColumn(name = "ContHang_Id" , foreignKey= @ForeignKey(name = "Fk_CongViec_ContHang"), nullable = true)
    private ContHang contHang;

    @Id
    @ManyToOne(fetch = FetchType.LAZY,
            cascade = {CascadeType.MERGE,CascadeType.DETACH,CascadeType.REFRESH})
    @JoinColumn(name = "TaiXe_Id" , foreignKey= @ForeignKey(name = "Fk_CongViec_TaiXe"), nullable = true)
    private TaiXe taiXe;

    @Id
    @ManyToOne(fetch = FetchType.LAZY,
            cascade = {CascadeType.MERGE,CascadeType.DETACH,CascadeType.REFRESH})
    @JoinColumn(name = "LoaiCongViec_Id" , foreignKey= @ForeignKey(name = "Fk_CongViec_LoaiCongViec"), nullable = true)
    private CongViec congViec;

    public CongViec_TaiXe_ContHang() {
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

    public String getNoiDung(){
        return congViec.getLoaiCongViec().getTen();
    }

    public String getTenTaiXe(){
        return taiXe.getTen();
    }


}
