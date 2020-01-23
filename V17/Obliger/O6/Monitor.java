//Skrevet av Jonas Roppestad Olsen (Brukernavn: jonasrol)

import java.util.concurrent.locks.Lock; //Importerer Lock
import java.util.concurrent.locks.Condition; //Importerer Condition
import java.util.concurrent.locks.ReentrantLock; //Importerer ReentrantLock
import krypto.*; //Importerer krypto.jar

public class Monitor{
  private Koe<Melding> meldinger  = new Koe<Melding>(); //Koe som holder paa meldinger

  private Lock laas = new ReentrantLock(); //Ny laas
  private Condition erTom = laas.newCondition(); //Ny Condition



  public void settInn(Melding melding){ //metode for aa sette inn meldinger i koen
    laas.lock(); //laaser slik at ingen andre traader faar tilgang foer den er laast opp

    try{
      meldinger.settInn(melding); //setter inn melding i koen
        erTom.signal(); //signaliserer de andre traadene
    }finally{ //laaser til slutt opp laasen
      laas.unlock();
    }
  }

  public Melding hentMelding()throws InterruptedException{ //henter melding fra koen
    laas.lock(); //laaser slik at ingen andre traader faar tilgang foer den er laast opp

    try{
      if(meldinger.erTom() && Oblig6.aktiveTelegrafister() && Oblig6.aktiveKryptografer()){
        return null;
      }
      if(meldinger.erTom() && Oblig6.aktiveTelegrafister() && !Oblig6.aktiveKryptografer()){
        return null;
      }
      if(meldinger.erTom()){
        erTom.await();
      }
      return meldinger.fjern();
    }catch(InterruptedException ie){
      throw ie;
    }finally{
      laas.unlock();
    }
  }

}