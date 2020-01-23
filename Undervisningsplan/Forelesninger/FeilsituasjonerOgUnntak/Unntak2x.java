class Unntak2x {
	public static void main(String [] args) { new Unntak2x();}
	
	Unntak2x(){
		String s = "Dette er en tekst med 29 tegn", s1;
		try {
			s1 = s.substring(30,32); //string-indeks utenfor enden
		} catch (StringIndexOutOfBoundsException e) {
			System.out.println("Her er det noe galt med string-ideksen " + e.getMessage());
		} // end try
	}
}
/*
[emilyd@vor FeilsituasjonerOgUnntak]$ java Unntak2x
Her er det noe galt med string-ideksen String index out of range: 32
*/