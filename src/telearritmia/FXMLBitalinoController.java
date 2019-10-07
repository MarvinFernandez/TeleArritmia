/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package telearritmia;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Accordion;
import javafx.scene.control.Label;
import javafx.scene.control.TitledPane;

/**
 * FXML Controller class
 *
 * @author marvi
 */
public class FXMLBitalinoController implements Initializable {

    
    @FXML
    private Label label;
    
    @FXML
    private Accordion steps;
    @FXML
    private TitledPane step1;
    @FXML
    private TitledPane step2;
    @FXML
    private TitledPane step3;
    
    
    @FXML
    private void macAdresse(ActionEvent event) {
        System.out.println("You clicked me motherfucker");
        label.setText("Hello Marvin!");
    }
    
    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
