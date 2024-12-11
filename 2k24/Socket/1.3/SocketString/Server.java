
import java.io.BufferedReader;
import java.io.InputStreamReader;

import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {
        System.out.println("Server in avvio...");
        try(ServerSocket Ss = new ServerSocket(9999)) {     // creazione socket server che ascolta sulla porta 999
            System.out.println("Server avviato. In attesa di connessioni sulla porta: " + Ss.getLocalPort());   // prende in automatico la porta

            while (true) {
                try(Socket s = Ss.accept()) {           // connessione accettata
                    System.out.println("Connessione accettata da: "+ s.getInetAddress());   // indirizzo ip del s (socket client che si è connesso)
                    BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));   // creazione di un buffer (flusso(stringa del s.client))
                    String Ricevuto = in.readLine();    // legge riga di testo inviata dal client
                    if(Ricevuto != null )
                        System.out.println("Il server riceve: " + Ricevuto);
                    else
                        System.out.println("Connessione chiusa senza invio di dati");

                    

                } catch (Exception e) {
                    System.err.println("Errore nella comunicazione con il client: " + e.getMessage());
                }
            }
            

        } catch (Exception e) {
            e.printStackTrace();        }
    }


}
