/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import model.Bakery;
import model.Orders.OrderManager;

/**
 * FXML Controller class
 *
 * @author Gerry
 */
public class StartController implements Initializable {
    private Stage nStage;
    @FXML
    private Button btnTramsactopm;
    @FXML
    private Button btnInventory;
    @FXML
    private Button btnReport;
    
    private Bakery currentBakery;
    @FXML
    private Button btnOrderList;
    
    public void setCurrentBakery(Bakery newBakery){
        this.currentBakery = newBakery;
    }
    
    public void setStage(Stage stage){
        this.nStage = stage;
    }
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
    }    

    @FXML
    private void goTransactionWindow(ActionEvent event) throws IOException {
        
        nStage = (Stage) btnTramsactopm.getScene().getWindow();
        //FXMLLoader loader = new FXMLLoader();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/SellProducts.fxml"));
        Parent root = loader.load();
        //SellProductsController saleController = loader.getController();
        //saleController.setStage(nStage);
        SellProductsController controller = loader.getController();
        nStage.setTitle("Ventas");
        nStage.setScene(new Scene(root));
        nStage.show();
        controller.setCurrentCashier(Bakery.getInstance().getCashier());
        //((SellProductsController)loader.getController()).setCurrentCashier(currentBakery.getCashier());
    }

    @FXML
    private void goInventoryWindow(ActionEvent event) {
    }

    @FXML
    private void goReportWindow(ActionEvent event) {
    }
    
    @FXML
    private void btnNewOrderPress(ActionEvent event) throws IOException{
        nStage = (Stage) btnTramsactopm.getScene().getWindow();
        //FXMLLoader loader = new FXMLLoader();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/NewOrderView.fxml"));
        Parent root = loader.load();
        
        //SellProductsController saleController = loader.getController();
        //saleController.setStage(nStage);
        
        nStage.setTitle("Pedidos");
        nStage.setScene(new Scene(root));
        
        NewOrderController controller = loader.getController();
        nStage.show();
        controller.setOrderManager(Bakery.getInstance().getOrderManager());
        
        
    }
    @FXML
    private void btnOrderListPress() throws IOException{
        nStage = (Stage) btnTramsactopm.getScene().getWindow();

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/OrderList.fxml"));
        Parent root = loader.load();
 
        nStage.setTitle("Pedidos");
        nStage.setScene(new Scene(root));
        
        nStage.show();
    }
    
}
