package com.tiendat.demo.Controller.ControllerChuHang;

import com.jfoenix.controls.JFXTextField;
import com.tiendat.demo.ImplementRespository.ChuyenHangRespositoryImplement;
import com.tiendat.demo.Model.ChuHang;
import com.tiendat.demo.Model.ChuyenHang;
import com.tiendat.demo.Respository.ChuyenHangRespository;
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
import java.util.ResourceBundle;

@Component
public class ThemChuyenHangController implements Initializable {

    @FXML
    private JFXTextField id_TenChuyenHang;

    @FXML
    private JFXTextField id_DiaChiDen;

    @FXML
    private TableView<ChuyenHang> id_TblViewChuyenHang;

    @FXML
    private TableColumn<ChuyenHang, String> id_CotTen;

    @FXML
    private TableColumn<ChuyenHang, String> id_CotDiaChi;

    @FXML
    private TableColumn<?, ?> id_CotThemTienTx;

    @FXML
    private TableColumn<?, ?> id_CotTHemGiaCuoc;

    @FXML
    private TableColumn<?, ?> id_CotThemLoaiCv;

    @Autowired
    private ChuyenHangRespository chuyenHangRespository = new ChuyenHangRespositoryImplement();

    private ChuHang chuHang;

    private ObservableList<ChuyenHang> chuyenHangs;

    public ChuHang getChuHang() {
        return chuHang;
    }

    public void setChuHang(ChuHang chuHang) {
        this.chuHang = chuHang;
    }

    @FXML
    void ThemChuyenHang(ActionEvent event) {


        if(this.chuHang != null) {
            String tenChuyenHang = id_TenChuyenHang.getText();
            String diaChi = id_DiaChiDen.getText();

            ChuyenHang chuyenHang = new ChuyenHang();
            chuyenHang.setDiaChiNoiDen(diaChi);
            chuyenHang.setTenChuyenHang(tenChuyenHang);
            chuyenHang.setChuHang(chuHang);
            chuyenHang.setTrangThai(true);

            chuyenHangRespository.save(chuyenHang);

            chuyenHangs.add(chuyenHang);
        }

    }

    public void LamMoi(){

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        id_CotTen.setCellValueFactory(new PropertyValueFactory<ChuyenHang,String>("tenChuyenHang"));
        id_CotDiaChi.setCellValueFactory(new PropertyValueFactory<ChuyenHang,String>("diaChiNoiDen"));

    }

    public void GanGiaTriSauKhiTimKiemChuHang(ChuHang chuHang){
        this.chuHang = chuHang;
        chuyenHangs = FXCollections.observableArrayList(this.chuHang.getChuyenHangSet());
        //chuyenHangs = FXCollections.observableArrayList(chuyenHangRespository.findByChuHang(this.chuHang));
        System.out.println(this.chuHang);
        id_TblViewChuyenHang.setItems(chuyenHangs);
    }

}
