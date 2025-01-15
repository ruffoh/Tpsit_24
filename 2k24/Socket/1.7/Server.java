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

                    // Lettura della stringa e del numero random inviati dal client
                    BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                    String input = reader.readLine();

                    if (input == null || input.isEmpty()) {
                        System.out.println("Non ho ricevuto nessun dato");
                    } else {
                        System.out.println("Dati ricevuti dal client: " + input);

                        // Separazione della stringa e del numero
                        String[] parts = input.split(",");
                        if (parts.length == 2) {
                            String parola = parts[0].trim();
                            int numero;
                            try {
                                numero = Integer.parseInt(parts[1].trim());
                            } catch (NumberFormatException e) {
                                System.err.println("Il secondo dato non è un numero valido: " + parts[1]);
                                continue;
                            }

                            // Operazioni sui dati ricevuti
                            String parolaInversa = reverseString(parola);
                            int numeroIncrementato = numero + 10; // Aggiunge 10 al numero

                            // Preparazione e invio della risposta al client
                            String risposta = parolaInversa + "," + numeroIncrementato;
                            PrintWriter writer = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()), true);
                            writer.println(risposta);
                            System.out.println("Risposta inviata al client: " + risposta);
                        } else {
                            System.out.println("Formato dei dati errato. Aspettato: <stringa>,<numero>");
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

    public static String reverseString(String str) {
        return new StringBuilder(str).reverse().toString();
    }
}
