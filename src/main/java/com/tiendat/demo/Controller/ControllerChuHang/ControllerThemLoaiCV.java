package com.tiendat.demo.Controller.ControllerChuHang;

import com.jfoenix.controls.JFXComboBox;
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
import javafx.scene.control.TableView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.net.URL;
import java.util.ResourceBundle;

@Component
public class ControllerThemLoaiCV implements Initializable {

    @FXML
    private Label id_LabelChuyenHang;

    @FXML
    private JFXComboBox<LoaiCongViec> id_ComboboxLoaiCV;

    @Autowired
    private ComboBoxService<LoaiCongViec> loaiCongViecComboBoxService;

    @Autowired
    private LoaiCongViecRepository loaiCongViecRepository = new LoaiCongViecRepositoryImplement();

    @Autowired
    private LoaiCongViecChuyenHangRespository loaiCongViecChuyenHangRespository =
            new LoaiCongViec_ChuyenHangRespositoryImplement();
    private ObservableList<LoaiCongViec> loaiCongViecs;
    @FXML
    private TableView<?> id_TableLoaiCV;

    @FXML
    void Them(ActionEvent event) {

        LoaiCongViec loaiCongViec = id_ComboboxLoaiCV.getSelectionModel().getSelectedItem();
        LoaiCongViec_ChuyenHangPK loaiCongViec_chuyenHangPK = new LoaiCongViec_ChuyenHangPK();
        loaiCongViec_chuyenHangPK.setChuyenHangId(chuyenHang.getId());
        loaiCongViec_chuyenHangPK.setLoaiCongViecId(loaiCongViec.getId());

        LoaiCongViec_ChuyenHang loaiCongViec_chuyenHang = new LoaiCongViec_ChuyenHang();
        loaiCongViec_chuyenHang.setId(loaiCongViec_chuyenHangPK);
        loaiCongViec_chuyenHang.setChuyenHang(chuyenHang);
        loaiCongViec_chuyenHang.setLoaiCongViec(loaiCongViec);
        //loaiCongViec_chuyenHang.setCongViec();
        loaiCongViecChuyenHangRespository.save(loaiCongViec_chuyenHang);
    }

    private ChuyenHang chuyenHang;

    public void setChuyenHang(ChuyenHang chuyenHang) {
        this.chuyenHang = chuyenHang;
        id_LabelChuyenHang.setText(chuyenHang.getTenChuyenHang());
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        loaiCongViecs = FXCollections.observableArrayList(loaiCongViecRepository.findAllBy());
        loaiCongViecComboBoxService.setComboBox(id_ComboboxLoaiCV);
        loaiCongViecComboBoxService.LoadCombo(loaiCongViecs);


    }
}
