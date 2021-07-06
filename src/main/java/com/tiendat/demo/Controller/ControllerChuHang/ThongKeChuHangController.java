package com.tiendat.demo.Controller.ControllerChuHang;

import com.jfoenix.controls.JFXDatePicker;
import com.tiendat.demo.ImplementRespository.ChuHangRespositoryImplement;
import com.tiendat.demo.ImplementRespository.ChuyenHangRespositoryImplement;
import com.tiendat.demo.Model.ChuHang;
import com.tiendat.demo.Model.TienUngTaiXe;
import com.tiendat.demo.ModelView.ChuyenHangTaiXe;
import com.tiendat.demo.ModelView.ContHangView;
import com.tiendat.demo.NodeService.PaginationService;
import com.tiendat.demo.NodeService.TableViewThongKe;
import com.tiendat.demo.Respository.ChuHangRespository;
import com.tiendat.demo.Respository.ChuyenHangRespository;
import com.tiendat.demo.ThongBao.LoiChuongTrinh;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.Pagination;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileOutputStream;
import java.net.URL;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;

@Component
public class ThongKeChuHangController implements Initializable {

    @FXML
    private JFXDatePicker id_TuNgay;

    @FXML
    private Label id_TongKet;

    @FXML
    private JFXDatePicker id_DenNgay;

    @FXML
    private Pagination id_PaginationThongKe;

    private PaginationService paginationService ;

    private TableViewThongKe<ContHangView> chiPhiDauTableViewThongKe;

    private ChuHang chuHang;
    private List<ContHangView> contHangViewList;

    @Autowired
    private ChuHangRespository chuHangRespository = new ChuHangRespositoryImplement();

    public void ThongKe(ActionEvent actionEvent) {

        if(chuHang == null){
            return;
        }

        if(LoiChuongTrinh.datePickerNull(id_TuNgay) || LoiChuongTrinh.datePickerNull(id_DenNgay)
                || LoiChuongTrinh.loiChonNgaySai(id_TuNgay,id_DenNgay)){
            return;
        }


        Date tungay = Date.valueOf(id_TuNgay.getValue());
        Date denngay = Date.valueOf(id_DenNgay.getValue());

        List<Map<String, Object>> list =
                chuHangRespository.ThongKeChuHangTheoNgay(chuHang.getId(),tungay,denngay);

        contHangViewList = this.ChuyenThanhDsContHangViews(list);

        paginationService.taiDSPagination(contHangViewList,chiPhiDauTableViewThongKe.getTableView(),
                20);

        Long tongCuoc = Long.valueOf(0);
        Long tongHDHa = Long.valueOf(0);
        Long tongHDLay = Long.valueOf(0);
        Long tongChiPhi = Long.valueOf(0);

        for(ContHangView e : contHangViewList){
            tongCuoc = tongCuoc + e.getGiaCuoc();
            tongHDHa = tongHDHa + e.getHoaDonHa();
            tongHDLay = tongHDLay + e.getHoaDonNang();
            tongChiPhi = tongChiPhi + e.getChiPhi();
        }

        id_TongKet.setText("Tổng Cước: " + tongCuoc.toString() + "\n"
                + "Tổng HD Hạ : " + tongHDHa.toString() + "\n"
                + "Tổng HD Lấy : " + tongHDLay.toString() + "\n"
                + "Tổng Chi Phí : " + tongChiPhi.toString());

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        paginationService = new PaginationService();
        paginationService.setPagination(id_PaginationThongKe);
        chiPhiDauTableViewThongKe = new TableViewThongKe<>();

        chiPhiDauTableViewThongKe.TaoCot("stt","STT",String.class);
        chiPhiDauTableViewThongKe.TaoCot("ngay","Ngày",String.class);
        chiPhiDauTableViewThongKe.TaoCot("soCont","Số Cont",String.class);
        chiPhiDauTableViewThongKe.TaoCot("chuyen","Chuyến",String.class);
        chiPhiDauTableViewThongKe.TaoCot("cangLay","Cảng Lấy",String.class);
        chiPhiDauTableViewThongKe.TaoCot("cangHa","Cảng Hạ",String.class);
        chiPhiDauTableViewThongKe.TaoCot("soXe","Số Xe",String.class);
        chiPhiDauTableViewThongKe.TaoCot("giaCuoc","Giá Cước",Long.class);
        chiPhiDauTableViewThongKe.TaoCot("hoaDonNang","HĐ Nâng",Long.class);
        chiPhiDauTableViewThongKe.TaoCot("hoaDonHa","HĐ Hạ",Long.class);
        chiPhiDauTableViewThongKe.TaoCot("chiPhi","Chi Phí",Long.class);
        chiPhiDauTableViewThongKe.TaoCot("tenChiPhi","Ghi Chú",String.class);


    }

