
import java.io.*;
import java.util.ArrayList;

class Brett {
	
	private int antallRaderIBoks;
	private int antallKolonnerIBoks;
	private int planLengde;
	private int brettLengde;

	
	
	private Rute[][] ruter;

	
	private Boks[] bokser;
	private Rad[] rader;
	private Kolonne[] kolonner;

	
	private SudokuBeholder sudokuBeholder;


	Brett(int antallRaderIBoks, int antallKolonnerIBoks, ArrayList<Rute> ruter) {
		// Lager en beholder for loesningene 
		this.sudokuBeholder = new SudokuBeholder(new Svar(ruter));

		this.antallRaderIBoks = antallRaderIBoks;
		this.antallKolonnerIBoks = antallKolonnerIBoks;
		this.planLengde = (this.antallRaderIBoks * this.antallKolonnerIBoks);
		this.brettLengde = (this.planLengde * this.planLengde);

		this.bokser = new Boks[this.planLengde];
		this.rader = new Rad[this.planLengde];
		this.kolonner = new Kolonne[this.planLengde];

		for (int i = 0; i < this.planLengde; i++) {
			
			this.rader[i] = new Rad(this);
			this.kolonner[i] = new Kolonne(this);
			this.bokser[i] = new Boks(this, this.antallRaderIBoks, this.antallKolonnerIBoks);
		}

		
		this.ruter = new Rute[this.planLengde][this.planLengde];

		int b = 0;
		int l = 0;
		Rute forrige = null;

		for (int r = 0; r < this.planLengde; r++) {
			for (int k = 0; k < this.planLengde; k++) {
				if (k%this.antallKolonnerIBoks==0) {
					if (l++%this.antallRaderIBoks==0)
						b = 0;
					b++;
				}

				int rNum = ((r * this.planLengde) + k);
				int bNum = (((r+b)-(r%this.antallRaderIBoks))-1);

				Rute rute = ruter.get(rNum);

				this.ruter[r][k] = rute;
				this.rader[r].settInnRute(rute);
				this.kolonner[k].settInnRute(rute);
				this.bokser[bNum].settInnRute(rute);

				
				if (forrige != null)
					forrige.neste = rute;

				forrige = rute;
			}
		}

		
	}

	// hvis alle ruter har verdi, sett inn nytt objekt for loesning, hente ruter fra  plan klassen hvor ruter er lagret 
	public void testSvar() {
		if (this.erRiktig())
			// legg til loesning
			this.hentSudokuBeholder().settInn(new Svar(this.hentRuter()));
	}

	// Tester at alle verdiene har en verdi 
	public boolean erRiktig() {
		for (int x = 0; x < this.planLengde; x++)
			for (int y = 0; y < this.planLengde; y++)
				if (this.ruter[y][x].hentVerdi() == 0)
					return false;

		return true;
	}

	// sette at verdier ikke er opptatte fra og med denne ruten 
	public void fjernVerdierBrett(Rute r) {
		if (r != null) {
			// hvis ruta ikke er opptatt
			if (r instanceof TomRute)
				//sette at denne ikke er 0 
				r.settVerdi(0);
             // og ordner det slik for resten av brettet 
			this.fjernVerdierBrett(r.neste);
		}
	}

	
	public int hentPlanLengde() { return this.planLengde; }
	public int hentAntallRaderIBoks() { return this.antallRaderIBoks; }
	public int hentAntallKolonnerIBoks() { return this.antallKolonnerIBoks; }
	public Boks[] hentBokser() { return this.bokser; }
	public Rad[] hentRader() { return this.rader; }
	public Kolonne[] hentKolonner() { return this.kolonner; }

	// Returnerer ruter
	public ArrayList<Rute> hentRuter() {
		ArrayList<Rute> ruter = new ArrayList<Rute>();

		for (int r = 0; r < this.planLengde; r++)
			for (int k = 0; k < this.planLengde; k++)
				ruter.add(this.ruter[r][k]);

		return ruter;
	}

	// Returner beholder
	public SudokuBeholder hentSudokuBeholder() {
		return this.sudokuBeholder;
	}

	// Finn loesninger
	public void finnSvar() {
		// Start i foerste rute
		this.ruter[0][0].fyllUtDenneRuteOgResten();
      	if (this.hentSudokuBeholder().hentAntallSvar() > 0)
			System.out.println("Fant totalt " + this.hentSudokuBeholder().hentAntallSvar() + " loesning(er).");
		else
			System.out.println("Fant ingen loesninger.");
	}


}
