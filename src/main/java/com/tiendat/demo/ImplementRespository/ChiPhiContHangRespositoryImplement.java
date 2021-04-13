package com.tiendat.demo.ImplementRespository;

import com.tiendat.demo.Model.ChiPhiContHang;
import com.tiendat.demo.Respository.ChiPhiContHangRespository;

import java.util.Optional;

public class ChiPhiContHangRespositoryImplement implements ChiPhiContHangRespository {
    @Override
    public <S extends ChiPhiContHang> S save(S entity) {
        return null;
    }

    @Override
    public <S extends ChiPhiContHang> Iterable<S> saveAll(Iterable<S> entities) {
        return null;
    }

    @Override
    public Optional<ChiPhiContHang> findById(Long aLong) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(Long aLong) {
        return false;
    }

    @Override
    public Iterable<ChiPhiContHang> findAll() {
        return null;
    }

    @Override
    public Iterable<ChiPhiContHang> findAllById(Iterable<Long> longs) {
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
    public void delete(ChiPhiContHang entity) {

    }

    @Override
    public void deleteAll(Iterable<? extends ChiPhiContHang> entities) {

    }

    @Override
    public void deleteAll() {

    }
}
