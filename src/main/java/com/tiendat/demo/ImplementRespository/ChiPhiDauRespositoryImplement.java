package com.tiendat.demo.ImplementRespository;

import com.tiendat.demo.Model.ChiPhiDau;
import com.tiendat.demo.Respository.ChiPhiDauRespository;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

public class ChiPhiDauRespositoryImplement implements ChiPhiDauRespository {
    @Override
    public <S extends ChiPhiDau> S save(S entity) {
        return null;
    }

    @Override
    public <S extends ChiPhiDau> Iterable<S> saveAll(Iterable<S> entities) {
        return null;
    }

    @Override
    public Optional<ChiPhiDau> findById(Long aLong) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(Long aLong) {
        return false;
    }

    @Override
    public Iterable<ChiPhiDau> findAll() {
        return null;
    }

    @Override
    public Iterable<ChiPhiDau> findAllById(Iterable<Long> longs) {
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
    public void delete(ChiPhiDau entity) {

    }

    @Override
    public void deleteAll(Iterable<? extends ChiPhiDau> entities) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public List<ChiPhiDau> findAllByNgayAfterAndNgayBefore(Date tuNgay, Date denNgay) {
        return null;
    }

    @Override
    public List<ChiPhiDau> findAllByNgayBetween(Date tuNgay, Date denNgay) {
        return null;
    }
}
