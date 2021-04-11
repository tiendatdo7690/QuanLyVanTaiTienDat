package com.tiendat.demo.Model;

import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "LoaiHang")
public class LoaiHang implements Serializable {

    private static final long serialVersionUID = 3865219319250687882L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Long id;

    @Type(type="org.hibernate.type.StringNVarcharType")
    @Column(name = "ten", length = 255)
    private String ten;

    @OneToMany(fetch = FetchType.LAZY,
            cascade = {CascadeType.MERGE,CascadeType.DETACH,CascadeType.REFRESH},
            mappedBy = "loaiHang")
    private Set<ContHang> contHangSet = new HashSet<ContHang>();

    public LoaiHang() {
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

    public Set<ContHang> getContHangSet() {
        return contHangSet;
    }

    public void setContHangSet(Set<ContHang> contHangSet) {
        this.contHangSet = contHangSet;
    }

    @Override
    public String toString() {
        return ten;
    }
}
