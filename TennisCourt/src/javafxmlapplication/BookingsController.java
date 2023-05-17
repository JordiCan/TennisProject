/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package javafxmlapplication;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import model.Booking;

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
    
    public List<Booking> arrayBooking = new ArrayList<>();
    public ObservableList<Booking> bookingList = FXCollections.observableArrayList();
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        dateColumn.setCellValueFactory(personaFila->new SimpleStringProperty(personaFila.getValue().getMadeForDay().toString()));
        hourColumn.setCellValueFactory(personaFila->new SimpleStringProperty(personaFila.getValue().getFromTime().toString()));
        courtColumn.setCellValueFactory(personaFila->new SimpleStringProperty(personaFila.getValue().getCourt().getName()));
        paidColumn.setCellValueFactory(personaFila->new SimpleStringProperty(personaFila.getValue().getPaid().toString()));
    }    
    
}
