package com.tiendat.demo.Respository;

import com.tiendat.demo.Model.*;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface LoaiChiHoContHangRespository extends CrudRepository<LoaiChiHo_ContHang, LoaiChiHo_ContHangPK> {

    List<LoaiChiHo_ContHang> findAllByContHang(ContHang contHang);

    @Modifying
    @Query(nativeQuery = true,value = "delete loai_chi_ho_cont_hang \n" +
            "where cont_hang_id = :idContHang")
    void DeleteByIdContHang(@Param("idContHang") Long id);

}
