class Flysalg {
	static int antSeter = 7;
	int antSolgt = 0;
	
	public static void main(String[] args) {
		System.out.println("Skal selge: " + antSeter + " flyseter med 2 selgerer");
		Flysalg fly = new Flysalg();
		Selger s1 = new Selger("Stein ", fly );
		s1.start();
		Selger s2 = new Selger("Michael ", fly);
		s2.start();
	}
	
	int antIgjen() {
		return antSeter;
	}
	
	void selg(int ant) {
		antSeter -= ant;
		antSolgt += ant;
		System.out.println("Salg: ant igjen: " + antSeter + " , ant solgt: " + antSolgt);
	}
}

/*
[emilyd@vor Traader]$ java Flysalg
Skal selge: 7 flyseter med 2 selgerer
Stein  vil selge: 1
Michael  vil selge: 2
Salg: ant igjen: 5 , ant solgt: 2
Salg: ant igjen: 4 , ant solgt: 3
Michael  vil selge: 1
Salg: ant igjen: 3 , ant solgt: 4
Stein  vil selge: 2
Salg: ant igjen: 1 , ant solgt: 6
Michael  vil selge: 1
Salg: ant igjen: 0 , ant solgt: 7
[emilyd@vor Traader]$ java Flysalg
Skal selge: 7 flyseter med 2 selgerer
Stein  vil selge: 2
Michael  vil selge: 3
Salg: ant igjen: 5 , ant solgt: 2
Salg: ant igjen: 2 , ant solgt: 5
Stein  vil selge: 2
Michael  vil selge: 1
Salg: ant igjen: 0 , ant solgt: 7
Salg: ant igjen: -1 , ant solgt: 8
*/