package com.tiendat.demo.NodeService;

import com.tiendat.demo.DialogService.DialogInterfce.IDialogThemThuocTinhChuyenHang;
import com.tiendat.demo.Model.ChuHang;
import com.tiendat.demo.Model.ChuyenHang;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.input.MouseEvent;
import javafx.util.Callback;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

@Service
public class TableViewChuyenHangService {


    private IDialogThemThuocTinhChuyenHang dialogThemTienTx;
    private IDialogThemThuocTinhChuyenHang dialogThemGiaCuoc;
    private IDialogThemThuocTinhChuyenHang dialogThemLoaiCV;

    @Autowired
    @Qualifier("DialogThemTienTXService")
    public void setDialogThemTienTx(IDialogThemThuocTinhChuyenHang dialogThemTienTx) {
        this.dialogThemTienTx = dialogThemTienTx;
    }

    @Autowired
    @Qualifier("DialogThemGiaCuocService")
    public void setDialogThemGiaCuoc(IDialogThemThuocTinhChuyenHang dialogThemGiaCuoc) {
        this.dialogThemGiaCuoc = dialogThemGiaCuoc;
    }

    @Autowired
    @Qualifier("DialogThemLoaiCVService")
    public void setDialogThemLoaiCV(IDialogThemThuocTinhChuyenHang dialogThemLoaiCV) {
        this.dialogThemLoaiCV = dialogThemLoaiCV;
    }

    public void TaoCotThemTienTx(TableColumn<ChuyenHang, Boolean> cotThemTienTx, ChuHang chuHang){

        Callback<TableColumn<ChuyenHang, Boolean>, TableCell<ChuyenHang, Boolean>> CellXemFactory
                = (TableColumn<ChuyenHang, Boolean> param) ->
                new ButtonCellThemGiaTriChuyenHang("Thêm Tiền TX",chuHang,dialogThemTienTx);

        cotThemTienTx.setCellFactory(CellXemFactory);
        //cotThemTienTx.f
    }

    public void TaoCotThemGiaCuoc(TableColumn<ChuyenHang, Boolean> cotThemTienTx, ChuHang chuHang){

        Callback<TableColumn<ChuyenHang, Boolean>, TableCell<ChuyenHang, Boolean>> CellXemFactory
                = (TableColumn<ChuyenHang, Boolean> param) ->
                new ButtonCellThemGiaTriChuyenHang("Thêm Tiền Giá Cước",chuHang,dialogThemGiaCuoc);

        cotThemTienTx.setCellFactory(CellXemFactory);
    }

    public void TaoCotThemLoaiCV(TableColumn<ChuyenHang, Boolean> cotThemTienTx, ChuHang chuHang){

        Callback<TableColumn<ChuyenHang, Boolean>, TableCell<ChuyenHang, Boolean>> CellXemFactory
                = (TableColumn<ChuyenHang, Boolean> param) ->
                new ButtonCellThemGiaTriChuyenHang("Thêm Loại Công Việc",chuHang,dialogThemLoaiCV);

        cotThemTienTx.setCellFactory(CellXemFactory);
    }

    public class ButtonCellThemGiaTriChuyenHang extends TableCell<ChuyenHang, Boolean> {

        private Button button;

        public ButtonCellThemGiaTriChuyenHang(String tenButton,ChuHang chuHang,
                                              IDialogThemThuocTinhChuyenHang themThuocTinhChuyenHang) {
            // TODO Auto-generated constructor stub
            button = new Button(tenButton);
            button.setOnMousePressed(new EventHandler<MouseEvent>() {


                @Override
                public void handle(MouseEvent mouseEvent) {

                    ChuyenHang chuyenHang = getTableRow().getItem();
                    themThuocTinhChuyenHang.ShowDialog(chuyenHang);


                }
            });
        }
        /** places an add button in the row only if the row is not empty. */
        @Override protected void updateItem(Boolean item, boolean empty) {
            super.updateItem(item, empty);
            if (!empty) {
                setContentDisplay(ContentDisplay.GRAPHIC_ONLY);
                setGraphic(button);
            } else {
                setGraphic(null);
            }
        }
    }
}
