import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {
    public static void main(String[] args) {
        // Indirizzo del server e porta
        String serverAddress = "localhost";
        int port = 9999;
        while(true){
        try (Socket socket = new Socket(serverAddress, port)) {
            // Creazione di BufferedReader per leggere l'input dell'utente
            BufferedReader userInputReader = new BufferedReader(new InputStreamReader(System.in));

            // Creazione di BufferedReader per leggere la risposta dal server
            BufferedReader serverReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            // Creazione di PrintWriter per inviare la richiesta al server
            PrintWriter writer = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()), true);

            System.out.println("Inserisci una data nel formato GG/MM/AAAA:");

            // Leggere la data dall'utente
            String inputDate = userInputReader.readLine();

            // Inviare la data al server
            writer.println(inputDate);

            // Ricevere  risposta  
            String response = serverReader.readLine();

            //  risposta del server
            System.out.println("Risposta dal server: " + response);

        } catch (Exception e) {
            System.err.println("Errore nella connessione al server: " + e.getMessage());
        }
    }
    }
}
