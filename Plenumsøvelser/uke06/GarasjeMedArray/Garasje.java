import java.util.Iterator;
class Garasje implements Iterable<Bil> {
	private Bil[] biler;
	
	Garasje(int antall) {
		biler = new Bil[antall];
	}
	
	public void settInn(Bil b, int i) {
		biler[i] = b;
	}
	
	public Iterator<Bil> iterator() {
		return new MinIterator();
	}
	
	class MinIterator implements Iterator<Bil> {
		int teller = 0;
		
		public boolean hasNext() {
			return teller < biler.length && biler[teller] != null;
		}
		
		public Bil next() {
			return biler[teller++];
		}
		
		public void remove() { }
	}
	
}
