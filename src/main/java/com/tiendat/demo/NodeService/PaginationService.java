package com.tiendat.demo.NodeService;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Pagination;
import javafx.scene.control.TableView;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

public class PaginationService {

    private Pagination pagination;

    public PaginationService() {

    }

    public Pagination getPagination() {
        return pagination;
    }

    public void setPagination(Pagination pagination) {
        this.pagination = pagination;
    }


    public void taiDSPagination(List list, TableView tableview, int sopt) {

        int maxPage = list.size()/sopt +1;
        pagination.setPageCount(maxPage);
        pagination.setMaxPageIndicatorCount(maxPage);


        pagination.setPageFactory(pageIndeX ->{


            int fromIndex = pageIndeX * sopt ;
            int toIndex = Math.min(fromIndex + sopt, list.size());
            tableview.setItems(FXCollections.observableArrayList(list.subList(fromIndex, toIndex)));

            return tableview;

        });
    }

    public void taiDSPagination(ObservableList list, TableView tableview, int sopt) {

        int maxPage = list.size()/sopt +1;
        pagination.setPageCount(maxPage);
        pagination.setMaxPageIndicatorCount(maxPage);


        pagination.setPageFactory(pageIndeX ->{

            int fromIndex = pageIndeX * sopt ;
            int toIndex = Math.min(fromIndex + sopt, list.size());
            tableview.setItems(FXCollections.observableArrayList(list.subList(fromIndex, toIndex)));

            return tableview;

        });
    }
}
