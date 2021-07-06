package com.tiendat.demo.Controller.ControllerHang;

import com.jfoenix.controls.JFXTextField;
import com.tiendat.demo.ImplementRespository.LoaiChiPhiContHangRespositoryImplement;
import com.tiendat.demo.ImplementRespository.LoaiHangRespositoryImplement;
import com.tiendat.demo.Model.LoaiChiPhiContHang;
import com.tiendat.demo.Model.LoaiHang;
import com.tiendat.demo.Respository.LoaiChiPhiContHangRespository;
import com.tiendat.demo.Respository.LoaiHangRespository;
import com.tiendat.demo.ThongBao.LoiChuongTrinh;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.net.URL;
import java.util.ResourceBundle;

@Component
public class ThemLoaiHangController implements Initializable {
    @FXML
    private JFXTextField id_TFTen;

    @FXML
    private TableView<LoaiHang> id_TableLoaiHang;

    @FXML
    private TableColumn<LoaiHang, String> id_ColTenLoaiHang;


    private ObservableList<LoaiHang> loaiHangs;

    @Autowired
    private LoaiHangRespository loaiHangRespository =
            new LoaiHangRespositoryImplement();
    @FXML
    void ThemLoaiHang(ActionEvent event) {

        if(LoiChuongTrinh.textFieldNull(id_TFTen)){
            return;
        }
        LoaiHang loaiHang = new LoaiHang();
        loaiHang.setTen(id_TFTen.getText());
        loaiHangRespository.save(loaiHang);
        loaiHangs.add(loaiHang);
    }

    public void LamMoi(){

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        loaiHangs = FXCollections.observableArrayList(loaiHangRespository.findAllBy());


        id_TableLoaiHang.setEditable(true);



        id_ColTenLoaiHang.setCellValueFactory(new PropertyValueFactory<LoaiHang, String>("ten"));

        id_TableLoaiHang.setItems(loaiHangs);


        id_ColTenLoaiHang.setCellFactory(TextFieldTableCell.forTableColumn());
        id_ColTenLoaiHang.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<LoaiHang, String>>() {
                                                @Override
                                                public void handle(TableColumn.CellEditEvent<LoaiHang, String> t) {
                                                    LoaiHang loaiHang =
                                                            t.getTableView().getSelectionModel().getSelectedItem();
                                                    loaiHang.setTen(t.getNewValue());
                                                    loaiHangRespository.save(loaiHang);
                                                }
                                            }
        );
    }
}
