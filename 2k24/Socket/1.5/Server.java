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
                    String input = reader.readLine();

                    PrintWriter writer = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()), true);

                    if (input == null || input.isEmpty()) {
                        writer.println("Errore: input vuoto");
                        System.out.println("Non ho ricevuto nessun dato");
                    } else {
                        System.out.println("Server ha ricevuto: " + input);

                        try {
                            // Determina se l'input è un'operazione
                            if (input.matches(".*[+\\-*/].*")) { // Controllo per +, -, *, /
                                // Calcola l'operazione
                                double risultato = calcolaOperatore(input);
                                writer.println("Risultato: " + risultato);
                                System.out.println("Operazione calcolata, risultato: " + risultato);
                            } else {
                                writer.println("Errore: Input non valido. Solo operazioni matematiche consentite.");
                                System.out.println("Operazione non consentita: input non valido.");
                            }
                        } catch (IllegalArgumentException e) {
                            writer.println("Errore: " + e.getMessage());
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

    // Funzione per calcolare l'operazione
    private static double calcolaOperatore(String operazione) throws IllegalArgumentException {
        // Rimuove eventuali spazi bianchi dall'operazione
        operazione = operazione.trim();

        // Trova la posizione dell'operatore
        int operatoreIndex = -1;
        for (int i = 0; i < operazione.length(); i++) {
            char c = operazione.charAt(i);
            if (c == '+' || c == '-' || c == '*' || c == '/') { // Controlla solo gli operatori validi
                operatoreIndex = i;
                break;
            }
        }

        if (operatoreIndex == -1) {
            throw new IllegalArgumentException("Operazione non valida: operatore mancante");
        }

        // Estrae i due numeri e l'operatore
        double num1 = Double.parseDouble(operazione.substring(0, operatoreIndex).trim());
        char operatore = operazione.charAt(operatoreIndex);
        double num2 = Double.parseDouble(operazione.substring(operatoreIndex + 1).trim());

        // Calcola il risultato in base all'operatore
        switch (operatore) {
            case '+':
                return num1 + num2;
            case '-':
                return num1 - num2;
            case '*':
                return num1 * num2;
            case '/':
                if (num2 == 0) {
                    throw new IllegalArgumentException("Divisione per zero non consentita");
                }
                return num1 / num2;
            default:
                throw new IllegalArgumentException("Operatore non valido: " + operatore);
        }
    }
}
