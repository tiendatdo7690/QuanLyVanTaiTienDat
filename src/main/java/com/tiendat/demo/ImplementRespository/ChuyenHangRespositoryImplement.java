package com.tiendat.demo.ImplementRespository;

import com.tiendat.demo.Model.ChuyenHang;
import com.tiendat.demo.Respository.IChuyenHangRespository;

import java.util.List;
import java.util.Optional;

public class ChuyenHangRespositoryImplement implements IChuyenHangRespository {
    public ChuyenHangRespositoryImplement() {
    }

    @Override
    public <S extends ChuyenHang> S save(S s) {
        return null;
    }

    @Override
    public <S extends ChuyenHang> Iterable<S> saveAll(Iterable<S> iterable) {
        return null;
    }

    @Override
    public Optional<ChuyenHang> findById(Long aLong) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(Long aLong) {
        return false;
    }

    @Override
    public Iterable<ChuyenHang> findAll() {
        return null;
    }

    @Override
    public Iterable<ChuyenHang> findAllById(Iterable<Long> iterable) {
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
    public void delete(ChuyenHang chuyenHang) {

    }

    @Override
    public void deleteAll(Iterable<? extends ChuyenHang> iterable) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public List<ChuyenHang> findAllBy() {
        return null;
    }
}
