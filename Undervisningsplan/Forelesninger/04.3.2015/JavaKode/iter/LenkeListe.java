import java.util.*;
public class LenkeListe <T> implements Iterable<T> {

    private Node foran;
    private int antall;
    
    private class Node {
	Node (T t) { obj = t; }
	Node neste;
	T obj;

	void skrivUtInfoOmObjektetINoden() {
	    System.out.println(obj);
	}
    
    }

    public Iterator<T> iterator() { return new MyIterator(); }

    private class MyIterator implements Iterator<T> {
	Node it = foran;

	public boolean hasNext() { return it != null; }

	public T next() {
	    T returverdi = it.obj;
	    it = it.neste;
	    
	    return returverdi;
	}

	public void remove() {}
	
    }

    
    /* 
       Invariante tilstandspÃ¥stander (skal gjelde fÃ¸r og etter alle metodekall,
       uansett rekkefÃ¸lge av kallene):

       - foran peker pÃ¥ fÃ¸rste node i lista
       - Bare bakerste node har en nestepeker som er null
       - antall er antallet noder og objekter av type T i lista

       - NÃ¥r lista er tom skal (tilstanden etableres av konstruktÃ¸r):
            - antall innholde tallet 0
	    - foran peke pÃ¥ null
    */
       
    
    LenkeListe(){
	// skal etablere datastrukturen for tom liste:
	foran = null;
	antall = 0;
    }

    public void settInnForan(T t) {
	System.out.println("Setter inn et objekt av klassen "
			   + t.getClass().getName()
			   + ": " + t);
	
	Node n = new Node(t);
	n.neste = foran;
	foran = n;
	antall++;
    }
    
    public void skrivUtInfoOmAlleObjekteneILista() {
	Node n = foran;
        for (int i = antall; i>0; i--) {
	    n.skrivUtInfoOmObjektetINoden();
	    n = n.neste;

	}
    }

}








