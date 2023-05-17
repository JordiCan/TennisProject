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
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.stage.Window;
import javafx.scene.image.Image;
import javafx.scene.input.MouseDragEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import static javafxmlapplication.RegistryController.Main;
import model.Club;
import model.Member;


/**
 * FXML Controller class
 *
 * @author Alma
 */
public class MainStageController  implements Initializable{

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
    
    
    private Member member = null ;
    @FXML
    private Text accountInfo;

    
    

    

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
        
        try{
        Club club = Club.getInstance();
        }
        catch(Exception e){}
        
       
       
       if(member != null){
           accountInfo.setText(member.getName() + "  " + member.getSurname());
       }
       else{
           accountInfo.setText("You must register in order to access to your profile");
       }
       

    }   

    @FXML
    private void changeToSignUp(ActionEvent event) throws Exception {
        
        FXMLLoader loader = new  FXMLLoader(getClass().getResource("SignUp.fxml"));
        Parent root = loader.load();
        Scene escena = new Scene(root);
        Stage nuevaVentana = new Stage();
        nuevaVentana.setScene(escena);
        nuevaVentana.setResizable(true);
        nuevaVentana.show();
    }

    @FXML
    private void changeToRegister(ActionEvent event) throws Exception {
        
        FXMLLoader loader = new  FXMLLoader(getClass().getResource("Registry.fxml"));
        Parent root = loader.load();
        Scene nueva = new Scene(root);
        Node n = registerScene.getParentPopup().getOwnerNode();
        Stage stage = (Stage) n.getScene().getWindow();
        stage.setScene(nueva);
        stage.setResizable(true);
        stage.show();
        
        
    }

    @FXML
    private void changeToFields(ActionEvent event) throws Exception {
        
        FXMLLoader loader = new  FXMLLoader(getClass().getResource("CourtsView.fxml"));
        Parent root = loader.load();
        Scene nueva = new Scene(root);
        Node n = registerScene.getParentPopup().getOwnerNode();
        Stage stage = (Stage) n.getScene().getWindow();
        stage.setScene(nueva);
        stage.setResizable(true);
        stage.show();
    
    }

    

    

    @FXML
    private void click(MouseEvent event) throws Exception {
    
        FXMLLoader loader = new  FXMLLoader(getClass().getResource("Profile.fxml"));
        Parent root = loader.load();
        Scene nueva = new Scene(root);
        Node n = accountInfo.getParent();
        Stage stage = (Stage) n.getScene().getWindow();
        stage.setScene(nueva);
        stage.setResizable(true);
        stage.show();
    
    }

    @FXML
    private void subrayarTexto(MouseEvent event) {
        accountInfo.setUnderline(true);
    }

  

    @FXML
    private void quitarSubrayado(MouseEvent event) {
        accountInfo.setUnderline(false);

    }
    
    public void setMember(Member member){
        this.member = member;
    }
 
    
    
    
}
