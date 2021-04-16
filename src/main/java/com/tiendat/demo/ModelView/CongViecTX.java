package com.tiendat.demo.ModelView;

import com.tiendat.demo.Model.CongViec;
import com.tiendat.demo.Model.LoaiChiPhiContHang;
import com.tiendat.demo.Model.LoaiCongViec;
import com.tiendat.demo.Model.TaiXe;

public class CongViecTX {

    private CongViec congViec;
    private TaiXe taiXe;
    private LoaiCongViec loaiCongViec;

    public CongViecTX() {
    }

    public CongViecTX(CongViec congViec, TaiXe taiXe) {
        this.congViec = congViec;
        this.taiXe = taiXe;
    }

    public LoaiCongViec getLoaiCongViec() {
        return loaiCongViec;
    }

    public void setLoaiCongViec(LoaiCongViec loaiCongViec) {
        this.loaiCongViec = loaiCongViec;
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
        return loaiCongViec.getTen();
    }


    public Long getTienTX() {
        return congViec.getTienCong();
    }


    public LoaiCongViec getE(){
        return loaiCongViec;
    }
}
