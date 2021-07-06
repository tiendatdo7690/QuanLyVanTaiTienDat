package com.tiendat.demo.Controller.ControllerHang;

import com.jfoenix.controls.JFXComboBox;
import com.tiendat.demo.Exception.CV_TX_CHException;
import com.tiendat.demo.Exception.ChiHo_ContHangException;
import com.tiendat.demo.Exception.ChiPhiContHang_ContHangException;
import com.tiendat.demo.ImplementRespository.*;
import com.tiendat.demo.Model.*;
import com.tiendat.demo.ModelView.ChuHang_ChuyenHangModel;
import com.tiendat.demo.ModelView.ChuyenHangTaiXe;
import com.tiendat.demo.ModelView.CongViecTX;
import com.tiendat.demo.ModelView.LoaiCongViecModel;
import com.tiendat.demo.NodeService.ComboBoxObjectService;
import com.tiendat.demo.NodeService.TableViewThemService;
import com.tiendat.demo.Respository.*;
import com.tiendat.demo.ThongBao.LoiChuongTrinh;
import com.tiendat.demo.ThongBao.ThongBao;
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
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;

@Component
public class CongViecContHangController implements Initializable {

    @FXML
    private JFXComboBox<ChuHang> id_CBChuHang;

    @FXML
    private JFXComboBox<ChuyenHang> id_CBChuyenHang;

    @FXML
    private JFXComboBox<LoaiCongViecModel> id_CBLoaiCongViec;

    @FXML
    private JFXComboBox<TaiXe> id_CBTaiXe;

    @FXML
    private TableView<CongViecTX> id_TableCongViec;

    @FXML
    private TableColumn<CongViecTX, String> id_CotCongViec;

    @FXML
    private TableColumn<CongViecTX, String> id_CotTaiXe;

    private TableViewThemService<CongViecTX,LoaiCongViecModel> congViecTXTableViewService =
            new TableViewThemService<CongViecTX,LoaiCongViecModel>();

    @FXML
    private TableColumn<CongViecTX, Long> id_CotTienTaiXe;

    private ObservableList<ChuyenHang> chuyenHangs;

    private ObservableList<LoaiCongViecModel> loaiCongViecs;

    @Autowired
    private ChuyenHangRespository chuyenHangRespository = new ChuyenHangRespositoryImplement();

    @Autowired
    private LoaiCongViecRepository loaiCongViecRepository = new LoaiCongViecRepositoryImplement();

    @Autowired
    private ChuHangRespository chuHangRespository = new ChuHangRespositoryImplement();

    @Autowired
    private ContHangRespository contHangRespository = new ContHangRespositoryImplement();

    @Autowired
    private TaiXeRepository taiXeRepository = new TaiXeRespositoryImplement();

    @Autowired
    private LoaiCongViecChuyenHangRespository loaiCongViecChuyenHangRespository =
            new LoaiCongViec_ChuyenHangRespositoryImplement();

    @Autowired
    private ContHangTXCVDAO contHangTXCVDAO;

    private ComboBoxObjectService comboBoxObjectService = new ComboBoxObjectService();

    private ObservableList<CongViecTX> dsCongViecTX;
    private ObservableList<ChuHang> chuHangs;

    private ChuHang chuHang;

    private ContHang contHang;

    @FXML
    void ThemCongViec(ActionEvent event) {

        if(LoiChuongTrinh.ComboBoxNull(id_CBTaiXe) || LoiChuongTrinh.ComboBoxNull(id_CBLoaiCongViec) || LoiChuongTrinh.ComboBoxNull(id_CBChuyenHang)
                || LoiChuongTrinh.ComboBoxNull(id_CBChuHang)){
            return;
        }

        TaiXe taiXe =  id_CBTaiXe.getSelectionModel().getSelectedItem();
        LoaiCongViecModel loaiCongViec =  id_CBLoaiCongViec.getSelectionModel().getSelectedItem();
        ChuyenHang chuyenHang = id_CBChuyenHang.getSelectionModel().getSelectedItem();
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
        congViecTX.setTientx(loaiCongViec_chuyenHang.LayRaTienTaiXeGanNhatTheoNgay(contHang.getNgay()));
        congViecTX.setTenTaiXe(taiXe.getTen());
        congViecTX.setTenCongViec(loaiCongViec.getTen());

        loaiCongViecs.remove(loaiCongViec);
        dsCongViecTX.add(congViecTX);
    }

    public void LoadCBChuyenHang(ActionEvent actionEvent) {

        id_CBChuyenHang.setDisable(false);

        ChuHang chuHang = id_CBChuHang.getSelectionModel().getSelectedItem();
        chuyenHangs.clear();
        chuyenHangs.addAll(chuyenHangRespository.findByChuHang(chuHang));
        id_CBLoaiCongViec.setDisable(true);
    }

