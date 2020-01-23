//Skrevet av Jonas Roppestad Olsen (Brukernavn: jonasrol)

import krypto.*; //importerer krypto.jar

public class Kryptograf implements Runnable{ //Kryptograf implementerer Runnable

    private Monitor kryptertMonitor; //referanse til monitor for krypterte meldinger
    private Monitor dekryptertMonitor; //referanse til monitor for dekrypterte meldinger

    Kryptograf(Monitor kryptertMonitor, Monitor dekryptertMonitor){ //konstruktoer for Kryptograf
      this.kryptertMonitor = kryptertMonitor;
      this.dekryptertMonitor = dekryptertMonitor;
    }

    public void run(){ //run metoden
      try{
        Melding m = kryptertMonitor.hentMelding(); //henter melding fra kryptertMonitor
        while (m != null){ //kjoerer saa lenge meldingen ikke er null
          m.dekrypter(); //kaller paa metoden dekrypter i melding
          dekryptertMonitor.settInn(m); //setter den dekrypterte meldingen inn i dekryptertMonitor
          m = kryptertMonitor.hentMelding(); //henter ut en ny melding fra kryptertMonitor
        }
      }catch(InterruptedException ie){ //catcher InterruptedException
        System.out.println("KRYPTOGRAF AVBRUTT"); //skriver ut til terminalen
      }finally{ //til slutt
        Oblig6.kryptografAvsluttet(); //tell ned antall kryptografer
      }
  }
}