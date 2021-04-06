package com.tiendat.demo.ImplementRespository;

import com.tiendat.demo.Model.ChuHang;
import com.tiendat.demo.Respository.ChuHangRespository;

import java.util.Optional;

public class ChuHangRespositoryImplement implements ChuHangRespository {
    @Override
    public <S extends ChuHang> S save(S entity) {
        return null;
    }

    @Override
    public <S extends ChuHang> Iterable<S> saveAll(Iterable<S> entities) {
        return null;
    }

    @Override
    public Optional<ChuHang> findById(Long aLong) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(Long aLong) {
        return false;
    }

    @Override
    public Iterable<ChuHang> findAll() {
        return null;
    }

    @Override
    public Iterable<ChuHang> findAllById(Iterable<Long> longs) {
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
    public void delete(ChuHang entity) {

    }

    @Override
    public void deleteAll(Iterable<? extends ChuHang> entities) {

    }

    @Override
    public void deleteAll() {

    }
}
