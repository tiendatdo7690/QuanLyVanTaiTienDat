package com.tiendat.demo.Respository;

import com.tiendat.demo.Model.CangHa;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CangHaRepository extends CrudRepository<CangHa, Long> {
    List<CangHa> findAllBy();
}
