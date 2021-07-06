package com.tiendat.demo.Respository;

import com.tiendat.demo.Model.Cang;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CangRespository extends CrudRepository<Cang, Long> {
    List<Cang> findAllBy();
}
