package com.tiendat.demo.Respository;

import com.tiendat.demo.Model.ChuyenHang;
import com.tiendat.demo.Model.CongViec;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface LoaiCongViecRepository extends CrudRepository<CongViec, Long> {

    List<CongViec> findAllByChuyenHang(ChuyenHang chuyenHang);
}
