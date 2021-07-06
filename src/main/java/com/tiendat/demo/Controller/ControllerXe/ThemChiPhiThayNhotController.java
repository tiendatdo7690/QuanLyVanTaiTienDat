package com.tiendat.demo.Controller.ControllerXe;

import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import com.tiendat.demo.ImplementRespository.ChiPhiThayNhotRespositoryImplement;
import com.tiendat.demo.Model.ChiPhiThayNhot;
import com.tiendat.demo.Respository.ChiPhiThayNhotRespository;
import com.tiendat.demo.ThongBao.LoiChuongTrinh;
import com.tiendat.demo.ThongBao.ThongBao;
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
public class ThemChiPhiThayNhotController implements Initializable {

    @FXML
    private JFXDatePicker id_Ngay;

    @FXML
    private JFXTextField id_Tien;

    @FXML
    private JFXDatePicker id_TuNgay;

    @FXML
    private JFXDatePicker id_DenNgay;

    @FXML
    private Pagination id_PaginationTimKiemChinhSua;

    @Autowired
    private TimKiemXeController timKiemXeController;

    @Autowired
    private ChiPhiThayNhotRespository chiPhiThayNhotRespository = new ChiPhiThayNhotRespositoryImplement();

    @FXML
    void TimKiem(ActionEvent event) {

    }

    @FXML
    void Them(ActionEvent event) {

        if(LoiChuongTrinh.textFieldNull(id_Tien)||
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

        ChiPhiThayNhot chiPhiThayNhot = new ChiPhiThayNhot();

        chiPhiThayNhot.setNgay(ngay);
        chiPhiThayNhot.setTien(tien);
        chiPhiThayNhot.setXe(timKiemXeController.getXe());

        chiPhiThayNhotRespository.save(chiPhiThayNhot);
        ThongBao.showThongBaoThanhCong("Chi Phí Thay Nhớt");

    }



    public void LamMoi(){

    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
