import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        String serverAddress = "localhost"; // Indirizzo del server
        int serverPort = 9999; // Porta del server

        try (Socket socket = new Socket(serverAddress, serverPort);
             BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             PrintWriter writer = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()), true);
             Scanner scanner = new Scanner(System.in)) {

            System.out.print("Inserisci 'asc' per ordine crescente o 'desc' per ordine decrescente: ");
            String orderType = scanner.nextLine().trim();

            System.out.print("Inserisci una lista di numeri separati da virgola: ");
            String listaNumeri = scanner.nextLine().trim();

            // Invio al server
            writer.println(orderType + ":" + listaNumeri);
            System.out.println("Client ha inviato: " + orderType + ":" + listaNumeri);

            // Lettura della risposta
            String risposta = reader.readLine();
            System.out.println("Risultato ricevuto dal server: " + risposta);

        } catch (Exception e) {
            System.err.println("Errore di connessione al server: " + e.getMessage());
        }
    }
}
