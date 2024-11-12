## Esercizio
``` xml
<?xml version="1.0" encoding="UTF-8"?>
<Festival>
    <nome>Venezia International Film Fest,</nome>
    <luogo>Venezia</luogo>
    <data_inizio>1 settembre 2024</data_inizio>
    <durata>10 </durata>

    <categorie>
        <categoria>Miglior Film</categoria>
        <categoria>Miglior Regista</categoria>
        <categoria>Miglior Attore</categoria>
        <categoria>Miglior Film d'Animazione</categoria>
        <categoria>Premio Speciale del Pubbilico</categoria>

    </categorie>
    <filmografia>
        <film>
            <titolo>titolo film</titolo>
            <regista>Nome Regista</regista>
            <anno>anno di produzione</anno>
            <paese>Paese d'Origine</paese>
            <durata>Durata in minuti</durata>
            <categoria>Categoria di Partecipazione</categoria>
            <cast>
                <attore>Nome Attore</attore>
                <!-- altri attori-->
            </cast>
            <lingua>Lingua originale</lingua>
            <sottotitoli>
                <lingua>Lingua sottotitoli</lingua>
                <!-- Altre lingue sottotitoli-->
            </sottotitoli>
            <generi>
                <genere>Genere di Appartenza</genere>
                   <!-- Altri generi -->
            </generi>

      </film>
      <!-- Altri film-->
    </filmografia>
    <proiezioni>
        <proiezione>
            <nome>Nome proiezione</nome>
            <data>data</data>
            <ora>Orario</ora>
            <location>Nome sala ecc.</location>
            <prezzo>Prezzo</prezzo>
            <sezione>Sezione sala(vip ecc...) </sezione>
        </proiezione>
        <!-- Altre proiezioni-->

    </proiezioni>
    <Ospiti>
        <Registi>
            <regista>Nome</regista>
            <!-- Altri registi-->
        </Registi>
        <Attori>
            <attore>Nome</attore>
            <!-- Altri attori-->
        </Attori>
        <Produttori>
            <Produttore>Nome</Produttore>
            <!-- Altri produttori-->
        </Produttori>
        <Critici>
            <critico>Nome</critico>
            <!-- Altri critici-->
        </Critici>
    </Ospiti>
    <Giuria>
        <giudice>
            <nome>nome</nome>
            <nazionalità>Nazione</nazionalità>
            <ruolo>ruolo specifico</ruolo>
            <voti>
                <voto>
                    <film>nome film</film>
                    <valutazione>numero voto</valutazione>
                </voto>
                <!-- Altri voti-->
            </voti>
        </giudice>
        <!-- Altri giudici-->
    </Giuria>
    <Recensioni>
        <recensione>
            <film>nome film</film>
            <nomePartecipante>nome</nomePartecipante>
            <valutazione>punteggio 1-5</valutazione>
            <commento>commento pubblico</commento>
        </recensione>
        <!-- Altre recensioni-->
    </Recensioni>
</Festival>
```