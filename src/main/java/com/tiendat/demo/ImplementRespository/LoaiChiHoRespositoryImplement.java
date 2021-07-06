package com.tiendat.demo.ImplementRespository;

import com.tiendat.demo.Model.LoaiChiHo;
import com.tiendat.demo.Respository.LoaiChiHoRespository;

import java.util.List;
import java.util.Optional;

public class LoaiChiHoRespositoryImplement implements LoaiChiHoRespository {
    @Override
    public <S extends LoaiChiHo> S save(S entity) {
        return null;
    }

    @Override
    public <S extends LoaiChiHo> Iterable<S> saveAll(Iterable<S> entities) {
        return null;
    }

    @Override
    public Optional<LoaiChiHo> findById(Long aLong) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(Long aLong) {
        return false;
    }

    @Override
    public Iterable<LoaiChiHo> findAll() {
        return null;
    }

    @Override
    public Iterable<LoaiChiHo> findAllById(Iterable<Long> longs) {
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
    public void delete(LoaiChiHo entity) {

    }

    @Override
    public void deleteAll(Iterable<? extends LoaiChiHo> entities) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public List<LoaiChiHo> findAllBy() {
        return null;
    }

    @Override
    public List<LoaiChiHo> LayDsLoaiChiHoChuaDuocChon(List<Long> dsIdLoaiChiHo) {
        return null;
    }

    @Override
    public List<LoaiChiHo> LayDsLoaiChiHoChuaDuocChon1(Long idContHang) {
        return null;
    }

    @Override
    public LoaiChiHo findTop1ByTen(String ten) {
        return null;
    }


}
