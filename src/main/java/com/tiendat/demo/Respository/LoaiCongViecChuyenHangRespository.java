package com.tiendat.demo.Respository;

import com.tiendat.demo.Model.ChuyenHang;
import com.tiendat.demo.Model.LoaiCongViec_ChuyenHang;
import com.tiendat.demo.Model.LoaiCongViec_ChuyenHangPK;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface LoaiCongViecChuyenHangRespository extends CrudRepository<LoaiCongViec_ChuyenHang, LoaiCongViec_ChuyenHangPK> {

    List<LoaiCongViec_ChuyenHang> findAllByChuyenHang(ChuyenHang chuyenHang);
}
