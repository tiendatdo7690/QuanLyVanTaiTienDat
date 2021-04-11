package com.tiendat.demo.Respository;

import com.tiendat.demo.Model.LoaiChiHo;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface LoaiChiHoRespository extends CrudRepository<LoaiChiHo, Long> {
    List<LoaiChiHo> findAllBy();
}
