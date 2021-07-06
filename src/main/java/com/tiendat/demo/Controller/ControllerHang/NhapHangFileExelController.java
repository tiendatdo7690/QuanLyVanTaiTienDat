package com.tiendat.demo.Controller.ControllerHang;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import com.tiendat.demo.Exception.CV_TX_CHException;
import com.tiendat.demo.ImplementRespository.*;
import com.tiendat.demo.Model.*;
import com.tiendat.demo.ModelView.ContHangExel;
import com.tiendat.demo.NodeService.PaginationService;
import com.tiendat.demo.Respository.*;
import com.tiendat.demo.ThongBao.ThongBao;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Pagination;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellAddress;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

import static org.apache.poi.ss.usermodel.CellType.*;

@Component
public class NhapHangFileExelController implements Initializable {

    @FXML
    private JFXTextField id_URLFile;
    @FXML
    private Pagination id_PaginationConhangExel;

    private List<ContHangExel> contHangExels = new ArrayList<>();

    private TableView<ContHangExel> contHangExelTableView;

    private TableColumn<ContHangExel,String> col_SoCont;
    private TableColumn<ContHangExel,String> col_CangLay;
    private TableColumn<ContHangExel,String> col_CangHa;
    private TableColumn<ContHangExel,String> col_ChuyenHang;
    private TableColumn<ContHangExel,String> col_SoXe;
    private TableColumn<ContHangExel,Integer> col_STT;
    private TableColumn<ContHangExel,Date> col_Ngay;
    private TableColumn<ContHangExel,Long> col_HoaDonNang;
    private TableColumn<ContHangExel,Long> col_HoaDonHa;
    private TableColumn<ContHangExel,Long> col_Cuoc;

    @FXML
    private JFXComboBox<ChuHang> id_CBChuHang;

    @FXML
    private JFXComboBox<LoaiHang> id_CBLoaiHang;

    @Autowired
    private ChuHangRespository chuHangRespository = new ChuHangRespositoryImplement();

    @Autowired
    private LoaiHangRespository loaiHangRespository = new LoaiHangRespositoryImplement();

    @Autowired
    private ContHangTXCVDAO contHangTXCVDAO;

    private PaginationService paginationService = new PaginationService();
    @FXML
    void NhapContHang(ActionEvent event) throws CV_TX_CHException {

        ChuHang chuHang = id_CBChuHang.getSelectionModel().getSelectedItem();
        LoaiHang loaiHang = id_CBLoaiHang.getSelectionModel().getSelectedItem();
        contHangTXCVDAO.saveContHangExel(contHangExels,chuHang,loaiHang);

    }

    @FXML
    void NhapFile(ActionEvent event) {

        contHangExels.clear();
        FileInputStream fileInputStream = null;
        Workbook workbook = null;
        FileChooser directoryChooser = new FileChooser();
        configuringDirectoryChooser(directoryChooser);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

        try {
            fileInputStream = new FileInputStream(id_URLFile.getText());
            workbook = new XSSFWorkbook(fileInputStream);
            Sheet sheet = workbook.getSheetAt(0);

            Row rowHeader = sheet.getRow(0);
            System.out.print(rowHeader.getCell(0).getStringCellValue() + "\t");
            System.out.print(rowHeader.getCell(1).getStringCellValue() + "\t");
            System.out.print(rowHeader.getCell(2).getStringCellValue() + "\t");
            System.out.print(rowHeader.getCell(3).getStringCellValue() + "\t");
            System.out.print(rowHeader.getCell(4).getStringCellValue() + "\t");
            System.out.print(rowHeader.getCell(5).getStringCellValue() + "\t");
            System.out.print(rowHeader.getCell(6).getStringCellValue() + "\t");
            System.out.print(rowHeader.getCell(7).getStringCellValue() + "\t");
            System.out.print(rowHeader.getCell(8).getStringCellValue() + "\t");
            System.out.print(rowHeader.getCell(9).getStringCellValue() + "\n");


            for(int i = 1; i <= sheet.getLastRowNum();i++){

                ContHangExel contHangExel = new ContHangExel();

                Row row = sheet.getRow(i);

                Cell cell0 = row.getCell(0);
                if(cell0.getCellType() != NUMERIC){
                    System.out.println("Sai Dữ Liệu Ô " + cell0.getColumnIndex() + "," + cell0.getRowIndex());
                    fileInputStream.close();
                    return;
                }
                contHangExel.setStt((int) cell0.getNumericCellValue());


                Cell cell1 = row.getCell(1);
                if(!DateUtil.isCellDateFormatted(cell1)){
                    System.out.println("Sai Dữ Liệu Ô " + cell1.getColumnIndex() +
                            "," + cell1.getRowIndex());
                    fileInputStream.close();
                    return;
                }
                LocalDate localDate = cell1.getLocalDateTimeCellValue().toLocalDate();
                contHangExel.setNgay(Date.valueOf(localDate));


                Cell cell2 = row.getCell(2);
                if(cell2.getCellType() != STRING){
                    System.out.println("Sai Dữ Liệu Ô " + cell2.getColumnIndex() + "," + cell1.getRowIndex());
                    fileInputStream.close();
                    return;
                }
                contHangExel.setSoCont(cell2.getStringCellValue());

                Cell cell3 = row.getCell(3);
                if(cell3.getCellType() != STRING){
                    System.out.println("Sai Dữ Liệu Ô " + cell3.getColumnIndex() + "," + cell3.getRowIndex());
                    fileInputStream.close();
                    return;
                }
                contHangExel.setCangHa(cell3.getStringCellValue());


                Cell cell4 = row.getCell(4);
                if(cell4.getCellType() != STRING){
                    System.out.println("Sai Dữ Liệu Ô " + cell4.getColumnIndex() + "," + cell4.getRowIndex());
                    fileInputStream.close();
                    return;
                }
                contHangExel.setCangLay(cell4.getStringCellValue());

                Cell cell5 = row.getCell(5);
                if(cell5.getCellType() != STRING){
                    System.out.println("Sai Dữ Liệu Ô " + cell5.getColumnIndex() + "," + cell5.getRowIndex());
                    fileInputStream.close();
                    return;
                }
                contHangExel.setSoXe(cell5.getStringCellValue());

                Cell cell6 = row.getCell(6);
                if(cell6.getCellType() != NUMERIC){
                    System.out.println("Sai Dữ Liệu Ô " + cell6.getColumnIndex() + "," + cell6.getRowIndex());
                    fileInputStream.close();
                    return;
                }
                contHangExel.setHoaDonHa((long) cell6.getNumericCellValue());


                Cell cell7 = row.getCell(7);
                if(cell7.getCellType() != NUMERIC){
                    System.out.println("Sai Dữ Liệu Ô " + cell7.getColumnIndex() + "," + cell7.getRowIndex());
                    fileInputStream.close();
                    return;
                }
                contHangExel.setHoaDonNang((long) cell7.getNumericCellValue());

                Cell cell8 = row.getCell(8);
                if(cell8.getCellType() != NUMERIC){
                    System.out.println("Sai Dữ Liệu Ô " + cell8.getColumnIndex() + "," + cell8.getRowIndex());
                    fileInputStream.close();
                    return;
                }
                contHangExel.setGiaCuoc((long) cell8.getNumericCellValue());

                Cell cell9 = row.getCell(9);
                if(cell9.getCellType() != STRING){
                    System.out.println("Sai Dữ Liệu Ô " + cell9.getColumnIndex() + "," + cell9.getRowIndex());
                    fileInputStream.close();
                    return;
                }
                contHangExel.setChuyen(cell9.getStringCellValue());

                contHangExels.add(contHangExel);

            }
            fileInputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }catch (IllegalStateException e) {
            // Important irelevant stuff
            ThongBao.showThongBao("Nhập File Exel","Lỗi Dữ Liệu",e.getMessage());
        }
        paginationService.taiDSPagination(contHangExels,contHangExelTableView,20);

    }

