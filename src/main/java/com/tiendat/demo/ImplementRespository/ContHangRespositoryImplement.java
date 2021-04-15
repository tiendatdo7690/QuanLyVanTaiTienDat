package com.tiendat.demo.ImplementRespository;

import com.tiendat.demo.Exception.ContHangException;
import com.tiendat.demo.Model.ContHang;
import com.tiendat.demo.Respository.ContHangRespository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

public class ContHangRespositoryImplement implements ContHangRespository {
    @Override
    public <S extends ContHang> S save(S entity) {
        return null;
    }

    @Override
    public <S extends ContHang> Iterable<S> saveAll(Iterable<S> entities) {
        return null;
    }

    @Override
    public Optional<ContHang> findById(Long aLong) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(Long aLong) {
        return false;
    }

    @Override
    public Iterable<ContHang> findAll() {
        return null;
    }

    @Override
    public Iterable<ContHang> findAllById(Iterable<Long> longs) {
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
    public void delete(ContHang entity) {

    }

    @Override
    public void deleteAll(Iterable<? extends ContHang> entities) {

    }

    @Override
    public void deleteAll() {

    }

    @Transactional(propagation = Propagation.MANDATORY )
    public void batLoiSaveContHang() throws ContHangException {


    }

    public void saveContHang(){

    }
}
