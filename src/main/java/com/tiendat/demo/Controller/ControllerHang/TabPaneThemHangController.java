package com.tiendat.demo.Controller.ControllerHang;

import com.jfoenix.controls.JFXTabPane;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import org.springframework.stereotype.Component;

import java.net.URL;
import java.util.ResourceBundle;

@Component
public class TabPaneThemHangController implements Initializable {

    @FXML
    private JFXTabPane tabPane_ThemHang;

    public void LamMoi(){

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

       // tabPane_ThemHang.getStyleClass().add("red-400");

    }
}
