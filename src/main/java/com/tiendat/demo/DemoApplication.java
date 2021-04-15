package com.tiendat.demo;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
public class DemoApplication extends Application{

    private ConfigurableApplicationContext springContext;
    private Parent rootNode;

    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void init() throws Exception {
        System.setProperty("java.awt.headless", "false");
        springContext = SpringApplication.run(DemoApplication.class);

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/MainViewWithDrawer.fxml"));
        fxmlLoader.setControllerFactory(springContext::getBean);
        rootNode = fxmlLoader.load();
    }

    @Override
    public void start(Stage stage) throws Exception {
        //rootNode.getStylesheets().add("dangnhap.css");
//        stage.setTitle("Quản Lý Nhân Viên");
//        stage.getIcons().add(new Image("/LOGO.png"));
//        rootNode.getStylesheets().add("dangnhap.css");
        Scene scene = new Scene(rootNode);
        ObservableList<String> stylesheets = scene.getStylesheets();
        stylesheets.addAll(DrawerDemo.class.getResource("/css/jfoenix-components.css").toExternalForm(),
                DrawerDemo.class.getResource("/css/jfoenix-design.css").toExternalForm());
        stage.setScene(scene);
        stage.show();
    }

    @Override
    public void stop() throws Exception {
        springContext.close();
    }

}
