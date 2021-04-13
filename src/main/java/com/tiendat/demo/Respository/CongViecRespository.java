package com.tiendat.demo.Respository;

import com.tiendat.demo.Model.ChuyenHang;
import com.tiendat.demo.Model.CongViec;
import com.tiendat.demo.Model.LoaiCongViec;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface CongViecRespository extends CrudRepository<CongViec, Long> {

    @Query(value = "select  cv\n" +
            "from LoaiCongViec lcv\n" +
            "inner join LoaiCongViec_ChuyenHang lcv_ch on lcv.id = lcv_ch.loaiCongViec.id\n" +
            "inner join ChuyenHang ch on ch.id = lcv_ch.chuyenHang.id\n" +
            "inner join CongViec cv on cv.id = lcv_ch.congViec.id\n" +
            " where lcv_ch.chuyenHang = :chuyenHang and lcv_ch.loaiCongViec = :loaiCV \n")
    CongViec layCVBangChuyenHangVaLoaiCV(@Param("chuyenHang") ChuyenHang chuyenHang,@Param("loaiCV") LoaiCongViec loaiCV);
}
