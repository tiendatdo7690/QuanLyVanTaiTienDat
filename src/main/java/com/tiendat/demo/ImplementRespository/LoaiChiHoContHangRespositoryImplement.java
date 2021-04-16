package com.tiendat.demo.ImplementRespository;

import com.tiendat.demo.Model.LoaiChiHo_ContHang;
import com.tiendat.demo.Model.LoaiChiHo_ContHangPK;
import com.tiendat.demo.Respository.LoaiChiHoContHangRespository;

import java.util.Optional;

public class LoaiChiHoContHangRespositoryImplement implements LoaiChiHoContHangRespository {

    @Override
    public <S extends LoaiChiHo_ContHang> S save(S entity) {
        return null;
    }

    @Override
    public <S extends LoaiChiHo_ContHang> Iterable<S> saveAll(Iterable<S> entities) {
        return null;
    }

    @Override
    public Optional<LoaiChiHo_ContHang> findById(LoaiChiHo_ContHangPK loaiChiHo_contHangPK) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(LoaiChiHo_ContHangPK loaiChiHo_contHangPK) {
        return false;
    }

    @Override
    public Iterable<LoaiChiHo_ContHang> findAll() {
        return null;
    }

    @Override
    public Iterable<LoaiChiHo_ContHang> findAllById(Iterable<LoaiChiHo_ContHangPK> loaiChiHo_contHangPKS) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(LoaiChiHo_ContHangPK loaiChiHo_contHangPK) {

    }

    @Override
    public void delete(LoaiChiHo_ContHang entity) {

    }

    @Override
    public void deleteAll(Iterable<? extends LoaiChiHo_ContHang> entities) {

    }

    @Override
    public void deleteAll() {

    }
}
