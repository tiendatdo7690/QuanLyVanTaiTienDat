package com.tiendat.demo.Controller.ControllerChuHang;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import com.tiendat.demo.ImplementRespository.LoaiCongViec_ChuyenHangRespositoryImplement;
import com.tiendat.demo.ImplementRespository.TienTaiXeRespositoryImplement;
import com.tiendat.demo.Model.ChuyenHang;
import com.tiendat.demo.Model.LoaiCongViec;
import com.tiendat.demo.Model.LoaiCongViec_ChuyenHang;
import com.tiendat.demo.Model.TienTaiXe;
import com.tiendat.demo.NodeService.ComboBoxService;
import com.tiendat.demo.NodeService.TableViewService;
import com.tiendat.demo.Respository.LoaiCongViecChuyenHangRespository;
import com.tiendat.demo.Respository.TienTaiXeRespository;
import com.tiendat.demo.ThongBao.LoiChuongTrinh;
import com.tiendat.demo.ThongBao.ThongBao;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.util.converter.LongStringConverter;
import javafx.util.converter.NumberStringConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.net.URL;
import java.sql.Date;
import java.util.ResourceBundle;

@Component
public class ControllerThemTienTx implements Initializable {

    @FXML
    private Label id_LabelChuyenHang;


    @FXML
    private JFXComboBox<LoaiCongViec_ChuyenHang> id_CBLoaiCV;

    @FXML
    private JFXTextField id_Tien;

    @FXML
    private JFXDatePicker id_Ngay;

    @FXML
    private TableView<TienTaiXe> id_TableTienTx;


    @FXML
    private TableColumn<TienTaiXe, Long> id_CotTien;

    @FXML
    private TableColumn<TienTaiXe, Date> id_CotNgay;

    private ObservableList<TienTaiXe> tienTaiXes;

    private ComboBoxService<LoaiCongViec_ChuyenHang> congViec_chuyenHangComboBoxService =
            new ComboBoxService<LoaiCongViec_ChuyenHang>();

    @Autowired
    private LoaiCongViecChuyenHangRespository loaiCongViecChuyenHangRespository =
            new LoaiCongViec_ChuyenHangRespositoryImplement();

    @Autowired
    private TienTaiXeRespository tienTaiXeRespository = new TienTaiXeRespositoryImplement();

    private TableViewService<TienTaiXe,ControllerThemTienTx> tableViewService =
            new TableViewService<>();
    @FXML
    void Them(ActionEvent event) {

        if (LoiChuongTrinh.datePickerNull(id_Ngay) || LoiChuongTrinh.textFieldNull(id_Tien)||
                LoiChuongTrinh.ComboBoxNull(id_CBLoaiCV)){
            return;
        }

        if(LoiChuongTrinh.textFieldSo(id_Tien)){
            return;
        }
        LoaiCongViec_ChuyenHang loaiCongViec_chuyenHang = id_CBLoaiCV.getSelectionModel().getSelectedItem();
        Long tien  = Long.valueOf(id_Tien.getText());
        Date ngay = Date.valueOf(id_Ngay.getValue());

        TienTaiXe tienTaiXe = new TienTaiXe();
        tienTaiXe.setNgay(ngay);
        tienTaiXe.setTien(tien);
        tienTaiXe.setLoaiCongViec_chuyenHang(loaiCongViec_chuyenHang);

        loaiCongViec_chuyenHang.getTienTaiXeSet().add(tienTaiXeRespository.save(tienTaiXe));

        tienTaiXes.add(tienTaiXe);
    }

    @FXML
    void LoadTienTX(ActionEvent event) {


        LoaiCongViec_ChuyenHang loaiCongViec_chuyenHang = id_CBLoaiCV.getSelectionModel().getSelectedItem();

        tienTaiXes = FXCollections.observableArrayList(loaiCongViec_chuyenHang.getTienTaiXeSet());
        id_TableTienTx.setItems(tienTaiXes);

    }


    private ChuyenHang chuyenHang;

    public void setChuyenHang(ChuyenHang chuyenHang) {
        this.chuyenHang = chuyenHang;



        ObservableList<LoaiCongViec_ChuyenHang> loaiCongViec_chuyenHangs =
                FXCollections.observableArrayList(
                        loaiCongViecChuyenHangRespository.findAllByChuyenHang(chuyenHang));

        if(loaiCongViec_chuyenHangs.size() == 0){
            ThongBao.showThongBao("Thông Tin Chuyến Hàng","Thêm Tiền Tài Xế","Chưa Có Loại Công " +
                    "Viêc Nào Cho Chuyến Hàng :"+chuyenHang.getTenChuyenHang());
            return;
        }

        congViec_chuyenHangComboBoxService.setComboBox(id_CBLoaiCV);
        congViec_chuyenHangComboBoxService.LoadCombo(loaiCongViec_chuyenHangs);

        LoaiCongViec_ChuyenHang loaiCongViec_chuyenHang = id_CBLoaiCV.getSelectionModel().getSelectedItem();

        //LoaiCongViec_ChuyenHang loaiCongViec_chuyenHang = id_CBLoaiCV.getSelectionModel().getSelectedItem();

        tienTaiXes = FXCollections.observableArrayList(loaiCongViec_chuyenHang.getTienTaiXeSet());
        id_TableTienTx.setItems(tienTaiXes);

        id_LabelChuyenHang.setText(chuyenHang.getTenChuyenHang());
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        id_TableTienTx.setEditable(true);
        id_CotTien.setCellValueFactory(new PropertyValueFactory<TienTaiXe, Long>("tien"));
        id_CotNgay.setCellValueFactory(new PropertyValueFactory<TienTaiXe, Date>("ngay"));

        id_CotTien.setCellFactory(TextFieldTableCell.forTableColumn(new LongStringConverter()));

        id_CotTien.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<TienTaiXe, Long>>() {
                                      @Override
                                      public void handle(TableColumn.CellEditEvent<TienTaiXe, Long> t) {
                                          TienTaiXe tienTaiXe =
                                                  t.getTableView().getSelectionModel().getSelectedItem();
                                          tienTaiXe.setTien(t.getNewValue());
                                          tienTaiXeRespository.save(tienTaiXe);
                                      }
                                  }
        );

        tableViewService.setController(this);
        tableViewService.setTableView(id_TableTienTx);
        tableViewService.TaoCotXoaDatabase();
    }

    public void XoaDatabase(TienTaiXe e){
            tienTaiXeRespository.deleteById(e.getId());
            tienTaiXes.remove(e);
    }
}
