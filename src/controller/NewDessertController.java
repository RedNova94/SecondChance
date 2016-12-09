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
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.Bakery;
import model.Inventory.Dessert;

/**
 * FXML Controller class
 *
 * @author Alberto
 */
public class NewDessertController implements Initializable {

    @FXML
    private TextField nameField;
    @FXML
    private TextArea descField;
    @FXML
    private TextField priceField;
    @FXML
    private TextField costField;
    @FXML
    private Button btnAccept;
    @FXML
    private Button btnCancel;

    private Stage nStage;
    
    public void setStage(Stage newStage){
        this.nStage = newStage;
    }
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void btnAcceptPress(ActionEvent event) throws IOException {
        String dessertName = nameField.getText();
        String dessertDesc = descField.getText();
        double dessertPrice = Double.parseDouble(priceField.getText());
        double dessertCost = Double.parseDouble(costField.getText());
        
        Bakery.getInstance().getBakeryOwner().createNewDessert(dessertName, 
                dessertDesc, dessertPrice, dessertCost);
        
        Stage nextStage = (Stage) btnAccept.getScene().getWindow();
        Alert confirmAlert = new Alert(AlertType.CONFIRMATION);
        confirmAlert.setTitle("Producto agregado.");
        confirmAlert.setContentText("El producto se agregó al inventario satisfactoriamente.");
        goBack(nextStage);
    }

    @FXML
    private void btnCancelPress(ActionEvent event) throws IOException {
        Stage nextStage = (Stage) btnCancel.getScene().getWindow();
        goBack(nextStage);
    }
    
    private void goBack(Stage nextStage) throws IOException{
        nStage = nextStage;
        FXMLLoader loader = new FXMLLoader();
        Parent root = loader.load(getClass().getResource("/view/Inventory.fxml"));
        nStage.setTitle("Inventario");
        nStage.setScene(new Scene(root));
        nStage.show();
    }
    
}
