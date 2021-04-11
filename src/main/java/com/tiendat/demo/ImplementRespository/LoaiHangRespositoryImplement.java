package com.tiendat.demo.ImplementRespository;

import com.tiendat.demo.Model.LoaiHang;
import com.tiendat.demo.Respository.LoaiHangRespository;

import java.util.List;
import java.util.Optional;

public class LoaiHangRespositoryImplement implements LoaiHangRespository {
    @Override
    public <S extends LoaiHang> S save(S entity) {
        return null;
    }

    @Override
    public <S extends LoaiHang> Iterable<S> saveAll(Iterable<S> entities) {
        return null;
    }

    @Override
    public Optional<LoaiHang> findById(Long aLong) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(Long aLong) {
        return false;
    }

    @Override
    public Iterable<LoaiHang> findAll() {
        return null;
    }

    @Override
    public Iterable<LoaiHang> findAllById(Iterable<Long> longs) {
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
    public void delete(LoaiHang entity) {

    }

    @Override
    public void deleteAll(Iterable<? extends LoaiHang> entities) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public List<LoaiHang> findAllBy() {
        return null;
    }
}
