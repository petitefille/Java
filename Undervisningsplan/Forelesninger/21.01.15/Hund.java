class Hund
{
    private String navn;
    private int vekt = 5000;
    private Hund mor = null;

    Hund(String n){
        navn = n;
    }

    Hund(String n, int v){
        navn = n;
        vekt = v;
    }

    public void settVekt(int v){
       vekt = v;
    }

}
