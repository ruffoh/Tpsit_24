import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class server {
    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(9999)) {
            System.out.println("Server avviato e in attesa di connessioni...");

            while (true) {
                try (Socket socket = serverSocket.accept()) {
                    System.out.println("Connessione accettata da: " + socket.getInetAddress());

                    BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                    String input = reader.readLine();

                    if (input == null || input.isEmpty()) {
                        System.out.println("Non ho ricevuto nessun dato.");
                    } else {
                        System.out.println("Server ha ricevuto: " + input);

                        // Calcolo della somma
                        String[] numeri = input.split(",");
                        int somma = 0;
                        for (String numero : numeri) {
                            somma += Integer.parseInt(numero.trim());
                        }

                        // Invio della risposta al client
                        PrintWriter writer = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()), true);
                        writer.println(somma);
                        System.out.println("Somma inviata al client: " + somma);
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
