package com.tiendat.demo.ImplementRespository;

import com.tiendat.demo.Model.ChiHo;
import com.tiendat.demo.Respository.ChiHoRespository;

import java.util.Optional;

public class ChiHoRespositoryImplement implements ChiHoRespository {
    @Override
    public <S extends ChiHo> S save(S entity) {
        return null;
    }

    @Override
    public <S extends ChiHo> Iterable<S> saveAll(Iterable<S> entities) {
        return null;
    }

    @Override
    public Optional<ChiHo> findById(Long aLong) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(Long aLong) {
        return false;
    }

    @Override
    public Iterable<ChiHo> findAll() {
        return null;
    }

    @Override
    public Iterable<ChiHo> findAllById(Iterable<Long> longs) {
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
    public void delete(ChiHo entity) {

    }

    @Override
    public void deleteAll(Iterable<? extends ChiHo> entities) {

    }

    @Override
    public void deleteAll() {

    }
}