    public ChuHang getChuHang() {
        return chuHang;
    }

    public void setChuHang(ChuHang chuHang) {
        this.chuHang = chuHang;
    }

    private List<ContHangView> ChuyenThanhDsContHangViews(List<Map<String, Object>> list){
        List<ContHangView> contHangViews = new ArrayList<ContHangView>();
        int stt = 1;
        for (Map<String, Object> x : list){
            ContHangView contHangView = new ContHangView(x);
            List<Map<String, Object>> list1 =
                    chuHangRespository.LayDsChiHoTheoContHang(contHangView.getId_ContHang());
            contHangView.GanGiaTriPhiChiHo(list1);
            contHangView.setStt(stt++);
            contHangViews.add(contHangView);
        }
        return contHangViews;
    }

    public void XuatExel(ActionEvent actionEvent) {

        //Blank workbook
        if(chuHang == null || contHangViewList == null){
            return;
        }

        if(LoiChuongTrinh.datePickerNull(id_TuNgay) || LoiChuongTrinh.datePickerNull(id_DenNgay)
                || LoiChuongTrinh.loiChonNgaySai(id_TuNgay,id_DenNgay)){
            return;
        }


        Date tungay = Date.valueOf(id_TuNgay.getValue());
        Date denngay = Date.valueOf(id_DenNgay.getValue());

        XSSFWorkbook workbook = new XSSFWorkbook();

        //Create a blank sheet
        XSSFSheet sheet = workbook.createSheet("Bảng kê "+tungay.toString()+
                "-"+ denngay.toString());

        Row rowHeader = sheet.createRow(0);

        rowHeader.createCell(0).setCellValue("STT");
        rowHeader.createCell(1).setCellValue("Số Cont");
        rowHeader.createCell(2).setCellValue("Ngày");
        rowHeader.createCell(3).setCellValue("Nơi Hạ");
        rowHeader.createCell(4).setCellValue("Nơi Lấy");
        rowHeader.createCell(5).setCellValue("Số Xe");
        rowHeader.createCell(6).setCellValue("Hóa Đơn Hạ");
        rowHeader.createCell(7).setCellValue("Hóa Đơn Nâng");
        rowHeader.createCell(8).setCellValue("Cước");
        rowHeader.createCell(9).setCellValue("Nơi Đóng");
        rowHeader.createCell(10).setCellValue("Phụ Phí");
        rowHeader.createCell(11).setCellValue("Ghi Chú");

        int i = 1;

        for(ContHangView contHangView :contHangViewList){
            Row row = sheet.createRow(i);
            row.createCell(0).setCellValue(String.valueOf(i));
            row.createCell(1).setCellValue(contHangView.getSoCont());
            row.createCell(2).setCellValue(contHangView.getNgay().toString());
            row.createCell(3).setCellValue(contHangView.getCangHa());
            row.createCell(4).setCellValue(contHangView.getCangLay());
            row.createCell(5).setCellValue(contHangView.getSoXe());
            row.createCell(6).setCellValue(contHangView.getHoaDonHa());
            row.createCell(7).setCellValue(contHangView.getHoaDonNang());
            row.createCell(8).setCellValue(contHangView.getGiaCuoc());
            row.createCell(9).setCellValue(contHangView.getChuyen());
            row.createCell(10).setCellValue(contHangView.getChiPhi());
            row.createCell(11).setCellValue(contHangView.getTenChiPhi());
            i++;
        }
        try
        {
            //Write the workbook in file system

            File file = new File("F:\\XuatExel\\Bảng Kê "+ tungay.toString()+ denngay.toString().toString()+
                    "-"+ id_DenNgay.getValue()+".xlsx");
            FileOutputStream out = new FileOutputStream(file);
            workbook.write(out);
            out.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }



    }
}
