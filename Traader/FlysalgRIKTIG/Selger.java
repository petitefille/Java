class Selger extends Thread {
	Flysalg2 fly;
	String navn;
	
	Selger(String navn, Flysalg2 fly) {
		this.navn = navn;
		this.fly = fly;
	}
	
	public void run() {
		while (fly.antIgjen() > 0) {
			int oenske = (int) (Math.random() * fly.antIgjen() + 1);
			System.out.println(navn + " vil selge: " + oenske);
			try {
				// vent litt
				sleep((long) (1000 * Math.random()));
			} catch(InterruptedException e) {}
			if (fly.proevSalg(oenske))
				System.out.println("Salget OK for: " + navn);
			else
				System.out.println("Allerede solgt for: " + navn);
			try{
				sleep((long) 2000); // vent 2 sek
			} catch (InterruptedException e) {}
		}
	    // Selgere ferdig
	}
}