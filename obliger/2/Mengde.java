class Mengde<E>
{
    private Node første;
    private Node siste;
    private int antall;

    private class Node {
        Node(E e)
        { 
            objektet = e;
        }
        Node neste;
        E objektet;

       
   
    

    

        
    }
    
    Mengde()
    {
        første = null;
        siste = null;
        antall = 0;
    }

    
    public boolean tom()
    {
        Node n = første;
        return første == null;
    }          
    
  
    public boolean leggTil(E e)
   
    {
        Node n = new Node(e);
        if (inneholder(e) == true)
        { 
            return false;
        }
        else if (siste!= null && inneholder(e) == false)
        {
              
            siste = n;
            første = n;
            n.neste = null;   
            antall++;
            return true;
        }
       else 
       {
          
          n.neste = første;
          første = n;
          antall++;
          return true;
       }
       
        
    }

// en metode inneholder(E e) som skal returnere true dersom objeketet e peker på er i mengden, false dersom det ikke er med.

    public int antall() { return antall;}

    public boolean inneholder(E e)
    {
        
        Node n = første;
        while (n != null )
       {  
            if (n.objektet.equals(e))
            {       
                return true;
            }
            else
           {
               n = n.neste;
           }
        }
        return false;
           
    }    
    

            

        
      
// en metode fjernEldste() som fjerner og returnerer det elementet som har ligget lengst i mengden. (Først inn først ut, First In First Out, FIFO). Returnerer  null hvis mengden er tom.
 

    public E fjernEldste()
    {
        
        if (første == null)
        {
            return null;
        }
        else if (første.neste == null)
        {
            Node n = første;
            første.objektet = null;
            første = null;
            antall--;
            return n.objektet;
        }
        else 
        {
            Node temp = første;
            while (temp.neste.neste != null)
            {            
                temp = temp.neste;
            }
            temp = temp.neste;
            siste.objektet = null;
            siste = null;
            antall--;
            return temp.objektet;
        }
            
        
    }
    
// en metode fjernNyeste() som fjerner det elementet som ble lagt inn sist. (Sist inn først ut, Last in FirstOut, LIFO). Returnerer null hvis mengden er tom.



    public E fjernNyeste()
 
    {
        Node n = første;
        if (n != null)
        {
            antall--;
            første = n.neste;
            return n.objektet;
        }
        else return null;
    }
         


}

