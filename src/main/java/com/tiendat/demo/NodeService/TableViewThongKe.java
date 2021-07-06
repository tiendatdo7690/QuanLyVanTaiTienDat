package com.tiendat.demo.NodeService;

import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class TableViewThongKe<E> {
    private TableView<E> tableView;

    public TableViewThongKe() {
        this.tableView = new TableView<>();
    }

    public TableView<E> getTableView() {
        return tableView;
    }

    public void setTableView(TableView<E> tableView) {
        this.tableView = tableView;
    }

    public <T> void TaoCot(String tenTruong, String tenCot, T loaiDuKieu){

        TableColumn<E,T> cot;
        cot = new TableColumn<E,T>(tenCot);
        cot.setCellValueFactory(new PropertyValueFactory<E,T>(tenTruong));
        tableView.getColumns().add(cot);

    }
}
