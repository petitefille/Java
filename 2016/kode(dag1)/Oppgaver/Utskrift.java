class Monitor {
	private int teller = 0;
	private boolean laast = false;
	
	public synchronized void vent( int nr ) {
		try {
			while ( laast ) {
				System.out.println(nr + " venter");
				wait();
			}
		} catch ( InterruptedException e ) {
			e.printStackTrace();
		}
		laast = false;
	}

	public synchronized void laasOpp( int nr ) {
		laast = false;
		System.out.println(nr + " varsler");
		notify();
	}

	public synchronized boolean laas() {
		if ( laast ) {
			return false;
		} else {
			laast = true;
			return true;
		}
	}
	
	public static void main(String[] args) {
		Monitor mon = new Monitor();
		Thread traad = new Thread( new Arbeider(1, mon));
		traad.start();
		traad = new Thread( new Arbeider(2, mon));
		traad.start();
	}
}

class Arbeider implements Runnable {
	private int nr;
	private Monitor mon;
	public Arbeider( int nr, Monitor mon ) {
		this.nr = nr;
		this.mon = mon;
	}
	public void run() {
		if ( mon.laas() ) {
			mon.vent( nr );
		} else { 
			mon.laasOpp( nr );
			mon.vent( nr );
		}
		mon.laasOpp( nr );
		System.out.println(nr + " ferdig");
	}
}
