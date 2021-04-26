package com.tiendat.demo.NodeService;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

@Service
public class WindowService {

    private Stage dialog ;

    @Autowired
    private ConfigurableApplicationContext springContext;

    public void OpenNewWinDow(String duongDanfile, String tenHamKhoiTao, Object controller, Object bienTruyenVao){

        this.dialog = new Stage();
        dialog.resizableProperty().setValue(false);
        dialog.initStyle(StageStyle.UTILITY);
        dialog.initModality(Modality.APPLICATION_MODAL);
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(duongDanfile));
        fxmlLoader.setControllerFactory(springContext::getBean);


        try {
            VBox addRelativesView = (VBox) fxmlLoader.load();
            Method method = fxmlLoader.getController().getClass().getMethod(tenHamKhoiTao,
                    new Class[] {bienTruyenVao.getClass()});
            method.invoke(controller, new Object[] {bienTruyenVao});


            Scene scene = new Scene(addRelativesView,500,300);
            this.dialog.setScene(scene);
            this.dialog.showAndWait();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
