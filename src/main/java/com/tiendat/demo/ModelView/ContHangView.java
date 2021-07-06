package com.tiendat.demo.ModelView;

import java.math.BigInteger;
import java.sql.Date;
import java.util.List;
import java.util.Map;

public class ContHangView {

    public static final String Id = "id";
    public static final String Ngay = "ngay";
    public static final String So_Cont = "socont";
    public static final String Ten_Chuyen = "tenchuyen";
    public static final String Ten_Cang_Lay = "tencanglay";
    public static final String Ten_Cang_Ha = "tencangha";
    public static final String So_Xe = "soxe";
    public static final String Ten_Chi_Phi = "tenchiphi";
    public static final String Chi_Phi = "tien";
    public static final String Gia_Cuoc = "giacuoc";
    public static final String Loai_Chi_Ho = "loaichiho";


    private int stt;
    private Long id_ContHang;
    private Date ngay;
    private String soCont;
    private String chuyen;
    private String cangLay;
    private String cangHa;
    private String soXe;
    private String tenChiPhi;
    private Long chiPhi;
    private Long giaCuoc;
    private Long hoaDonNang;
    private Long hoaDonHa;

    public ContHangView(Map<String, Object> values) {
        this.id_ContHang = values.get(Id) != null ? ((BigInteger) values.get(Id)).longValue(): null;
        this.soCont = values.get(So_Cont) != null ? (String) values.get(So_Cont): null;
        this.ngay = values.get(Ngay) != null ? (Date) values.get(Ngay): null;
        this.chuyen = values.get(Ten_Chuyen) != null ? (String) values.get(Ten_Chuyen): null;
        this.cangLay = values.get(Ten_Cang_Lay) != null ? (String) values.get(Ten_Cang_Lay): null;
        this.cangHa = values.get(Ten_Cang_Ha) != null ? (String) values.get(Ten_Cang_Ha): null;
        this.soXe = values.get(So_Xe) != null ? (String) values.get(So_Xe): null;
        this.giaCuoc = values.get(Gia_Cuoc) != null ? ((BigInteger) values.get(Gia_Cuoc)).longValue(): null;
    }

    public void GanGiaTriPhiChiHo(List<Map<String, Object>> values){
        this.chiPhi = Long.valueOf(0);
        this.tenChiPhi = "";
        for (Map<String, Object> value : values) {
            String loaiChiHo = value.get(Loai_Chi_Ho) != null ? (String) value.get(Loai_Chi_Ho) : null;
            Long tien = value.get(Chi_Phi) != null ? ((BigInteger) value.get(Chi_Phi)).longValue() : 0;
            System.out.println("Loai chi Hộ: "+loaiChiHo);
            System.out.println("Tiền: "+tien);
            if( loaiChiHo.contains("Lấy") ) {
                this.hoaDonNang = tien;
            }
            else if( loaiChiHo.contains("Hạ") ){
                this.hoaDonHa = tien;
            }
            else {
                this.chiPhi = this.chiPhi + tien;
                this.tenChiPhi = this.tenChiPhi + loaiChiHo + "+";
            }

        }

    }
    public int getStt() {
        return stt;
    }

    public void setStt(int stt) {
        this.stt = stt;
    }

    public Date getNgay() {
        return ngay;
    }

    public void setNgay(Date ngay) {
        this.ngay = ngay;
    }

    public String getSoCont() {
        return soCont;
    }

    public void setSoCont(String soCont) {
        this.soCont = soCont;
    }

    public String getChuyen() {
        return chuyen;
    }

    public void setChuyen(String chuyen) {
        this.chuyen = chuyen;
    }

    public String getCangLay() {
        return cangLay;
    }

    public void setCangLay(String cangLay) {
        this.cangLay = cangLay;
    }

    public String getCangHa() {
        return cangHa;
    }

    public void setCangHa(String cangHa) {
        this.cangHa = cangHa;
    }

    public String getSoXe() {
        return soXe;
    }

    public void setSoXe(String soXe) {
        this.soXe = soXe;
    }

    public String getTenChiPhi() {
        return tenChiPhi;
    }

    public void setTenChiPhi(String tenChiPhi) {
        this.tenChiPhi = tenChiPhi;
    }

    public Long getChiPhi() {
        return chiPhi;
    }

    public void setChiPhi(Long chiPhi) {
        this.chiPhi = chiPhi;
    }

    public Long getGiaCuoc() {
        return giaCuoc;
    }

    public void setGiaCuoc(Long giaCuoc) {
        this.giaCuoc = giaCuoc;
    }

    public Long getHoaDonNang() {
        return hoaDonNang;
    }

    public void setHoaDonNang(Long hoaDonNang) {
        this.hoaDonNang = hoaDonNang;
    }

    public Long getHoaDonHa() {
        return hoaDonHa;
    }

    public void setHoaDonHa(Long hoaDonHa) {
        this.hoaDonHa = hoaDonHa;
    }

    public Long getId_ContHang() {
        return id_ContHang;
    }

    public void setId_ContHang(Long id_ContHang) {
        this.id_ContHang = id_ContHang;
    }


}
