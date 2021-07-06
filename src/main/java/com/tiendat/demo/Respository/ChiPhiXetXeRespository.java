package com.tiendat.demo.Respository;

import com.tiendat.demo.Model.ChiPhiXetXe;
import org.springframework.data.repository.CrudRepository;

import java.sql.Date;
import java.util.List;

public interface ChiPhiXetXeRespository extends CrudRepository<ChiPhiXetXe, Long> {

    List<ChiPhiXetXe> findAllByNgayAfterAndNgayBefore(Date tuNgay, Date denNgay);

    List<ChiPhiXetXe> findAllByNgayBetween(Date tuNgay, Date denNgay);
}
