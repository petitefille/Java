import java.util.NoSuchElementException;

class EnkelReseptListe 
{
	protected int antall;
	protected Node<Resept> forste;
	protected Node<Resept> siste;
	
	public Resept iterate()
		{
		    Node<Resept> n1 = forste;
		    //Node n2 = n1.neste;
		    Node<Resept> verdi = n1;
			
		
		    if (n1 == null)
			{
			    return null;
			}
		    else 
			{
			    return n1.objektet;
			}
		}	
	
	
	
   
	
	
	
	public Resept finn(int nummer)
	{
		
	    
		Node<Resept> n1 = forste;
	    Resept r1 = forste.objektet;
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
            while (n1.neste != null) 
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


  
	
