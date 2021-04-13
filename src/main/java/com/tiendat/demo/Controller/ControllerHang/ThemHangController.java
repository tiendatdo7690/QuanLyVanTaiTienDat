package com.tiendat.demo.Controller.ControllerHang;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import com.tiendat.demo.ImplementRespository.*;
import com.tiendat.demo.Model.*;
import com.tiendat.demo.ModelView.CongViecTX;
import com.tiendat.demo.NodeService.ComboBoxService;
import com.tiendat.demo.Respository.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.net.URL;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ResourceBundle;

//Ngày 11/4 Thêm Hàng
@Component
public class ThemHangController implements Initializable {

    @FXML
    private JFXComboBox<LoaiChiPhiContHang> id_LoaiChiPhi;

    @FXML
    private JFXTextField id_NoiDungChiPhi;
    @FXML
    private JFXTextField id_SoCont;

    @FXML
    private JFXTextField id_SoSeal;

    @FXML
    private JFXComboBox<LoaiHang> id_LoaiHang;

    @FXML
    private JFXComboBox<CangLay> id_CangLay;

    @FXML
    private JFXComboBox<CangHa> id_CangHa;

    @FXML
    private JFXComboBox<Xe> id_Xe;

    @FXML
    private JFXComboBox<LoaiChiHo> id_LoaiChiHo;

    @FXML
    private JFXTextField id_TienChiHo;

    @FXML
    private TableView<ChiHo> id_TableChiHo;

    @FXML
    private TableColumn<ChiHo, String> id_CotNoiDungChiHo;

    @FXML
    private TableColumn<ChiHo, Long> id_CotTienChiHo;

    @FXML
    private TableColumn<ChiPhiContHang, String> id_CotNoiDungChiPhi;

    @FXML
    private JFXTextField id_SoTienChiPhi;

    @FXML
    private TableView<ChiPhiContHang> id_TableChiPhi;

    @FXML
    private TableColumn<ChiPhiContHang, Long> id_CotTienChiPhi;

    @FXML
    private JFXComboBox<ChuyenHang> id_ChuyenHang;

    @FXML
    private JFXComboBox<TaiXe> id_TaiXe;

    @FXML
    private JFXComboBox<LoaiCongViec> id_LoaiCongViec;

    @FXML
    private JFXComboBox<ChuHang> id_ChuHang;

    @FXML
    private TableView<CongViecTX> id_TableCongViec;

    @FXML
    private TableColumn<CongViecTX, String> id_CotCongViec;

    @FXML
    private TableColumn<CongViecTX, String> id_CotTaiXe;

    @FXML
    private TableColumn<CongViecTX, Long> id_CotTienTaiXe;


    @Autowired
    private LoaiHangRespository loaiHangRespository = new LoaiHangRespositoryImplement();

    @Autowired
    private CangHaRepository cangHaRepository = new CangHaRespositoryImplement();

    @Autowired
    private CangLayRepository cangLayRepository = new CangLayRespositoryImplement();

    @Autowired
    private TaiXeRepository taiXeRepository = new TaiXeRespositoryImplement();

    @Autowired
    private XeRespository xeRespository = new XeRespositoryImplement();

    @Autowired
    private ChuHangRespository chuHangRespository = new ChuHangRespositoryImplement();

    @Autowired
    private LoaiChiHoRespository loaiChiHoRespository = new LoaiChiHoRespositoryImplement();

    @Autowired
    private ChuyenHangRespository chuyenHangRespository = new ChuyenHangRespositoryImplement();

    @Autowired
    private LoaiCongViecRepository loaiCongViecRepository = new LoaiCongViecRepositoryImplement();

    @Autowired
    private ContHangRespository contHangRespository = new ContHangRespositoryImplement();

    @Autowired
    private LoaiChiPhiContHangRespository loaiChiPhiContHangRespository = new LoaiChiPhiContHangRespositoryImplement();

    @Autowired
    private CongViecRespository congViecRespository = new CongViecRespositoryImplement();

    @Autowired
    private ComboBoxService<LoaiHang> loaiHangComboBoxService;

    private ObservableList<LoaiHang> loaiHangs;

    @Autowired
    private ComboBoxService<CangLay> cangLayComboBoxService;

    private ObservableList<CangLay> cangLays;

    @Autowired
    private ComboBoxService<CangHa> cangHaComboBoxService;

    private ObservableList<CangHa> cangHas;

