package com.tiendat.demo.ModelView;

public class CongViecTX {

    private String tenTx;
    private String tenCV;
    private Long tienTX;

    public CongViecTX() {
    }

    public CongViecTX(String tenTx, String tenCV, Long tienTX) {
        this.tenTx = tenTx;
        this.tenCV = tenCV;
        this.tienTX = tienTX;
    }

    public String getTenTx() {
        return tenTx;
    }

    public void setTenTx(String tenTx) {
        this.tenTx = tenTx;
    }

    public String getTenCV() {
        return tenCV;
    }

    public void setTenCV(String tenCV) {
        this.tenCV = tenCV;
    }

    public Long getTienTX() {
        return tienTX;
    }

    public void setTienTX(Long tienTX) {
        this.tienTX = tienTX;
    }
}
