
import java.util.Arrays;
import java.util.ArrayList;

class Plan  {
	
	private Brett brett;
	
	// disse skal settes inn som loesningsobjekter av klassen loesning
	private ArrayList<Rute> ruter;

	
	Plan(Brett brett) {
		this.brett = brett;
		this.ruter = new ArrayList<Rute>();
	}

	// setter inn rute i ruter 
	public void leggTilRute(Rute r) {
		this.ruter.add(r);
	}

	// returnerer rutene som har blitt fylt inn i rute klassen 
	public ArrayList<Rute> hentRuter() {
		return this.ruter;
	}

	// sjekker om felt inneholder en gitt verdi
	public boolean inneholderVerdi(int verdi) {
		for (Rute r : this.hentRuter())
			if (r.hentVerdi() == verdi)
				return true;

		return false;
	}

	// returnerer stoerrelse av ruter 
	public int lengde() {
		return this.ruter.size();
	}

	
	public Brett hentBrett() {
		return this.brett;
	}

}


class Rad extends Plan {
	Rad(Brett brett) {
		super(brett);
	}

	public void settInnRute(Rute r) {
		super.leggTilRute(r);

		r.settRad(this);
	}
}


class Kolonne extends Plan {
	Kolonne(Brett brett) {
		super(brett);
	}

	public void settInnRute(Rute r) {
		super.leggTilRute(r);

		r.settKolonne(this);
	}
}


class Boks extends Plan {
	int rader;
	int kolonner;

		Boks(Brett brett, int rader, int kolonner) {
		super(brett);

		this.rader = rader;
		this.kolonner = kolonner;
	}

	public void settInnRute(Rute r) {
		super.leggTilRute(r);

		r.settBoks(this);
	}

	public int hentAntallRader() {
		return this.rader;
	}

	public int hentAntallKolonner() {
		return this.kolonner;
	}
}
