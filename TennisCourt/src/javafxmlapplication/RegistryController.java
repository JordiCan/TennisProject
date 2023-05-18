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
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import model.Club;
import model.ClubDAOException;
import model.Member;

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

    public Member m;
    @FXML
    private ImageView pelotazas;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        Image im = new Image("/img/pelotazasazules.png");
        pelotazas.setImage(im);
    }    

    @FXML
    private void handleAcceptOnAction(ActionEvent event) throws ClubDAOException, IOException{

            Club c= Club.getInstance();
            if(c.existsLogin(UserField.getText())){
                System.out.println("Entra");
                String temp;
                m= c.getMemberByCredentials(UserField.getText(), PasswordField.getText());
                                System.out.println("Entra2");
                temp= m.getPassword();
                                System.out.println(temp);
                if(!m.equals(null)&&temp.equals(PasswordField.getText())){
                   
                    System.out.println("Funciona");
                           FXMLLoader loader = new  FXMLLoader(getClass().getResource("MainStage.fxml"));
                           Parent root = loader.load();
                           MainStageController controlador=  loader.getController(); 
                           controlador.setMember(m);
                           
                            Scene nueva = new Scene(root);
                            Node n = (Node) AcceptButton;
                            Stage stage = (Stage) n.getScene().getWindow();
                            stage.setScene(nueva);
                            stage.setResizable(true);
                            stage.show();
                }
                else{
                    errorMessage.setVisible(true);
                    UserField.setText("");
                    PasswordField.setText("");
                }
            }
            else{
                errorMessage.setVisible(true);
                UserField.setText("");
                PasswordField.setText("");
                }
        }

    @FXML
    private void handleCancelOnAction(ActionEvent event) throws IOException {
        FXMLLoader loader = new  FXMLLoader(getClass().getResource("MainStage.fxml"));
        Parent root = loader.load();
        Scene nueva = new Scene(root);
        Node n = (Node) CancelButton;
        Stage stage = (Stage) n.getScene().getWindow();
        stage.setScene(nueva);
        stage.setResizable(true);
        stage.show();
        
        
        
        
        
        
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
    
