import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Server {
    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(9999)) {
            System.out.println("Server avviato e in attesa di connessioni...");

            while (true) {
                try (Socket socket = serverSocket.accept()) {
                    System.out.println("Connessione accettata da: " + socket.getInetAddress());

                    // Lettura della stringa inviata dal client
                    BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                    String input = reader.readLine();

                    PrintWriter writer = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()), true);

                    if (input == null || input.isEmpty()) {
                        writer.println("Errore: input vuoto");
                        System.out.println("Non ho ricevuto nessun dato");
                    } else {
                        System.out.println("Server ha ricevuto: " + input);

                        try {
                            // Creiamo un oggetto DateTimeFormatter per analizzare la data
                            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                            // Analizziamo la data inviata dal client
                            LocalDate date = LocalDate.parse(input, formatter);

                            // Calcoliamo la data successiva
                            LocalDate nextDay = date.plusDays(1);

                            // Inviamo la data successiva al client
                            writer.println("Data successiva: " + nextDay.format(formatter));
                            System.out.println("Data successiva: " + nextDay.format(formatter));
                        } catch (Exception e) {
                            writer.println("Errore: formato data non valido");
                            System.err.println("Errore nell'elaborazione: " + e.getMessage());
                        }
                    }
                } catch (Exception e) {
                    System.err.println("Errore nella comunicazione con il client: " + e.getMessage());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
