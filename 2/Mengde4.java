// skrive en klasse med en generisk parameter som beskriver en beholder som tar vare på vilkårlig mange objekter av samme type
// klassen heter Mengde<E>


public class LinkedList<E>
{    
    // Constructs an empty list
    public LinkedList()
    {
        Nyeste = null;
    }

    

// Removes the first element in the linked list.
//@return the removed element
    public E getNyeste()
    {
        if (Nyeste == null)
        {
            return null; 
        }            
        E e = Nyeste.data;
        Nyeste = Nyeste.next;
        return e;
    }    
        
  

    public E fjernNyeste()
    { 
        if (Nyeste == null)
        {
            return null;
        }
        E e = Nyeste.data;
        Nyeste = Nyeste.next;
        return e;
    }
// Adds an element to the front of the linked list
// @param element the element to add
    public void LeggTilNyeste(E e)
    { 
        Node newNode = new Node();
        newNode.data = e;
        newNode.next = Nyeste;
        Nyeste = newNode; 
    }



// Returns an iterator for iterating through this list
// @return an iterator for iterating through this list

    public ListIterator<E> listIterator();
    {
        return new LinkedListIterator();
    }
   
    private Node Nyeste;

    private class Node
    {
        public E data;
        public Node next;
    } 
 

    // indre klasse Node som beskriver objekter som lenkes
    // sammen og som  hver holder på ett objekt av typen E

    // Datastrukturen i Mengde er ei lenkeliste av slike nodeobjekter

    // Det er ikke mulig å legge til et objekt som finnes i beholderen fra før

// Grensesnitt i Mengde<E>

    
// En metode tom() som returnerer true hvis mengden er tom, false hvis 
// mengden har minst ett objekt

// en metode legg til (E e) som legger objektet e peker på inn i mengden hvis det ikke er i mengden fra før. Metoden skal returnere true dersom objektet ble satt inn, false dersom det var der før. Metoden legger objektet til mendgen ved å opprette et nytt objekt av nodeklassen. Nodeobjektet som har en pekervariabel av type E som settes til å peke på e, som lenkes inn på lenkelista. 

    
 

// en metode fjernEldste() som fjerner og returnerer det elementet som har ligget lengst i mengden. (Først inn og først ut, First Inn First Out, FIFO). Returnerer null hvis mengden er tom.

    private class LinkedListIterator implements ListIterator<E>
    {
        // Constructs an interator that points to the front of the linked list
        public void LinkedListedIterator()
        {
            position = null;
            previous = null;
        }
        
        // Moves the iterator past the next element
        // @return the traversed element

        public E next()
        {
            if (!tom())
            {
                return null;
            }
            previous = position; //Remember for remove

            if (position == null)
            {
                position = position.next;
            }

            else
            {
                position = position.next;
            }
            return position.data;
        }

// Tests if there is an element after the iterator position.
// @return true if there is an element after the iterator position

        public boolean tom()
        {
            if (position == null)
            {
                return Nyeste != null;
            }
            else
            {
                return position.next != null;
            }
        }

        

// Adds an element before the iterator position and moves the 
// iterator past the inserted element
// @param element the element to add
        public boolean LeggTil(E e)
        {
            if (position == null)
            {
                LeggTilNyeste(e);
                position = Nyeste;
                return true;
            }
            else
            {
                Node newNode = new Node();
                newNode.data = e;
                newNode.next = position.next;
                position.next = newNode;
                position = newNode;
                return false;
            }
            previous = position;
        }

            


// en metode fjernNyeste() som fjerner og returnerer det elementet som ble lagt inn sist. (Sist inn først ut, Last in First Out, LIFO). Returnerer null hvis mengden er tom.

// Removes the last traversed element. This method may only be called after
// a call to the next() method

        public E fjernEldste()
        {
            if (previous == position)
            {
                return null;
            }
            if (position == Nyeste)
            {
                fjernNyeste();
            }
            else  
            {
                previous.next = position.next;
            }
            position = previous;
        }


   
       
           

// Sets the last traversed element to a different value

// @param element the element to set

        public boolean inneholder(E e)
        { 
            if (position == null)
            {
                return true;
            }
            else
            {
                return false;
            }            
            position.data = e;
        }
    
        private Node position;
        private Node previous;
    }
}




   // en metode inneholder (E e) som skal returnere true dersom objektet e peker på er i mengden, false dersom det ikke er med. 

// alle metoden er public

// man kan fritt legge til andre objekter, men skriv disse 5 metoden etter
// hverandre i denne rekkefølgen for å lette rettingen

// du kan ikke endre navn på disse 5 metodene


