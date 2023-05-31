/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package javafxmlapplication;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.binding.Bindings;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
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
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import static javafxmlapplication.JavaFXMLApplication.member;
import model.Booking;
import model.Club;
import model.ClubDAOException;

/**
 * FXML Controller class
 *
 * @author Jordi
 */
public class BookingsController implements Initializable {

    @FXML
    private TableView<Booking> TableView;
    @FXML
    private TableColumn<Booking, String> dateColumn;
    @FXML
    private TableColumn<Booking, String> hourColumn;
    @FXML
    private TableColumn<Booking, String> courtColumn;
    @FXML
    private TableColumn<Booking, String> paidColumn;
    
    @FXML
    private Button homeButton;
    @FXML
    private Label nameField;
    @FXML
    private ImageView imageMember;
    @FXML
    private Button cancelButton;
    @FXML
    private Label errorLabel;
    
   
    /**
     * Initializes the controller class.
     */
    
    public static LocalDateTime bookTime = null;
    public static LocalDateTime currentTime=LocalDateTime.now();
    
    public List<Booking> arrayBooking = new ArrayList<>();
   public ObservableList<Booking> bookingList= FXCollections.observableArrayList();
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
           // TODO
        Club c= Club.getInstance();
        arrayBooking= c.getUserBookings(member.getNickName());
        recentBookings();
        TableView.setItems(bookingList);
        nameField.setVisible(true);
        nameField.setText(member.getNickName());
        Image jiji = member.getImage();
        imageMember.setImage(jiji);
        } catch (ClubDAOException | IOException ex) {
            Logger.getLogger(BookingsController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        dateColumn.setCellValueFactory(personaFila->new SimpleStringProperty(personaFila.getValue().getMadeForDay().toString()));
        hourColumn.setCellValueFactory(personaFila->new SimpleStringProperty(personaFila.getValue().getFromTime().toString()));
        courtColumn.setCellValueFactory(personaFila->new SimpleStringProperty(personaFila.getValue().getCourt().getName()));
        paidColumn.setCellValueFactory(personaFila->new SimpleStringProperty(personaFila.getValue().getPaid().toString()));
        
        
        cancelButton.disableProperty().bind(Bindings.or(
                new SimpleBooleanProperty(bookingList.isEmpty()),Bindings.equal(TableView.getSelectionModel().selectedIndexProperty(), -1))
        );
        // new SimpleBooleanProperty(Utils.checkTime(TableView.getSelectionModel().getSelectedItem().getBookingDate())
        System.out.println(arrayBooking.size());
        
    }    

    public void recentBookings(){
        
        int c=0;
        for(int i = 0; i < arrayBooking.size(); i++,c++){
            if(c<=10&&arrayBooking.get(i).getMadeForDay().compareTo(LocalDate.now()) > 0){
                bookingList.add(arrayBooking.get(i));
            }
        }
    }
    
    @FXML
    private void goMainMenu(ActionEvent event) throws IOException {
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
    private void cancelBooking(ActionEvent event) throws ClubDAOException, IOException {
        Club c= Club.getInstance();
        
        
        LocalDate reservationDay =TableView.getSelectionModel().getSelectedItem().getMadeForDay();
        LocalDate nowDate= LocalDate.now();
        LocalTime reservationTime= TableView.getSelectionModel().getSelectedItem().getFromTime();
        LocalTime nowTime= LocalTime.now();
        
        if(reservationDay.isEqual(nowDate)){
            Alert alert = new Alert(AlertType.ERROR);
                alert.setTitle("You cannot cancel this booking"); 
                alert.setHeaderText("Dear Sir/Madam "+member.getNickName()+ " we regret to inform you that it is not possible to cancel the track you have selected, as there are less than 24 hours remaining until the scheduled time of the reservation.");
                alert.setContentText("1");
                alert.showAndWait();
        }
        else{
            if(reservationDay.isEqual(nowDate.plusDays(1))&&reservationTime.compareTo(nowTime)<=0){
                Alert alert = new Alert(AlertType.ERROR);
                alert.setTitle("You cannot cancel this booking"); 
                alert.setHeaderText("Is not possible to cancel the track you have selected, less than 24 hours remaining until the scheduled time of the reservation.");
                alert.setContentText("Any further assistance, please do not hesitate to contact us either through the email or mobile phone number provided below\n\nPhone: 878767657\nEmail: clubassitance@gmail.com");
                alert.showAndWait();
            }
            else{
                c.removeBooking(TableView.getSelectionModel().getSelectedItem());
                bookingList.remove(TableView.getSelectionModel().getSelectedItem());
                TableView.setItems(bookingList);
            }
            
        }
           
                
                
           
            
        
        
    }
    
}
