package com.tiendat.demo.Model;

import java.io.Serializable;

public class LoaiCongViec_ChuyenHangPK implements Serializable {

    private LoaiCongViec loaiCongViec;
    private ChuyenHang chuyenHang;

    public LoaiCongViec_ChuyenHangPK() {
    }

    public LoaiCongViec getLoaiCongViec() {
        return loaiCongViec;
    }

    public void setLoaiCongViec(LoaiCongViec loaiCongViec) {
        this.loaiCongViec = loaiCongViec;
    }

    public ChuyenHang getChuyenHang() {
        return chuyenHang;
    }

    public void setChuyenHang(ChuyenHang chuyenHang) {
        this.chuyenHang = chuyenHang;
    }
}
