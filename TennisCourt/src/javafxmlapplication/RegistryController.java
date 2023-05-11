/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package javafxmlapplication;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.Club;
import model.ClubDAOException;

/**
 * FXML Controller class
 *
 * @author Jordi
 */
public class RegistryController implements Initializable {

    @FXML
    private TextField UserField;
    @FXML
    private PasswordField PasswordField;
   
    
    public static Stage SignUp;
    public static Stage Main;
    @FXML
    private Label errorMessage;
    @FXML
    private Button AcceptButton;
    @FXML
    private Button CancelButton;
    @FXML
    private Button SignUpButton;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
    }    

    @FXML
    private void handleAcceptOnAction(ActionEvent event) throws ClubDAOException, IOException{

            Club c= Club.getInstance();
            if(c.existsLogin(UserField.getText())){
                String temp= null;
                temp= c.getMemberByCredentials(UserField.getText(), PasswordField.getText()).getPassword();
                if(temp.equals(PasswordField.getText())){
                    FXMLLoader myLoader = new FXMLLoader(getClass().getResource("MainStage.fxml"));
                    Parent root= myLoader.load();
                    Scene scene = new Scene(myLoader.load());
                    /*Main = new Stage();
                    Main.setResizable(false);
                    Main.setTitle("Main Menu");
                    Main.setScene(scene);
                    Main.centerOnScreen();
                    Main.show();*/
                    
                    
                        /*FXMLLoader myLoader = new FXMLLoader(getClass().getResource("MainStage.fxml"));
                        Parent root= myLoader.load();
                        Scene scene = new Scene(myLoader.load());*/
                        Node node = (Node) AcceptButton;
                        Main = (Stage) node.getScene().getWindow();
                        Main.setScene(scene);
                        Main.show();

                    
                    
                }
            }
        }

    @FXML
    private void handleCancelOnAction(ActionEvent event) throws IOException {
        Stage stage = (Stage) CancelButton.getScene().getWindow();
        stage.close();
        
        
        
        
        
        
    }

    @FXML
    private void handleSignUpOnAction(ActionEvent event) throws IOException {
        FXMLLoader myLoader = new FXMLLoader(getClass().getResource("SignUp.fxml"));
        Scene scene = new Scene(myLoader.load());
        SignUp = new Stage();
        SignUp.setResizable(false);
        SignUp.setTitle("Sign Up");
        SignUp.setScene(scene);
        SignUp.show();
    }
      
                
}
    
