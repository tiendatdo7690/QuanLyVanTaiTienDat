package com.tiendat.demo.Model;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "LoaiCongViec_ChuyenHang")
public class LoaiCongViec_ChuyenHang implements Serializable {

    @EmbeddedId
    private  LoaiCongViec_ChuyenHangPK id;

    @MapsId("loaiCongViecId")
    @ManyToOne(fetch = FetchType.LAZY,
            cascade = {CascadeType.MERGE,CascadeType.DETACH,CascadeType.REFRESH})
    @JoinColumn(name = "LoaiCongViec_Id" , foreignKey= @ForeignKey(name = "Fk_LoaiCongViecCongViec_LoaiCongViec"), nullable = true)
    private LoaiCongViec loaiCongViec;

    @MapsId("chuyenHangId")
    @ManyToOne(fetch = FetchType.LAZY,
            cascade = {CascadeType.MERGE,CascadeType.DETACH,CascadeType.REFRESH})
    @JoinColumn(name = "Chuyen_Hang_Id" , foreignKey= @ForeignKey(name = "Fk_LoaiCongViecChuyenHang_ChuyenHang"), nullable = true)
    private ChuyenHang chuyenHang;

    @OneToMany(fetch = FetchType.LAZY,
            cascade = {CascadeType.MERGE,CascadeType.DETACH,CascadeType.REFRESH},
            mappedBy = "loaiCongViec_ChuyenHang")
    private Set<TienTaiXe> tienTaiXeSet = new HashSet<TienTaiXe>(0);


    public LoaiCongViec_ChuyenHang() {
    }


    public LoaiCongViec_ChuyenHangPK getId() {
        return id;
    }

    public void setId(LoaiCongViec_ChuyenHangPK id) {
        this.id = id;
    }

    public LoaiCongViec getLoaiCongViec() {
        return loaiCongViec;
    }

    public void setLoaiCongViec(LoaiCongViec loaiCongViec) {
        this.loaiCongViec = loaiCongViec;
    }

    public ChuyenHang getChuyenHang() {
        return chuyenHang;
    }

    public void setChuyenHang(ChuyenHang chuyenHang) {
        this.chuyenHang = chuyenHang;
    }

    public String getTen(){
        return loaiCongViec.getTen();
    }

    public Set<TienTaiXe> getTienTaiXeSet() {
        return tienTaiXeSet;
    }

    public void setTienTaiXeSet(Set<TienTaiXe> tienTaiXeSet) {
        this.tienTaiXeSet = tienTaiXeSet;
    }

    public Boolean getNguyenChuyen(){
        return loaiCongViec.isNguyenChuyenHang();
    }

    public Long LayRaTienTaiXeGanNhatTheoNgay(Date ngay){

        Long thoiGianNganNhat = TinhThoiGianNganNhat(ngay);
       // System.out.println("Thoi"thoiGianNganNhat);
        for(TienTaiXe tienTaiXe : tienTaiXeSet){
            Long khoangThoiGian = TinhThoiGian(ngay,tienTaiXe.getNgay());
            if(TinhThoiGian(ngay,tienTaiXe.getNgay()).equals(thoiGianNganNhat)){
                return tienTaiXe.getTien();
            }
        }
        return Long.valueOf(0);
    }

    private  Long TinhThoiGianNganNhat(Date mocThoiGian){

        Long khoangThoiGianNganNhat = Long.MAX_VALUE;
        for(TienTaiXe tienTaiXe : tienTaiXeSet){
            Long khoangThoiGian = TinhThoiGian(mocThoiGian,tienTaiXe.getNgay());
            if(khoangThoiGian  != -1 && khoangThoiGian < khoangThoiGianNganNhat){
                khoangThoiGianNganNhat = khoangThoiGian;
            }
        }
        return khoangThoiGianNganNhat;
    }

    private Long TinhThoiGian(Date mocThoiGian,Date ngaytruoc){

        if(mocThoiGian.getTime() - ngaytruoc.getTime() < 0){
            return Long.valueOf(-1);
        }
        else {
            return mocThoiGian.getTime() - ngaytruoc.getTime();
        }
    }
    @Override
    public String toString() {
        return loaiCongViec.getTen();
    }
}
