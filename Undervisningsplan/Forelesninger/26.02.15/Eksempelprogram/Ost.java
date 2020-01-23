class Ost implements Skattbar {
    private int innkjPris;
    Ost(int ip) {
	innkjPris = ip;
    }

    public int skatt( ) { return innkjPris * 3; }

}
