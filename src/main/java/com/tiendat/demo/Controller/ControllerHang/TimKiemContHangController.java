package com.tiendat.demo.Controller.ControllerHang;

import com.tiendat.demo.NodeService.TabPaneService;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

@Component
public class TimKiemContHangController implements Initializable {

    @FXML
    private AnchorPane id_AnchaorPaneTabChiHo;
    @FXML
    private AnchorPane id_AnchaorPaneTabChiPhi;
    @FXML
    private AnchorPane id_AnchaorPaneTabCongViec;

    private TabPaneService tabPaneService;

    @Autowired
    private ConfigurableApplicationContext springContext;

    public void LamMoi(){

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        tabPaneService = new TabPaneService();

        try {
            tabPaneService.addContentInTab(springContext,id_AnchaorPaneTabChiHo,"/fxml/Hang/ChiHoContHang.fxml");
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            tabPaneService.addContentInTab(springContext,id_AnchaorPaneTabChiPhi,"/fxml/Hang/ChiPhiContHang.fxml");
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            tabPaneService.addContentInTab(springContext,id_AnchaorPaneTabCongViec,"/fxml/Hang/CongViecContHang.fxml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
