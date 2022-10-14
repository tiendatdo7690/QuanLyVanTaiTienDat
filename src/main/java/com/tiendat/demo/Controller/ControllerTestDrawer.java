package com.tiendat.demo.Controller;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDrawer;
import com.tiendat.demo.DrawerDemo;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.util.StringConverter;
import org.springframework.stereotype.Component;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
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
    private ComboBox<Integer> id_CBTest;

    @FXML
    private AnchorPane anchorpaneMain;

    private AnchorPane anchorpane1;
    private AnchorPane anchorpane2;
    private AnchorPane anchorpane3;
    @FXML
    private AnchorPane anchorpane4;

    @FXML
    private AnchorPane anchorpane5;

    private int selectIndex = -3;
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

//        anchorpane4.setViewOrder(1);
//        anchorpane5.setViewOrder(1);
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

        id_CBTest.setEditable(true);
        List<Integer> integerLíst = new ArrayList<Integer>();
        integerLíst.add(1);
        integerLíst.add(2);
        integerLíst.add(3);
        integerLíst.add(4);


        id_CBTest.setItems(FXCollections.observableArrayList(integerLíst));

        id_CBTest.setConverter(new StringConverter<Integer>() {

            @Override
            public String toString(Integer object) {
                if (object == null) return null;
                return object.toString();
            }

            @Override
            public Integer fromString(String string) {
                // replace this with approquiate implementation of parsing function
                // or lookup function
                int x = 666;
                return x;
            }
        });
        id_CBTest.getEditor().textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable,
                                String oldValue, String newValue) {

                System.out.println(" Text Changed to  " + newValue + ")\n");
                id_CBTest.show();
            }
        });
    }

    public void getValueCB(ActionEvent actionEvent) {




        System.out.println("   ComboBox.getValue(): " + id_CBTest.getSelectionModel().getSelectedItem());
    }

}
