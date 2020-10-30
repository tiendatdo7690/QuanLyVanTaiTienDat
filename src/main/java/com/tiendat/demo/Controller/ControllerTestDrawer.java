package com.tiendat.demo.Controller;

import com.jfoenix.controls.JFXDrawer;
import com.tiendat.demo.DrawerDemo;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;
import org.springframework.stereotype.Component;

import java.net.URL;
import java.util.ResourceBundle;

@Component
public class ControllerTestDrawer implements Initializable {

    @FXML
    private JFXDrawer drawer1;

    @FXML
    private JFXDrawer drawer2;

    @FXML
    private JFXDrawer drawer3;


    @FXML
    private AnchorPane anchorpaneMain;

    private AnchorPane anchorpane1;
    private AnchorPane anchorpane2;
    private AnchorPane anchorpane3;
    @FXML
    private AnchorPane anchorpane4;

    @FXML
    private AnchorPane anchorpane5;

    @FXML
    public void clickButton1(ActionEvent actionEvent) {

        if (drawer1.isOpened())
            drawer1.close();
        else
            drawer1.open();
    }

    @FXML
    public void clickButton2(ActionEvent actionEvent) {
        if (drawer2.isOpened())
            drawer2.close();
        else
            drawer2.open();
    }

    @FXML
    public void clickButton3(ActionEvent actionEvent) {
        if (drawer3.isOpened())
            drawer3.close();
        else
            drawer3.open();

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        anchorpane4.setViewOrder(1);
        anchorpane5.setViewOrder(1);
        anchorpane1 = new AnchorPane();
        anchorpane1.getStyleClass().add("green-400");
        drawer1.setDirection(JFXDrawer.DrawerDirection.TOP);
        drawer1.setSidePane(anchorpane1);

        anchorpane2 = new AnchorPane();
        anchorpane2.getStyleClass().add("red-400");
        drawer2.setDirection(JFXDrawer.DrawerDirection.TOP);
        drawer2.setSidePane(anchorpane2);

        anchorpane3 = new AnchorPane();
        anchorpane3.getStyleClass().add("blue-400");
        drawer3.setDirection(JFXDrawer.DrawerDirection.TOP);
        drawer3.setSidePane(anchorpane3);

        final ObservableList<String> stylesheets = anchorpaneMain.getStylesheets();
        stylesheets.addAll(ControllerTestDrawer.class.getResource("/css/jfoenix-components.css").toExternalForm(),
                DrawerDemo.class.getResource("/css/jfoenix-design.css").toExternalForm());
    }
}
