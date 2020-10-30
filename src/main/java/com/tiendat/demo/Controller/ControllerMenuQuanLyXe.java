package com.tiendat.demo.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Tab;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.net.URL;
import java.util.ResourceBundle;

@Component
public class ControllerMenuQuanLyXe implements Initializable {

    @Autowired
    private ControllerMainViewTest controllerMainViewTest;

    @FXML
    void addTabThemXe(ActionEvent event) {
        Tab tab = new Tab("Thêm Xe");

        controllerMainViewTest.getId_TabPane().getTabs().add(tab);

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
