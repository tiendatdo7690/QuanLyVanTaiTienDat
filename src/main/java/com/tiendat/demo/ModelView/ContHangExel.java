package com.tiendat.demo.ModelView;

import java.sql.Date;

public class ContHangExel {

    private int stt;
    private Date ngay;
    private String soCont;
    private String chuyen;
    private String cangLay;
    private String cangHa;
    private String soXe;
    private Long giaCuoc;
    private Long hoaDonNang;
    private Long hoaDonHa;

    public ContHangExel(int stt, Date ngay, String soCont, String chuyen, String cangLay, String cangHa, String soXe,
                        Long giaCuoc, Long hoaDonNang, Long hoaDonHa) {
        this.stt = stt;
        this.ngay = ngay;
        this.soCont = soCont;
        this.chuyen = chuyen;
        this.cangLay = cangLay;
        this.cangHa = cangHa;
        this.soXe = soXe;
        this.giaCuoc = giaCuoc;
        this.hoaDonNang = hoaDonNang;
        this.hoaDonHa = hoaDonHa;
    }

    public ContHangExel() {
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
}
