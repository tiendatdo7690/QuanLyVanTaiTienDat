package com.tiendat.demo.Controller.ControllerXe;

import com.jfoenix.controls.JFXTabPane;
import com.tiendat.demo.NodeService.TabPaneService;
import com.tiendat.demo.NodeService.TabService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.util.ResourceBundle;

@Component
public class TimKiemXeController implements Initializable {

    @FXML
    private JFXTabPane id_TabpaneThongTinXe;

    @FXML
    private AnchorPane id_AnchaorPaneTabThongKeXe;

    @FXML
    private AnchorPane id_AnchaorPaneTabThongKeLoiNhuan;


    private TabPaneService tabPaneService;

    @Autowired
    private ConfigurableApplicationContext springContext;

    private TabService themChiPhiDauTabService;
    private TabService themChiPhiXetXeTabService;
    private TabService themChiPhiVoXeTabService;
    private TabService themChiPhiThayNhotTabService;
    private TabService themChiPhiKhacTabService;

    @Autowired
    private ThemChiPhiDauController themChiPhiDauController;

    @Autowired
    private ThemChiPhiXetXeController themChiPhiXetXeController;

    @Autowired
    private ThemChiPhiVoXeController themChiPhiVoXeController;

    @Autowired
    private ThemChiPhiThayNhotController themChiPhiThayNhotController;

    @Autowired
    private ThemChiPhiKhacController themChiPhiKhacController;

    public void LamMoi(){

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        tabPaneService = new TabPaneService();
        themChiPhiDauTabService = new TabService("Thêm CP Dầu");
        themChiPhiXetXeTabService = new TabService("Thêm CP Xét Xe");
        themChiPhiVoXeTabService = new TabService("Thêm CP Vỏ Xe");
        themChiPhiThayNhotTabService = new TabService("Thêm CP Thay Nhớt");
        themChiPhiKhacTabService = new TabService("Thêm CP Khác");

        try {
            tabPaneService.addContentInTab(springContext,id_AnchaorPaneTabThongKeXe,"/fxml/Xe/ThongKeXe.fxml");
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            tabPaneService.addContentInTab(springContext,id_AnchaorPaneTabThongKeLoiNhuan,"/fxml/Xe/ThongKeLoiNhuan.fxml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void addTabThemChiPhiDau(ActionEvent actionEvent) throws InvocationTargetException, NoSuchMethodException,
            IllegalAccessException, IOException {
        tabPaneService.addTab(springContext,id_TabpaneThongTinXe,themChiPhiDauTabService,
                "/fxml/Xe/ThemChiPhiDau.fxml",themChiPhiDauController);
    }

    public void addTabThemChiPhiXetXe(ActionEvent actionEvent) throws InvocationTargetException, NoSuchMethodException,
            IllegalAccessException, IOException {
        tabPaneService.addTab(springContext,id_TabpaneThongTinXe,themChiPhiXetXeTabService,
                "/fxml/Xe/ThemChiPhiXetXe.fxml",themChiPhiXetXeController);
    }

    public void addTabThemChiPhiVoXe(ActionEvent actionEvent)throws InvocationTargetException, NoSuchMethodException,
            IllegalAccessException, IOException {
        tabPaneService.addTab(springContext,id_TabpaneThongTinXe,themChiPhiVoXeTabService,
                "/fxml/Xe/ThemChiPhiVoXe.fxml",themChiPhiVoXeController);
    }

    public void addTabThemChiPhiThayNhot(ActionEvent actionEvent)throws InvocationTargetException, NoSuchMethodException,
            IllegalAccessException, IOException {
        tabPaneService.addTab(springContext,id_TabpaneThongTinXe,themChiPhiThayNhotTabService,
                "/fxml/Xe/ThemChiPhiThayNhot.fxml",themChiPhiThayNhotController);
    }

    public void addTabThemChiPhiKhac(ActionEvent actionEvent)throws InvocationTargetException, NoSuchMethodException,
            IllegalAccessException, IOException {
        tabPaneService.addTab(springContext,id_TabpaneThongTinXe,themChiPhiKhacTabService,
                "/fxml/Xe/ThemChiPhiKhac.fxml",themChiPhiKhacController);
    }
}
