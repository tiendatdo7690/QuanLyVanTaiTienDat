package com.tiendat.demo.ImplementRespository;

import com.tiendat.demo.Model.ChiPhiXeKhac;
import com.tiendat.demo.Respository.ChiPhiKhacRespository;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

public class ChiPhiKhacRespositoryImplement implements ChiPhiKhacRespository {
    @Override
    public <S extends ChiPhiXeKhac> S save(S entity) {
        return null;
    }

    @Override
    public <S extends ChiPhiXeKhac> Iterable<S> saveAll(Iterable<S> entities) {
        return null;
    }

    @Override
    public Optional<ChiPhiXeKhac> findById(Long aLong) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(Long aLong) {
        return false;
    }

    @Override
    public Iterable<ChiPhiXeKhac> findAll() {
        return null;
    }

    @Override
    public Iterable<ChiPhiXeKhac> findAllById(Iterable<Long> longs) {
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
    public void delete(ChiPhiXeKhac entity) {

    }

    @Override
    public void deleteAll(Iterable<? extends ChiPhiXeKhac> entities) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public List<ChiPhiXeKhac> findAllByNgayAfterAndNgayBefore(Date tuNgay, Date denNgay) {
        return null;
    }

    @Override
    public List<ChiPhiXeKhac> findAllByNgayBetween(Date tuNgay, Date denNgay) {
        return null;
    }
}
