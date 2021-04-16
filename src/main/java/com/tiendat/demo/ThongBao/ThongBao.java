package com.tiendat.demo.ThongBao;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Control;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public final class ThongBao {

	public static void showThongBaoLoiTextNull(String idTextField) {
		
		 Alert alert = new Alert(AlertType.ERROR);
	     alert.setTitle("Text Field Null");
	     alert.setHeaderText(idTextField);
	     alert.setContentText("Dữ Liệu Bắt Buộc Phải Nhập!");
	 
	     alert.showAndWait();
	}
	public static void showThongBaoLoiDaCoChuyenHang(String idTextField) {

		Alert alert = new Alert(AlertType.ERROR);
		alert.setTitle("Công Việc Tài Xế Sai");
		alert.setHeaderText(idTextField);
		alert.setContentText("Nguyên Chuyến Hàng Không Được thêm vào chung với những Công Việc Khác!");

		alert.showAndWait();
	}

	public static void showThongBaoLoiCVThem2Lan(String idTextField) {

		Alert alert = new Alert(AlertType.ERROR);
		alert.setTitle("Công Việc Tài Xế Sai");
		alert.setHeaderText(idTextField);
		alert.setContentText("Công Việc THêm 2 Lần!");

		alert.showAndWait();
	}

	public static void showThongBaoLoiTextSo(String idTextField) {
		
		 Alert alert = new Alert(AlertType.ERROR);
	     alert.setTitle("Text Field Sai Dữ Liệu");
	     alert.setHeaderText(idTextField);
	     alert.setContentText("Dữ Liệu Nhập Bị Sai!");
	 
	     alert.showAndWait();
	}
	
	public static void showThongBaoThanhCong(String loaiDuLieu) {
		
		 Alert alert = new Alert(AlertType.INFORMATION);
	     alert.setTitle("Thêm Dữ Liệu");
	     alert.setHeaderText(loaiDuLieu);
	     alert.setContentText("Thêm Dữ Liệu Thành Công!!");
	 
	     alert.showAndWait();
	}
	
	public static String showThongBaoTuChoi() {
		
			Stage taoTaiKhoanNhanVienDialog = new Stage();
			taoTaiKhoanNhanVienDialog.resizableProperty().setValue(false);
			taoTaiKhoanNhanVienDialog.initStyle(StageStyle.UTILITY);
			taoTaiKhoanNhanVienDialog.initModality(Modality.APPLICATION_MODAL);

			VBox taoTK = new VBox();
			taoTK.setPrefWidth(Control.USE_COMPUTED_SIZE);
			taoTK.setPrefHeight(Control.USE_COMPUTED_SIZE);
			taoTK.setAlignment(Pos.TOP_CENTER);
			Label lb = new Label("Nội Dung Từ Chối");
			lb.setPrefWidth(150);
			JFXTextField text_noidung = new JFXTextField();
			text_noidung.setPrefWidth(300);
			
			HBox hbox = new HBox();
			hbox.setSpacing(10);
			hbox.getChildren().add(lb);
			hbox.getChildren().add(text_noidung);
			JFXButton button = new JFXButton("OK");
			button.setOnAction(new EventHandler<ActionEvent>() {
	            @Override
	            public void handle(ActionEvent event) {
	            	taoTaiKhoanNhanVienDialog.close();
	            }
	        });
			taoTK.getChildren().add(hbox);
			taoTK.getChildren().add(button);
			
			Scene scene = new Scene(taoTK,500,300);
			taoTaiKhoanNhanVienDialog.setScene(scene);
			taoTaiKhoanNhanVienDialog.showAndWait();
			
			return text_noidung.getText();
	}
	
}
