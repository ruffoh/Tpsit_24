package SocketJava;
import java.io.IOException;

import java.net.ServerSocket;

import java.net.Socket;

public class IntClient {

    public static void main(String[] args) {
        
        try (Socket serverSocket = new Socket("127.0.0.1",9999)){
           // creo l'oggetto Socket per la connessione
           // server su local host 

           System.out.println("Connessione al server stabilita");
           int numero = (int) (Math.random() * 10);

            serverSocket.getOutputStream().write(numero);
            //scriviamo il numero generato nel flusso di output del socket, inviadolo al server
            System.out.println("Client ha inviato il numero :  "+ numero);
         

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}