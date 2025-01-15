import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Random;

public class Server {
    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(9999)) {
            System.out.println("Server avviato e in attesa di connessioni...");

            while (true) {
                try (Socket socket = serverSocket.accept()) {
                    System.out.println("Connessione accettata da: " + socket.getInetAddress());

                    // Lettura della stringa inviata  client
                    BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                    String parola = reader.readLine();

                    if (parola == null || parola.isEmpty()) {
                        System.out.println("Non ho ricevuto nessun dato");
                    } else {
                        System.out.println("Server ha ricevuto: " + parola);

                        //  numero casuale
                        Random random = new Random();
                        int numeroRandom = random.nextInt(100); // Numero casuale tra 0 e 99

                        //   risposta
                        String risposta = parola + " " + numeroRandom;

                        // Invio della risposta  
                        PrintWriter writer = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()), true);
                        writer.println(risposta);
                        System.out.println("Risposta inviata al client: " + risposta);
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
