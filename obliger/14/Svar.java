
import java.util.ArrayList;

// loesnings objekter som skal settes inn i beholder SudokuBeholder 
class Svar {
	
	private int planLengde;
	private ArrayList<Rute> ruter;

	// loesning objekt med en loesning opprettes 
	Svar(ArrayList<Rute> ruter) {
		// Feltstorrelse
		this.planLengde = (int) Math.sqrt(ruter.size());

		// lagrer kopi av ruter 
		this.ruter = new ArrayList<Rute>();

		for (Rute r : ruter) {
			// hente verdien til rute objektet hvis denne har en verdi
			if (r instanceof OpptattRute)
				this.ruter.add(new OpptattRute(r.hentVerdi()));
			// henter verdi hvis rute objektet er en "."
			if (r instanceof TomRute)
				this.ruter.add(new TomRute(r.hentVerdi()));
		}
	}

	// returner loesningsruter
	public ArrayList<Rute> hentRuter() {
		return this.ruter;
	}

	// String format av loesnings objekt hvis det finnes faa loesninger som skal skrives ut 
	public String snDtoString() {
		
		String linje = "";

		for (int i = 0; i < this.ruter.size(); i++) {
			Rute r = this.ruter.get(i);

			if ((r.hentVerdi() > 0) && (r.hentVerdi() < 10))
				linje += r.hentVerdi();
			else
				linje += "ABCDEFGHIJKLMNOPQRSTUVWXYZ".charAt((r.hentVerdi()-10));

			if((i+1)%this.planLengde==0)
				linje += "\n";
		}

		return linje;
	}
	
	
	// String format for aa printe ut loesninger, og ikke int , her skal loesningene skrives slik hvis det er mange loesninger 
	public String toString() {
		
		String linje = "";

		for (int i = 0; i < this.ruter.size(); i++) {
			Rute r = this.ruter.get(i);

			if ((r.hentVerdi() > 0) && (r.hentVerdi() < 10))
				linje += r.hentVerdi();
			else
				linje += "ABCDEFGHIJKLMNOPQRSTUVWXYZ".charAt((r.hentVerdi()-10));

			if((i+1)%this.planLengde==0)
				linje += "//";
		}

		return linje;
	}
}
