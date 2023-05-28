/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package javafxmlapplication;
import java.awt.event.ActionListener;
import static javafxmlapplication.JavaFXMLApplication.member;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
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
import javax.swing.Timer;
import model.Club;
import model.ClubDAOException;
import model.Member;

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
    @FXML
    private ImageView Image;
    @FXML
    private ImageView oki;

    Image avatar= new Image("/img/default.png");
    Member m;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
        
    }    


    @FXML
    private void CancelButton(ActionEvent event) throws IOException {
        
        FXMLLoader loader = new  FXMLLoader(getClass().getResource("MainStage.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        Stage stage = (Stage) cancel.getScene().getWindow();
        stage.setScene(scene);
        stage.setResizable(true);
        stage.show();
        
    }

    @FXML
    private void SelectPicture(ActionEvent event) throws FileNotFoundException {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Select images");
        FileChooser.ExtensionFilter imageFilter = new FileChooser.ExtensionFilter("Archivos de imagen", "*.jpg", "*.png", "*.gif", "*.bmp");
        fileChooser.getExtensionFilters().add(imageFilter);
        File file = fileChooser.showOpenDialog(pictureButton.getScene().getWindow());
        if (file != null) {
            FileInputStream fis = new FileInputStream(file);
            avatar = new Image(fis);
            Image.imageProperty().setValue(avatar);
        }
    }

    @FXML
    private void LaunchLogin(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Registry.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        Stage stageprev = (Stage) LoginButton.getScene().getWindow();
        stageprev.close();
        stage.show(); 
    }

    @FXML
    private void CreateProfile(ActionEvent event) throws ClubDAOException, IOException {
        
        Club c= Club.getInstance();
        
        if(!Utils.checkUser(nameField.getText())){
            nameErr.setVisible(true);
            nameField.setText("");
        }
        else{nameErr.setVisible(false);}
        
        if(!Utils.checkSurname(surnameField.getText())){
            surnErr.setVisible(true);
            surnameField.setText("");
        }
        else{surnErr.setVisible(false);}
        
        if(!Utils.checkTelephone(telephoneField.getText())){
            telErr.setVisible(true);
            telephoneField.setText("");
        }
        else{
            telErr.setVisible(false);
        }
        
        if(!Utils.checkNickname(nicknameField.getText())){
            nameErr1.setVisible(true);
            nicknameField.setText("");
        }
        if(c.existsLogin(nicknameField.getText())){
            nameErr1.setText("Name already in use");
        }
        //else{nameErr1.setVisible(false);}
            
        if(!Utils.checkPassword(passwordField.getText())){
            passErr.setVisible(true);
            passwordField.setText("");
        }
        else{passErr.setVisible(false);}
        
        if(!Utils.checkCard(creditcardField.getText())){
            cardErr.setVisible(true);
            creditcardField.setText("");
        }
        else{cardErr.setVisible(false);}

        if(Utils.checkUser(nameField.getText()) && Utils.checkSurname(surnameField.getText()) && 
        Utils.checkTelephone(telephoneField.getText()) && Utils.checkNickname(nicknameField.getText()) && Utils.checkNickname(nicknameField.getText())&& 
        !c.existsLogin(nicknameField.getText()) && Utils.checkPassword(passwordField.getText()) && Utils.checkCard(creditcardField.getText())) //Falta CSC SVC)
        {
            if(svc.getText().equals("")){
                member= c.registerMember(nameField.getText(), surnameField.getText(), telephoneField.getText(), nicknameField.getText(),
                        passwordField.getText(), creditcardField.getText(), -1, avatar);
            }
            else{
                member= c.registerMember(nameField.getText(), surnameField.getText(), telephoneField.getText(), nicknameField.getText(),
                        passwordField.getText(), creditcardField.getText(), Integer.parseInt(svc.getText()), avatar);
 
            }

           
            /*
                        int visibilityDuration = 2000; 
                oki.setVisible(true);
                Timer timer = new Timer(visibilityDuration, new ActionListener() {
                    @Override
                    public void actionPerformed(java.awt.event.ActionEvent e) {
                       oki.setVisible(false);
                       
                    }
            });
            timer.setRepeats(false);
            timer.start();
            */
            

            FXMLLoader loader = new  FXMLLoader(getClass().getResource("MainStage.fxml"));
            Parent root;
            root = loader.load();
            Scene escena = new Scene(root);
            Stage stage = (Stage) cancel.getScene().getWindow();
            stage.setScene(escena);
            stage.show();
                
     

        
        }
       

        
        
    }
    
}
