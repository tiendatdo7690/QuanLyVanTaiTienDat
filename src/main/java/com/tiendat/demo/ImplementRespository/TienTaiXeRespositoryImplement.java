package com.tiendat.demo.ImplementRespository;

import com.tiendat.demo.Model.TienTaiXe;
import com.tiendat.demo.Respository.TienTaiXeRespository;

import java.util.Optional;

public class TienTaiXeRespositoryImplement implements TienTaiXeRespository {
    @Override
    public <S extends TienTaiXe> S save(S entity) {
        return null;
    }

    @Override
    public <S extends TienTaiXe> Iterable<S> saveAll(Iterable<S> entities) {
        return null;
    }

    @Override
    public Optional<TienTaiXe> findById(Long aLong) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(Long aLong) {
        return false;
    }

    @Override
    public Iterable<TienTaiXe> findAll() {
        return null;
    }

    @Override
    public Iterable<TienTaiXe> findAllById(Iterable<Long> longs) {
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
    public void delete(TienTaiXe entity) {

    }

    @Override
    public void deleteAll(Iterable<? extends TienTaiXe> entities) {

    }

    @Override
    public void deleteAll() {

    }
}
