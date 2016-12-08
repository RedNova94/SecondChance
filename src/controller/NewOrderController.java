/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.net.URL;
import java.util.Calendar;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.Inventory.Dessert;
import model.Orders.OrderManager;


/**
 *
 * @author Niamki
 */
public class NewOrderController implements Initializable{
    private Stage nStage;
    
    @FXML
    private Button btnAccept;
    @FXML
    private Button btnCancel;
    @FXML
    private TextField nameField;
    @FXML
    private TextField phoneField;
    @FXML
    private TextArea descField;
    @FXML
    private DatePicker dueDatePicker;
    
    private OrderManager currentManager;
    
    private ObservableList<Dessert> currentList;
    
    public void setOrderManager(OrderManager newManager){
        this.currentManager = newManager;
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        dueDatePicker  = new DatePicker();

    }
    
    @FXML
    private void btnAcceptPress(ActionEvent event) throws IOException{
        Alert alert = new Alert(AlertType.INFORMATION);
        boolean missingData = nameField.getText() == null || 
                descField.getText() == null || phoneField.getText() == null ||
                dueDatePicker.getValue() == null;
        
            String clientName = nameField.getText();
            String description = descField.getText();
            String phoneNumber = phoneField.getText();
        
            Calendar dueDate = retrieveDateInput();
            currentManager.takeOrder(clientName, description, dueDate, phoneNumber);
        
            alert.setTitle("Orden registrada");
            
            alert.setContentText("La orden se ha registrado con los datos ingresados.");

            alert.showAndWait();
            goBack(event, (Stage)btnAccept.getScene().getWindow());
        
    }
    
    @FXML
    private void btnCancelPress(ActionEvent event) throws IOException{
        goBack(event, (Stage)btnCancel.getScene().getWindow());
    }
    
    @FXML
    private void goBack(ActionEvent event, Stage stage) throws IOException {
        nStage = stage;
        Parent root = FXMLLoader.load(getClass().getResource("/view/Start.fxml"));
        nStage.setTitle("Inicio");
        nStage.setScene(new Scene(root));
        nStage.show();
    }
    
    private Calendar retrieveDateInput(){
        int year = dueDatePicker.getValue().getYear();
        int month = dueDatePicker.getValue().getMonthValue();
        int dayOfMonth = dueDatePicker.getValue().getDayOfMonth();
        
        Calendar dueDate = Calendar.getInstance();
        dueDate.set(year, month, dayOfMonth);
        return dueDate;
    }
    
    
}
