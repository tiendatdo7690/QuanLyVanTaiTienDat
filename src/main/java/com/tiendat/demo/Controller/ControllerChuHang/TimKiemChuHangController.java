package com.tiendat.demo.Controller.ControllerChuHang;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.JFXTextField;
import com.tiendat.demo.ImplementRespository.ChuHangRespositoryImplement;
import com.tiendat.demo.Model.ChuHang;
import com.tiendat.demo.NodeService.*;
import com.tiendat.demo.Respository.ChuHangRespository;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Pagination;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

@Component
public class TimKiemChuHangController implements Initializable {

    public Pagination id_PaginationTimChuHang;

    @FXML
    private AnchorPane id_AnchaorPaneTabThemChuyenHang;

    private TabPaneService tabPaneService;

    @FXML
    private JFXComboBox<String> id_CBLoaiTimKiem;

    @FXML
    private JFXTextField id_TFTimKiem;

    @FXML
    private JFXTextField id_TFTenChuHang;

    @FXML
    private JFXTextField id_TFDiaChi;

    @FXML
    private JFXRadioButton id_RadioHoatDong;

    @FXML
    private JFXTextField id_TFMST;

    @Autowired
    private ConfigurableApplicationContext springContext;

    @Autowired
    private ComboBoxService<String> comboBoxServiceLoaiTimKiem;

    @Autowired
    private TableViewService<ChuHang,TimKiemChuHangController> tableviewTimKiemChuHang;

    @Autowired
    private PaginationService timKiemChuHangPaginationService;
    ObservableList<String> observableList = FXCollections.observableArrayList();

    @Autowired
    private ChuHangRespository chuHangRespository = new ChuHangRespositoryImplement();

    @Autowired
    private ThemChuyenHangController themChuyenHangController;

    private ChuHang chuHang = null;

    public ChuHang getChuHang() {
        return chuHang;
    }

    public void setChuHang(ChuHang chuHang) {
        this.chuHang = chuHang;
    }

    public void LamMoi(){

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {


        System.out.println(observableList.add("Tên"));
        observableList.add("Mã Số Thuế");
        System.out.println(observableList.size());
        comboBoxServiceLoaiTimKiem.LoadCombo(id_CBLoaiTimKiem,observableList);
        tabPaneService = new TabPaneService();

        try {
            tabPaneService.addContentInTab(springContext,id_AnchaorPaneTabThemChuyenHang,"/fxml/ChuHang/ThemChuyenHang.fxml");
        } catch (IOException e) {
            e.printStackTrace();
        }

        if(tableviewTimKiemChuHang.getTableView().getColumns().size() == 0) {

            tableviewTimKiemChuHang.setController(this);
            tableviewTimKiemChuHang.TaoCot("ten", "Tên", String.class);
            tableviewTimKiemChuHang.TaoCotXemThongTin();
        }
        timKiemChuHangPaginationService.setPagination(id_PaginationTimChuHang);



    }

    public void GanGiaTri(ChuHang chuHang){
        System.out.printf("Gán giá trị");
        this.chuHang = chuHang;

        id_TFTenChuHang.setText(this.chuHang.getTen());
        id_TFDiaChi.setText(this.chuHang.getDiaChi());
        id_TFMST.setText(this.chuHang.getMaSoThue());
        id_RadioHoatDong.setSelected(this.chuHang.isTrangThai());

        themChuyenHangController.GanGiaTriSauKhiTimKiemChuHang(this.chuHang);
    }
    public void SuaThongTin(ActionEvent actionEvent) {
    }

    public void TimChuHang(ActionEvent actionEvent) {

        String chuoiTimChuHang = "%" + id_TFTimKiem.getText() + "%";

        List<ChuHang> chuHangs = chuHangRespository.findByTenLikeOrMaSoThueLike(chuoiTimChuHang,chuoiTimChuHang);

        tableviewTimKiemChuHang.getTableView().getItems().clear();
        timKiemChuHangPaginationService.taiDSPagination(chuHangs,tableviewTimKiemChuHang.getTableView(),20);

    }
}
