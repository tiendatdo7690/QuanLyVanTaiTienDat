package com.tiendat.demo.ImplementRespository;

import com.tiendat.demo.Exception.CV_TX_CHException;
import com.tiendat.demo.Exception.ChiHo_ContHangException;
import com.tiendat.demo.Exception.ChiPhiContHang_ContHangException;
import com.tiendat.demo.Model.*;
import com.tiendat.demo.ModelView.CongViecTX;
import com.tiendat.demo.Respository.*;
import com.tiendat.demo.ThongBao.ThongBao;
import javafx.collections.ObservableList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class ContHangTXCVDAO {

    @Autowired
    private ContHangTXCVRespository contHangTXCVRespository = new ContHangTXCVRespositoryImplement();

    @Autowired
    private ContHangRespository contHangRespository = new ContHangRespositoryImplement();

    @Autowired
    private LoaiChiHoContHangRespository loaiChiHoContHangRespository = new LoaiChiHoContHangRespositoryImplement();

    @Autowired
    private ChiPhiContHangContHangRespository chiPhiContHangContHangRespository = new ChiPhiContHangContHangRespositoryImplement();

    @Transactional(propagation = Propagation.MANDATORY )
    public void saveDanhSachCongViec(ObservableList<CongViecTX> dsCongViecTX,
                                     ObservableList<LoaiChiHo_ContHang> dsLoaiChiHoContHangs,
                                     ObservableList<ChiPhiContHang_ContHang> dsChiPhiContHangContHang,
                                     ContHang contHang) throws CV_TX_CHException, ChiHo_ContHangException, ChiPhiContHang_ContHangException {


        contHangRespository.save(contHang);


        for(LoaiChiHo_ContHang e : dsLoaiChiHoContHangs){
            LoaiChiHo_ContHangPK loaiChiHo_contHangPK = new LoaiChiHo_ContHangPK();
            loaiChiHo_contHangPK.setIdConHang(contHang.getId());
            loaiChiHo_contHangPK.setIdLoaiChiHo(e.getLoaiChiHo().getId());

            e.setContHang(contHang);
            e.setId(loaiChiHo_contHangPK);
            //loaiChiHoContHangRespository.save(e);

            if(!loaiChiHoContHangRespository.existsById(loaiChiHo_contHangPK))
                loaiChiHoContHangRespository.save(e);
            else{
                throw new ChiHo_ContHangException("Nhập Chi Hộ 2 lần giống nhau");
            }
        }


        for(ChiPhiContHang_ContHang e : dsChiPhiContHangContHang){
            ChiPhiContHang_ContHangPK chiPhiContHang_contHangPK = new ChiPhiContHang_ContHangPK();
            chiPhiContHang_contHangPK.setIdContHang(contHang.getId());
            chiPhiContHang_contHangPK.setIdChiPhiContHang(e.getLoaiChiPhiContHang().getId());

            e.setContHang(contHang);
            e.setId(chiPhiContHang_contHangPK);
            //chiPhiContHangContHangRespository.save(e);

            if(!chiPhiContHangContHangRespository.existsById(chiPhiContHang_contHangPK))
                chiPhiContHangContHangRespository.save(e);
            else{
                throw new ChiPhiContHang_ContHangException("Nhập Chi Phí 2 lần giống nhau");
            }

        }


        for(CongViecTX e : dsCongViecTX){
            CongViec_TaiXe_ContHang congViec_taiXe_contHang = new CongViec_TaiXe_ContHang();
            congViec_taiXe_contHang.setLoaiCongViec_chuyenHang(e.getLoaiCongViec_chuyenHang());
            congViec_taiXe_contHang.setContHang(contHang);
            congViec_taiXe_contHang.setTaiXe(e.getTaiXe());

            CongViec_TaiXe_ContHangPK congViec_taiXe_contHangPK = new CongViec_TaiXe_ContHangPK();
            congViec_taiXe_contHangPK.setLoaiCongViec_ChuyenHangId(e.getLoaiCongViec_chuyenHang().getId());
            congViec_taiXe_contHangPK.setConthangid(contHang.getId());
            congViec_taiXe_contHang.setId(congViec_taiXe_contHangPK);

            if(!contHangTXCVRespository.existsById(congViec_taiXe_contHangPK))
                contHangTXCVRespository.save(congViec_taiXe_contHang);
            else{
                throw new CV_TX_CHException("Nhập Công việc 2 lần");

            }


        }
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW,
            rollbackFor = {CV_TX_CHException.class,ChiHo_ContHangException.class,
                    ChiPhiContHang_ContHangException.class})
    public void saveDS(ObservableList<CongViecTX> dsCongViecTX,
                       ObservableList<LoaiChiHo_ContHang> dsLoaiChiHoContHangs,
                       ObservableList<ChiPhiContHang_ContHang> dsChiPhiContHangContHang,
                       ContHang contHang) throws CV_TX_CHException, ChiHo_ContHangException,
            ChiPhiContHang_ContHangException {

        this.saveDanhSachCongViec(dsCongViecTX,dsLoaiChiHoContHangs,dsChiPhiContHangContHang,contHang);
    }
}
