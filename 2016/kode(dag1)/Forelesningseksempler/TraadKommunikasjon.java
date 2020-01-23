class Traadkommunikasjon {
    //	private static int verdien = 0;
    private static int verdien = 0;
	
    public static synchronized void oekVerdi() {
        verdien++;
    }
    public static synchronized void giVerdi( int merverdi ) {
        verdien += merverdi;
    }

    public static int hentVerdi() {
        return verdien;
    }
	
    public static void main(String[] args) throws InterruptedException {
        int n = 1000;
        Thread[] traadene = new Thread[ n ];
        for ( int k = 0; k<n; k++ ) {
        traadene[k] = new Thread( new Tellertraad() );
        traadene[k].start();
        }
        for ( int k = 0; k<n; k++ ) {
            traadene[k].join();
        }
        System.out.println("hei fra main:" + verdien);
    }
}

class Tellertraad implements Runnable {
    public void run() {
        int  verdienMin = 0;
        for ( int i=0; i<1000; i++ ) {
            verdienMin++; //Traadkommunikasjon.oekVerdi();
        }
        Traadkommunikasjon.giVerdi( verdienMin );
        //        System.out.println(this + ": " + Traadkommunikasjon.hentVerdi());
    }
}

 