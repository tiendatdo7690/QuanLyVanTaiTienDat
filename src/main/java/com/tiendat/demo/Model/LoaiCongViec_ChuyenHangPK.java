package com.tiendat.demo.Model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class LoaiCongViec_ChuyenHangPK implements Serializable {

    @Column(name = "Loai_Cong_Viec_id")
    private Long loaiCongViecId;

    @Column(name = "Chuyen_Hang_id")
    private Long chuyenHangId;

    public LoaiCongViec_ChuyenHangPK() {
    }

    public Long getLoaiCongViecId() {
        return loaiCongViecId;
    }

    public void setLoaiCongViecId(Long loaiCongViecId) {
        this.loaiCongViecId = loaiCongViecId;
    }

    public Long getChuyenHangId() {
        return chuyenHangId;
    }

    public void setChuyenHangId(Long chuyenHangId) {
        this.chuyenHangId = chuyenHangId;
    }

    @Override
    public boolean equals(Object obj) {
        return false;
    }
    @Override
    public int hashCode(){

        return 0;
    }
}
