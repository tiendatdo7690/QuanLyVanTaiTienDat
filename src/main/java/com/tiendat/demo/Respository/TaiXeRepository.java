package com.tiendat.demo.Respository;

import com.tiendat.demo.Model.TaiXe;
import com.tiendat.demo.Model.TienTaiXe;
import com.tiendat.demo.ModelView.ChuyenHangTaiXe;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;
import java.util.List;
import java.util.Map;

public interface TaiXeRepository extends CrudRepository<TaiXe, Long> {
    List<TaiXe> findAllByTrangThaiTrue();
    List<TaiXe> findAllByTenLikeAndTrangThai(String ten,Boolean trangThai);

    @Query(nativeQuery = true,value = "EXEC TimKiemChuyenHangTxChayTuNgayDenNgay " +
            "@IdTX = :idTX, @TuNgay = :tungay, @DenNgay = :denngay")
    List<Map<String, Object>> TimKiemChuyenHangTxChayTuNgayDenNgay(@Param("idTX")Long idTx,@Param("tungay")Date tungay
    ,@Param("denngay") Date denngay);

//    @Transactional
//    @Procedure(procedureName = "coutx")
    @Query(value = "EXEC coutx", nativeQuery = true)
    int DemSoLuongTx();

   // List<TienTaiXe> findAllBy
}
