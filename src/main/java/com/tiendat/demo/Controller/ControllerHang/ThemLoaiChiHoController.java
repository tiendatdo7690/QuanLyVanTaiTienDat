package com.tiendat.demo.Controller.ControllerHang;

import com.jfoenix.controls.JFXTextField;
import com.tiendat.demo.ImplementRespository.LoaiChiHoRespositoryImplement;
import com.tiendat.demo.Model.LoaiChiHo;
import com.tiendat.demo.Respository.LoaiChiHoRespository;
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
public class ThemLoaiChiHoController implements Initializable {

    @FXML
    private JFXTextField id_TFTen;

    @FXML
    private TableView<LoaiChiHo> id_TableLoaiChiHo;

    @FXML
    private TableColumn<LoaiChiHo, String> id_ColTenLoaiChiHo;

    private ObservableList<LoaiChiHo> loaiChiHos;

    @Autowired
    private LoaiChiHoRespository loaiChiHoRespository = new LoaiChiHoRespositoryImplement();

    @FXML
    void ThemLoaiChiHo(ActionEvent event) {

        if(LoiChuongTrinh.textFieldNull(id_TFTen)){
            return;
        }
        LoaiChiHo loaiChiHo = new LoaiChiHo();
        loaiChiHo.setTen(id_TFTen.getText());
        loaiChiHoRespository.save(loaiChiHo);
        loaiChiHos.add(loaiChiHo);
    }

    public void LamMoi(){

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        loaiChiHos = FXCollections.observableArrayList(loaiChiHoRespository.findAllBy());

        id_TableLoaiChiHo.setEditable(true);

        id_ColTenLoaiChiHo.setCellValueFactory(new PropertyValueFactory<LoaiChiHo, String>("ten"));
        id_TableLoaiChiHo.setItems(loaiChiHos);


        id_ColTenLoaiChiHo.setCellFactory(TextFieldTableCell.forTableColumn());
        id_ColTenLoaiChiHo.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<LoaiChiHo, String>>() {
                                    @Override
                                    public void handle(TableColumn.CellEditEvent<LoaiChiHo, String> t) {
                                        LoaiChiHo loaiChiHo = t.getTableView().getSelectionModel().getSelectedItem();
                                        loaiChiHo.setTen(t.getNewValue());
                                        loaiChiHoRespository.save(loaiChiHo);
                                    }
                                }
        );
    }
}
