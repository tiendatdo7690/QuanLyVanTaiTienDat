package com.tiendat.demo.Respository;

import com.tiendat.demo.Model.LoaiChiHo;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface LoaiChiHoRespository extends CrudRepository<LoaiChiHo, Long> {
    List<LoaiChiHo> findAllBy();

    @Query(value = "select  lch\n" +
            "from LoaiChiHo lch \n" +
            " where lch.id not in (:dsIdLoaiChiHo) \n")
    List<LoaiChiHo> LayDsLoaiChiHoChuaDuocChon(@Param("dsIdLoaiChiHo") List<Long> dsIdLoaiChiHo);

    @Query(value = "select  lch\n" +
            "from ContHang conthang \n" +
            " inner join LoaiChiHo_ContHang lch_ch on conthang.id = lch_ch.contHang.id\n" +
            " inner join LoaiChiHo lch on lch.id = lch_ch.loaiChiHo.id\n" +
            " where conthang.id = :idContHang \n")
    List<LoaiChiHo> LayDsLoaiChiHoChuaDuocChon1(@Param("idContHang") Long idContHang);

    LoaiChiHo findTop1ByTen(String ten);
}
