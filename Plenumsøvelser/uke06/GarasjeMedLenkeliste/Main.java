class Main {
	public static void main(String[] args) {
	
		Garasje g = new Garasje();
		
		for (int i = 0; i < 5; i++) {
			g.settInn(new Bil(i));
		}
		
		for (Bil b : g) {
			System.out.println(b);
		}
	}
}

/*
[emilyd@fingon GarasjeMedLenkeliste]$ java Main
Bil nr. 0
Bil nr. 1
Bil nr. 2
Bil nr. 3
Bil nr. 4
*/
