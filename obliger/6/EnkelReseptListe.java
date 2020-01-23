import java.util.NoSuchElementException;
import java.util.*;

class EnkelReseptListe 
{

      protected Node<Resepter> forste;
	  protected Node<Resepter> siste;
      protected int antall;
      protected Resepter objektet;

   
   EnkelReseptListe(){
	
	forste = null;
	antall = 0;
    }
	
	  public Iterator<Resepter> iterator() { 
       return new EnkelListeReseptIterator();
   }

      private class EnkelListeReseptIterator implements Iterator<Resepter> {
       int teller = 0; 
       Node<Resepter> pekerTilNeste = forste;
       
       public boolean hasNext() { return ( teller < antall );}
     
       public Resepter next() {
	   Resepter returnerDenne = pekerTilNeste.objektet;
	   teller++ ;
	   pekerTilNeste = pekerTilNeste.neste;
	   return returnerDenne;
       }
   } 
   
   public void settInn(Resepter r)
   {
	   Node<Resepter> n = new Node<Resepter>(r);
        n.neste = forste;
        forste = n;
        antall++;
	   
   }
	

      
	
	
	
	
   
	
	
	
	public Resepter finn(int nummer)
	{
		
	    
		Node<Resepter> n1 = forste;
               
	    Resepter r1 = forste.objektet;
	    boolean identity = false;
	    if (n1 == null)
		{
	        throw new NoSuchElementException();
		}	
	    else if (n1.neste == null)
		{
		    if (r1.getNummer() == nummer) 
			{
			    return 	r1;
			}
            else
			{
			     throw new NoSuchElementException();
			}
        }
		else
		{
            while (n1.neste != null && identity != true) 
			{
			    if (r1.getNummer() == nummer) 
			    {
			        r1 = n1.objektet;	
                    identity = true;	
				}	
			    n1 = n1.neste;
			}
		}	
		if (identity == true)
		{
		    return r1;
		}
        else 
		{
		    throw new NoSuchElementException();
		}
	}	
            		
				
				
}	


  
	

