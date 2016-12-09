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
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.Inventory.Dessert;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TablePosition;
import model.Bakery;
import model.Sales.Cashier;
import model.Sales.Sale;
import view.TableElementsMaker;

/**
 * FXML Controller class
 *
 * @author Gerry
 */
public class SellProductsController implements Initializable {
    private Stage nStage;
    @FXML
    private Button btnAceptar;
    @FXML
    private Button btnCancelar;
    
    private ArrayList<Dessert> dessertList = new ArrayList<Dessert>();
    
    private ObservableList<Dessert> currentList;
    @FXML
    private TextField customerMoney;
    @FXML
    private TableColumn<Dessert, String> dessertName;
    @FXML
    private TableColumn<Dessert, String> dessertPrice;
    @FXML
    private TableView<Dessert> viewProductList;
    
    @FXML
    private Button btnViewProducts;
    private TableElementsMaker listMaker;
    
    private Cashier currentCashier;
    
    
    /**
     * Initializes the controller class.
     * @param currentCashier
     */
    
    public void setCurrentCashier(Cashier newCashier) {
        this.currentCashier = newCashier;
    }
    
    public void setStage(Stage stage){
        this.nStage = stage;
    }
    
    public void setBuyList(ArrayList list){
        this.dessertList = list;
    }
    
    
    //Referir a la documentación para aclarar abstracción de este método
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        listMaker = new TableElementsMaker(dessertList);
        updateTable();
        
    }
    
    public void updateTable(){
        listMaker.convertArrayToObservable(dessertList);
        currentList = listMaker.getCurrentList();
        listMaker.setCell(dessertName, "name");
        listMaker.setCell(dessertPrice, "price");
        viewProductList.setItems(currentList);
    }
    
    public void returnFromListWindow(Dessert newDessert, int productQuantity){
        for (int productNum = 0; productNum < productQuantity; productNum++) {
            Bakery.getInstance().getCashier().addDessertToBuyerList(dessertList, newDessert);
        }
        
        updateTable();
    }
    
    public Dessert getSelectedCellDessert(){
        TablePosition pos = viewProductList.getSelectionModel().getSelectedCells().get(0);
        if(pos == null){
            return null;
        }
        int row = pos.getRow();
 
        Dessert item = (Dessert) viewProductList.getItems().get(row);
        return item;
    }
    
    @FXML
    private void btnCancelarPress(ActionEvent event){
        try {
            goBack(event);
        } catch (IOException ex) {
            
            Logger.getLogger(SellProductsController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @FXML
    private void btnFinishSalePress(ActionEvent event) {
        Bakery.getInstance().getCashier().sellDesserts(dessertList, Double.valueOf(customerMoney.getText()));
        Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.setTitle("Venta completada.");
        alert.setContentText("La venta se ha completado.");
        alert.showAndWait();
        setBuyList(new ArrayList());
        updateTable();
    }

    @FXML
    private void goBack(ActionEvent event) throws IOException {
        nStage = (Stage) btnCancelar.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("/view/Start.fxml"));
        nStage.setTitle("Inicio");
        nStage.setScene(new Scene(root));
        nStage.show();
    }

    @FXML
    private void btnViewProductsPress(ActionEvent event) throws IOException {
        setStage((Stage)btnViewProducts.getScene().getWindow());
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/ProductList.fxml"));
        Parent root = loader.load();
        ListController controller = loader.getController();
        nStage.setTitle("Agregar producto");
        nStage.setScene(new Scene(root));
        nStage.show();
        controller.setCurrentCashier(currentCashier);
        controller.setBuyList(this.dessertList);
    }
    
}
