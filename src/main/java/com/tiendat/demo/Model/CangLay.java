package com.tiendat.demo.Model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@DiscriminatorValue("CangLay")
public class CangLay extends Cang{

    @OneToMany(fetch = FetchType.LAZY,
            cascade = {CascadeType.MERGE,CascadeType.DETACH,CascadeType.REFRESH},
            mappedBy = "cangLay")
    private Set<ContHang> contHangHashSet = new HashSet<ContHang>();


    public CangLay() {
    }

    public CangLay(Long id, String ten, String diaChi, String soDienThoai, String eMail, String loai, boolean trangThai) {
        super(id, ten, diaChi, soDienThoai, eMail, loai, trangThai);
    }

    public Set<ContHang> getContHangHashSet() {
        return contHangHashSet;
    }

    public void setContHangHashSet(Set<ContHang> contHangHashSet) {
        this.contHangHashSet = contHangHashSet;
    }
}
