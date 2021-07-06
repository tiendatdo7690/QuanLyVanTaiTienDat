package com.tiendat.demo.Controller.ControllerXe;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.tiendat.demo.ImplementRespository.*;
import com.tiendat.demo.Model.*;
import com.tiendat.demo.NodeService.PaginationService;
import com.tiendat.demo.NodeService.TableViewService;
import com.tiendat.demo.NodeService.TableViewThongKe;
import com.tiendat.demo.Respository.*;
import com.tiendat.demo.ThongBao.LoiChuongTrinh;
import com.tiendat.demo.ThongBao.ThongBao;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.Pagination;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.net.URL;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;

@Component
public class ThongKeXeController implements Initializable {

    @FXML
    private JFXDatePicker id_TuNgay;

    @FXML
    private Label id_TongKet;

    @FXML
    private JFXDatePicker id_DenNgay;

    @FXML
    private JFXComboBox<String> id_CbLoaiThongKe;

    @FXML
    private Pagination id_PaginationThongKe;

    @Autowired
    private ChiPhiDauRespository chiPhiDauRespository = new ChiPhiDauRespositoryImplement();

    @Autowired
    private ChiPhiKhacRespository chiPhiKhacRespository = new ChiPhiKhacRespositoryImplement();

    @Autowired
    private ChiPhiThayNhotRespository chiPhiThayNhotRespository = new ChiPhiThayNhotRespositoryImplement();

    @Autowired
    private ChiPhiVoXeRepository chiPhiVoXeRepository = new ChiPhiVoXeRepositoryImplement();

    @Autowired
    private ChiPhiXetXeRespository chiPhiXetXeRespository = new ChiPhiXetXeRespositoryImplement();


    private PaginationService paginationService = new PaginationService();

    private TableViewService<ChiPhiDau,ThongKeXeController> chiPhiDauTableViewThongKe;

    private TableViewService<ChiPhiThayNhot,ThongKeXeController> chiPhiThayNhotTableViewThongKe;

    private TableViewService<ChiPhiVoXe,ThongKeXeController> chiPhiVoXeTableViewThongKe;

    private TableViewService<ChiPhiXeKhac,ThongKeXeController> chiPhiXeKhacTableViewThongKe;