    public void LoadCBLoaiCongViec(ActionEvent actionEvent) {

        id_CBLoaiCongViec.setDisable(false);

        ChuyenHang chuyenHang = id_CBChuyenHang.getSelectionModel().getSelectedItem();

        if(chuyenHang != null) {
            loaiCongViecs.clear();
            loaiCongViecs.addAll(ChuyenThanhDsLoaiCongViec(
                    loaiCongViecRepository.layDSLoaiCongViecModel(chuyenHang.getId())));
            dsCongViecTX.clear();
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        id_CotCongViec.setCellValueFactory(new PropertyValueFactory<CongViecTX,String>("tenCongViec"));
        id_CotTaiXe.setCellValueFactory(new PropertyValueFactory<CongViecTX,String>("tenTaiXe"));
        id_CotTienTaiXe.setCellValueFactory(new PropertyValueFactory<CongViecTX,Long>("tientx"));

        chuyenHangs = FXCollections.observableArrayList();

        chuHangs =
                FXCollections.observableArrayList(chuHangRespository.findAllByTrangThaiTrue());

        comboBoxObjectService.LoadComboObservableList(
                ((ObservableList) chuHangs),
                ((JFXComboBox)id_CBChuHang));

        id_CBChuyenHang.setItems(chuyenHangs);

        loaiCongViecs = FXCollections.observableArrayList();
        id_CBLoaiCongViec.setItems(loaiCongViecs);

        congViecTXTableViewService.setTableView(id_TableCongViec);
        dsCongViecTX = FXCollections.observableArrayList();
        congViecTXTableViewService.TaoCotXoa(dsCongViecTX,loaiCongViecs);
        id_CBTaiXe.setItems(FXCollections.observableArrayList(
                taiXeRepository.findAllByTrangThaiTrue()
        ));

    }

    public ContHang getContHang() {
        return contHang;
    }

    public void setContHang(ContHang contHang) {

        dsCongViecTX.clear();

        this.contHang = contHang;
        chuHang = chuHangRespository.LayChuHangTuContHang(contHang.getId());

        ChonChuHangVaChueynHang();

        dsCongViecTX.addAll(this.ChuyenThanhDsCongViecTX(
                chuHangRespository.LayDsCongViecCuaContHang(this.contHang.getId())
        ));

        id_TableCongViec.setItems(dsCongViecTX);

        loaiCongViecs.clear();
        if(chuHang == null){
            System.out.println("Cont Hang chua co tx");
            return;
        }
        loaiCongViecs.addAll(ChuyenThanhDsLoaiCongViec(
                contHangRespository.LayDsCongViecChuaDuocChonCuaContHang(
                        contHang.getId(),chuHang.getId())));
    }

    public ChuHang getChuHang() {
        return chuHang;
    }

    public void setChuHang(ChuHang chuHang) {

        this.chuHang = chuHang;
        //dsCongViecTX = FXCollections

    }

    private List<CongViecTX> ChuyenThanhDsCongViecTX(List<Map<String, Object>> list){
        List<CongViecTX> congViecTXList = new ArrayList<CongViecTX>();
        for (Map<String, Object> x : list){
            CongViecTX congViecTX = new CongViecTX(x);
            congViecTX.setTaiXe(taiXeRepository.findById(congViecTX.getIdTaiXe()).get());
            LoaiCongViec_ChuyenHangPK loaiCongViec_chuyenHangPK = new LoaiCongViec_ChuyenHangPK();
            loaiCongViec_chuyenHangPK.setLoaiCongViecId(congViecTX.getLoaiCongViec().getIdLoaiCongViec());
            loaiCongViec_chuyenHangPK.setChuyenHangId(congViecTX.getIdChuyenHang());
            congViecTX.setLoaiCongViec_chuyenHang(
                    loaiCongViecChuyenHangRespository.findById(loaiCongViec_chuyenHangPK).get());

            congViecTXList.add(congViecTX);
        }
        return congViecTXList;
    }

    private List<LoaiCongViecModel> ChuyenThanhDsLoaiCongViec(List<Map<String, Object>> list){

        List<LoaiCongViecModel> loaiCongViecModels = new ArrayList<LoaiCongViecModel>();
        for (Map<String, Object> x : list){
            loaiCongViecModels.add(new LoaiCongViecModel(x));
        }
        return loaiCongViecModels;
    }


    public CongViecContHangController() {

    }

    private void ChonChuHangVaChueynHang(){
        ChuHang_ChuyenHangModel chuHang_chuyenHangModel = new
                ChuHang_ChuyenHangModel(contHangRespository.LayTenChuHangVaChuyenHangTheoIdContHang(contHang.getId()));

        ChonChuHang(chuHang_chuyenHangModel.getIdChuHang());
        ChonChuyenHang(chuHang_chuyenHangModel.getIdChuyenHang());
    }

    private void ChonChuHang(Long idChuHang){

        chuHangs.forEach(e -> {
            if(e.getId() == idChuHang){
                id_CBChuHang.getSelectionModel().select(e);
                return;
            }
        });
    }
    private void ChonChuyenHang(Long idChuyenHang){

        chuyenHangs.forEach(e -> {
            if(e.getId() == idChuyenHang){
                id_CBChuyenHang.getSelectionModel().select(e);
                return;
            }
        });
    }

    public void CapNhatCongViec(ActionEvent actionEvent) throws CV_TX_CHException {

        if(KiemTraDsCongViec()) {
            try {
                contHangTXCVDAO.UpdateCongViec(dsCongViecTX,contHang);
                ThongBao.showThongBaoThanhCong("Cập Nhật Công Việc Cont Hàng");
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
}
