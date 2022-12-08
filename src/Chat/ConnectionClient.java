/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Chat;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author alexaleq321
 */
public class ConnectionClient {

    Socket socketServer = null;
    ObjectInputStream inputFromServer = null;

    ConnectionClient(String addressServer, int portServer) throws IOException {

        socketServer = new Socket(addressServer, portServer);
        inputFromServer = new ObjectInputStream(socketServer.getInputStream());
        
    }
    
    public String msgRead(){
        String msg;
        try {
            msg = inputFromServer.readLine();
        } catch (IOException ex) {
            System.err.println("Erro msgRead: " + ex);
            return null;
        }
        return msg;
    }

}
