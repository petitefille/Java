// Oppgave 1

interface Eldes {
	int alder();
}

class Dyr implements Eldes {
    private int alderen; //antall år;

    public int alder () { return alderen; }

    String navn;

    Dyr (String nvn, int ald) {
	navn = nvn;
	alderen = ald;
    }
}

class Pattedyr extends Dyr {
    Pattedyr (String nvn, int ald) {
	super(nvn,ald);
    }
}

class Fugl extends Dyr {
    Fugl (String nvn, int ald) {
	super(nvn,ald);
    }
}

class Primater extends Pattedyr {
    Primater (String nvn, int ald) {
	super(nvn,ald);
    }
}

class Giraff extends Pattedyr {
    Giraff (String nvn, int ald) {
	super(nvn,ald);
    }
}

class HomoSapiens extends Primater {
    HomoSapiens (String nvn, int ald) {
	super(nvn,ald);
    }
}

interface KleSegUt {
    void kleUtSom(Object obj);
    Object erKleddUtSom ();
}


class Ape extends Primater implements KleSegUt {
    Ape (String nvn, int ald) {
	super(nvn,ald);
    }

    Object som;  // peker til objektet this er kledd ut som

    public void kleUtSom(Object obj) {som = obj;}
    public Object erKleddUtSom () {return som;}
}

class Papegoye extends Fugl implements KleSegUt {
    Papegoye (String nvn, int ald) {
	super(nvn,ald);
    }

	Object som;

	public void kleUtSom(Object obj) {som = obj;}
	public Object erKleddUtSom () {return som;}
}


// Oppgave 2a

class Ko <E extends Eldes> {
	NodeAlder forsteAld;  // peker på yngste;
	NodeAlder sisteAld;   // peker på den eldste;
	NodeNummer forsteNr;  // peker på den med høyest nummer
	NodeNummer sisteNr;   // peker på den med lavest nummer

	static int nesteKoNummer;
	
// Viktig at det er to indre nodeklasser:

	class NodeAlder {
	    E denne;
	    NodeNummer andre;
	    NodeAlder (E inn) {
		denne = inn;
	    }
	    NodeAlder neste, forrige;
	}

	class NodeNummer {
	    int nummer;
	    E denne;
	    NodeAlder andre;
	    NodeNummer(E inn) { 
		denne = inn;
		nummer = nesteKoNummer;
		nesteKoNummer ++;
	    }
	    NodeNummer neste, forrige;
	}

	public void settInn(E inn) {
	    NodeAlder ald = new NodeAlder(inn);    // Lager to nodeobjekter
	    NodeNummer nr = new NodeNummer(inn);
	    // La de peke på hverandre ! :
	    ald.andre = nr;
	    nr.andre = ald;
	    // sett inn i nr-listen, alltid inn først:
	    if( forsteNr == null) {
		forsteNr = nr;
		sisteNr = nr;
	    } else {
		nr.neste = forsteNr;
		forsteNr.forrige = nr;
		forsteNr = nr;
	    }
	    // sett inn sortert i alder-listen:
	    if (forsteAld == null) {forsteAld = ald; sisteAld = ald;}
	    else if(forsteAld.denne.alder() > ald.denne.alder()) {
		ald.neste = forsteAld;
		forsteAld.forrige = ald;
		forsteAld = ald;
	    } else {
		NodeAlder loper = forsteAld.neste;
		while (loper!=null && loper.denne.alder()>ald.denne.alder()) {
		    ald.forrige = loper.forrige;
		    ald. neste = loper;
		    loper.forrige.neste = ald;
		    loper.forrige = ald;
		    break;
		}
		if (loper == null) {
		    sisteAld.neste = ald;
		    ald.forrige = sisteAld;
		    sisteAld = ald;
		}
	    }
	}

	public E tautYngst( ) {
	    NodeAlder taut = 	forsteAld;
	    if (taut != null) {
		forsteAld = forsteAld.neste;
		if (forsteAld == null) sisteAld = null;
		tautNr(taut.andre);
		return taut.denne;
	    } else return null;
	}

	public E tautMinstNr( ) {
	    NodeNummer taut = 	sisteNr;
	    if (taut != null) {
		sisteNr = sisteNr.forrige;
		if (sisteNr == null) forsteNr = null;
		tautAld(taut.andre);
		return taut.denne;
	    } else return null;
	}

	// De to neste metodene er svært like,
	// og det er OK å bare skrive den ene, 
	// og så vise i den andre hvor forskjellene ligger.

	private void tautNr(NodeNummer ut) {
	    // Antar at ut != null
	    if (forsteNr == ut && sisteNr == ut) {
		forsteNr = null; sisteNr = null;
	    }
	    else if (forsteNr == ut) forsteNr = forsteNr.neste;
	    else if (sisteNr == ut) sisteNr = sisteNr.forrige;
	    else {
		ut.forrige.neste = ut.neste;
		ut.neste.forrige = ut.forrige;
	    }
	}

