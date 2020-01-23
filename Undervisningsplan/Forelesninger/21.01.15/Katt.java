class Katt{

    private String navn;
    private int vekt = 3750;
    private Katt mor = null;

    Katt(String n, Katt mor){
        navn = n;
        this.mor = mor;
    }

    Katt(String n, int v){
        navn = n;
        vekt = v;
    }

    public void settVekt(int v){
        vekt = v;
    }
}

 
