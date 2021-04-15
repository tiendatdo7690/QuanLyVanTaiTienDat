package com.tiendat.demo.ImplementRespository;

import com.tiendat.demo.Exception.CV_TX_CHException;
import com.tiendat.demo.Model.CongViec_TaiXe_ContHang;
import com.tiendat.demo.Model.CongViec_TaiXe_ContHangPK;
import com.tiendat.demo.Model.ContHang;
import com.tiendat.demo.ModelView.CongViecTX;
import com.tiendat.demo.Respository.ContHangTXCVRespository;
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

    @Transactional(propagation = Propagation.MANDATORY )
    public void saveDanhSachCongViec(ObservableList<CongViecTX> dsCongViecTX,
                                     ContHang contHang) throws CV_TX_CHException {

        for(CongViecTX e : dsCongViecTX){
            CongViec_TaiXe_ContHang congViec_taiXe_contHang = new CongViec_TaiXe_ContHang();
            congViec_taiXe_contHang.setCongViec(e.getCongViec());
            congViec_taiXe_contHang.setContHang(contHang);
            congViec_taiXe_contHang.setTaiXe(e.getTaiXe());

            CongViec_TaiXe_ContHangPK congViec_taiXe_contHangPK = new CongViec_TaiXe_ContHangPK();
            congViec_taiXe_contHangPK.setCongviecid(e.getCongViec().getId());
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
            rollbackFor = CV_TX_CHException.class)
    public void saveDS(ObservableList<CongViecTX> dsCongViecTX, ContHang contHang) throws CV_TX_CHException {

        this.saveDanhSachCongViec(dsCongViecTX,contHang);
    }
}
