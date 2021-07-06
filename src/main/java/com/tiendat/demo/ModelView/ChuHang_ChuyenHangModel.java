package com.tiendat.demo.ModelView;

import java.math.BigInteger;
import java.util.Map;

public class ChuHang_ChuyenHangModel {

    public static final String Id_Chu_Hang = "idChuHang";
    public static final String Id_Chuyen_Hang = "idChuyenHang";

    private Long idChuHang;
    private Long idChuyenHang;

    public ChuHang_ChuyenHangModel(Map<String, Object> values) {
        this.idChuHang = values.get(Id_Chu_Hang) != null ? ((BigInteger) values.get(Id_Chu_Hang)).longValue() : null;
        this.idChuyenHang = values.get(Id_Chuyen_Hang) != null ? ((BigInteger) values.get(Id_Chuyen_Hang)).longValue() : null;

    }

    public Long getIdChuHang() {
        return idChuHang;
    }

    public void setIdChuHang(Long idChuHang) {
        this.idChuHang = idChuHang;
    }

    public Long getIdChuyenHang() {
        return idChuyenHang;
    }

    public void setIdChuyenHang(Long idChuyenHang) {
        this.idChuyenHang = idChuyenHang;
    }
}
