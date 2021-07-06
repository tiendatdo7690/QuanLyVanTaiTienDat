package com.tiendat.demo.Controller.ControllerXe;

import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import com.tiendat.demo.ImplementRespository.ChiPhiVoXeRepositoryImplement;
import com.tiendat.demo.Model.ChiPhiVoXe;
import com.tiendat.demo.Respository.ChiPhiVoXeRepository;
import com.tiendat.demo.ThongBao.LoiChuongTrinh;
import com.tiendat.demo.ThongBao.ThongBao;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Pagination;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.net.URL;
import java.sql.Date;
import java.util.ResourceBundle;

@Component
public class ThemChiPhiVoXeController implements Initializable {

    @FXML
    private JFXDatePicker id_Ngay;

    @FXML
    private JFXTextField id_Tien;

    @FXML
    private Spinner<Integer> id_SoLuong;

    @FXML
    private JFXDatePicker id_TuNgay;

    @FXML
    private JFXDatePicker id_DenNgay;

    @FXML
    private Pagination id_PaginationTimKiemChinhSua;

    @Autowired
    private TimKiemXeController timKiemXeController;

    @Autowired
    private ChiPhiVoXeRepository chiPhiVoXeRepository = new ChiPhiVoXeRepositoryImplement();

    @FXML
    void TimKiem(ActionEvent event) {

    }

    @FXML
    void Them(ActionEvent event) {

        if(LoiChuongTrinh.textFieldNull(id_Tien)||
                LoiChuongTrinh.datePickerNull(id_Ngay)){
            return;
        }
        if (timKiemXeController.getXe() == null){
            System.out.println("chưa chọn xe");
            return;
        }

        if(LoiChuongTrinh.textFieldSo(id_Tien)){
            return;
        }

        int soLuong = id_SoLuong.getValue();
        Long tien = Long.valueOf(id_Tien.getText());
        Date ngay = Date.valueOf(id_Ngay.getValue());

        ChiPhiVoXe chiPhiVoXe = new ChiPhiVoXe();

        chiPhiVoXe.setNgay(ngay);
        chiPhiVoXe.setTien(tien);
        chiPhiVoXe.setSoLuong(id_SoLuong.getValue());
        chiPhiVoXe.setXe(timKiemXeController.getXe());

        chiPhiVoXeRepository.save(chiPhiVoXe);
        ThongBao.showThongBaoThanhCong("Chi Phí Vỏ Xe");

    }


    public void LamMoi(){

    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        SpinnerValueFactory<Integer> valueFactory = //
                new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 100, 1);
        id_SoLuong.setValueFactory(valueFactory);
    }
}
