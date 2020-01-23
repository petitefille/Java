// Import
import java.util.ArrayList;


// 	Klasse: SudokuBeholder
// =================================================================================
class SudokuBeholder {
	// Konstanter
	private static final int MAKS = 750;

	// Variabler
	private Losning tomLosning;
	private ArrayList<Losning> losninger;
	private int antallLosninger;

	// Konstruktoer	
	SudokuBeholder(Losning tomLosning) {
		this.tomLosning = tomLosning;
		this.losninger = new ArrayList<Losning>(MAKS);
	}

	// Sett inn loesning
	public void settInn(Losning losning) {
		this.antallLosninger++;

		if (this.losninger.size() < MAKS) {
			// Legg til
			losninger.add(losning);
		}
	}

	// Ta ut loesning
	public Losning taUt(int indeks) {
		if (indeks < this.losninger.size())
			return this.losninger.get(indeks);

		return null;
	}

	// Returner antall loesninger
	public int hentAntallLosninger() {
		return this.antallLosninger;
	}

	// Returnerer losninger
	public ArrayList<Losning> hentLosninger() {
		return this.losninger;
	}

	// Returnerer maks lagrede loesninger
	public int hentMaks() {
		return MAKS;
	}

	// Returnerer tom losning
	public Losning hentTomLosning() {
		return this.tomLosning;
	}
}