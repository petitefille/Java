public class LenkeListe <T> {

    private Node foran;
    private int antall;
    
    private class Node {
	int nodeNr = 0;
	Node neste;
	T obj;

	Node (T t) { 
	    obj = t;
	    nodeNr = ++antall;
	}


	void skrivUtInfoOmObjektetINoden() {
	    System.out.println( obj.toString()
				//  + ", hashcode: " + obj.hashCode()
			      + ", objekt av klassen " + obj.getClass().getName()
			    );
	}


	void skrivUtDenneNodenOgResten() {
	    System.out.println("skrivUtDenneNodenOgResten kalt i node nr " + nodeNr);
	    skrivUtInfoOmObjektetINoden();
	    if (neste != null) neste.skrivUtDenneNodenOgResten();
	    System.out.println("skrivUtDenneNodenOgResten i node nr " + nodeNr + " avslutter");
	}

	void skrivUtRestenTilSluttDenneNoden() {
	    System.out.println("skrivUtRestenTilSluttDenneNoden kalt i node nr " + nodeNr);
	    if (neste != null) neste.skrivUtRestenTilSluttDenneNoden();
	    skrivUtInfoOmObjektetINoden();
	    System.out.println("skrivUtRestenTilSluttDenneNoden i node nr " + nodeNr + " avslutter");
	}
	    
    }


    /* 
       Invariante tilstandspÃ¥stander (skal gjelde fÃ¸r og etter alle metodekall,
       uansett rekkefÃ¸lge av kallene):

       - foran peker pÃ¥ fÃ¸rste node i lista
       - Bare bakerste node har en nestepeker som er null

       - NÃ¥r lista er tom skal (tilstanden etableres av konstruktÃ¸r):
            - antall innholde tallet 0
	    - foran peke pÃ¥ null
    */
       
    
    LenkeListe(){
	// skal etablere datastrukturen for tom liste:
	foran = null;
	antall = 0;
    }

    /* Metoder som er pÃ¥krevd fra det navngitte grensesnittet Stabel<E> */

    public void settInnForan(T t) {
	System.out.println("Setter inn et objekt av klassen "
			   + t.getClass().getName()
			   + ": " + t);
	
	Node n = new Node(t);
	n.neste = foran;
	foran = n;
	//	antall++;  gjÃ¸res i konstruktÃ¸ren
    }

    public void skrivUtInfoOmAlleObjekteneIListaXXX() {
	Node n = foran;
        for (int i = antall; i>0; i--) {

	    n.skrivUtInfoOmObjektetINoden();
	    n = n.neste;

	}
    }

    public void skrivUtInfoOmAlleObjekteneILista() {
	if (foran != null) {
	    foran.skrivUtDenneNodenOgResten();
	}
    }

   public void skrivUtInfoOmAlleObjekteneILista2() {
	if (foran != null) {
	    foran.skrivUtRestenTilSluttDenneNoden();
	}
    }
    


}








