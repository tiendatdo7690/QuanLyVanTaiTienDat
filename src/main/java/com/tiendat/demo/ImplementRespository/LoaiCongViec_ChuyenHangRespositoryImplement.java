package com.tiendat.demo.ImplementRespository;

import com.tiendat.demo.Model.LoaiCongViec_ChuyenHang;
import com.tiendat.demo.Model.LoaiCongViec_ChuyenHangPK;
import com.tiendat.demo.Respository.LoaiCongViecChuyenHangRespository;

import java.util.Optional;

public class LoaiCongViec_ChuyenHangRespositoryImplement implements LoaiCongViecChuyenHangRespository {
    @Override
    public <S extends LoaiCongViec_ChuyenHang> S save(S entity) {
        return null;
    }

    @Override
    public <S extends LoaiCongViec_ChuyenHang> Iterable<S> saveAll(Iterable<S> entities) {
        return null;
    }

    @Override
    public Optional<LoaiCongViec_ChuyenHang> findById(LoaiCongViec_ChuyenHangPK loaiCongViec_chuyenHangPK) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(LoaiCongViec_ChuyenHangPK loaiCongViec_chuyenHangPK) {
        return false;
    }

    @Override
    public Iterable<LoaiCongViec_ChuyenHang> findAll() {
        return null;
    }

    @Override
    public Iterable<LoaiCongViec_ChuyenHang> findAllById(Iterable<LoaiCongViec_ChuyenHangPK> loaiCongViec_chuyenHangPKS) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(LoaiCongViec_ChuyenHangPK loaiCongViec_chuyenHangPK) {

    }

    @Override
    public void delete(LoaiCongViec_ChuyenHang entity) {

    }

    @Override
    public void deleteAll(Iterable<? extends LoaiCongViec_ChuyenHang> entities) {

    }

    @Override
    public void deleteAll() {

    }
}
