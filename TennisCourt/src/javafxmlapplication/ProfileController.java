/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package javafxmlapplication;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import javafx.scene.text.Text;

import javafx.stage.Stage;
import model.Club;
import model.ClubDAOException;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author ana
 */
public class ProfileController implements Initializable {
    
    @FXML
    private Button EditProfile;
    
    @FXML
    private Button pic;
    
    @FXML
    private Button cancel;
    
    @FXML
    private Button save;
    
    @FXML
    private TextField name;
    
    @FXML
    private TextField surname;
    
    @FXML
    private TextField telephone;
    
    @FXML
    private TextField nickname;
    
    @FXML
    private TextField password;
    
    @FXML
    private TextField creditcard;
    
    @FXML
    private TextField csc;
    
    @FXML
    private TextField svc;
    
    @FXML
    private Text nameErr;
    
    @FXML
    private Text surnErr;
    
    @FXML
    private Text telErr;
    
    @FXML
    private Text passErr;
    
    @FXML
    private Text cardErr;
    
    @FXML
    private Text cscErr;
    
    @FXML
    private Text svcErr;
    
    
    
    public static Stage Main;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }   
    
    @FXML
    public void EditProfile_Action(ActionEvent event) throws Exception{
        //Button pic = new Button("pic");
        //Button EditProfile = new Button ("Edit profile");
        //pic.setVisible(false);
        
        pic.setVisible(true);
        save.setVisible(true);
        cancel.setVisible(true);
        
    }
    
    @FXML
    public void EditProfile_Pic(ActionEvent event) throws Exception{
        //aqui tengo que poder abrir las fotos. 
    }
    
    @FXML
    public void ErroresData() {
        //esta parte la hago mañana con Jordi creo, pero la vamos haciendo 
        //cuando click el save 
        save.setOnMouseClicked(event -> {
            
           
            //me falta ver si son numeros o letras
            if (name.getText().length() < 6 || name.getText().equals("")){
                nameErr.setVisible(true);
            }
             //me falta ver si son numeros o letras
            if (surname.getText().equals("") || surname.getText().equals("")){
                surnErr.setVisible(true);
            }
             //me falta ver si son numeros o letras
            if (telephone.getText().equals("")){
                telErr.setVisible(true);
            }
            if (password.getText().equals("") || password.getText().length() < 6){
                passErr.setVisible(true);
            }
             //me falta ver si son numeros o letras
            if (creditcard.getText().equals("") || creditcard.getText().length() != 16){
                cardErr.setVisible(true);
            }
            //me falta ver que sean numeros
            if (csc.getText().length() != 3){
                cscErr.setVisible(true);
            }
             //me falta ver si son numeros o letras
            if (svc.getText().length() != 3){
                svcErr.setVisible(true);
            }
        });
        
        
    } 
}
