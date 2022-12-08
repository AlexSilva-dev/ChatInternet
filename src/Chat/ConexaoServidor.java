/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Chat;

import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author alexaleq321
 */
public class ConexaoServidor {
    
    ServerSocket servidor = null;
    Socket cliente = null;
    ObjectOutputStream outFromClient = null;
    ObjectInputStream inputFromClient = null;

    public ConexaoServidor() throws Exception {
        servidor = new ServerSocket(12345);
        
        
    }
    
    public String clientWait() throws IOException{
        cliente = servidor.accept();
        String connClient = "Cliente conectado: " + cliente.getInetAddress().getHostAddress();
        outFromClient = new ObjectOutputStream(cliente.getOutputStream());
        inputFromClient = new ObjectInputStream(cliente.getInputStream());
        return connClient;
        
    }
    
    public String msgRead(){
        String msg;
        try {
            msg = inputFromClient.readLine();
        } catch (IOException ex) {
            System.err.println("Erro msgRead: " + ex);
            return null;
        }
        return msg;
    }
    public void ConfirmMsg() throws Exception{
        String msg = "Estou on";
        this.outFromClient = new ObjectOutputStream(cliente.getOutputStream());
        this.outFromClient.flush();
        this.outFromClient.writeChars(msg);
        this.outFromClient.close();
        
    }
    
    
}
