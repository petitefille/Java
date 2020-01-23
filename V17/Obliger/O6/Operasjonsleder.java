//Skrevet av Jonas Roppestad Olsen (Brukernavn: jonasrol)

import java.io.PrintWriter; //Importerer PrintWriter
import java.io.File; //Importerer File
import java.io.FileNotFoundException; //Importerer FileNotFoundException
import java.io.UnsupportedEncodingException; //Importerer UnsupportedEncodingException
import krypto.*; //Importerer krypto.jar


public class Operasjonsleder{
  private static Object[] kanalMeldinger;
  private static Monitor  dekryptertMonitor;


  public static void skrivUt(int antallKanaler, Monitor paramDekryptertMonitor)throws InterruptedException{
    kanalMeldinger = new Object[antallKanaler];
    dekryptertMonitor = paramDekryptertMonitor;

    for (int i = 0; i < antallKanaler; i++){
      OrdnetLenkeliste<Melding> nyListe = new OrdnetLenkeliste<Melding>();
      kanalMeldinger[i] = (Object) nyListe;
    }

    while(Oblig6.aktiveKryptografer()){
      settInn(); //kaller paa metoden settInn()
    }

    skrivUtTilFil(); //Kaller paa metoden skrivUtTilFil
  }

  private static void settInn()throws InterruptedException{
    Melding m = dekryptertMonitor.hentMelding();
    while (m != null){
      OrdnetLenkeliste<Melding> liste = (OrdnetLenkeliste<Melding>) kanalMeldinger[m.hentKanalId()];
      liste.settInn(m);
      m = dekryptertMonitor.hentMelding();
    }
  }

  private static void skrivUtTilFil(){ //Metode som skriver meldingene til fil
    System.out.println("SKRIVER TIL FIL");
    try{
      for (int i = 0; i < kanalMeldinger.length; i++){
        PrintWriter pw = new PrintWriter("kanal_" + i + ".txt", "UTF-8");
        OrdnetLenkeliste<Melding> liste = (OrdnetLenkeliste<Melding>) kanalMeldinger[i];
        for (Melding m : liste){
          pw.println(m.hentMelding() + "\n");
          //System.out.println(m.hentMelding() + "\n"); //test
        }
        pw.close();
      }
    }catch(UnsupportedEncodingException|FileNotFoundException feil){
      System.out.println(feil);
    }
    System.out.println("PROGRAM FERDIG");
  }
}