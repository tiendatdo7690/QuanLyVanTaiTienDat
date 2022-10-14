package com.tiendat.demo.Respository;

import com.tiendat.demo.Model.ChuHang;
import com.tiendat.demo.Model.ChuyenHang;
import com.tiendat.demo.Model.LoaiCongViec;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.sql.Date;
import java.util.List;
import java.util.Map;

public interface ChuHangRespository extends CrudRepository<ChuHang, Long> {

	List<ChuHang> findByTenOrMaSoThue(String ten,String mst);

	List<ChuHang> findByTenLikeOrMaSoThueLike(String ten,String mst);

	List<ChuHang> findAllByTrangThaiTrue();


	@Query(nativeQuery = true,value = "EXEC ThongKeContHangTheoChuHangTheoNgay " +
			"@IdChuHang = :idChuHang, @TuNgay = :tungay, @DenNgay = :denngay")
	List<Map<String, Object>> ThongKeChuHangTheoNgay(@Param("idChuHang")Long idChuHang, @Param("tungay") Date tungay
			, @Param("denngay") Date denngay);

	@Query(nativeQuery = true,value = "EXEC LayDsChiHoTheoContHang " +
			"@IdContHang = :idConthang")
	List<Map<String, Object>> LayDsChiHoTheoContHang(@Param("idConthang")Long idContHang);

	@Query(value = "select distinct  chuhang\n" +
			"from ChuHang chuhang \n" +
			" inner join ChuyenHang chuyenhang on chuhang.id = chuyenhang.chuHang.id\n" +
			" inner join LoaiCongViec_ChuyenHang lcv_ch on lcv_ch.chuyenHang = chuyenhang " +
			" inner join CongViec_TaiXe_ContHang cv_tx_ch on " +
			"(cv_tx_ch.id.loaiCongViec_ChuyenHangId = lcv_ch.id)" +
			" where cv_tx_ch.contHang.id = :idContHang \n")
	ChuHang LayChuHangTuContHang(@Param("idContHang") Long idContHang);

	@Query(nativeQuery = true,value = "select tx.ten as tentaixe, lcv.ten as tencv, ttx.tien as tientx, tx.id as idTaiXe, chuyenhang.id as idChuyenHang, \n" +
			"lcv.id as idLoaiCongViec, lcv.ten as ten, lcv.nguyen_chuyen_hang as nguyenChuyen \n" +
			"from cont_hang ch inner join cong_viec_tai_xe_cont_hang cv_tx_ch on ch.id = cv_tx_ch.cont_hang_id\n" +
			"inner join loai_cong_viec_chuyen_hang lcv_ch on \n" +
			"lcv_ch.chuyen_hang_id = cv_tx_ch.loai_cong_viec_chuyen_hang_chuyen_hang_id and lcv_ch.loai_cong_viec_id = cv_tx_ch.loai_cong_viec_chuyen_hang_loai_cong_viec_id\n" +
			"inner join tai_xe tx on tx.id = cv_tx_ch.tai_xe_id\n" +
			"inner join loai_cong_viec lcv on lcv.id = lcv_ch.loai_cong_viec_id\n" +
			"inner join tien_tai_xe ttx on \n" +
			"ttx.loai_cong_viec_chuyen_hang_chuyen_hang_id = lcv_ch.chuyen_hang_id and ttx.loai_cong_viec_chuyen_hang_loai_cong_viec_id = lcv_ch.loai_cong_viec_id\n" +
			"inner join chuyen_hang chuyenhang on chuyenhang.id = lcv_ch.chuyen_hang_id\n" +
			"where ch.id = :idConthang and ttx.ngay = \n" +
			"( select max(ttx2.ngay)\n" +
			"from tien_tai_xe ttx2\n" +
			"where ttx2.loai_cong_viec_chuyen_hang_chuyen_hang_id = ttx.loai_cong_viec_chuyen_hang_chuyen_hang_id and \n" +
			"ttx2.loai_cong_viec_chuyen_hang_loai_cong_viec_id = ttx.loai_cong_viec_chuyen_hang_loai_cong_viec_id\n" +
			") ")
	List<Map<String, Object>> LayDsCongViecCuaContHang(@Param("idConthang")Long idContHang);
}