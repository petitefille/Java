import java.util.NoSuchElementException;
// import java.util.LinkedList;
// import java.util.ListIterator;


public class LinkedList<E>
{
    public LinkedList()
    {
        first = null;
    }

    public E getFirst()
    {
        if (first == null)
            throw new NoSuchElementException();
        return first.data;
    }

    public E removeFirst()
    {
        if (first == null)
            throw new NoSuchElementException();
        E element = first.data;
        first = first.next;
        return element;
    }

    public void addFirst(E element)
    {
        Node newNode = new Node();
        newNode.data = element;
        newNode.next = first;
        first = newNode;
    }

    public ListIterator<E> listIterator()
    {
        return new LinkedListIterator();
    }

    private Node first;

    private class Node
    {
        public E data;
        public Node next;
    }

    private class LinkedListIterator implements ListIterator<E>
    {
        public LinkedListIterator()
        {
            position = null;
            previous = null;
        }

        public E next()
        {
            if (!hasNext())
                throw new NoSuchElementException();
            previous = position;
        
            if (position == null)
                position = first;
            else
                position = position.next;
           return position.data;
        }

        public boolean hasNext()
        {
            if (position == null)
                return first != null;
            else
                return position.next != null;
        }

        public void add(E element)
        { 
            if (position == null)
            {
                addFirst(element);
                position = first;
            }
            else
            {
                Node newNode = new Node();
                newNode.data = element;
                newNode.next = position.next;
                position.next = newNode;
                position = newNode;
            }
            previous = position;
        }

        public void remove()
        {
            if (previous == position)
                throw new IllegalStateException();
            if (position == first)
            {
                removeFirst();
            }
            else
            {
                previous.next = position.next;
            }
            position = previous;
        }

        public void set(E element)
        {
            if (position == null)
                throw new NoSuchElementException();
            position.data = element;
        }

        private Node position;
        private Node previous;
    }
}
  
      
