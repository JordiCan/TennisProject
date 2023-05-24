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
import javafx.scene.control.RadioMenuItem;
import javafx.scene.control.SplitMenuButton;
import javafx.scene.control.ToggleGroup;
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
    
    private CheckMenuItem prova;
    
    private ObservableList<CheckMenuItem> ol = FXCollections.observableArrayList();
    
    private List<Booking> l = new ArrayList<>();
    
    private ObservableList<Booking> books = FXCollections.observableArrayList();
    
    private boolean p1 = true;
    
    

    /**
     * Initializes the controller class.
     */

    @FXML
    private RadioMenuItem nueveadiez;
    @FXML
    private ToggleGroup MenuItems;
    @FXML
    private RadioMenuItem diezaonce;
    @FXML
    private RadioMenuItem onceadoce;
    @FXML
    private RadioMenuItem doceauna;
    @FXML
    private RadioMenuItem unaados;
    @FXML
    private RadioMenuItem unaatres;
    @FXML
    private RadioMenuItem tresacuatro;
    @FXML
    private RadioMenuItem cuatroacinco;
    @FXML
    private RadioMenuItem cincoaseis;
    @FXML
    private RadioMenuItem seisasiete;
    @FXML
    private RadioMenuItem sieteaocho;
    @FXML
    private RadioMenuItem ochoanueve;
    
    private int max1 = 0;
    
    
    
    
    
    
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        try{
         club = Club.getInstance();
        
        }
        catch(Exception e){}
       
        
        
        //---------------------------------------------------------------------
        //inicializa el DatePicker al dia actual
        day.setValue(LocalDate.now());        
        
        day.valueProperty().addListener((observable, oldvalue, newvalue)->{
            daySelected = newvalue;
            System.out.print(daySelected.getDayOfMonth());
//AQUI VIENE LO TOCHO
            
            System.out.println("Que esta pasando");
                    l = club.getForDayBookings(daySelected);
                    books = FXCollections.observableArrayList(l);
                    System.out.print(l.size());
                    List<Court> courts = club.getCourts();
                    for(int i = 0; i <6; i++){
                       courts.get(i).setName("p"+i);

                    }
                    Image i1 = new Image("/img/wiilabuena.png");
                    pista1.setImage(i1);
                    Image i2 = new Image("/img/pista3labuena.jpg");
                    pista2.setImage(i2);
                    Image i3 = new Image("/img/pista5labuena.jpg");
                    pista3.setImage(i3);
                    Image i4 = new Image("/img/pista2labuena.jpg");
                    pista4.setImage(i4);
                    Image i5 = new Image("/img/pista6labuena.jpeg");
                    pista5.setImage(i5);
                    Image i6 = new Image("/img/mario tennislabuena.jpg");
                    pista6.setImage(i6);                    
                    for(int i =0; i < l.size(); i++){
                        String courtname = books.get(i).getCourt().getName();
                        LocalTime begin = books.get(i).getFromTime();
                        System.out.println("Memuero");
                        
                        if(begin.equals(timeBegin)){
                            System.out.println("Hasta aqui bien");
                            switch(courtname){
                                case "p0":
                                    i1 = new Image("/img/wiilabuenaBooked.png");
                                    pista1.setImage(i1);
                                break;
                                case "p1":
                                    System.out.println("falla p1");                                    
                                    i2 = new Image("/img/pista5labuenaBooked.jpg");
                                    pista2.setImage(i2);
                                break;
                                case "p2":
                                System.out.println("falla p2");
                                    
                                    i3 = new Image("/img/pista6labuenaBooked.jpeg");
                                    pista2.setImage(i3);
                                break;
                                case "p3":
                                System.out.println("falla p3");
                                    
                                    i4 = new Image("/img/pista3labuenaBooked.jpg");
                                    pista2.setImage(i4);
                                break;
                                case "p4":
                                System.out.println("falla p4");
                                    
                                    i5 = new Image("/img/pista2labuenaBooked.jpg");
                                    pista2.setImage(i5);
                                break; 
                                case "p5":
                                System.out.println("falla p5");
                                    
                                    i6 = new Image("/img/pistaMarioReservada.jpg");
                                    pista6.setImage(i6);
                                    System.out.println("xs");
                                break;                                 
                            }
                        
                        
                        
                        
                    
                    
                    
                    
                        }
                    
                    
                    
                    
                
                }            
        });
        
        MenuItems.selectedToggleProperty().addListener((observable, oldvalue, newvalue)->{
            
            if(nueveadiez.isSelected()){
                timeBegin = LocalTime.of(9,0);
                timeEnd = LocalTime.of(10, 0);
                
                System.out.println(timeBegin.getHour());
            
            }
            
            if(diezaonce.isSelected()){
                timeBegin = LocalTime.of(10,0);
                timeEnd = LocalTime.of(11, 0);
            
            }            
            if(onceadoce.isSelected()){
                timeBegin = LocalTime.of(11,0);
                timeEnd = LocalTime.of(12, 0);
            
            }           
            if(doceauna.isSelected()){
                timeBegin = LocalTime.of(12,0);
                timeEnd = LocalTime.of(13, 0);
            
            }            
            if(unaados.isSelected()){
                timeBegin = LocalTime.of(13,0);
                timeEnd = LocalTime.of(14, 0);
            
            }            
            if(unaatres.isSelected()){
                timeBegin = LocalTime.of(14,0);
                timeEnd = LocalTime.of(15, 0);
            
            }            
            
            if(tresacuatro.isSelected()){
                timeBegin = LocalTime.of(15,0);
                timeEnd = LocalTime.of(16, 0);
            
            }            
            
            if(cuatroacinco.isSelected()){
                timeBegin = LocalTime.of(16,0);
                timeEnd = LocalTime.of(17, 0);
            
            }            
            
            if(cincoaseis.isSelected()){
                timeBegin = LocalTime.of(17,0);
                timeEnd = LocalTime.of(18, 0);
            
            }            
            
            if(seisasiete.isSelected()){
                timeBegin = LocalTime.of(18,0);
                timeEnd = LocalTime.of(19, 0);
            
            }            
            
            if(sieteaocho.isSelected()){
                timeBegin = LocalTime.of(19,0);
                timeEnd = LocalTime.of(20, 0);
            
            }            
        
            if(nueveadiez.isSelected()){
                timeBegin = LocalTime.of(20,0);
                timeEnd = LocalTime.of(21, 0);
            
            }            
        
        
        
        
        
        
        
        
        });
        
        
        
        

        
         

        

        
        
       MenuItems.selectedToggleProperty().addListener((observable, oldvalue, newvalue)->{
                System.out.println("Que esta pasando");
                    l = club.getForDayBookings(daySelected);
                    books = FXCollections.observableArrayList(l);
                    System.out.print(l.size());
                    List<Court> courts = club.getCourts();
                    for(int i = 0; i <6; i++){
                       courts.get(i).setName("p"+i);

                    }
                    Image i1 = new Image("/img/wiilabuena.png");
                    pista1.setImage(i1);
                    Image i2 = new Image("/img/pista3labuena.jpg");
                    pista2.setImage(i2);
                    Image i3 = new Image("/img/pista5labuena.jpg");
                    pista3.setImage(i3);
                    Image i4 = new Image("/img/pista2labuena.jpg");
                    pista4.setImage(i4);
                    Image i5 = new Image("/img/pista6labuena.jpeg");
                    pista5.setImage(i5);
                    Image i6 = new Image("/img/mario tennislabuena.jpg");
                    pista6.setImage(i6);                    
                    for(int i =0; i < l.size(); i++){
                        String courtname = books.get(i).getCourt().getName();
                        LocalTime begin = books.get(i).getFromTime();
                        System.out.println("Memuero");
                        
                        if(begin.equals(timeBegin)){
                            System.out.println("Hasta aqui bien");
                            switch(courtname){
                                case "p0":
                                    i1 = new Image("/img/wiilabuenaBooked.png");
                                    pista1.setImage(i1);
                                break;
                                case "p1":
                                    System.out.println("falla p1");                                    
                                    i2 = new Image("/img/pista5labuenaBooked.jpg");
                                    pista2.setImage(i2);
                                break;
                                case "p2":
                                System.out.println("falla p2");
                                    
                                    i3 = new Image("/img/pista6labuenaBooked.jpeg");
                                    pista3.setImage(i3);
                                break;
                                case "p3":
                                System.out.println("falla p3");
                                    
                                    i4 = new Image("/img/pista3labuenaBooked.jpg");
                                    pista4.setImage(i4);
                                break;
                                case "p4":
                                System.out.println("falla p4");
                                    
                                    i5 = new Image("/img/pista2labuenaBooked.jpg");
                                    pista5.setImage(i5);
                                break; 
                                case "p5":
                                System.out.println("falla p5");
                                    
                                    i6 = new Image("/img/pistaMarioReservada.jpg");
                                    pista6.setImage(i6);
                                    System.out.println("xs");
                                break;                                 
                            }
                        
                        
                        
                        
                    
                    
                    
                    
                        }
                    
                    
                    
                    
                
                }
        
        
        
        });
        

        
        
        

        //---------------------------------------------------------------------
        


        
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
        if(p1 && max1 != 2){
            max1++;
            
        
        }
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








