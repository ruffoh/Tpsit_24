# Esercizio 3
esercizio xml della serie a dal [testo](/2k24/Xml/esercizio/esercizio%203/XML%20-%20Gestione%20della%20stagione%20di%20Serie%20A%202024.pdf)

```
<?xml version="1.0" encoding="UTF-8"?>
<SerieA>
    <data_inizio>20 agosto 2024</data_inizio>
    <data_fine>26 maggio 2025</data_fine>
    <squadre>
        <quantità>20</quantità>
        <elenco>
            <squadra id="squadra_Napoli">
                <nome>Napoli</nome>
                <città>Napoli</città>
                <stadio>Diego Armando Maradona</stadio>
                <allenatore>Antonio Conte</allenatore>
                <giocatori>
                    <giocatore id="giocatore_Lukaku_11">
                        <Nome>Romelu Lukaku</Nome>
                        <NumeroMaglia>11</NumeroMaglia>
                        <Ruolo>Attaccante</Ruolo>
                        <Nazionalita>Belga</Nazionalita>
                    </giocatore>
                    <!-- altri giocatori -->
                </giocatori>
            </squadra>
            <!-- altre squadre -->
        </elenco>
    </squadre>
    <Campionato>
        <Partita id="partita_Napoli_Juventus_1">
            <Data>2024-08-20</Data>
            <Orario>21:00</Orario>
            <SquadraCasa>Napoli</SquadraCasa>
            <SquadraOspite>Juventus</SquadraOspite>
            <Location>Diego Armando Maradona</Location>
            <ArbitroPrincipale>Maurizio Mariani</ArbitroPrincipale>
            <Risultato>
                <Gol_Casa>5</Gol_Casa>
                <Gol_Ospite>2</Gol_Ospite>
            </Risultato>
            <Statistiche>
                <Gol>
                    <Rete marcatore="Romelu Lukaku" minuto="48"></Rete>
                    <Rete marcatore="Khvicha Kvaratskhelia" minuto="56"></Rete>
                    <!-- altri gol -->
                </Gol>
                <Ammonizioni>
                    <Gialli>
                        <cartellino>
                            <Giocatore>Romelu Lukaku</Giocatore>
                            <minuto>87</minuto>
                            <motivo>Intervento Pericoloso</motivo>
                        </cartellino>
                    </Gialli>
                    <Rossi>
                        <!-- altri cartellini rossi -->
                    </Rossi>
                </Ammonizioni>
                <PossessoPalla>
                    <SquadraCasa>60%</SquadraCasa>
                    <SquadraOspite>40%</SquadraOspite>
                </PossessoPalla>
                <TiriInPorta>
                    <SquadraCasa>12</SquadraCasa>
                    <SquadraOspite>7</SquadraOspite>
                </TiriInPorta>
            </Statistiche>
        </Partita>
        <!-- altre partite -->
    </Campionato>
    <Arbitri>
        <arbitro id="arbitro_Mariani">
            <nome>Maurizio Mariani</nome>
            <sezione>Roma</sezione>
        </arbitro>
        <!-- altri arbitri -->
    </Arbitri>
    <ClassificaFinale>
        <squadra id="classifica_Napoli">
            <nome>Napoli</nome>
            <punti>85</punti>
            <vittorie>27</vittorie>
            <sconfitte>5</sconfitte>
            <pareggi>6</pareggi>
            <gol_fatti>85</gol_fatti>
            <gol_subiti>34</gol_subiti>
        </squadra>
        <!-- altre squadre -->
    </ClassificaFinale>
    <StatisticheGiocatori>
        <giocatore id="stat_Lukaku_11">
            <Nome>Romelu Lukaku</Nome>
            <gol_stagione>21</gol_stagione>
            <assist>9</assist>
            <minuti_giocati>2800</minuti_giocati>
        </giocatore>
        <!-- altri giocatori -->
    </StatisticheGiocatori>
    <Telecronisti>
        <telecronista id="telecronista_Rossi">
            <nome>Mario Rossi</nome>
            <Giudizi>
                <giudizio partita="partita_Napoli_Juventus_1">
                    <giocatore>Romelu Lukaku</giocatore>
                    <punteggio>8</punteggio>
                </giudizio>
                <!-- altri giudizi -->
            </Giudizi>
        </telecronista>
        <!-- altri telecronisti -->
    </Telecronisti>
</SerieA>

```