import java.io.IOException; //Importa la classe IOException per gestire eventuali errori di input/output.
import java.io.PrintWriter; //Importa la classe PrintWriter per inviare dati (testo) al server in modo semplice ed efficiente.
import java.net.Socket; //Importa la classe Socket per rappresentare la connessione tra il client e il server.
import java.net.UnknownHostException; //Importa la classe UnknownHostException per gestire il caso in cui il server non sia raggiungibile.

public class ProfClient { //Dichiarazione della classe IntClient che contiene il programma principale.
    public static void main(String[] args) { //Dichiarazione del metodo main, punto di ingresso del programma client.
        try { //Gestisce eccezioni relative a problemi di connessione o comunicazione.
            System.out.println("Tentativo di connessione al server..."); //Stampa un messaggio per indicare che il client sta tentando di connettersi al server.

            try (Socket s = new Socket("localhost", 9999)) { //Crea un socket che si connette al server sulla stessa macchina ('localhost') alla porta 9999.
                System.out.println("Connessione stabilita con il server."); //Stampa un messaggio per indicare che la connessione al server è stata stabilita.

                PrintWriter out = new PrintWriter(s.getOutputStream(), true); //Crea un oggetto PrintWriter per inviare dati al server. L'auto-flush è abilitato per inviare immediatamente i dati.
                String messaggio = "ciao " + Math.random(); //Genera un messaggio che include la parola "ciao" seguita da un numero casuale.
                out.println(messaggio); //Invia il messaggio generato al server.

                System.out.println("Il client ha inviato: " + messaggio); //Stampa un messaggio per confermare l'invio del dato al server.
            } //Chiude automaticamente il socket al termine del blocco try-with-resources.
        } catch (UnknownHostException e) { //Gestisce l'eccezione nel caso in cui il server specificato non venga trovato.
            System.err.println("Impossibile trovare il server: " + e.getMessage()); //Stampa un messaggio di errore specificando che il server non è raggiungibile.
        } catch (IOException e) { //Gestisce eccezioni relative a problemi di comunicazione con il server.
            System.err.println("Errore di comunicazione con il server: " + e.getMessage()); //Stampa un messaggio di errore con i dettagli dell'eccezione.
        }
    }
}