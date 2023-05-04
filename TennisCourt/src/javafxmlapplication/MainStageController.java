/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package javafxmlapplication;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.MenuItem;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.stage.Window;
import javafx.scene.image.Image;
import static javafxmlapplication.RegistryController.Main;


/**
 * FXML Controller class
 *
 * @author Alma
 */
public class MainStageController  implements Initializable {

    @FXML
    private MenuItem signUpScene;
    @FXML
    private MenuItem registerScene;
    @FXML
    private MenuItem fieldsScene;
    @FXML
    private ImageView logo;
    @FXML
    private ImageView court;
    
    public static Stage SignUp;
    public static Stage Main;
    public static Stage Fields;
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        Image image = new Image("/img/logo.png");
        logo.setImage(image);
        Image im = new Image("/img/upv pista.jpeg");
        court.setImage(im);
    }    

    @FXML
    private void changeToSignUp(ActionEvent event) throws Exception {
        
        Stage nuevaVentana = new Stage();
        FXMLLoader loader= new  FXMLLoader(getClass().getResource("SignUp.fxml"));
        Parent root = loader.load();
        Scene escena = new Scene(root);
        nuevaVentana.setTitle("SignUp");
        nuevaVentana.setResizable(false);
        nuevaVentana.setScene(escena);
        nuevaVentana.show();
    }

    @FXML
    private void changeToRegister(ActionEvent event) throws Exception {
        
        FXMLLoader loader1 = new  FXMLLoader(getClass().getResource("Registry.fxml"));
        Parent root = loader1.load();
        Scene nueva = new Scene(root);
        Node n = registerScene.getParentPopup().getOwnerNode();
        Stage stage = (Stage) n.getScene().getWindow();
        stage.setScene(nueva);
        stage.show();
        
        
    }

    @FXML
    private void changeToFields(ActionEvent event) throws Exception {
        
        /*FXMLLoader loader = new  FXMLLoader(getClass().getResource("Registry.fxml"));
        Parent root = loader.load();
        Scene nueva = new Scene(root);
        Node n = registerScene.getParentPopup().getOwnerNode();
        Main = (Stage) n.getScene().getWindow();
        stage.setScene(nueva);
        stage.show();*/
    
    }
 
    
    
    
}
