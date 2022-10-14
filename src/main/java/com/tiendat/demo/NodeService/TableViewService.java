package com.tiendat.demo.NodeService;

import com.tiendat.demo.Model.LoaiChiHo;
import javafx.event.EventHandler;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.input.MouseEvent;
import javafx.util.Callback;
import javafx.util.StringConverter;
import javafx.util.converter.DoubleStringConverter;
import javafx.util.converter.IntegerStringConverter;
import javafx.util.converter.LongStringConverter;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.Date;

public class TableViewService<E,C> {

    private E e;
    private TableView<E> tableView;
    private C controller;

    public TableViewService() {
        this.tableView = new TableView<E>();
        this.tableView.setEditable(true);
    }

    public TableView<E> getTableView() {
        return tableView;
    }

    public void setTableView(TableView<E> tableView) {
        this.tableView = tableView;
    }

    public C getController() {
        return controller;
    }

    public void setController(C controller) {
        this.controller = controller;
    }

    public <T> void TaoCot(String tenTruong, String tenCot, T loaiDuKieu){

        TableColumn<E,T> cot;
        cot = new TableColumn<E,T>(tenCot);
        cot.setCellValueFactory(new PropertyValueFactory<E,T>(tenTruong));
        tableView.getColumns().add(cot);

    }
    public void TaoCotEditString(String tenTruong, String tenCot){

        TableColumn<E,String> cot;
        cot = new TableColumn<E,String>(tenCot);
        cot.setCellValueFactory(new PropertyValueFactory<E,String>(tenTruong));
        cot.setCellFactory(TextFieldTableCell.forTableColumn());
        cot.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<E, String>>() {
                                               @Override
                                               public void handle(TableColumn.CellEditEvent<E, String> t) {
                                                   E e = t.getTableView().getSelectionModel().getSelectedItem();

                                                   try {
                                                       Method getMethod = controller.getClass().getMethod("UpdateString",
                                                               new Class[] {e.getClass(),String.class});
                                                       getMethod.invoke(controller, new Object[] {e,t.getNewValue()});
                                                   } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException noSuchMethodException) {
                                                       noSuchMethodException.printStackTrace();
                                                   }
                                               }
                                           }
        );
        tableView.getColumns().add(cot);

    }
    public void TaoCotEditDouble(String tenTruong, String tenCot){

        TableColumn<E,Double> cot;
        cot = new TableColumn<E,Double>(tenCot);
        cot.setCellValueFactory(new PropertyValueFactory<E,Double>(tenTruong));
        cot.setCellFactory(TextFieldTableCell.forTableColumn(new DoubleStringConverter()));
        cot.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<E, Double>>() {
                                @Override
                                public void handle(TableColumn.CellEditEvent<E, Double> t) {
                                    E e = t.getTableView().getSelectionModel().getSelectedItem();

                                    try {
                                        Method getMethod = controller.getClass().getMethod("UpdateDouble",
                                                new Class[] {e.getClass(),Double.class});
                                        getMethod.invoke(controller, new Object[] {e,t.getNewValue()});
                                    } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException noSuchMethodException) {
                                        noSuchMethodException.printStackTrace();
                                    }
                                }
                            }
        );
        tableView.getColumns().add(cot);

    }
    public void TaoCotEditInteger(String tenTruong, String tenCot){

        TableColumn<E,Integer> cot;
        cot = new TableColumn<E,Integer>(tenCot);
        cot.setCellValueFactory(new PropertyValueFactory<E,Integer>(tenTruong));
        cot.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
        cot.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<E, Integer>>() {
                                @Override
                                public void handle(TableColumn.CellEditEvent<E, Integer> t) {
                                    E e = t.getTableView().getSelectionModel().getSelectedItem();

                                    try {
                                        Method getMethod = controller.getClass().getMethod("UpdateInteger",
                                                new Class[] {e.getClass(),Integer.class});
                                        getMethod.invoke(controller, new Object[] {e,t.getNewValue()});
                                    } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException noSuchMethodException) {
                                        noSuchMethodException.printStackTrace();
                                    }
                                }
                            }
        );
        tableView.getColumns().add(cot);

    }

    public void TaoCotEditLong(String tenTruong, String tenCot){

        TableColumn<E,Long> cot;
        cot = new TableColumn<E,Long>(tenCot);
        cot.setCellValueFactory(new PropertyValueFactory<E,Long>(tenTruong));
        cot.setCellFactory(TextFieldTableCell.forTableColumn(new LongStringConverter()));
        cot.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<E, Long>>() {
                                @Override
                                public void handle(TableColumn.CellEditEvent<E, Long> t) {
                                    E e = t.getTableView().getSelectionModel().getSelectedItem();

                                    try {
                                        Method getMethod = controller.getClass().getMethod("UpdateLong",
                                                new Class[] {e.getClass(),Long.class});
                                        getMethod.invoke(controller, new Object[] {e,t.getNewValue()});
                                    } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException noSuchMethodException) {
                                        noSuchMethodException.printStackTrace();
                                    }
                                }
                            }
        );
        tableView.getColumns().add(cot);

    }

    public void TaoCotEditDate(String tenTruong, String tenCot){

        TableColumn<E, java.sql.Date> cot;
        cot = new TableColumn<E, java.sql.Date>(tenCot);
        cot.setCellValueFactory(new PropertyValueFactory<E, java.sql.Date>(tenTruong));
        Callback<TableColumn<E, java.sql.Date>, TableCell<E, java.sql.Date>> crcDateCellFactory = (
                TableColumn<E, java.sql.Date> param) -> new DateEditingCell();

        cot.setCellFactory(crcDateCellFactory);
        cot.setOnEditCommit((TableColumn.CellEditEvent<E, java.sql.Date> t) -> {
            E e = t.getTableView().getSelectionModel().getSelectedItem();

            try {
                Method getMethod = controller.getClass().getMethod("UpdateDate",
                        new Class[] {e.getClass(),java.sql.Date.class});
                getMethod.invoke(controller, new Object[] {e,t.getNewValue()});
            } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException noSuchMethodException) {
                noSuchMethodException.printStackTrace();
            }
        });
        tableView.getColumns().add(cot);

    }

    public void TaoCotXemThongTin(){

        TableColumn<E, Boolean> cotXemThongTin = new TableColumn<E,Boolean>("Xem Thông Tin");

        Callback<TableColumn<E, Boolean>, TableCell<E, Boolean>> CellXemFactory
                = (TableColumn<E, Boolean> param) -> new ButtonCellXem();

        cotXemThongTin.setCellFactory(CellXemFactory);

        tableView.getColumns().add(cotXemThongTin);

    }

    public void TaoCotXoa(){

        TableColumn<E, Boolean> cotXoa = new TableColumn<E,Boolean>("Xóa");

        Callback<TableColumn<E, Boolean>, TableCell<E, Boolean>> CellXemFactory
                = (TableColumn<E, Boolean> param) -> new ButtonCellXoa();

        cotXoa.setCellFactory(CellXemFactory);

        tableView.getColumns().add(cotXoa);

    }

    public void TaoCotXoaDatabase(){

        TableColumn<E, Boolean> cotXoa = new TableColumn<E,Boolean>("Xóa");

        Callback<TableColumn<E, Boolean>, TableCell<E, Boolean>> CellXemFactory
                = (TableColumn<E, Boolean> param) -> new ButtonCellXoaDatabase();

        cotXoa.setCellFactory(CellXemFactory);

        tableView.getColumns().add(cotXoa);

    }

    public E getE() {
        return e;
    }

    public void setE(E e) {
        this.e = e;
    }

    public class ButtonCellXem extends TableCell<E, Boolean> {

        private javafx.scene.control.Button Button = new Button("Xem");

        public ButtonCellXem() {
            // TODO Auto-generated constructor stub
            Button.setOnMousePressed(new EventHandler<MouseEvent>() {


                @Override
                public void handle(MouseEvent mouseEvent) {

                    E e = (E) getTableRow().getItem();
                    try {
                        Method getMethod = controller.getClass().getMethod("GanGiaTri", new Class[] {e.getClass()});
                        getMethod.invoke(controller, new Object[] {e});
                    } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException noSuchMethodException) {
                        noSuchMethodException.printStackTrace();
                    }
                }
            });
        }
        /** places an add button in the row only if the row is not empty. */
        @Override protected void updateItem(Boolean item, boolean empty) {
            super.updateItem(item, empty);
            if (!empty) {
                setContentDisplay(ContentDisplay.GRAPHIC_ONLY);
                setGraphic(Button);
            } else {
                setGraphic(null);
            }
        }
    }

    public class ButtonCellXoa extends TableCell<E, Boolean> {

        private javafx.scene.control.Button Button = new Button("Xóa");

        public ButtonCellXoa() {
            // TODO Auto-generated constructor stub
            Button.setOnMousePressed(new EventHandler<MouseEvent>() {


                @Override
                public void handle(MouseEvent mouseEvent) {

                    System.out.println("Xóa");
                    E e = (E) getTableRow().getItem();
                    getTableView().getItems().remove(e);
                }
            });
        }
        /** places an add button in the row only if the row is not empty. */
        @Override protected void updateItem(Boolean item, boolean empty) {
            super.updateItem(item, empty);
            if (!empty) {
                setContentDisplay(ContentDisplay.GRAPHIC_ONLY);
                setGraphic(Button);
            } else {
                setGraphic(null);
            }
        }
    }

    public class ButtonCellXoaDatabase extends TableCell<E, Boolean> {

        private javafx.scene.control.Button Button = new Button("Xóa");

        public ButtonCellXoaDatabase() {
            // TODO Auto-generated constructor stub
            Button.setOnMousePressed(new EventHandler<MouseEvent>() {


                @Override
                public void handle(MouseEvent mouseEvent) {

                    E e = (E) getTableRow().getItem();
                    try {
                        Method getMethod = controller.getClass().getMethod("XoaDatabase", new Class[] {e.getClass()});
                        getMethod.invoke(controller, new Object[] {e});
                    } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException noSuchMethodException) {
                        noSuchMethodException.printStackTrace();
                    }
                }
            });
        }
        /** places an add button in the row only if the row is not empty. */
        @Override protected void updateItem(Boolean item, boolean empty) {
            super.updateItem(item, empty);
            if (!empty) {
                setContentDisplay(ContentDisplay.GRAPHIC_ONLY);
                setGraphic(Button);
            } else {
                setGraphic(null);
            }
        }
    }
}
