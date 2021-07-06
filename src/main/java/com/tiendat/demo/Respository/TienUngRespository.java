package com.tiendat.demo.Respository;

import com.tiendat.demo.Model.TaiXe;
import com.tiendat.demo.Model.TienUngTaiXe;
import org.springframework.data.repository.CrudRepository;

import java.util.Date;
import java.util.List;

public interface TienUngRespository extends CrudRepository<TienUngTaiXe, Long> {

    List<TienUngTaiXe> findAllByTaiXeAndNgayBetween(TaiXe taixe, Date tuNgay, Date denNgay);
}
