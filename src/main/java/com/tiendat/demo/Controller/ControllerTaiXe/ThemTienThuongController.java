package com.tiendat.demo.Controller.ControllerTaiXe;

import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import com.tiendat.demo.ImplementRespository.TienThuongRespositoryImplement;
import com.tiendat.demo.Model.TienThuongTX;
import com.tiendat.demo.Model.TienUngTaiXe;
import com.tiendat.demo.Respository.TienThuongRespository;
import com.tiendat.demo.ThongBao.LoiChuongTrinh;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Date;

@Component
public class ThemTienThuongController {

    @FXML
    private JFXTextField id_TextNoiDung;

    @FXML
    private JFXTextField id_TextTien;

    @FXML
    private JFXDatePicker id_TextNgay;

    @Autowired
    private TienThuongRespository tienThuongRespository = new TienThuongRespositoryImplement();

    @FXML
    void ThemTienThuong(ActionEvent event) {

        if(LoiChuongTrinh.textFieldNull(id_TextTien)||
                LoiChuongTrinh.datePickerNull(id_TextNgay)|| LoiChuongTrinh.textFieldSo(id_TextNoiDung)){
            return;
        }
        if(LoiChuongTrinh.textFieldSo(id_TextTien)){
            return;
        }

        String noiDung = id_TextNoiDung.getText();
        Long tien = Long.valueOf(id_TextTien.getText());
        Date ngay = Date.valueOf(id_TextNgay.getValue());

        TienThuongTX tienThuongTX = new TienThuongTX();
        tienThuongTX.setNgay(ngay);
        tienThuongTX.setTien(tien);
        tienThuongTX.setNoiDung(noiDung);
        tienThuongRespository.save(tienThuongTX);

    }


    public void LamMoi(){

    }

    public void TimKiem(ActionEvent actionEvent) {
    }
}
