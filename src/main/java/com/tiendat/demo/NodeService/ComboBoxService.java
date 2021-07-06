package com.tiendat.demo.NodeService;

import com.jfoenix.controls.JFXComboBox;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.util.Callback;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

public class ComboBoxService<E> {

    private JFXComboBox<E> comboBox;

    public JFXComboBox<E> getComboBox() {
        return comboBox;
    }

    public void setComboBox(JFXComboBox<E> comboBox) {
        this.comboBox = comboBox;
    }

    public void LoadCombo(ObservableList<E> listE) {
        // TODO Auto-generated method stub

        ObservableList<E> listNoiDen = listE;

        comboBox.setItems(listNoiDen);

        comboBox.setCellFactory(new Callback<ListView<E>, ListCell<E>>(){

            @Override
            public ListCell<E> call(ListView<E> p) {

                final ListCell<E> cell = new ListCell<E>(){

                    @Override
                    protected void updateItem(E t, boolean bln) {
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

    public void LoadComboNoSelectFirts(ObservableList<E> listE) {
        // TODO Auto-generated method stub

        comboBox.setItems(listE);

        comboBox.setCellFactory(new Callback<ListView<E>, ListCell<E>>(){

            @Override
            public ListCell<E> call(ListView<E> p) {

                final ListCell<E> cell = new ListCell<E>(){

                    @Override
                    protected void updateItem(E t, boolean bln) {
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

    public void LoadSetCombo(Set<E> listE) {
        ObservableList<E> listNoiDen = FXCollections.observableArrayList(listE);

        comboBox.setItems(listNoiDen);

        comboBox.setCellFactory(new Callback<ListView<E>, ListCell<E>>(){

            @Override
            public ListCell<E> call(ListView<E> p) {

                final ListCell<E> cell = new ListCell<E>(){

                    @Override
                    protected void updateItem(E t, boolean bln) {
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
}
