package com.tiendat.demo.NodeService;

import com.jfoenix.controls.JFXComboBox;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.util.Callback;

import java.util.List;

public class ComboBoxObjectService {

    public ComboBoxObjectService() {
    }

    public void LoadCombo(List<Object> listE, JFXComboBox<Object> comboBox) {
        // TODO Auto-generated method stub

        ObservableList<Object> listNoiDen = FXCollections.observableArrayList(listE);

        comboBox.setItems(listNoiDen);

        comboBox.setCellFactory(new Callback<ListView<Object>, ListCell<Object>>(){

            @Override
            public ListCell<Object> call(ListView<Object> p) {

                final ListCell<Object> cell = new ListCell<Object>(){

                    @Override
                    protected void updateItem(Object t, boolean bln) {
                        super.updateItem(t, bln);

                        if(t != null){
                            setText(t.toString());
                        }else{
                            setText(null);
                        }
                    }

                };

                return cell;
            }
        });


        comboBox.getSelectionModel().selectFirst();
    }

    public void LoadComboObservableList(ObservableList<Object> listE, JFXComboBox<Object> comboBox) {
        // TODO Auto-generated method stub

        ObservableList<Object> listNoiDen = listE;

        comboBox.setItems(listNoiDen);

        comboBox.setCellFactory(new Callback<ListView<Object>, ListCell<Object>>(){

            @Override
            public ListCell<Object> call(ListView<Object> p) {

                final ListCell<Object> cell = new ListCell<Object>(){

                    @Override
                    protected void updateItem(Object t, boolean bln) {
                        super.updateItem(t, bln);

                        if(t != null){
                            setText(t.toString());
                        }else{
                            setText(null);
                        }
                    }

                };

                return cell;
            }
        });
    }
}
