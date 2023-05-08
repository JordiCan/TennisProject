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
import java.io.File;
import java.io.IOException;
import java.awt.Desktop;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import static javafxmlapplication.JavaFXMLApplication.*;
import model.*;
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
    public void initialize(URL url, ResourceBundle rb){
        // TODO
        
        //variables que declarar con jordi 
        //hago un metodo nuevo? o consigo asi con throw?
        Club t = Club.getInstance();
        Member mem = t.getMemberByCredentials(variableXori1, gvariableXori2);
        
        name.setPromptText(mem.getName());
        surname.setPromptText(mem.getSurname());
        telephone.setPromptText(mem.getTelephone());
        nickname.setPromptText(mem.getNickName());
        password.setPromptText(mem.getPassword());
        creditcard.setPromptText(mem.getCreditCard());
        String svcString = Integer.toString(mem.getSvc());
        svc.setPromptText(svcString);      
    }   
    
    @FXML
    public void EditProfile_Action(ActionEvent event) throws Exception{
        //Button pic = new Button("pic");
        //Button EditProfile = new Button ("Edit profile");
        //pic.setVisible(false);
        
        //que permita editar los text fields
        
        pic.setVisible(true);
        save.setVisible(true);
        cancel.setVisible(true);
        
    }
  
    
    
    
    
    @FXML
    public void EditProfile_Pic(ActionEvent event) throws Exception{
        //aqui que abra su home
        //esto está mal pero es parecido
        File imagenes = new File ("img");
        Desktop.getDesktop().open(imagenes);
    }
   
    
    
    
    
    
    
    @FXML
    public void Save_ErroresData() {
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
        
        //AHORA ADEMAS TENGO QUE HACER LO DE AÑADIR QUE SE REGISTREN LOS CAMBIOS 
        //LO HAGO CON LO QUE SE HAGA EN EL REGISTER
        
    } 
    @FXML
    public void CancelButton() {
        //que vuelva a escribir lo anterior
        
    } 
}
