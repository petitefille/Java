public class TryTest
{
	public static void main (String [] args) {
		int i = 1;
		for(int j = 0; j < 5; j++) {
			try {
				i = 10/j;
				System.out.println("Det gikk OK, i: " + i + " ,j: " + j);
			} catch(Exception e) {
				System.out.println("Feil i utrrykk: " + e.getMessage());
			}
		}
	}	
} // end TryTest

/*
[emilyd@vor FeilsituasjonerOgUnntak]$ java TryTest
Feil i utrrykk: / by zero
Det gikk OK, i: 10 ,j: 1
Det gikk OK, i: 5 ,j: 2
Det gikk OK, i: 3 ,j: 3
Det gikk OK, i: 2 ,j: 4
*/