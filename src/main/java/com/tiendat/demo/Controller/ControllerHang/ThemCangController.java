package com.tiendat.demo.Controller.ControllerHang;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.JFXTextField;
import com.tiendat.demo.Model.*;
import com.tiendat.demo.NodeService.ComboBoxService;
import com.tiendat.demo.NodeService.PaginationService;
import com.tiendat.demo.NodeService.TableViewService;
import com.tiendat.demo.Respository.CangRespository;
import com.tiendat.demo.ThongBao.LoiChuongTrinh;
import com.tiendat.demo.ThongBao.ThongBao;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.input.MouseEvent;
import javafx.util.Callback;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

@Component
public class ThemCangController implements Initializable {

    @FXML
    private Pagination id_PaginationCang;
    @FXML
    private JFXTextField id_tencang;
    @FXML
    private JFXTextField id_DiaChi;
    @FXML
    private JFXTextField id_Email;
    @FXML
    private JFXTextField id_Sdt;
    @FXML
    private JFXComboBox id_CBLoaiCang;

    private TableView<Cang> cangTableView;

    private TableColumn<Cang,String> col_Ten;

    private TableColumn<Cang,String> col_DiaChi;

    private TableColumn<Cang,String> col_Sdt;

    private TableColumn<Cang,String> col_Email;

    private TableColumn<Cang,String> col_LoaiCang;

    private TableColumn<Cang,Boolean> col_TrangThai;


    private ComboBoxService<String> stringComboBoxService = new ComboBoxService<String>();

    private ObservableList<Cang> cangs;

    private PaginationService paginationService = new PaginationService();
    @Autowired
    private CangRespository cangRespository;

    public void LamMoi(){

    }

    public void ThemCang(ActionEvent actionEvent) {

        List<JFXTextField> jfxTextFields = new ArrayList<JFXTextField>();
        jfxTextFields.add(id_DiaChi);
        jfxTextFields.add(id_tencang);
        jfxTextFields.add(id_Email);
        jfxTextFields.add(id_Sdt);

        if(LoiChuongTrinh.listTextFielNull(jfxTextFields)){
            return;
        }

        String loaicang = null;

        String tencang = id_tencang.getText();
        String diachi = id_DiaChi.getText();
        String email = id_Email.getText();
        String sdt = id_Sdt.getText();
        Cang cang;

        if(id_CBLoaiCang.getSelectionModel().getSelectedItem().equals("Cảng Lấy")){

            loaicang = "CangLay";
            cang = new CangLay();
            System.out.println("Loại Cảng" + loaicang);
        }
        else {
            loaicang = "CangHa";
            cang = new CangHa();
            System.out.println("Loại Cảng" + loaicang);
        }

        cang.setDiaChi(diachi);
        cang.setEmail(email);
        cang.setSoDienThoai(sdt);
        cang.setTen(tencang);
        cang.setTrangThai(true);

        cangRespository.save(cang);
        cangs.add(cang);

        paginationService.taiDSPagination(cangs,cangTableView,10);
        ThongBao.showThongBaoThanhCong("Cảng");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        ObservableList<String> observableList = FXCollections.observableArrayList();

        observableList.add("Cảng Lấy");
        observableList.add("Cảng Hạ");

        stringComboBoxService.setComboBox(id_CBLoaiCang);
        stringComboBoxService.LoadCombo(observableList);

        cangTableView = new TableView<>();
        cangTableView.setEditable(true);

        col_Ten = new TableColumn<>("Tên");
        col_DiaChi = new TableColumn<>("Địa Chỉ");
        col_Email = new TableColumn<>("Email");
        col_Sdt = new TableColumn<>("Số Điện Thoại");
        col_LoaiCang = new TableColumn<>("Loại Cảng");
        col_TrangThai = new TableColumn<>("Trạng Thái");


        col_Ten.setCellValueFactory(new PropertyValueFactory<Cang,String>("ten"));
        col_DiaChi.setCellValueFactory(new PropertyValueFactory<Cang,String>("diaChi"));
        col_Email.setCellValueFactory(new PropertyValueFactory<Cang,String>("email"));
        col_Sdt.setCellValueFactory(new PropertyValueFactory<Cang,String>("soDienThoai"));
        col_LoaiCang.setCellValueFactory(new PropertyValueFactory<Cang,String>("loaiCang"));
        col_TrangThai.setCellValueFactory(new PropertyValueFactory<Cang,Boolean>("trangThai"));

        col_Ten.setCellFactory(TextFieldTableCell.forTableColumn());
        col_Ten.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<Cang, String>>() {
                                               @Override
                                               public void handle(TableColumn.CellEditEvent<Cang, String> t) {
                                                   Cang cang = t.getTableView().getSelectionModel().getSelectedItem();
                                                   cang.setTen(t.getNewValue());
                                                   cangRespository.save(cang);
                                               }
                                           }
        );

        col_DiaChi.setCellFactory(TextFieldTableCell.forTableColumn());
        col_DiaChi.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<Cang, String>>() {
                                    @Override
                                    public void handle(TableColumn.CellEditEvent<Cang, String> t) {
                                        Cang cang = t.getTableView().getSelectionModel().getSelectedItem();
                                        cang.setDiaChi(t.getNewValue());
                                        cangRespository.save(cang);
                                    }
                                }
        );

        col_Email.setCellFactory(TextFieldTableCell.forTableColumn());
        col_Email.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<Cang, String>>() {
                                    @Override
                                    public void handle(TableColumn.CellEditEvent<Cang, String> t) {
                                        Cang cang = t.getTableView().getSelectionModel().getSelectedItem();
                                        cang.setEmail(t.getNewValue());
                                        cangRespository.save(cang);
                                    }
                                }
        );

        col_Sdt.setCellFactory(TextFieldTableCell.forTableColumn());
        col_Sdt.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<Cang, String>>() {
                                    @Override
                                    public void handle(TableColumn.CellEditEvent<Cang, String> t) {
                                        Cang cang = t.getTableView().getSelectionModel().getSelectedItem();
                                        cang.setSoDienThoai(t.getNewValue());
                                        cangRespository.save(cang);
                                    }
                                }
        );


        Callback<TableColumn<Cang, Boolean>, TableCell<Cang, Boolean>> CellTrangThaiFactory
                = (TableColumn<Cang, Boolean> param) -> new ButtonCellTinhTrang();

        col_TrangThai.setCellFactory(CellTrangThaiFactory);


        cangTableView.getColumns().addAll(col_Ten,col_DiaChi,col_Email,col_Sdt,col_LoaiCang,col_TrangThai);

        cangs = FXCollections.observableArrayList(cangRespository.findAllBy());
        //cangTableView.setItems(cangs);
        System.out.println(cangs);

        paginationService.setPagination(id_PaginationCang);
        paginationService.taiDSPagination(cangs,cangTableView,10);
    }

    public class ButtonCellTinhTrang extends TableCell<Cang, Boolean> {

        private JFXRadioButton Button = new JFXRadioButton();

        public ButtonCellTinhTrang() {
            // TODO Auto-generated constructor stub

            Button.setOnMousePressed(new EventHandler<MouseEvent>() {

                @Override public void handle(MouseEvent mouseEvent) {

                    Cang cang = (Cang) getTableRow().getItem();
                    boolean  tinhtrang =  cang.isTrangThai();

                    cang.setTrangThai(!tinhtrang);


                    cangRespository.save(cang);
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
