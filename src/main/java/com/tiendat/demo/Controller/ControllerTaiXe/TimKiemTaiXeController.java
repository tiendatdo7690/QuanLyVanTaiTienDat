package com.tiendat.demo.Controller.ControllerTaiXe;

import com.jfoenix.controls.JFXTabPane;
import com.tiendat.demo.Controller.ControllerXe.ThemChiPhiDauController;
import com.tiendat.demo.Controller.ControllerXe.ThemChiPhiThayNhotController;
import com.tiendat.demo.Controller.ControllerXe.ThemChiPhiVoXeController;
import com.tiendat.demo.Controller.ControllerXe.ThemChiPhiXetXeController;
import com.tiendat.demo.NodeService.TabPaneService;
import com.tiendat.demo.NodeService.TabService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.util.ResourceBundle;

@Component
public class TimKiemTaiXeController implements Initializable {

    @FXML
    private AnchorPane id_AnchaorPaneTabThongKeTaiXe;
    @FXML
    private JFXTabPane id_TabpaneThongTinTaiXe;

    private TabPaneService tabPaneService;

    @Autowired
    private ConfigurableApplicationContext springContext;

    private TabService themTienUngTabService;
    private TabService themTienThuongTabService;
    private TabService taoBangLuongTabService;
    private TabService capNhatLuongCBTabService;

    @Autowired
    private CapNhatBangLuongController capNhatBangLuongController;

    @Autowired
    private ThemTienUngController themTienUngController;

    @Autowired
    private ThemTienThuongController themTienThuongController;

    @Autowired
    private TaoBangLuongController taoBangLuongController;

    public void LamMoi(){

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        tabPaneService = new TabPaneService();
        themTienUngTabService = new TabService("Thêm Tiền Ứng");
        themTienThuongTabService = new TabService("Thêm Tiền Thưởng");
        taoBangLuongTabService = new TabService("Tạo Bảng Lương");
        capNhatLuongCBTabService = new TabService("Cập Nhật Lương CB");

        try {
            tabPaneService.addContentInTab(springContext,id_AnchaorPaneTabThongKeTaiXe,"/fxml/TaiXe/ThongKeTaiXe.fxml");
        } catch (IOException e) {
            e.printStackTrace();
        }
        
    }

    public void TaoTabThemTienUng(ActionEvent actionEvent) throws InvocationTargetException, NoSuchMethodException,
            IllegalAccessException, IOException {
        tabPaneService.addTab(springContext,id_TabpaneThongTinTaiXe,themTienUngTabService,
                "/fxml/TaiXe/ThemTienUng.fxml",themTienUngController);
    }

    public void TaoTabThemTienThuong(ActionEvent actionEvent) throws InvocationTargetException, NoSuchMethodException,
            IllegalAccessException, IOException{
        tabPaneService.addTab(springContext,id_TabpaneThongTinTaiXe,themTienThuongTabService,
                "/fxml/TaiXe/ThemTienThuong.fxml",themTienThuongController);
    }

    public void TaoTabCapNhatLuong(ActionEvent actionEvent) throws InvocationTargetException, NoSuchMethodException,
            IllegalAccessException, IOException{
        tabPaneService.addTab(springContext,id_TabpaneThongTinTaiXe,taoBangLuongTabService,
                "/fxml/TaiXe/CapNhatLuongCB.fxml",capNhatBangLuongController);
    }

    public void TaoTabTaoBangLuong(ActionEvent actionEvent) throws InvocationTargetException, NoSuchMethodException,
            IllegalAccessException, IOException{
        tabPaneService.addTab(springContext,id_TabpaneThongTinTaiXe,capNhatLuongCBTabService,
                "/fxml/TaiXe/TaoBangLuong.fxml",taoBangLuongController);
    }
}
