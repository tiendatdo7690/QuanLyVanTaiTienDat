package com.tiendat.demo.NodeService;

import javafx.event.EventHandler;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.util.Callback;
import org.springframework.stereotype.Service;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

@Service
public class TableViewService<E,C> {

    private E e;
    private TableView<E> tableView;
    private C controller;

    public TableViewService() {
        this.tableView = new TableView<E>();
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

    public void TaoCotXemThongTin(){

        TableColumn<E, Boolean> cotXemThongTin = new TableColumn<E,Boolean>("Xem Thông Tin");
        Callback<TableColumn<E, Boolean>, TableCell<E, Boolean>> CellXemFactory
                = (TableColumn<E, Boolean> param) -> new ButtonCellXem();

        cotXemThongTin.setCellFactory(CellXemFactory);

        tableView.getColumns().add(cotXemThongTin);

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

                    E e = getTableRow().getItem();
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
}
