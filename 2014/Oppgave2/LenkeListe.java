EnkelListe<E> implements Comparable<>{
	
	Node forste;
	
	EnkelListe<E>() {
		forste = null;
		
	}
	
	
	private class Node {
		
		Node neste;
		E element;
		
		Node(E e) {
            element = e; 			
		}
		
	}
	
	public void settInn(E e) {
		Node ny = new Node(e);
		if (foran == null) {
			foran = ny;
			foran.neste = null;
		}
		else (if foran.neste == null)
		{
			if (foran.element.comparableTo(ny.element) < 0)
			{ 
		} else {
			
		}	
		}
		
	}
	
	public E TaUT()
	
	public comparableTo() {
		
	}
	
	
}