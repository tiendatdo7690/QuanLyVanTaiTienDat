package com.tiendat.demo.Controller.ControllerXe;

import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import com.tiendat.demo.ImplementRespository.ChiPhiKhacRespositoryImplement;
import com.tiendat.demo.Model.ChiPhiDau;
import com.tiendat.demo.Model.ChiPhiXeKhac;
import com.tiendat.demo.Respository.ChiPhiKhacRespository;
import com.tiendat.demo.ThongBao.LoiChuongTrinh;
import com.tiendat.demo.ThongBao.ThongBao;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Pagination;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.net.URL;
import java.sql.Date;
import java.util.ResourceBundle;

@Component
public class ThemChiPhiKhacController implements Initializable {

    @FXML
    private JFXDatePicker id_Ngay;

    @FXML
    private JFXTextField id_NoiDung;

    @FXML
    private JFXTextField id_Tien;

    @FXML
    private JFXDatePicker id_TuNgay;

    @FXML
    private JFXDatePicker id_DenNgay;

    @FXML
    private Pagination id_PaginationTimKiemChinhSua;

    private ObservableList<ChiPhiXeKhac> chiPhiXeKhacs = FXCollections.observableArrayList();

    @Autowired
    private TimKiemXeController timKiemXeController;

    @Autowired
    private ChiPhiKhacRespository chiPhiKhacRespository = new ChiPhiKhacRespositoryImplement();

    @FXML
    void TimKiem(ActionEvent event) {

    }

    @FXML
    void Them(ActionEvent event) {

        if(LoiChuongTrinh.textFieldNull(id_NoiDung)||LoiChuongTrinh.textFieldNull(id_Tien)||
                LoiChuongTrinh.datePickerNull(id_Ngay)){
            return;
        }
        if (timKiemXeController.getXe() == null){
            System.out.println("chưa chọn xe");
            return;
        }

        if(LoiChuongTrinh.textFieldSo(id_Tien)){
            return;
        }
        Long tien = Long.valueOf(id_Tien.getText());
        Date ngay = Date.valueOf(id_Ngay.getValue());
        String noiDung = id_NoiDung.getText();

        ChiPhiXeKhac chiPhiXeKhac = new ChiPhiXeKhac();

        chiPhiXeKhac.setNgay(ngay);
        chiPhiXeKhac.setNoiDung(noiDung);
        chiPhiXeKhac.setTien(tien);
        chiPhiXeKhac.setXe(timKiemXeController.getXe());

        chiPhiKhacRespository.save(chiPhiXeKhac);

        ThongBao.showThongBaoThanhCong("Chi Phí Khác");

    }

    public void LamMoi(){

    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
