import java.util.concurrent.locks.*; // imports ikke viktig på eksamen
import java.util.concurrent.CountDownLatch;
import java.util.ArrayList;

// 4a: Må legge på låser på de to metodene for at det ikke blir kollisjoner
// eventuelt kan man gjøre metodene synchronized (ikke pensum i år)

// 4b: Vi kan bruke en CountDownLatch(1) for å vente. Kunden venter på
// CountDownLatchen og Ansatt kaller på countDown() for å vekke den igjen.
// Svaret må da lagres i bestillingen

// 4b alternativ: Vi kan lage en slags "monitorklasse" med Lock og Condition,
// kunde venter (await) og Ansatt kaller signal(). Svaret kan da returneres fra
// ventemetoden i denne klassen.

// 4b alternativ til CountDownLatch
class Ventelapp {
    Lock laas = new ReentrantLock();
    Condition kundeStatus = laas.newCondition();
    boolean ferdig = false; // Ellers kan ansatt sende signal før kunde begynner venting
    String svar;

    String vent() {
        laas.lock();
        try {
            if (!ferdig) { // her trenger vi ikke while-løkke, selv om det også hadde funket
                kundeStatus.await();
            }
            return svar;
        }
        catch(InterruptedException e) { return null; }
        finally {
            laas.unlock();
        }
    }

    void ferdig(String svar) {
        laas.lock();
        ferdig = true;
        this.svar = svar;
        kundeStatus.signal();
        laas.unlock();
    }
}

// 4c
class Bestilling {
    String varenavn;
    CountDownLatch latch; // 4b
    volatile String svar; // 4b
    //Ventelapp ventelapp; // 4b alternativ løsning, må også komme med i konstruktør
    public Bestilling(String varenavn, CountDownLatch latch) {
        this.varenavn = varenavn;
        this.latch = latch;
    }
}
// 4c
class Bestillingsbeholder {
    ArrayList<Bestilling> bestillinger = new ArrayList<Bestilling>();
    Lock laas = new ReentrantLock();
    Condition vareFinnes = laas.newCondition();

    void leggInn(Bestilling bestilling) {
        laas.lock();
        try {
            bestillinger.add(bestilling);
            vareFinnes.signalAll();
        }
        finally {
            laas.unlock();
        }
    }

    Bestilling hentBestilling() {
        laas.lock();
        try {
            while (bestillinger.size() == 0) {
                vareFinnes.await();
            }
            return bestillinger.remove(0);
        }
        catch(InterruptedException e) { return null; }
        finally {
            laas.unlock();
        }
    }
}

// 4d
class Kunde implements Runnable {
    Bestillingsbeholder bestillinger;
    String varenavn;

    public Kunde(Bestillingsbeholder bestillinger, String varenavn) {
        this.bestillinger = bestillinger;
        this.varenavn = varenavn;
    }

    // Om man bruker 4b
    public void run() {
        CountDownLatch latch = new CountDownLatch(1);
        Bestilling bestilling = new Bestilling(varenavn, latch);
        bestillinger.leggInn(bestilling);
        try {
            latch.await();
        } catch(InterruptedException e) {} // ikke superfarlig å glemme dette
        System.out.println(bestilling.svar);
    }

    // Om man bruker 4b alternativ løsning
    /*
    public void run() {
        Ventelapp lapp = new Ventelapp(); // 4b alternativ løsning
        bestillinger.leggInn(new Bestilling(varenavn, lapp));
        String svar = lapp.vent();
        System.out.println(svar);
    }
    */
}

// 4e
class Ansatt implements Runnable {
    Bestillingsbeholder bestillinger;
    VareRegister register; // antar at denne er thread-safe jf. svar i 4a

    public Ansatt(Bestillingsbeholder bestillinger, VareRegister register) {
        this.bestillinger = bestillinger;
        this.register = register;
    }

    public void run() {
        while(true) {
            Bestilling best = bestillinger.hentBestilling();

            // "hent" varen som skal lånes ut, ikke viktig for løsningen, men nyttig om man vil prøvekjøre
            try { Thread.sleep(2000); } catch(InterruptedException e) {}

            String svar = register.leie(best.varenavn);

            // 4b
            best.svar = svar; // lagre svar i bestilling, kan kombineres med linjen over
            best.latch.countDown(); // "vekker" kunden fra await

            // 4b alternativ løsning
            //best.ventelapp.ferdig(svar);
        }
    }
}
