import java.util.* ;

public class LenkeListe <T extends Skattbar> implements Iterable<T> {

    private Node foran;
    private int antall;
    
    private class Node {
	Node (T t) { obj = t; }
	Node neste;
	T obj;
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

   public Iterator<T> iterator() { 
       return new LenkeListeIterator();
   }

   private class LenkeListeIterator implements Iterator<T> {
       int teller = 0; 
       Node pekerTilNeste = foran;
       
       public boolean hasNext() { return ( teller < antall );}
       public void remove() {}
       public T next() {
	   T returnerDenne = pekerTilNeste.obj;
	   teller++ ;
	   pekerTilNeste = pekerTilNeste.neste;
	   return returnerDenne;
       }
   }  

   public void settInnForan(T t) {
       if (t instanceof Bil)
	   System.out.println("Setter inn en bil: " + t);
       else
	   System.out.println("Setter inn noe annet: " + t);
       
       Node n = new Node(t);
       n.neste = foran;
       foran = n;
       antall++;
   }
   
   
   public T taUtForan() {
       Node n = foran;
       if (n != null) {
	   foran = n.neste;
	   return n.obj;
       }
       else return null;
   }


   public void testType(T o) {
       if (o instanceof Bil)
	   System.out.println(" ..... er en bil (Bil eller subklasse av Bil) !");
       else 
	   System.out.println(" ...... noe skattbart !");
       
   }

   public void skrivUtInfoOmAlleObjekteneILista() {
       Node n = foran;
       for (int i = antall; i>0; i--) {
	   System.out.print(n.obj.toString()
			    + ", " + n.obj.hashCode()
			    + ", " + n.obj.getClass().getName()
			    );
	   testType(n.obj);
	   
	   if (n.obj instanceof Bil)
	       System.out.println("     Dette var faktisk en bil med skatt: "
				  + ((Bil)n.obj).skatt() );
	   
	   if (n.obj.getClass().getName().equals("Drosje")) {
	       System.out.println("    Dette var faktisk en drosje med skatt: "
				  + ((Drosje)n.obj).skatt() );
	   }
	   
	   if (n.obj instanceof Bil)
	       System.out.println("     Dette var faktisk en bil med skatt: "
				  + ((Bil)n.obj).skatt() );
	   
	   
	   n = n.neste;
	   
       }
   }
   
   public void skrivUtAlleSkattebelagte() {
       System.out.println(" SKATTEBELAGTE: ");
       Node n = foran;
       for (int i = antall; i>0; i--) {
	   System.out.println("Et skattebelagt objekt (" + n.obj
			      + ") med skatt: "
			      + n.obj.skatt() );
	   n = n.neste;
       }
       
   }
   
}
