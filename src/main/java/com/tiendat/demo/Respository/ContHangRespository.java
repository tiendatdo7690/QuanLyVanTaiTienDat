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

    @Query(nativeQuery = true,value = "EXEC LAYTENCHUHANGVACHUYENHANGTHEOIDCONTHANG " +
            "@IdContHang = :idConthang")
    Map<String, Object> LayTenChuHangVaChuyenHangTheoIdContHang(@Param("idConthang")Long idContHang);

    @Query(nativeQuery = true,value = "EXEC LayDsCongViecChuaDuocChonCuaContHang " +
            "@IdContHang = :idConthang,@IdChuHang = :idChuHang")
    List<Map<String, Object>> LayDsCongViecChuaDuocChonCuaContHang(@Param("idConthang")Long idContHang,
                                                                   @Param("idChuHang")Long idChuHang);

}
