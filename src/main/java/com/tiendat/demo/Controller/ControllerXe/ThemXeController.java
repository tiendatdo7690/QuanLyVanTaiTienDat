package com.tiendat.demo.Controller.ControllerXe;

import com.jfoenix.controls.JFXTextField;
import com.tiendat.demo.Controller.ControllerTaiXe.ThemTaiXeController;
import com.tiendat.demo.ImplementRespository.XeRespositoryImplement;
import com.tiendat.demo.Model.Xe;
import com.tiendat.demo.Respository.XeRespository;
import com.tiendat.demo.ThongBao.LoiChuongTrinh;
import com.tiendat.demo.ThongBao.ThongBao;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

@Component
public class ThemXeController implements Initializable {

    public JFXTextField id_BienSo;
    public JFXTextField id_HieuXe;
    public JFXTextField id_NamSX;

    @Autowired
    private ThemTaiXeController themTaiXeController;
    @Autowired
    private XeRespository xeRespository = new XeRespositoryImplement();

    public void LamMoi(){

    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    public void ThemXe(ActionEvent actionEvent) {

        List<JFXTextField> jfxTextFields = new ArrayList<JFXTextField>();

        jfxTextFields.add(id_HieuXe);
        jfxTextFields.add(id_BienSo);
        jfxTextFields.add(id_NamSX);

        if(LoiChuongTrinh.listTextFielNull(jfxTextFields)){
            return;
        }

        String bienSo = id_BienSo.getText();
        String hieuXe = id_HieuXe.getText();
        int namSX = Integer.valueOf(id_NamSX.getText());

        Xe xe = new Xe();
        xe.setBienSo(bienSo);
        xe.setNamSX(namSX);
        xe.setTrangThai(true);
        xe.setHieuXe(hieuXe);

        xe = xeRespository.save(xe);
        themTaiXeController.addXevaoCBXe(xe);
        ThongBao.showThongBaoThanhCong("Thêm Xe");

    }
}
