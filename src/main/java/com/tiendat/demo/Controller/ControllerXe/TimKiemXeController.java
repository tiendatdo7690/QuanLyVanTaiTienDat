package com.tiendat.demo.Controller.ControllerXe;

import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.JFXTabPane;
import com.jfoenix.controls.JFXTextField;
import com.tiendat.demo.ImplementRespository.XeRespositoryImplement;
import com.tiendat.demo.Model.Xe;
import com.tiendat.demo.NodeService.PaginationService;
import com.tiendat.demo.NodeService.TabPaneService;
import com.tiendat.demo.NodeService.TabService;
import com.tiendat.demo.NodeService.TableViewService;
import com.tiendat.demo.Respository.XeRespository;
import com.tiendat.demo.ThongBao.ThongBao;
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
import java.util.List;
import java.util.ResourceBundle;

@Component
public class TimKiemXeController implements Initializable {

    @FXML
    private JFXTextField id_BienSoXe;

    @FXML
    private JFXTextField id_HieuXe;

    @FXML
    private JFXTextField id_Taixe;

    @FXML
    private JFXTextField id_NamSX;

    @FXML
    private JFXRadioButton id_ConHoatDong;

    @FXML
    private JFXTabPane id_TabpaneThongTinXe;

    @FXML
    private AnchorPane id_AnchaorPaneTabThongKeXe;

    @FXML
    private AnchorPane id_AnchaorPaneTabThongKeLoiNhuan;

    @FXML
    private JFXTextField id_TFTimKiem;

    @FXML
    private Pagination id_PaginationXeTimKiem;

    @FXML
    private JFXRadioButton id_TrangThaiXeTimKiem;


    private PaginationService paginationService = new PaginationService();

    private TabPaneService tabPaneService;

    @Autowired
    private ConfigurableApplicationContext springContext;

    private TabService themChiPhiDauTabService;
    private TabService themChiPhiXetXeTabService;
    private TabService themChiPhiVoXeTabService;
    private TabService themChiPhiThayNhotTabService;
    private TabService themChiPhiKhacTabService;

    @Autowired
    private ThemChiPhiDauController themChiPhiDauController;

    @Autowired
    private ThemChiPhiXetXeController themChiPhiXetXeController;

    @Autowired
    private ThemChiPhiVoXeController themChiPhiVoXeController;

    @Autowired
    private ThemChiPhiThayNhotController themChiPhiThayNhotController;

    @Autowired
    private ThemChiPhiKhacController themChiPhiKhacController;

    @Autowired
    private XeRespository xeRespository = new XeRespositoryImplement();

    private TableView<Xe> xeTableView;

    private Xe xe;


    private TableViewService<Xe,TimKiemXeController> xeTableViewService =
            new TableViewService<>();

    public void LamMoi(){

    }

    @FXML
    void TimKiemXe(ActionEvent event) {

        String bienSo = "%"+id_TFTimKiem.getText()+"%";
        Boolean trangThai = id_TrangThaiXeTimKiem.isSelected();
        List<Xe> xes = xeRespository.findAllByBienSoLikeAndTrangThai(bienSo,trangThai);
        paginationService.taiDSPagination(xes,xeTableViewService.getTableView(),20);

    }

    public void GanGiaTri(Xe xe){
        this.xe = xe;
        id_BienSoXe.setText(xe.getBienSo());
        id_HieuXe.setText(xe.getHieuXe());
        id_NamSX.setText(String.valueOf(xe.getNamSX()));
        id_ConHoatDong.setSelected(xe.isTrangThai());
        String taiXe = xe.getTaiXe() == null ? "Chưa Có Tài xế" : xe.getTaiXe().getTen();

        id_Taixe.setText(taiXe);
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        tabPaneService = new TabPaneService();
        themChiPhiDauTabService = new TabService("Thêm CP Dầu");
        themChiPhiXetXeTabService = new TabService("Thêm CP Xét Xe");
        themChiPhiVoXeTabService = new TabService("Thêm CP Vỏ Xe");
        themChiPhiThayNhotTabService = new TabService("Thêm CP Thay Nhớt");
        themChiPhiKhacTabService = new TabService("Thêm CP Khác");

        try {
            tabPaneService.addContentInTab(springContext,id_AnchaorPaneTabThongKeXe,"/fxml/Xe/ThongKeXe.fxml");
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            tabPaneService.addContentInTab(springContext,id_AnchaorPaneTabThongKeLoiNhuan,"/fxml/Xe/ThongKeLoiNhuan.fxml");
        } catch (IOException e) {
            e.printStackTrace();
        }

        paginationService.setPagination(id_PaginationXeTimKiem);

        xeTableView = new TableView<Xe>();
        xeTableViewService.setTableView(xeTableView);
        xeTableViewService.setController(this);
        xeTableViewService.TaoCot("bienSo","Biển Số Xe", String.class);
        xeTableViewService.TaoCotXemThongTin();
    }

    public void addTabThemChiPhiDau(ActionEvent actionEvent) throws InvocationTargetException, NoSuchMethodException,
            IllegalAccessException, IOException {
        tabPaneService.addTab(springContext,id_TabpaneThongTinXe,themChiPhiDauTabService,
                "/fxml/Xe/ThemChiPhiDau.fxml",themChiPhiDauController);
    }

    public void addTabThemChiPhiXetXe(ActionEvent actionEvent) throws InvocationTargetException, NoSuchMethodException,
            IllegalAccessException, IOException {
        tabPaneService.addTab(springContext,id_TabpaneThongTinXe,themChiPhiXetXeTabService,
                "/fxml/Xe/ThemChiPhiXetXe.fxml",themChiPhiXetXeController);
    }

    public void addTabThemChiPhiVoXe(ActionEvent actionEvent)throws InvocationTargetException, NoSuchMethodException,
            IllegalAccessException, IOException {
        tabPaneService.addTab(springContext,id_TabpaneThongTinXe,themChiPhiVoXeTabService,
                "/fxml/Xe/ThemChiPhiVoXe.fxml",themChiPhiVoXeController);
    }

    public void addTabThemChiPhiThayNhot(ActionEvent actionEvent)throws InvocationTargetException, NoSuchMethodException,
            IllegalAccessException, IOException {
        tabPaneService.addTab(springContext,id_TabpaneThongTinXe,themChiPhiThayNhotTabService,
                "/fxml/Xe/ThemChiPhiThayNhot.fxml",themChiPhiThayNhotController);
    }

    public void addTabThemChiPhiKhac(ActionEvent actionEvent)throws InvocationTargetException, NoSuchMethodException,
            IllegalAccessException, IOException {
        tabPaneService.addTab(springContext,id_TabpaneThongTinXe,themChiPhiKhacTabService,
                "/fxml/Xe/ThemChiPhiKhac.fxml",themChiPhiKhacController);
    }

    public Xe getXe() {
        return xe;
    }

    public void SuaThongTinXe(ActionEvent actionEvent) {
        if(xe == null){
            ThongBao.showThongBao("Thông Tin Xe","Cập Nhật",
                    "Chưa Chọn Xe");
            return;
        }

        xe.setHieuXe(id_HieuXe.getText());
        xe.setTrangThai(id_ConHoatDong.isSelected());
        xe.setBienSo(id_BienSoXe.getText());
        //xe.setNamSX(id_NamSX.getText());

        xeRespository.save(xe);

        ThongBao.showThongBao("Thông Tin Xe","Cập Nhật", "Thành Công");

    }
}
