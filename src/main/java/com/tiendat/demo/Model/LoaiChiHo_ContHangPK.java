package com.tiendat.demo.Model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class LoaiChiHo_ContHangPK implements Serializable {

    @Column(name = "idLoaiChiHo")
    private Long idLoaiChiHo;

    @Column(name = "idLoaiChiHo")
    private Long idConHang;

    public LoaiChiHo_ContHangPK() {
    }

    public Long getIdLoaiChiHo() {
        return idLoaiChiHo;
    }

    public void setIdLoaiChiHo(Long idLoaiChiHo) {
        this.idLoaiChiHo = idLoaiChiHo;
    }

    public Long getIdConHang() {
        return idConHang;
    }

    public void setIdConHang(Long idConHang) {
        this.idConHang = idConHang;
    }
}
