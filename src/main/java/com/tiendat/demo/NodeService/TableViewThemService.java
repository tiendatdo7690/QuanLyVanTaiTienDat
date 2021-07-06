package com.tiendat.demo.NodeService;

import javafx.collections.ObservableList;
import javafx.event.EventHandler;

import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.util.Callback;
import org.springframework.stereotype.Service;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class TableViewThemService<E,C> {

    private TableView<E> tableView;

    public TableViewThemService() {
    }


    public TableView<E> getTableView() {
        return tableView;
    }

    public void setTableView(TableView<E> tableView) {
        this.tableView = tableView;
    }

    public void TaoCotXoa(ObservableList<E> items,ObservableList<C> dsEComboBox){

        TableColumn<E, Boolean> cotXoa = new TableColumn<E,Boolean>("Xóa");

        Callback<TableColumn<E, Boolean>, TableCell<E, Boolean>> CellXemFactory
                = (TableColumn<E, Boolean> param) -> new ButtonCellXoa(items,dsEComboBox);

        cotXoa.setCellFactory(CellXemFactory);

        tableView.getColumns().add(cotXoa);

    }

    public class ButtonCellXoa extends TableCell<E, Boolean> {

        private Button button = new Button("Xóa");

        public ButtonCellXoa(ObservableList<E> items,ObservableList<C> dsEComboBox) {
            // TODO Auto-generated constructor stub
            button.setOnMousePressed(new EventHandler<MouseEvent>() {


                @Override
                public void handle(MouseEvent mouseEvent) {

                    System.out.println("Xóa");
                    E e = getTableRow().getItem();
                    items.remove(e);

                    C c;
                    try {
                        Method getMethod = e.getClass().getMethod("getE", new Class[] {});
                        c = (C) getMethod.invoke(e, new Object[] {});
                        dsEComboBox.add(c);
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
                setGraphic(button);
            } else {
                setGraphic(null);
            }
        }
    }
}
