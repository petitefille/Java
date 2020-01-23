public class TestTabell
{
    public static void main (String[] args)
   {
	 // Vanlige tilfeller blir testet
	  
	// tester om man lage en array hvor man kan lagre alle elementene ved aa oppgi arrayens lengde som parameter til konstruktoeren
	Tabell<Personer> TabellPersoner;
	TabellPersoner = new Tabell<Personer>(5);
	   
	// tester om man kan sette inn flere objekt inn i tabellen paa en oppgitt plass (indeks)
	   
    Personer p1 = new Personer("Jens Hans Olsen", 11223344556L);
    p1.adresse("Storgata", "67", "5431");
    Personer p2 = new Personer("Ane Rask", 29117091241L);
    p1.adresse("Storgata", "67", "5431");
	Personer p3 = new Personer("Johan-Niclas Ingmarson", 31018253352L);
	p1.adresse(" Akebakken", "7", "3522");
	boolean a1 = TabellPersoner.settInn(3,p1);
	boolean a2 = TabellPersoner.settInn(4,p2);
	boolean a3 = TabellPersoner.settInn(5,p3);
	
	// tester om det er mulig aa finne et objekt basert paa en indeks
	Personer  p7 = TabellPersoner.finn(3);
	
	// tester om det er mulig aa iterere over listen
	TabellPersoner.iterator();
	Personer p8 = TabellPersoner.iterator().next();
	
		
	//Spesialtilfeller blir testet 
	// tester at det ikke er restriksjoner paa hva slags elementer den abstrakte tabellen skal kunne inneholde
	Tabell<Leger>  TabellLeger;
	Tabell<Resept> TabellResept;
	Tabell<Legemiddel> TabellLegemiddel;
	
	TabellLeger = new Tabell<Leger>(6);
	TabellResept = new Tabell<Resept>(6);
	TabellLegemiddel = new Tabell<Legemiddel>(6);
	
	Leger l1 = new Leger("Dr. Dre");
	Resept r1 = new Resept();
	Legemiddel lm1 = new Legemiddel("Predizol",450); 
	
	boolean a4 = TabellLeger.settInn(5,l1 );
	boolean a5 = TabellResept.settInn(6,r1 );
	boolean a6 = TabellLegemiddel.settInn(1,lm1);
        
	// tester om det er mulig aa sette inn et element naar man oppgir en indeks som er stoerre enn lenge paa beholderen
	Personer p4 = new Personer("Charles Dupont", 820396183645L);
	p1.adresse(" Dyrebakken", "86", "8927");
	boolean a7 = TabellPersoner.settInn(9,p4);
	
	// tester om man kan hente et element inn paa en plass som ikke eksisterer, og om metoden settInn da returnerer usann
	Personer p5 = new Personer("Charles Dupont", 820396183645L);
	p1.adresse(" Dyrebakken", "86", "8927");
	boolean a8 = TabellPersoner.settInn(-3,p4);
	
    // tester om man kan finne et objekt paa en indeks der det ikke er noe element		
	
	Resept  r3 = TabellResept.finn(1);	
	
	
	Resept  r4 = TabellResept.finn(90);	
		
		
		
   }	
    
}

