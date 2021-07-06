package com.tiendat.demo.ImplementRespository;

import com.tiendat.demo.Model.CangHa;
import com.tiendat.demo.Respository.CangHaRepository;

import java.util.List;
import java.util.Optional;

public class CangHaRespositoryImplement implements CangHaRepository {
    @Override
    public <S extends CangHa> S save(S entity) {
        return null;
    }

    @Override
    public <S extends CangHa> Iterable<S> saveAll(Iterable<S> entities) {
        return null;
    }

    @Override
    public Optional<CangHa> findById(Long aLong) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(Long aLong) {
        return false;
    }

    @Override
    public Iterable<CangHa> findAll() {
        return null;
    }

    @Override
    public Iterable<CangHa> findAllById(Iterable<Long> longs) {
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
    public void delete(CangHa entity) {

    }

    @Override
    public void deleteAll(Iterable<? extends CangHa> entities) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public List<CangHa> findAllBy() {
        return null;
    }

    @Override
    public CangHa findTop1ByTen(String cangHa) {
        return null;
    }
}
