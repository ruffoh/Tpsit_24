# HTTP1.0/1.1

## Differenza tra HTTP 1.0 e HTTP 1.1

HTTP 1.1 introduce diverse migliorie rispetto alla versione 1.0. Tra le principali:

- Connessioni persistenti (keep-alive) di default
- Supporto per host virtuali
- Miglior gestione della cache
- Negoziazione del contenuto

## I messaggi HTTP (richiesta e risposta)

Un messaggio HTTP è composto da una linea iniziale, delle intestazioni e un corpo opzionale. Analizziamo la richiesta fornita:

``` php
  GET /percorsi-studio?id=1389 HTTP/1.1
  Host: www.antonioscarpa.edu.it
  User-Agent: Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKi
  Accept: text/html,application/xhtml+xml,application/xml;q=0.9,im
  Accept-Language: en-US,en;q=0.5
  Accept-Encoding: gzip, deflate, br
  Connection: keep-alive
  Upgrade-Insecure-Requests: 1

```

Analisi riga per riga:
1. Metodo GET, percorso richiesto con query string, versione HTTP
2. Host a cui è diretta la richiesta
3. User-Agent: informazioni sul browser e sistema operativo del client
4. Accept: tipi MIME accettati dal client
5. Accept-Language: lingue preferite dal client
6. Accept-Encoding: metodi di compressione supportati
7. Connection: richiesta di connessione persistente
8. Upgrade-Insecure-Requests: preferenza per connessioni sicure

## HTTP keep-alive

Il browser richiede una connessione permanente (keep-alive). Questo è indicato dalla riga "Connection: keep-alive". Le connessioni persistenti permettono di effettuare più richieste sulla stessa connessione TCP, migliorando le prestazioni.

Il parametro "?id=1389" dopo "/percorsi-studio" è una query string. Viene utilizzata per passare dati al server, in questo caso probabilmente un identificativo specifico per la pagina richiesta.

## Status Code di un messaggio di risposta

Lo Status Code è un codice numerico a tre cifre che indica l'esito della richiesta. Alcuni esempi comuni:

| Codice | Significato | Descrizione |
|--------|-------------|-------------|
| 1xx | Informational | Indica che la richiesta è stata ricevuta e il processo continua |
| 100 | Continue | Il server ha ricevuto gli headers della richiesta e il client dovrebbe procedere con l'invio del corpo |
| 101 | Switching Protocols | Il server accetta il cambio di protocollo richiesto dal client |
| 2xx | Success | Indica che la richiesta è stata ricevuta, compresa e accettata con successo |
| 200 | OK | La richiesta è andata a buon fine |
| 201 | Created | La richiesta è stata soddisfatta e ha portato alla creazione di una nuova risorsa |
| 204 | No Content | La richiesta è stata elaborata con successo ma non c'è contenuto da restituire |
| 3xx | Redirection | Indica che ulteriori azioni devono essere intraprese per completare la richiesta |
| 301 | Moved Permanently | La risorsa richiesta è stata spostata permanentemente |
| 302 | Found | La risorsa richiesta è stata temporaneamente spostata |
| 304 | Not Modified | La risorsa non è stata modificata dall'ultima richiesta |
| 4xx | Client Error | Indica che c'è stato un errore nella richiesta del client |
| 400 | Bad Request | La richiesta non può essere soddisfatta a causa di una sintassi errata |
| 401 | Unauthorized | La richiesta richiede autenticazione |
| 403 | Forbidden | Il server ha capito la richiesta ma rifiuta di autorizzarla |
| 404 | Not Found | La risorsa richiesta non è stata trovata sul server |
| 5xx | Server Error | Indica che il server non è riuscito a soddisfare una richiesta apparentemente valida |
| 500 | Internal Server Error | Il server ha incontrato una condizione inaspettata che gli ha impedito di soddisfare la richiesta |
| 502 | Bad Gateway | Il server, mentre agiva come gateway o proxy, ha ricevuto una risposta non valida dal server upstream |
| 503 | Service Unavailable | Il server non è al momento disponibile (sovraccarico o in manutenzione) |

## Metodi GET e POST

GET e POST sono due metodi HTTP utilizzati per inviare dati al server.

### GET
- I dati sono inclusi nell'URL come query string
- Utilizzato per richieste che non modificano lo stato del server
- Visibile nell'URL del browser

### POST
- I dati sono inviati nel corpo della richiesta
- Utilizzato per inviare dati sensibili o di grandi dimensioni
- Non visibile nell'URL del browser

In PHP, si accede ai dati GET tramite $_GET e ai dati POST tramite $_POST.

Nell'URL, un form che usa GET includerà i dati come query string (es. ?nome=valore), mentre un form POST non mostrerà i dati nell'URL.

## Codifica URL

La codifica URL sostituisce alcuni caratteri con una sequenza di escape per garantire una trasmissione sicura. Alcuni esempi di caratteri codificati:

- Spazio: %20
- &: %26
- =: %3D
- +: %2B

## Altri metodi di richiesta

- PUT: Aggiorna una risorsa esistente
- DELETE: Elimina una risorsa specificata
- TRACE: Esegue un test di loop-back lungo il percorso verso la risorsa
- CONNECT: Stabilisce un tunnel verso il server identificato dalla risorsa
