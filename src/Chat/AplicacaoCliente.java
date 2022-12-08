/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Chat;

/**
 *
 * @author alexaleq321
 */
public class AplicacaoCliente {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        String msg;
        String address = "192.168.0.106";
        int numSocket = 12345;
        try{
            ConnectionClient client = new ConnectionClient(address, numSocket);
            msg = client.msgRead();
            System.out.println(msg);
            
        }catch(Exception e){
            System.err.println("Erro: " + e);
        }
    }
    
}
