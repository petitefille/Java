class Person {
    protected String navn;

    Person(String s) {navn = s;}

    @Override public boolean equals(Object o) {
	return (o instanceof Person && navn.compareTo(((Person)o).navn) == 0);
    }

    @Override public String toString() {
	return "Person med navn " + navn ;
    }

    public int compareTo(Object o) {
	if (o instanceof Person && navn.compareTo(((Person)o).navn) == 0)
	     return 0;
	else return 1;
    }
}

class Student extends Person {

    int studnr;

    Student(String s, int snr) {
	super(s);
	studnr = snr;
    }   

    @Override public boolean equals(Object o) {
	return ( o instanceof Student
		 && super.equals(o)
		 && ((Student)o).studnr == studnr ) ;
    }

    @Override public String toString() {
	return "Student med navn " + navn  + " og studentnummer " + studnr;
    }
}


abstract class Frukt {
    abstract String typeFrukt();

    @Override public String toString() {return typeFrukt();}

    @Override public boolean equals(Object o) {
	return false;
	// fordi objektet ikke bare kan være frukt
    }
}

class Eple extends Frukt {
    private String id = "Eple";

    @Override public boolean equals(Object o) {
	return ( o.toString().compareTo(toString()) == 0 );
    }

    @Override public String typeFrukt() {return id;}
}

class Banan extends Frukt {
    private String id = "Banan";

    @Override public boolean equals(Object o) {
	return ( o.toString().compareTo(toString()) == 0 );
    }

    @Override public String typeFrukt() {return id;}
}

class Kiwi extends Frukt {
    private String id = "Kiwi";

    @Override public boolean equals(Object o) {
	return ( o.toString().compareTo(toString()) == 0 );
    }

    @Override public String typeFrukt() {return id;}
}


class Beholder {

    private Node f; // peker til første node
    private int ant = 0; // antall objekter i beholderen

    class Node {
	Node(Object o) { obj = o;}
	Object obj;
	Node neste;

	Node fjernSist() {
	    Node ret = null;
	    
	    if ( neste != null) { // ikke siste node:
		ret = neste.fjernSist();
		neste = ret;
	    }
	    else if ( obj != null) // ikke tom node:
		ret = this;
	    else ; // tom node, ret skal være null
	    
	    return ret;
	}

    }
	
    void fjern (Object o) {
	// lista må ikke være tom:
	if ( ant > 0) {
	    // spesialtilfelle, første element skal fjernes:
	    if ( f.obj.equals(o) ) {
		f = f.neste;
		ant--;
	    }
	    else {
		Node n = f;
		for (int i = 1; i<=ant; i++)
		    if ( n.obj.equals(o) ) {
			// likt objekt, fjernes
			Node nn = f;
			while ( nn.neste.obj.equals(o) ) nn = nn.neste;
			// nn.neste er nå noden som skal fjernes
			nn.neste = n.neste;
			ant--;
			break;
		    }
		    else n = n.neste; // let mere
	    }
	}
    }
	    
    void settInn(Object o) {
	if (o != null)
	    fjern(o);
	Node n = new Node(o);
	n.neste = f;
	f = n;
	ant++;
    }

    Object hent() {
	return f.obj;
    }

    int antall() { return ant;}

    void ovfAlleFraBeholder(Beholder bh) {
	while (bh.antall() > 0) {
	    Object co = bh.hent();
	    settInn(co);
	    bh.fjern(co);
	}
    }
	
 
    void skrivAlle() {
	Node n = f;
	for (int i = 1; i<=ant; i++) {
	    System.out.println( i + ":" + n.obj );
	    n = n.neste;
	}
    }
}

class August {
    August() {
	Beholder bh = new Beholder();
	Object o = null;
	Beholder bhb = new Beholder();
	
	

	for (int i = 1; i <= 763; i++) {
	    o = new Kiwi();
	    bh.settInn(o);
	}


	o = new Person("a");
	bh.settInn(o);
	o = new Person("b");
	bh.settInn(o);
	o = new Student("student1" , 123);
	bh.settInn(o);
	o = new Student("student1" , 123);
	bh.settInn(o);
	o = new Student("student2" , 321);
	bh.settInn(o);

	o = new Eple();
	bh.settInn(o);
	o = new Eple();
	bh.settInn(o);

	for (int i = 1; i <= 24; i++) {
	    o = new Banan();
	    bh.settInn(o);
	}

	int teller = 0;

	bhb.settInn(bh);

	while (bh.antall() > 0) {
	    teller++;
	    o = bh.hent();
	    bh.fjern(o);
	    System.out.println( teller + ": " + o.toString() );
	}
    }
}

public class Xks {
    public static void main(String[] a) { new August(); }
}
