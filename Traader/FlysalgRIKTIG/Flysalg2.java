class Flysalg2 {
	static int antSeter = 7;
	int antSolgt = 0;
	
	public static void main(String[] args) {
		System.out.println("Skal selge:: " + antSeter + " flyseter med 2 selgere" );
		Flysalg2 fly = new Flysalg2();
		Selger s1 = new Selger("Stein ", fly);
		s1.start();
		Selger s2 = new Selger("Michael", fly);
		s2.start();
	}
	
	int antIgjen() {
		return antSeter;
	}
	
	synchronized boolean proevSalg(int ant) {
		if (antSeter >= ant) {
			antSeter -= ant;
			antSolgt += ant;
			System.out.println(" Salg: ant igjen: " + antSeter + " , ant solgt: " + antSolgt);
			return true;
		} else {
			return false;
		}	
	}
}

/*
[emilyd@vor FlysalgRIKTIG]$ java Flysalg2
Skal selge:: 7 flyseter med 2 selgere
Stein  vil selge: 4
Michael vil selge: 5
 Salg: ant igjen: 2 , ant solgt: 5
Salget OK for: Michael
Allerede solgt for: Stein
Michael vil selge: 2
Stein  vil selge: 2
 Salg: ant igjen: 0 , ant solgt: 7
Salget OK for: Michael
Allerede solgt for: Stein
[emilyd@vor FlysalgRIKTIG]$ java Flysalg2
Skal selge:: 7 flyseter med 2 selgere
Stein  vil selge: 4
Michael vil selge: 3
 Salg: ant igjen: 4 , ant solgt: 3
Salget OK for: Michael
 Salg: ant igjen: 0 , ant solgt: 7
Salget OK for: Stein
*/

