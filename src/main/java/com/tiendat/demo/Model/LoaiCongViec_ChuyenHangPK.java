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

    public LoaiCongViec_ChuyenHangPK(Long loaiCongViecId, Long chuyenHangId) {
        this.loaiCongViecId = loaiCongViecId;
        this.chuyenHangId = chuyenHangId;
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
        if (obj == this) {
            return true;
        }

        /* Check if o is an instance of Complex or not
          "null instanceof [type]" also returns false */
        if (!(obj instanceof LoaiCongViec_ChuyenHangPK)) {
            return false;
        }

        // typecast o to Complex so that we can compare data members
        LoaiCongViec_ChuyenHangPK c = (LoaiCongViec_ChuyenHangPK) obj;

        // Compare the data members and return accordingly
        return c.getChuyenHangId() == this.chuyenHangId
                && c.getLoaiCongViecId() == this.loaiCongViecId;
    }
    @Override
    public int hashCode(){

        return 0;
    }
}
