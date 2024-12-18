import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        try (Socket socket = new Socket("127.0.0.1", 9999)) {
            System.out.println("Connessione al server stabilita");

            Scanner in = new Scanner(System.in);
            PrintWriter writer = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()), true);
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            while (true) {
                System.out.print("Inserisci un'operazione (es. 10+5) o 'exit' per uscire: ");
                String input = in.nextLine();

                if ("exit".equalsIgnoreCase(input)) {
                    System.out.println("Uscita dal client...");
                    break;
                }

                // Controlla se l'input contiene solo operazioni matematiche valide
                if (input.matches(".*[+\\-*/].*")) {
                    writer.println(input);  // Invia l'operazione al server
                    System.out.println("Client ha inviato: " + input);

                    // Legge la risposta dal server
                    String risposta = reader.readLine();
                    System.out.println("Risposta dal server: " + risposta);
                } else {
                    System.out.println("Operazione non valida. Usa solo operatori matematici (+, -, *, /).");
                }
            }

            in.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
