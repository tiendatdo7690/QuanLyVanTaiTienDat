package com.tiendat.demo.Controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDrawer;
import com.jfoenix.controls.JFXDrawersStack;
import com.jfoenix.controls.JFXTabPane;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

@Component
public class ControllerMainViewTest implements Initializable {

    private JFXTabPane id_TabPane;

    @FXML
    private JFXButton id_QuanLyXe;

    @FXML
    private VBox id_VBox;

    private JFXDrawersStack drawersStack;

    private JFXDrawer Drawer1 = new JFXDrawer();

    @Autowired
    private ConfigurableApplicationContext springContext;

    public ControllerMainViewTest() {

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

        id_TabPane.getStyleClass().add("green-400");

        Drawer1 = new JFXDrawer();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/MenuQuanLyXe.fxml"));
        fxmlLoader.setControllerFactory(springContext::getBean);


        VBox quanLyXeDrawerPane = null;

        try {
            quanLyXeDrawerPane = fxmlLoader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }

        //quanLyXeDrawerPane.getStyleClass().add("blue-400");
        //quanLyXeDrawerPane.getChildren().add(new JFXButton("Right Content"));
        Drawer1.setDirection(JFXDrawer.DrawerDirection.LEFT);
        Drawer1.setDefaultDrawerSize(120);
        Drawer1.setSidePane(quanLyXeDrawerPane);
        Drawer1.setResizeContent(true);
        Drawer1.setOverLayVisible(false);
        Drawer1.setResizableOnDrag(true);

        drawersStack = new JFXDrawersStack();

        drawersStack.setPrefWidth(600);
        drawersStack.setPrefHeight(900);
        drawersStack.setContent(id_TabPane);
        drawersStack.setViewOrder(1);

        id_VBox.getChildren().add(drawersStack);
        //id_BorderPane.setLeft(drawersStack);

    }

    @FXML
    void openMenuQuanLyXe(ActionEvent event) {
        if(Drawer1.isOpened()) {
            drawersStack.toggle(Drawer1);
        }
        else {
            drawersStack.toggle(Drawer1);
        }
    }
}
