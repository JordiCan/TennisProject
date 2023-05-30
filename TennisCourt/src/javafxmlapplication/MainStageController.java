/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package javafxmlapplication;

import java.io.File;
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
import javafx.scene.layout.HBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaException;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import static javafxmlapplication.JavaFXMLApplication.member;
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
    private Text accountInfo;
    @FXML
    private ImageView imageProfile;
    @FXML
    private HBox hbox;
    @FXML
    private MenuItem bookings;
    @FXML
    private MediaView mediaView;
    
    
    

    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
         try{
            String videofile = "src//video//videomario.mp4";
            File file = new File(videofile);
             Media media = new Media(file.toURI().toString());
             MediaPlayer mediaPlayer = new MediaPlayer(media);
             mediaView.setMediaPlayer(mediaPlayer);
             mediaPlayer.setAutoPlay(true);
             mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);              
         }
         catch(MediaException e){System.out.println("No coge bien el path");}
        
        bookings.setDisable(true);
        Image image = new Image("/img/logo.png");
        logo.setImage(image);
        
        hbox.heightProperty().addListener((observable, oldvalue, newvalue)->{
            mediaView.setFitHeight((double) newvalue);
        });
        hbox.widthProperty().addListener((observable, oldvalue, newvalue)->{
            mediaView.setFitWidth((double) newvalue);
        });        

        
        try{
        Club club = Club.getInstance();
        }
        catch(Exception e){}
        
        //accountInfo.visbleProperty().addListener((observable,oldvalue,newvalue)->{});
       if(member!=null){
            accountInfo.setVisible(true);
            accountInfo.setText(member.getNickName());
            Image jiji = member.getImage();
            imageProfile.setImage(jiji);
            bookings.setDisable(false);
       }
       



    }   

    @FXML
    private void changeToSignUp(ActionEvent event) throws Exception {
        
        FXMLLoader loader = new  FXMLLoader(getClass().getResource("SignUp.fxml"));
        Parent root = loader.load();
        Scene escena = new Scene(root);
     
        Node n = (Node) signUpScene.getParentPopup().getOwnerNode();
        Stage nuevaVentana = (Stage) n.getScene().getWindow();
        nuevaVentana.setScene(escena);
        nuevaVentana.setResizable(true);
        nuevaVentana.show();
        
        nuevaVentana.setMinHeight(400);
        nuevaVentana.setMinWidth(200);
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
        
        stage.setMinWidth(400);
        stage.setMinHeight(200);
        
        
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
        
        stage.setMinHeight(200);
        stage.setMinWidth(400);
    
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
        
        stage.setMinHeight(400);
        stage.setMinWidth(200);
    
    }

    @FXML
    private void subrayarTexto(MouseEvent event) {
        accountInfo.setUnderline(true);
    }

  

    @FXML
    private void quitarSubrayado(MouseEvent event) {
        accountInfo.setUnderline(false);

    }
    


    @FXML
    private void changeToBooking(ActionEvent event) throws Exception {
        if(member != null){

            FXMLLoader loader = new  FXMLLoader(getClass().getResource("Bookings.fxml"));
            Parent root = loader.load();
            Scene nueva = new Scene(root);
            Node n = bookings.getParentPopup().getOwnerNode();
            Stage stage = (Stage) n.getScene().getWindow();
            stage.setScene(nueva);
            stage.setResizable(true);
            stage.show();

        
        
        
        
        
        
        }
        
        
    }
 
    
    
    
}
