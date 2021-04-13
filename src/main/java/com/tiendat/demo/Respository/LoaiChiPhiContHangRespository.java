package com.tiendat.demo.Respository;

import com.tiendat.demo.Model.LoaiChiPhiContHang;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface LoaiChiPhiContHangRespository extends CrudRepository<LoaiChiPhiContHang, Long> {
    List<LoaiChiPhiContHang> findAllBy();
}
