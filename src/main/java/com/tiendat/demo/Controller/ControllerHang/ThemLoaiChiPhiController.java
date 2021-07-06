package com.tiendat.demo.Controller.ControllerHang;

import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.JFXTextField;
import com.tiendat.demo.ImplementRespository.LoaiChiPhiContHangRespositoryImplement;
import com.tiendat.demo.Model.LoaiChiHo;
import com.tiendat.demo.Model.LoaiChiPhiContHang;
import com.tiendat.demo.Respository.LoaiChiPhiContHangRespository;
import com.tiendat.demo.ThongBao.LoiChuongTrinh;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.input.MouseEvent;
import javafx.util.Callback;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.net.URL;
import java.util.ResourceBundle;

@Component
public class ThemLoaiChiPhiController implements Initializable {

    @FXML
    private JFXTextField id_TFTen;

    @FXML
    private TableView<LoaiChiPhiContHang> id_TableLoaiChiPhi;

    @FXML
    private TableColumn<LoaiChiPhiContHang, String> id_ColTenLoaiChiPhi;


    private ObservableList<LoaiChiPhiContHang> loaiChiPhiContHangs;

    @Autowired
    private LoaiChiPhiContHangRespository loaiChiPhiContHangRespository =
            new LoaiChiPhiContHangRespositoryImplement();
    @FXML
    void ThemLoaiChiPhi(ActionEvent event) {

        if(LoiChuongTrinh.textFieldNull(id_TFTen)){
            return;
        }
        LoaiChiPhiContHang loaiChiPhiContHang = new LoaiChiPhiContHang();
        loaiChiPhiContHang.setTen(id_TFTen.getText());
        loaiChiPhiContHangRespository.save(loaiChiPhiContHang);
        loaiChiPhiContHangs.add(loaiChiPhiContHang);
    }

    public void LamMoi(){

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        loaiChiPhiContHangs = FXCollections.observableArrayList(loaiChiPhiContHangRespository.findAllBy());

        id_TableLoaiChiPhi.setEditable(true);



        id_ColTenLoaiChiPhi.setCellValueFactory(new PropertyValueFactory<LoaiChiPhiContHang, String>("ten"));

        id_TableLoaiChiPhi.setItems(loaiChiPhiContHangs);


        id_ColTenLoaiChiPhi.setCellFactory(TextFieldTableCell.forTableColumn());
        id_ColTenLoaiChiPhi.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<LoaiChiPhiContHang, String>>() {
                                               @Override
                                               public void handle(TableColumn.CellEditEvent<LoaiChiPhiContHang, String> t) {
                                                   LoaiChiPhiContHang loaiChiPhiContHang =
                                                           t.getTableView().getSelectionModel().getSelectedItem();
                                                   loaiChiPhiContHang.setTen(t.getNewValue());
                                                   loaiChiPhiContHangRespository.save(loaiChiPhiContHang);
                                               }
                                           }
        );
    }


}
