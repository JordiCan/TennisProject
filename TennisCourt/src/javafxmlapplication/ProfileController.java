/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package javafxmlapplication;

import java.net.URL;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import java.awt.event.ActionListener;
import java.awt.event.ActionListener;
import javafx.fxml.FXML;
import java.net.URL;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ResourceBundle;
import javafx.beans.binding.Bindings;
import javafx.beans.binding.BooleanBinding;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.fxml.FXMLLoader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import javax.swing.JTextField;
import javax.swing.JFrame;
import java.awt.Color;
import java.awt.FlowLayout;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import model.Club;
import model.ClubDAOException;
import model.Member;
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
import java.io.FileInputStream;
import javax.swing.*;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
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
import javafx.scene.effect.BlendMode;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import model.ClubDAOException;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Background;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author ana
 */
public class ProfileController implements Initializable {
    
    
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
    
    private Text svcErr;
    
    @FXML
    private ImageView Image;
    
    public static Stage Main;
    @FXML
    private Text svcErr1;
    @FXML
    private Button EditProfile;
    @FXML
    private TextField svc1;

    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb){   
        
       // Club t = Club.getInstance();
        //Member mem = t.getMemberByCredentials(variableXori1, gvariableXori2);
        
        //CUANDO HAGAMOS LO DE QUE SEA PUBLICO
        name.setText("EJEMPLO");
        nickname.setText("EJEMPLO2");
        //name.setText(mem.getName());
        //surname.setText(mem.getSurname());
        //telephone.setText(mem.getTelephone());
        //nickname.setText(mem.getNickName());
        //password.setText(mem.getPassword());
        //creditcard.setText(mem.getCreditCard());
        //String svcString = Integer.toString(mem.getSvc());
        //svc1.setText(svcString);
        
        
           
            
    }   
    
    
               
    @FXML
    public void CancelButton() throws Exception {
        FXMLLoader loader = new  FXMLLoader(getClass().getResource("MainStage.fxml"));
        Parent root = loader.load();
        Scene nueva = new Scene(root);
        Node n = (Node) cancel;
        Stage stage = (Stage) cancel.getScene().getWindow();
        stage.setScene(nueva);
        stage.show();
    } 
    
    @FXML
    public void EditProfile_Pic(ActionEvent event) throws Exception{
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Select images");
        FileChooser.ExtensionFilter imageFilter = new FileChooser.ExtensionFilter("Archivos de imagen", "*.jpg", "*.png", "*.gif", "*.bmp");
        fileChooser.getExtensionFilters().add(imageFilter);
        File file = fileChooser.showOpenDialog(pic.getScene().getWindow());
        if (file != null) {
            FileInputStream fis = new FileInputStream(file);
            Image avatar = new Image(fis);
            Image.imageProperty().setValue(avatar);
        }
    }  
    
    @FXML
    public void EditProfile_Action(ActionEvent event) throws Exception{
        //Button pic = new Button("pic");
        //Button EditProfile = new Button ("Edit profile");
        //pic.setVisible(false);
        
        //que permita editar los text fields
        
        
        pic.setVisible(true);
        save.setVisible(true);
        
        name.setBlendMode(BlendMode.SRC_OVER);
        name.setEditable(true);
        surname.setBlendMode(BlendMode.SRC_OVER);
        surname.setEditable(true);
        telephone.setBlendMode(BlendMode.SRC_OVER);
        telephone.setEditable(true);
        //nickname.setEditable(true); NO ES EDITABLE
        password.setBlendMode(BlendMode.SRC_OVER);
        password.setEditable(true);
        creditcard.setBlendMode(BlendMode.SRC_OVER);
        creditcard.setEditable(true);
        csc.setBlendMode(BlendMode.SRC_OVER);
        csc.setEditable(true);
        svc1.setBlendMode(BlendMode.SRC_OVER);
        svc1.setEditable(true);
    }
    
    @FXML
    public void Save_ErroresData() {
        //esta parte la hago mañana con Jordi creo, pero la vamos haciendo 
        //cuando click el save 
        save.setOnMouseClicked(event -> {
           
           if (!Utils.checkUser(name.getText())){
                nameErr.setVisible(true);
                name.setText(""); //AQUI QUIERO QUE ME PONGA LA ORIGINAL 
            }
           else{nameErr.setVisible(false);}
           
            if (!Utils.checkSurname(surname.getText())){
                surnErr.setVisible(true);
                surname.setText("");
            }
            else {surnErr.setVisible(false);}
            
            if (!Utils.checkTelephone(telephone.getText())){
                telErr.setVisible(true);
                telephone.setText("");
            }
            else {telErr.setVisible(false);}
            
            if (!Utils.checkPassword(password.getText())){
                passErr.setVisible(true);
                password.setText("");
            }
            else {passErr.setVisible(false);}

            if (!Utils.checkCard(creditcard.getText())){
                cardErr.setVisible(true);
                creditcard.setText("");
            }
            else {cardErr.setVisible(false);}
            
            if (!Utils.checkCSC(csc.getText())){
                cscErr.setVisible(true);
                csc.setText("");
            }
            else {cscErr.setVisible(false);}
            
             //me falta ver si son numeros o letras
            if (!Utils.checkSVC(svc.getText())){
                svcErr1.setVisible(true);
                svc.setText("");
            }
            else {svcErr1.setVisible(false);}
            
            
            //HASTQ AQUI VEMOS QUE ESTEN CORRECTOS LOS CAMPOS
            //AHORA VAMOS CON EL LISTENER
        });  
    }
}

//DUDAS
//Button accept: que se registren los datos si no hay error. Acceder base de datos. 
//TextFields tengan los campos anteriormente registrados, es decir lo del password y el nickname varibles no locales.

    //ActionListener oyente = new ActionListener(){
                
                //@Overrride
                //public void actionPerformed(ActionEvent e){
                //}
            //}
        //}); 
    
//hacer
//QUIERO QUE ME PONGA LA ORIGINAL EN EL TEXTFIELD al hacer error y al inicio el prompt text
//Ademas la original tm si hay algun error, para que al hacer save 
//me falta chequear si ese tio ya esta registrado
//listener
