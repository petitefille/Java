import java.io.*;

class Klokke2 {
    public static void main(String[] args) throws IOException
	{
	    System.out.println("Trykk [ENTER] for aa starte og aa stoppe");
		
		// oppretter en nytt objekt av klassen InputStreamReader som vil kunne lese inn ny linje 
		BufferedReader minInn = new BufferedReader (new InputStreamReader(System.in));
		// denne linjen leser inn det foerste ENTER tastet 
		minInn.readLine();
		
		// ENDRING:
		//opprette nytt Stoppeklokke-objekt som ogsaa er et Runnable-objekt siden den implementerer interfacet Runnable
		Stoppeklokke stoppeklokke = new Stoppeklokke();
		//ENDRING: 
		// Opprette vanlig Thread objekt, og ikke et subklasse-objekt av klassen Thread
		// Konstruktoeren Thread() har et objekt som parameter som peker til et Runnable-objekt, altsaa stoppeklokke
		Thread mintrad = new Thread(stoppeklokke); 
		
		//ENDRING:
		// traaden mintrad maa startes hvor start metoden ligger 
		mintrad.start();
        // her venter main-traaden paa at Enter blir tastet   		
		minInn.readLine();
		
		// INGEN ENDRING:
        // stoppeklokke.avslutt() er riktig fordi avslutt metoden er i runnable-objektet som er blitt opprettet for seg 		
		stoppeklokke.avslutt();
		// naar baade main og andre traaden er terminerte, saa terminerer hele den Java virtuelle maskinen
	}
}

class Stoppeklokke implements Runnable {
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
	
	public void run() {
	    int tid = 0;
		// saa lenge stopp er false gaar man i loekke
		while(!stopp) {
			
		    System.out.println(tid++);
			try {
				//sleep metode i klasse Thread 
				// traaden sover / gjoer ingenting, venter 1 millisek * 1000 = 1 sek 
				// ENDRING:
				// sleep() er en metode i klassen Thread og foer var stoppeklokke en subklasse av klassen Thread.
				// Fordi man var inn i denne subklassen hadde man tilgang til sleep(). Men naa er man inn i et helt frittstaaende 
				// objekt (stoppeklokke) som bare implementerer grensesnittet Runnable. Sleep()-metoden er da ikke kjent i dette 
				// grensesnittet. Men sleep() er en statisk metode saa man kan kalle den ved aa si Thread sin sleep: Tread.sleep(). 
				// HUSK AT: statiske metoder i en klasse faar man tak i ved aa si klassenavnet og saa navnet paa metoden.
			    Thread.sleep(1 * 1000); // ett sekund
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
Terminal> java Klokke2
Trykk [ENTER] for aa starte og aa stoppe

0
1
2
3
4
5
6
7
8
9
10
*/	
