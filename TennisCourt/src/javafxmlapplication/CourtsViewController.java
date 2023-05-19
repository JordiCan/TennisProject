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
import javafx.collections.FXCollections;
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
import javafx.scene.control.CheckMenuItem;
import javafx.scene.control.DateCell;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SplitMenuButton;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import model.Booking;
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
    private LocalTime timeBegin;
    private LocalTime timeEnd;
    
    @FXML
    private DatePicker day;
    @FXML
    private SplitMenuButton splitMenuButtons;
    
    
    private int value;
    private MenuItem selected;
    
    @FXML
    private CheckMenuItem prova;
    
    private ObservableList<CheckMenuItem> ol = FXCollections.observableArrayList();
    
    private ObservableList<Booking> books = FXCollections.observableArrayList();
    
    

    /**
     * Initializes the controller class.
     */
    @FXML
    private CheckMenuItem prova1;
    @FXML
    private CheckMenuItem prova2;
    @FXML
    private CheckMenuItem prova3;
    @FXML
    private CheckMenuItem prova4;
    @FXML
    private CheckMenuItem prova5;
    @FXML
    private CheckMenuItem prova6;
    @FXML
    private CheckMenuItem prova7;
    @FXML
    private CheckMenuItem prova8;
    @FXML
    private CheckMenuItem prova9;
    @FXML
    private CheckMenuItem prova10;
    @FXML
    private CheckMenuItem prova11;
    
    
    
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        try{
         club = Club.getInstance();
        
        }
        catch(Exception e){}
       
        ol.add(prova);
        ol.add(prova1);
        ol.add(prova2);
        ol.add(prova3);
        ol.add(prova4);
        ol.add(prova5);
        ol.add(prova6);
        ol.add(prova7);
        ol.add(prova8);
        ol.add(prova9);
        ol.add(prova10);
        ol.add(prova11);
        
        //---------------------------------------------------------------------
        //inicializa el DatePicker al dia actual
        day.setValue(LocalDate.now());        

        

        prova.setOnAction(e ->{
         if(prova.isSelected()){
             timeBegin = firstSlotStart;
             timeEnd = LocalTime.of(10,0);
             unselectOtherItems(prova);
         }
        });
         
        prova1.setOnAction(e->{
        if(prova1.isSelected()){
             timeBegin = LocalTime.of(10,0);
             timeEnd = LocalTime.of(11,0);
             unselectOtherItems(prova1);
             
         }
        });
        
        
        prova2.setOnAction(e->{
         if(prova2.isSelected()){
             timeBegin = LocalTime.of(11,0);
             timeEnd = LocalTime.of(12,0);
             unselectOtherItems(prova2);
            
         }
        });
        
        prova3.setOnAction(e->{

         if(prova3.isSelected()){
             timeBegin = LocalTime.of(12,0);
             timeEnd = LocalTime.of(13,0);
             unselectOtherItems(prova3);
             
         }});

        prova4.setOnAction(e->{
        
         if(prova4.isSelected()){
             timeBegin = LocalTime.of(13,0);
             timeEnd = LocalTime.of(14,0);
             unselectOtherItems(prova4);
             
         }});

        prova5.setOnAction(e->{
        
         if(prova5.isSelected()){
             timeBegin = LocalTime.of(14,0);
             timeEnd = LocalTime.of(15,0);
             unselectOtherItems(prova5);
             
         }});
        
        prova6.setOnAction(e->{
        
         if(prova6.isSelected()){
             timeBegin = LocalTime.of(15,0);
             timeEnd = LocalTime.of(16,0);
             unselectOtherItems(prova6);
             
         }
        });
        
        prova7.setOnAction(e->{
        
         if(prova7.isSelected()){
             timeBegin = LocalTime.of(16,0);
             timeEnd = LocalTime.of(17,0);
             unselectOtherItems(prova7);
             
         }});
        
        prova8.setOnAction(e->{
        
         if(prova8.isSelected()){
             timeBegin = LocalTime.of(17,0);
             timeEnd = LocalTime.of(18,0);
             unselectOtherItems(prova8);
             
         }});
        
        prova1.setOnAction(e->{
        
         if(prova9.isSelected()){
             timeBegin = LocalTime.of(18,0);
             timeEnd = LocalTime.of(19,0);
             unselectOtherItems(prova9);
             
         }});
        
        prova10.setOnAction(e->{
        
         if(prova10.isSelected()){
             timeBegin = LocalTime.of(19,0);
             timeEnd = LocalTime.of(20,0);
             unselectOtherItems(prova10);
             
         }});
        
        prova11.setOnAction(e->{
        
         if(prova11.isSelected()){
             timeBegin = LocalTime.of(20,0);
             timeEnd = LocalTime.of(21,0);
             unselectOtherItems(prova11);
             
         }});
        
        pista1.imageProperty().addListener(e ->{
            
            List<Booking> list1 = club.getCourtBookings("court 1",daySelected);
            if(!containsDate(list1,timeBegin)){
                Image p1 = new Image("/img/wiibuenaBooked");
                pista1.setImage(p1);
            }
        });

        pista2.imageProperty().addListener(e ->{
            
            List<Booking> list2 = club.getCourtBookings("court 2",daySelected);
            if(!containsDate(list2,timeBegin)){
                Image p2 = new Image("/img/pista3labuenaBooked");
                pista2.setImage(p2);
            }
        });
        pista3.imageProperty().addListener(e ->{
            
            List<Booking> list3 = club.getCourtBookings("court 3",daySelected);
            if(!containsDate(list3,timeBegin)){
                Image p3 = new Image("/img/pista5labuenaBooked");
                pista3.setImage(p3);
            }
        });
        pista4.imageProperty().addListener(e ->{
            
            List<Booking> list4 = club.getCourtBookings("court 4",daySelected);
            if(!containsDate(list4,timeBegin)){
                Image p4 = new Image("/img/pista2labuenaBooked");
                pista4.setImage(p4);
            }
        });
        pista5.imageProperty().addListener(e ->{
            
            List<Booking> list5 = club.getCourtBookings("court 5",daySelected);
            if(!containsDate(list5,timeBegin)){
                Image p5 = new Image("/img/pista6labuenaBooked");
                pista5.setImage(p5);
            }
        });
        pista6.imageProperty().addListener(e ->{
            
            List<Booking> list6 = club.getCourtBookings("court 6",daySelected);
            if(!containsDate(list6,timeBegin)){
                Image p6 = new Image("/img/pistaMarioReservada");
                pista6.setImage(p6);
            }
        });
        
        

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
        
        day.setDayCellFactory((DatePicker picker) -> {
            return new DateCell() {
                @Override 
                public void updateItem(LocalDate date, boolean empty) {
                    super.updateItem(date, empty);
                    LocalDate today = LocalDate.now();
                    setDisable(empty || date.compareTo(today) < 0 );
                }             };
        });
        
        daySelected = day.valueProperty().get();
        
        
       

    
    
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
    
    private void unselectOtherItems(CheckMenuItem selectedItem){
       for(CheckMenuItem menuItem : ol) {
           if(menuItem != selectedItem){
               menuItem.setSelected(false);
           }

       }

    }
    
    private boolean containsDate(List l, LocalTime t ){
    
       Booking[] ba = (Booking[]) l.toArray();
       for(int i = 0; i < ba.length; i++){
           if(ba[i].getFromTime().equals(t)){
               return true;
           }
       }
    return false;
    }
    
 
}








