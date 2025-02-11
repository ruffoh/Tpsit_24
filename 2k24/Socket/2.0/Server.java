import java.io.*;
import java.net.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Server {
    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(9999)) {
            System.out.println("Server avviato e in attesa di connessioni...");

            while (true) {
                try (Socket socket = serverSocket.accept()) {
                    System.out.println("Connessione accettata da: " + socket.getInetAddress());

                    BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                    PrintWriter writer = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()), true);

                    String input = reader.readLine();

                    if (input == null || input.isEmpty()) {
                        writer.println("Errore: nessun dato ricevuto.");
                    } else {
                        System.out.println("Server ha ricevuto: " + input);

                        String[] parts = input.split(":");
                        if (parts.length != 2) {
                            writer.println("Errore: formato non valido. Usa 'asc:1,2,3' o 'desc:3,2,1'.");
                            continue;
                        }

                        String orderType = parts[0]; // "asc" o "desc"
                        String numberList = parts[1];

                        // Conversione dei numeri
                        List<Integer> numbers = Arrays.stream(numberList.split(","))
                                .map(String::trim)
                                .map(Integer::parseInt)
                                .collect(Collectors.toList());

                        // Ordinamento
                        if (orderType.equals("asc")) {
                            Collections.sort(numbers);
                        } else if (orderType.equals("desc")) {
                            Collections.sort(numbers, Collections.reverseOrder());
                        } else {
                            writer.println("Errore: specificare 'asc' o 'desc'.");
                            continue;
                        }

                        // Invio della risposta al client
                        String result = numbers.toString().replace("[", "").replace("]", "");
                        writer.println(result);
                        System.out.println("Lista ordinata inviata al client: " + result);
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
