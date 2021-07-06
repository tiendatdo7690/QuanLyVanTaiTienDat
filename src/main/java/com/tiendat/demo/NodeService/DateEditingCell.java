package com.tiendat.demo.NodeService;

import com.jfoenix.controls.JFXDatePicker;
import javafx.scene.control.TableCell;


import java.sql.Date;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

public class DateEditingCell<S, Date> extends TableCell<S, java.sql.Date> {
    private JFXDatePicker datePicker;
    DateEditingCell() {
    }

    @Override
    public void startEdit() {
        if (!isEmpty()) {
            super.startEdit();
            createDatePicker();
            setText(null);
            setGraphic(datePicker);
        }
    }

    @Override
    public void cancelEdit() {
        super.cancelEdit();

        setText(getDate().toString());
        setGraphic(null);
    }

    @Override
    public void updateItem(java.sql.Date item, boolean empty) {
        super.updateItem(item, empty);

        if (empty) {
            setText(null);
            setGraphic(null);
        } else {
            if (isEditing()) {
                if (datePicker != null) {
                    datePicker.setValue(getDate().toLocalDate());
                }
                setText(null);
                setGraphic(datePicker);
            } else {
                setText(getDate().toString());
                setGraphic(null);
            }
        }
    }

    private void createDatePicker() {
        datePicker = new JFXDatePicker(getDate().toLocalDate());
        //datePicker.setMinWidth(this.getWidth() - this.getGraphicTextGap() * 2);
        datePicker.setOnAction((e) -> {
            System.out.println("Committed: " + datePicker.getValue().toString());
            commitEdit(java.sql.Date.valueOf(datePicker.getValue()));
        });
    }

    private java.sql.Date getDate() {
        return getItem() == null ? java.sql.Date.valueOf(LocalDate.now())
                : getItem();
    }
}
