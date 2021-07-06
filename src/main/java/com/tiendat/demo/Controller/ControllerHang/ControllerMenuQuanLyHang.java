package com.tiendat.demo.Controller.ControllerHang;

import com.jfoenix.controls.JFXButton;
import com.tiendat.demo.Controller.ControllerChuHang.ThemChuHangController;
import com.tiendat.demo.Controller.ControllerChuHang.TimKiemChuHangController;
import com.tiendat.demo.Controller.ControllerMainViewDrawer;
import com.tiendat.demo.NodeService.TabPaneService;
import com.tiendat.demo.NodeService.TabService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.util.ResourceBundle;

@Component
public class ControllerMenuQuanLyHang implements Initializable {

    @FXML
    private JFXButton id_ButtonChiPhi;

    @Autowired
    private ControllerMainViewDrawer controllerMainViewTest;


    @Autowired
    private ConfigurableApplicationContext springContext;

    private TabPaneService tabPaneService;

    private TabService themHangTabService;
    private TabService timKiemHangTabService;
    private TabService thongKeHangTabService;
    private TabService themCangTabService;
    private TabService themLoaiChiPhiTabService;
    private TabService themLoaiChiHoTabService;
    private TabService themLoaiHangTabService;


    @Autowired
    private TabPaneThemHangController tabPaneThemHangController;

    @Autowired
    private ThemCangController themCangController;

    @Autowired
    private TimKiemContHangController timKiemContHangController;

    @Autowired
    private ThongKeHangController thongKeHangController;

    @Autowired
    private ThemLoaiChiHoController themLoaiChiHoController;

    @Autowired
    private ThemLoaiChiPhiController themLoaiChiPhiController;

    @Autowired
    private ThemLoaiHangController themLoaiHangController;


    public void addTabThemHang(ActionEvent actionEvent) throws InvocationTargetException, NoSuchMethodException,
            IllegalAccessException, IOException {
        tabPaneService.addTab(springContext,controllerMainViewTest.getId_TabPane(),themHangTabService,
                "/fxml/Hang/TabPaneThemHang.fxml",tabPaneThemHangController);
    }

    public void offMenuHang(ActionEvent actionEvent) {
        controllerMainViewTest.offMenuHang();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        id_ButtonChiPhi.setWrapText(true);
        tabPaneService = new TabPaneService();
        themHangTabService = new TabService("Thêm Hàng");
        timKiemHangTabService = new TabService("Tìm Kiếm Hàng");
        thongKeHangTabService = new TabService("Thống Kê Hàng");
        themCangTabService = new TabService("Thêm Cảng");
        themLoaiHangTabService = new TabService("Thêm Loại Hàng");
        themLoaiChiPhiTabService = new TabService("Thêm Loại Chi Phí");
        themLoaiChiHoTabService = new TabService("Thêm Loại Chi Hộ");
    }

    public void addTabTimKiemHang(ActionEvent actionEvent) throws InvocationTargetException, NoSuchMethodException,
            IllegalAccessException, IOException {
        tabPaneService.addTab(springContext,controllerMainViewTest.getId_TabPane(),timKiemHangTabService,
                "/fxml/Hang/TimKiemHang.fxml",timKiemContHangController);
    }

    public void addTabThongKeHang(ActionEvent actionEvent) throws InvocationTargetException, NoSuchMethodException,
            IllegalAccessException, IOException {
        tabPaneService.addTab(springContext,controllerMainViewTest.getId_TabPane(),thongKeHangTabService,
                "/fxml/Hang/ThongKeHang.fxml",thongKeHangController);
    }

    public void addTabThemCang(ActionEvent actionEvent) throws InvocationTargetException, NoSuchMethodException,
            IllegalAccessException, IOException {
        tabPaneService.addTab(springContext,controllerMainViewTest.getId_TabPane(),themCangTabService,
                "/fxml/Hang/ThemCang.fxml",themCangController);
    }

    public void addTabThemLoaiChiPhi(ActionEvent actionEvent) throws InvocationTargetException, NoSuchMethodException, IllegalAccessException, IOException {
        tabPaneService.addTab(springContext,controllerMainViewTest.getId_TabPane(),themLoaiChiPhiTabService,
                "/fxml/Hang/ThemLoaiChiPhi.fxml",themLoaiChiPhiController);
    }

    public void addTabThemLoaiChiHo(ActionEvent actionEvent) throws InvocationTargetException, NoSuchMethodException, IllegalAccessException, IOException {
        tabPaneService.addTab(springContext,controllerMainViewTest.getId_TabPane(),themLoaiChiHoTabService,
                "/fxml/Hang/ThemLoaiChiHo.fxml",themLoaiChiHoController);
    }

    public void addTabThemLoaiHang(ActionEvent actionEvent) throws InvocationTargetException, NoSuchMethodException, IllegalAccessException, IOException {
        tabPaneService.addTab(springContext,controllerMainViewTest.getId_TabPane(),themLoaiHangTabService,
                "/fxml/Hang/ThemLoaiHang.fxml",themLoaiHangController);
    }
}
