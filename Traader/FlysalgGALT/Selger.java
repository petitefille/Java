class Selger extends Thread {
    Flysalg fly;
	String navn;
	
	Selger(String navn, Flysalg fly) {
	    this.navn = navn;
	    this.fly = fly;
	}
	
	public void run(){
	    while (fly.antIgjen() > 0) {
		    int oenske = (int) (Math.random() * fly.antIgjen() + 1);
			System.out.println(navn + " vil selge: " + oenske);
		    try { 
		        // vent litt
			    sleep((long) (1000 * Math.random()));
		    } catch(InterruptedException e) {}
			fly.selg(oenske);
			try {
			    sleep((long) 2000); // vent 2 sek
			} catch(InterruptedException e) {}
	
	    }// Selgere ferdig
	}
}