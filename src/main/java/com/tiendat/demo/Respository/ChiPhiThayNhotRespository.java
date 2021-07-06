package com.tiendat.demo.Respository;

import com.tiendat.demo.Model.ChiPhiThayNhot;
import org.springframework.data.repository.CrudRepository;

import java.sql.Date;
import java.util.List;

public interface ChiPhiThayNhotRespository extends CrudRepository<ChiPhiThayNhot, Long> {
    List<ChiPhiThayNhot> findAllByNgayAfterAndNgayBefore(Date tuNgay, Date denNgay);

    List<ChiPhiThayNhot> findAllByNgayBetween(Date tuNgay, Date denNgay);
}