    private void configuringDirectoryChooser(FileChooser directoryChooser) {

        // Set tiêu đề cho DirectoryChooser
        directoryChooser.setTitle("Select Some Directories");


        // Sét thư mục bắt đầu nhìn thấy khi mở DirectoryChooser
        directoryChooser.setInitialDirectory(new File(System.getProperty("user.home")));
    }

    @FXML
    void ChonFile(MouseEvent event) {

        FileInputStream fileInputStream = null;
        Workbook workbook = null;
        id_URLFile.clear();
        FileChooser directoryChooser = new FileChooser();
        configuringDirectoryChooser(directoryChooser);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

        File selectedFile = directoryChooser.showOpenDialog(null);
        if(selectedFile != null) {
            id_URLFile.setText(selectedFile.getAbsolutePath());
        }


    }

    public void LamMoi(){

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        contHangExelTableView = new TableView<>();

        col_SoCont = new TableColumn<>("Số Cont");
        col_CangHa = new TableColumn<>("Cảng Hạ");
        col_CangLay = new TableColumn<>("Cảng Lấy");
        col_ChuyenHang = new TableColumn<>("Chuyến Hàng");
        col_Cuoc = new TableColumn<>("Cước");
        col_HoaDonNang = new TableColumn<>("Hóa Đơn Nâng");
        col_Ngay = new TableColumn<>("Ngày");
        col_STT = new TableColumn<>("STT");
        col_SoXe = new TableColumn<>("Số Xe");
        col_HoaDonHa = new TableColumn<>("Hóa  Đơn Hạ");

        col_SoCont.setCellValueFactory(new PropertyValueFactory<ContHangExel, String>("soCont"));
        col_CangHa.setCellValueFactory(new PropertyValueFactory<ContHangExel, String>("cangHa"));
        col_CangLay.setCellValueFactory(new PropertyValueFactory<ContHangExel, String>("cangLay"));
        col_ChuyenHang.setCellValueFactory(new PropertyValueFactory<ContHangExel, String>("chuyen"));
        col_Cuoc.setCellValueFactory(new PropertyValueFactory<ContHangExel, Long>("giaCuoc"));
        col_HoaDonNang.setCellValueFactory(new PropertyValueFactory<ContHangExel, Long>("hoaDonNang"));
        col_Ngay.setCellValueFactory(new PropertyValueFactory<ContHangExel, Date>("ngay"));
        col_STT.setCellValueFactory(new PropertyValueFactory<ContHangExel, Integer>("stt"));
        col_SoXe.setCellValueFactory(new PropertyValueFactory<ContHangExel, String>("soXe"));
        col_HoaDonHa.setCellValueFactory(new PropertyValueFactory<ContHangExel, Long>("hoaDonHa"));

        contHangExelTableView.getColumns().addAll(col_STT,col_Ngay,col_SoCont,col_CangHa,col_CangLay,col_HoaDonHa,col_HoaDonNang,
                col_SoXe,col_Cuoc,col_ChuyenHang);

        //contHangExelTableView.setItems(contHangExels);

        paginationService.setPagination(id_PaginationConhangExel);

        ObservableList<ChuHang> chuHangs = FXCollections.
                observableArrayList(chuHangRespository.findAllByTrangThaiTrue());
        id_CBChuHang.setItems(chuHangs);

        ObservableList<LoaiHang> loaiHangs = FXCollections.
                observableArrayList(loaiHangRespository.findAllBy());
        id_CBLoaiHang.setItems(loaiHangs);

    }
}
