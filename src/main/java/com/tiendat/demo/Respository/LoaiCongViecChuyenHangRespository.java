package com.tiendat.demo.Respository;

import com.tiendat.demo.Model.ChuyenHang;
import com.tiendat.demo.Model.LoaiCongViec_ChuyenHang;
import com.tiendat.demo.Model.LoaiCongViec_ChuyenHangPK;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface LoaiCongViecChuyenHangRespository extends CrudRepository<LoaiCongViec_ChuyenHang, LoaiCongViec_ChuyenHangPK> {

    List<LoaiCongViec_ChuyenHang> findAllByChuyenHang(ChuyenHang chuyenHang);

    @Query(value = "select lcv_ch \n" +
            "from LoaiCongViec_ChuyenHang lcv_ch \n" +
            "where lcv_ch.chuyenHang.id = :idChuyenHang and lcv_ch.loaiCongViec.nguyenChuyenHang = true ")
    LoaiCongViec_ChuyenHang findByNguyenChuyenHangAndChuyenHang(@Param("idChuyenHang") Long id);
}
