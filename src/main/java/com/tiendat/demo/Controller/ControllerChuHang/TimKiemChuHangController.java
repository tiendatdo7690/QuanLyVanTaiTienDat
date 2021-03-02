package com.tiendat.demo.Controller.ControllerChuHang;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.JFXTextField;
import com.tiendat.demo.NodeService.ComboBoxService;
import com.tiendat.demo.NodeService.ObservableListImpl;
import com.tiendat.demo.NodeService.TabPaneService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

@Component
public class TimKiemChuHangController implements Initializable {

    @FXML
    private AnchorPane id_AnchaorPaneTabThemChuyenHang;

    private TabPaneService tabPaneService;

    @FXML
    private JFXComboBox<String> id_CBLoaiTimKiem;

    @FXML
    private JFXTextField id_TFTimKiem;

    @FXML
    private JFXTextField id_TFTenChuHang;

    @FXML
    private JFXTextField id_TFDiaChi;

    @FXML
    private JFXRadioButton id_RadioHoatDong;

    @FXML
    private JFXTextField id_TFMST;

    @Autowired
    private ConfigurableApplicationContext springContext;

    @Autowired
    private ComboBoxService<String> comboBoxServiceLoaiTimKiem;

    ObservableList<String> observableList = FXCollections.observableArrayList();
    public void LamMoi(){

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {


        System.out.println(observableList.add("Tên"));
       // observableList.add("Tên");
        observableList.add("Mã Số Thuế");
        System.out.println(observableList.size());
        comboBoxServiceLoaiTimKiem.LoadCombo(id_CBLoaiTimKiem,observableList);
        tabPaneService = new TabPaneService();

        try {
            tabPaneService.addContentInTab(springContext,id_AnchaorPaneTabThemChuyenHang,"/fxml/ChuHang/ThemChuyenHang.fxml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void SuaThongTin(ActionEvent actionEvent) {
    }
}
