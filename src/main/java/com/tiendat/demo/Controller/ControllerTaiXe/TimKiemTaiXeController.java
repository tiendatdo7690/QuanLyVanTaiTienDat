package com.tiendat.demo.Controller.ControllerTaiXe;

import com.jfoenix.controls.*;
import com.tiendat.demo.ImplementRespository.TaiXeRespositoryImplement;
import com.tiendat.demo.ImplementRespository.XeRespositoryImplement;
import com.tiendat.demo.Model.TaiXe;
import com.tiendat.demo.Model.Xe;
import com.tiendat.demo.NodeService.PaginationService;
import com.tiendat.demo.NodeService.TabPaneService;
import com.tiendat.demo.NodeService.TabService;
import com.tiendat.demo.NodeService.TableViewService;
import com.tiendat.demo.Respository.TaiXeRepository;
import com.tiendat.demo.Respository.XeRespository;
import com.tiendat.demo.ThongBao.ThongBao;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Pagination;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.sql.Date;
import java.util.List;
import java.util.ResourceBundle;

@Component
public class TimKiemTaiXeController implements Initializable {

    @FXML
    private JFXTextField id_TextTimKiem;

    @FXML
    private JFXButton id_ButtonTimKiemTX;

    @FXML
    private Pagination id_PaginationTimKiemTX;

    @FXML
    private  JFXRadioButton id_TinhTrangTaiXeTimKiem;
    @FXML
    private JFXButton id_ButtonSuaThongTin;

    @FXML
    private JFXButton id_ButtonThemTienUng;

    @FXML
    private JFXButton id_ButtonThemTienThuong;

    @FXML
    private JFXButton id_ButtonCapNhatLuongCoBan;

    @FXML
    private JFXButton id_ButtonTaoBangLuong;

    @FXML
    private JFXTextField id_TextTenTX;

    @FXML
    private JFXTextField id_TextQuenQuan;

    @FXML
    private JFXRadioButton id_RadioHoatDong;

    @FXML
    private JFXComboBox<Xe> id_CBXe;

    @FXML
    private JFXDatePicker id_DateNgaySinh;

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

    @Autowired
    private TaiXeRepository taiXeRepository = new TaiXeRespositoryImplement();
    @Autowired
    private XeRespository xeRespository = new XeRespositoryImplement();

    @Autowired
    private ThongKeTaiXeController thongKeTaiXeController;

    private TableViewService<TaiXe, TimKiemTaiXeController> taixeTableViewService =
            new TableViewService<>();

    private TableView<TaiXe> taiXeTableView;

    private PaginationService paginationService = new PaginationService();;

    private ObservableList<Xe> xeObservableList;
    private TaiXe taiXe;
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

        paginationService.setPagination(id_PaginationTimKiemTX);
        taiXeTableView = new TableView<TaiXe>();
        taixeTableViewService.setTableView(taiXeTableView);
        taixeTableViewService.setController(this);
        taixeTableViewService.TaoCot("ten","Tên Tài Xế", String.class);
        taixeTableViewService.TaoCotXemThongTin();

        xeObservableList = FXCollections.observableArrayList(
                xeRespository.findAllByTaiXe(null)
        );
        id_CBXe.setItems(xeObservableList);
    }

    public void GanGiaTri(TaiXe taiXe){

        if( this.taiXe != null){
            xeObservableList.remove(this.taiXe.getXe());
        }

        this.taiXe = taiXe;
        id_TextTenTX.setText(taiXe.getTen());
        id_TextQuenQuan.setText(taiXe.getQueQuan());
        id_DateNgaySinh.setValue(taiXe.getNgaySinh().toLocalDate());
        id_RadioHoatDong.setSelected(taiXe.isTrangThai());
        if(taiXe.getXe() != null) {
            xeObservableList.add(taiXe.getXe());
            id_CBXe.getSelectionModel().select(taiXe.getXe());
        }
        thongKeTaiXeController.setTaiXe(taiXe);
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
        tabPaneService.addTab(springContext,id_TabpaneThongTinTaiXe,capNhatLuongCBTabService,
                "/fxml/TaiXe/CapNhatLuongCB.fxml",capNhatBangLuongController);
    }

    public void TaoTabTaoBangLuong(ActionEvent actionEvent) throws InvocationTargetException, NoSuchMethodException,
            IllegalAccessException, IOException{
        tabPaneService.addTab(springContext,id_TabpaneThongTinTaiXe,taoBangLuongTabService,
                "/fxml/TaiXe/TaoBangLuong.fxml",taoBangLuongController);
    }

    public void TimKiemTX(ActionEvent actionEvent) {

        String ten = "%"+id_TextTimKiem.getText()+"%";
        Boolean tinhTrang = id_TinhTrangTaiXeTimKiem.isSelected();
        List<TaiXe> taiXes = taiXeRepository.findAllByTenLikeAndTrangThai(ten,tinhTrang);
        paginationService.taiDSPagination(taiXes,taixeTableViewService.getTableView(),20);

    }

    public TaiXe getTaiXe() {
        return taiXe;
    }

    public void SuaThongTinTaiXe(ActionEvent actionEvent) {
        if(taiXe == null){
            ThongBao.showThongBao("Thông Tin Tài Xế","Cập Nhật",
                    "Chưa chọn Tài Xế");
            return;
        }

        Xe xe = this.taiXe.getXe();
        this.taiXe.setQueQuan(id_TextQuenQuan.getText());
        this.taiXe.setNgaySinh(Date.valueOf(id_DateNgaySinh.getValue()));
        this.taiXe.setTrangThai(id_RadioHoatDong.isSelected());
        this.taiXe.setXe(id_CBXe.getSelectionModel().getSelectedItem());
        this.taiXe.setTen(id_TextTenTX.getText());

        taiXeRepository.save(this.taiXe);

        xe.setTaiXe(null);
        xeRespository.save(xe);

        ThongBao.showThongBao("Thông Tin Tài Xế","Cập Nhật", "Thành Công");


    }
}
