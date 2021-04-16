package com.tiendat.demo.ThongBao;


import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import javafx.scene.control.Spinner;

import java.util.List;

public final class LoiChuongTrinh {

    public static boolean textFieldNull(JFXTextField textField) {

        String idTextField = textField.getId();
        boolean kiemtra = textField.getText().isEmpty();

        if(kiemtra) {
            System.out.println(textField.getId() +": NULL");
            ThongBao.showThongBaoLoiTextNull(idTextField);
            return kiemtra;
        }
        return kiemtra;
    }

    public static boolean listTextFielNull(List<JFXTextField> jfxTextFields){

        for(JFXTextField textField : jfxTextFields){
            boolean kiemtra = textFieldNull(textField);
            if (kiemtra)
                return kiemtra;
        }
        return false;
    }
    public static boolean textFieldSo(JFXTextField textField) {

		String regex = "[0-9]*";

		String text = textField.getText();

		 if (!text.matches(regex)) {
			 ThongBao.showThongBaoLoiTextSo(textField.getId());
             return true;
         }
		return false;
    }

    public static boolean spinnerSo(Spinner<Integer> spinner) {

        String regex = "[0-9]";

        String text = String.valueOf(spinner.getValue());

        if ( !text.matches(regex)  ) {
            ThongBao.showThongBaoLoiTextSo(spinner.getId());
            return true;
        }
        return false;
    }

    public static boolean textAreaNull(JFXTextArea textField) {

        String idTextField = textField.getId();
        boolean kiemtra = textField.getText().isEmpty();

        if(kiemtra) {
            System.out.println(textField.getId() +": NULL");
            ThongBao.showThongBaoLoiTextNull(idTextField);
            return kiemtra;
        }
        return kiemtra;
    }

    public static boolean datePickerNull(JFXDatePicker datePicker) {

        String idTextField = datePicker.getId();
        boolean kiemtra = datePicker.getValue() == null ? true : false;

        if(kiemtra) {
            System.out.println(datePicker.getId() +": NULL");
            ThongBao.showThongBaoLoiTextNull(idTextField);
            return kiemtra;
        }
        return kiemtra;
    }

    public static boolean loiChonNgaySai(JFXDatePicker tungay, JFXDatePicker denngay) {

        boolean kiemtra = tungay.getValue().isAfter(denngay.getValue());
        //boolean kiemtrabang = tungay.getValue().equals(denngay.getValue());
        if(kiemtra) {
            System.out.println("Chọn Ngày Sai");
            ThongBao.showThongBaoLoiTextSo("Nhập Sai Ngày");
            return kiemtra;
        }
        return kiemtra;
    }

    public static boolean ComboBoxNull(JFXComboBox<?> combo_KhachHang) {
        // TODO Auto-generated method stub
        String idTextField = combo_KhachHang.getId();
        boolean kiemtra = combo_KhachHang.getValue() == null ? true : false;
        if(kiemtra) {
            System.out.println(combo_KhachHang.getId() +": NULL");
            ThongBao.showThongBaoLoiTextNull(idTextField);
            return kiemtra;
        }
        return kiemtra;
    }

}
