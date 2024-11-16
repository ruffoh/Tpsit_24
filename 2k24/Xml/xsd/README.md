# Xsd Esercizi
## Esericizio 2
<details>
  <summary>Clicca qui per visualizzare il codice XSD </summary>
  
``` xsd 
<?xml version="1.0" encoding="UTF-8"?>
<xs:schema xmlns:xs="http://www.w3.org/2001/XMLSchema">
  
  <!-- Definizione dell'elemento Festival -->
  <xs:element name="Festival">
    <xs:complexType>
      <xs:sequence>
        <xs:element name="nome" type="xs:string"/>
        <xs:element name="luogo" type="xs:string"/>
        <xs:element name="data_inizio" type="xs:string"/>
        <xs:element name="durata" type="xs:int"/>
        
        <xs:element name="categorie">
          <xs:complexType>
            <xs:sequence>
              <xs:element name="categoria" type="xs:string" maxOccurs="unbounded"/>
            </xs:sequence>
          </xs:complexType>
        </xs:element>
        
        <xs:element name="filmografia">
          <xs:complexType>
            <xs:sequence>
              <xs:element name="film">
                <xs:complexType>
                  <xs:sequence>
                    <xs:element name="titolo" type="xs:string"/>
                    <xs:element name="regista" type="xs:string"/>
                    <xs:element name="anno" type="xs:string"/>
                    <xs:element name="paese" type="xs:string"/>
                    <xs:element name="durata" type="xs:int"/>
                    <xs:element name="categoria" type="xs:string"/>
                    
                    <xs:element name="cast">
                      <xs:complexType>
                        <xs:sequence>
                          <xs:element name="attore" type="xs:string" maxOccurs="unbounded"/>
                        </xs:sequence>
                      </xs:complexType>
                    </xs:element>
                    
                    <xs:element name="lingua" type="xs:string"/>
                    
                    <xs:element name="sottotitoli">
                      <xs:complexType>
                        <xs:sequence>
                          <xs:element name="lingua" type="xs:string" maxOccurs="unbounded"/>
                        </xs:sequence>
                      </xs:complexType>
                    </xs:element>
                    
                    <xs:element name="generi">
                      <xs:complexType>
                        <xs:sequence>
                          <xs:element name="genere" type="xs:string" maxOccurs="unbounded"/>
                        </xs:sequence>
                      </xs:complexType>
                    </xs:element>
                  </xs:sequence>
                </xs:complexType>
              </xs:element>
            </xs:sequence>
          </xs:complexType>
        </xs:element>
        
        <xs:element name="proiezioni">
          <xs:complexType>
            <xs:sequence>
              <xs:element name="proiezione">
                <xs:complexType>
                  <xs:sequence>
                    <xs:element name="nome" type="xs:string"/>
                    <xs:element name="data" type="xs:string"/>
                    <xs:element name="ora" type="xs:string"/>
                    <xs:element name="location" type="xs:string"/>
                    <xs:element name="prezzo" type="xs:string"/>
                    <xs:element name="sezione" type="xs:string"/>
                  </xs:sequence>
                </xs:complexType>
              </xs:element>
            </xs:sequence>
          </xs:complexType>
        </xs:element>

        <xs:element name="Ospiti">
          <xs:complexType>
            <xs:sequence>
              <xs:element name="Registi">
                <xs:complexType>
                  <xs:sequence>
                    <xs:element name="regista" type="xs:string" maxOccurs="unbounded"/>
                  </xs:sequence>
                </xs:complexType>
              </xs:element>

              <xs:element name="Attori">
                <xs:complexType>
                  <xs:sequence>
                    <xs:element name="attore" type="xs:string" maxOccurs="unbounded"/>
                  </xs:sequence>
                </xs:complexType>
              </xs:element>

              <xs:element name="Produttori">
                <xs:complexType>
                  <xs:sequence>
                    <xs:element name="Produttore" type="xs:string" maxOccurs="unbounded"/>
                  </xs:sequence>
                </xs:complexType>
              </xs:element>

              <xs:element name="Critici">
                <xs:complexType>
                  <xs:sequence>
                    <xs:element name="critico" type="xs:string" maxOccurs="unbounded"/>
                  </xs:sequence>
                </xs:complexType>
              </xs:element>
            </xs:sequence>
          </xs:complexType>
        </xs:element>

        <xs:element name="Giuria">
          <xs:complexType>
            <xs:sequence>
              <xs:element name="giudice">
                <xs:complexType>
                  <xs:sequence>
                    <xs:element name="nome" type="xs:string"/>
                    <xs:element name="nazionalità" type="xs:string"/>
                    <xs:element name="ruolo" type="xs:string"/>
                    
                    <xs:element name="voti">
                      <xs:complexType>
                        <xs:sequence>
                          <xs:element name="voto">
                            <xs:complexType>
                              <xs:sequence>
                                <xs:element name="film" type="xs:string"/>
                                <xs:element name="valutazione" type="xs:int"/>
                              </xs:sequence>
                            </xs:complexType>
                          </xs:

```
</details>

## XSD esercizio Serie A
<details>
  <summary>Clicca qui per visualizzare il codice XSD</summary>

  ```xsd
  <?xml version="1.0" encoding="UTF-8"?>
  <xs:schema xmlns:xs="http://www.w3.org/2001/XMLSchema" elementFormDefault="qualified">
      <!-- Elemento radice -->
      <xs:element name="SerieA">
          <xs:complexType>
              <xs:sequence>
                  <xs:element name="data_inizio" type="xs:string"/>
                  <xs:element name="data_fine" type="xs:string"/>
                  <xs:element name="squadre">
                      <xs:complexType>
                          <xs:sequence>
                              <xs:element name="quantità" type="xs:positiveInteger"/>
                              <xs:element name="elenco">
                                  <xs:complexType>
                                      <xs:sequence>
                                          <xs:element name="squadra" maxOccurs="unbounded">
                                              <xs:complexType>
                                                  <xs:sequence>
                                                      <xs:element name="nome" type="xs:string"/>
                                                      <xs:element name="città" type="xs:string"/>
                                                      <xs:element name="stadio" type="xs:string"/>
                                                      <xs:element name="allenatore" type="xs:string"/>
                                                      <xs:element name="giocatori">
                                                          <xs:complexType>
                                                              <xs:sequence>
                                                                  <xs:element name="giocatore" maxOccurs="unbounded">
                                                                      <xs:complexType>
                                                                          <xs:sequence>
                                                                              <xs:element name="Nome" type="xs:string"/>
                                                                              <xs:element name="NumeroMaglia" type="xs:positiveInteger"/>
                                                                              <xs:element name="Ruolo" type="xs:string"/>
                                                                              <xs:element name="Nazionalita" type="xs:string"/>
                                                                          </xs:sequence>
                                                                          <xs:attribute name="id" type="xs:string" use="required"/>
                                                                      </xs:complexType>
                                                                  </xs:element>
                                                              </xs:sequence>
                                                          </xs:complexType>
                                                      </xs:element>
                                                  </xs:sequence>
                                                  <xs:attribute name="id" type="xs:string" use="required"/>
                                              </xs:complexType>
                                          </xs:element>
                                      </xs:sequence>
                                  </xs:complexType>
                              </xs:element>
                          </xs:sequence>
                      </xs:complexType>
                  </xs:element>
              </xs:sequence>
          </xs:complexType>
      </xs:element>
  </xs:schema>
```
</details>
