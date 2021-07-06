package com.tiendat.demo.Controller.ControllerXe;

import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import com.tiendat.demo.ImplementRespository.ChiPhiDauRespositoryImplement;
import com.tiendat.demo.Model.ChiPhiDau;
import com.tiendat.demo.Respository.ChiPhiDauRespository;
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
public class ThemChiPhiDauController implements Initializable {

    @FXML
    private JFXDatePicker id_NgayDo;

    @FXML
    private JFXTextField id_LitDau;

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
    private ChiPhiDauRespository chiPhiDauRespository = new ChiPhiDauRespositoryImplement();

    private ObservableList<ChiPhiDau> chiPhiDaus = FXCollections.observableArrayList();
    @FXML
    void TimKiem(ActionEvent event) {

        if (LoiChuongTrinh.datePickerNull(id_DenNgay) || LoiChuongTrinh.datePickerNull(id_TuNgay) ||
        LoiChuongTrinh.loiChonNgaySai(id_TuNgay,id_DenNgay)){
            return;
        }
        chiPhiDaus.clear();
        Date tungay = Date.valueOf(id_TuNgay.getValue());
        Date denngay = Date.valueOf(id_DenNgay.getValue());
        chiPhiDaus.addAll(chiPhiDauRespository.findAllByNgayAfterAndNgayBefore(tungay,denngay));

    }

    @FXML
    void Them(ActionEvent event) {

        if(LoiChuongTrinh.textFieldNull(id_LitDau)||LoiChuongTrinh.textFieldNull(id_Tien)||
                LoiChuongTrinh.datePickerNull(id_NgayDo)){
            return;
        }
        if (timKiemXeController.getXe() == null){
            System.out.println("chưa chọn xe");
            return;
        }
        if(LoiChuongTrinh.textFieldSo(id_LitDau)){
            //ThongBao.showThongBaoLoiTextSo(id_LitDau.getId());
            return;
        }
        if(LoiChuongTrinh.textFieldSo(id_Tien)){
            //ThongBao.showThongBaoLoiTextSo(id_Tien.getId());
            return;
        }

        Double lit = Double.valueOf(id_LitDau.getText());
        Long tien = Long.valueOf(id_Tien.getText());
        Date ngay = Date.valueOf(id_NgayDo.getValue());

        ChiPhiDau chiPhiDau = new ChiPhiDau();

        chiPhiDau.setLit(lit);
        chiPhiDau.setNgay(ngay);
        chiPhiDau.setTien(tien);
        chiPhiDau.setXe(timKiemXeController.getXe());
        chiPhiDauRespository.save(chiPhiDau);
        ThongBao.showThongBaoThanhCong("Chi Phí Dầu");


    }


    public void LamMoi(){

    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
