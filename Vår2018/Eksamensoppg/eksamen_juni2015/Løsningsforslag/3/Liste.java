// oppgave 3 - eksamen juni 2015

class Liste <T extends Comparable<T>> {
    private Node foran;

    private class Node {
        protected T t;
        protected Node neste;

        Node(T nyttObjekt) {
            t = nyttObjekt;
        }

        // oppgave a
        /* Metoden skal virke som compareTo, dvs returnere et heltall stoerre 
           enn null hvis objektet som k.t peker paa er mindre enn det (denne 
           nodens) t peker paa. */
        int sammenlign(Node k) {
            /* Hvis vi trenger at sammenlign virker naar den kalles fra en 
               vanlig node med et ListeEnde-objekt som argument, maa vi "snu" 
               kallet. Dette er ikke noedvendig for aa loese oppgaven riktig, 
               (se forklaring i neste metode), men det vil vaere en noedvendig 
               "workaround" hvis metoden kalles som beskrevet over. */
            // if (k instanceof ListeEnde)      // gir kompileringsfeil
            /* At linjen over gir kompileringsfeil kommer av at Javas
               implementasjon av generiske klasser er daarlig, og dette er 
               ikke noe dere ventes aa kunne. */
            if (ListeEnde.class.isInstance(k)) {
                return 0 - k.sammenlign(this);
            }

            // den vesentlige delen av metoden
            return t.compareTo(k.t);
        }
        // slutt oppgave a

        // oppgave b
        /* setter den nye noden inn etter denne noden hvis den ordningsmessig 
           skal inn der, eller sender den videre ved et rekursivt kall hvis 
           den skal inn lenger ut i lista. */
        void settInn(Node ny) {
            /* Legg merke til at vi kaller neste.sammenlign(ny) og ikke 
               ny.sammenlign(neste). Hvis vi hadde gjort sistnevnte, ville vi 
               faatt et problem med halen om vi ikke passer paa at sammenlign 
               kalt paa en vanlig node med en listeende som argument blir 
               spesialbehandlet. Vi hadde da risikert aa sammenligne et objekt 
               med null. */
            // if (ny.sammenlign(neste) > 0) {
            if (neste.sammenlign(ny) < 0) {
                // ny skal lenger ut i listen
                neste.settInn(ny);
            } else {
                ny.neste = neste;   // ny sin neste skal peke paa min neste
                neste = ny;         // min (this) neste skal peke paa ny
            }
        }
        // slutt oppgave b

        void skriv() {
            System.out.println(t);
            neste.skriv();
        }
    }

    // oppgave c
    /* Objekter av denne klassen skal brukes til to spesialnoder: Listehode og 
       listehale. Listehodet er noden som ligger foerst og -halen er noden 
       som alltid ligger sist i lenkelisten. Bruk polymorfi slik at 
       listehodenoden blir «mindre enn» alle andre noder, og slik at 
       listehalenoden er «stoerre enn» alle andre noder. */
    private class ListeEnde extends Node {
        private boolean erHode;

        ListeEnde(boolean erHode) {
            /* Det ligger et implisitt kall paa super() i slutten av 
               konstruktoerer i subklasser. Hvis vi eksplisitt kaller en av 
               superklassens konstrutoerer, forsvinner dette implisitte kallet. 
               I vaart tilfelle har ikke superklassen noen konstruktoer som 
               ikke tar inn noen parametre, saa vi maa gjoere enten gjoere et 
               eksplisitt kall super(null); eller lage enda en konstruktoer i 
               Node for aa unngaa kompileringsfeil. 
               Merk at dette ikke er veldig sentralt, saa en slik feil paa 
               eksamen ville ikke gitt mye trekk. */
            super(null);
            this.erHode = erHode;
        }

        @Override
        int sammenlign(Node k) {
            if (erHode) {
                // hodet er mindre enn alle andre noder
                return -1;
            } else {
                // halen er stoerre enn alle andre noder
                return 1;
            }
        }

        @Override
        void skriv() {
            if (erHode) {
                neste.skriv();
            }
            // halen maa ikke sende kallet videre
        }
    }
    // slutt oppgave c

    // oppgave d
    /* Her initialiseres listen med listehode og -hale. */
    Liste() {
        foran = new ListeEnde(true);
        Node hale = new ListeEnde(false);
        foran.neste = hale;
    }
    // slutt oppgave d

    public void settInn(T t) {
        Node nyNode = new Node(t);
        foran.settInn(nyNode);
    }

    public void skrivAlle() {
        System.out.println("Alle i lista:\n" + "-----");
        foran.skriv();
        System.out.println(" --- SLUTT");
    }
}

