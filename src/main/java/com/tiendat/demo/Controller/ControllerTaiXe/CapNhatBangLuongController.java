package com.tiendat.demo.Controller.ControllerTaiXe;

import com.jfoenix.controls.JFXTextField;
import com.tiendat.demo.ImplementRespository.LuongCoBanTxRespositoryImplement;
import com.tiendat.demo.Model.LuongCoBanTaiXe;
import com.tiendat.demo.Model.TaiXe;
import com.tiendat.demo.Respository.LuongCoBanTXRespository;
import com.tiendat.demo.ThongBao.LoiChuongTrinh;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Date;
import java.time.LocalDate;

@Component
public class CapNhatBangLuongController {

    @FXML
    private JFXTextField id_TextTien;

    @Autowired
    private LuongCoBanTXRespository luongCoBanTXRespository = new LuongCoBanTxRespositoryImplement();

    @Autowired
    private TimKiemTaiXeController timKiemTaiXeController;

    public void LamMoi(){

    }

    public void CapNhatLuong(ActionEvent actionEvent) {

        if(LoiChuongTrinh.textFieldNull(id_TextTien)){
            return;
        }
        if(LoiChuongTrinh.textFieldSo(id_TextTien)){
            return;
        }

        TaiXe taiXe = timKiemTaiXeController.getTaiXe();
        Long tien = Long.valueOf(id_TextTien.getText());

        LuongCoBanTaiXe luongCoBanTaiXe = new LuongCoBanTaiXe();
        luongCoBanTaiXe.setTien(tien);
        luongCoBanTaiXe.setTaiXe(taiXe);
        luongCoBanTaiXe.setNgay(Date.valueOf(LocalDate.now()));

        luongCoBanTXRespository.save(luongCoBanTaiXe);

        taiXe.getLuongCoBanTaiXeSet().add(luongCoBanTaiXe);
    }

    public void TimKiem(ActionEvent actionEvent) {
    }
}
