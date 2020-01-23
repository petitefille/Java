class Mengde<E>
{
    private Node f�rste;
    private Node siste;
    private int antall;

    private class Node {
        Node(E e)
        { 
            objektet = e;
        }
        Node neste;
        Node forrige;
        E objektet;

       
   
    

    

        
    }
    
    Mengde()
    {
        f�rste = null;
        siste = null;
        antall = 0;
    }

    
    public boolean tom()
    {
        Node n = f�rste;
        return f�rste == null;
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
            f�rste = n;
            n.neste = null;   
            antall++;
            return true;
        }
       else 
       {
          
          n.neste = f�rste;
          f�rste = n;
          antall++;
          return true;
       }
       
        
    }

// en metode inneholder(E e) som skal returnere true dersom objeketet e peker p� er i mengden, false dersom det ikke er med.

    public int antall() { return antall;}

    public boolean inneholder(E e)
    {
        
        Node n = f�rste;
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
    

            

        
      
// en metode fjernEldste() som fjerner og returnerer det elementet som har ligget lengst i mengden. (F�rst inn f�rst ut, First In First Out, FIFO). Returnerer  null hvis mengden er tom.
 

    public E fjernEldste()
    {
        
        if (f�rste == null)
        {
            return null;
        }
        Node n = f�rste;
        Node p = null;
        while (n.neste != null)
        {   
            p = n;         
            n = n.neste;
        }
        if (p == null)
        {
            f�rste =null;
        }
        else
        {
            p.neste = null;
        }
        antall--;    
        return n.objektet;
        
            
        
    }
    
// en metode fjernNyeste() som fjerner det elementet som ble lagt inn sist. (Sist inn f�rst ut, Last in FirstOut, LIFO). Returnerer null hvis mengden er tom.



    public E fjernNyeste()
 
    {
        Node n = f�rste;
        if (n != null)
        {
            antall--;
            f�rste = n.neste;
            return n.objektet;
        }
        else return null;
    }
         


}

/*

Terminal> java Oblig2TestA
OK - tom() paa tom mengde returnerer true
OK - tom() paa ikke-tom mengde returnerer false
OK - inneholder() paa en tom mengde skal returnere false
OK - leggTil() med et nytt element skal returnere true
OK - inneholder() skal returnere false for elementer som ikke er i mengden
OK - inneholder() skal klare aa finne eldste element
OK - inneholder() skal klare aa finne et element midt i mengden
OK - inneholder() skal klare aa finne nyeste element
OK - leggTil() med et eksisterende element skal returnere false
OK - fjernEldste() paa en tom mengde skal returnere null
OK - fjernEldste() paa en mengde med ett element skal gi en tom mengde
OK - fjernEldste() skal returnere det forste objektet vi la inn
OK - fjernNyeste() paa en tom mengde skal returnere null
OK - fjernNyeste() paa en mengde med ett element skal gi en tom mengde
OK - fjernNyeste() skal returnere det siste objektet vi la inn
Terminal> java Oblig2TestB
OK - tom() paa tom mengde returnerer true
OK - tom() paa ikke-tom mengde returnerer false
OK - inneholder() paa en tom mengde skal returnere false
OK - leggTil() med et nytt element skal returnere true
OK - inneholder() skal returnere false for elementer som ikke er i mengden
OK - inneholder() skal klare aa finne eldste element
OK - inneholder() skal klare aa finne et element midt i mengden
OK - inneholder() skal klare aa finne nyeste element
OK - leggTil() med et eksisterende element skal returnere false
OK - fjernEldste() paa en tom mengde skal returnere null
OK - fjernEldste() paa en mengde med ett element skal gi en tom mengde
OK - fjernEldste() skal returnere det forste objektet vi la inn
OK - fjernNyeste() paa en tom mengde skal returnere null
OK - fjernNyeste() paa en mengde med ett element skal gi en tom mengde
OK - fjernNyeste() skal returnere det siste objektet vi la inn
Terminal> java Oblig2TestC

ANTALL FEIL: 0


*/

