import java.util.NoSuchElementException;
 
/**
   A linked list is a sequence of nodes with efficient
   element insertion and removal. This class 
   contains a subset of the methods of the standard
   java.util.LinkedList class.
*/
public class Mengde<E>
{  
   /** 
      Constructs an empty linked list.
   */
   public Mengde()
   {  
      Nyeste = null;
   }
   
   /**
      Returns the first element in the linked list.
      @return the first element in the linked list
   */
   public E getNyeste()
   {  
      if (Nyeste == null) 
         throw new NoSuchElementException();
      return Nyeste.data;
   }

    

   /**
      Removes the first element in the linked list.
      @return the removed element
   */
   public E fjernNyeste()
   {  
      if (Nyeste == null) 
         return null;
      E e = Nyeste.data;
      Nyeste = Nyeste.next;
      return e;
   }

    public 
   /**
      Adds an element to the front of the linked list.
      @param element the element to add
   */
   public void leggTilNyeste(E e)
   {  
      Node newNode = new Node();
      newNode.data = e;
      newNode.next = Nyeste;
      Nyeste = newNode;
   }
   
   /**
      Returns an iterator for iterating through this list.
      @return an iterator for iterating through this list
   */
   public ListIterator<E> listIterator()
   {  
      return new MengdeIterator();
   }
   
   private Node Nyeste;
   
   private class Node
   {  
      public E data;
      public Node next;
   }

   private class MengdeIterator implements ListIterator<E>
   {  
      /**
         Constructs an iterator that points to the front
         of the linked list.
      */
      public MengdeIterator()
      {  
         position = null;
         previous = null;
      }
      
      /**
         Moves the iterator past the next element.
         @return the traversed element
      */
      public E fjernEldste()
      {  
         if (!tom())
            return null;
         previous = position; // Remember for remove

         if (position == null)
            position = Nyeste;
         else
            position = position.next;

         return position.data;
      }
      
      /**
         Tests if there is an element after the iterator 
         position.
         @return true if there is an element after the iterator 
         position
      */
      public boolean tom()
      {  
         if (position == null)
            return Nyeste != null;
         else
            return position.next != null;
      }
      
      /**
         Adds an element before the iterator position
         and moves the iterator past the inserted element.
         @param element the element to add
      */
      public boolean leggTil(E e)
      {  
         if (position == null)
         {
            leggTilNyeste(e);
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
      
      /**
         Removes the last traversed element. This method may
         only be called after a call to the next() method.
      */
      public void fjern()
      {  
         if (previous == position)
            throw new IllegalStateException();

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

      /**
         Sets the last traversed element to a different 
         value. 
         @param element the element to set
     */
      public boolean inneholder(E e)
      {
         if (position == null)
            return true;
         else 
             return false;
         position.data = e;
      }
            
      private Node position;
      private Node previous;
   }
}
