package com.tiendat.demo.Controller.ControllerChuHang;

import com.jfoenix.controls.JFXTextField;
import com.tiendat.demo.Model.ChuHang;
import com.tiendat.demo.Respository.ChuHangRespository;
import com.tiendat.demo.ImplementRespository.ChuHangRespositoryImplement;
import com.tiendat.demo.ThongBao.LoiChuongTrinh;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.net.URL;
import java.util.ResourceBundle;

@Component
public class ThemChuHangController implements Initializable {

    @FXML
    private JFXTextField id_TFTenCty;

    @FXML
    private JFXTextField id_TFMST;

    @FXML
    private JFXTextField id_TFDiaChi;

    @Autowired
    ChuHangRespository chuHangRespository = new ChuHangRespositoryImplement();

    @FXML
    void ThemChuHang(ActionEvent event) {
        if(LoiChuongTrinh.textFieldNull(id_TFTenCty) || LoiChuongTrinh.textFieldNull(id_TFMST) ||
                LoiChuongTrinh.textFieldNull(id_TFDiaChi)){
            return;
        }

        String tenCty = id_TFTenCty.getText();
        String mst = id_TFMST.getText();
        String diachi = id_TFDiaChi.getText();

        ChuHang chuHang = new ChuHang();
        chuHang.setTen(tenCty);
        chuHang.setDiaChi(diachi);
        chuHang.setMaSoThue(mst);
        chuHang.setTrangThai(true);

        chuHangRespository.save(chuHang);

    }

    public void LamMoi(){

    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
