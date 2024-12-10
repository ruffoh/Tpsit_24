# **README: Invio di una Stringa al Server**

Questo file illustra come funziona l'invio di una stringa da un client a un server usando Java. Il server utilizza un buffer per leggere i dati e risponde invertendo la stringa ricevuta.

---

## **Invio di una Stringa**

### **Cosa fa il Codice:**
1. **Lettura della Stringa:** 
   - Il server utilizza un `BufferedReader` per leggere i dati dal flusso di input del socket.
   - Il buffer migliora l'efficienza nella gestione dei dati, leggendo blocchi di caratteri invece di un carattere alla volta.

2. **Elaborazione della Stringa:** 
   - Il server controlla se la stringa ricevuta è vuota o nulla.
   - Inverte la stringa utilizzando il metodo `reverseString`.

3. **Invio della Risposta:**
   - La stringa invertita viene inviata al client usando un `PrintWriter`, che gestisce il flusso di output.

---

### **Estratto del Codice**

#### **Lettura della Stringa dal Client**
```java
BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
String parola = reader.readLine(); // Legge la stringa inviata dal client