    private TableViewService<ChiPhiXetXe,ThongKeXeController> chiPhiXetXeTableViewThongKe;
    @FXML
    void ThongKe(ActionEvent event) {

        if(LoiChuongTrinh.datePickerNull(id_DenNgay) ||
                LoiChuongTrinh.datePickerNull(id_TuNgay)){
            return;
        }
        if(LoiChuongTrinh.loiChonNgaySai(id_TuNgay,id_DenNgay)){
            return;
        }

        String loaiThongKe = id_CbLoaiThongKe.getSelectionModel().getSelectedItem();

        Date tuNgay = Date.valueOf(id_TuNgay.getValue());
        Date denNgay = Date.valueOf(id_DenNgay.getValue());
        switch(loaiThongKe) {
            case "Chi Phí Dầu":
                // code block
                this.LoadThongKeChiPhiDau(tuNgay,denNgay);
                break;
            case "Chi Phí Khác":
                // code block
                this.LoadThongKeChiPhiKhac(tuNgay,denNgay);
                break;
            case "Chi Phí Vỏ Xe":
                // code block
                this.LoadThongKeChiPhiVoXe(tuNgay,denNgay);
                break;
            case "Chi Phí Xét Xe":
                // code block
                this.LoadThongKeChiPhiXetXe(tuNgay,denNgay);
                break;
            case "Chi Phí Thay Nhớt":
                // code block
                this.LoadThongKeChiPhiThayNhot(tuNgay,denNgay);
                break;
            default:
                // code block
        }

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        List<String> listLoaiThongKe = new ArrayList<String>();
        listLoaiThongKe.add("Chi Phí Dầu");
        listLoaiThongKe.add("Chi Phí Khác");
        listLoaiThongKe.add("Chi Phí Vỏ Xe");
        listLoaiThongKe.add("Chi Phí Xét Xe");
        listLoaiThongKe.add("Chi Phí Thay Nhớt");

        id_CbLoaiThongKe.setItems(FXCollections.observableArrayList(listLoaiThongKe));

        id_CbLoaiThongKe.getSelectionModel().selectFirst();

        /////////////////////////////////////////////////////////////
        chiPhiDauTableViewThongKe = new TableViewService<>();
        chiPhiDauTableViewThongKe.setController(this);
        chiPhiDauTableViewThongKe.TaoCotEditDouble("lit","Số Lít");
        chiPhiDauTableViewThongKe.TaoCotEditLong("tien","Tiền Dầu");
        chiPhiDauTableViewThongKe.TaoCotEditDate("ngay","Ngày Đổ");
        chiPhiDauTableViewThongKe.TaoCotXoaDatabase();

        /////////////////////////////////////////////////////////////
        chiPhiThayNhotTableViewThongKe = new TableViewService<>();
        chiPhiThayNhotTableViewThongKe.setController(this);
        chiPhiThayNhotTableViewThongKe.TaoCotEditLong("tien","Tiền");
        chiPhiThayNhotTableViewThongKe.TaoCotEditDate("ngay","Ngày Thay");
        chiPhiThayNhotTableViewThongKe.TaoCotXoaDatabase();

        /////////////////////////////////////////////////////////////
        chiPhiVoXeTableViewThongKe = new TableViewService<>();
        chiPhiVoXeTableViewThongKe.setController(this);
        chiPhiVoXeTableViewThongKe.TaoCotEditInteger("soLuong","Số Lượng");
        chiPhiVoXeTableViewThongKe.TaoCotEditLong("tien","Tiền");
        chiPhiVoXeTableViewThongKe.TaoCotEditDate("ngay","Ngày Thay");
        chiPhiVoXeTableViewThongKe.TaoCotXoaDatabase();

        /////////////////////////////////////////////////////////////
        chiPhiXeKhacTableViewThongKe = new TableViewService<>();
        chiPhiXeKhacTableViewThongKe.setController(this);
        chiPhiXeKhacTableViewThongKe.TaoCotEditLong("tien","Tiền");
        chiPhiXeKhacTableViewThongKe.TaoCotEditString("noiDung","Nội Dung");
        chiPhiXeKhacTableViewThongKe.TaoCotEditDate("ngay","Ngày");
        chiPhiXeKhacTableViewThongKe.TaoCotXoaDatabase();

        /////////////////////////////////////////////////////////////
        chiPhiXetXeTableViewThongKe = new TableViewService<>();
        chiPhiXetXeTableViewThongKe.setController(this);
        chiPhiXetXeTableViewThongKe.TaoCotEditLong("tien","Tiền");
        chiPhiXetXeTableViewThongKe.TaoCotEditDate("ngay","Ngày");
        chiPhiXetXeTableViewThongKe.TaoCotXoaDatabase();



        paginationService.setPagination(id_PaginationThongKe);


    }

    private void LoadThongKeChiPhiDau(Date tuNgay, Date denNgay){

        List<ChiPhiDau> chiPhiDauList =
                chiPhiDauRespository.findAllByNgayBetween(tuNgay,denNgay);

        Long tongTien = Long.valueOf(0);
        Double soLit = 0.0;
        for (ChiPhiDau chiPhiDau : chiPhiDauList){
            tongTien = tongTien + chiPhiDau.getTien();
            soLit = soLit + chiPhiDau.getLit();
        }

        String tongKet = this.LoiTongKetDau(tuNgay.toString(),denNgay.toString(),
                tongTien.toString(),soLit.toString());
        paginationService.taiDSPagination(chiPhiDauList,chiPhiDauTableViewThongKe.getTableView(),20);
        id_TongKet.setText(tongKet);
    }

    private void LoadThongKeChiPhiXetXe(Date tuNgay, Date denNgay){

        List<ChiPhiXetXe> chiPhiXetXeList =
                chiPhiXetXeRespository.findAllByNgayBetween(tuNgay,denNgay);
        Long tongTien = Long.valueOf(0);
        for (ChiPhiXetXe e : chiPhiXetXeList){
            tongTien = tongTien + e.getTien();

        }
        String tongKet = this.LoiTongKetXetXe(tuNgay.toString(),denNgay.toString(),
                tongTien.toString());

        paginationService.taiDSPagination(chiPhiXetXeList,chiPhiXetXeTableViewThongKe.getTableView(),20);
        id_TongKet.setText(tongKet);
    }

