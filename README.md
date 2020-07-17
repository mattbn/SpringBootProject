# Solar Event Data

### Descrizione
Il contenuto della repository è una REST API il cui obiettivo è identificare i dati relativi agli eventi solari osservati in un certo intervallo di tempo. 

### Informazioni sui dati
I dati sono ottenuti dai tweet dell'utente Twitter @\_SpaceWeather\_.

### Installazione

1. Clonare questa repository con `git clone https://github.com/mattbn/SpringBootProject` oppure con il pulsante "Code" -> "Download ZIP"
2. Aprire il Prompt dei Comandi (Windows, cmd.exe) oppure il Terminale (\*NIX) nella cartella creata
3. Inserire il comando `mvn clean install`
4. Eseguire il server con `java -jar target/SpringBootProject-0.0.1-SNAPSHOT.jar`


### Utilizzo
**Essendo per ora sprovvisto di interfaccia utente grafica (GUI o viste), l'unico modo per effettuare le richieste correttamente è utilizzare un software di terze parti (Postman, ad esempio).**

##### Rotte

> GET /rawdata 

*Ottiene e restituisce i dati dei tweet presi direttamente dal profilo dell'utente scelto*

**Parametri**:

 1. screen_name (String) : tag unico dell'utente del quale leggere i tweet
 2. count (Integer) : numero di tweet da leggere

> GET /data 

*Ottiene i dati dei tweet e li restituisce convertendoli automaticamente in dati di eventi solari*

**Parametri**:

1. screen_name (String) : tag unico dell'utente del quale leggere i tweet
2. count (Integer) : numero di tweet da leggere

> GET /metadata 

*Restituisce i metadati relativi alle classi Tweet e SolarEvent*

**Parametri**:
*Nessun parametro richiesto*

> POST /stat/count/{event}

*Prende in ingresso un JSON contenente una lista di SolarEvent e restituisce una statistica (formato JSON) relativa al numero di eventi del tipo desiderato nell'intervallo di tempo desiderato*

**Variabili di percorso**:

1. event : nome dell'evento di cui calcolare la statistica (possibili valori: "flare", "geomagnetic_conditions", "geomagnetic_storm")

**Parametri**:

1. interval (String) : intervallo di tempo nel quale calcolare la statistica (possibili valori: "month", "year")
 
 > POST /stat/intensity/{event}

*Prende in ingresso un JSON contenente una lista di SolarEvent e restituisce una statistica (formato JSON) relativa all'intensità di eventi del tipo desiderato nell'intervallo di tempo desiderato*

**Variabili di percorso**:

1. event : nome dell'evento di cui calcolare la statistica (possibili valori: "flare", "geomagnetic_conditions", "geomagnetic_storm")

**Parametri**:

1. interval (String) : intervallo di tempo nel quale calcolare la statistica (possibili valori: "month", "year")

### Esempio di chiamata
> POST /stat/count/flare?interval="year"
> POST /stat/intensity/geomagnetic_storm?interval="month"
> GET /rawdata?screen_name=\_SpaceWeather\_&count=71
> GET /metadata
> GET /data?screen_name=\_SpaceWeather\_&count=42

### Diagrammi UML

##### Use Case Diagram

![](https://raw.githubusercontent.com/mattbn/SpringBootProject/master/usecase.png)

##### Class Diagram

![](https://raw.githubusercontent.com/mattbn/SpringBootProject/master/clsdiag.png)

##### Sequence Diagram
###### Richiesta GET /rawdata

![](https://raw.githubusercontent.com/mattbn/SpringBootProject/master/rawdata.png)

###### Richiesta GET /data

![](https://raw.githubusercontent.com/mattbn/SpringBootProject/master/data.png)

###### Richiesta GET /metadata

![](https://raw.githubusercontent.com/mattbn/SpringBootProject/master/metadata.png)

###### Richiesta POST /stat/intensity/{event}

![](https://raw.githubusercontent.com/mattbn/SpringBootProject/master/statsintensity.png)

###### Richiesta POST /stat/count/{event}

![](https://raw.githubusercontent.com/mattbn/SpringBootProject/master/statscount.png)

