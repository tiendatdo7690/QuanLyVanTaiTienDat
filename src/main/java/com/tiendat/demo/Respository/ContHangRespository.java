package com.tiendat.demo.Respository;

import com.tiendat.demo.Model.ContHang;
import com.tiendat.demo.Model.LoaiCongViec;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Map;

public interface ContHangRespository extends CrudRepository<ContHang, Long> {

    List<ContHang> findAllBySoContLike(String soCont);

    @Query(nativeQuery = true,value = "select distinct chuhang.id as idChuHang , chuyenhang.id as idChuyenHang\n" +
            "from cont_hang ch inner join cong_viec_tai_xe_cont_hang cv_tx_ch on ch.id = cv_tx_ch.cont_hang_id\n" +
            "inner join loai_cong_viec_chuyen_hang lcv_ch on " +
            "lcv_ch.chuyen_hang_id = cv_tx_ch.loai_cong_viec_chuyen_hang_chuyen_hang_id and lcv_ch.loai_cong_viec_id = cv_tx_ch.loai_cong_viec_chuyen_hang_loai_cong_viec_id\n" +
            "inner join chuyen_hang chuyenhang on chuyenhang.id = lcv_ch.chuyen_hang_id\n" +
            "inner join chu_hang chuhang on chuhang.id = chuyenhang.chu_hang_id\n" +
            "where ch.id = :idConthang")
    Map<String, Object> LayTenChuHangVaChuyenHangTheoIdContHang(@Param("idConthang")Long idContHang);

    @Query(nativeQuery = true,value = "select distinct lcv.id as idLoaiCongViec, lcv.nguyen_chuyen_hang as nguyenchuyen, lcv.ten as ten\n" +
            "from loai_cong_viec lcv inner join loai_cong_viec_chuyen_hang lcv_ch on lcv.id = lcv_ch.loai_cong_viec_id\n" +
            "inner join chuyen_hang chuyenhang on chuyenhang.id = lcv_ch.chuyen_hang_id\n" +
            "inner join chu_hang chuhang on chuyenhang.chu_hang_id = chuhang.id\n" +
            "inner join cong_viec_tai_xe_cont_hang cv_tx_ch on cv_tx_ch.loai_cong_viec_chuyen_hang_chuyen_hang_id = lcv_ch.chuyen_hang_id \n" +
            "and cv_tx_ch.loai_cong_viec_chuyen_hang_loai_cong_viec_id = lcv_ch.loai_cong_viec_id\n" +
            "where chuhang.id = :idChuHang and lcv.id not in(\n" +
            "select lcv.id\n" +
            "from loai_cong_viec lcv inner join loai_cong_viec_chuyen_hang lcv_ch on lcv.id = lcv_ch.loai_cong_viec_id\n" +
            "inner join cong_viec_tai_xe_cont_hang cv_tx_ch on cv_tx_ch.loai_cong_viec_chuyen_hang_chuyen_hang_id = lcv_ch.chuyen_hang_id \n" +
            "and cv_tx_ch.loai_cong_viec_chuyen_hang_loai_cong_viec_id = lcv_ch.loai_cong_viec_id\n" +
            "inner join cont_hang ch on ch.id = cv_tx_ch.cont_hang_id\n" +
            "where ch.id = :idConthang\n" +
            ")")
    List<Map<String, Object>> LayDsCongViecChuaDuocChonCuaContHang(@Param("idConthang")Long idContHang,
                                                                   @Param("idChuHang")Long idChuHang);

}
