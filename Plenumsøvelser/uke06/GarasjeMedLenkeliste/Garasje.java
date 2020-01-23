import java.util.Iterator;
class Garasje implements Iterable<Bil> {

	private Node forste;
	
	Garasje() {
		
	}	
	
	public void settInn(Bil b) {
		if(forste == null) {
			forste = new Node(b);
		} else {
			Node tmp = forste;
			while(tmp.neste != null) {
				tmp = tmp.neste;
			}
			
			tmp.neste = new Node(b);
		}
	}
	
	public Iterator<Bil> iterator() {
		return new MinIterator();
	}
	
	class MinIterator implements Iterator<Bil> {
	
		Node tmp = forste;	
		
		public boolean hasNext() {
		
			return tmp != null;
			
		}
		
		public Bil next() {
		
			Bil denne = tmp.data;
			tmp = tmp.neste;
			
			return denne;
			
		}
		
		public void remove() { }
	}
	
	private class Node {
	
		Bil data;
		Node neste;
		
		public Node(Bil data) {
			this.data = data;
		}
		
	}
	
}
