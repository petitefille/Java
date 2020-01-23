// Oppg 5

// 5 a) 

public boolean sorterDel(String[] a, int fom, int tom) {
	boolean sortert = false;
	boolean gjorde noe = false;
	while(! sortert){
		sortert = true;
		for (int i = fom; i < tom; i++){
			if(a[i].compareTo(a[i+1])>0){
				String bytt = a[i];
				a[i] = a[i+1];
				a[i+1] 0 bytt;
				sortert = false;
				gjordeNoe = true;
			}
		}
	}
	return gjordeNoe; // kommer til nytte senere
}

// OBS: jeg antar videre at metoden over er tilgjengelig i klassen 
// Sortering 

// 5 b)

public clss Sortering {
	String[] a;
	int antTraader;
	CountDownLatch nedteller;
	MinTraad[] traader;
	
	Sortering() {
		antTraader = 32;
		traader = new MinTraad[32];
	}
	
	public String[] sorter(String[] a){
		int lengde = a.length/antTraader;
		this.a = a;
		nedteller = new CountDownLAtch(antTraader);
		for(int i = 0; i < antTraader; i++){
			if (i == antTraader-1){
				MinTraade t = new MinTraad()
			}
		}
	}
}
