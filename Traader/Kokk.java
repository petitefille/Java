class Kokk extends Thread {
    private FellesBord bord;
	private final int ANTALL;
	private int laget = 0;
	Kokk(FellesBord bord, int ant) {
	    this.bord = bord; ANTALL = ant;
	}
	
	public void run() {
	    while (ANTALL != laget) {
		    laget++;
			System.out.println("Kokken lager tallerken nr:" + laget);
			bord.settTallerken();  //lag og lever tallerken
			try { sleep((long) (1000 * Math.random()));
			} catch (InterruptedException e) {}
		} // Kokken er ferdig
		
	}
}