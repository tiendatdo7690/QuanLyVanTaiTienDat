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

@Service
public class ComboBoxService<E> {


    public void LoadCombo(ComboBox<E> comboBox_E,ObservableList<E> listE) {
        // TODO Auto-generated method stub

        ObservableList<E> listNoiDen = listE;

        System.out.println("Load CB");
        comboBox_E.setItems(listNoiDen);

        comboBox_E.setCellFactory(new Callback<ListView<E>, ListCell<E>>(){

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


        comboBox_E.getSelectionModel().selectFirst();
    }

    public void LoadComboNoSelectFirts(ComboBox<E> comboBox_E,List<E> listE) {
        // TODO Auto-generated method stub

        ObservableList<E> listNoiDen = FXCollections.observableArrayList(listE);

        comboBox_E.setItems(listNoiDen);

        comboBox_E.setCellFactory(new Callback<ListView<E>, ListCell<E>>(){

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

    public void LoadSetCombo(JFXComboBox<E> comboBox_E, Set<E> listE) {
        ObservableList<E> listNoiDen = FXCollections.observableArrayList(listE);

        comboBox_E.setItems(listNoiDen);

        comboBox_E.setCellFactory(new Callback<ListView<E>, ListCell<E>>(){

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

        comboBox_E.getSelectionModel().selectFirst();

    }
}
