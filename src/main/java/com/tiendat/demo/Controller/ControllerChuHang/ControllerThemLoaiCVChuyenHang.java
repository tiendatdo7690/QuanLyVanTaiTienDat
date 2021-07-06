package com.tiendat.demo.Controller.ControllerChuHang;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import com.tiendat.demo.ImplementRespository.LoaiCongViecRepositoryImplement;
import com.tiendat.demo.ImplementRespository.LoaiCongViec_ChuyenHangRespositoryImplement;
import com.tiendat.demo.Model.*;
import com.tiendat.demo.NodeService.ComboBoxService;
import com.tiendat.demo.NodeService.TableViewService;
import com.tiendat.demo.Respository.LoaiCongViecChuyenHangRespository;
import com.tiendat.demo.Respository.LoaiCongViecRepository;
import com.tiendat.demo.ThongBao.LoiChuongTrinh;
import com.tiendat.demo.ThongBao.ThongBao;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.net.URL;
import java.util.ResourceBundle;

@Component
public class ControllerThemLoaiCVChuyenHang implements Initializable {

    @FXML
    private Label id_LabelChuyenHang;

    @FXML
    private JFXComboBox<LoaiCongViec> id_ComboboxLoaiCV;

    @FXML
    private TableView<LoaiCongViec_ChuyenHang> id_TableLoaiCV;

    @FXML
    private TableColumn<LoaiCongViec_ChuyenHang, String> id_CotTen;

    @FXML
    private TableColumn<LoaiCongViec_ChuyenHang, Boolean> id_CotNguyenChuyen;

    private ComboBoxService<LoaiCongViec> loaiCongViecComboBoxService = new ComboBoxService<LoaiCongViec>() ;

    @Autowired
    private LoaiCongViecRepository loaiCongViecRepository = new LoaiCongViecRepositoryImplement();


    @Autowired
    private LoaiCongViecChuyenHangRespository loaiCongViecChuyenHangRespository =
            new LoaiCongViec_ChuyenHangRespositoryImplement();

    private ObservableList<LoaiCongViec> loaiCongViecsComboBox;
    private ObservableList<LoaiCongViec_ChuyenHang> loaiCongViecsTableView;

    private TableViewService<LoaiCongViec_ChuyenHang,ControllerThemLoaiCVChuyenHang> tableViewService =
            new TableViewService<>();
    private ChuyenHang chuyenHang;

    @FXML
    void Them(ActionEvent event) {

        if (LoiChuongTrinh.ComboBoxNull(id_ComboboxLoaiCV)){
            return;
        }



        LoaiCongViec loaiCongViec = id_ComboboxLoaiCV.getSelectionModel().getSelectedItem();
        LoaiCongViec_ChuyenHangPK loaiCongViec_chuyenHangPK = new LoaiCongViec_ChuyenHangPK();
        loaiCongViec_chuyenHangPK.setChuyenHangId(chuyenHang.getId());
        loaiCongViec_chuyenHangPK.setLoaiCongViecId(loaiCongViec.getId());

        LoaiCongViec_ChuyenHang loaiCongViec_chuyenHang = new LoaiCongViec_ChuyenHang();
        loaiCongViec_chuyenHang.setId(loaiCongViec_chuyenHangPK);
        loaiCongViec_chuyenHang.setChuyenHang(chuyenHang);
        loaiCongViec_chuyenHang.setLoaiCongViec(loaiCongViec);

        if(layLoaiCongViec_ChuyenHangDaCoTrongDS(loaiCongViecsTableView,loaiCongViec_chuyenHang)){
            return;
        }
        loaiCongViec_chuyenHang = loaiCongViecChuyenHangRespository.save(loaiCongViec_chuyenHang);
        //loaiCongViecsTableView.remove(layLoaiCongViec_ChuyenHangDaCoTrongDS(loaiCongViecsTableView,loaiCongViec_chuyenHang));
        loaiCongViecsTableView.add(loaiCongViec_chuyenHang);
    }

    private Boolean layLoaiCongViec_ChuyenHangDaCoTrongDS(
            ObservableList<LoaiCongViec_ChuyenHang> loaiCongViec_chuyenHangs,
            LoaiCongViec_ChuyenHang loaiCongViecChuyenHang){

        int checkNguyenChuyen = 0;
        if(loaiCongViecChuyenHang.getNguyenChuyen()){
            checkNguyenChuyen++;
        }


        for(LoaiCongViec_ChuyenHang e : loaiCongViec_chuyenHangs){

            if(e.getNguyenChuyen()){
                checkNguyenChuyen++;
                System.out.println("Check Nguyên chuyên: "+checkNguyenChuyen);
            }
            if(e.getId().equals(loaiCongViecChuyenHang.getId())) {
                ThongBao.showThongBao("Thêm Loại Công Việc Chuyến Hàng","Thêm Loại Công Việc",
                        "Trùng Loại Công Việc!!");
                return true;
            }
            if(checkNguyenChuyen > 1) {
                ThongBao.showThongBao("Thêm Loại Công Việc Chuyến Hàng","Thêm Loại Công Việc",
                        "Đã Có Nguyên Chuyến Hàng!!");
                return true;
            }


        }
        return false;
    }
    public void setChuyenHang(ChuyenHang chuyenHang) {

        System.out.println("Gán chuyens hàng");
        this.chuyenHang = chuyenHang;
        id_LabelChuyenHang.setText(chuyenHang.getTenChuyenHang());

        loaiCongViecsTableView = FXCollections.observableArrayList(loaiCongViecChuyenHangRespository.findAllByChuyenHang(chuyenHang));
        loaiCongViecsComboBox = FXCollections.observableArrayList(loaiCongViecRepository.findAllBy());

        loaiCongViecComboBoxService.setComboBox(id_ComboboxLoaiCV);

        loaiCongViecComboBoxService.LoadCombo(loaiCongViecsComboBox);

        id_TableLoaiCV.setItems(loaiCongViecsTableView);

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        id_CotTen.setCellValueFactory(new PropertyValueFactory<LoaiCongViec_ChuyenHang, String>("ten"));
        id_CotNguyenChuyen.setCellValueFactory(new PropertyValueFactory<LoaiCongViec_ChuyenHang, Boolean>("nguyenChuyen"));
        tableViewService.setController(this);
        tableViewService.setTableView(id_TableLoaiCV);
        tableViewService.TaoCotXoaDatabase();

    }

    public void XoaDatabase(LoaiCongViec_ChuyenHang e){
        try {
            loaiCongViecChuyenHangRespository.deleteById(e.getId());
            loaiCongViecsTableView.remove(e);
        }
        catch (Exception ex){
            ThongBao.showThongBao("Thêm Loại Công Việc Chuyến Hàng","Xóa Dữ Liệu",
                    "Loại Công Việc Đã Có Tiền Tài Xế");
        }

    }
}
