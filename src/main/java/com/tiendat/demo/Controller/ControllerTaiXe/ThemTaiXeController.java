package com.tiendat.demo.Controller.ControllerTaiXe;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import com.tiendat.demo.ImplementRespository.LuongCoBanTxRespositoryImplement;
import com.tiendat.demo.ImplementRespository.TaiXeRespositoryImplement;
import com.tiendat.demo.ImplementRespository.XeRespositoryImplement;
import com.tiendat.demo.Model.LuongCoBanTaiXe;
import com.tiendat.demo.Model.TaiXe;
import com.tiendat.demo.Model.Xe;
import com.tiendat.demo.NodeService.ComboBoxService;
import com.tiendat.demo.Respository.LuongCoBanTXRespository;
import com.tiendat.demo.Respository.TaiXeRepository;
import com.tiendat.demo.Respository.XeRespository;
import com.tiendat.demo.ThongBao.LoiChuongTrinh;
import com.tiendat.demo.ThongBao.ThongBao;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.net.URL;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

@Component
public class ThemTaiXeController implements Initializable {

    @FXML
    private JFXTextField id_Ten;
    @FXML
    private JFXTextField id_LuongCoBan;
    @FXML
    private JFXComboBox<Xe> id_CBXe;
    @FXML
    private JFXTextField id_QueQuan;
    @FXML
    private JFXDatePicker id_NgaySinh;

    private ComboBoxService<Xe> xeComboBoxService = new ComboBoxService<Xe>();

    @Autowired
    private TaiXeRepository taiXeRepository = new TaiXeRespositoryImplement();

    @Autowired
    private LuongCoBanTXRespository luongCoBanTXRespository = new LuongCoBanTxRespositoryImplement();

    @Autowired
    private XeRespository xeRespository = new XeRespositoryImplement();


    private ObservableList<Xe> xeObservableList;
    public void LamMoi(){

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {


        xeRespository.findAllBy().forEach(e -> {
            System.out.println("Tài Xế của xe " + e.getBienSo() + " :" + e.getTaiXe());
        });
        xeObservableList = FXCollections.observableArrayList(xeRespository.timXeChuaCoTX());
        xeComboBoxService.setComboBox(id_CBXe);
        xeComboBoxService.LoadCombo(xeObservableList);
    }

    public void ThemTaiXe(ActionEvent actionEvent) {

        List<JFXTextField> jfxTextFields = new ArrayList<JFXTextField>();
        jfxTextFields.add(id_LuongCoBan);
        jfxTextFields.add(id_QueQuan);
        jfxTextFields.add(id_Ten);

        if(LoiChuongTrinh.listTextFielNull(jfxTextFields) || LoiChuongTrinh.datePickerNull(id_NgaySinh) ||
                LoiChuongTrinh.ComboBoxNull(id_CBXe)){
            return;
        }

        if(LoiChuongTrinh.textFieldSo(id_LuongCoBan)){
            return;
        }
        TaiXe taiXe = new TaiXe();

        String ten = id_Ten.getText();
        Long luongCoBan = Long.valueOf(id_LuongCoBan.getText());
        String queQuan = id_QueQuan.getText();
        Date ngaySinh = Date.valueOf(id_NgaySinh.getValue());
        Xe xe = id_CBXe.getSelectionModel().getSelectedItem();


        taiXe.setTen(ten);
        taiXe.setXe(xe);
        taiXe.setNgaySinh(ngaySinh);
        taiXe.setQueQuan(queQuan);
        taiXe.setTrangThai(true);

        try {
            taiXe = taiXeRepository.save(taiXe);
        }
        catch (Exception e){
            ThongBao.showThongBaoThanhCong(e.toString());

        }

        xeObservableList.remove(xe);
        id_CBXe.getSelectionModel().selectFirst();

        LuongCoBanTaiXe luongCoBanTaiXe = new LuongCoBanTaiXe();

        luongCoBanTaiXe.setNgay(Date.valueOf(LocalDate.now()));
        luongCoBanTaiXe.setTaiXe(taiXe);
        luongCoBanTaiXe.setTien(luongCoBan);

        luongCoBanTaiXe = luongCoBanTXRespository.save(luongCoBanTaiXe);
        taiXe.getLuongCoBanTaiXeSet().add(luongCoBanTaiXe);

        ThongBao.showThongBaoThanhCong("Thêm Tài Xế");


    }

    public void  addXevaoCBXe(Xe xe) {
        if(xeObservableList != null)
            xeObservableList.add(xe);
    }
}
