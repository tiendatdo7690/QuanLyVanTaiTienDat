package com.tiendat.demo.ImplementRespository;

import com.tiendat.demo.Model.CongViec_TaiXe_ContHang;
import com.tiendat.demo.Model.CongViec_TaiXe_ContHangPK;
import com.tiendat.demo.Respository.ContHang_TX_CVRespository;

import java.util.Optional;

public class ContHang_TX_CVRespositoryImplement implements ContHang_TX_CVRespository {

    @Override
    public <S extends CongViec_TaiXe_ContHang> S save(S entity) {
        return null;
    }

    @Override
    public <S extends CongViec_TaiXe_ContHang> Iterable<S> saveAll(Iterable<S> entities) {
        return null;
    }

    @Override
    public Optional<CongViec_TaiXe_ContHang> findById(CongViec_TaiXe_ContHangPK congViec_taiXe_contHangPK) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(CongViec_TaiXe_ContHangPK congViec_taiXe_contHangPK) {
        return false;
    }

    @Override
    public Iterable<CongViec_TaiXe_ContHang> findAll() {
        return null;
    }

    @Override
    public Iterable<CongViec_TaiXe_ContHang> findAllById(Iterable<CongViec_TaiXe_ContHangPK> congViec_taiXe_contHangPKS) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(CongViec_TaiXe_ContHangPK congViec_taiXe_contHangPK) {

    }

    @Override
    public void delete(CongViec_TaiXe_ContHang entity) {

    }

    @Override
    public void deleteAll(Iterable<? extends CongViec_TaiXe_ContHang> entities) {

    }

    @Override
    public void deleteAll() {

    }
}
