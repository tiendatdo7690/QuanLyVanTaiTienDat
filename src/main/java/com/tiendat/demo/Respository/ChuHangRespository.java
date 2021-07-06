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

	@Query(nativeQuery = true,value = "EXEC LayDsCongViecCuaContHang " +
			"@IdContHang = :idConthang")
	List<Map<String, Object>> LayDsCongViecCuaContHang(@Param("idConthang")Long idContHang);
}