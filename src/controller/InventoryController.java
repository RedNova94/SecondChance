/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TablePosition;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import model.Bakery;
import model.Inventory.Dessert;
import view.TableElementsMaker;

/**
 * FXML Controller class
 *
 * @author Alberto
 */
public class InventoryController implements Initializable {
    
    private TableView<Dessert> inventoryList;
    @FXML
    private TableColumn<?, ?> nameColumn;
    @FXML
    private TableColumn<?, ?> descColumn;
    @FXML
    private TableColumn<?, ?> priceColumn;
    @FXML
    private TableColumn<?, ?> costColumn;
    @FXML
    private TableColumn<?, ?> stockColumn;
    @FXML
    private Button btnAddProduct;
    @FXML
    private Button btnRemoveProduct;
    @FXML
    private Button btnAddStock;
    @FXML
    private Button btnReturn;
    
    private TableElementsMaker listMaker;
    
    private ObservableList<Dessert> currentList;
    @FXML
    private TextField productKeyField;
    @FXML
    private TextField quantityField;
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        listMaker = new TableElementsMaker(getAllProductsList());
        currentList = listMaker.getCurrentList();
        listMaker.setCell(nameColumn, "name");
        listMaker.setCell(descColumn, "description");
        listMaker.setCell(priceColumn, "price");
        listMaker.setCell(costColumn, "cost");
        listMaker.setCell(stockColumn, "stock");
        inventoryList.setItems(currentList);
    }

    private void updateTable(){
        listMaker = new TableElementsMaker(getAllProductsList());
        currentList = listMaker.getCurrentList();
        inventoryList.setItems(currentList);
    }

    @FXML
    private void btnAddProductPress(ActionEvent event) {
        
    }

    @FXML
    private void btnRemoveProductPress(ActionEvent event) {
        Bakery.getInstance().getBakeryOwner().removeDessertFromMenu(Integer.parseInt(productKeyField.getText()));
        updateTable();
    }
    
    @FXML
    private void btnAddStockPress(ActionEvent event) {
        Bakery.getInstance().getBaker().addStockToInventory(Integer.parseInt(productKeyField.getText()),
                Integer.parseInt(quantityField.getText()));
        updateTable();
    }
    
 


    @FXML
    private void btnReturn(ActionEvent event) {
        
    }
    
    private ArrayList getAllProductsList() {
        return Bakery.getInstance().getCashier().retrieveMenuWithStock(); //To change body of generated methods, choose Tools | Templates.
    }
}