    private void LoadThongKeChiPhiVoXe(Date tuNgay, Date denNgay){

        List<ChiPhiVoXe> chiPhiVoXeList =
                chiPhiVoXeRepository.findAllByNgayBetween(tuNgay,denNgay);
        Long tongTien = Long.valueOf(0);
        Integer soLuong = 0;
        for (ChiPhiVoXe e : chiPhiVoXeList){
            tongTien = tongTien + e.getTien();
            soLuong = soLuong + e.getSoLuong();
        }
        String tongKet = this.LoiTongKetVoXe(tuNgay.toString(),denNgay.toString(),
                tongTien.toString(),soLuong.toString());

        paginationService.taiDSPagination(chiPhiVoXeList,chiPhiVoXeTableViewThongKe.getTableView(),20);
        id_TongKet.setText(tongKet);
    }

    private void LoadThongKeChiPhiKhac(Date tuNgay, Date denNgay){

        List<ChiPhiXeKhac> chiPhiXeKhacList =
                chiPhiKhacRespository.findAllByNgayBetween(tuNgay,denNgay);
        Long tongTien = Long.valueOf(0);
        for (ChiPhiXeKhac e : chiPhiXeKhacList){
            tongTien = tongTien + e.getTien();

        }
        String tongKet = this.LoiTongKetKhac(tuNgay.toString(),denNgay.toString(),
                tongTien.toString());
        paginationService.taiDSPagination(chiPhiXeKhacList,chiPhiXeKhacTableViewThongKe.getTableView(),20);
        id_TongKet.setText(tongKet);
    }

    private void LoadThongKeChiPhiThayNhot(Date tuNgay, Date denNgay){

        List<ChiPhiThayNhot> chiPhiThayNhotList =
                chiPhiThayNhotRespository.findAllByNgayBetween(tuNgay,denNgay);
        Long tongTien = Long.valueOf(0);
        for (ChiPhiThayNhot e : chiPhiThayNhotList){
            tongTien = tongTien + e.getTien();

        }
        String tongKet = this.LoiTongKetNhot(tuNgay.toString(),denNgay.toString(),
                tongTien.toString());
        paginationService.taiDSPagination(chiPhiThayNhotList,chiPhiThayNhotTableViewThongKe.getTableView(),20);
        id_TongKet.setText(tongKet);
    }

    private String LoiTongKetDau(String tuNgay,String denNgay,
                              String tongTien,String soLit){
        return "Thống Kê Dầu" +
                " : " +
                "Từ Ngày : " + tuNgay +
                " Đến Ngày : "+ denNgay +
                " Số Lít : "+ soLit +
                ", Tổng Tiền : " +tongTien;
    }

    private String LoiTongKetKhac(String tuNgay,String denNgay,
                                 String tongTien){
        return "Thống Kê Chi Phí Khác" +
                " : " +
                "Từ Ngày : " + tuNgay +
                " Đến Ngày : "+ denNgay +
                ", Tổng Tiền : " +tongTien;
    }
    private String LoiTongKetNhot(String tuNgay,String denNgay,
                                 String tongTien){
        return "Thống Kê Dầu" +
                " : " +
                "Từ Ngày : " + tuNgay +
                " Đến Ngày : "+ denNgay +
                ", Tổng Tiền : " +tongTien;
    }
    private String LoiTongKetVoXe(String tuNgay,String denNgay,
                                 String tongTien,String soLuong){
        return "Thống Kê Dầu" +
                " : " +
                "Từ Ngày : " + tuNgay +
                " Đến Ngày : "+ denNgay +
                " Số Lượng : "+ soLuong +
                ", Tổng Tiền : " +tongTien;
    }
    private String LoiTongKetXetXe(String tuNgay,String denNgay,
                                 String tongTien){
        return "Thống Kê Dầu" +
                " : " +
                "Từ Ngày : " + tuNgay +
                " Đến Ngày : "+ denNgay +
                ", Tổng Tiền : " +tongTien;
    }
    public void XoaDatabase(ChiPhiDau e){

        Optional<ButtonType> option = ThongBao.ShowConfirm("Xóa Chi Phí Dầu","Chi Phí Dầu",
                "Bạn Có Chắc Muốn Xóa?");

        if (option.get() == ButtonType.OK) {
            chiPhiDauTableViewThongKe.getTableView().getItems().remove(e);
            chiPhiDauRespository.delete(e);
        }
    }

