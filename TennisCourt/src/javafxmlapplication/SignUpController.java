/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package javafxmlapplication;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

/**
 * FXML Controller class
 *
 * @author Jordi
 */
public class SignUpController implements Initializable {

    @FXML
    private Button save;
    @FXML
    private Button cancel;
    @FXML
    private TextField nameField;
    @FXML
    private Text nameErr;
    @FXML
    private TextField surnameField;
    @FXML
    private Text surnErr;
    @FXML
    private TextField telephoneField;
    @FXML
    private Text telErr;
    @FXML
    private TextField nicknameField;
    @FXML
    private Text nameErr1;
    @FXML
    private PasswordField passwordField;
    @FXML
    private Text passErr;
    @FXML
    private TextField creditcardField;
    @FXML
    private Text cardErr;
    @FXML
    private TextField csc;
    @FXML
    private Text cscErr;
    @FXML
    private TextField svc;
    @FXML
    private Text svcErr1;
    @FXML
    private Button pictureButton;
    @FXML
    private Button LoginButton;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
        
    }    


    @FXML
    private void CancelButton(ActionEvent event) {
    }

    @FXML
    private void SelectPicture(ActionEvent event) {
    }

    @FXML
    private void LaunchLogin(ActionEvent event) {
        
    }

    @FXML
    private void CreateProfile(ActionEvent event) {
        if(!nameField.getText().equals("")){}
        else{nameField.setText(""); nameErr.setVisible(true);}
        
        if(){}
        else
        
        if(){}
        else{}
        
        if(){}
        else{}
    }
    
}
