class Mengde<E>
{
	// reference to the head node.
	private Node første;
        private Node siste;
        private int antall;

    private class Node {
        Node (E e) {objektet = e}
        Node neste;
        E objektet;
	
	// LinkedList constructor
	public E Mengde()
	{
            første = null;
            siste = null;
        }    
		// this is an empty list, so the reference to the head node
		// is set to a new node with no data
		nyeste = new Node(null);
		listCount = 0;
	}

public boolean tom()
    return first == null;
	
public void leggtil(E e)
Node temo = newNode(data)
Node current = head

public T removeAt(T elem)
{
    temp = head;
    Mynode<T> tw



public 
        public void add(Object data)
	// post: appends the specified element to the end of this list.
	{
		Node temp = new Node(data);
		Node current = head;
		// starting at the head node, crawl to the end of the list
		while(current.getNext() != null)
		{
			current = current.getNext();
		}
		// the last node's "next" reference set to our new node
		current.setNext(temp);
		listCount++;// increment the number of elements variable
	}        

	public void leggTil(E e)
	// post: appends the specified element to the end of this list.
	{
		Node temp = new Node(e);
		Node current = nyeste;
		// starting at the head node, crawl to the end of the list
                
		if(current.getNext() != null && .equals(e) )
		{
			current = current.getNext();
                        return true; 
		}
		// the last node's "next" reference set to our new node
		current.setNext(temp);
		listCount++;// increment the number of elements variable
	}
	
	public void leggTil(E e, int index)
	// post: inserts the specified element at the specified position in this list.
	{
		Node temp = new Node(e);
		Node current = nyeste;
		// crawl to the requested index or the last element in the list,
		// whichever comes first
                
		for(int i = 1; i < index && current.getNext() != null; i++)
		{
			current = current.getNext();
		}
		// set the new node's next-node reference to this node's next-node reference
		temp.setNext(current.getNext());
		// now set this node's next-node reference to the new node
		current.setNext(temp);
		listCount++;// increment the number of elements variable
	}
	
	public Object get(int index)
	// post: returns the element at the specified position in this list.
	{
		// index must be 1 or higher
		if(index <= 0)
			return null;
		
		Node current = nyeste.getNext();
		for(int i = 1; i < index; i++)
		{
			if(current.getNext() == null)
				return null;
			
			current = current.getNext();
		}
		return current.getE();
	}
public fjernNyeste() // LIFO

public void T taUtForan() // LIFO
    Node n = første.neste;
    if (n != null) {
        antall--;
        første.neste = n.neste;
        return n.objektet;
    }
    else return null;
} 

public fjernEldtse() { // FIFO
    Node n = første;
    if (n != null) {
        antall--;
        første = n.neste;
        return n.objektet;
        }
    else return null;
} 
 
	
	public boolean remove(int index)
	// post: removes the element at the specified position in this list.
	{
		// if the index is out of range, exit
		if(index < 1 || index > size())
			return false;
		
		Node current = head;
		for(int i = 1; i < index; i++)
		{
			if(current.getNext() == null)
				return false;
			
			current = current.getNext();
		}
		current.setNext(current.getNext().getNext());
		listCount--; // decrement the number of elements variable
		return true;
	}



// post: removes the element at the specified position in this list.
	{
		// if the index is out of range, exit
		if(index < 1 || index > size())
			return false;
		
		Node current = head;
		for(int i = 1; i < index; i++)
		{
			if(current.getNext() == null)
				return null;
			
			current = current.getNext();
		}
		current.setNext(current.getNext().getNext());
		listCount--; // decrement the number of elements variable
		return true;
	}

   

// post: removes the element at the specified position in this list.
	{
		// if the index is out of range, exit
		if(index < 1 || index > size())
			return false;
		
		Node current = head;// Node n = første.neste;
		for(int i = 1; i < index; i++)
		{
			if(current.getNext() == null)
				return null;
			
			current = current.getNext();
		}
		current.setNext(current.getNext().getNext());
		listCount--; // decrement the number of elements variable
		return true;
	}

public inneholder(E e)
	
	public int size()
	// post: returns the number of elements in this list.
	{
		return listCount;
	}
	
	public String toString()
	{
		Node current = head.getNext();
		String output = "";
		while(current != null)
		{
			output += "[" + current.getE().toString() + "]";
			current = current.getNext();
		}
		return output;
	}
	
	private class Node
	{
		// reference to the next node in the chain,
		// or null if there isn't one.
		public Node next;
		// data carried by this node.
		// could be of any type you need.
		public E data;
		

		// Node constructor
		public Node(Object _data)
		{
			next = null;
			data = _data;
		}
		
		// another Node constructor if we want to
		// specify the node to point to.
		public Node(Object _data, Node _next)
		{
			next = _next;
			data = _data;
		}
		
		// these methods should be self-explanatory
		public Object getData()
		{
			return data;
		}
		
		public void setData(Object _data)
		{
			data = _data;
		}
		
		public Node getNext()
		{
			return next;
		}
		
		public void setNext(Node _next)
		{
			next = _next;
		}
	}
}

Written by Pavel.
Copyright © 2005-2015 MyCSTutorials.com
