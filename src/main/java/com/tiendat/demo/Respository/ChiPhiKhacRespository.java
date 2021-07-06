package com.tiendat.demo.Respository;

import com.tiendat.demo.Model.ChiPhiXeKhac;
import org.springframework.data.repository.CrudRepository;

import java.sql.Date;
import java.util.List;

public interface ChiPhiKhacRespository extends CrudRepository<ChiPhiXeKhac, Long> {
    List<ChiPhiXeKhac> findAllByNgayAfterAndNgayBefore(Date tuNgay, Date denNgay);

    List<ChiPhiXeKhac> findAllByNgayBetween(Date tuNgay, Date denNgay);
}
