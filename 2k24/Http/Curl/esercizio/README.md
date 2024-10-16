
## Esercizio 1

 ``` ruby
  tempo_risoluzione_dns: 0.054634
  tempo_connessione: 0.074430
  tempo_pretrasferimento: 0.382575
  tempo_inizio_trasferimento: 0.487632
  tempo_totale: 0.48823
 ```

## Esercizio 2

``` php  
2HTTP/1.1 404 NOT FOUND
Date: Wed, 16 Oct 2024 07:16:42 GMT
Content-Type: text/html; charset=utf-8
Content-Length: 0
Connection: keep-alive
Server: gunicorn/19.9.0
Access-Control-Allow-Origin: *
Access-Control-Allow-Credentials: true
``` 

## Esercizio 4 
``` json
{
  "args": {},
  "data": "{    \"username\": \"studente\",    \"password\": \"password123\"        }",
  "files": {},
  "form": {},
  "headers": {
    "Accept": "*/*",
    "Content-Length": "66",
    "Content-Type": "application/json",
    "Host": "httpbin.org",
    "User-Agent": "curl/8.7.1",
    "X-Amzn-Trace-Id": "Root=1-670f68ad-080df4b869be704c57aac10c"
  },
  "json": {
    "password": "password123",
    "username": "studente"
  },
  "origin": "94.80.173.222",
  "url": "https://httpbin.org/post"
}
```
Approfondimenti sugli Elementi della Risposta:
Codice di stato: 200 OK indica una richiesta andata a buon fine.

Header della risposta: Forniscono informazioni su come il server ha elaborato la richiesta, le dimensioni della risposta e il tipo di contenuto.

Body della risposta: Contiene i dati inviati (username e password) in formato JSON, confermando che la richiesta POST ha avuto successo e che il server ha correttamente ricevuto e processato i dati inviati.







## Esercizio 5 
[Header](https://github.com/ruffoh/Tpsit_24/blob/main/2k24/Http/Curl/esercizio/header.txt)
``` php
HTTP/1.1 200 OK
Date: Wed, 16 Oct 2024 07:20:21 GMT
Content-Type: application/json
Content-Length: 254
Connection: keep-alive
Server: gunicorn/19.9.0
Access-Control-Allow-Origin: *
Access-Control-Allow-Credentials: true


```
[Body](https://github.com/ruffoh/Tpsit_24/blob/main/2k24/Http/Curl/esercizio/body.txt)
 ``` json
{
  "args": {}, 
  "headers": {
    "Accept": "*/*", 
    "Host": "httpbin.org", 
    "User-Agent": "curl/8.7.1", 
    "X-Amzn-Trace-Id": "Root=1-670f6935-6fc2b01718ae104e1bc00fb1"
  }, 
  "origin": "94.80.173.222", 
  "url": "https://httpbin.org/get"
}
```


