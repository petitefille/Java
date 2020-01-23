
import java.util.ArrayList;

class Rute {
	
	private int verdi;
	
	protected Rad rad;
	protected Kolonne kolonne;
	protected Boks boks;

	public Rute neste;

	
	Rute(int verdi) {
		this.verdi = verdi;
	}

	// metode for aa sette at fra denne ruten skal alle verdiene ikke vaere opptatt, altsaa ar de har verdi 0  
	protected void fyllUtDenneRuteOgResten() {
		// henter brettet for aa sette verdiene til 0 fra og med denne ruten 
		this.rad.hentBrett().fjernVerdierBrett(this);
	}

	
	public void settRad(Rad r) { this.rad = r; }
	public void settKolonne(Kolonne k) { this.kolonne = k; }
	public void settBoks(Boks b) { this.boks = b; }

	public Rad hentRad() { return this.rad; }
	public Kolonne hentKolonne() { return this.kolonne; }
	public Boks hentBoks() { return this.boks; }

	
	public void settVerdi(int verdi) { this.verdi = verdi; }
	public int hentVerdi() { return this.verdi; }
}


// Rute med en verdi og som da er opptatt
class OpptattRute extends Rute {
	
	OpptattRute(int verdi) {
		super(verdi);
	}

	// fyller ut resten av brettet 
	public void fyllUtDenneRuteOgResten() {
		super.fyllUtDenneRuteOgResten();

		
		if (this.neste != null)
			this.neste.fyllUtDenneRuteOgResten();

		// ser om loesningen ikke er et tomt brett 
		if (this.neste == null)
			this.rad.hentBrett().testSvar();
	}
}

// Rute med verdi som ikke er opptatt
class TomRute extends Rute {
	TomRute() {
		super(0);
	}
	TomRute(int verdi) {
		super(verdi);
	}

	// fyller ut resten av brettet
	public void fyllUtDenneRuteOgResten() {
		super.fyllUtDenneRuteOgResten();

		for (int verdi : this.finnAlleMuligeTall()) {
		// finn mulige verdier
			this.settVerdi(verdi);

			if (this.neste != null)
				this.neste.fyllUtDenneRuteOgResten();
		}
		

		
		if (this.neste == null)
			this.rad.hentBrett().testSvar();
	}

	// Finn mulige verdier i felter
	public ArrayList<Integer> finnAlleMuligeTall() {
		ArrayList<Integer> verdier = new ArrayList<Integer>();

		for (int i = 1; i <= this.rad.lengde(); i++)
			// Sjekk rad
			if (!this.rad.inneholderVerdi(i))
				// Sjekk kolonne
				if (!this.kolonne.inneholderVerdi(i))
					// Sjekk boks
					if (!this.boks.inneholderVerdi(i))
						verdier.add(i);
		
		return verdier;
	}
}
