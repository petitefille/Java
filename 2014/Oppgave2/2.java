/*
 flettesortere 2 lenkede lister, dvs man skal kombinere to allerede sorterte lister  til en ny sortert liste 
 
 naermere beskrivelse:
 
 skrive en metode kalt flettEnkelLister som har 2 parametere (pekere til foerste Node i de to allerede sorterte listene) som 
 returnere en peker til den forste noden i den nye kombinerte listen 
 
 programmet skal følgelig flytte nodene fra de allerede sorterte listene over til den nye listen, slik at den nye listen til slutt
 er sortert og inneholder alle nodene fra de to listene 
 
 sorteringskriteriet er  slik at noder med minst verdi er foerst i listen 
 
 Node-objektene inneholder en nestepeker, slik at listene i denne oppgaven er enkel-kjedete lister 
 
 
 I oppgave 2b brukes et grensesnitt til aa definere nodene i listene som skal flettes
 
 oppgave 2B: fletting med noder definert vha. et grensesnitt: 
 
 skriv metoden flettEnkelLister i klassen Fletting
 
 class Fletting {
     public stativ GrNode flettEnkleLister(GrNode liste1, GrNode Liste2) {
	     ...
     }
 }

Grensesnittet GrNode er definert slik: 

inteface Comparable<T> {
	
	comparableTo(T o);
}

interface GrNode extends Comparable<GrNode> {
	GrNode hentNeste();
	voidsettNeste(GrNode gn);
	
} 

legg merke til at man ikke kan manipulere neste-pekerne i lister ned slike noder direkte. Man maa isteden gjoere det ved hjelp av 
metodene hentNeste() og settNeste()
Listene er sortert ved hjelp av compareTo-metodene 

(merk at man bare skal skrive metoden flettEnkelLister, ikke noe annet)

Om bruk av static-metoder:
Legg merke til at flettEnkleLister - metodene er static. I INF1010 skal man egentlig vite hva en static-metode er,
men i denne oppgaven spiller det ingen rolle

Om flettesortering:

Naar man fletter to sorterte sekvenser, ser man for seg at de ligger ved siden av hverandre og at man saa trer dem i hverandre, 
lignende det man gjoer naar man fletter tau eller fletter haar 
UTSKRIFT (VIKTIG)
Her er et eksempel der man fletter to sekvenser med tall 
Ferdig sortert1: 2, 7, 12, 23, 29
Ferdig sortert2: 3, 19, 23, 31, 33, 51

Resultat av aa flette 1 og 2:
2,3,7,12,19,23,23,29,31,33,51

Her er et eksempel der man 


 /*