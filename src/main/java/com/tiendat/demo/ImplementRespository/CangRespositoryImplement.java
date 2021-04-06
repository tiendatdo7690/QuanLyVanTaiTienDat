package com.tiendat.demo.ImplementRespository;

import com.tiendat.demo.Model.Cang;
import com.tiendat.demo.Respository.CangRespository;

import java.util.Optional;

public class CangRespositoryImplement implements CangRespository {
    @Override
    public <S extends Cang> S save(S entity) {
        return null;
    }

    @Override
    public <S extends Cang> Iterable<S> saveAll(Iterable<S> entities) {
        return null;
    }

    @Override
    public Optional<Cang> findById(Long aLong) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(Long aLong) {
        return false;
    }

    @Override
    public Iterable<Cang> findAll() {
        return null;
    }

    @Override
    public Iterable<Cang> findAllById(Iterable<Long> longs) {
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
    public void delete(Cang entity) {

    }

    @Override
    public void deleteAll(Iterable<? extends Cang> entities) {

    }

    @Override
    public void deleteAll() {

    }
}
