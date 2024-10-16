# Esercizio HTTP

## Esercizio 1

Rispondi alle seguenti domande:

1. ❓ **Qual è il metodo HTTP utilizzato per la richiesta principale?**
2. 📄 **Quale status code è stato restituito dal server? Cosa indica questo codice?**
3. 📑 **Quali header di richiesta e di risposta sono presenti?**
4. 📸 **Il browser ha richiesto risorse aggiuntive (CSS, immagini, script)? Quali?**
5. 🔄 **Cosa succede se clicchi su un link o ricarichi la pagina? Noti cambiamenti nelle richieste?**
6. 🔍 **C'è qualche differenza tra le richieste GET e POST che riesci a identificare?**

### Risposte

**🌐 URL completo della risorsa alla quale sto cercando di accedere**: [https://me.stecca.dev/](https://me.stecca.dev/)

1. **📥 Metodo HTTP**: Il metodo utilizzato per accedere alla risorsa principale è il metodo **GET**. 

    ![image](https://github.com/user-attachments/assets/e25faabd-3575-4bc2-a59c-f697860a56a4)
<hr>

2. **📊 Status Code** : Il codice restituito dal server è **304 (Not Modified)**. Questo codice indica che la risorsa richiesta è già presente nella cache del browser.

3. **📤 Response Headers**:
   - **Age**: Indica il tempo trascorso dalla generazione della risposta dal server.
   - **Cache-Control**: Specifica le direttive di caching per richiesta/risposta.
   - **Date**: Data e ora in cui il messaggio è stato originato.
   - **Etag**: Identificatore unico per una specifica versione di una risorsa.
   - **Expires**: Data/ora dopo la quale la risposta è considerata obsoleta.
   - **Vary**: Indica come determinare la corrispondenza della risposta in cache.
   - **Via**: Informa sul proxy attraverso cui è passata la risposta.
   - **X-Cache**: Indica se la risposta è stata servita da una cache.
   - **X-Cache-Hits**: Numero di volte che la risposta è stata servita da una cache.
   - **X-Fastly-Request-ID**: Identificatore unico per la richiesta, specifico di Fastly CDN.
   - **X-Served-By**: Identifica il server che ha servito la risposta.
   - **X-Timer**: Fornisce informazioni sui tempi di elaborazione della richiesta.
     <hr>
   ![image](https://github.com/user-attachments/assets/b99532cf-c211-4acd-8343-3d1c15851fcc)

   **📥 Request Headers**:
   - **authority**: Specifica il dominio del server a cui si sta facendo la richiesta (in questo caso, me.stecca.dev).
   - **method**: Indica il metodo HTTP utilizzato per la richiesta (GET in questo caso).
   - **path**: Specifica il percorso della risorsa richiesta sul server (/ indica la root).
   - **scheme**: Indica il protocollo utilizzato (https in questo caso).
   - **accept**: Specifica i tipi di contenuto che il client è in grado di comprendere.
   - **accept-encoding**: Indica i metodi di compressione supportati dal client.
   - **accept-language**: Specifica le preferenze linguistiche del client.
   - **cache-control**: Definisce le direttive per il caching della richiesta.
   - **if-modified-since**: Chiede al server di inviare la risorsa solo se è stata modificata dopo la data specificata.
   - **if-none-match**: Utilizzato per la validazione della cache, confronta l'ETag fornito con quello della risorsa sul server.
   - **priority**: Indica la priorità della richiesta.
   - **sec-ch-ua, sec-ch-ua-mobile, sec-ch-ua-platform**: Forniscono informazioni sul browser e sul dispositivo del client.
   - **sec-fetch-***: Una serie di header che forniscono informazioni sul contesto della richiesta.
   - **upgrade-insecure-requests**: Indica al server che il client preferisce connessioni sicure.
   - **user-agent**: Identifica il software del client che sta effettuando la richiesta.

4. **📊 Richiesta di risorse aggiuntive**: Il browser ha richiesto molte risorse aggiuntive, poiché il sito è un portfolio che contiene molte immagini e contenuti. Questi vengono inviati dal server come risorse aggiuntive quando vengono visualizzati, inclusi script JavaScript per rendere il sito dinamico e immagini in formato WebP.

5. **🔄 Comportamento al ricaricare la pagina**: Quando si ricarica la pagina, le richieste effettuate e ricevute saranno le stesse, poiché si accede alla stessa risorsa. Cliccando su un link si accede a una risorsa diversa e le richieste ad essa connesse cambieranno di conseguenza.

6. **🔍 Differenze tra GET e POST**: Quando si effettua una richiesta **GET**, si richiede una risorsa per visualizzarla; mentre per una richiesta **POST**, è necessario inviare dati insieme ad essa, come mostrato nel campo payload.

## Esercizio 2

Due risposte plausibili del server HTTP (solo la status line):

1. **📄 Risorsa non modificata**:
HTTP/1.1 304 Not Modified


2. **📁 Risorsa trovata e mostrata**:
HTTP/1.1 200 OK


3. **❌ Risorsa non trovata**:
HTTP/1.1 404 NOT FOUND


4. **🚫 Risorsa Proibita**:
HTTP/1.1 403 FORBIDDEN



### Comportamento del Proxy

Quando una richiesta come quella sopra viene inviata attraverso un proxy, il comportamento del proxy varia a seconda della configurazione e delle policy di caching. Ecco due scenari possibili:

1. **Proxy con caching abilitato**:
- Il proxy potrebbe aver memorizzato una copia della risorsa richiesta in una precedente richiesta (Cache Hit). Se non è presente (Cache Miss), inoltra la richiesta al server originario.
- Se il proxy ha la risorsa nella cache ma è incerto sulla sua validità (a causa dell'intestazione "If-Modified-Since"), inoltra la richiesta al server.
- Se il server risponde con **304 Not Modified**, il proxy invia al client la risorsa dalla sua cache.
- Se il server risponde con **200 OK**, il proxy aggiorna la sua cache con la nuova versione della risorsa e la invia al client.

2. **Proxy senza caching o con caching disabilitato**:
- Il proxy inoltra la richiesta direttamente al server, comportandosi come un semplice intermediario.
- Il server risponderà direttamente al proxy con uno dei due codici di stato (304 o 200), e il proxy trasmetterà la risposta al client senza ulteriori elaborazioni.

## Esercizio 3: Calcolo del tempo di download

Dati:
- Numero di oggetti: **N = 11** (1 file HTML + 10 oggetti)
- Dimensione di ogni oggetto: **L = 200 kbit**
- Capacità del collegamento: **C = 100 kbit/s**
- Dimensione messaggi di controllo: **m = 100 bit**
- Ritardo di propagazione: **τ = 100 ms = 0.1 s**

1. **Connessioni TCP parallele non persistenti**:
- Velocità di trasmissione per connessione: **r = C / N = 100 / 11 ≈ 9.09 kbit/s**
- Tempo di trasferimento per oggetto: **T_oggetto = L / r = 200 / 9.09 ≈ 22 s**
- Tempo totale: **T_totale = T_oggetto + RTT = 22 + 0.1 = 22.1 s**

2. **Connessioni TCP seriali non persistenti**:
- Tempo di trasferimento per oggetto: **t_oggetto = L / C = 200 / 100 = 2 s**
- Tempo totale: **T_totale = N * (t_oggetto + RTT) = 11 * (2 + 0.1) = 23.1 s**

## Esercizio 4: Condivisione del collegamento e connessioni TCP

Dati:
- Numero di oggetti: **12** (1 file HTML + 11 oggetti)
- Dimensione di ogni oggetto: **L = 50 kB = 400 kbit**
- Capacità del collegamento: **C = 1 Mbit/s = 1000 kbit/s**
- **RTT = 150 ms = 0.15 s**
- Numero totale di flussi: **n = 10** (Numero flussi utili + 9)
- Velocità effettiva per il flusso HTTP: **r = C / n = 1000 / 10 = 100 kbit/s**

1. **Singola connessione TCP persistente**:Tempo di trasferimento per oggetto: Toggetto = L / r = 400 / 100 = 4 s
   Tempo totale: ttotale = (12 toggetto) + RTT = (12 * 4) + 0.15 = 48.15 s

2.  **Connessioni TCP parallele non persistenti:**
 - Tempo di trasferimento per oggetto: Toggetto = L / r = 400 / 50 = 8 s
-  Tempo totale: Ttotale = Toggetto + RTT = 8 + 0.15 = 8.15 s 

  
  ## Esercizio HTTP 5:  HTTP Caching
-  Dati:
 -  Cache hit rate: P = 0.4
 - Cache miss rate: Q = 0.6
-   Dimensione pagina web: L = 100 kB = 800 kbit
 -  Capacità del collegamento client-proxy: C = 1 Gb/s = 1,000,000 kbit/s
 -  Capacità del collegamento proxy-server: c = 100 Mb/s = 100,000 kbit/s
 -  Tempo di risposta per cache hit: Thit = L / C = 800 / 1,000,000 = 0.0008 s
 -  Tempo di risposta per cache miss: Tmiss = (L / c) + (L / C) = (800 / 100,000) + (800 / 1,000,000) = 0.0088 s
  - Ritardo medio: Tmedio = P Thit + Q tmiss = 0.4 * 0.0008 + 0.6 * 0.0088 = 0.00512 s = 5.12 ms
  - Quindi, il ritardo medio sperimentato dal generico client è di 5.12 millisecondi



