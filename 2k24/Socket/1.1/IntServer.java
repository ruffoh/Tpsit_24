    package SocketJava;
    import java.io.IOException;
    // errori input output
    import java.net.ServerSocket;
    // classe per creare un server che ascolta
    import java.net.Socket;
    // rappresenta connesione client -server 

    public class IntServer {
        public static void main(String[] args) {
         
            try (ServerSocket serverSocket = new ServerSocket(9999)) {
                // creo serverSocket che ascolta le connessioni su la porta 9999
               System.out.println("Server avviato e in attesa di connessioni ");
                // SERVER ATTIVO

                while(true){
                    //ciclo infinito per accettare nuove connessioni dei client

                    try(Socket socket = serverSocket.accept()){
                        //Acceta una connessione da un client. Punto di Blocco; Programma aspetta finchè client si conette
                        System.out.println("Connessione accettata da: "+ serverSocket.getInetAddress());
                      //Stampa l'indirizzo IP del client che si è connesso;
                        int numero = socket.getInputStream().read();
                        //legge un byte inviato dal client al sokcet
                       //  se non arriva nulla , valore = -1;

                       if(numero== -1){
                        System.out.println("Non ho ricevuto nessun dato");
                        // Non sono arrivati messaggi
                       }
                       else{
                        System.out.println("Server ha ricevuto: "+ numero);
                        System.out.println("Numero al quadrato: "+ numero*numero);
                        // Stampa
                       }
                    
                    
                    }   catch (IOException e) {
                        System.err.println("Errore nella communicazione con il client:" +e.getMessage());
                        // stampa che errore ha dato la comunicaizone
                    }
                } 
             }catch (Exception e) {
                // Gestione errori di creazione ServerSocket
                e.printStackTrace();
                // stampa cronologia in memoria del programma
            }
            
        }
        
    }