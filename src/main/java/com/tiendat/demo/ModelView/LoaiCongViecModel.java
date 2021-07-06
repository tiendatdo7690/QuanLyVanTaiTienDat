package com.tiendat.demo.ModelView;

import java.math.BigInteger;
import java.util.Map;

public class LoaiCongViecModel {

    public static final String Id_LoaiCongViec = "id";
    public static final String Nguyen_Chuyen = "nguyenchuyen";
    public static final String Ten = "ten";

    private Long idLoaiCongViec;
    private Character nguyenChuyen;
    private String ten;

    public LoaiCongViecModel(Map<String, Object> values) {
        this.idLoaiCongViec = values.get(Id_LoaiCongViec) != null ? ((BigInteger) values.get(Id_LoaiCongViec)).longValue() : null;
        this.ten = values.get(Ten) != null ? (String) values.get(Ten) : null;
        this.nguyenChuyen = values.get(Nguyen_Chuyen) != null ? (Character) values.get(Nguyen_Chuyen) : null;

    }

    public LoaiCongViecModel() {
    }

    public Long getIdLoaiCongViec() {
        return idLoaiCongViec;
    }

    public void setIdLoaiCongViec(Long idLoaiCongViec) {
        this.idLoaiCongViec = idLoaiCongViec;
    }

    public Character getNguyenChuyen() {
        return nguyenChuyen;
    }

    public void setNguyenChuyen(Character nguyenChuyen) {
        this.nguyenChuyen = nguyenChuyen;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    @Override
    public String toString() {
        return ten;
    }
}
