package com.tiendat.demo.Controller.ControllerHang;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTabPane;
import com.jfoenix.controls.JFXTextField;
import com.tiendat.demo.ImplementRespository.*;
import com.tiendat.demo.Model.*;
import com.tiendat.demo.NodeService.*;
import com.tiendat.demo.Respository.*;
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
import java.net.URL;
import java.sql.Date;
import java.util.List;
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

    private TableView<ContHang> contHangTableView;

    private PaginationService paginationService ;

    @Autowired
    private ContHangRespository contHangRespository = new ContHangRespositoryImplement();

    @Autowired
    private ChuHangRespository chuHangRespository = new ChuHangRespositoryImplement();

    @Autowired
    private LoaiHangRespository loaiHangRespository = new LoaiHangRespositoryImplement();

    @Autowired
    private CangHaRepository cangHaRepository = new CangHaRespositoryImplement();

    @Autowired
    private CangLayRepository cangLayRepository = new CangLayRespositoryImplement();

    @Autowired
    private XeRespository xeRespository = new XeRespositoryImplement();

    @Autowired
    private CongViecContHangController congViecContHangController;

    @Autowired
    private ChiPhiContHangController chiPhiContHangController;

    @Autowired
    private ChiHoContHangController chiHoContHangController;

    private ComboBoxObjectService comboBoxObjectService = new ComboBoxObjectService();

    private ContHang contHang;


    private TableViewService<ContHang, TimKiemContHangController> tableViewService =
            new TableViewService<>();

    @Autowired
    private ConfigurableApplicationContext springContext;

    @FXML
    private JFXTextField id_TextTimKiem;

    @FXML
    private Pagination id_PaginationTimKiem;

    @FXML
    private JFXTextField id_TextSoCont;

    @FXML
    private JFXDatePicker id_Ngay;

    @FXML
    private JFXComboBox<ChuHang> id_CBChuHang;

    @FXML
    private JFXTextField id_TextSoSeal;

    @FXML
    private JFXComboBox<LoaiHang> id_CBLoaiHang;

    @FXML
    private JFXComboBox<CangLay> id_CBCangLay;

    @FXML
    private JFXComboBox<CangHa> id_CBCangHa;

    @FXML
    private JFXComboBox<Xe> id_CBXe;

    @FXML
    private JFXTabPane id_TabpaneThongTinContHang;

    private ObservableList<LoaiHang> loaiHangs;

    private ObservableList<CangHa> cangHas;

    private ObservableList<CangLay> cangLays;

    private ObservableList<Xe> xes;

    @FXML
    void SuaThongTin(ActionEvent event) {

        if(contHang == null){
            ThongBao.showThongBao("Thông Tin Cont Hàng","Cập Nhật","Chưa Chọn Cont Hàng");
            return;
        }

        contHang.setXe(id_CBXe.getSelectionModel().getSelectedItem());
        contHang.setLoaiHang(id_CBLoaiHang.getSelectionModel().getSelectedItem());
        contHang.setCangLay(id_CBCangLay.getSelectionModel().getSelectedItem());
        contHang.setCangHa(id_CBCangHa.getSelectionModel().getSelectedItem());
        contHang.setSoCont(id_TextSoCont.getText());
        contHang.setNgay(Date.valueOf(id_Ngay.getValue()));

        contHangRespository.save(contHang);
        ThongBao.showThongBao("Thông Tin Cont Hàng","Cập Nhật", "Thành Công");
    }

    @FXML
    void TimKiem(ActionEvent event) {

        String soCont = "%"+id_TextTimKiem.getText()+"%";
        List<ContHang> contHangs = contHangRespository.findAllBySoContLike(soCont);
        paginationService.taiDSPagination(contHangs,tableViewService.getTableView(),10);
    }

    public void LamMoi(){

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        comboBoxObjectService.LoadCombo(((List) chuHangRespository.findAllByTrangThaiTrue()),
                ((JFXComboBox)id_CBChuHang));

        loaiHangs = FXCollections.observableArrayList(loaiHangRespository.findAllBy());
        id_CBLoaiHang.setItems(loaiHangs);

        cangHas = FXCollections.observableArrayList(cangHaRepository.findAllBy());
        id_CBCangHa.setItems(cangHas);

        cangLays = FXCollections.observableArrayList(cangLayRepository.findAllBy());
        id_CBCangLay.setItems(cangLays);

        xes = FXCollections.observableArrayList(xeRespository.findAllBy());
        id_CBXe.setItems(xes);

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

        paginationService = new PaginationService();
        paginationService.setPagination(id_PaginationTimKiem);
        contHangTableView = new TableView<>();
        tableViewService.setTableView(contHangTableView);
        tableViewService.setController(this);
        tableViewService.TaoCot("soCont","Số Cont",String.class);
        tableViewService.TaoCotXemThongTin();
    }

    public ContHang getContHang() {
        return contHang;
    }

    public void setContHang(ContHang contHang) {
        this.contHang = contHang;
    }

    public void GanGiaTri(ContHang contHang){
        this.contHang = contHang;
        id_TextSoCont.setText(contHang.getSoCont());
        id_CBChuHang.getSelectionModel().select(chuHangRespository.LayChuHangTuContHang(contHang.getId()));
        id_CBLoaiHang.getSelectionModel().select(this.SeclectLoaiHang(contHang));
        id_CBCangHa.getSelectionModel().select(this.SeclectCangHa(contHang));
        id_CBCangLay.getSelectionModel().select(this.SeclectCangLay(contHang));
        id_CBXe.getSelectionModel().select(this.SeclectXe(contHang));
        id_Ngay.setValue(contHang.getNgay().toLocalDate());

        congViecContHangController.setContHang(contHang);
        chiPhiContHangController.setContHang(contHang);
        chiHoContHangController.setContHang(contHang);
    }

    private Xe SeclectXe(ContHang contHang) {
        for(Xe e : xes) {
            if (e.getId() == contHang.getXe().getId())
                return e;
        }
        return null;
    }

    private CangLay SeclectCangLay(ContHang contHang) {
        for(CangLay e : cangLays) {
            if (e.getId() == contHang.getCangLay().getId())
                return e;
        }
        return null;
    }

    private CangHa SeclectCangHa(ContHang contHang) {
        for(CangHa e : cangHas) {
            if (e.getId() == contHang.getCangHa().getId())
                return e;
        }
        return null;
    }

    private LoaiHang SeclectLoaiHang(ContHang contHang){
        for(LoaiHang e : loaiHangs) {
            if (e.getId() == contHang.getLoaiHang().getId())
                return e;
        }
        return null;
    }
}