    @Autowired
    private ComboBoxService<TaiXe> taiXeComboBoxService;

    private ObservableList<TaiXe> taiXes;

    @Autowired
    private ComboBoxService<Xe> xeComboBoxService;

    private ObservableList<Xe> xes;

    @Autowired
    private ComboBoxService<ChuHang> chuHangComboBoxService;

    private ObservableList<ChuHang> chuHangs;

    @Autowired
    private ComboBoxService<ChuyenHang> chuyenHangComboBoxService;

    private ObservableList<ChuyenHang> chuyenHangs;

    @Autowired
    private ComboBoxService<LoaiCongViec> loaiCongViecComboBoxService;

    private ObservableList<LoaiCongViec> loaiCongViecs;

    @Autowired
    private ComboBoxService<LoaiChiHo> loaiChiHoComboBoxService;

    private ObservableList<LoaiChiHo> loaiChiHos;

    @Autowired
    private ComboBoxService<LoaiChiPhiContHang> loaiChiPhiContHangComboBoxService;

    private ObservableList<LoaiChiPhiContHang> loaiChiPhiContHangs;


    private ObservableList<ChiHo> dsChiHos;
    private ObservableList<ChiPhiContHang> dsChiPhiContHang;
    private ObservableList<CongViecTX> dsCongViecTX;

    @FXML
    void ThemChiHo(ActionEvent event) {

        Long tien = Long.valueOf(id_TienChiHo.getText());
        LoaiChiHo loaiChiHo = id_LoaiChiHo.getSelectionModel().getSelectedItem();

        ChiHo chiHo = new ChiHo();
        chiHo.setTien(tien);
        chiHo.setLoaiChiHo(loaiChiHo);

        dsChiHos.add(chiHo);
    }

    @FXML
    void ThemCongViec(ActionEvent event) {

        TaiXe taiXe =  id_TaiXe.getSelectionModel().getSelectedItem();
        LoaiCongViec loaiCongViec =  id_LoaiCongViec.getSelectionModel().getSelectedItem();
        ChuyenHang chuyenHang = id_ChuyenHang.getSelectionModel().getSelectedItem();
        String tenTaiXe = taiXe.getTen();
        String congViec = loaiCongViec.getTen();
        Long tienTx = congViecRespository.layCVBangChuyenHangVaLoaiCV(chuyenHang,loaiCongViec).getTienCong();
        System.out.println("Tiền TX: "+tienTx);

        CongViecTX congViecTX = new CongViecTX();
        congViecTX.setTenCV(congViec);
        congViecTX.setTenTx(tenTaiXe);
        congViecTX.setTienTX(tienTx);

        dsCongViecTX.add(congViecTX);
    }

    @FXML
    void ThemContHang(ActionEvent event) {

        String soCont = id_SoCont.getText();
        String soSeal = id_SoSeal.getText();
        Date ngay = Date.valueOf(LocalDate.now());

        Cang cangHa = id_CangHa.getSelectionModel().getSelectedItem();
        Cang cangLay = id_CangLay.getSelectionModel().getSelectedItem();
        LoaiHang loaiHang = id_LoaiHang.getSelectionModel().getSelectedItem();

        ContHang contHang = new ContHang();
        contHang.setSoCont(soCont);
        contHang.setSoSeal(soSeal);
        contHang.setNgay(ngay);
        contHang.setCangHa(cangHa);
        contHang.setCangLay(cangLay);
        contHang.setLoaiHang(loaiHang);

        contHangRespository.save(contHang);

        dsChiHos.forEach(e->{
            e.setContHang(contHang);
        });

    }

