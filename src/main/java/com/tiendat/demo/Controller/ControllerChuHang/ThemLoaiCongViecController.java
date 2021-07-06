package com.tiendat.demo.Controller.ControllerChuHang;

import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.JFXTextField;
import com.tiendat.demo.Controller.ControllerHang.ThemLoaiChiPhiController;
import com.tiendat.demo.ImplementRespository.LoaiCongViecRepositoryImplement;
import com.tiendat.demo.Model.LoaiChiPhiContHang;
import com.tiendat.demo.Model.LoaiCongViec;
import com.tiendat.demo.Respository.LoaiCongViecRepository;
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
public class ThemLoaiCongViecController implements Initializable {

    @FXML
    private JFXTextField id_TFTen;

    @FXML
    private JFXRadioButton id_RadioNguyenChuyen;

    @FXML
    private TableView<LoaiCongViec> id_TableLoaiCongViec;

    @FXML
    private TableColumn<LoaiCongViec, String> id_ColTen;

    @FXML
    private TableColumn<LoaiCongViec, Boolean> id_ColNguyenChuyen;

    private ObservableList<LoaiCongViec> loaiCongViecs;

    @Autowired
    private LoaiCongViecRepository loaiCongViecRepository =
            new LoaiCongViecRepositoryImplement();
    @FXML
    void ThemCongViec(ActionEvent event) {

        if (LoiChuongTrinh.textFieldNull(id_TFTen)) {
            return;
        }
        LoaiCongViec loaiCongViec = new LoaiCongViec();
        loaiCongViec.setTen(id_TFTen.getText());
        loaiCongViec.setNguyenChuyenHang(id_RadioNguyenChuyen.isSelected());
        loaiCongViecRepository.save(loaiCongViec);
        loaiCongViecs.add(loaiCongViec);
    }

    public void LamMoi(){

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        Callback<TableColumn<LoaiCongViec, Boolean>, TableCell<LoaiCongViec, Boolean>> CellRadioButtonFactory
                = (TableColumn<LoaiCongViec, Boolean> param) -> new ButtonCellTinhTrang();

        id_ColNguyenChuyen.setCellValueFactory(new PropertyValueFactory<LoaiCongViec, Boolean>("nguyenChuyenHang"));

        loaiCongViecs = FXCollections.observableArrayList(loaiCongViecRepository.findAllBy());

        id_TableLoaiCongViec.setEditable(true);

        id_ColTen.setCellValueFactory(new PropertyValueFactory<LoaiCongViec, String>("ten"));
        id_ColTen.setCellFactory(TextFieldTableCell.forTableColumn());
        id_ColTen.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<LoaiCongViec, String>>() {
                                                @Override
                                                public void handle(TableColumn.CellEditEvent<LoaiCongViec, String> t) {
                                                    LoaiCongViec loaiCongViec =
                                                            t.getTableView().getSelectionModel().getSelectedItem();
                                                    loaiCongViec.setTen(t.getNewValue());
                                                    loaiCongViecRepository.save(loaiCongViec);
                                                }
                                            }
        );

        id_ColNguyenChuyen.setCellFactory(CellRadioButtonFactory);

        id_TableLoaiCongViec.setItems(loaiCongViecs);
    }

    public class ButtonCellTinhTrang extends TableCell<LoaiCongViec, Boolean>{

        private JFXRadioButton Button = new JFXRadioButton("Tình Trạng");

        public ButtonCellTinhTrang() {
            // TODO Auto-generated constructor stub
            Button.setOnMousePressed(new EventHandler<MouseEvent>() {


                @Override public void handle(MouseEvent mouseEvent) {


                    LoaiCongViec loaiCongViec = getTableRow().getItem();
                    //tableview_CongViecView.getSelectionModel().select(i);
                    boolean tinhtrang = !loaiCongViec.isNguyenChuyenHang();
                    loaiCongViec.setNguyenChuyenHang(tinhtrang);
                    loaiCongViecRepository.save(loaiCongViec);
                }
            });
        }

        /** places an add button in the row only if the row is not empty. */
        @Override protected void updateItem(Boolean item, boolean empty) {
            super.updateItem(item, empty);
            if (!empty) {
                setContentDisplay(ContentDisplay.GRAPHIC_ONLY);
                if(item) {
                    Button.setSelected(true);
                }
                else
                    Button.setSelected(false);
                setGraphic(Button);
            } else {
                setGraphic(null);
            }
        }


    }
}
