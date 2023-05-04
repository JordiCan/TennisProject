/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package javafxmlapplication;

import java.awt.Image;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.MenuItem;
import javax.swing.JPanel;

/**
 * FXML Controller class
 *
 * @author Alma
 */
public class MainStageController extends javax.swing.JFrame implements Initializable {

    @FXML
    private MenuItem signUpScene;
    @FXML
    private MenuItem registerScene;
    @FXML
    private MenuItem fieldsScene;
    
    FondoPanel fondo = new FondoPanel();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        this.setContentPane(fondo);
    }    

    @FXML
    private void changeToSignUp(ActionEvent event) {
    }

    @FXML
    private void changeToRegister(ActionEvent event) {
    }

    @FXML
    private void changeToFields(ActionEvent event) {
    }
 
    
    
    
}
