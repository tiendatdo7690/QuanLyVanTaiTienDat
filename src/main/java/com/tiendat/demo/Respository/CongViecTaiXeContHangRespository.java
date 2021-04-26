package com.tiendat.demo.Respository;

import com.tiendat.demo.Model.ChuyenHang;
import com.tiendat.demo.Model.CongViec_TaiXe_ContHang;
import com.tiendat.demo.Model.CongViec_TaiXe_ContHangPK;
import org.springframework.data.repository.CrudRepository;

public interface CongViecTaiXeContHangRespository extends CrudRepository<CongViec_TaiXe_ContHang, CongViec_TaiXe_ContHangPK> {
}
