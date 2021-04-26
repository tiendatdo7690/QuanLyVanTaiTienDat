package com.tiendat.demo.Controller.ControllerChuHang;

import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import com.tiendat.demo.Model.ChuHang;
import com.tiendat.demo.Model.ChuyenHang;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import org.springframework.stereotype.Component;

@Component
public class ControllerThemTienTx {

    @FXML
    private Label id_LabelChuyenHang;


    @FXML
    private JFXTextField id_Tien;

    @FXML
    private JFXDatePicker id_Ngay;

    @FXML
    private TableView<?> id_TableTienTx;

    @FXML
    void Them(ActionEvent event) {

    }


    private ChuyenHang chuyenHang;

    public void setChuyenHang(ChuyenHang chuyenHang) {
        this.chuyenHang = chuyenHang;
        id_LabelChuyenHang.setText(chuyenHang.getTenChuyenHang());
    }
}
