package com.tiendat.demo.ImplementRespository;

import com.tiendat.demo.Model.Xe;
import com.tiendat.demo.Respository.XeRespository;

import java.util.List;
import java.util.Optional;

public class XeRespositoryImplement implements XeRespository {
    @Override
    public <S extends Xe> S save(S entity) {
        return null;
    }

    @Override
    public <S extends Xe> Iterable<S> saveAll(Iterable<S> entities) {
        return null;
    }

    @Override
    public Optional<Xe> findById(Long aLong) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(Long aLong) {
        return false;
    }

    @Override
    public Iterable<Xe> findAll() {
        return null;
    }

    @Override
    public Iterable<Xe> findAllById(Iterable<Long> longs) {
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
    public void delete(Xe entity) {

    }

    @Override
    public void deleteAll(Iterable<? extends Xe> entities) {

    }

    @Override
    public void deleteAll() {
    }


    @Override
    public List<Xe> findAllBy() {
        return null;
    }

    @Override
    public List<Xe> findAllByTrangThaiTrue() {
        return null;
    }

    @Override
    public List<Xe> timXeChuaCoTX() {
        return null;
    }


}
