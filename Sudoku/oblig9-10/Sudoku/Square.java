import java.util.*;

public class Square {

	private int value;
	private final int n;
	private Box box;
	protected Row row;
	private Column column;
	protected Square next;
	protected Sudoku game;

	public Square(int value, int n, Sudoku game) {
		this.value = value;
		this.n = n;
		this.game = game;
	}

	public String toString() {
		int verdiNy = Character.toUpperCase(Character.forDigit(verdi, 36));
		return verdiNy + "";
	}

	public void skrivUtDenneOgNeste() {
		System.out.print(neste + " ");
		if (neste != null) {
			neste.skrivUtDenneOgNeste();
		}
	}

	public void settNext(Square next) {
		this.next = next;
	}

	public void settVerdi(int verdi) {
		this.verdi = verdi;
	}

	public int getVerdi() {
		return verdi;
	}

	public void setRow(Row row) {
		this.row = row;
	}

	public Rad getRad() {
		return rad;
	}

	public void setColumn(Column column) {
		this.column = column;
	}

	public Kolonne getKolonne() {
		return kolonne;
	}

	public void settBoks(Boks boks) {
		this.boks = boks;
	}

	public Boks getBoks() {
		return boks;
	}

	protected void fillInnThisRowAndTheRest() {
		this.row.getBoard().angreVerdier(this);
	}

	ArrayList<Integer> finnAlleMuligeTall() {
		ArrayList<Integer> mulige = new ArrayList<>();

		for (int i = 1; i <= n; i++) {
			if (!rad.inneholder(i) && !kolonne.inneholder(i) && !boks.inneholder(i)) {
				mulige.add(i);
			}
		}
		return mulige;
	}

}


//         **** FastRute *****
//  *************************************

class FastRute extends Rute {

	public FastRute(int verdi, int n, Sudoku spillet) {
		super(verdi, n, spillet);
	}

	// Fyll ut resten av brettet
	public void fyllUtDenneRuteOgResten() {
		super.fyllUtDenneRuteOgResten();

		// Hopp over
		if (this.neste != null) {
			this.neste.fyllUtDenneRuteOgResten();
		}

		// Er det siste rute
		if (this.neste == null) {
			//Lagre brettet
			spillet.lagreBrett(rad.getBrett().getRuteBrett()); //LAGRE BRETTET
			return; //Funnet losning
		}
	}
}

//         **** TomRute *****
//  *************************************

class TomRute extends Rute {


	public TomRute(int verdi, int n, Sudoku spillet) {
		super(verdi, n, spillet);
	}

	// Fyll ut resten av brettet
	public void fyllUtDenneRuteOgResten() {
		super.fyllUtDenneRuteOgResten();

		// Finn mulige verdier
		for (int verdi : this.finnAlleMuligeTall()) {
			this.settVerdi(verdi);

			if (this.neste != null)
				this.neste.fyllUtDenneRuteOgResten();
		}

		// Er det siste rute
		if (this.neste == null) {
			if(!(this.getVerdi() == 0)) {
				//Lagre brettet
				spillet.lagreBrett(rad.getBrett().getRuteBrett());
				return; //Funnet losning
			}
		}
	}
}
