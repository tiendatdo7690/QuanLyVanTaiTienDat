package com.tiendat.demo.Respository;

import com.tiendat.demo.Model.Xe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface XeRespository extends CrudRepository<Xe, Long> {

    List<Xe> findAllBy();

    @Query(value = "select  x\n" +
            "from Xe x\n" +
            "where x.bienSo not in(\n" +
            "select x1.bienSo\n" +
            "from Xe x1 inner join TaiXe tx on x1.id = tx.xe.id\n" +
            ")")
    List<Xe> timXeChuaCoTX();
}
