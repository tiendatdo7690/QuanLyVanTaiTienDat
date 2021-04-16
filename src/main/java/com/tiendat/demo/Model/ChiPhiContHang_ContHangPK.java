package com.tiendat.demo.Model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class ChiPhiContHang_ContHangPK implements Serializable {

    @Column(name = "id_Chi_Phi_Cont_Hang")
    private Long idChiPhiContHang;

    @Column(name = "id_Cont_Hang")
    private Long idContHang;

    public ChiPhiContHang_ContHangPK() {
    }

    public Long getIdChiPhiContHang() {
        return idChiPhiContHang;
    }

    public void setIdChiPhiContHang(Long idChiPhiContHang) {
        this.idChiPhiContHang = idChiPhiContHang;
    }

    public Long getIdContHang() {
        return idContHang;
    }

    public void setIdContHang(Long idContHang) {
        this.idContHang = idContHang;
    }
}
