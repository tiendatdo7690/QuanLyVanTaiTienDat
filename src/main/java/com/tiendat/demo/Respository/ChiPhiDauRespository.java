package com.tiendat.demo.Respository;

import com.tiendat.demo.Model.ChiPhiDau;
import org.springframework.data.repository.CrudRepository;

import java.sql.Date;
import java.util.List;

public interface ChiPhiDauRespository extends CrudRepository<ChiPhiDau, Long> {

    List<ChiPhiDau> findAllByNgayAfterAndNgayBefore(Date tuNgay,Date denNgay);
    List<ChiPhiDau> findAllByNgayBetween(Date tuNgay,Date denNgay);
}
