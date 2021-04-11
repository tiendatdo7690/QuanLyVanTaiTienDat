package com.tiendat.demo.Controller.ControllerHang;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import com.tiendat.demo.Model.Cang;
import com.tiendat.demo.Model.CangHa;
import com.tiendat.demo.Model.CangLay;
import com.tiendat.demo.NodeService.ComboBoxService;
import com.tiendat.demo.Respository.CangRespository;
import com.tiendat.demo.ThongBao.LoiChuongTrinh;
import com.tiendat.demo.ThongBao.ThongBao;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

@Component
public class ThemCangController implements Initializable {

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

    @Autowired
    private ComboBoxService<String> stringComboBoxService;

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
        if(id_CBLoaiCang.getSelectionModel().getSelectedItem() == "Cảng Lấy"){

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
        cang.seteMail(email);
        cang.setSoDienThoai(sdt);
        cang.setTen(tencang);
        cang.setTrangThai(true);

        cangRespository.save(cang);
        ThongBao.showThongBaoThanhCong("Cảng");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

//        List<String> listLoaiCang = new ArrayList<String>();
//        listLoaiCang.add("Cảng Lấy");
//        listLoaiCang.add("Cảng Hạ");

        ObservableList<String> observableList = FXCollections.observableArrayList();

        observableList.add("Cảng Lấy");
        observableList.add("Cảng Hạ");

        stringComboBoxService.setComboBox(id_CBLoaiCang);
        stringComboBoxService.LoadCombo(observableList);
    }
}
