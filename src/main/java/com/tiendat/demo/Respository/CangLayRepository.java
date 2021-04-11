package com.tiendat.demo.Respository;

import com.tiendat.demo.Model.CangLay;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CangLayRepository extends CrudRepository<CangLay, Long> {
    List<CangLay> findAllBy();
}
