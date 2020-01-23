class Servitor extends Thread {
    private FellesBord bord;
	private final int ANTALL;
	private int servert = 0;
	Servitor(FellesBord bord, int ant) {
	    this.bord = bord; ANTALL = ant;
	}
	
	public void run() {
	    while (ANTALL != servert) {
		    bord.hentTallerken(); /* hent tallerken og server */
			servert++;
			System.out.println("Servitoer serverer nr:" + servert);
			try { sleep((long) (1000 * Math.random()));
			} catch (InterruptedException e) {}
		} // Servitoeren er ferdig
	}
}

/*
[emilyd@fingon Traader]$ java RestaurantS 8
Kokken lager tallerken nr:1
Antall paa bordet: 1
Servitoer serverer nr:1
Kokken lager tallerken nr:2
Antall paa bordet: 1
Servitoer serverer nr:2
Kokken lager tallerken nr:3
Antall paa bordet: 1
Servitoer serverer nr:3
Kokken lager tallerken nr:4
Antall paa bordet: 1
Servitoer serverer nr:4
Kokken lager tallerken nr:5
Antall paa bordet: 1
Servitoer serverer nr:5
Kokken lager tallerken nr:6
Antall paa bordet: 1
Kokken lager tallerken nr:7
Antall paa bordet: 2
Servitoer serverer nr:6
Kokken lager tallerken nr:8
Antall paa bordet: 2
Servitoer serverer nr:7
Servitoer serverer nr:8
*/
