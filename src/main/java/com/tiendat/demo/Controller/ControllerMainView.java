package com.tiendat.demo.Controller;

import com.tiendat.demo.Controller.ControllerChuHang.ControllerMainChuHang;
import com.tiendat.demo.Controller.ControllerHang.ControllerMainHang;
import com.tiendat.demo.Controller.ControllerTaiXe.ControllerMainTaiXe;
import com.tiendat.demo.Controller.ControllerXe.ControllerMainXe;
import com.tiendat.demo.NodeService.TabPaneService;
import com.tiendat.demo.NodeService.TabService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TabPane;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class ControllerMainView {

    @FXML
    private Button btn_QuanLyHang;

    @FXML
    private Button btn_QuanLyNhanSu;

    @FXML
    private Button btn_QuanLyPhuongTien;

    @FXML
    private Button btn_ThongKe;

    @FXML
    private TabPane tabpane_Main;

    private TabPaneService tabpaneservice;

    @Autowired
    private ConfigurableApplicationContext springContext;

    @Autowired
    private ControllerMainChuHang controllerMainChuHang ;

    @Autowired
    private ControllerMainHang controllerMainHang ;

    @Autowired
    private ControllerMainTaiXe controllerMainTaiXe ;

    @Autowired
    private ControllerMainXe controllerMainXe ;



    private TabService tab_QuanLyChuHang;
    private TabService tab_QuanLyXe;
    private TabService tab_QuanLyHang;
    private TabService tab_QuanLyTaiXe;



    public ControllerMainView() {
        super();
        // TODO Auto-generated constructor stub
        tabpaneservice = new TabPaneService();

        tab_QuanLyChuHang = new TabService("Chủ Hàng");
        tab_QuanLyXe = new TabService("Xe");
        tab_QuanLyHang = new TabService("Hàng");
        tab_QuanLyTaiXe = new TabService("Tài Xế");

    }

    @FXML
    public void addQuanLyCongViec(ActionEvent event) throws Exception {
        //addTab(tab_QuanLyHang,"/QuanLyHang.fxml");
        tabpaneservice.addTab(springContext,tabpane_Main,tab_QuanLyChuHang, "/fxml/ChuHang/ViewMainChuHang.fxml", controllerMainChuHang);
    }


    @FXML
    public void addQuanLyNgayNghiPhep(ActionEvent event) throws Exception {
        //addTab(tab_QuanLyPhuongTien,"/QuanLyPhuongTien.fxml");
        tabpaneservice.addTab(springContext,tabpane_Main,tab_QuanLyHang, "/fxml/Hang/ViewMainHang.fxml", controllerMainHang);
    }

    @FXML
    public void addQuanLyNhanVien(ActionEvent event) throws Exception {
        //addTab(tab_QuanLyNhanSu,"/QuanLyNhanSu.fxml");
        tabpaneservice.addTab(springContext,tabpane_Main,tab_QuanLyTaiXe, "/fxml/TaiXe/ViewMainTaiXe.fxml", controllerMainTaiXe);
    }

    @FXML
    public void addThongKe(ActionEvent event) throws Exception {
        //addTab(tab_ThongKe,"/ThongKe.fxml");
        tabpaneservice.addTab(springContext,tabpane_Main,tab_QuanLyXe, "/fxml/Xe/ViewMainXe.fxml", controllerMainXe);
    }
}
