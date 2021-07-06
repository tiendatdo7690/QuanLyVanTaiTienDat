package com.tiendat.demo.ImplementRespository;

import com.tiendat.demo.Model.ChiPhiContHang_ContHang;
import com.tiendat.demo.Model.ChiPhiContHang_ContHangPK;
import com.tiendat.demo.Model.ContHang;
import com.tiendat.demo.Respository.ChiPhiContHangContHangRespository;

import java.util.List;
import java.util.Optional;

public class ChiPhiContHangContHangRespositoryImplement implements ChiPhiContHangContHangRespository {

    @Override
    public <S extends ChiPhiContHang_ContHang> S save(S entity) {
        return null;
    }

    @Override
    public <S extends ChiPhiContHang_ContHang> Iterable<S> saveAll(Iterable<S> entities) {
        return null;
    }

    @Override
    public Optional<ChiPhiContHang_ContHang> findById(ChiPhiContHang_ContHangPK chiPhiContHang_contHangPK) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(ChiPhiContHang_ContHangPK chiPhiContHang_contHangPK) {
        return false;
    }

    @Override
    public Iterable<ChiPhiContHang_ContHang> findAll() {
        return null;
    }

    @Override
    public Iterable<ChiPhiContHang_ContHang> findAllById(Iterable<ChiPhiContHang_ContHangPK> chiPhiContHang_contHangPKS) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(ChiPhiContHang_ContHangPK chiPhiContHang_contHangPK) {

    }

    @Override
    public void delete(ChiPhiContHang_ContHang entity) {

    }

    @Override
    public void deleteAll(Iterable<? extends ChiPhiContHang_ContHang> entities) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public List<ChiPhiContHang_ContHang> findAllByContHang(ContHang contHang) {
        return null;
    }

    @Override
    public void DeleteByIdContHang(Long id) {

    }
}
