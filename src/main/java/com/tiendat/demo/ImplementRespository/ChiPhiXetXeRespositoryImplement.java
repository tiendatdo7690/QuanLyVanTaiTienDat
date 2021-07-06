package com.tiendat.demo.ImplementRespository;

import com.tiendat.demo.Model.ChiPhiXetXe;
import com.tiendat.demo.Respository.ChiPhiXetXeRespository;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

public class ChiPhiXetXeRespositoryImplement implements ChiPhiXetXeRespository {
    @Override
    public <S extends ChiPhiXetXe> S save(S entity) {
        return null;
    }

    @Override
    public <S extends ChiPhiXetXe> Iterable<S> saveAll(Iterable<S> entities) {
        return null;
    }

    @Override
    public Optional<ChiPhiXetXe> findById(Long aLong) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(Long aLong) {
        return false;
    }

    @Override
    public Iterable<ChiPhiXetXe> findAll() {
        return null;
    }

    @Override
    public Iterable<ChiPhiXetXe> findAllById(Iterable<Long> longs) {
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
    public void delete(ChiPhiXetXe entity) {

    }

    @Override
    public void deleteAll(Iterable<? extends ChiPhiXetXe> entities) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public List<ChiPhiXetXe> findAllByNgayAfterAndNgayBefore(Date tuNgay, Date denNgay) {
        return null;
    }

    @Override
    public List<ChiPhiXetXe> findAllByNgayBetween(Date tuNgay, Date denNgay) {
        return null;
    }
}
