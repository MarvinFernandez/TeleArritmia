/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package socket;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import pojo.Patient;

/**
 *
 * @author Levi
 */
public class sendPatient implements Runnable {
    Socket socket;
    Patient patient;
    ObjectInputStream objectInputStream=null;
    
    public sendPatient(Socket socket) {
        this.socket = socket;
    }

    
    @Override
    public void run() {
        InputStream inputStream = null;
        Object tmp;
        try {
            
            inputStream = socket.getInputStream();
            objectInputStream= new ObjectInputStream(inputStream);
            
            try {
                while ((tmp = objectInputStream.readObject()) != null) {
                    
                    Patient patient= (Patient) tmp;
                    System.out.println("patient"+patient.toString());
                    
                }
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(sendPatient.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (IOException ex) {
            Logger.getLogger(sendPatient.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            releaseResourcesClient(objectInputStream, socket);
        }

    }

    private static void releaseResourcesClient(ObjectInputStream inputStream, Socket socket) {
        try {
            inputStream.close();
        } catch (IOException ex) {
            Logger.getLogger(sendPatient.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            socket.close();
        } catch (IOException ex) {
            Logger.getLogger(sendPatient.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
