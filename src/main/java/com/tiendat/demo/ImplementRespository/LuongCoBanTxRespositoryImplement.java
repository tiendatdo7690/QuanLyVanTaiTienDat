package com.tiendat.demo.ImplementRespository;

import com.tiendat.demo.Model.LuongCoBanTaiXe;
import com.tiendat.demo.Respository.ILuongCoBanTXRespository;

import java.util.Optional;

public class LuongCoBanTxRespositoryImplement implements ILuongCoBanTXRespository {
    @Override
    public <S extends LuongCoBanTaiXe> S save(S entity) {
        return null;
    }

    @Override
    public <S extends LuongCoBanTaiXe> Iterable<S> saveAll(Iterable<S> entities) {
        return null;
    }

    @Override
    public Optional<LuongCoBanTaiXe> findById(Long aLong) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(Long aLong) {
        return false;
    }

    @Override
    public Iterable<LuongCoBanTaiXe> findAll() {
        return null;
    }

    @Override
    public Iterable<LuongCoBanTaiXe> findAllById(Iterable<Long> longs) {
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
    public void delete(LuongCoBanTaiXe entity) {

    }

    @Override
    public void deleteAll(Iterable<? extends LuongCoBanTaiXe> entities) {

    }

    @Override
    public void deleteAll() {

    }
}
