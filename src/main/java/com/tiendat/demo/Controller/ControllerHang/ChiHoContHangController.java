package com.tiendat.demo.Controller.ControllerHang;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import com.tiendat.demo.Exception.CV_TX_CHException;
import com.tiendat.demo.Exception.ChiHo_ContHangException;
import com.tiendat.demo.Exception.ChiPhiContHang_ContHangException;
import com.tiendat.demo.ImplementRespository.ContHangTXCVDAO;
import com.tiendat.demo.ImplementRespository.LoaiChiHoContHangRespositoryImplement;
import com.tiendat.demo.ImplementRespository.LoaiChiHoRespositoryImplement;
import com.tiendat.demo.ImplementRespository.LoaiChiPhiContHangRespositoryImplement;
import com.tiendat.demo.Model.ChiPhiContHang_ContHang;
import com.tiendat.demo.Model.ContHang;
import com.tiendat.demo.Model.LoaiChiHo;
import com.tiendat.demo.Model.LoaiChiHo_ContHang;
import com.tiendat.demo.NodeService.ComboBoxService;
import com.tiendat.demo.NodeService.TableViewThemService;
import com.tiendat.demo.Respository.LoaiChiHoContHangRespository;
import com.tiendat.demo.Respository.LoaiChiHoRespository;
import com.tiendat.demo.Respository.LoaiChiPhiContHangRespository;
import com.tiendat.demo.ThongBao.LoiChuongTrinh;
import com.tiendat.demo.ThongBao.ThongBao;
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
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

@Component
public class ChiHoContHangController implements Initializable {



    private TableViewThemService<LoaiChiHo_ContHang, LoaiChiHo> loaiChiHo_contHangTableViewService =
            new TableViewThemService<LoaiChiHo_ContHang,LoaiChiHo>();

    private ComboBoxService<LoaiChiHo> loaiChiHoComboBoxService = new ComboBoxService<LoaiChiHo>();

    private ObservableList<LoaiChiHo_ContHang> dsLoaiChiHoContHangs;

    private ObservableList<LoaiChiHo> loaiChiHos;

    @FXML
    private JFXTextField id_TFTien;

    @FXML
    private JFXComboBox<LoaiChiHo> id_CBLoaiChiHo;

    @FXML
    private TableView<LoaiChiHo_ContHang> id_TableChiHo;

    @FXML
    private TableColumn<LoaiChiHo_ContHang, String> id_ColTenChiHo;

    @FXML
    private TableColumn<LoaiChiHo_ContHang, Long> id_ColTienChiHo;

    private ContHang contHang;
    @Autowired
    private LoaiChiHoRespository loaiChiHoRespository =
            new LoaiChiHoRespositoryImplement();

    @Autowired
    private LoaiChiHoContHangRespository loaiChiHoContHangRespository =
            new LoaiChiHoContHangRespositoryImplement();

    @Autowired
    private ContHangTXCVDAO contHangTXCVDAO;

    @FXML
    void CapNhatChiHo(ActionEvent event) {


        try {
            contHangTXCVDAO.UpdateChiHo(dsLoaiChiHoContHangs,contHang);
            ThongBao.showThongBaoThanhCong("Cập Nhật Ds Chi Hộ");
        }
        catch (ChiHo_ContHangException exception1){
            ThongBao.showThongBaoLoiCVThem2Lan("Bảng Chi Hộ");
        }

    }

    @FXML
    void ThemLoaiChiHo(ActionEvent event) {

        if(contHang == null)
            return;

        if(LoiChuongTrinh.textFieldNull(id_TFTien) || LoiChuongTrinh.ComboBoxNull(id_CBLoaiChiHo)){
            return;
        }
        if(LoiChuongTrinh.textFieldSo(id_TFTien)){
            return;
        }
        LoaiChiHo_ContHang loaiChiHo_contHang = new LoaiChiHo_ContHang();
        LoaiChiHo loaiChiHo = id_CBLoaiChiHo.getSelectionModel().getSelectedItem();
        loaiChiHo_contHang.setContHang(contHang);
        loaiChiHo_contHang.setTien(Long.valueOf(id_TFTien.getText()));
        loaiChiHo_contHang.setLoaiChiHo(loaiChiHo);

        dsLoaiChiHoContHangs.add(loaiChiHo_contHang);
        loaiChiHos.remove(loaiChiHo);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        loaiChiHos = FXCollections.observableArrayList();
        loaiChiHoComboBoxService.setComboBox(id_CBLoaiChiHo);
        loaiChiHoComboBoxService.LoadCombo(loaiChiHos);

        dsLoaiChiHoContHangs = FXCollections.observableArrayList();
        id_TableChiHo.setItems(dsLoaiChiHoContHangs);


        id_ColTenChiHo.setCellValueFactory(new PropertyValueFactory<LoaiChiHo_ContHang,String>("noiDung"));
        id_ColTienChiHo.setCellValueFactory(new PropertyValueFactory<LoaiChiHo_ContHang,Long>("tien"));

        loaiChiHo_contHangTableViewService.setTableView(id_TableChiHo);
        loaiChiHo_contHangTableViewService.TaoCotXoa(dsLoaiChiHoContHangs,loaiChiHos);

    }

    public ContHang getContHang() {
        return contHang;
    }

    public void setContHang(ContHang contHang) {
        this.contHang = contHang;
        dsLoaiChiHoContHangs.clear();
        loaiChiHos.clear();
        dsLoaiChiHoContHangs.addAll(loaiChiHoContHangRespository.
                findAllByContHang(contHang));

        List<Long> idloaiChiHos1 = new ArrayList<Long>();
        dsLoaiChiHoContHangs.forEach(e -> {
            idloaiChiHos1.add(e.getLoaiChiHo().getId());
        });

        loaiChiHos.addAll(loaiChiHoRespository.LayDsLoaiChiHoChuaDuocChon(idloaiChiHos1));

    }
}
