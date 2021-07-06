package com.tiendat.demo.Respository;

import com.tiendat.demo.Model.CangLay;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CangLayRepository extends CrudRepository<CangLay, Long> {

    List<CangLay> findAllBy();

    CangLay findTop1ByTen(String cangLay);

    @Query(value = "select  cl.ten\n" +
            "from CangLay cl")
    List<String> getAllName();

    boolean existsByTen(String ten);
}