    public void LamMoi(){

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        loaiHangs = FXCollections.observableArrayList(loaiHangRespository.findAllBy());
        loaiHangComboBoxService.setComboBox(id_LoaiHang);
        loaiHangComboBoxService.LoadCombo(loaiHangs);

        cangLays = FXCollections.observableArrayList(cangLayRepository.findAllBy());
        cangLayComboBoxService.setComboBox(id_CangLay);
        cangLayComboBoxService.LoadCombo(cangLays);

        cangHas = FXCollections.observableArrayList(cangHaRepository.findAllBy());
        cangHaComboBoxService.setComboBox(id_CangHa);
        cangHaComboBoxService.LoadCombo(cangHas);

        taiXes = FXCollections.observableArrayList(taiXeRepository.findAllByTrangThaiTrue());
        taiXeComboBoxService.setComboBox(id_TaiXe);
        taiXeComboBoxService.LoadCombo(taiXes);

        xes = FXCollections.observableArrayList(xeRespository.findAllByTrangThaiTrue());
        xeComboBoxService.setComboBox(id_Xe);
        xeComboBoxService.LoadCombo(xes);

        chuHangs = FXCollections.observableArrayList(chuHangRespository.findAllByTrangThaiTrue());
        chuHangComboBoxService.setComboBox(id_ChuHang);
        chuHangComboBoxService.LoadComboNoSelectFirts(chuHangs);

        loaiChiHos = FXCollections.observableArrayList(loaiChiHoRespository.findAllBy());
        loaiChiHoComboBoxService.setComboBox(id_LoaiChiHo);
        loaiChiHoComboBoxService.LoadCombo(loaiChiHos);

        loaiChiPhiContHangs = FXCollections.observableArrayList(loaiChiPhiContHangRespository.findAllBy());
        loaiChiPhiContHangComboBoxService.setComboBox(id_LoaiChiPhi);
        loaiChiPhiContHangComboBoxService.LoadCombo(loaiChiPhiContHangs);

        chuyenHangs = FXCollections.observableArrayList();
        chuyenHangComboBoxService.setComboBox(id_ChuyenHang);
        chuyenHangComboBoxService.LoadComboNoSelectFirts(chuyenHangs);

        loaiCongViecs = FXCollections.observableArrayList();
        loaiCongViecComboBoxService.setComboBox(id_LoaiCongViec);
        loaiCongViecComboBoxService.LoadCombo(loaiCongViecs);

        id_ChuyenHang.setDisable(true);
        id_LoaiCongViec.setDisable(true);


        id_CotNoiDungChiHo.setCellValueFactory(new PropertyValueFactory<ChiHo,String>("noiDung"));
        id_CotTienChiHo.setCellValueFactory(new PropertyValueFactory<ChiHo,Long>("tien"));
        id_CotTienChiPhi.setCellValueFactory(new PropertyValueFactory<ChiPhiContHang,Long>("tien"));
        id_CotNoiDungChiPhi.setCellValueFactory(new PropertyValueFactory<ChiPhiContHang,String>("noiDung"));

        id_CotCongViec.setCellValueFactory(new PropertyValueFactory<CongViecTX,String>("tenCV"));
        id_CotTaiXe.setCellValueFactory(new PropertyValueFactory<CongViecTX,String>("tenTx"));
        id_CotTienTaiXe.setCellValueFactory(new PropertyValueFactory<CongViecTX,Long>("tienTX"));

        dsChiHos = FXCollections.observableArrayList();
        id_TableChiHo.setItems(dsChiHos);

        dsChiPhiContHang = FXCollections.observableArrayList();
        id_TableChiPhi.setItems(dsChiPhiContHang);

        dsCongViecTX = FXCollections.observableArrayList();
        id_TableCongViec.setItems(dsCongViecTX);
    }

    public void LoadCBChuyenHang(ActionEvent actionEvent) {

        id_ChuyenHang.setDisable(false);

        ChuHang chuHang = id_ChuHang.getSelectionModel().getSelectedItem();
        chuyenHangs.clear();
        chuyenHangs.addAll(chuyenHangRespository.findByChuHang(chuHang));
        id_LoaiCongViec.setDisable(true);
    }

    public void LoadCBLoaiCongViec(ActionEvent actionEvent) {

        id_LoaiCongViec.setDisable(false);

        ChuyenHang chuyenHang = id_ChuyenHang.getSelectionModel().getSelectedItem();

        loaiCongViecs.clear();
        loaiCongViecs.addAll(loaiCongViecRepository.layDSLoaiCV_ChuyenHang(chuyenHang));
    }

    public void ThemChiPhi(ActionEvent actionEvent) {

        LoaiChiPhiContHang loaiChiPhiContHang = id_LoaiChiPhi.getSelectionModel().getSelectedItem();
        Long tien = Long.valueOf(id_SoTienChiPhi.getText());

        ChiPhiContHang chiPhiContHang = new ChiPhiContHang();
        chiPhiContHang.setTien(tien);
        chiPhiContHang.setLoaiChiPhiContHang(loaiChiPhiContHang);

        dsChiPhiContHang.add(chiPhiContHang);
    }
}
