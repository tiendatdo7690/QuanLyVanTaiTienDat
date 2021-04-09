package com.tiendat.demo.Respository;

import com.tiendat.demo.Model.ChuHang;
import com.tiendat.demo.Model.ChuyenHang;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface IChuyenHangRespository extends CrudRepository<ChuyenHang, Long> {
    List<ChuyenHang> findByChuHang(ChuHang chuHang);
}
