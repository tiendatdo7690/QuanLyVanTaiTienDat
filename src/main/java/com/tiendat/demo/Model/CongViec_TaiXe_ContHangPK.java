package com.tiendat.demo.Model;

import java.io.Serializable;

public class CongViec_TaiXe_ContHangPK implements Serializable {

    private ContHang contHang;
    private TaiXe taiXe;
    private CongViec congViec;

    public CongViec_TaiXe_ContHangPK() {
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
}
