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

    private List<TimeSlotMenuItem> timeSlots = new ArrayList<>(); //Para varias columnas List<List<TimeSolt>>

    private ObjectProperty<TimeSlotMenuItem> timeSlotSelected;
    
    private LocalDate daySelected;
    @FXML
    private DatePicker day;
    @FXML
    private SplitMenuButton splitMenuButtons;
    
    private Connection con;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        try{
        Club club = Club.getInstance();
        
        con = connectSqlite("/Libraries/sqlite-jdb-3.41.2.1.jar");
        }
        catch(Exception e){}
        
        timeSlotSelected = new SimpleObjectProperty<>();
        //cambia los SlotTime al cambiar de dia
        day.valueProperty().addListener((a, b, c) -> {
            setTimesSlotsMenuItem(c);
        });
        
        //---------------------------------------------------------------------
        //inicializa el DatePicker al dia actual
        day.setValue(LocalDate.now());        

        //---------------------------------------------------------------------
        // pinta los SlotTime en el grid
        setTimesSlotsMenuItem(day.getValue());

        
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
        /*
        if(m == null){
            accountProfile.setText(m.getNickName()); 
        }
        else{
            accountProfile.setText("You want to make a reservation? Sign Up!");
        }
        */
       

    
    
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

    
    
    }

    @FXML
    private void reservaPista2(MouseEvent event) {
        court = "court 2";

    
    
    }

    @FXML
    private void reservaPista5(MouseEvent event) {
        court = "court 5";

    
    
    }

    @FXML
    private void reservaPista3(MouseEvent event) {
        court = "court 3";

    
    
    }

    @FXML
    private void reservaPista6(MouseEvent event) {
        court = "court 6";

    
    
    }
    
    private void setTimesSlotsMenuItem(LocalDate date){
        timeSlotSelected.setValue(null);
        
        splitMenuButtons.getItems().clear();
        timeSlots.clear();
        
        for(LocalDateTime startTime = date.atTime(firstSlotStart);
                !startTime.isAfter(date.atTime(lastSlotStart));
                startTime = startTime.plus(slotLength)){
            
            TimeSlotMenuItem timeSlot = new TimeSlotMenuItem(startTime, slotLength);
            timeSlots.add(timeSlot);
            
            registerHandlers(timeSlot);
        }
        
    
    
    
    }
    
    private void registerHandlers(TimeSlotMenuItem timeSlot){
    

        timeSlot.getView().setOnMousePressed((MouseEvent event) -> {
            //---------------------------------------------slot----------------------------
            //solamente puede estar seleccionado un slot dentro de la lista de slot
            timeSlots.forEach(slot -> {
                slot.setSelected(slot == timeSlot);
            });

            //----------------------------------------------------------------
            //actualizamos el label Dia-Hora, esto es ad hoc,  para mi diseño
            timeSlotSelected.setValue(timeSlot);
            //----------------------------------------------------------------
            // si es un doubleClik  vamos a mostrar una alerta y cambiar el estilo de la celda
            if (event.getClickCount() > 1) {
                Alert alerta = new Alert(Alert.AlertType.CONFIRMATION);
                alerta.setTitle("SlotTime");
                alerta.setHeaderText("Confirma la selección");
                alerta.setContentText("Has seleccionat: "
                        + timeSlot.getDate().format(DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT)) + ", "
                        + timeSlot.getTime().format(DateTimeFormatter.ofLocalizedTime(FormatStyle.SHORT)));
                Optional<ButtonType> result = alerta.showAndWait();
                if (result.isPresent() && result.get() == ButtonType.OK) {
                    ObservableList<String> styles = timeSlot.getView().getStyleClass();
                    if (styles.contains("time-slot")) {
                        styles.remove("time-slot");
                        styles.add("time-slot-libre");
                    } else {
                        styles.remove("time-slot-libre");
                        styles.add("time-slot");
                    }
                }
            }
        });
    }
    
    
    
    
    
    
    
    
public class TimeSlotMenuItem {

private final LocalDateTime start;
    private final Duration duration;
    protected final Pane view;

    private final BooleanProperty selected = new SimpleBooleanProperty();

    private final PseudoClass SELECTED_PSEUDO_CLASS =
            PseudoClass.getPseudoClass("selected");

    public final BooleanProperty selectedProperty() {
        return selected;
    }

    public final boolean isSelected() {
        return selectedProperty().get();
    }

    public final void setSelected(boolean selected) {
        selectedProperty().set(selected);
    }

    public TimeSlotMenuItem(LocalDateTime start, Duration duration) {
        this.start = start;
        this.duration = duration;
        view = new Pane();
        view.getStyleClass().add("time-slot");

        selectedProperty().addListener((obs, wasSelected, isSelected) ->
                view.pseudoClassStateChanged(SELECTED_PSEUDO_CLASS, isSelected));

    }

    public LocalDateTime getStart() {
        return start;
    }

    public LocalTime getTime() {
        return start.toLocalTime();
    }

    public LocalDate getDate() {
        return start.toLocalDate();
    }

    public Duration getDuration() {
        return duration;
    }

    public Pane getView() {
        return view;
    }

    }

}








