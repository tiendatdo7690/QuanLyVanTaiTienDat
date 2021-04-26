package com.tiendat.demo.Controller.ControllerChuHang;

import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import com.tiendat.demo.ImplementRespository.GiaCuocRespositoryImplement;
import com.tiendat.demo.Model.ChuHang;
import com.tiendat.demo.Model.ChuyenHang;
import com.tiendat.demo.Model.GiaCuoc;
import com.tiendat.demo.NodeService.TableViewService;
import com.tiendat.demo.Respository.GiaCuocRespository;
import com.tiendat.demo.ThongBao.LoiChuongTrinh;
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
public class ControllerThemGiaCuoc implements Initializable {

    @FXML
    private Label id_LabelChuyenHang;

    @FXML
    private JFXTextField id_Tien;

    @FXML
    private JFXDatePicker id_Ngay;

    @FXML
    private TableView<GiaCuoc> id_TableGiaCuoc;

    @FXML
    private TableColumn<GiaCuoc, Long> id_CotTien;

    @FXML
    private TableColumn<GiaCuoc, Date> id_CotNgay;

    @Autowired
    private GiaCuocRespository giaCuocRespository = new GiaCuocRespositoryImplement();

//    @Autowired
//    private TableViewService<GiaCuoc,ControllerThemGiaCuoc> themGiaCuocTableViewService;

    private ChuyenHang chuyenHang;
    private ObservableList<GiaCuoc> giaCuocs;

    @FXML
    void Them(ActionEvent event) {

        if (LoiChuongTrinh.textFieldNull(id_Tien) || LoiChuongTrinh.datePickerNull(id_Ngay)) {
            return;
        }

        Long tien = Long.valueOf(id_Tien.getText());

        Date ngay = Date.valueOf(id_Ngay.getValue());

        GiaCuoc giaCuoc = new GiaCuoc();

        giaCuoc.setChuyenHang(chuyenHang);
        giaCuoc.setTien(tien);
        giaCuoc.setNgay(ngay);

        giaCuocRespository.save(giaCuoc);
        giaCuocs.add(giaCuoc);

    }

    public void setChuyenHang(ChuyenHang chuyenHang) {
        this.chuyenHang = chuyenHang;

        giaCuocs = FXCollections.observableArrayList(chuyenHang.getGiaCuocSet());

        id_LabelChuyenHang.setText(chuyenHang.getTenChuyenHang());
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        id_CotTien.setCellValueFactory(new PropertyValueFactory<GiaCuoc,Long>("tien"));
        id_CotNgay.setCellValueFactory(new PropertyValueFactory<GiaCuoc,Date>("ngay"));



    }
}
