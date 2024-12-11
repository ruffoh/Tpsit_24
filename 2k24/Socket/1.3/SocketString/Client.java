import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.io.PrintWriter;         // inviare dati (text) al server in maniera semplificata
import java.net.UnknownHostException;   // gestisce l'eventualità in cui il server non sia raggiungibile

public class Client {
    public static void main(String[] args) {
        try(Socket socket = new Socket("127.0.0.1", 9999);){
            

        }catch (Exception e) {
            // TODO: handle exception
        }

    }
    
}
