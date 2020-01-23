import java.util.NoSuchElementException;
import java.util.Iterator;
class SortertEnkelListe<T extends Comparable<T> & Lik> implements AbstraktSortertEnkelListe<T> 
{


    private Node<T> forste;
    private int antall;
	private T objektet;
	
	
	
	 SortertEnkelListe(){
	
	forste = null;
	antall = 0;
    }


	
	
	
	
		
	
	    
	
	
        public boolean samme(String nokkel)
	   {
		
	        return (this.objektet.equals(nokkel));
	   }
	
	 
	   
   public Iterator<T> iterator() { 
       return new SortertEnkelListeIterator();
   }
   
   
   

   private class SortertEnkelListeIterator implements Iterator<T> {
       int teller = 0; 
       Node<T> pekerTilNeste = forste;
       
       public boolean hasNext() { return ( teller < antall );}
   
       public T next() {
	   T returnerDenne = pekerTilNeste.objektet;
	   teller++ ;
	   pekerTilNeste = pekerTilNeste.neste;
	   return returnerDenne;
       }
   } 
				
		 

     public void leggTil(T t)
    {
	    
	       
		
		    Node<T> n = new Node<T>(t);
			Node<T> m = n;
			Node<T> l = n;
			Node<T> n1 = forste;
			//Node<T> n2 = n1.neste;
			Node<T> verdi = forste;
			Node<T> verdi2 = null; 
			boolean identity = false;
			if (n1 == null)
			{
			    forste = n;
				antall++;
				
			}
			else if (n1.neste == null)
			{
				
				
			    if (n1.objektet.compareTo(n.objektet) > 0 ) 
				{
				    
				    n1.neste = n1;
                    n1 = n;
					antall++;
				}
                else
                {
				    n1.neste = n;
					antall++;
					
				}				
			}		
            else
			{
			    
			    while (n1.neste != null && identity != true)
				{
					
				    
			        if (n1.objektet.compareTo(n.objektet) >= 0)
					{
				        verdi2 = n1;
						identity = true;
						
						
					}						 
					n1 = n1.neste;
				}
                if (identity == true)
                {
					
					this.objektet = verdi2.objektet;
				    Node<T> n3 = forste;
				    while (n3.objektet.compareTo(n3.objektet) != 0)
					{
						
					    n3 = n3.neste;
					}
					n3.neste = n3;
					n3 = n;
					antall++;
					
				}				
				
				if (identity == false)
				{
                    while (verdi.neste != null)
					{
					    verdi = verdi.neste;
					}	
                    verdi.neste = n;
					antall++;
					
				}
                			
			}
			
			
		
        	
	}		
			
			
			
	
            
        
      
       

	public T finn(String nokkel)
	{
	    Node<T> n1 = forste;
		Node<T> verdi = forste;
		boolean identity = false;
		if (n1 == null)
		{
		    throw new NoSuchElementException();
		}
		else if (n1.neste == null)
		{
		    T oN1 = n1.objektet;
			this.objektet = oN1;
		    if (samme(nokkel) == true)
			{
			    return oN1;
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
			    T oN1 = n1.objektet;
				this.objektet = oN1;
			    if (samme(nokkel) == true)
				{
				    verdi = n1;
					identity = true;				
				}
				n1 = n1.neste;
			}
			if (identity == true)
			{
			    return verdi.objektet;
			}
			else
			{
			    throw new NoSuchElementException();
			}
		}
         
    }
	
	


}


