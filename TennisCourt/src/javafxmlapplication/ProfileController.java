
//Hacr jordi estetica
//Lo del password y todo eso 


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
import model.Club;
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
import model.ClubDAOException;
import model.Member;
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
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import model.Club;
import model.ClubDAOException;
import model.Member;
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
    public static Stage SignUp;
    
    @FXML
    private Text svcErr1;
    @FXML
    private Button EditProfile;
    @FXML
    private TextField svc1;
    @FXML
    private Text nameErr1;
    
    
    
   
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb){   
        
        try {
            Club c = Club.getInstance();
            //m = c.getMemberByCredentials(UserField.getText(), PasswordField.getText());
            
            name.setText(member.getName());
            surname.setText(member.getSurname());
            telephone.setText(member.getTelephone());
            nickname.setText(member.getNickName());
            password.setText(member.getPassword());
            creditcard.setText(member.getCreditCard());
            String svcString = Integer.toString(member.getSvc());
            svc1.setText(svcString);
            
        } catch (Exception e) {
            name.setText("");
        }
    }   
    
               
    @FXML
    public void CancelButton() throws Exception {
        FXMLLoader loader = new  FXMLLoader(getClass().getResource("MainStage.fxml"));
        Parent root = loader.load();
        Scene nueva = new Scene(root);
        Stage stage = (Stage) cancel.getScene().getWindow();
        stage.setScene(nueva);
        stage.show();
    } 
    
    @FXML
    public void Save_ErroresData() {
        //esta parte la hago mañana con Jordi creo, pero la vamos haciendo 
        //cuando click el save 
    
        
        save.setOnMouseClicked(event -> {
           
           boolean tFots = true; //si es true entonces lo guardamos
           if (!Utils.checkUser(name.getText())){
               tFots = false;
                nameErr.setVisible(true);
                name.setText(member.getName()); //AQUI QUIERO QUE ME PONGA LA ORIGINAL
                
            }
           else{nameErr.setVisible(false);}
           
            if (!Utils.checkSurname(surname.getText())){
                surnErr.setVisible(true);
                surname.setText(member.getSurname());
                tFots = false;
            }
            else {surnErr.setVisible(false);}
            
            if (!Utils.checkTelephone(telephone.getText())){
                telErr.setVisible(true);
                telephone.setText(member.getTelephone());
                tFots = false;
            }
            else {telErr.setVisible(false);}
            
            if (!Utils.checkPassword(password.getText())){
                passErr.setVisible(true);
                password.setText(member.getPassword());
                tFots = false;
            }
            else {passErr.setVisible(false);}

            if (!Utils.checkCard(creditcard.getText())){
                cardErr.setVisible(true);
                creditcard.setText(member.getCreditCard());
                tFots = false;
            }
            else {cardErr.setVisible(false);}
            
            if (!Utils.checkSVC(svc.getText())){
                svcErr1.setVisible(true);
                String svcString = Integer.toString(member.getSvc());
                svc.setText(svcString);
            }
            else {svcErr1.setVisible(false);}
            
            
            if (tFots == true){
                //lo guardamos si no son iguales
                if (name.getText() != member.getName()){
                    member.setName(name.getText()); 
                }
                if (surname.getText() != member.getSurname()){
                    member.setSurname(surname.getText());
                }
                if (telephone.getText() != member.getTelephone()){
                    member.setTelephone(telephone.getText());
                }
                if(password.getText() != member.getPassword()){
                    member.setPassword(password.getText());
                }
                if(creditcard.getText() != member.getCreditCard()){
                    member.setCreditCard(creditcard.getText());
                }
                if(svc.getText() != Integer.toString(member.getSvc())){
                    int svc3 = Integer.parseInt(svc.getText());
                    member.setSvc(svc3);
                }
            } 
            
            
            
           
        });  
    }

    @FXML
    private void EditProfile_Pic(javafx.event.ActionEvent event) throws FileNotFoundException {
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
    private void EditProfile_Action(javafx.event.ActionEvent event) {
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
}

//DUDAS
//Button accept: que se registren los datos si no hay error. Acceder base de datos. 
//TextFields tengan los campos anteriormente registrados, es decir lo del password y el nickname varibles no locales.

 /*   ActionListener oyente = new ActionListener(){
                
                @Overrride
                public void actionPerformed(ActionEvent e){
                }
            }
        }); */ 
    
//hacer
//QUIERO QUE ME PONGA LA ORIGINAL EN EL TEXTFIELD al hacer error y al inicio el prompt text
//Ademas la original tm si hay algun error, para que al hacer save 
//me falta chequear si ese tio ya esta registrado
//listener
