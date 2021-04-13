package com.tiendat.demo.ImplementRespository;

import com.tiendat.demo.Model.ChuyenHang;
import com.tiendat.demo.Model.CongViec;
import com.tiendat.demo.Model.LoaiCongViec;
import com.tiendat.demo.Respository.CongViecRespository;

import java.util.Optional;

public class CongViecRespositoryImplement implements CongViecRespository {
    @Override
    public <S extends CongViec> S save(S entity) {
        return null;
    }

    @Override
    public <S extends CongViec> Iterable<S> saveAll(Iterable<S> entities) {
        return null;
    }

    @Override
    public Optional<CongViec> findById(Long aLong) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(Long aLong) {
        return false;
    }

    @Override
    public Iterable<CongViec> findAll() {
        return null;
    }

    @Override
    public Iterable<CongViec> findAllById(Iterable<Long> longs) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(Long aLong) {

    }

    @Override
    public void delete(CongViec entity) {

    }

    @Override
    public void deleteAll(Iterable<? extends CongViec> entities) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public CongViec layCVBangChuyenHangVaLoaiCV(ChuyenHang chuyenHang, LoaiCongViec loaiCV) {
        return null;
    }
}
