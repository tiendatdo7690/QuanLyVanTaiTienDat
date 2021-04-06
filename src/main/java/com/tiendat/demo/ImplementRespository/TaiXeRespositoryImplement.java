package com.tiendat.demo.ImplementRespository;

import com.tiendat.demo.Model.TaiXe;
import com.tiendat.demo.Respository.TaiXeRepository;

import java.util.Optional;

public class TaiXeRespositoryImplement implements TaiXeRepository {
    @Override
    public <S extends TaiXe> S save(S entity) {
        return null;
    }

    @Override
    public <S extends TaiXe> Iterable<S> saveAll(Iterable<S> entities) {
        return null;
    }

    @Override
    public Optional<TaiXe> findById(Long aLong) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(Long aLong) {
        return false;
    }

    @Override
    public Iterable<TaiXe> findAll() {
        return null;
    }

    @Override
    public Iterable<TaiXe> findAllById(Iterable<Long> longs) {
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
    public void delete(TaiXe entity) {

    }

    @Override
    public void deleteAll(Iterable<? extends TaiXe> entities) {

    }

    @Override
    public void deleteAll() {

    }
}
