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
import javafx.beans.binding.Bindings;
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
import javafx.scene.control.Alert.AlertType;
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
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import static javafxmlapplication.JavaFXMLApplication.member;
import javafxmlapplication.MaxBookingDuration;
import model.Booking;
import model.Club;
import model.ClubDAOException;
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
    
    
    private String court;
    
    private Court c;
    
    private Club club;

    private final LocalTime firstSlotStart = LocalTime.of(9, 0);
    private final Duration slotLength = Duration.ofMinutes(60);
    private final LocalTime lastSlotStart = LocalTime.of(21, 0);
    

    //private List<TimeSlotMenuItem> timeSlots = new ArrayList<>(); //Para varias columnas List<List<TimeSolt>>

    //private ObjectProperty<TimeSlotMenuItem> timeSlotSelected;
    
    private LocalDate daySelected;
    private LocalTime timeBegin;
    private LocalTime timeEnd;
    private LocalDateTime now = LocalDateTime.of(LocalDate.now(),LocalTime.now());
    
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
    private boolean p2 = true;
    private boolean p3 = true;
    private boolean p4 = true;
    private boolean p5 = true;
    private boolean p6 = true;
    
    private Member localMember;
    
    private List<Booking> memberBooking = new ArrayList<>();
    

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
    

    @FXML
    private RadioMenuItem nueveadiezpm;
    
    private List<MaxBookingDuration> maxBookingsCourts = new ArrayList<>();
    @FXML
    private Text member1;
    @FXML
    private Text member4;
    @FXML
    private Text member2;
    @FXML
    private Text member5;
    @FXML
    private Text member3;
    @FXML
    private Text member6;
    @FXML
    private HBox hboxcourts;
    @FXML
    private HBox hboxbottom;
    @FXML
    private HBox hboxpistas;
    @FXML
    private VBox v1;
    @FXML
    private VBox v2;
    @FXML
    private VBox v3;
    @FXML
    private HBox buttonbox;
    @FXML
    private ImageView home;
    
    
    
    
    
    
    
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        try{
         club = Club.getInstance();
        
        }
        catch(Exception e){}
        
        member1.setVisible(false);
        member2.setVisible(false);
        member3.setVisible(false);
        member4.setVisible(false);
        member5.setVisible(false);
        member6.setVisible(false);
        
        double initialWidth = 150;
        
        
        //RESIZABLE
        hboxpistas.heightProperty().addListener((observable, oldvalue, newvalue)->{

        if(newvalue.doubleValue()/3 < 140){
            pista1.setFitHeight(newvalue.doubleValue()/3);
            pista2.setFitHeight(newvalue.doubleValue()/3);
            pista3.setFitHeight(newvalue.doubleValue()/3);
            pista4.setFitHeight(newvalue.doubleValue()/3);
            pista5.setFitHeight(newvalue.doubleValue()/3);
            pista6.setFitHeight(newvalue.doubleValue()/3);
        }
                   
        });
        
        hboxpistas.widthProperty().addListener((obervable, oldvalue, newvalue)->{
            if(newvalue.doubleValue()/4 < 192.4){ 
                pista1.setFitWidth(newvalue.doubleValue()/4);
                pista2.setFitWidth(newvalue.doubleValue()/4);
                pista3.setFitWidth(newvalue.doubleValue()/4);
                pista4.setFitWidth(newvalue.doubleValue()/4);
                pista5.setFitWidth(newvalue.doubleValue()/4);
                pista6.setFitWidth(newvalue.doubleValue()/4);
                
                
                
                double fontSize = newvalue.doubleValue() *0.02;
                member1.setFont(Font.font("System",fontSize));
                member2.setFont(Font.font("System",fontSize));
                member3.setFont(Font.font("System",fontSize));
                member4.setFont(Font.font("System",fontSize));
                member5.setFont(Font.font("System",fontSize));
                member6.setFont(Font.font("System",fontSize));
        
           }
        
        });
        

        
        hboxbottom.widthProperty().addListener((obervable, oldvalue, newvalue)->{
            double fontSize = newvalue.doubleValue() *0.015;
            accountProfile.setFont(Font.font("System", fontSize));
            home.setFitWidth(newvalue.doubleValue()/2);
        
        });
        hboxbottom.heightProperty().addListener((onservable,oldvalue, newvalue)->{
            home.setFitHeight(newvalue.doubleValue()/2);
        
        });
        
        
        LocalDate n = LocalDate.ofEpochDay(3);
        Court court = new Court("jeje");

        //---------------------------------------------------------------------
        //inicializa el DatePicker al dia actual
        day.setValue(LocalDate.now());        
        
        day.valueProperty().addListener((observable, oldvalue, newvalue)->{
            daySelected = newvalue;
            System.out.print(daySelected.getDayOfMonth());
            
//AQUI VIENE LO TOCHO
            
                    l = club.getForDayBookings(daySelected);
                    books = FXCollections.observableArrayList(l);
                    System.out.print(l.size());
                    
//No existen los bookings
                        member1.setVisible(false);
                        member2.setVisible(false);
                        member3.setVisible(false);
                        member4.setVisible(false);
                        member5.setVisible(false);
                        member6.setVisible(false);
                    
                    
//poner nombre a las pistas                    
                    List<Court> courts = club.getCourts();
                    for(int i = 0; i <6; i++){
                       courts.get(i).setName("p"+i);

                    }
                    if(member != null){
                    memberBooking = club.getUserBookings(member.getNickName());
                    }
                    else{memberBooking = null;}
//poner las imagenes bien para luego cambiarlas

                    Image i1 = new Image("/img/wiilabuena.png");
                    pista1.setImage(i1);
                    Image i2 = new Image("/img/pista5labuena.jpg");
                    pista2.setImage(i2);
                    Image i3 = new Image("/img/pista6labuena.jpeg");
                    pista3.setImage(i3);
                    Image i4 = new Image("/img/pista3labuena.jpg");
                    pista4.setImage(i4);
                    Image i5 = new Image("/img/pista2labuena.jpg");
                    pista5.setImage(i5);
                    Image i6 = new Image("/img/mario tennislabuena.jpg");
                    pista6.setImage(i6);  
                    
                    
//poner a true todas las variables otra vez
                    p1 = true;
                    p2 = true;
                    p3 = true;
                    p4 = true;
                    p5 = true;
                    p6 = true;



                    for(int i =0; i < l.size(); i++){
                        String courtname = books.get(i).getCourt().getName();
                        LocalTime begin = books.get(i).getFromTime();
                        String nickname = books.get(i).getMember().getNickName();
                        System.out.println("El nickname es " + nickname);
                        
                        if(begin.equals(timeBegin)){
                            switch(courtname){
                                case "p0":
                                    
                                    if(inTheMemberBookings(memberBooking,timeBegin,"p0")){
                                        i1 = new Image("/img/wiilabuenatupista.png");
                                        pista1.setImage(i1);

                                    
                                    }
                                    else{i1 = new Image("/img/wiilabuenaBooked.png");
                                    pista1.setImage(i1);
                                    member1.setVisible(true);
                                    member1.setText("Booked by: " +nickname);                                    
                                    }
                                    p1 = false;
                                break;
                                case "p1":
                                    if(inTheMemberBookings(memberBooking,timeBegin,"p1")){
                                        i2 = new Image("/img/pista5labuenatupista.jpg");
                                        pista2.setImage(i2);
                                    
                                    }
                                    else{                                    
                                    i2 = new Image("/img/pista5labuenaBooked.jpg");
                                    pista2.setImage(i2);
                                    member2.setVisible(true);
                                    member2.setText("Booked by: " +nickname);                                         
                                    }
                                    p2 = false;
                                break;
                                case "p2":
                                    if(inTheMemberBookings(memberBooking,timeBegin,"p2")){
                                        i3 = new Image("/img/pista6labuenatupista.jpeg");
                                        pista3.setImage(i3);
                                    member3.setVisible(true);
                                    member3.setText("Booked by: " +nickname);                                         
                                    
                                    }
                                    else{                                    
                                    i3 = new Image("/img/pista6labuenaBooked.jpeg");
                                    pista3.setImage(i3);
                                    member3.setVisible(true);
                                    member3.setText("Booked by: " +nickname);                                     
                                    }
                                    p3 = false;
                                break;
                                case "p3":
                                    if(inTheMemberBookings(memberBooking,timeBegin,"p3")){
                                        i4 = new Image("/img/pista3tupista.jpg");
                                        pista4.setImage(i4);
                                    }
                                    else{                                    
                                    i4 = new Image("/img/pista3labuenaBooked.jpg");
                                    pista4.setImage(i4);
                                    member4.setVisible(true);
                                    member4.setText("Booked by: " +nickname);                                                                         
                                    }
                                    p4 = false;
                                break;
                                case "p4":
                                    if(inTheMemberBookings(memberBooking,timeBegin,"p4")){
                                        i5 = new Image("/img/pista2labuenatupista.jpg");
                                        pista5.setImage(i5);
                                    
                                    }
                                    else{                                
                                    i5 = new Image("/img/pista2labuenaBooked.jpg");
                                    pista5.setImage(i5);
                                    member5.setVisible(true);
                                    member5.setText("Booked by: " +nickname);                                     
                                    }
                                    p5 = false;
                                break; 
                                case "p5":
                                    if(inTheMemberBookings(memberBooking,timeBegin,"p5")){
                                        i6 = new Image("/img/mario tennislabuenatupista.jpg");
                                        pista6.setImage(i6);
                                    
                                    }
                                    else{                                    
                                    i6 = new Image("/img/pistaMarioReservada.jpg");
                                    pista6.setImage(i6);
                                    member6.setVisible(true);
                                    member6.setText("Booked by: " +nickname);                                     
                                    }
                                    p6 = false;
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
        
            if(ochoanueve.isSelected()){
                timeBegin = LocalTime.of(20,0);
                timeEnd = LocalTime.of(21, 0);
            
            } 
            
             if(nueveadiezpm.isSelected()){
                timeBegin = LocalTime.of(20,0);
                timeEnd = LocalTime.of(21, 0);
            
            }         
        
        
        
        
        
        
        
        });
        
        
        
        

        
         

        

        
        
       MenuItems.selectedToggleProperty().addListener((observable, oldvalue, newvalue)->{
                System.out.println("Que esta pasando");
                    l = club.getForDayBookings(daySelected);
                    books = FXCollections.observableArrayList(l);
                   
//poner nombre a las pistas                    
                    List<Court> courts = club.getCourts();
                    for(int i = 0; i <6; i++){
                       courts.get(i).setName("p"+i);

                    }
                    if(member != null){
                    memberBooking = club.getUserBookings(member.getNickName());
                    }
               else{memberBooking = null;}
                    
//poner a true todas las variables otra vez
                    p1 = true;
                    p2 = true;
                    p3 = true;
                    p4 = true;
                    p5 = true;
                    p6 = true;
                    
//para reiniciar los textos 
                        member1.setVisible(false);
                        member2.setVisible(false);
                        member3.setVisible(false);
                        member4.setVisible(false);
                        member5.setVisible(false);
                        member6.setVisible(false);
                    

//poner las imagenes al sitio                    
                    Image i1 = new Image("/img/wiilabuena.png");
                    pista1.setImage(i1);
                    Image i2 = new Image("/img/pista5labuena.jpg");
                    pista2.setImage(i2);
                    Image i3 = new Image("/img/pista6labuena.jpeg");
                    pista3.setImage(i3);
                    Image i4 = new Image("/img/pista3labuena.jpg");
                    pista4.setImage(i4);
                    Image i5 = new Image("/img/pista2labuena.jpg");
                    pista5.setImage(i5);
                    Image i6 = new Image("/img/mario tennislabuena.jpg");
                    pista6.setImage(i6);                    
                    for(int i =0; i < l.size(); i++){
                        String courtname = books.get(i).getCourt().getName();
                        LocalTime begin = books.get(i).getFromTime();
                        String nickname = books.get(i).getMember().getNickName();
                        if(begin.equals(timeBegin)){
                            System.out.println("Hasta aqui bien");
                            switch(courtname){
                                case "p0":
                                    
                                    if(inTheMemberBookings(memberBooking,timeBegin,"p0")){
                                        i1 = new Image("/img/wiilabuenatupista.png");
                                        pista1.setImage(i1);
                                    
                                    }
                                    else{i1 = new Image("/img/wiilabuenaBooked.png");
                                    pista1.setImage(i1);
                                    member1.setVisible(true);
                                    member1.setText("Booked by: " +nickname);                                     
                                    }
                                    p1 = false;
                                break;
                                case "p1":
                                    if(inTheMemberBookings(memberBooking,timeBegin,"p1")){
                                        i2 = new Image("/img/pista5labuenatupista.jpg");
                                        pista2.setImage(i2);
                                    
                                    }
                                    else{                                    
                                    i2 = new Image("/img/pista5labuenaBooked.jpg");
                                    pista2.setImage(i2);
                                    member2.setVisible(true);
                                    member2.setText("Booked by: " +nickname);                                     
                                    }
                                    p2 = false;
                                break;
                                case "p2":
                                    if(inTheMemberBookings(memberBooking,timeBegin,"p2")){
                                        i3 = new Image("/img/pista6labuenatupista.jpeg");
                                        pista3.setImage(i3);
                                    
                                    }
                                    else{                                    
                                    i3 = new Image("/img/pista6labuenaBooked.jpeg");
                                    pista3.setImage(i3);
                                    member3.setVisible(true);
                                    member3.setText("Booked by: " +nickname);                                     
                                    }
                                    p3 = false;
                                break;
                                case "p3":
                                    if(inTheMemberBookings(memberBooking,timeBegin,"p3")){
                                        i4 = new Image("/img/pista3tupista.jpg");
                                        pista4.setImage(i4);
                                    
                                    }
                                    else{                                    
                                    i4 = new Image("/img/pista3labuenaBooked.jpg");
                                    pista4.setImage(i4);
                                    member4.setVisible(true);
                                    member4.setText("Booked by: " +nickname);                                     
                                    }
                                    p4 = false;
                                break;
                                case "p4":
                                    if(inTheMemberBookings(memberBooking,timeBegin,"p4")){
                                        i5 = new Image("/img/pista2labuenatupista.jpg");
                                        pista5.setImage(i5);
                                         
                                    
                                    }
                                    else{                                
                                    i5 = new Image("/img/pista2labuenaBooked.jpg");
                                    pista5.setImage(i5);
                                    member5.setVisible(true);
                                    member5.setText("Booked by: " +nickname);                                    
                                    }
                                    p5 = false;
                                break; 
                                case "p5":
                                    if(inTheMemberBookings(memberBooking,timeBegin,"p5")){
                                        i6 = new Image("/img/mario tennislabuenatupista.jpg");
                                        pista6.setImage(i6);
                                    
                                    }
                                    else{                                    
                                    i6 = new Image("/img/pistaMarioReservada.jpg");
                                    pista6.setImage(i6);
                                    member6.setVisible(true);
                                    member6.setText("Booked by: " +nickname);                                    
                                    }
                                    p6 = false;
                                break;                                 
                            }
                        }
                    
                    
                    
                
                }
        
        
        
        });
        

        
        
        

        //---------------------------------------------------------------------
        


        
        Image image1 = new Image("/img/wiilabuena.png");
        pista1.setImage(image1);
        Image image2 = new Image("/img/pista5labuena.jpg");
        pista2.setImage(image2);
        Image image3 = new Image("/img/pista6labuena.jpeg");
        pista3.setImage(image3);
        Image image4 = new Image("/img/pista3labuena.jpg");
        pista4.setImage(image4);
        Image image5 = new Image("/img/pista2labuena.jpg");
        pista5.setImage(image5);
        Image image6 = new Image("/img/mario tennislabuena.jpg");
        pista6.setImage(image6);
       
        accountProfile.setUnderline(false);
        
        informationMessage.visibleProperty().bind(nueveadiezpm.selectedProperty());
        
        if(member != null){
            accountProfile.setText("Check here your bookings "+member.getNickName()+"!"); 
        }
        else{
            accountProfile.setText("You want to make a reservation? Log In!");
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
        
        if(member == null){
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
            FXMLLoader loader = new  FXMLLoader(getClass().getResource("Bookings.fxml"));
            Parent root = loader.load();
            Scene nueva = new Scene(root);
            Node n = (Node) homeButton;
            Stage stage = (Stage) n.getScene().getWindow();
            stage.setScene(nueva);
            stage.setResizable(true);
            stage.show();
        
        
        
        
        
        }
        
    
    }
    


    @FXML
    private void reservaPista1(MouseEvent event) throws ClubDAOException{
        Alert a;
        System.out.print("Hola hola holaaa");
        c = club.getCourt("p0");        
        MaxBookingDuration maxb = new MaxBookingDuration(daySelected, c,timeBegin);
        int max1 = containHours(maxBookingsCourts, maxb);

        
        if(p1 && max1 <= 2 && member != null && MenuItems.getSelectedToggle() != null ){
            if(member.getCreditCard().equals("")){
            club.registerBooking(now, daySelected, timeBegin,false, c, member);
            }
            else{
            club.registerBooking(now, daySelected, timeBegin,true, c, member);            
            }            a = new Alert(AlertType.INFORMATION);
            a.setTitle("Hola guapo");
            a.setHeaderText("Book confirmation");
            a.setContentText("Your book has been realised correctly");
            a.showAndWait();
            Image mismuertos = new Image("/img/wiilabuenatupista.png");
            pista1.setImage(mismuertos);
        
        }
        else if(member == null){
            a = new Alert(AlertType.ERROR);
            a.setTitle("No member registered");
            a.setHeaderText("Member resgistry error");
            a.setContentText("You need to register in order to make your book");
            a.showAndWait();
        }
        else if(max1 > 2){
            a = new Alert(AlertType.ERROR);
            a.setTitle("Maximum hours exceeded");
            a.setHeaderText("Hours exceeded error");
            a.setContentText("You have exceeded the maximum hours permitted for this court");
            a.showAndWait();
        
        
        }
        else if(!p1){
                a = new Alert(AlertType.ERROR);
                a.setTitle("Court already booked");
                a.setHeaderText("Court booked error");
                a.setContentText("This court is not available for the moment");
                a.showAndWait();
        
        }
        else{
            a = new Alert(AlertType.ERROR);
            a.setTitle("No hour selected error");
            a.setHeaderText("No hour selected error");
            a.setContentText("You must select an hour in order to make your book");
            a.showAndWait();
        }
    }

    @FXML
    private void reservaPista4(MouseEvent event) throws ClubDAOException {
        Alert a;
        c = club.getCourt("p3");
        System.out.print("Hola hola holaaa");
        MaxBookingDuration maxb = new MaxBookingDuration(daySelected, c,timeBegin);
        int max4 = containHours(maxBookingsCourts, maxb);        
       
        if(p4 && max4 <= 2 && member != null && MenuItems.getSelectedToggle() != null){
            if(member.getCreditCard().equals("")){
            club.registerBooking(now, daySelected, timeBegin,false, c, member);
            }
            else{
            club.registerBooking(now, daySelected, timeBegin,true, c, member);            
            }            a = new Alert(AlertType.INFORMATION);
            a.setTitle("Hola guapo");
            a.setHeaderText("Book confirmation");
            a.setContentText("Your book has been realised correctly");
            a.showAndWait();
            Image locaconmitigre = new Image("/img/pista3labuenatupista.jpg");
            pista4.setImage(locaconmitigre);
            p4 = false;            
        
        }
        else if(member == null){
            a = new Alert(AlertType.ERROR);
            a.setTitle("No member registered");
            a.setHeaderText("Member resgistry error");
            a.setContentText("You need to register in order to make your book");
            a.showAndWait();

        }
        else if (max4 > 2){
            a = new Alert(AlertType.ERROR);
            a.setTitle("Maximum hours exceeded");
            a.setHeaderText("Hours exceeded error");
            a.setContentText("You have exceeded the maximum hours permitted for this court");
            a.showAndWait();
        }
        else if(!p4){
                a = new Alert(AlertType.ERROR);
                a.setTitle("Court already booked");
                a.setHeaderText("Court booked error");
                a.setContentText("This court is not available for the moment");
                a.showAndWait();
        }        
        else{            a = new Alert(AlertType.ERROR);
            a.setTitle("No hour selected error");
            a.setHeaderText("No hour selected error");
            a.setContentText("You must select an hour in order to make your book");
            a.showAndWait();
        }
    
    
    }

    @FXML
    private void reservaPista2(MouseEvent event) throws ClubDAOException {
        Alert a;
        c = club.getCourt("p1");
        System.out.print("Hola hola holaaa");
        MaxBookingDuration maxb = new MaxBookingDuration(daySelected, c,timeBegin);
        int max2 = containHours(maxBookingsCourts, maxb);        
      
        if(p2 && max2 <= 2 && member != null && MenuItems.getSelectedToggle() != null){
            if(member.getCreditCard().equals("")){
            club.registerBooking(now, daySelected, timeBegin,false, c, member);
            }
            else{
            club.registerBooking(now, daySelected, timeBegin,true, c, member);            
            }            a = new Alert(AlertType.INFORMATION);
            a.setTitle("Hola guapo");
            a.setHeaderText("Book confirmation");
            a.setContentText("Your book has been realised correctly");
            a.showAndWait();
            Image loca = new Image("/img/pista5labuenatupista.jpg");
            pista2.setImage(loca);
            p2 = false;
        
        }
        else if(member == null){
            a = new Alert(AlertType.ERROR);
            a.setTitle("No member registered");
            a.setHeaderText("Member resgistry error");
            a.setContentText("You need to register in order to make your book");
            a.showAndWait();
        }
        else if(max2 > 2){
            a = new Alert(AlertType.ERROR);
            a.setTitle("Maximum hours exceeded");
            a.setHeaderText("Hours exceeded error");
            a.setContentText("You have exceeded the maximum hours permitted for this court");
            a.showAndWait();
        }
        else if(!p2){
                a = new Alert(AlertType.ERROR);
                a.setTitle("Court already booked");
                a.setHeaderText("Court booked error");
                a.setContentText("This court is not available for the moment");
                a.showAndWait();}        
        else{            a = new Alert(AlertType.ERROR);
            a.setTitle("No hour selected error");
            a.setHeaderText("No hour selected error");
            a.setContentText("You must select an hour in order to make your book");
            a.showAndWait();
        
        }
    
    
    }

    @FXML
    private void reservaPista5(MouseEvent event) throws ClubDAOException {
        court = "p4";
        c = club.getCourt(court);
        Alert a;
        MaxBookingDuration maxb = new MaxBookingDuration(daySelected, c,timeBegin);
        int max5 = containHours(maxBookingsCourts, maxb);        
        
       if(p5 && max5 <= 2 && member != null && MenuItems.getSelectedToggle() != null){
            if(member.getCreditCard().equals("")){
            club.registerBooking(now, daySelected, timeBegin,false, c, member);
            }
            else{
            club.registerBooking(now, daySelected, timeBegin,true, c, member);            
            }            a = new Alert(AlertType.INFORMATION);
            a.setTitle("Hola guapo");
            a.setHeaderText("Book confirmation");
            a.setContentText("Your book has been realised correctly");
            a.showAndWait();
            Image loca = new Image("/img/pista2labuenatupista.jpg");
            pista5.setImage(loca);
            p5 = false;
        
        }
        else if(member == null){
            a = new Alert(AlertType.ERROR);
            a.setTitle("No member registered");
            a.setHeaderText("Member resgistry error");
            a.setContentText("You need to register in order to make your book");
            a.showAndWait();
        }
        else if(max5 > 2){
            a = new Alert(AlertType.ERROR);
            a.setTitle("Maximum hours exceeded");
            a.setHeaderText("Hours exceeded error");
            a.setContentText("You have exceeded the maximum hours permitted for this court");
            a.showAndWait();
        }
        else if(!p5){
                a = new Alert(AlertType.ERROR);
                a.setTitle("Court already booked");
                a.setHeaderText("Court booked error");
                a.setContentText("This court is not available for the moment");
                a.showAndWait();
        }
        else{
            a = new Alert(AlertType.ERROR);
            a.setTitle("No hour selected error");
            a.setHeaderText("No hour selected error");
            a.setContentText("You must select an hour in order to make your book");
            a.showAndWait();
        
        }
    
    
    }

    @FXML
    private void reservaPista3(MouseEvent event) throws ClubDAOException {
        court = "p2";
        c = club.getCourt(court);
        Alert a;
        MaxBookingDuration maxb = new MaxBookingDuration(daySelected, c,timeBegin);
        int max3 = containHours(maxBookingsCourts, maxb);        
       
       if(p3 && max3 <= 2 && member != null && MenuItems.getSelectedToggle() != null){
            if(member.getCreditCard().equals("")){
            club.registerBooking(now, daySelected, timeBegin,false, c, member);
            }
            else{
            club.registerBooking(now, daySelected, timeBegin,true, c, member);            
            }            a = new Alert(AlertType.INFORMATION);
            a.setTitle("Hola guapo");
            a.setHeaderText("Book confirmation");
            a.setContentText("Your book has been realised correctly");
            a.showAndWait();
            Image loca = new Image("/img/pista6labuenatupista.jpeg");
            pista3.setImage(loca);
            p3 = false;
        
        }
        else if(member == null){
            a = new Alert(AlertType.ERROR);
            a.setTitle("No member registered");
            a.setHeaderText("Member resgistry error");
            a.setContentText("You need to register in order to make your book");
            a.showAndWait();
        }
        else if(max3 > 2){
            a = new Alert(AlertType.ERROR);
            a.setTitle("Maximum hours exceeded");
            a.setHeaderText("Hours exceeded error");
            a.setContentText("You have exceeded the maximum hours permitted for this court");
            a.showAndWait();
        }
        else if(!p3){
                a = new Alert(AlertType.ERROR);
                a.setTitle("Court already booked");
                a.setHeaderText("Court booked error");
                a.setContentText("This court is not available for the moment");
                a.showAndWait();
        }
        else{
            a = new Alert(AlertType.ERROR);
            a.setTitle("No hour selected error");
            a.setHeaderText("No hour selected error");
            a.setContentText("You must select an hour in order to make your book");
            a.showAndWait();
        
        }
    
    
    }

    @FXML
    private void reservaPista6(MouseEvent event) throws ClubDAOException {
        court = "p5";
        c = club.getCourt(court);
        Alert a;
        MaxBookingDuration maxb = new MaxBookingDuration(daySelected, c, timeBegin);
        int max6 = containHours(maxBookingsCourts,maxb);
        System.out.println("Esto es lo que esta fallando" +max6);
       if(p6 && max6 <= 2 && member != null && MenuItems.getSelectedToggle() != null){
            if(member.getCreditCard().equals("")){
            club.registerBooking(now, daySelected, timeBegin,false, c, member);
            }
            else{
            club.registerBooking(now, daySelected, timeBegin,true, c, member);            
            }
            a = new Alert(AlertType.INFORMATION);
            a.setTitle("Book completed");
            a.setHeaderText("Book confirmation");
            a.setContentText("Your book has been realised correctly");
            a.showAndWait();
            Image loca = new Image("/img/mario tennislabuenatupista.jpg");
            pista6.setImage(loca);
            p6 = false;
        
        }
        else if(member == null){
            a = new Alert(AlertType.ERROR);
            a.setTitle("No member registered");
            a.setHeaderText("Member resgistry error");
            a.setContentText("You need to register in order to make your book");
            a.showAndWait();
        }
        else if(max6 > 2){
            a = new Alert(AlertType.ERROR);
            a.setTitle("Maximum hours exceeded");
            a.setHeaderText("Hours exceeded error");
            a.setContentText("You have exceeded the maximum hours permitted for this court");
            a.showAndWait();
        }
        else if(!p6){
                a = new Alert(AlertType.ERROR);
                a.setTitle("Court already booked");
                a.setHeaderText("Court booked error");
                a.setContentText("This court is not available for the moment");
                a.showAndWait();        
        }else{
            a = new Alert(AlertType.ERROR);
            a.setTitle("No hour selected error");
            a.setHeaderText("No hour selected error");
            a.setContentText("You must select an hour in order to make your book");
            a.showAndWait();
        }
    
    }
    
    
    protected int containHours(List<MaxBookingDuration>  l, MaxBookingDuration m){
        if(member != null){
            memberBooking = club.getUserBookings(member.getNickName());
        }
        else{memberBooking = null; return 6;}
        for(int i = 0; i < memberBooking.size(); i++){
            Booking b1 = memberBooking.get(i);
            System.out.println("Entra al bucle");
            for(int j = i+1; j < memberBooking.size(); j++){
                Booking b2 = memberBooking.get(j);
                if(b1.getCourt().equals(b2.getCourt()) && b2.getCourt().equals(m.getCourt())){
                    System.out.println("Entra en el primer if");
                    if(b1.getMadeForDay().equals(b2.getMadeForDay()) && b1.getMadeForDay().equals(m.getDay())){
                        System.out.println("Entra en el segundo if");
                       if(Math.abs(b1.getFromTime().getHour()-b2.getFromTime().getHour()) == 2  &&
                                Math.abs(b1.getFromTime().getHour()- m.getHoursBooked().getHour()) == 1
                                    && Math.abs(b2.getFromTime().getHour() - m.getHoursBooked().getHour()) == 1){
                            System.out.println("La locura en todo su explendor");
                            return 52;
                       }
                       else if(Math.abs(b1.getFromTime().getHour() - b2.getFromTime().getHour()) == 1 &&
                               (Math.abs(b1.getFromTime().getHour() - m.getHoursBooked().getHour()) == 1
                               || Math.abs(b2.getFromTime().getHour()-m.getHoursBooked().getHour())== 1)){
                               return 69;
                       
                       }
                        

                        }
                    
                    }
                
                }
            }
        
        
        
        return 0;

    }
    
    protected boolean inTheMemberBookings(List<Booking> memberBooking,LocalTime timeBegin,String courtName){
        
        if(memberBooking == null){return false;}
        Court courtxd = club.getCourt(courtName);
        for(int i = 0; i < memberBooking.size(); i++){
            Booking b = memberBooking.get(i);
            if(b.getFromTime().equals(timeBegin) && b.getCourt().equals(courtxd)){
                return true;
            }
        
        
        }
        return false;
    
    }

    
 
}








