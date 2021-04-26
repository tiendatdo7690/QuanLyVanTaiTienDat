package com.tiendat.demo.Controller.Configure;

import com.tiendat.demo.DialogService.DialogImplement.DialogThemGiaCuocImplement;
import com.tiendat.demo.DialogService.DialogImplement.DialogThemLoaiCVImplement;
import com.tiendat.demo.DialogService.DialogImplement.DialogThemTienTxImplement;
import com.tiendat.demo.DialogService.DialogInterfce.IDialogThemThuocTinhChuyenHang;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DialogChuyenHangFactory {

    @Bean
    public IDialogThemThuocTinhChuyenHang DialogThemTienTXService(){

        return new DialogThemTienTxImplement();
    }

    @Bean
    public IDialogThemThuocTinhChuyenHang DialogThemGiaCuocService(){

        return new DialogThemGiaCuocImplement();
    }

    @Bean
    public IDialogThemThuocTinhChuyenHang DialogThemLoaiCVService(){

        return new DialogThemLoaiCVImplement();
    }
}
