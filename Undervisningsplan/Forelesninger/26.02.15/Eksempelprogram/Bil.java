class Bil implements Skattbar {

    public Bil() { pris = 300000; }
    public Bil(int v) { pris = v; }

    protected int pris;
    public int skatt( ) {return pris;}
}

class Personbil extends Bil {
 private int antallPassasjer;
 public int skatt( ) {return pris * 2;}
}

class Lastebil extends Bil {
 private double lastevekt;
 public int skatt ( ) {return pris / 2;}
}

class Drosje extends Personbil {
 private String loyveId;
 public int skatt ( ) {return pris / 4;}
}


