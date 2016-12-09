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
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.Bakery;
import model.Inventory.Dessert;
import model.Sales.Cashier;
import view.TableElementsMaker;

/**
 * FXML Controller class
 *
 * @author Gerry
 */
public class ListController implements Initializable {
    private Stage nStage;
    @FXML
    private TableView<Dessert> productList;
    @FXML
    private TableColumn<?, ?> nameColumn;
    @FXML
    private TableColumn<?, ?> descColumn;
    @FXML
    private TableColumn<?, ?> priceColumn;
    @FXML
    private TableColumn<?, ?> stockColumn;
    @FXML
    private TextField quantityTxt;
    @FXML
    private Button btnAccept;
    @FXML
    private Button btnCancel;
    
    private TableElementsMaker listMaker;
    
    private ObservableList<Dessert> currentList;
    
    private Cashier currentCashier;
    
    private ArrayList<Dessert> buyList;

    public void setCurrentCashier(Cashier currentCashier) {
        this.currentCashier = currentCashier;
    }

    public void setStage(Stage stage){
        this.nStage = stage;
    }
    
    public void setBuyList(ArrayList list){
        this.buyList = list;
    }
   
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
        listMaker.setCell(stockColumn, "stock");
        productList.setItems(currentList);
        
    }
    
    
    
    public Dessert getSelectedCellDessert(){
        TablePosition pos = productList.getSelectionModel().getSelectedCells().get(0);
        if(pos == null){
            return null;
        }
        int row = pos.getRow();
 
        Dessert item = (Dessert) productList.getItems().get(row);
        /*
        TableColumn col = pos.getTableColumn();
        String data = (String) col.getCellObservableValue(item).getValue();
        return data;
        
        */
        return item;
    }
    
    @FXML
    public void btnAcceptPress(ActionEvent evt) throws IOException{
        
        String userQuantityInput = quantityTxt.getText();
        int productQuantity = Integer.parseInt( userQuantityInput );
        
        Dessert dessertSelected = getSelectedCellDessert();
        
        Stage newStage = (Stage)btnAccept.getScene().getWindow();
        
        if(dessertSelected == null){
            goBack(newStage);
        }else{
            goBackAddingProduct( newStage, dessertSelected, productQuantity );
        }
    }

    public void goBack(Stage stage) throws IOException{
        nStage = stage;
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/SellProducts.fxml"));
        Parent root = loader.load();
        SellProductsController controller = loader.getController();
        nStage.setTitle("Ventas y pedidos");
        nStage.setScene(new Scene(root));
        nStage.show();
        
        controller.setBuyList(buyList);
        controller.updateTable();
        
    }
    
    public void goBackAddingProduct(Stage stage, Dessert newDessert, int productQuantity) throws IOException{
        Dessert product = newDessert;
        nStage = stage;
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/SellProducts.fxml"));
        Parent root = loader.load();
        SellProductsController controller = loader.getController();
        nStage.setTitle("Ventas y pedidos");
        nStage.setScene(new Scene(root));
        nStage.show();
        controller.setBuyList(buyList);
        controller.returnFromListWindow(product, productQuantity);
        
    }
    
    @FXML
    public void btnCancelPress(ActionEvent evt) throws IOException{
        goBack((Stage)btnCancel.getScene().getWindow());
    }

    private ArrayList<Dessert> getAllProductsList() {
        return Bakery.getInstance().getCashier().retrieveMenuWithStock(); //To change body of generated methods, choose Tools | Templates.
    }
    
}
