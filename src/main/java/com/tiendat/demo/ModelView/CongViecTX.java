package com.tiendat.demo.ModelView;

import com.tiendat.demo.Model.CongViec;
import com.tiendat.demo.Model.TaiXe;

public class CongViecTX {

    private CongViec congViec;
    private TaiXe taiXe;
    private String tenCV;

    public CongViecTX() {
    }

    public CongViecTX(CongViec congViec, TaiXe taiXe, String tenCV) {
        this.congViec = congViec;
        this.taiXe = taiXe;
        this.tenCV = tenCV;
    }

    public String getTenTx() {
        return taiXe.getTen();
    }

    public CongViec getCongViec() {
        return congViec;
    }

    public void setCongViec(CongViec congViec) {
        this.congViec = congViec;
    }

    public TaiXe getTaiXe() {
        return taiXe;
    }

    public void setTaiXe(TaiXe taiXe) {
        this.taiXe = taiXe;
    }

    public String getTenCV() {
        return tenCV;
    }

    public void setTenCV(String tenCV) {
        this.tenCV = tenCV;
    }

    public Long getTienTX() {
        return congViec.getTienCong();
    }


}
