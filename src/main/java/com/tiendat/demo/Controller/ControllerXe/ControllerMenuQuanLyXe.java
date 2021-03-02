package com.tiendat.demo.Controller.ControllerXe;

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
public class ControllerMenuQuanLyXe implements Initializable {

    @Autowired
    private ControllerMainViewDrawer controllerMainViewTest;

    @Autowired
    private ThemXeController themXeController;

    @Autowired
    private TimKiemXeController timKiemXeController;

    private TabPaneService tabPaneService;

    @Autowired
    private ConfigurableApplicationContext springContext;

    private TabService themXeTabService;
    private TabService timKiemXeTabService;

    @FXML
    void addTabThemXe(ActionEvent event) throws InvocationTargetException, NoSuchMethodException, IllegalAccessException, IOException {

        tabPaneService.addTab(springContext,controllerMainViewTest.getId_TabPane(),themXeTabService,
                "/fxml/Xe/ThemXe.fxml",themXeController);

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        tabPaneService = new TabPaneService();
        themXeTabService = new TabService("Thêm Xe");
        timKiemXeTabService = new TabService("Tìm Kiếm Xe");

    }

    public void offMenuXe(ActionEvent actionEvent) {
        controllerMainViewTest.offMenuXe();
    }

    public void addTabTimKiemXe(ActionEvent actionEvent) throws InvocationTargetException, NoSuchMethodException, IllegalAccessException, IOException {

        tabPaneService.addTab(springContext,controllerMainViewTest.getId_TabPane(),timKiemXeTabService,
                "/fxml/Xe/TimKiemXe.fxml",timKiemXeController);
    }
}
