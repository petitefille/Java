import java.util.ArrayList;
import java.lang.InterruptedException;


class OrdBuffer 
// monitor
//Mellom arbeiderne er det buffere.
/*
En buffer kan ta vare paa et ord det faar av en arbeider, og neste arbeider i samlebaandet kan hente ord fra denne bufferen. 
Arbeider nummer 1 leser et og et ord fra filen, og finner og tar vare på det (leksikalsk) minste ordet i filen, dvs det som er minst 
når man sammenligner med comapreTo(). Alle andre ord sendes videre til arbeider 2 via bufferen mellom disse to arbeiderne. Dersom bufferen
er full maa arbeider 1 vente. Naar hele filen er lest skriver arbeider 1 ut ved hjelp (ved hjelp av System.out.println) at den 
er nummer 1 og det minste ordet den fant, go saa tils slutt, foer dden terminerer, sender den en null-peker til bufferen.

Arbeider nummer 2 henter ord fra denne bufferen. Er det ingen ord i bufferen maa arbeider 2 vente. Arbeider 2 sin oppgave er aa finne
det minste ordet i filen, dvs. det minste ordet som kommer fra arbeider 1. Alle andre ord sendes videre til atbeider 3 via bufferen
mellom arbeider 2 og 3.  Er denne arbeideren full maa arbeider 2 vente. Naar arbeider 2 er ferdig (henter en null peker fra bufferen)
, skriver den ut (ved hjelp av System.out.println) at den er nummer 2 og det minste ordet den har sett, og sender en null-peker til det
etterfoelgende bufferen*/

{
	

	// private variabler som tilhører monitoren av klassen OrdBuffer
	
	// bufferen skal ha en maskimal kapasitet, og for enkelthets skyld sier man at bufferen kan ta vare paa inntil 10 ord 
	// peker med navn ORD_KAPASITET av klassen Integer som peker paa et objekt av klassen Integer: 10
	private int ORDBUFFER_KAPASITET = 10;
	
	//ordBuffer listen som inneholder antall ord (maks 10 ord)
	//peker med navn ordBuffer av klassen ArrayList String 
	private ArrayList<String> ordBuffer;
	
	//nummeret til ordBufferen (fra 0 (kun 2 arbeidere) til N(=antalll arbeidere/traader)-2 )
	// peker med navn ordBufferListe av klassen Integer av typen statisk settes til aa peke paa 0
	private static int counter = 1;
	
	private int ordBufferNr = 0;
	
	//antall ord i OrdBuffer som alle peker paa et objekt av klassen String
	// peker med navn antallOrd av klassen int settes til aa peke til et objekt av klassen Integer: 0
	private int antallOrd = 0; 
	
	//antall pekere som peker til null
	// peker med navn antallNullPekere av klassen Integer settes til aa peke paa et objekt av klassen Integer: 0
	private int antallNullPekere = 0;
	
	
	
	//Konstruktoeren til monitoren 
	// en parameter: en peker med navn heltall av klassen Integer som peker paa et objekt av klassen Integer som representerer
	// ordBufferNr til ordBuffer-objektet som opprettes naar denne konstruktoeren blir kalt
	public OrdBuffer()
	{
		//pekeren ordBuffer settes til aa peke paa et nytt objekt av klassen ArrayList<String> og med stoerrelse 10
		// her kan man da sette inn ordene
		// antall ord er null for oeyeblikket
		// antall nullpekere er null for oyeblikket
		ordBuffer = new ArrayList<String> (ORDBUFFER_KAPASITET);
		
		//pekeren ordBufferNr settes til aa peke paa det samme som heltall peker paa, nemlig et objekt av klassen Integer som 
		// representerer ordBufferNr til OrdBuffer-objektet som opprettes naa 
        ordBufferNr = ordBufferNr + counter++;
	}

        
        
	
	
	      
          
	
	public synchronized void settInnNullPeker()
	{
        while (antallOrd >= 10)
		{
			try {
				wait();
			} catch(InterruptedException e) {}
		}
        antallNullPekere++;
        String nullpeker = null;
        for (int i = 0; i < ordBuffer.size(); i++)
        {
			if(ordBuffer.get(i) == null){
				ordBuffer.add(i, nullpeker);
				i = ordBuffer.size();
			}
				
		}
		System.out.println("ArbeiderNr " + ordBufferNr + " har satt inn null peker i OrdBufferNr " + ordBufferNr );
        notify();		
            
                	
	}
	
	// Alle ord gaar via bufferene (monitorene) mellom arbeiderne (traadene)
	// Arbeider sender alle ord videre til bufferen sin  
	//er denne bufferen full maa arbeideren vente 
	public synchronized void settInnOrdIOrdBuffer(String ord)
	{
		// her tester man om ordBuffer er full for i dette tilfelle maa arbeider vente 
		// da den ikke kan sette inn flere ord 
		
		// saa lenge antall ord i ord bufferen er stoerre eller lik 10 saa gar man inn i denne loekka 
        while (antallOrd >= 10 )
        {
			// gaar inn i try loekken 
			try {
				// traaden venter 
				wait();
			} catch(InterruptedException e) {} // behandler avbrudd 
		}
        // Naa er antall ord i Buffer som ikke peker paa null mindre enn 10	

        // man setter inn et ord i OrdBuffer saa antall ord i ordBufferen oeker med en 		
        antallOrd++;
		
		// man legger til ordet i ordBufferen 
        ordBuffer.add(ord);
		// skriver ut informasjon 
        System.out.println("OrdBufferNr " + ordBufferNr + " har mottatt ord: " + ord + " fra arbeiderNr" + ordBufferNr);
		// vekker traad some henter ord 
        notify();		
               
    	
	}
	
	public synchronized String hentOrdFraForrigeOrdBuffer()
	{
		// hvis antall ord i bufferen er 0 og antall null pekere er 1 returneres en null peker 
		if (antallOrd == 0 && antallNullPekere == 1)
		{
			String nullpeker = null;
			return nullpeker; 
		}
        else
        {
			// tester om ordBuffer er tom 
			while (antallOrd == 0)
			{
			    try {
					wait();
				} catch(InterruptedException e) {}				
			} // naa er ikke listen tom
		    antallOrd--;
			String ord = null;
			for (int i = 0; i < ordBuffer.size(); i++)
			{
				if (ordBuffer.get(i) != null)
				{
					ord = ordBuffer.get(i);
					ordBuffer.remove(i);
					i = ordBuffer.size();
				}	
			}
            notify();
            return ord;			
			
		}			
	} 
           
            
                
	
}

