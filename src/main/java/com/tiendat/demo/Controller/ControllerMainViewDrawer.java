package com.tiendat.demo.Controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDrawer;
import com.jfoenix.controls.JFXDrawersStack;
import com.jfoenix.controls.JFXTabPane;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.TabPane;
import javafx.scene.layout.VBox;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

@Component
public class ControllerMainViewDrawer implements Initializable {

    private JFXTabPane id_TabPane;

    @FXML
    private JFXButton id_QuanLyXe;

    @FXML
    private VBox id_VBox;

    private JFXDrawersStack drawersStack;

    private JFXDrawer drawerQuanLyXe;
    private JFXDrawer drawerQuanLyTaiXe;
    private JFXDrawer drawerQuanLyChuHang;
    private JFXDrawer drawerQuanLyHang;

    @Autowired
    private ConfigurableApplicationContext springContext;

    public ControllerMainViewDrawer() {

    }

    public JFXTabPane getId_TabPane() {
        return id_TabPane;
    }

    public void setId_TabPane(JFXTabPane id_TabPane) {
        this.id_TabPane = id_TabPane;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        id_TabPane = new JFXTabPane();
        id_TabPane.setTabClosingPolicy(TabPane.TabClosingPolicy.ALL_TABS);

        VBox quanLyXeDrawerPane = this.loadFxmlAsVbox("/fxml/Xe/MenuQuanLyXe.fxml");
        drawerQuanLyXe = this.setUpDrawerLeft(quanLyXeDrawerPane);

        VBox quanLyTaiXeDrawerPane = this.loadFxmlAsVbox("/fxml/TaiXe/MenuQuanLyTaiXe.fxml");
        drawerQuanLyTaiXe = this.setUpDrawerLeft(quanLyTaiXeDrawerPane);

        VBox quanLyChuHangDrawerPane = this.loadFxmlAsVbox("/fxml/ChuHang/MenuQuanLyChuHang.fxml");
        drawerQuanLyChuHang = this.setUpDrawerLeft(quanLyChuHangDrawerPane);

        VBox quanLyHangDrawerPane = this.loadFxmlAsVbox("/fxml/Hang/MenuQuanLyHang.fxml");
        drawerQuanLyHang = this.setUpDrawerLeft(quanLyHangDrawerPane);


        //id_TabPane.getStyleClass().add("red-400");
        drawersStack = new JFXDrawersStack();

        drawersStack.setPrefWidth(1000);
        drawersStack.setPrefHeight(1300);
        drawersStack.setContent(id_TabPane);
        drawersStack.setViewOrder(1);
       // drawersStack.getStyleClass().add("blue-400");

        id_VBox.getChildren().add(drawersStack);
        //id_BorderPane.setLeft(drawersStack);

    }

    @FXML
    void openMenuQuanLyXe(ActionEvent event) {
            drawersStack.toggle(drawerQuanLyXe);
    }
    private VBox loadFxmlAsVbox(String url){

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(url));
        fxmlLoader.setControllerFactory(springContext::getBean);

        VBox quanLyXeDrawerPane = null;

        try {
            quanLyXeDrawerPane = fxmlLoader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return quanLyXeDrawerPane;
    }
    private JFXDrawer setUpDrawerLeft(VBox vBox){

        JFXDrawer drawer = new JFXDrawer();

        drawer.setDirection(JFXDrawer.DrawerDirection.LEFT);
        drawer.setDefaultDrawerSize(120);
        drawer.setSidePane(vBox);
        drawer.setResizeContent(true);
        drawer.setOverLayVisible(false);
        drawer.setResizableOnDrag(false);

        return drawer;
    }

    public void openMenuQuanLyTaiXe(ActionEvent actionEvent) {
        drawersStack.toggle(drawerQuanLyTaiXe);
    }

    public void openMenuQuanLyHang(ActionEvent actionEvent) {
        drawersStack.toggle(drawerQuanLyHang);
    }

    public void openMenuQuanLyChuHang(ActionEvent actionEvent) {
        drawersStack.toggle(drawerQuanLyChuHang);
    }

    public void offMenuXe(){
        drawersStack.toggle(drawerQuanLyXe);
    }

    public void offMenuTaiXe(){
        drawersStack.toggle(drawerQuanLyTaiXe);
    }

    public void offMenuHang(){
        drawersStack.toggle(drawerQuanLyHang);
    }

    public void offMenuChuHang(){
        drawersStack.toggle(drawerQuanLyChuHang);
    }
}
