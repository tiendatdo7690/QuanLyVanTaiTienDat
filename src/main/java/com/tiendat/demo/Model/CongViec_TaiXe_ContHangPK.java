package com.tiendat.demo.Model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class CongViec_TaiXe_ContHangPK implements Serializable {

    @Column(name = "cont_hang_id")
    private Long conthangid;

    @Column(name = "cong_Viec_id")
    private Long congviecid;

    public CongViec_TaiXe_ContHangPK() {
    }

    public CongViec_TaiXe_ContHangPK(Long conthangid, Long congviecid) {
        this.conthangid = conthangid;
        this.congviecid = congviecid;
    }

    public Long getConthangid() {
        return conthangid;
    }

    public void setConthangid(Long conthangid) {
        this.conthangid = conthangid;
    }

    public Long getCongviecid() {
        return congviecid;
    }

    public void setCongviecid(Long congviecid) {
        this.congviecid = congviecid;
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
        return c.getCongviecid() == this.congviecid
                && c.getConthangid() == this.conthangid;
    }
    @Override
    public int hashCode(){

        return 0;
    }
}
