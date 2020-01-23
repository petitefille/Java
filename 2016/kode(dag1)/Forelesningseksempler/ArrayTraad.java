public class ArrayTraad implements Runnable {
    private final int indeks;
    private final int k;
    private final String[] a;
    
    public ArrayTraad( int indeks, int k, String[] a ) {
        this.indeks = indeks;
        this.a = a;
        this.k = k;
    }

    public void run() {
        int porsjon = a.length / k;
        int porsjonsRest = a.length % k;
        int start = indeks * porsjon;
        if ( indeks +1 == k ) {
            porsjon += porsjonsRest;
        }
        int slutt = start + porsjon;
        System.out.println( indeks + " range (" + start + "-"+slutt+")");
        for ( int i=start; i < slutt; i++ ) {
            
        } 
    }

}