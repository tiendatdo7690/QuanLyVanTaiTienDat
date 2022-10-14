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

    @Query(nativeQuery = true,value = "SELECT lcv.id as idLoaiCongViec, lcv.ten as ten, lcv.nguyen_chuyen_hang as nguyenChuyen\n" +
            "FROM (loai_cong_viec lcv inner join loai_cong_viec_chuyen_hang lcv_ch on lcv.id = lcv_ch.loai_cong_viec_id)\n" +
            "\t inner join chuyen_hang ch on ch.id = lcv_ch.chuyen_hang_id\n" +
            "where ch.id = :idChuyenHang ")
    List<Map<String, Object>> layDSLoaiCongViecModel(@Param("idChuyenHang") Long idChuyenHang);

    List<LoaiCongViec> findAllBy();

    @Query(value = "select lcv \n" +
            "from LoaiCongViec lcv inner join LoaiCongViec_ChuyenHang lcv_ch on lcv.id = lcv_ch.loaiCongViec.id \n " +
            "where lcv_ch.chuyenHang.id = : idChuyenHang and lcv.nguyenChuyenHang = true ")
    LoaiCongViec getNguyenChuyenHangCuaChuyenHang(@Param("idChuyenHang") Long id);
}
