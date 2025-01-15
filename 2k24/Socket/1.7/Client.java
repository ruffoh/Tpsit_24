import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        String host = "localhost";
        int port = 9999;

        try (Socket socket = new Socket(host, port)) {
            System.out.println("Connessione al server " + host + " sulla porta " + port);

            // input da tastiera
            Scanner scanner = new Scanner(System.in);
            System.out.print("Inserisci una stringa: ");
            String parola = scanner.nextLine();

            System.out.print("Inserisci un numero: ");
            int numero;
            try {
                numero = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.err.println("Input non valido per il numero. Uscita.");
                return;
            }

            // invio dati -> server
            PrintWriter writer = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()), true);
            writer.println(parola + "," + numero);
            System.out.println("Dati inviati al server: " + parola + "," + numero);

            // lettura  risposta del server
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String risposta = reader.readLine();

            if (risposta != null && !risposta.isEmpty()) {
                System.out.println("Risposta ricevuta dal server: " + risposta);
            } else {
                System.out.println("Nessuna risposta ricevuta dal server.");
            }

        } catch (Exception e) {
            System.err.println("Errore nella comunicazione con il server: " + e.getMessage());
        }
    }
}