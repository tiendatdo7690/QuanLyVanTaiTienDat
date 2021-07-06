package com.tiendat.demo.DialogService.DialogImplement;

import com.tiendat.demo.Controller.ControllerChuHang.ControllerThemTienTx;
import com.tiendat.demo.DialogService.DialogInterfce.IDialogThemThuocTinhChuyenHang;
import com.tiendat.demo.Model.ChuyenHang;
import com.tiendat.demo.NodeService.WindowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DialogThemTienTxImplement implements IDialogThemThuocTinhChuyenHang {

    @Autowired
    private WindowService windowService;

    @Autowired
    private ControllerThemTienTx controllerThemTienTx;

    @Override
    public void ShowDialog(ChuyenHang chuyenHang) {

        System.out.println("Them Tien TX");

        windowService.OpenNewWinDow("/fxml/ChuHang/ThemTienTX.fxml",
                "setChuyenHang", controllerThemTienTx, chuyenHang);
    }
}
