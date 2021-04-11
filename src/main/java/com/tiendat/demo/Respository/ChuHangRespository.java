package com.tiendat.demo.Respository;

import com.tiendat.demo.Model.ChuHang;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ChuHangRespository extends CrudRepository<ChuHang, Long> {

	List<ChuHang> findByTenOrMaSoThue(String ten,String mst);

	List<ChuHang> findByTenLikeOrMaSoThueLike(String ten,String mst);

	List<ChuHang> findAllByTrangThaiTrue();
}