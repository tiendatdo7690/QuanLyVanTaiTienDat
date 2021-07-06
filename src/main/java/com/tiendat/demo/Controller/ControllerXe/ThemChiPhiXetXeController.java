package com.tiendat.demo.Controller.ControllerXe;

import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import com.tiendat.demo.ImplementRespository.ChiPhiXetXeRespositoryImplement;
import com.tiendat.demo.Model.ChiPhiXetXe;
import com.tiendat.demo.Respository.ChiPhiXetXeRespository;
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
public class ThemChiPhiXetXeController implements Initializable {

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
    private ChiPhiXetXeRespository chiPhiXetXeRespository = new ChiPhiXetXeRespositoryImplement();

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

        ChiPhiXetXe chiPhiXetXe = new ChiPhiXetXe();
        chiPhiXetXe.setNgay(ngay);
        chiPhiXetXe.setTien(tien);
        chiPhiXetXe.setXe(timKiemXeController.getXe());
        chiPhiXetXeRespository.save(chiPhiXetXe);
        ThongBao.showThongBaoThanhCong("Chi Phí Xét Xe");
    }

    public void LamMoi(){

    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
