/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package javafxmlapplication;

import java.sql.Connection;
import java.net.URL;
import java.time.DayOfWeek;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.format.TextStyle;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.ObservableList;
import javafx.css.PseudoClass;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DatePicker;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SplitMenuButton;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import model.Club;
import model.Court;
import model.Member;
import static model.sub.SqliteConnection.connectSqlite;

/**
 * FXML Controller class
 *
 * @author Alma
 */
public class CourtsViewController implements Initializable {

    @FXML
    private ImageView pista1;
    @FXML
    private ImageView pista2;
    @FXML
    private ImageView pista3;
    @FXML
    private ImageView pista4;
    @FXML
    private ImageView pista5;
    @FXML
    private ImageView pista6;
    @FXML
    private Button homeButton;
    @FXML
    private MenuItem lastCall;
    @FXML
    private Text informationMessage;
    @FXML
    private Text accountProfile;
    
    private Member m = null;
    
    private String court;
    
    private Court c;
    
    private Club club;

    private final LocalTime firstSlotStart = LocalTime.of(9, 0);
    private final Duration slotLength = Duration.ofMinutes(60);
    private final LocalTime lastSlotStart = LocalTime.of(21, 0);
    
    private static final PseudoClass SELECTED_PSEUDO_CLASS = PseudoClass.getPseudoClass("selected");

    //private List<TimeSlotMenuItem> timeSlots = new ArrayList<>(); //Para varias columnas List<List<TimeSolt>>

    //private ObjectProperty<TimeSlotMenuItem> timeSlotSelected;
    
    private LocalDate daySelected;
    @FXML
    private DatePicker day;
    @FXML
    private SplitMenuButton splitMenuButtons;
    
    
    private int value;
    private MenuItem selected;
    
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        try{
        Club club = Club.getInstance();
        
        }
        catch(Exception e){}
        
        //timeSlotSelected = new SimpleObjectProperty<>();
        //cambia los SlotTime al cambiar de dia
        //day.valueProperty().addListener((a, b, c) -> {
            //setTimesSlotsMenuItem(c);
        //});
        
        //---------------------------------------------------------------------
        //inicializa el DatePicker al dia actual
        day.setValue(LocalDate.now());        

        //---------------------------------------------------------------------
        // pinta los SlotTime en el grid
        //setTimesSlotsMenuItem(day.getValue());

        
        Image image1 = new Image("/img/wiilabuena.png");
        pista1.setImage(image1);
        Image image2 = new Image("/img/pista3labuena.jpg");
        pista2.setImage(image2);
        Image image3 = new Image("/img/pista5labuena.jpg");
        pista3.setImage(image3);
        Image image4 = new Image("/img/pista2labuena.jpg");
        pista4.setImage(image4);
        Image image5 = new Image("/img/pista6labuena.jpeg");
        pista5.setImage(image5);
        Image image6 = new Image("/img/mario tennislabuena.jpg");
        pista6.setImage(image6);
        informationMessage.setVisible(false);
        accountProfile.setUnderline(false);
        
        if(m != null){
            accountProfile.setText(m.getNickName()); 
        }
        else{
            accountProfile.setText("You want to make a reservation? Sign Up!");
        }
        
       

    
    
    }    

    @FXML
    private void handleActionGoMainStage(ActionEvent event) throws Exception {
        
        FXMLLoader loader = new  FXMLLoader(getClass().getResource("MainStage.fxml"));
        Parent root = loader.load();
        Scene nueva = new Scene(root);
        Node n = (Node) homeButton;
        Stage stage = (Stage) n.getScene().getWindow();
        stage.setScene(nueva);
        stage.setResizable(true);
        stage.show();
    
    
    }

    @FXML
    private void showInformationMessage(ActionEvent event) {

        informationMessage.setVisible(true);
    
    }

    @FXML
    private void quitarSubrayarTexto(MouseEvent event) {
            accountProfile.setUnderline(false);
    }

    @FXML
    private void subrayarTexto(MouseEvent event) {
            accountProfile.setUnderline(true);
    }

    @FXML
    private void irAlRegister(MouseEvent event) throws Exception {
        
        if(m == null){
            FXMLLoader loader = new  FXMLLoader(getClass().getResource("Registry.fxml"));
            Parent root = loader.load();
            Scene nueva = new Scene(root);
            Node n = (Node) homeButton;
            Stage stage = (Stage) n.getScene().getWindow();
            stage.setScene(nueva);
            stage.setResizable(true);
            stage.show();
        }
        else{
            FXMLLoader loader = new  FXMLLoader(getClass().getResource("Profile.fxml"));
            Parent root = loader.load();
            Scene nueva = new Scene(root);
            Node n = (Node) homeButton;
            Stage stage = (Stage) n.getScene().getWindow();
            stage.setScene(nueva);
            stage.setResizable(true);
            stage.show();
        
        
        
        
        
        }
        
    
    }
    
    public void setMember(Member member){
        this.m = member;
    }

    @FXML
    private void reservaPista1(MouseEvent event) {
        court = "court 1";
        c = club.getCourt(court);
        
        
    
    }

    @FXML
    private void reservaPista4(MouseEvent event) {
        court = "court 4";
        c = club.getCourt(court);

    
    
    }

    @FXML
    private void reservaPista2(MouseEvent event) {
        court = "court 2";
        c = club.getCourt(court);

    
    
    }

    @FXML
    private void reservaPista5(MouseEvent event) {
        court = "court 5";
        c = club.getCourt(court);

    
    
    }

    @FXML
    private void reservaPista3(MouseEvent event) {
        court = "court 3";
        c = club.getCourt(court);

    
    
    }

    @FXML
    private void reservaPista6(MouseEvent event) {
        court = "court 6";
        c = club.getCourt(court);

    
    
    }
    
 
}








