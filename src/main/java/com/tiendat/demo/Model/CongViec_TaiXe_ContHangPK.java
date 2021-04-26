package com.tiendat.demo.Model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class CongViec_TaiXe_ContHangPK implements Serializable {

    @Column(name = "cont_hang_id")
    private Long conthangid;

    @Column(name = "tai_xe_id")
    private Long taixeid;

    @Column(name = "LoaiCongViec_ChuyenHang_id")
    private LoaiCongViec_ChuyenHangPK loaiCongViec_ChuyenHangId;

    public CongViec_TaiXe_ContHangPK() {
    }

    public CongViec_TaiXe_ContHangPK(Long conthangid, Long taixeid, LoaiCongViec_ChuyenHangPK loaiCongViec_ChuyenHangId) {
        this.conthangid = conthangid;
        this.taixeid = taixeid;
        this.loaiCongViec_ChuyenHangId = loaiCongViec_ChuyenHangId;
    }

    public Long getTaixeid() {
        return taixeid;
    }

    public void setTaixeid(Long taixeid) {
        this.taixeid = taixeid;
    }

    public LoaiCongViec_ChuyenHangPK getLoaiCongViec_ChuyenHangId() {
        return loaiCongViec_ChuyenHangId;
    }

    public void setLoaiCongViec_ChuyenHangId(LoaiCongViec_ChuyenHangPK loaiCongViec_ChuyenHangId) {
        this.loaiCongViec_ChuyenHangId = loaiCongViec_ChuyenHangId;
    }

    public Long getConthangid() {
        return conthangid;
    }

    public void setConthangid(Long conthangid) {
        this.conthangid = conthangid;
    }


    @Override
    public boolean equals(Object obj) {

        if (obj == this) {
            return true;
        }

        /* Check if o is an instance of Complex or not
          "null instanceof [type]" also returns false */
        if (!(obj instanceof CongViec_TaiXe_ContHangPK)) {
            return false;
        }

        // typecast o to Complex so that we can compare data members
        CongViec_TaiXe_ContHangPK c = (CongViec_TaiXe_ContHangPK) obj;

        // Compare the data members and return accordingly
        return c.getLoaiCongViec_ChuyenHangId() == this.loaiCongViec_ChuyenHangId
                && c.getConthangid() == this.conthangid;
    }
    @Override
    public int hashCode(){

        return 0;
    }
}
