/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TablePosition;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import model.Bakery;
import model.Inventory.Dessert;
import model.Orders.Order;
import view.TableElementsMaker;

/**
 * FXML Controller class
 *
 * @author Alberto
 */
public class OrderListController implements Initializable {
    private Stage nStage;
    @FXML
    private TableColumn<Order, String> clientNameColumn;
    @FXML
    private TableColumn<Order, String> descColumn;
    @FXML
    private TableColumn<Order, String> phoneColumn;
    @FXML
    private TableColumn<Order, String> dateColumn;
    @FXML
    private TableColumn<Order, String> statusColumn;

    @FXML
    private Button btnChangeStatus;
    @FXML
    private Button btnReturn;
    @FXML
    private TableView<Order> orderList;
    private ObservableList<Order> currentList;

    public void setStage(Stage stage){
        this.nStage = stage;
    }
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        ArrayList list = getAllOrdersList();
        
        currentList = FXCollections.observableArrayList(list);
        clientNameColumn.setCellValueFactory(new PropertyValueFactory<Order, String>("customerName"));
        descColumn.setCellValueFactory(new PropertyValueFactory<Order, String>("description"));
        phoneColumn.setCellValueFactory(new PropertyValueFactory<Order, String>("telephone"));
        dateColumn.setCellValueFactory(new PropertyValueFactory<Order, String>("dueDate"));
        statusColumn.setCellValueFactory(new PropertyValueFactory<Order, String>("deliveryStatus"));
        orderList.setItems(currentList);
    }    



    @FXML
    private void btnChangeStatusPress(ActionEvent event) {
        Order orderToChange = getSelectedCellOrder();
        Bakery.getInstance().getOrderManager().markOrderAsDone(orderToChange);
    }

    @FXML
    private void btnReturnPress(ActionEvent event) throws IOException {
        nStage = (Stage)btnReturn.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader();
        Parent root = loader.load(getClass().getResource("/view/Start.fxml"));
        nStage.setTitle("Inicio");
        nStage.setScene(new Scene(root));
        nStage.show();
    }

    private ArrayList getAllOrdersList() {
        return Bakery.getInstance().getOrderManager().searchOrdersUndelivered(); //To change body of generated methods, choose Tools | Templates.
    }
    
    public Order getSelectedCellOrder(){
        TablePosition pos = orderList.getSelectionModel().getSelectedCells().get(0);
        if(pos == null){
            return null;
        }
        int row = pos.getRow();
 
        Order item = (Order) orderList.getItems().get(row);
        /*
        TableColumn col = pos.getTableColumn();
        String data = (String) col.getCellObservableValue(item).getValue();
        return data;
        
        */
        return item;
    }
    
}
