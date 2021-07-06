package com.tiendat.demo.ModelView;

import com.tiendat.demo.Model.LoaiCongViec;
import com.tiendat.demo.Model.LoaiCongViec_ChuyenHang;
import com.tiendat.demo.Model.TaiXe;

import java.math.BigInteger;
import java.util.Map;

public class CongViecTX {

    public static final String Ten_Tai_Xe = "tentaixe";
    public static final String Ten_Cong_Viec = "tencv";
    public static final String Tien_Tx = "tientx";
    public static final String Id_Tai_Xe = "idTaiXe";
    public static final String Id_Chuyen_Hang = "idChuyenHang";


    private LoaiCongViec_ChuyenHang loaiCongViec_chuyenHang;
    private TaiXe taiXe;
    private LoaiCongViecModel loaiCongViec;

    private String tenCongViec;
    private String tenTaiXe;
    private Long tientx;
    private Long idTaiXe;
    private Long idChuyenHang;


    public CongViecTX() {
    }

    public CongViecTX(Map<String, Object> values) {

        loaiCongViec = new LoaiCongViecModel();
        loaiCongViec_chuyenHang = new LoaiCongViec_ChuyenHang();
        this.loaiCongViec.setIdLoaiCongViec(values.get(LoaiCongViecModel.Id_LoaiCongViec) != null ?
                ((BigInteger) values.get(LoaiCongViecModel.Id_LoaiCongViec)).longValue() : null);
        this.loaiCongViec.setTen(values.get(LoaiCongViecModel.Ten) != null ?
                (String) values.get(LoaiCongViecModel.Ten) : null);
        this.loaiCongViec.setNguyenChuyen(values.get(LoaiCongViecModel.Nguyen_Chuyen) != null ?
                (Character) values.get(LoaiCongViecModel.Nguyen_Chuyen) : null);


        this.tenCongViec = values.get(Ten_Cong_Viec) != null ? (String) values.get(Ten_Cong_Viec): null;
        this.tenTaiXe = values.get(Ten_Tai_Xe) != null ? (String) values.get(Ten_Tai_Xe): null;
        this.tientx = values.get(Tien_Tx) != null ? ((BigInteger) values.get(Tien_Tx)).longValue() : null;
        this.idTaiXe = values.get(Id_Tai_Xe) != null ? ((BigInteger) values.get(Id_Tai_Xe)).longValue() : null;
        this.idChuyenHang = values.get(Id_Chuyen_Hang) != null ? ((BigInteger) values.get(Id_Chuyen_Hang)).longValue() : null;

    }


    public CongViecTX(LoaiCongViec_ChuyenHang congViec, TaiXe taiXe) {
        this.loaiCongViec_chuyenHang = congViec;
        this.taiXe = taiXe;
    }

    public Long getIdChuyenHang() {
        return idChuyenHang;
    }

    public void setIdChuyenHang(Long idChuyenHang) {
        this.idChuyenHang = idChuyenHang;
    }

    public String getTenCongViec() {
        return tenCongViec;
    }

    public void setTenCongViec(String tenCongViec) {
        this.tenCongViec = tenCongViec;
    }

    public String getTenTaiXe() {
        return tenTaiXe;
    }

    public void setTenTaiXe(String tenTaiXe) {
        this.tenTaiXe = tenTaiXe;
    }

    public Long getTientx() {
        return tientx;
    }

    public void setTientx(Long tientx) {
        this.tientx = tientx;
    }

    public LoaiCongViecModel getLoaiCongViec() {
        return loaiCongViec;
    }

    public void setLoaiCongViec(LoaiCongViecModel loaiCongViec) {
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
        return loaiCongViec_chuyenHang.getTienTaiXeSet().iterator().next().getTien();
    }


    public LoaiCongViecModel getE(){
        return loaiCongViec;
    }

    public Long getIdTaiXe() {
        return idTaiXe;
    }

    public void setIdTaiXe(Long idTaiXe) {
        this.idTaiXe = idTaiXe;
    }
}
