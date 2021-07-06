package com.tiendat.demo.ImplementRespository;

import com.tiendat.demo.Model.ChiPhiThayNhot;
import com.tiendat.demo.Respository.ChiPhiThayNhotRespository;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

public class ChiPhiThayNhotRespositoryImplement implements ChiPhiThayNhotRespository {
    @Override
    public <S extends ChiPhiThayNhot> S save(S entity) {
        return null;
    }

    @Override
    public <S extends ChiPhiThayNhot> Iterable<S> saveAll(Iterable<S> entities) {
        return null;
    }

    @Override
    public Optional<ChiPhiThayNhot> findById(Long aLong) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(Long aLong) {
        return false;
    }

    @Override
    public Iterable<ChiPhiThayNhot> findAll() {
        return null;
    }

    @Override
    public Iterable<ChiPhiThayNhot> findAllById(Iterable<Long> longs) {
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
    public void delete(ChiPhiThayNhot entity) {

    }

    @Override
    public void deleteAll(Iterable<? extends ChiPhiThayNhot> entities) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public List<ChiPhiThayNhot> findAllByNgayAfterAndNgayBefore(Date tuNgay, Date denNgay) {
        return null;
    }

    @Override
    public List<ChiPhiThayNhot> findAllByNgayBetween(Date tuNgay, Date denNgay) {
        return null;
    }
}
