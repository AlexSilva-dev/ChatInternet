/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package separado;

import Chat.ConexaoServidor;

/**
 *
 * @author alexaleq321
 */
public class AplicacaoServidor {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        while (true) {
            String client;
            try {
                ConexaoServidor serv = new ConexaoServidor();
                System.out.println("Conectado com sucesso no socket!");
                while (true) {
                    client = serv.clientWait();
                    System.out.println(client);
                    serv.ConfirmMsg();
                    
                }
            } catch (Exception e) {
                System.err.println("Erro: " + e);
                continue;
            }

        }
    }
}
