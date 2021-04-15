package com.tiendat.demo.Respository;

import com.tiendat.demo.Exception.CV_TX_CHException;
import com.tiendat.demo.Model.*;
import com.tiendat.demo.ModelView.CongViecTX;
import javafx.collections.ObservableList;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.repository.CrudRepository;

public interface ContHangTXCVRespository extends CrudRepository<CongViec_TaiXe_ContHang, CongViec_TaiXe_ContHangPK> {

}
