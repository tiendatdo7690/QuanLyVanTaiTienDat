package com.tiendat.demo.Respository;

import com.tiendat.demo.Model.TaiXe;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TaiXeRepository extends CrudRepository<TaiXe, Long> {
    List<TaiXe> findAllByTrangThaiTrue();
}
