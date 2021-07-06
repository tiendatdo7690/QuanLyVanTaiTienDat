package com.tiendat.demo.ImplementRespository;

import com.tiendat.demo.Model.ChuyenHang;
import com.tiendat.demo.Model.LoaiCongViec;
import com.tiendat.demo.Respository.LoaiCongViecRepository;

import java.util.List;
import java.util.Map;
import java.util.Optional;


public class LoaiCongViecRepositoryImplement implements LoaiCongViecRepository {

    @Override
    public <S extends LoaiCongViec> S save(S entity) {
        return null;
    }

    @Override
    public <S extends LoaiCongViec> Iterable<S> saveAll(Iterable<S> entities) {
        return null;
    }

    @Override
    public Optional<LoaiCongViec> findById(Long aLong) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(Long aLong) {
        return false;
    }

    @Override
    public Iterable<LoaiCongViec> findAll() {
        return null;
    }

    @Override
    public Iterable<LoaiCongViec> findAllById(Iterable<Long> longs) {
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
    public void delete(LoaiCongViec entity) {

    }

    @Override
    public void deleteAll(Iterable<? extends LoaiCongViec> entities) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public List<LoaiCongViec> layDSLoaiCV_ChuyenHang(ChuyenHang chuyenHang) {
        return null;
    }

    @Override
    public List<Map<String, Object>> layDSLoaiCongViecModel(Long idChuyenHang) {
        return null;
    }

    @Override
    public List<LoaiCongViec> findAllBy() {
        return null;
    }

    @Override
    public LoaiCongViec getNguyenChuyenHangCuaChuyenHang(Long id) {
        return null;
    }
}
