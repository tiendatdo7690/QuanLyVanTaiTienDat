package com.tiendat.demo.DialogService.DialogImplement;

import com.tiendat.demo.Controller.ControllerChuHang.ControllerThemGiaCuoc;
import com.tiendat.demo.Controller.ControllerChuHang.ControllerThemLoaiCV;
import com.tiendat.demo.DialogService.DialogInterfce.IDialogThemThuocTinhChuyenHang;
import com.tiendat.demo.Model.ChuHang;
import com.tiendat.demo.Model.ChuyenHang;
import com.tiendat.demo.NodeService.WindowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DialogThemLoaiCVImplement implements IDialogThemThuocTinhChuyenHang {

    @Autowired
    private WindowService windowService;

    @Autowired
    private ControllerThemLoaiCV controllerThemLoaiCV;

    @Override
    public void ShowDialog(ChuyenHang chuyenHang) {

        System.out.println("Them Loai CV");

        windowService.OpenNewWinDow("/fxml/ChuHang/ThemLoaiCV.fxml",
                "setChuyenHang", controllerThemLoaiCV, chuyenHang);
    }
}
