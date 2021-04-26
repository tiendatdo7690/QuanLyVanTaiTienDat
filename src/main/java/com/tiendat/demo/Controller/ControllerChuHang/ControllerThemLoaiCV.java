package com.tiendat.demo.Controller.ControllerChuHang;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import com.tiendat.demo.ImplementRespository.LoaiCongViecRepositoryImplement;
import com.tiendat.demo.ImplementRespository.LoaiCongViec_ChuyenHangRespositoryImplement;
import com.tiendat.demo.Model.*;
import com.tiendat.demo.NodeService.ComboBoxService;
import com.tiendat.demo.Respository.LoaiCongViecChuyenHangRespository;
import com.tiendat.demo.Respository.LoaiCongViecRepository;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.net.URL;
import java.sql.Date;
import java.util.ResourceBundle;

@Component
public class ControllerThemLoaiCV implements Initializable {

    @FXML
    private Label id_LabelChuyenHang;

    @FXML
    private JFXComboBox<LoaiCongViec> id_ComboboxLoaiCV;

    @FXML
    private JFXTextField id_Tien;

    @FXML
    private TableView<LoaiCongViec_ChuyenHang> id_TableLoaiCV;

    @FXML
    private TableColumn<LoaiCongViec_ChuyenHang, String> id_CotTen;

    @FXML
    private TableColumn<LoaiCongViec_ChuyenHang, Boolean> id_CotNguyenChuyen;

    @FXML
    private TableColumn<LoaiCongViec_ChuyenHang, Long> id_CotTien;

    @Autowired
    private ComboBoxService<LoaiCongViec> loaiCongViecComboBoxService;

    @Autowired
    private LoaiCongViecRepository loaiCongViecRepository = new LoaiCongViecRepositoryImplement();


    @Autowired
    private LoaiCongViecChuyenHangRespository loaiCongViecChuyenHangRespository =
            new LoaiCongViec_ChuyenHangRespositoryImplement();

    private ObservableList<LoaiCongViec> loaiCongViecsComboBox;
    private ObservableList<LoaiCongViec_ChuyenHang> loaiCongViecsTableView;

    private ChuyenHang chuyenHang;

    @FXML
    void Them(ActionEvent event) {


        Long tienCong = Long.valueOf(id_Tien.getText());

        LoaiCongViec loaiCongViec = id_ComboboxLoaiCV.getSelectionModel().getSelectedItem();
        LoaiCongViec_ChuyenHangPK loaiCongViec_chuyenHangPK = new LoaiCongViec_ChuyenHangPK();
        loaiCongViec_chuyenHangPK.setChuyenHangId(chuyenHang.getId());
        loaiCongViec_chuyenHangPK.setLoaiCongViecId(loaiCongViec.getId());

        LoaiCongViec_ChuyenHang loaiCongViec_chuyenHang = new LoaiCongViec_ChuyenHang();
        loaiCongViec_chuyenHang.setId(loaiCongViec_chuyenHangPK);
        loaiCongViec_chuyenHang.setChuyenHang(chuyenHang);
        loaiCongViec_chuyenHang.setTienCong(tienCong);
        loaiCongViec_chuyenHang.setLoaiCongViec(loaiCongViec);
        //loaiCongViec_chuyenHang.setCongViec();
        loaiCongViec_chuyenHang = loaiCongViecChuyenHangRespository.save(loaiCongViec_chuyenHang);

        loaiCongViecsTableView.remove(layLoaiCongViec_ChuyenHangDaCoTrongDS(loaiCongViecsTableView,loaiCongViec_chuyenHang));
        loaiCongViecsTableView.add(loaiCongViec_chuyenHang);
    }

    private LoaiCongViec_ChuyenHang layLoaiCongViec_ChuyenHangDaCoTrongDS(
            ObservableList<LoaiCongViec_ChuyenHang> loaiCongViec_chuyenHangs,
            LoaiCongViec_ChuyenHang loaiCongViecChuyenHang){

        for(LoaiCongViec_ChuyenHang e : loaiCongViec_chuyenHangs){

            if(e.getId().equals(loaiCongViecChuyenHang.getId()))
                return e;
        }
        return null;
    }
    public void setChuyenHang(ChuyenHang chuyenHang) {

        System.out.println("Gán chuyens hàng");
        this.chuyenHang = chuyenHang;
        id_LabelChuyenHang.setText(chuyenHang.getTenChuyenHang());

        loaiCongViecsTableView = FXCollections.observableArrayList(loaiCongViecChuyenHangRespository.findAllByChuyenHang(chuyenHang));
        loaiCongViecsComboBox = FXCollections.observableArrayList(loaiCongViecRepository.findAllBy());

        loaiCongViecComboBoxService.setComboBox(id_ComboboxLoaiCV);

        loaiCongViecComboBoxService.LoadCombo(loaiCongViecsComboBox);

        id_TableLoaiCV.setItems(loaiCongViecsTableView);

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {


        System.out.println("Khởi tạo");

        id_CotTien.setCellValueFactory(new PropertyValueFactory<LoaiCongViec_ChuyenHang,Long>("tienCong"));
        id_CotTen.setCellValueFactory(new PropertyValueFactory<LoaiCongViec_ChuyenHang, String>("ten"));
        id_CotNguyenChuyen.setCellValueFactory(new PropertyValueFactory<LoaiCongViec_ChuyenHang, Boolean>("nguyenChuyen"));



    }
}
