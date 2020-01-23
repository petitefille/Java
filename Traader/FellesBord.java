class FellesBord { //
    private int antallPaBordet = 0; // invarianten gjelder
	private final int BORD_KAPASITET = 4;
	/* Invariant: 0 <= antallPaBordet <= BORD_KAPASITET */
	
	synchronized void settTallerken() {
	    while (antallPaBordet >= BORD_KAPASITET) {
		/* Saa lenge det allerede er BORD_KAPASITET tallerkner paa bordet
		   er det ikke lov aa sette flere.  */
		   try { wait();
		   } catch (InterruptedException e) {}
		} // Naa er antallPaBordet < BORD_KAPASITET
		antallPaBordet++; // bevarer invarianten
		System.out.println("Antall paa bordet: " + antallPaBordet);
		notify(); // Si fra til den som henter tallerkener
	}
	
	synchronized void hentTallerken() {
	    while (antallPaBordet == 0) {
		    /* Saa lenge det ikke er noen  talerkener paa
			   bordet er det ikke lov aa ta en*/
			   try { wait();
			   } catch (InterruptedException e) {}
		} // Naa er antallBordet > 0
		antallPaBordet --; //bevarer invarianten
		notify(); // si ifra til den som setter paa tallerkener
	}
}	