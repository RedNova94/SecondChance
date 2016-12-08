/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.util.ArrayList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;
import model.Inventory.Dessert;

/**
 *
 * @author Niamki
 */
public class TableElementsMaker {
    
    private ObservableList currentList;
    
    public TableElementsMaker(ArrayList list){
        createObservableFromList(list);
    }

    public void setCurrentList(ObservableList currentList) {
        this.currentList = currentList;
    }
    
    public void convertArrayToObservable(ArrayList list){
        createObservableFromList(list);
    }
    
    public void createObservableFromList(ArrayList list){
        this.currentList = FXCollections.observableList(list);
    }

    public ObservableList getCurrentList() {
        return currentList;
    }
    
    
    
    public void setCell(TableColumn column, String columnName){
        //TableColumn column = new TableColumn();
        column.setCellValueFactory(new PropertyValueFactory<Dessert, String>(columnName));
        
    }
}
