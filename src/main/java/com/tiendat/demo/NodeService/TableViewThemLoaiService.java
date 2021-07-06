package com.tiendat.demo.NodeService;

import javafx.scene.control.TableView;

public class TableViewThemLoaiService<E> {

    private TableView<E> tableView;

    public TableViewThemLoaiService() {
    }


    public TableView<E> getTableView() {
        return tableView;
    }

    public void setTableView(TableView<E> tableView) {
        this.tableView = tableView;
    }
}
