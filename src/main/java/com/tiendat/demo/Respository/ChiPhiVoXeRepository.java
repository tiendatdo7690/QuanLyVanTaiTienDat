package com.tiendat.demo.Respository;

import com.tiendat.demo.Model.ChiPhiVoXe;
import org.springframework.data.repository.CrudRepository;

import java.sql.Date;
import java.util.List;

public interface ChiPhiVoXeRepository extends CrudRepository<ChiPhiVoXe, Long> {
    List<ChiPhiVoXe> findAllByNgayAfterAndNgayBefore(Date tuNgay, Date denNgay);

    List<ChiPhiVoXe> findAllByNgayBetween(Date tuNgay, Date denNgay);
}
