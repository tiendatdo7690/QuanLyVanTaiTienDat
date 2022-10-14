package com.tiendat.demo.Controller.ControllerHang;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import com.tiendat.demo.Exception.CV_TX_CHException;
import com.tiendat.demo.Exception.ChiHo_ContHangException;
import com.tiendat.demo.Exception.ChiPhiContHang_ContHangException;
import com.tiendat.demo.ImplementRespository.ChiPhiContHangContHangRespositoryImplement;
import com.tiendat.demo.ImplementRespository.ContHangTXCVDAO;
import com.tiendat.demo.ImplementRespository.LoaiChiPhiContHangRespositoryImplement;
import com.tiendat.demo.Model.ChiPhiContHang_ContHang;
import com.tiendat.demo.Model.ContHang;
import com.tiendat.demo.Model.LoaiChiHo_ContHang;
import com.tiendat.demo.Model.LoaiChiPhiContHang;
import com.tiendat.demo.NodeService.ComboBoxService;
import com.tiendat.demo.NodeService.TableViewThemService;
import com.tiendat.demo.Respository.ChiPhiContHangContHangRespository;
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
public class ChiPhiContHangController implements Initializable {

    @FXML
    private JFXTextField id_TFTien;

    @FXML
    private JFXComboBox<LoaiChiPhiContHang> id_CBLoaiChiPhi;

    @FXML
    private TableView<ChiPhiContHang_ContHang> id_TableChiPhi;

    @FXML
    private TableColumn<ChiPhiContHang_ContHang, String> id_ColTenChiPhi;

    @FXML
    private TableColumn<ChiPhiContHang_ContHang, Long> id_ColTien;

    private TableViewThemService<ChiPhiContHang_ContHang, LoaiChiPhiContHang> chiPhiContHang_contHangTableViewService =
            new TableViewThemService<ChiPhiContHang_ContHang,LoaiChiPhiContHang>();

    private ComboBoxService<LoaiChiPhiContHang> loaiChiPhiContHangComboBoxService =
            new ComboBoxService<LoaiChiPhiContHang>();

    private ObservableList<LoaiChiPhiContHang> loaiChiPhiContHangs;

    private ObservableList<ChiPhiContHang_ContHang> dsChiPhiContHang;

    private ContHang contHang;

    @Autowired
    private LoaiChiPhiContHangRespository loaiChiPhiContHangRespository =
            new LoaiChiPhiContHangRespositoryImplement();
    @Autowired
    private ChiPhiContHangContHangRespository chiPhiContHangContHangRespository =
            new ChiPhiContHangContHangRespositoryImplement();

    @Autowired
    private ContHangTXCVDAO contHangTXCVDAO;

    @FXML
    void CapNhatChiPhi(ActionEvent event) {

        try {
            contHangTXCVDAO.UpdateChiPhiContHang(dsChiPhiContHang, contHang);
            ThongBao.showThongBaoThanhCong("Cập Nhật Ds Chi Phí");
        }
        catch (ChiPhiContHang_ContHangException exception2){

            ThongBao.showThongBaoLoiCVThem2Lan("Bảng Chi Phí");
        }
    }

    @FXML
    void ThemChiPhi(ActionEvent event) {

        if(contHang == null)
            return;

        if(LoiChuongTrinh.textFieldNull(id_TFTien) || LoiChuongTrinh.ComboBoxNull(id_CBLoaiChiPhi)){
            return;
        }
        if(LoiChuongTrinh.textFieldSo(id_TFTien)){
            return;
        }

        ChiPhiContHang_ContHang chiPhiContHang_contHang = new ChiPhiContHang_ContHang();
        LoaiChiPhiContHang loaiChiPhiContHang = id_CBLoaiChiPhi.getSelectionModel().getSelectedItem();

        chiPhiContHang_contHang.setContHang(contHang);
        chiPhiContHang_contHang.setTien(Long.valueOf(id_TFTien.getText()));
        chiPhiContHang_contHang.setLoaiChiPhiContHang(loaiChiPhiContHang);

        dsChiPhiContHang.add(chiPhiContHang_contHang);
        loaiChiPhiContHangs.remove(loaiChiPhiContHang);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        loaiChiPhiContHangs = FXCollections.observableArrayList();
        loaiChiPhiContHangComboBoxService.setComboBox(id_CBLoaiChiPhi);
        loaiChiPhiContHangComboBoxService.LoadCombo(loaiChiPhiContHangs);

        id_ColTien.setCellValueFactory(new PropertyValueFactory<ChiPhiContHang_ContHang,Long>("tien"));
        id_ColTenChiPhi.setCellValueFactory(new PropertyValueFactory<ChiPhiContHang_ContHang,String>("noiDung"));

        dsChiPhiContHang = FXCollections.observableArrayList();
        id_TableChiPhi.setItems(dsChiPhiContHang);
        chiPhiContHang_contHangTableViewService.setTableView(id_TableChiPhi);
        chiPhiContHang_contHangTableViewService.TaoCotXoa(dsChiPhiContHang,loaiChiPhiContHangs);
    }

    public ContHang getContHang() {
        return contHang;
    }

    //11/10/2022 thêm kiểm tra idloaiChiPhiContHangs1 == 0 thì add tất cả
    public void setContHang(ContHang contHang) {

        this.contHang = contHang;

        dsChiPhiContHang.clear();
        loaiChiPhiContHangs.clear();
        dsChiPhiContHang.addAll(chiPhiContHangContHangRespository.
                findAllByContHang(contHang));

        List<Long> idloaiChiPhiContHangs1 = new ArrayList<Long>(0);
        dsChiPhiContHang.forEach(e -> {
            idloaiChiPhiContHangs1.add(e.getLoaiChiPhiContHang().getId());
        });

        if(idloaiChiPhiContHangs1.size() == 0) {
            loaiChiPhiContHangs.addAll(loaiChiPhiContHangRespository.
                    findAllBy());
        }
        else {
            loaiChiPhiContHangs.addAll(loaiChiPhiContHangRespository.
                    LayDsLoaiChiPhiContHangChuaDuocChon(idloaiChiPhiContHangs1));
        }

    }
}
