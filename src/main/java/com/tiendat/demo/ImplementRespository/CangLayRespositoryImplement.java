package com.tiendat.demo.ImplementRespository;

import com.tiendat.demo.Model.CangLay;
import com.tiendat.demo.Respository.CangLayRepository;

import java.util.List;
import java.util.Optional;

public class CangLayRespositoryImplement implements CangLayRepository {
    @Override
    public <S extends CangLay> S save(S entity) {
        return null;
    }

    @Override
    public <S extends CangLay> Iterable<S> saveAll(Iterable<S> entities) {
        return null;
    }

    @Override
    public Optional<CangLay> findById(Long aLong) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(Long aLong) {
        return false;
    }

    @Override
    public Iterable<CangLay> findAll() {
        return null;
    }

    @Override
    public Iterable<CangLay> findAllById(Iterable<Long> longs) {
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
    public void delete(CangLay entity) {

    }

    @Override
    public void deleteAll(Iterable<? extends CangLay> entities) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public List<CangLay> findAllBy() {
        return null;
    }

    @Override
    public CangLay findTop1ByTen(String cangLay) {
        return null;
    }

    @Override
    public List<String> getAllName() {
        return null;
    }

    @Override
    public boolean existsByTen(String ten) {
        return false;
    }
}
