import java.util.Iterator;

class Main {
	public static void main(String[] args) {
	
		Garasje g = new Garasje(10);
		
		for (int i = 0; i < 5; i++) {
			g.settInn(new Bil(i), i);
		}
		
		for (Bil b : g) {
			System.out.println(b);
		}
	}
}

/*
[emilyd@fingon GarasjeMedArray]$ java Main
Bil nr. 0
Bil nr. 1
Bil nr. 2
Bil nr. 3
Bil nr. 4
*/





