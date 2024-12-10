import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

public class IntClient {
    public static void main(String[] args) {
        try (Socket socket = new Socket("127.0.0.1", 9999)) {
            System.out.println("Connessione al server stabilita");

            String parola = "negro";

            // Invio della parola al server
            PrintWriter writer = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()), true);
            writer.println(parola);
            System.out.println("Client ha inviato la parola: " + parola);

            // Lettura della risposta dal server
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String risposta = reader.readLine();
            System.out.println("Risposta ricevuta dal server: " + risposta);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
