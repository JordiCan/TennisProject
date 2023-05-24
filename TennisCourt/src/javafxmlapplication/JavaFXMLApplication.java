    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxmlapplication;

import java.util.List;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.Club;
import model.Court;
import model.Member;



public class JavaFXMLApplication extends Application {
    
    public static Member member;
    
    @Override
    public void start(Stage stage) throws Exception {
        //======================================================================
        // 1- creación del grafo de escena a partir del fichero FXML


        //======================================================================
        // 2- creación de la escena con el nodo raiz del grafo de escena
        //======================================================================
        // 3- asiganación de la escena al Stage que recibe el metodo 
        //     - configuracion del stage
        //     - se muestra el stage de manera no modal mediante el metodo show()

        
        Club club = Club.getInstance();
        
        
       
 
        
       // club.setInitialData();
        
        club.addSimpleData();
        
        
        FXMLLoader loader= new  FXMLLoader(getClass().getResource("MainStage.fxml"));
        Parent root = loader.load();
        stage.setResizable(true);
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("MainStage");
        

        stage.show();
        
        
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
        
    }


    
}
