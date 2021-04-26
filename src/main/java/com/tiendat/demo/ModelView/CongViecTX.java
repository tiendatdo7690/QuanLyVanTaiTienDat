package com.tiendat.demo.ModelView;

import com.tiendat.demo.Model.LoaiCongViec;
import com.tiendat.demo.Model.LoaiCongViec_ChuyenHang;
import com.tiendat.demo.Model.TaiXe;

public class CongViecTX {

    private LoaiCongViec_ChuyenHang loaiCongViec_chuyenHang;
    private TaiXe taiXe;
    private LoaiCongViec loaiCongViec;

    public CongViecTX() {
    }

    public CongViecTX(LoaiCongViec_ChuyenHang congViec, TaiXe taiXe) {
        this.loaiCongViec_chuyenHang = congViec;
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

    public LoaiCongViec_ChuyenHang getLoaiCongViec_chuyenHang() {
        return loaiCongViec_chuyenHang;
    }

    public void setLoaiCongViec_chuyenHang(LoaiCongViec_ChuyenHang loaiCongViec_chuyenHang) {
        this.loaiCongViec_chuyenHang = loaiCongViec_chuyenHang;
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
        return loaiCongViec_chuyenHang.getTienCong();
    }


    public LoaiCongViec getE(){
        return loaiCongViec;
    }
}