    public void XoaDatabase(ChiPhiThayNhot e){
        Optional<ButtonType> option = ThongBao.ShowConfirm("Xóa Chi Phí Thay Nhớt","Chi Phí Thay Nhớt",
                "Bạn Có Chắc Muốn Xóa?");

        if (option.get() == ButtonType.OK) {
            chiPhiThayNhotTableViewThongKe.getTableView().getItems().remove(e);
            chiPhiThayNhotRespository.delete(e);
        }
    }

    public void XoaDatabase(ChiPhiVoXe e){
        Optional<ButtonType> option = ThongBao.ShowConfirm("Xóa Chi Phí Vỏ Xe","Chi Phí Vỏ Xe",
                "Bạn Có Chắc Muốn Xóa?");

        if (option.get() == ButtonType.OK) {
            chiPhiVoXeTableViewThongKe.getTableView().getItems().remove(e);
            chiPhiVoXeRepository.delete(e);
        }
    }

    public void XoaDatabase(ChiPhiXetXe e){
        Optional<ButtonType> option = ThongBao.ShowConfirm("Xóa Chi Phí Xét Xe","Chi Phí Xét Xe",
                "Bạn Có Chắc Muốn Xóa?");

        if (option.get() == ButtonType.OK) {
            chiPhiXetXeTableViewThongKe.getTableView().getItems().remove(e);
            chiPhiXetXeRespository.delete(e);
        }
    }

    public void XoaDatabase(ChiPhiXeKhac e){
        Optional<ButtonType> option = ThongBao.ShowConfirm("Xóa Chi Khác","Chi Phí Khác",
                "Bạn Có Chắc Muốn Xóa?");

        if (option.get() == ButtonType.OK) {
            chiPhiXeKhacTableViewThongKe.getTableView().getItems().remove(e);
            chiPhiKhacRespository.delete(e);
        }
    }

    public void UpdateString(ChiPhiXeKhac e,String newValue){
        e.setNoiDung(newValue);
        chiPhiKhacRespository.save(e);
    }

    public void UpdateDouble(ChiPhiDau e,Double newValue){
        e.setLit(newValue);
        chiPhiDauRespository.save(e);
    }

    public void UpdateLong(ChiPhiXeKhac e,Long newValue){
        e.setTien(newValue);
        chiPhiKhacRespository.save(e);
    }
    public void UpdateLong(ChiPhiThayNhot e,Long newValue){
        e.setTien(newValue);
        chiPhiThayNhotRespository.save(e);
    }
    public void UpdateLong(ChiPhiDau e,Long newValue){
        e.setTien(newValue);
        chiPhiDauRespository.save(e);
    }
    public void UpdateLong(ChiPhiVoXe e,Long newValue){
        e.setTien(newValue);
        chiPhiVoXeRepository.save(e);
    }
    public void UpdateLong(ChiPhiXetXe e,Long newValue){
        e.setTien(newValue);
        chiPhiXetXeRespository.save(e);
    }

    public void UpdateDate(ChiPhiXeKhac e, Date newValue){
        e.setNgay(newValue);
        chiPhiKhacRespository.save(e);
    }
    public void UpdateDate(ChiPhiThayNhot e,Date newValue){
        e.setNgay(newValue);
        chiPhiThayNhotRespository.save(e);
    }
    public void UpdateDate(ChiPhiDau e,Date newValue){
        e.setNgay(newValue);
        chiPhiDauRespository.save(e);
    }
    public void UpdateDate(ChiPhiVoXe e,Date newValue){
        e.setNgay(newValue);
        chiPhiVoXeRepository.save(e);
    }
    public void UpdateDate(ChiPhiXetXe e,Date newValue){
        e.setNgay(newValue);
        chiPhiXetXeRespository.save(e);
    }

    public void UpdateInteger(ChiPhiVoXe e,Integer newValue){
        e.setSoLuong(newValue);
        chiPhiVoXeRepository.save(e);
    }
}
