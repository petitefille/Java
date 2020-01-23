class Unntak3x{
	public static void main(String [] args) {
		int dividend = 7, divisor = 0; int kvotient = 0;
		String s = "Dette er em tekst med 29 tegn"; String s1 = "*********";
		try {
			s1 = s.substring(15,17);       // OK string-indeks
			kvotient = dividend/divisor;   // Feil: divisjon med 0
		} catch(StringIndexOutOfBoundsException e) {
			System.out.println("Her er det noe galt med string-indeksen");
		} catch(ArithmeticException e1) {
			System.out.println("Divisjon med 0:" + e1.getMessage());
		}
		System.out.println(s1);
		System.out.println(kvotient);
	}
}
/*
[emilyd@vor FeilsituasjonerOgUnntak]$ java Unntak3x
Divisjon med 0:/ by zero
st
0
*/