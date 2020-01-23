import java.io.*;

class Klokke {
    public static void main(String[] args) throws IOException
	{
	    System.out.println("Trykk [ENTER] for aa starte og aa stoppe");
		
		// oppretter en nytt objekt av klassen InputStreamReader som vil kunne lese inn ny linje 
		BufferedReader minInn = new BufferedReader (new InputStreamReader(System.in));
		// denne linjen leser inn det foerste ENTER tastet 
		minInn.readLine();
		
		//Her lages stoppeklokke-objektet som er en subklasse av klassen Thread:
		Stoppeklokke stoppeklokke = new Stoppeklokke(); 
		
		// og her settes den nye traaden i gang. Start metoden starter run metoden som gaar videre i parallel med følgende 
		// program
		stoppeklokke.start();
        // her venter main-traaden paa at Enter blir tastet   		
		minInn.readLine();
		// metode avslutt i stoppeklokke-objektet blir kalt
		stoppeklokke.avslutt();
		// naar baade main og andre traaden er terminerte, saa terminerer hele den Java virtuelle maskinen
	}
}

class Stoppeklokke extends Thread {
	/* volatile: nytt reservert ord i Java
	saa variabelen stopp av type boolean er volatile
	_ den skal ikke caches, den skal hele tiden skrives tilbake til minne for det kan hende 
	det er andre traader som ogsaa oensker aa se paa denne variabelen
	_ volatile fordi man kan  ikke ha lokal kopi i egen cash for da faar ikke andre sett resultatet av skrivingen
	_ altsaa naar det gjelder traader kan kam deklarere enkelte variabler som volatile hvis andre traader skal se
	paa disse variablene
	_ bruker annen metoden hvis det er en gruppe variabler andre traader skal kunne ha tilgang til og bruke
	
	*/
    private volatile boolean stopp = false;
	// blir kalt opp av superklassens start-metode.
	public void run() {
	    int tid = 0;
		// saa lenge stopp er false gaar man i loekke
		while(!stopp) {
			
		    System.out.println(tid++);
			try {
				//sleep metode i klasse Thread 
				// traaden sover / gjoer ingenting, venter 1 millisek * 1000 = 1 sek 
			    sleep(1 * 1000); // ett sekund
				// pga man kan avbryte traader saa maa man fange unntak 
				} catch (InterruptedException e) {}
		}
	}
	//maaten traaden blir stoppet paa er hvis metoden avsluttet blir kalt
	// fordi da settes variabelen stopp til true, saa neste gang stop variabelen blir testet
	// (linje 42), hentes denne variabelen opp fra minne hvorden staar deklarert som true, og dermed
	// saa skal ikke loekken kjoeres lenger, og traaden terminerer
	public void avslutt() { stopp =  true; }
}	

/*
Terminal> java Klokke
Trykk [ENTER] for aa starte og aa stoppe

0
1
2
3
4
5

*/