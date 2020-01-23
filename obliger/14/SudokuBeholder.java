
import java.util.ArrayList;


class SudokuBeholder {
	
	private static final int MAKS = 2500;

	
	private Svar tomtSvar;
	private ArrayList<Svar> svar;
	private int antallSvar;

	
	SudokuBeholder(Svar tomtSvar) {
		this.tomtSvar = tomtSvar;
		this.svar = new ArrayList<Svar>(MAKS);
	}

	// offentlig metode settInn
	public void settInn(Svar s) {
		this.antallSvar++;

		if (this.svar.size() < MAKS) {
			// Legg til
			svar.add(s);
		}
	}
	

	// offentlig metode ta ut, som tar ut loesninge
	public Svar taUt(int indeks) {
		if (indeks < this.svar.size())
			return this.svar.get(indeks);

		return null;
	}

	// offentlig metode Returner antall loesninger
	public int hentAntallSvar() {
		return this.antallSvar;
	}

	// returnerer losninger
	public ArrayList<Svar> hentSvar() {
		return this.svar;
	}

	// returnerer maks lagrede loesninger
	public int hentMaks() {
		return MAKS;
	}

	// returnerer tom losning
	public Svar hentTomtSvar() {
		return this.tomtSvar;
	}
}
