package com.tiendat.demo.Controller.ControllerTaiXe;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import com.tiendat.demo.ImplementRespository.TienUngRespositoryImplement;
import com.tiendat.demo.Model.TienUngTaiXe;
import com.tiendat.demo.Respository.TienUngRespository;
import com.tiendat.demo.ThongBao.LoiChuongTrinh;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.net.URL;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

@Component
public class ThemTienUngController implements Initializable {

    @FXML
    private JFXTextField id_TextTien;

    @FXML
    private JFXDatePicker id_DateNgay;

    @FXML
    private JFXComboBox<String> id_ComboBox;

    @Autowired
    private TienUngRespository tienUngRespository = new TienUngRespositoryImplement();
    @FXML
    void ThemTienUng(ActionEvent event) {

        if(LoiChuongTrinh.textFieldNull(id_TextTien)||
                LoiChuongTrinh.datePickerNull(id_DateNgay)|| LoiChuongTrinh.ComboBoxNull(id_ComboBox)){
            return;
        }
        if(LoiChuongTrinh.textFieldSo(id_TextTien)){
            return;
        }

        Long tien = Long.valueOf(id_TextTien.getText());
        Date ngay = Date.valueOf(id_DateNgay.getValue());

        TienUngTaiXe tienUngTaiXe = new TienUngTaiXe();
        tienUngTaiXe.setNgay(ngay);
        tienUngTaiXe.setTien(tien);
        tienUngTaiXe.setHinhThuc(id_ComboBox.getSelectionModel().getSelectedItem());
        tienUngRespository.save(tienUngTaiXe);
    }
    public void LamMoi(){

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        List<String> dsHinhThuc = new ArrayList<>();
        dsHinhThuc.add("Tiền Mặt");
        dsHinhThuc.add("Chuyển Khoản");
        id_ComboBox.setItems(FXCollections.observableList(dsHinhThuc));
    }

    public void TimKiem(ActionEvent actionEvent) {
    }
}
