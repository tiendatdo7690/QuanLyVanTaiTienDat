package com.tiendat.demo.ImplementRespository;

import com.tiendat.demo.Model.GiaCuoc;
import com.tiendat.demo.Respository.GiaCuocRespository;

import java.util.Optional;

public class GiaCuocRespositoryImplement implements GiaCuocRespository {
    @Override
    public <S extends GiaCuoc> S save(S entity) {
        return null;
    }

    @Override
    public <S extends GiaCuoc> Iterable<S> saveAll(Iterable<S> entities) {
        return null;
    }

    @Override
    public Optional<GiaCuoc> findById(Long aLong) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(Long aLong) {
        return false;
    }

    @Override
    public Iterable<GiaCuoc> findAll() {
        return null;
    }

    @Override
    public Iterable<GiaCuoc> findAllById(Iterable<Long> longs) {
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
    public void delete(GiaCuoc entity) {

    }

    @Override
    public void deleteAll(Iterable<? extends GiaCuoc> entities) {

    }

    @Override
    public void deleteAll() {

    }
}
