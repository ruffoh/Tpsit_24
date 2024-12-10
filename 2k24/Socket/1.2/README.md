**Codice Client (`client.java`):**

* **Creazione del Socket:**
  ```java
  try (Socket socket = new Socket("127.0.0.1", 9999)) {
  ```
  - Questa riga crea una connessione socket al server in esecuzione sulla macchina locale (localhost) alla porta 9999. L'uso della dichiarazione `try-with-resources` assicura che il socket venga chiuso correttamente dopo l'uso.

* **Input dell'utente:**
  ```java
  Scanner in = new Scanner(System.in);
  System.out.println("Inserisci la parola da inviare che verrà invertita: ");
  String parola = in.nextLine();
  ```
  - Viene creato un oggetto `Scanner` per leggere l'input dell'utente dalla console.
  - Il programma chiede all'utente di inserire una parola che verrà inviata al server per essere invertita.
  - La parola inserita viene memorizzata nella variabile `parola`.

* **Invio dei dati al server:**
  ```java
  PrintWriter writer = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()), true);
  writer.println(parola);
  ```
  - Viene creato un oggetto `PrintWriter` per inviare i dati al server tramite il flusso di uscita del socket. Il parametro `true` nel costruttore abilita il "flush" automatico, assicurando che i dati vengano inviati immediatamente.
  - La variabile `parola` contenente la parola inserita dall'utente viene inviata al server tramite il metodo `println`, che aggiunge automaticamente un carattere di newline alla fine.

* **Ricezione della risposta dal server:**
  ```java
  BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
  String risposta = reader.readLine();
  ```
  - Viene creato un oggetto `BufferedReader` per leggere i dati dal flusso di input del server.
  - Il metodo `readLine` viene utilizzato per leggere una singola linea di testo (la risposta del server) dal flusso di input e la memorizza nella variabile `risposta`.

---

**Codice Server (`server.java`):**

* **Creazione del server socket:**
  ```java
  try (ServerSocket serverSocket = new ServerSocket(9999)) {
  ```
  - Questa riga crea un server socket che ascolta le connessioni in ingresso sulla porta 9999. Come nel client, l'uso della dichiarazione `try-with-resources` assicura che il server socket venga chiuso correttamente.

* **Accettazione delle connessioni:**
  ```java
  while (true) {
      try (Socket socket = serverSocket.accept()) {
          // ...
      }
  }
  ```
  - Il server entra in un ciclo infinito, aspettando continuamente nuove connessioni da parte dei client.
  - Il metodo `accept` sul server socket attende che un client si connetta e restituisce un nuovo oggetto `Socket` che rappresenta la connessione stabilita.
  - Il blocco `try-with-resources` interno assicura che il socket del client venga chiuso correttamente all'interno del ciclo.

* **Lettura dei dati dal client:**
  ```java
  BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
  String parola = reader.readLine();
  ```
  - Come nel client, viene creato un oggetto `BufferedReader` per leggere i dati dal flusso di uscita del client (che è il flusso di input del server per questa connessione).
  - Il metodo `readLine` viene utilizzato per leggere la parola inviata dal client e memorizzarla nella variabile `parola`.

* **Gestione dell'input vuoto:**
  ```java
  if (parola == null || parola.isEmpty()) {
      System.out.println("Non ho ricevuto nessun dato");
  } else {
      // ...
  }
  ```
  - Il codice verifica se la variabile `parola` è null (significa che non è stato ricevuto alcun dato) o se è vuota (una stringa vuota).
  - Se non vengono ricevuti dati, viene stampato un messaggio che indica che il server non ha ricevuto alcun dato.

* **Funzione di inversione della stringa:**
  ```java
  public static String reverseString(String str) {
      return new StringBuilder(str).reverse().toString();
  }
  ```
  - Questa funzione statica prende una stringa (`str`) come input e restituisce la versione invertita della stringa.
  - Crea un oggetto `StringBuilder` dalla stringa di input, usa il metodo `reverse` per invertire i caratteri e infine la converte di nuovo in una stringa utilizzando il metodo `toString`.

* **Invio della risposta al client:**
  ```java
  PrintWriter writer = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()), true);
  writer.println(risposta);
  ```
  - Viene creato un oggetto `PrintWriter` per inviare la risposta al client tramite il flusso di uscita del socket.
  - La risposta (la stringa invertita) viene inviata al client utilizzando il metodo `println`, che aggiunge automaticamente un carattere di newline alla fine.

---

