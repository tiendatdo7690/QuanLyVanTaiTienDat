package com.tiendat.demo.Respository;

import com.tiendat.demo.Exception.CV_TX_CHException;
import com.tiendat.demo.Model.*;
import com.tiendat.demo.ModelView.CongViecTX;
import javafx.collections.ObservableList;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface ContHangTXCVRespository extends CrudRepository<CongViec_TaiXe_ContHang, CongViec_TaiXe_ContHangPK> {

    @Modifying
    @Query(nativeQuery = true,value = "delete cong_viec_tai_xe_cont_hang \n" +
                   "where cont_hang_id = :idContHang")
    void DeleteByIdContHang(@Param("idContHang") Long idContHang);
}
