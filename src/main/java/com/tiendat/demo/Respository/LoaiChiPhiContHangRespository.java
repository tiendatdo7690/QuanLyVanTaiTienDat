package com.tiendat.demo.Respository;

import com.tiendat.demo.Model.LoaiChiPhiContHang;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface LoaiChiPhiContHangRespository extends CrudRepository<LoaiChiPhiContHang, Long> {
    List<LoaiChiPhiContHang> findAllBy();

    @Query(value = "select  lcp\n" +
            "from LoaiChiPhiContHang lcp \n" +
            " where lcp.id not in (:dsIdLoaiChiPhi) \n")
    List<LoaiChiPhiContHang> LayDsLoaiChiPhiContHangChuaDuocChon(
            @Param("dsIdLoaiChiPhi") List<Long> idloaiChiPhiContHangs1);



    //List<LoaiChiPhiContHang> findAllByContH
}
