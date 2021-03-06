package com.tiendat.demo.Model;

import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "LoaiChiPhiContHang")
public class LoaiChiPhiContHang implements Serializable {

    private static final long serialVersionUID = 5989629596905147014L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Long id;

    @Type(type="org.hibernate.type.StringNVarcharType")
    @Column(name = "ten", length = 255)
    private String ten;

    @OneToMany(fetch = FetchType.LAZY,
            cascade = {CascadeType.MERGE,CascadeType.DETACH,CascadeType.REFRESH},
            mappedBy = "loaiChiPhiContHang")
    private Set<ChiPhiContHang_ContHang> chiPhiContHangContHangSet = new HashSet<ChiPhiContHang_ContHang>();

    public LoaiChiPhiContHang() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public Set<ChiPhiContHang_ContHang> getChiPhiContHangContHangSet() {
        return chiPhiContHangContHangSet;
    }

    public void setChiPhiContHangContHangSet(Set<ChiPhiContHang_ContHang> chiPhiContHangContHangSet) {
        this.chiPhiContHangContHangSet = chiPhiContHangContHangSet;
    }

    @Override
    public String toString() {
        return ten;
    }
}