	private void tautAld(NodeAlder ut) {
	    // Anter at ut != null
	    if (forsteAld == ut && sisteAld == ut) {
		forsteAld = null; sisteAld = null;
	    }
	    else 
		if (forsteAld == ut) forsteAld = forsteAld.neste;
		else 
		    if (sisteAld == ut) sisteAld = sisteAld.forrige;
		    else {
			ut.forrige.neste = ut.neste;
			ut.neste.forrige = ut.forrige;
		    }
	}
}

	

class Oppg2 { 

    //Oppgave 1c 
    
    public static void main (String[]a) {
	
	HomoSapiens kapteinSabeltann =
	    new HomoSapiens ( "Kaptein Sabeltann",200);

	Ape julius = new Ape ("Julius",20);
	
	Papegoye pol = new Papegoye("Polly", 10);

	julius.kleUtSom(kapteinSabeltann);

	Object kledd = julius.erKleddUtSom();

	if (kledd instanceof Dyr) {
	    Dyr dyret = (Dyr) kledd;
	    System.out.println(" Navnet på rollemodellen er: "
			       + dyret.navn);
	    System.out.println(" Alderen på rollemodellen er: "
			       + dyret.alder());

	}
    
	// Slutt oppgave 1c

	// oppgave 2b

	Ko<Dyr> pasienter = new Ko<Dyr>();

	pasienter.settInn(julius);
	pasienter.settInn(kapteinSabeltann);
	pasienter.settInn(pol);

	Giraff gir = new Giraff("Stankel", 5);
	pasienter. settInn(gir);

	Dyr nesteUt = pasienter.tautMinstNr();
	System.out.println("Den neste var: " + nesteUt.navn);
 
	Dyr enUng = pasienter.tautYngst();
	System.out.println("Den yngste var: " + enUng.navn);

    }
}


import java.util.*;

// Oppgave 3, vekt 40% 

// Oppgave 3a

class StorstAvTo {
    private int tallet;
    private int antallKalt = 0;

    public synchronized void leggInn (int tall) throws ForMangeKall {
	if (antallKalt == 2) throw new ForMangeKall();
	antallKalt ++;

	if (antallKalt == 1) {tallet = tall; return; }
	if (tall > tallet) tallet = tall;
	notify( );
    }
    
    public synchronized int hentUt( ) {
	if (antallKalt != 2) {   // while er kanskje sikrere
	    try {wait();}
	    catch (InterruptedException e) {} 
	}
	return tallet;
    }
}

class ForMangeKall extends Exception { }

// Oppgave 3b.

class FinnStorst extends Thread {
    int[] tab;
    int nedre, ovre;
    StorstAvTo monitor;
    FinnStorst (int []t, int ned, int ov, StorstAvTo mon) {
	tab = t; nedre = ned; ovre = ov; monitor = mon;
    }
    int trnr = 0;
    public void run ( ) {
	trnr++;
	System.out.println("Tråd nr " + trnr);
	if (ovre-nedre > 10000) {
	    StorstAvTo monMin = new StorstAvTo();
	    new FinnStorst(tab, nedre, nedre + (ovre-nedre)/2, monMin).start();
	    new FinnStorst(tab, nedre+((ovre-nedre)/2)+1,ovre, monMin).start();
	    int resultat = monMin.hentUt();
	    try {monitor.leggInn(resultat);}
	    catch (ForMangeKall e) { }
	} else {
	    int resultat = Integer.MIN_VALUE;
	    for (int ind = nedre; ind <= ovre; ind++) 
		if(tab[ind] > resultat) resultat = tab[ind];
	    try {monitor.leggInn(resultat);}
	    catch (ForMangeKall e) { }
	}
    }
}

// Oppgave 3c.

class Tabell {
    static  Random  rand = new Random();
    static final int LENGDE = 10000000;

    static public int [] lagTabell() {
	int [] tab = new int [LENGDE];
	for (int ind = 0; ind < LENGDE; ind++) 
	    tab[ind] = rand.nextInt();
	return tab;
    }
}

class Oppg3 {
    public static void main (String[]a){
        int [] tab = Tabell.lagTabell();
	StorstAvTo monitor = new StorstAvTo();
	try {monitor.leggInn(Integer.MIN_VALUE);} 
	// lurer tråden til å tro
	// at den ikke er alene slik at starten blir enkel
	catch (ForMangeKall e) { }

	new FinnStorst(tab, 0, tab.length-1 ,monitor).start();

	int resultat = monitor.hentUt();
	System.out.println("Største tall: " + resultat);
    }
}
