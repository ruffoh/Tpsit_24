# **Codice Server (IntServer.java)**

```java
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class IntServer {
    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(9999)) {
            System.out.println("Server in ascolto...");

            while (true) {
                try (Socket socket = serverSocket.accept()) {
                    System.out.println("Connessione accettata da: " + socket.getInetAddress());

                    // Lettura dei dati dal client
                    BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                    String ricevuto = reader.readLine();

                    if (ricevuto == null || ricevuto.isEmpty()) {
                        System.out.println("Nessun dato ricevuto.");
                    } else {
                        System.out.println("Server ha ricevuto: " + ricevuto);

                        // Inversione della stringa e invio al client
                        String risposta = reverseString(ricevuto);
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

    public static String reverseString(String str) {
        return new StringBuilder(str).reverse().toString();
    }
}
```
