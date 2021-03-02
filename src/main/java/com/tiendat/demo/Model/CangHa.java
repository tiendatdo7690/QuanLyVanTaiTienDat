package com.tiendat.demo.Model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@DiscriminatorValue("CangHa")
public class CangHa  extends Cang{

    @OneToMany(fetch = FetchType.LAZY,
            cascade = {CascadeType.MERGE,CascadeType.DETACH,CascadeType.REFRESH},
            mappedBy = "cangHa")
    private Set<ContHang> contHangHaSet = new HashSet<ContHang>();

    public CangHa() {
    }

    public CangHa(Long id, String ten, String diaChi, String soDienThoai, String eMail, boolean trangThai) {
        super(id, ten, diaChi, soDienThoai, eMail, trangThai);
    }

    public CangHa(Long id, String ten, String diaChi, String soDienThoai, String eMail, boolean trangThai, Set<ContHang> contHangHaSet) {
        super(id, ten, diaChi, soDienThoai, eMail, trangThai);
        this.contHangHaSet = contHangHaSet;
    }

    public Set<ContHang> getContHangHaSet() {
        return contHangHaSet;
    }

    public void setContHangHaSet(Set<ContHang> contHangHaSet) {
        this.contHangHaSet = contHangHaSet;
    }
}
