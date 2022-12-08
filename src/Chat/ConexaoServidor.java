/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Chat;

import java.io.IOException;
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
    ObjectOutputStream saida = null;

    public ConexaoServidor() throws Exception {
        servidor = new ServerSocket(12345);
    }
    
    public String clientWait() throws IOException{
        cliente = servidor.accept();
        String connClient = "Cliente conectado: " + cliente.getInetAddress().getHostAddress();
        return connClient;
        
    }
    
    public void ConfirmMsg() throws Exception{
        String msg = "Estou on";
        saida = new ObjectOutputStream(cliente.getOutputStream());
        saida.flush();
        saida.writeChars(msg);
        saida.close();
        
    }
    
    
}
