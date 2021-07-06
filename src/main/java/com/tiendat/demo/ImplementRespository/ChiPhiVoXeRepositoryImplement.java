package com.tiendat.demo.ImplementRespository;

import com.tiendat.demo.Model.ChiPhiVoXe;
import com.tiendat.demo.Respository.ChiPhiVoXeRepository;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

public class ChiPhiVoXeRepositoryImplement implements ChiPhiVoXeRepository {
    @Override
    public <S extends ChiPhiVoXe> S save(S entity) {
        return null;
    }

    @Override
    public <S extends ChiPhiVoXe> Iterable<S> saveAll(Iterable<S> entities) {
        return null;
    }

    @Override
    public Optional<ChiPhiVoXe> findById(Long aLong) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(Long aLong) {
        return false;
    }

    @Override
    public Iterable<ChiPhiVoXe> findAll() {
        return null;
    }

    @Override
    public Iterable<ChiPhiVoXe> findAllById(Iterable<Long> longs) {
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
    public void delete(ChiPhiVoXe entity) {

    }

    @Override
    public void deleteAll(Iterable<? extends ChiPhiVoXe> entities) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public List<ChiPhiVoXe> findAllByNgayAfterAndNgayBefore(Date tuNgay, Date denNgay) {
        return null;
    }

    @Override
    public List<ChiPhiVoXe> findAllByNgayBetween(Date tuNgay, Date denNgay) {
        return null;
    }
}
