package com.tiendat.demo.Controller.ControllerChuHang;

import com.tiendat.demo.Controller.ControllerMainViewDrawer;
import com.tiendat.demo.Controller.ControllerTaiXe.ThemTaiXeController;
import com.tiendat.demo.Controller.ControllerTaiXe.TimKiemTaiXeController;
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
public class ControllerMenuQuanLyChuHang implements Initializable {

    @Autowired
    private ControllerMainViewDrawer controllerMainViewTest;


    @Autowired
    private ConfigurableApplicationContext springContext;

    private TabPaneService tabPaneService;

    private TabService themChuHangTabService;
    private TabService timKiemChuHangTabService;
    private TabService themLoaiCongViecTabService;

    @Autowired
    private ThemChuHangController themChuHangController;

    @Autowired
    private TimKiemChuHangController timKiemChuHangController;

    @Autowired
    private ThemLoaiCongViecController themLoaiCongViecController;

    public void addTabThemChuHang(ActionEvent actionEvent) throws InvocationTargetException, NoSuchMethodException, IllegalAccessException, IOException {

        tabPaneService.addTab(springContext,controllerMainViewTest.getId_TabPane(),themChuHangTabService,
                "/fxml/ChuHang/ThemChuHang.fxml",themChuHangController);
    }

    public void offMenuChuHang(ActionEvent actionEvent) {

        controllerMainViewTest.offMenuChuHang();
    }

    public void addTabTimKiemChuHang(ActionEvent actionEvent) throws InvocationTargetException, NoSuchMethodException,
            IllegalAccessException, IOException {

        tabPaneService.addTab(springContext,controllerMainViewTest.getId_TabPane(),timKiemChuHangTabService,
                "/fxml/ChuHang/TimKiemChuHang.fxml",timKiemChuHangController);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        tabPaneService = new TabPaneService();
        themChuHangTabService = new TabService("Thêm Chủ Hàng");
        timKiemChuHangTabService = new TabService("Tìm Kiếm Chủ Hàng");
        themLoaiCongViecTabService = new TabService("Thêm Loại Công Việc");
    }


    public void addTabThemLoaiCongViec(ActionEvent actionEvent) throws InvocationTargetException, NoSuchMethodException, IllegalAccessException, IOException {
        tabPaneService.addTab(springContext,controllerMainViewTest.getId_TabPane(),themLoaiCongViecTabService,
                "/fxml/ChuHang/ThemLoaiCongViec.fxml",themLoaiCongViecController);
    }
}
