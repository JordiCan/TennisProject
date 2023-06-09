/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package javafxmlapplication;

import java.awt.Desktop;
import java.io.File;
import java.net.URI;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SplitMenuButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.stage.Window;
import javafx.scene.image.Image;
import javafx.scene.input.MouseDragEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
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
    private MenuItem bookings;
    @FXML
    private MediaView mediaView;
    @FXML
    private Text nombre;
    @FXML
    private SplitMenuButton home;
    @FXML
    private HBox hboxverdadera;
    @FXML
    private VBox vbox;
    private VBox vboxxd;
    @FXML
    private HBox hboxpane;
    @FXML
    private Text paginadecathlon;
    @FXML
    private BorderPane borderPane;
    
    private MediaPlayer mediaPlayer;
    @FXML
    private Button logOutButton;
    @FXML
    private ImageView imageLogOut;
    

    

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
             mediaPlayer = new MediaPlayer(media);
             mediaView.setMediaPlayer(mediaPlayer);
             mediaPlayer.setMute(false);             
             mediaPlayer.setAutoPlay(true);
             mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);
             mediaView.setFitHeight(hboxverdadera.getHeight());
             mediaView.setFitWidth(hboxverdadera.getWidth());
         }
         catch(MediaException e){System.out.println("No coge bien el path");}
        bookings.setDisable(true);
        Image image = new Image("/img/logo.png");
        Image i = new Image("/img/logoutColor.png");
        imageLogOut.setImage(i);
        logo.setImage(image);

        try{
        Club club = Club.getInstance();
        }
        catch(Exception e){}
        
       signUpScene.setDisable(false);
       registerScene.setDisable(false);
        
        //accountInfo.visbleProperty().addListener((observable,oldvalue,newvalue)->{});
       if(member != null){
            accountInfo.setVisible(true);
            accountInfo.setText(member.getNickName());
            Image jiji = member.getImage();
            imageProfile.setImage(jiji);
            bookings.setDisable(false);
            signUpScene.setDisable(true);
            registerScene.setDisable(true);
       }

       //RESIZABLE  
        
       mediaView.fitHeightProperty().bind(hboxverdadera.heightProperty());
       mediaView.fitWidthProperty().bind(hboxverdadera.widthProperty());
       
       


    }   

    @FXML
    private void changeToSignUp(ActionEvent event) throws Exception {
        
        FXMLLoader loader = new  FXMLLoader(getClass().getResource("SignUp.fxml"));
        Parent root = loader.load();
        Scene escena = new Scene(root);
        mediaPlayer.setMute(true);
     
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
        mediaPlayer.setMute(true);
        
        
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
        mediaPlayer.setMute(true);
        
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
        mediaPlayer.setMute(true);
        
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
            mediaPlayer.setMute(true);
            
            Scene nueva = new Scene(root);
            Node n = bookings.getParentPopup().getOwnerNode();
            Stage stage = (Stage) n.getScene().getWindow();
            stage.setScene(nueva);
            stage.setResizable(true);
            stage.show();

        
        
        
        
        
        
        }
        
        
    }

    @FXML
    private void quitarSubrayadoDecathlon(MouseEvent event) {
        paginadecathlon.setUnderline(false);
        
    }

    @FXML
    private void subrayarDecathlon(MouseEvent event) {
        paginadecathlon.setUnderline(true);
    
    }

    @FXML
    private void irADecathlon(MouseEvent event) {
        String direccion = "https://www.decathlon.es/es/sport/c0-deportes/c1-tenis/_/N-77r6sc";
        try{
            Desktop.getDesktop().browse(new URI(direccion));
        
        }
        catch(Exception e){
            e.printStackTrace();
        
        }
    }

    @FXML
    private void logOutAction(ActionEvent event) throws Exception {
        if(member == null){
            Alert a = new Alert(AlertType.ERROR);
            a.setHeaderText("Inavlid action");
            a.setContentText("You can not log out if you have not logged in");
            a.showAndWait();
        }
        else{
            member = null;
            FXMLLoader loader = new  FXMLLoader(getClass().getResource("MainStage.fxml"));
            Parent root = loader.load();
            mediaPlayer.setMute(true);
            
            Scene nueva = new Scene(root);
            Stage stage = (Stage) logOutButton.getScene().getWindow();
            stage.setScene(nueva);
            stage.setResizable(true);
            stage.show();            
            
        
        }
    
    }
 
    
    
    
}
