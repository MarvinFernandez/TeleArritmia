/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package telearritmia;

import BITalino.BITalinoException;
import BITalino.Frame;
import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Accordion;
import javafx.scene.control.Button;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.control.TextField;
import javax.bluetooth.RemoteDevice;
import pojo.Patient;

/**
 * FXML Controller class
 *
 * @author danielmarchan
 */
public class FXMLVistaBitalino2Controller implements Initializable {

    @FXML
    Button recordBut;
    @FXML
    Button but_SaveSend;
    @FXML 
    Button but_Upload;
    @FXML
    ProgressIndicator indicator;
    @FXML
    TextField textMacAddress;
    @FXML
    Accordion steps;
    
    
   
    @FXML
    private void savePatient(ActionEvent event){
        String name = Main.patient.getName();
        String surname = Main.patient.getSurname();
        String filename = name.concat(surname);
        File file = new File(filename.concat(".txt"));
        Main.persistence.guardar(file, Main.patient);
        System.out.println("saved");
    }
    
    @FXML
    private void loadPatient(ActionEvent event){
        String nameFile = "DanielMarchan.txt"; //esto habria que cambiar, el doctor deberia meter el nombre del archivo a cargar
        File file = new File(nameFile);
        Patient p = new Patient();
            
            if(!file.exists()){
                    System.out.println("Archivo inexistente");
            }
            else        
                    try{  
                        p=Main.persistence.cargar(file);
                        System.out.println(p);
                        System.out.println("load");
                    }
                    catch(ClassNotFoundException ex){
                        System.out.println("error en la lectura intente de nuevo");
                    }       
    }
    
    
    @FXML
    private void record(ActionEvent event){
        String macAddress = textMacAddress.getText(); //You should have the MAC ADDRESS in a sticker in the Bitalino
        try {
            // Code to find Devices
            Vector<RemoteDevice> devices = Main.bitalino.findDevices();
            System.out.println(devices);
            //Sampling rate, should be 10, 100 or 1000
            int SamplingRate = 100;
            Main.bitalino.open(macAddress, SamplingRate);
            // Start acquisition on analog channels A2 and A3
            // For example, If you want A1, A3 and A4 you should use {0,2,3}
            int[] channelsToAcquire = {1, 2};
            Main.bitalino.start(channelsToAcquire);
            
            Frame[] frame;
            
            for (int j = 0; j < 30; j++) {

                //Each time read a block of 10 samples 
                int block_size=100;
                //frame should change into EMG matrix
                frame = Main.bitalino.read(block_size);

                System.out.println("size block: " + frame.length);

                //Print the samples
                for (int i = 0; i < frame.length; i++) {
                    System.out.println((j * block_size + i) + " seq: " + frame[i].seq + " "
                            + frame[i].analog[0] + " "
                            + frame[i].analog[1] + " "
                    //  + frame[i].analog[2] + " "
                    //  + frame[i].analog[3] + " "
                    //  + frame[i].analog[4] + " "
                    //  + frame[i].analog[5]
                    );

                }
            }
            //stop acquisition
            Main.bitalino.stop();
        } catch (BITalinoException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Throwable ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                //close bluetooth connection
                if (Main.bitalino != null) {
                    Main.bitalino.close();
                }
            } catch (BITalinoException ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    
    }
    
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
