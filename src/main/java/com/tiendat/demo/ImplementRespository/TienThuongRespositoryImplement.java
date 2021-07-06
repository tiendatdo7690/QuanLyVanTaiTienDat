package com.tiendat.demo.ImplementRespository;

import com.tiendat.demo.Model.TienThuongTX;
import com.tiendat.demo.Respository.TienThuongRespository;

import java.util.Optional;

public class TienThuongRespositoryImplement implements TienThuongRespository {
    @Override
    public <S extends TienThuongTX> S save(S entity) {
        return null;
    }

    @Override
    public <S extends TienThuongTX> Iterable<S> saveAll(Iterable<S> entities) {
        return null;
    }

    @Override
    public Optional<TienThuongTX> findById(Long aLong) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(Long aLong) {
        return false;
    }

    @Override
    public Iterable<TienThuongTX> findAll() {
        return null;
    }

    @Override
    public Iterable<TienThuongTX> findAllById(Iterable<Long> longs) {
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
    public void delete(TienThuongTX entity) {

    }

    @Override
    public void deleteAll(Iterable<? extends TienThuongTX> entities) {

    }

    @Override
    public void deleteAll() {

    }
}
