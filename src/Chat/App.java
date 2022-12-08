/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Chat;

import java.util.Scanner;

/**
 *
 * @author alequ
 */
public class App {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner tcl = new Scanner(System.in);
        System.out.println("Digite a opção:\n1 - Se conectar\n2 - Esperar conexão");
        String op = tcl.nextLine();
        String ip = "192.168.0.107";
        int socket = 12345;

        try {

            ConexaoServidor serv = null;
            ConnectionClient client = null;
            if (op.equals("1")) {
                client = new ConnectionClient(ip, socket);
                serv = new ConexaoServidor();
                client.msgWrite(tcl.nextLine());
            } else {
                serv = new ConexaoServidor();
                serv.clientWait();
                client = new ConnectionClient(ip, socket);
                
            }
            while (true) {
                System.out.println("Mesagem: " + serv.msgRead());
                System.out.println("\nDigite sua mensagem: ");
                client.msgWrite(tcl.nextLine());
            }

        } catch (Exception e) {
            System.err.println("Erro: " + e.getMessage());
        }

    }

}
