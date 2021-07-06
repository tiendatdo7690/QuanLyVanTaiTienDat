package com.tiendat.demo.Respository;

import com.tiendat.demo.Model.ChiPhiContHang_ContHang;
import com.tiendat.demo.Model.ChiPhiContHang_ContHangPK;
import com.tiendat.demo.Model.ContHang;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ChiPhiContHangContHangRespository extends CrudRepository<ChiPhiContHang_ContHang, ChiPhiContHang_ContHangPK> {

    public List<ChiPhiContHang_ContHang> findAllByContHang(ContHang contHang);


    @Modifying
    @Query(nativeQuery = true,value = "delete chi_phi_cont_hang_cont_hang \n" +
            "where cont_hang_id = :idContHang")
    void DeleteByIdContHang(@Param("idContHang") Long id);
}
