package com.tiendat.demo.Model;

import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "LoaiChiHo")
public class LoaiChiHo implements Serializable {

    private static final long serialVersionUID = 2139852422137092648L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Long id;

    @Type(type="org.hibernate.type.StringNVarcharType")
    @Column(name = "ten", length = 255)
    private String ten;

    @OneToMany(fetch = FetchType.LAZY,
            cascade = {CascadeType.MERGE,CascadeType.DETACH,CascadeType.REFRESH},
            mappedBy = "loaiChiHo")
    private Set<ChiHo> chiHoSet = new HashSet<ChiHo>();

    public LoaiChiHo() {
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

    public Set<ChiHo> getChiHoSet() {
        return chiHoSet;
    }

    public void setChiHoSet(Set<ChiHo> chiHoSet) {
        this.chiHoSet = chiHoSet;
    }
}
