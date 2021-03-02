package com.tiendat.demo.Controller.ControllerHang;

import com.tiendat.demo.Controller.ControllerChuHang.ThemChuHangController;
import com.tiendat.demo.Controller.ControllerChuHang.TimKiemChuHangController;
import com.tiendat.demo.Controller.ControllerMainViewDrawer;
import com.tiendat.demo.NodeService.TabPaneService;
import com.tiendat.demo.NodeService.TabService;
import javafx.event.ActionEvent;
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

    @Autowired
    private ControllerMainViewDrawer controllerMainViewTest;


    @Autowired
    private ConfigurableApplicationContext springContext;

    private TabPaneService tabPaneService;

    private TabService themHangTabService;
    private TabService timKiemHangTabService;
    private TabService thongKeHangTabService;
    private TabService themCangTabService;


    @Autowired
    private TabPaneThemHangController tabPaneThemHangController;

    @Autowired
    private ThemCangController themCangController;

    @Autowired
    private TimKiemContHangController timKiemContHangController;

    @Autowired
    private ThongKeHangController thongKeHangController;


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
        tabPaneService = new TabPaneService();
        themHangTabService = new TabService("Thêm Hàng");
        timKiemHangTabService = new TabService("Tìm Kiếm Hàng");
        thongKeHangTabService = new TabService("Thống Kê Hàng");
        themCangTabService = new TabService("Thêm Cảng");
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
}
