import java.util.*;
public class LenkeListe <T extends Rute> implements Iterable<T> 
{

    protected Node foran;
	protected Node siste;
    private int antall;
    
    protected class Node {
	Node (T t) { obj = t; }
	Node neste;
	T obj;

	void skrivUtInfoOmObjektetINoden() {
	    System.out.println(obj);
	}
    
    }

    public Iterator<T> iterator() { return new MyIterator(); }

    protected class MyIterator implements Iterator<T> {
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
       Invariante tilstandspåstander (skal gjelde før og etter alle metodekall,
       uansett rekkefølge av kallene):

       - foran peker på første node i lista
       - Bare bakerste node har en nestepeker som er null
       - antall er antallet noder og objekter av type T i lista

       - Når lista er tom skal (tilstanden etableres av konstruktør):
            - antall innholde tallet 0
	    - foran peke på null
    */
       
    
    LenkeListe(){
	// skal etablere datastrukturen for tom liste:
	foran = null;
	antall = 0;
    }

    public void settInnBak(T t) {
	//System.out.println("Setter inn et objekt av klassen "
			   //+ t.getClass().getName()
			   //+ ": " + t);
	
	Node n = new Node(t);
	if (siste != null) {
		siste.neste = n;
		n.neste = null;
		siste = n; 
	}
	else{
		siste = n;
		foran = n;
		n.neste = null; 
	}
	antall++;
    }
	
	public T taUt() // tar ut foran
	{
		Node n = foran; 
		if (n!= null)
		{
			antall--;
			foran = n.neste;
			return n.obj;
		}
        else return null; 		
	}
    
    public void skrivUtInfoOmAlleObjekteneILista() {
	Node n = foran;
        for (int i = antall; i>0; i--) {
	    n.skrivUtInfoOmObjektetINoden();
	    n = n.neste;

	}
    }

}