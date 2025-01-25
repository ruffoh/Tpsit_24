import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

public class client {

    public static void main(String[] args) {
        String serverAddress = "localhost"; // Indirizzo del server
        int serverPort = 9999; // Porta del server

        try (Socket socket = new Socket(serverAddress, serverPort);
             BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             PrintWriter writer = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()), true)) {

            // Invia una lista di numeri separati da virgole
            String listaNumeri = "5,10,15,20";
            writer.println(listaNumeri);
            System.out.println("Client ha inviato: " + listaNumeri);

            // Leggi la risposta dal server (la somma)
            String risposta = reader.readLine();
            System.out.println("Risposta dal server: " + risposta);

        } catch (Exception e) {
            System.err.println("Errore di connessione al server: " + e.getMessage());
        }
    }
}
