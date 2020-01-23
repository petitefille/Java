//Skrevet av Jonas Roppestad Olsen (Brukernavn: jonasrol)

import krypto.*;
import java.util.concurrent.CountDownLatch;

public class Oblig6{
    private static final int antallTelegrafister = 3; //antall telegrafister programmet bruker
    private static final int kryptografer = 20; //antall kryptografer programmet bruker

    private static Monitor monitorKrypterte = new Monitor(); //Ny monitor for krypterte meldinger
    private static Monitor dekryptertMonitor = new Monitor(); //Ny monitor for dekrypterte meldinger

    private static CountDownLatch telegrafistCount; //nedtelling for telegrafister
    private static CountDownLatch kryptografCount; //nedtelling for kryptografer


    public static void main (String[] args)throws InterruptedException{ //main starter
        telegrafistCount = new CountDownLatch(antallTelegrafister);
        kryptografCount = new CountDownLatch(kryptografer);

        Operasjonssentral ops = new Operasjonssentral(antallTelegrafister); //lager en ny Operasjonssentral
        Kanal[] kanal = ops.hentKanalArray(); //henter ut array med kanaler fra Operasjonssentral


        for (int i = 0; i < antallTelegrafister; i++){ //Oppretter og starter telegrafister
          new Thread(new Telegrafist(kanal[i], i, monitorKrypterte)).start();
        }

        for (int i = 0; i < kryptografer; i++){ //Oppretter og starter kryptografer
          new Thread(new Kryptograf(monitorKrypterte, dekryptertMonitor)).start();
        }

        Operasjonsleder.skrivUt(kanal.length, dekryptertMonitor); //kaller paa skrivUt i Operasjonsleder
    }

    public static boolean aktiveKryptografer(){
      return (kryptografCount.getCount() > 0 ? true : false);
    }

    public static boolean aktiveTelegrafister(){
      return (telegrafistCount.getCount() == 0 ? true : false);
    }

    public static void kryptografAvsluttet(){ //teller ned antall aktive kryptografer
      kryptografCount.countDown();
    }

    public static void telegrafistAvsluttet(){ //teller ned antall aktive telegrafister
      telegrafistCount.countDown();
    }
}