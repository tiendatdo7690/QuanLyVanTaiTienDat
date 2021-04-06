package com.tiendat.demo.Controller.ControllerTaiXe;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.net.URL;
import java.util.ResourceBundle;

@Component
public class ThemTaiXeController implements Initializable {

    public JFXTextField id_Ten;
    public JFXTextField id_LuongCoBan;
    public JFXComboBox id_CBXe;
    public JFXTextField id_QueQuan;
    public JFXDatePicker id_NgaySinh;

    public void LamMoi(){

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    public void ThemTaiXe(ActionEvent actionEvent) {
    }
}
