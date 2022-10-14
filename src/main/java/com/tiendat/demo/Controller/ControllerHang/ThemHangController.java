package com.tiendat.demo.Controller.ControllerHang;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import com.tiendat.demo.Exception.CV_TX_CHException;
import com.tiendat.demo.Exception.ChiHo_ContHangException;
import com.tiendat.demo.Exception.ChiPhiContHang_ContHangException;
import com.tiendat.demo.ImplementRespository.*;
import com.tiendat.demo.Model.*;
import com.tiendat.demo.ModelView.CongViecTX;
import com.tiendat.demo.ModelView.LoaiCongViecModel;
import com.tiendat.demo.NodeService.ComboBoxService;
import com.tiendat.demo.NodeService.TableViewService;
import com.tiendat.demo.NodeService.TableViewThemService;
import com.tiendat.demo.Respository.*;
import com.tiendat.demo.ThongBao.LoiChuongTrinh;
import com.tiendat.demo.ThongBao.ThongBao;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
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
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
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
    private JFXDatePicker id_Ngay;

    @FXML
    private JFXComboBox<LoaiHang> id_LoaiHang;

    @FXML
    private JFXComboBox<String> id_CangLay;

    @FXML
    private JFXComboBox<CangHa> id_CangHa;

    @FXML
    private JFXComboBox<Xe> id_Xe;

    @FXML
    private JFXComboBox<LoaiChiHo> id_LoaiChiHo;

    @FXML
    private JFXTextField id_TienChiHo;

    @FXML
    private TableView<LoaiChiHo_ContHang> id_TableChiHo;

    @FXML
    private TableColumn<LoaiChiHo_ContHang, String> id_CotNoiDungChiHo;

    @FXML
    private TableColumn<LoaiChiHo_ContHang, Long> id_CotTienChiHo;

    @FXML
    private TableColumn<ChiPhiContHang_ContHang, String> id_CotNoiDungChiPhi;

    @FXML
    private JFXTextField id_SoTienChiPhi;

    @FXML
    private TableView<ChiPhiContHang_ContHang> id_TableChiPhi;

    @FXML
    private TableColumn<ChiPhiContHang_ContHang, Long> id_CotTienChiPhi;

    @FXML
    private JFXComboBox<ChuyenHang> id_ChuyenHang;

    @FXML
    private JFXComboBox<TaiXe> id_TaiXe;

    @FXML
    private JFXComboBox<LoaiCongViecModel> id_LoaiCongViec;

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
    private CongViecTaiXeContHangRespository congViecTaiXeContHangRespository
            = new CongViecTaiXeContHangRespositoryImplement();

    @Autowired
    private ContHangTXCVRespository contHangTXCVRespository = new ContHangTXCVRespositoryImplement();

    @Autowired
    private LoaiChiHoContHangRespository loaiChiHoContHangRespository = new LoaiChiHoContHangRespositoryImplement();

    @Autowired
    private LoaiCongViecChuyenHangRespository loaiCongViecChuyenHangRespository =
            new LoaiCongViec_ChuyenHangRespositoryImplement();

    @Autowired
    private ChiPhiContHangContHangRespository chiPhiContHangContHangRespository = new ChiPhiContHangContHangRespositoryImplement();

    @Autowired
    private ContHangTXCVDAO contHangTXCVDAO;

    private ComboBoxService<LoaiHang> loaiHangComboBoxService = new ComboBoxService<LoaiHang>();

    private ObservableList<LoaiHang> loaiHangs;

    private ComboBoxService<CangLay> cangLayComboBoxService = new ComboBoxService<CangLay>();

    private ObservableList<String> cangLays;
    private List<String> listCangLays;

    private ComboBoxService<CangHa> cangHaComboBoxService = new ComboBoxService<CangHa>();

    private ObservableList<CangHa> cangHas;

    private ComboBoxService<TaiXe> taiXeComboBoxService = new ComboBoxService<TaiXe>();

    private ObservableList<TaiXe> taiXes;

    private ComboBoxService<Xe> xeComboBoxService = new ComboBoxService<Xe>();

    private ObservableList<Xe> xes;

    private ComboBoxService<ChuHang> chuHangComboBoxService = new ComboBoxService<ChuHang>();

    private ObservableList<ChuHang> chuHangs;

    private ComboBoxService<ChuyenHang> chuyenHangComboBoxService = new ComboBoxService<ChuyenHang>();

    private ObservableList<ChuyenHang> chuyenHangs;


    private ComboBoxService<LoaiCongViecModel> loaiCongViecComboBoxService = new ComboBoxService<LoaiCongViecModel>();

    private ObservableList<LoaiCongViecModel> loaiCongViecs;


    private ComboBoxService<LoaiChiHo> loaiChiHoComboBoxService = new ComboBoxService<LoaiChiHo>();

    private ObservableList<LoaiChiHo> loaiChiHos;


    private ComboBoxService<LoaiChiPhiContHang> loaiChiPhiContHangComboBoxService =
            new ComboBoxService<LoaiChiPhiContHang>();

    private TableViewThemService<LoaiChiHo_ContHang,LoaiChiHo> loaiChiHo_contHangTableViewService =
    new TableViewThemService<LoaiChiHo_ContHang,LoaiChiHo>();

    private TableViewThemService<ChiPhiContHang_ContHang,LoaiChiPhiContHang> chiPhiContHang_contHangTableViewService =
            new TableViewThemService<ChiPhiContHang_ContHang,LoaiChiPhiContHang>();

    private TableViewThemService<CongViecTX,LoaiCongViecModel> congViecTXTableViewService =
            new TableViewThemService<CongViecTX,LoaiCongViecModel>();


    private ObservableList<LoaiChiPhiContHang> loaiChiPhiContHangs;


    private ObservableList<LoaiChiHo_ContHang> dsLoaiChiHoContHangs;
    private ObservableList<ChiPhiContHang_ContHang> dsChiPhiContHangContHang;
    private ObservableList<CongViecTX> dsCongViecTX;
    private CangLay cangLaySelectFromCombo;

    @FXML
    void ThemChiHo(ActionEvent event) {

        if(LoiChuongTrinh.textFieldNull(id_TienChiHo)){
            return;
        }

        if(LoiChuongTrinh.ComboBoxNull(id_LoaiChiHo)){
            return;
        }

        if(LoiChuongTrinh.textFieldSo(id_TienChiHo)){
            return;
        }

        Long tien = Long.valueOf(id_TienChiHo.getText());
        LoaiChiHo loaiChiHo = id_LoaiChiHo.getSelectionModel().getSelectedItem();

        LoaiChiHo_ContHang loaiChiHoContHang = new LoaiChiHo_ContHang();
        loaiChiHoContHang.setTien(tien);
        loaiChiHoContHang.setLoaiChiHo(loaiChiHo);

        loaiChiHos.remove(loaiChiHo);
        dsLoaiChiHoContHangs.add(loaiChiHoContHang);
    }

    @FXML
    void ThemCongViec(ActionEvent event) {

        if(LoiChuongTrinh.ComboBoxNull(id_LoaiCongViec) || LoiChuongTrinh.ComboBoxNull(id_ChuyenHang)
        || LoiChuongTrinh.ComboBoxNull(id_ChuHang)){
            return;
        }

        TaiXe taiXe =  id_TaiXe.getSelectionModel().getSelectedItem();
        LoaiCongViecModel loaiCongViec =  id_LoaiCongViec.getSelectionModel().getSelectedItem();
        ChuyenHang chuyenHang = id_ChuyenHang.getSelectionModel().getSelectedItem();
        String tenCongViec = loaiCongViec.getTen();
        System.out.println("chuyenhang id:" + chuyenHang.getId() +", loai cv id:" +loaiCongViec.getIdLoaiCongViec());

        LoaiCongViec_ChuyenHangPK loaiCongViecChuyenHangPK = new LoaiCongViec_ChuyenHangPK();
        loaiCongViecChuyenHangPK.setLoaiCongViecId(loaiCongViec.getIdLoaiCongViec());
        loaiCongViecChuyenHangPK.setChuyenHangId(chuyenHang.getId());

        LoaiCongViec_ChuyenHang loaiCongViec_chuyenHang = loaiCongViecChuyenHangRespository.findById(
                loaiCongViecChuyenHangPK).get();

        CongViecTX congViecTX = new CongViecTX();
        congViecTX.setLoaiCongViec(loaiCongViec);
        congViecTX.setLoaiCongViec_chuyenHang(loaiCongViec_chuyenHang);
        congViecTX.setTaiXe(taiXe);

        loaiCongViecs.remove(loaiCongViec);
        dsCongViecTX.add(congViecTX);
    }

    @FXML
    void ThemContHang(ActionEvent event) {

        String tenCang = id_CangLay.getSelectionModel().getSelectedItem();
        List<JFXTextField> jfxTextFieldList = new ArrayList<JFXTextField>();
        jfxTextFieldList.add(id_SoCont);

        if(LoiChuongTrinh.listTextFielNull(jfxTextFieldList) || LoiChuongTrinh.ComboBoxNull(id_CangHa) ||
                LoiChuongTrinh.ComboBoxNull(id_CangLay) || LoiChuongTrinh.ComboBoxNull(id_Xe) ||
                LoiChuongTrinh.ComboBoxNull(id_LoaiHang)){
           return;
        }
        if(!cangLayRepository.existsByTen(tenCang)){
            System.out.println("Khong Tim Thay Cang");
            return;
        }


        String soCont = id_SoCont.getText();
        Date ngay = Date.valueOf(id_Ngay.getValue());

        Cang cangHa = id_CangHa.getSelectionModel().getSelectedItem();
        Cang cangLay = cangLayRepository.findTop1ByTen(tenCang); //id_CangLay.getSelectionModel().getSelectedItem();
        LoaiHang loaiHang = id_LoaiHang.getSelectionModel().getSelectedItem();

        ChuyenHang chuyenHang = id_ChuyenHang.getSelectionModel().getSelectedItem();
        LoaiCongViecModel loaiCongViec = id_LoaiCongViec.getSelectionModel().getSelectedItem();
        Xe xe = id_Xe.getSelectionModel().getSelectedItem();

        ContHang contHang = new ContHang();
        contHang.setSoCont(soCont);
        contHang.setNgay(ngay);
        contHang.setCangHa(cangHa);
        contHang.setCangLay(cangLay);
        contHang.setLoaiHang(loaiHang);
        contHang.setXe(xe);

        if(KiemTraDsCongViec()) {
            try {
                contHangTXCVDAO.saveDS(dsCongViecTX, dsLoaiChiHoContHangs, dsChiPhiContHangContHang, contHang);
                this.XoaDuLieuNhapCu();
                ThongBao.showThongBaoThanhCong("Thêm Dữ Liệu Cont Hàng");
            }
            catch (ChiHo_ContHangException exception1){
                ThongBao.showThongBaoLoiCVThem2Lan("Bảng Chi Hộ");
            }
            catch (ChiPhiContHang_ContHangException exception2){

                ThongBao.showThongBaoLoiCVThem2Lan("Bảng Chi Phí");
            }
            catch (CV_TX_CHException exception3){

                ThongBao.showThongBaoLoiCVThem2Lan("Bảng Công Việc Tài Xế");
            }
        }
        else {
            ThongBao.showThongBaoLoiDaCoChuyenHang("Bảng Thêm Công Việc");
        }
    }

    private boolean KiemTraDsCongViec() {
        int soLuongCv = dsCongViecTX.size();

        for (CongViecTX congViecTX : dsCongViecTX){
            Character isNguyenChuyen = congViecTX.getLoaiCongViec().getNguyenChuyen();
            if(isNguyenChuyen.toString().equals("T") && (soLuongCv != 1))
                return false;
        }
        return true;
    }

    public void LamMoi(){

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        loaiHangs = FXCollections.observableArrayList(loaiHangRespository.findAllBy());
        loaiHangComboBoxService.setComboBox(id_LoaiHang);
        loaiHangComboBoxService.LoadCombo(loaiHangs);

        listCangLays = cangLayRepository.getAllName();
        cangLays = FXCollections.observableArrayList(listCangLays);
        id_CangLay.setItems(cangLays);
        //cangLayComboBoxService.setComboBox(id_CangLay);
        //cangLayComboBoxService.LoadCombo(cangLays);

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


        id_CotNoiDungChiHo.setCellValueFactory(new PropertyValueFactory<LoaiChiHo_ContHang,String>("noiDung"));
        id_CotTienChiHo.setCellValueFactory(new PropertyValueFactory<LoaiChiHo_ContHang,Long>("tien"));
        id_CotTienChiPhi.setCellValueFactory(new PropertyValueFactory<ChiPhiContHang_ContHang,Long>("tien"));
        id_CotNoiDungChiPhi.setCellValueFactory(new PropertyValueFactory<ChiPhiContHang_ContHang,String>("noiDung"));

        id_CotCongViec.setCellValueFactory(new PropertyValueFactory<CongViecTX,String>("tenCV"));
        id_CotTaiXe.setCellValueFactory(new PropertyValueFactory<CongViecTX,String>("tenTx"));
        id_CotTienTaiXe.setCellValueFactory(new PropertyValueFactory<CongViecTX,Long>("tienTX"));

        dsLoaiChiHoContHangs = FXCollections.observableArrayList();
        id_TableChiHo.setItems(dsLoaiChiHoContHangs);

        dsChiPhiContHangContHang = FXCollections.observableArrayList();
        id_TableChiPhi.setItems(dsChiPhiContHangContHang);

        dsCongViecTX = FXCollections.observableArrayList();
        id_TableCongViec.setItems(dsCongViecTX);

        loaiChiHo_contHangTableViewService.setTableView(id_TableChiHo);
        loaiChiHo_contHangTableViewService.TaoCotXoa(dsLoaiChiHoContHangs,loaiChiHos);

        chiPhiContHang_contHangTableViewService.setTableView(id_TableChiPhi);
        chiPhiContHang_contHangTableViewService.TaoCotXoa(dsChiPhiContHangContHang,loaiChiPhiContHangs);

        congViecTXTableViewService.setTableView(id_TableCongViec);
        congViecTXTableViewService.TaoCotXoa(dsCongViecTX,loaiCongViecs);

        id_CangLay.setEditable(true);

        id_CangLay.getEditor().textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable,
                                String oldValue, String newValue) {

                System.out.println("New Value " + newValue);
                System.out.println("DS Cảng LẤy " + id_CangLay.getItems());
                listCangLays.forEach(e->{
                    if(!e.trim().toLowerCase().contains(newValue.trim().toLowerCase()))
                        cangLays.remove(e);
                    else if(!cangLays.contains(e))
                        cangLays.add(e);
                });

                id_CangLay.show();
            }
        });
    }

    public void LoadCBChuyenHang(ActionEvent actionEvent) {

        id_ChuyenHang.setDisable(false);

        ChuHang chuHang = id_ChuHang.getSelectionModel().getSelectedItem();
        chuyenHangs.clear();
        chuyenHangs.addAll(chuyenHangRespository.findByChuHang(chuHang));
        id_LoaiCongViec.setDisable(true);
    }

    //ngày 10/07/2022 thay đổi kiểm tra null Chuyến hàng và dsCVModel
    public void LoadCBLoaiCongViec(ActionEvent actionEvent) {

        id_LoaiCongViec.setDisable(false);
        List<Map<String, Object>> dsCVModel = null;
        ChuyenHang chuyenHang = id_ChuyenHang.getSelectionModel().getSelectedItem();
        if(chuyenHang != null)
            dsCVModel =  loaiCongViecRepository.layDSLoaiCongViecModel(chuyenHang.getId());

        loaiCongViecs.clear();
        if(dsCVModel != null)
            loaiCongViecs.addAll(ChuyenThanhDsLoaiCongViec(dsCVModel));
        dsCongViecTX.clear();
    }

    private List<LoaiCongViecModel> ChuyenThanhDsLoaiCongViec(List<Map<String, Object>> list){
        List<LoaiCongViecModel> loaiCongViecModels = new ArrayList<LoaiCongViecModel>();
        for (Map<String, Object> x : list){
            loaiCongViecModels.add(new LoaiCongViecModel(x));
        }
        return loaiCongViecModels;
    }
    public void ThemChiPhi(ActionEvent actionEvent) {

        if(LoiChuongTrinh.textFieldNull(id_SoTienChiPhi)){
            return;
        }

        if(LoiChuongTrinh.ComboBoxNull(id_LoaiChiPhi)){
            return;
        }

        if(LoiChuongTrinh.textFieldSo(id_SoTienChiPhi)){
            return;
        }

        LoaiChiPhiContHang loaiChiPhiContHang = id_LoaiChiPhi.getSelectionModel().getSelectedItem();
        Long tien = Long.valueOf(id_SoTienChiPhi.getText());

        ChiPhiContHang_ContHang chiPhiContHangContHang = new ChiPhiContHang_ContHang();
        chiPhiContHangContHang.setTien(tien);
        chiPhiContHangContHang.setLoaiChiPhiContHang(loaiChiPhiContHang);


        loaiChiPhiContHangs.remove(loaiChiPhiContHang);
        dsChiPhiContHangContHang.add(chiPhiContHangContHang);
    }
    private void XoaDuLieuNhapCu(){
        id_SoCont.setText("");
        id_SoTienChiPhi.setText("");
        id_TienChiHo.setText("");

        dsChiPhiContHangContHang.forEach(e->{
            loaiChiPhiContHangs.add(e.getLoaiChiPhiContHang());
        });
        dsChiPhiContHangContHang.clear();

        dsLoaiChiHoContHangs.forEach(e->{
            loaiChiHos.add(e.getLoaiChiHo());
        });
        dsLoaiChiHoContHangs.clear();

        dsCongViecTX.forEach(e->{
            loaiCongViecs.add(e.getLoaiCongViec());
        });
        dsCongViecTX.clear();
    }
}
