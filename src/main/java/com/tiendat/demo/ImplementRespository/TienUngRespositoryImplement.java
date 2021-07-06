package com.tiendat.demo.ImplementRespository;

import com.tiendat.demo.Model.TaiXe;
import com.tiendat.demo.Model.TienUngTaiXe;
import com.tiendat.demo.Respository.TienUngRespository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public class TienUngRespositoryImplement implements TienUngRespository {
    @Override
    public <S extends TienUngTaiXe> S save(S entity) {
        return null;
    }

    @Override
    public <S extends TienUngTaiXe> Iterable<S> saveAll(Iterable<S> entities) {
        return null;
    }

    @Override
    public Optional<TienUngTaiXe> findById(Long aLong) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(Long aLong) {
        return false;
    }

    @Override
    public Iterable<TienUngTaiXe> findAll() {
        return null;
    }

    @Override
    public Iterable<TienUngTaiXe> findAllById(Iterable<Long> longs) {
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
    public void delete(TienUngTaiXe entity) {

    }

    @Override
    public void deleteAll(Iterable<? extends TienUngTaiXe> entities) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public List<TienUngTaiXe> findAllByTaiXeAndNgayBetween(TaiXe taixe, Date tuNgay, Date denNgay) {
        return null;
    }
}
