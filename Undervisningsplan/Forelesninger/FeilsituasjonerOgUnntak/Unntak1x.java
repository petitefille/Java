class Unntak1x {
	
	public Unntak1x(){
		String s = "Dette er en tekst med 29 tegn", s1;
		try {
			s1 = s.substring(30,32); // string-indeks utenfor ende
		} catch (StringIndexOutOfBoundsException e) {
			System.out.println("Her er det noe galt med string-indeksen");
		}	
	}
	
	public static void main(String [] args) { new Unntak1x();}
}
/*
[emilyd@vor FeilsituasjonerOgUnntak]$ java Unntak1x
Her er det noe galt med string-indeksen
*/