package com.tiendat.demo.ImplementRespository;

import com.tiendat.demo.Model.LoaiChiPhiContHang;
import com.tiendat.demo.Respository.LoaiChiPhiContHangRespository;

import java.util.List;
import java.util.Optional;

public class LoaiChiPhiContHangRespositoryImplement implements LoaiChiPhiContHangRespository {
    @Override
    public <S extends LoaiChiPhiContHang> S save(S entity) {
        return null;
    }

    @Override
    public <S extends LoaiChiPhiContHang> Iterable<S> saveAll(Iterable<S> entities) {
        return null;
    }

    @Override
    public Optional<LoaiChiPhiContHang> findById(Long aLong) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(Long aLong) {
        return false;
    }

    @Override
    public Iterable<LoaiChiPhiContHang> findAll() {
        return null;
    }

    @Override
    public Iterable<LoaiChiPhiContHang> findAllById(Iterable<Long> longs) {
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
    public void delete(LoaiChiPhiContHang entity) {

    }

    @Override
    public void deleteAll(Iterable<? extends LoaiChiPhiContHang> entities) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public List<LoaiChiPhiContHang> findAllBy() {
        return null;
    }
}
