/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Chat;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author alexaleq321
 */
public class ConnectionClient {

    private Socket socketServer = null;
    private ObjectInputStream inputFromServer = null;
    private ObjectOutputStream outFromServer = null;

    ConnectionClient(String addressServer, int portServer) throws IOException {

        socketServer = new Socket(addressServer, portServer);
        inputFromServer = new ObjectInputStream(socketServer.getInputStream());
        outFromServer = new ObjectOutputStream(socketServer.getOutputStream());
        
    }
    
    public void msgWrite(String msg)throws IOException{
        outFromServer.flush();
        outFromServer.writeChars(msg);
        
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
