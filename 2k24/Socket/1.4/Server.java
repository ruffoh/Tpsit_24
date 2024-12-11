import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(9999)) {
            System.out.println("Server avviato e in attesa di connessioni...");

            while (true) {
                try (Socket socket = serverSocket.accept()) {
                    System.out.println("Connessione accettata da: " + socket.getInetAddress());

                    // Lettura della stringa inviata dal client
                    BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                    String parola = reader.readLine();
                    // utilizzo di un buffer per l' invio della parola

                    if (parola == null || parola.isEmpty()) {
                        System.out.println("Non ho ricevuto nessun dato");
                    } else {
                        System.out.println("Server ha ricevuto: " + parola);

                        // Inversione della stringa e invio risposta al client
                        int risposta = parola.length();
                        PrintWriter writer = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()), true);
                        writer.println(risposta);
                        System.out.println("La lunghezza dalla parola ricevuta è: " + risposta);
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
