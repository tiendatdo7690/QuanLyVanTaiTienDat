package com.tiendat.demo.Controller.ControllerTaiXe;

import com.tiendat.demo.Controller.ControllerMainViewDrawer;
import com.tiendat.demo.Controller.ControllerXe.ThemXeController;
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
public class ControllerMenuQuanlyTaiXe implements Initializable {

    @Autowired
    private ControllerMainViewDrawer controllerMainViewTest;

    @Autowired
    private ConfigurableApplicationContext springContext;

    private TabPaneService tabPaneService;

    private TabService themTaiXeTabService;
    private TabService timKiemTaiXeTabService;

    @Autowired
    private ThemTaiXeController themTaiXeController;

    @Autowired
    private TimKiemTaiXeController timKiemTaiXeController;

    public void addTabThemTaiXe(ActionEvent actionEvent) throws InvocationTargetException, NoSuchMethodException, IllegalAccessException, IOException {

        tabPaneService.addTab(springContext,controllerMainViewTest.getId_TabPane(),themTaiXeTabService,
                "/fxml/TaiXe/ThemTaiXe.fxml",themTaiXeController);
    }


    public void offMenuTaiXe(ActionEvent actionEvent) {
        controllerMainViewTest.offMenuTaiXe();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        tabPaneService = new TabPaneService();
        themTaiXeTabService = new TabService("Thêm Tài Xế");
        timKiemTaiXeTabService = new TabService("Tìm Kiếm Tài Xế");
    }

    public void addTabTimKiemTaiXe(ActionEvent actionEvent) throws InvocationTargetException, NoSuchMethodException, IllegalAccessException, IOException {

        tabPaneService.addTab(springContext,controllerMainViewTest.getId_TabPane(),timKiemTaiXeTabService,
                "/fxml/TaiXe/TimKiemTaiXe.fxml",timKiemTaiXeController);
    }
}
