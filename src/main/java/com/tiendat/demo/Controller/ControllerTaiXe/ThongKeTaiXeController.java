package com.tiendat.demo.Controller.ControllerTaiXe;

import com.jfoenix.controls.JFXDatePicker;
import com.tiendat.demo.ImplementRespository.TaiXeRespositoryImplement;
import com.tiendat.demo.ImplementRespository.TienUngRespositoryImplement;
import com.tiendat.demo.Model.TaiXe;
import com.tiendat.demo.Model.TienUngTaiXe;
import com.tiendat.demo.ModelView.ChuyenHangTaiXe;
import com.tiendat.demo.NodeService.PaginationService;
import com.tiendat.demo.NodeService.TableViewThongKe;
import com.tiendat.demo.Respository.TaiXeRepository;
import com.tiendat.demo.Respository.TienUngRespository;
import com.tiendat.demo.ThongBao.LoiChuongTrinh;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.Pagination;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.net.URL;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;

@Component
public class ThongKeTaiXeController implements Initializable {

    @FXML
    private JFXDatePicker id_DateTuNgay;

    @FXML
    private JFXDatePicker id_DateDenNgay;

    @FXML
    private Label id_TongTienLuong;

    @FXML
    private Pagination id_PaginationBangLuong;

    @FXML
    private Pagination id_PaginationBangUngTien;

    private PaginationService paginationServiceLuong;

    private PaginationService paginationServiceTienUng;

    private TaiXe taiXe;

    private TableViewThongKe<ChuyenHangTaiXe> chuyenHangTaiXeTableViewThongKe;

    private TableViewThongKe<TienUngTaiXe> tienUngTaiXeTableViewThongKe;

    private List<ChuyenHangTaiXe> chuyenHangTaiXeList;

    private List<TienUngTaiXe> tienUngTaiXes;

    @Autowired
    private TaiXeRepository taiXeRepository = new TaiXeRespositoryImplement();

    @Autowired
    private TienUngRespository tienUngRespository = new TienUngRespositoryImplement();
//    @Autowired
//    private TimKiemTaiXeController timKiemTaiXeController;

    @FXML
    void ThongKe(ActionEvent event) {

        if(taiXe == null){
            System.out.println("Chưa chọn tx");
            return;
        }
        if(LoiChuongTrinh.datePickerNull(id_DateTuNgay)
        || LoiChuongTrinh.datePickerNull(id_DateDenNgay) || LoiChuongTrinh.loiChonNgaySai(id_DateTuNgay,id_DateDenNgay)){
            return;
        }


        Date tungay = Date.valueOf(id_DateTuNgay.getValue());
        Date denngay = Date.valueOf(id_DateDenNgay.getValue());

        List<Map<String, Object>> list =
                taiXeRepository.TimKiemChuyenHangTxChayTuNgayDenNgay(taiXe.getId(),tungay,denngay);
        tienUngTaiXes = tienUngRespository.findAllByTaiXeAndNgayBetween(taiXe,tungay,denngay);

        chuyenHangTaiXeList = ChuyenThanhDsChuyenHangTX(list);
        paginationServiceLuong.taiDSPagination(chuyenHangTaiXeList,
                chuyenHangTaiXeTableViewThongKe.getTableView(),20);

        paginationServiceTienUng.taiDSPagination(tienUngTaiXes,tienUngTaiXeTableViewThongKe.getTableView(),
                20);

        Long tongLuong = Long.valueOf(0);
        Long tongUng = Long.valueOf(0);

        for(ChuyenHangTaiXe e : chuyenHangTaiXeList){
            tongLuong = tongLuong + e.getTien();
        }

        for(TienUngTaiXe e : tienUngTaiXes){
            tongUng = tongUng + e.getTien();
        }
        Long tienConLai = tongLuong - tongUng;
        id_TongTienLuong.setText("Tổng Lương: " + tongLuong.toString() + " - " + "Tổng Ứng : " + tongUng.toString() + " = " +
                tienConLai.toString());
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        tienUngTaiXeTableViewThongKe = new TableViewThongKe<TienUngTaiXe>();
        chuyenHangTaiXeTableViewThongKe = new TableViewThongKe<ChuyenHangTaiXe>();

        paginationServiceTienUng = new  PaginationService();
        paginationServiceLuong = new  PaginationService();

        paginationServiceLuong.setPagination(id_PaginationBangLuong);
        paginationServiceTienUng.setPagination(id_PaginationBangUngTien);

        chuyenHangTaiXeTableViewThongKe.TaoCot("socont","Số Cont",String.class);
        chuyenHangTaiXeTableViewThongKe.TaoCot("tien","Tiền",Long.class);
        chuyenHangTaiXeTableViewThongKe.TaoCot("noiden","Nơi Đến",String.class);
        chuyenHangTaiXeTableViewThongKe.TaoCot("loaicongviec","Loại Công Việc",String.class);

        tienUngTaiXeTableViewThongKe.TaoCot("tien","Tiền",Long.class);
        tienUngTaiXeTableViewThongKe.TaoCot("ngay","Ngày",Date.class);
        tienUngTaiXeTableViewThongKe.TaoCot("hinhThuc","Hình Thức",String.class);


    }

    public TaiXe getTaiXe() {
        return taiXe;
    }

    public void setTaiXe(TaiXe taiXe) {
        this.taiXe = taiXe;
    }

    private List<ChuyenHangTaiXe> ChuyenThanhDsChuyenHangTX(List<Map<String, Object>> list){
        List<ChuyenHangTaiXe> chuyenHangTaiXeList = new ArrayList<ChuyenHangTaiXe>();
        for (Map<String, Object> x : list){
            chuyenHangTaiXeList.add(new ChuyenHangTaiXe(x));
        }
        return chuyenHangTaiXeList;
    }

}
