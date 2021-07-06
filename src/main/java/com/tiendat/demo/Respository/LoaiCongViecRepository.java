package com.tiendat.demo.Respository;

import com.tiendat.demo.Model.ChuyenHang;
import com.tiendat.demo.Model.LoaiCongViec;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Map;


public interface LoaiCongViecRepository extends CrudRepository<LoaiCongViec, Long> {

    @Query(value = "select  lcv\n" +
            "from LoaiCongViec lcv\n" +
            " inner join LoaiCongViec_ChuyenHang lcv_ch on lcv.id = lcv_ch.loaiCongViec.id\n" +
            " where lcv_ch.chuyenHang = :chuyenHang \n")
    List<LoaiCongViec> layDSLoaiCV_ChuyenHang(@Param("chuyenHang") ChuyenHang chuyenHang);

    @Query(nativeQuery = true,value = "EXEC layDSLoaiCongViecModel " +
            "@IdChuyenHang = :idChuyenHang")
    List<Map<String, Object>> layDSLoaiCongViecModel(@Param("idChuyenHang") Long idChuyenHang);

    List<LoaiCongViec> findAllBy();

    @Query(value = "select lcv \n" +
            "from LoaiCongViec lcv inner join LoaiCongViec_ChuyenHang lcv_ch on lcv.id = lcv_ch.loaiCongViec.id \n " +
            "where lcv_ch.chuyenHang.id = : idChuyenHang and lcv.nguyenChuyenHang = true ")
    LoaiCongViec getNguyenChuyenHangCuaChuyenHang(@Param("idChuyenHang") Long id);
}
