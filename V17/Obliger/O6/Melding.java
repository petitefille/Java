//Skrevet av Jonas Roppestad Olsen (Brukernavn: jonasrol)

import krypto.*;

public class Melding implements Comparable<Melding>{ //Melding implementerer Comparable

    private String melding; //Selve meldingen
    private int kanalId; //IDen til kanalen meldingen kom fra
    private int sekvensNummer; //Meldingen sekvensnummer slik at vi kan sortere dem i riktig rekkefoelge

    Melding(String melding, int kanalId, int sekvensNummer){ //konstruktoer for Melding
      this.melding = melding;
      this.kanalId = kanalId;
      this.sekvensNummer = sekvensNummer;
    }


    public int hentKanalId(){ //returnerer kanalId
      return kanalId;
    }

    public int hentSekvensNummer(){ //returnerer sekvensNummer
      return sekvensNummer;
    }

    public String hentMelding(){ //returnerer melding
      return melding;
    }

    @Override //Overskriver compareTo i Comparable
    public int compareTo(Melding annen){ //Sammenligner sekvensnummeret til to meldinger
      return sekvensNummer - annen.hentSekvensNummer();
    }

    public void dekrypter(){ //metode for aa dekryptere melding
      //System.out.println(melding + "\n"); //test
      melding = Kryptografi.dekrypter(melding); //kaller paa metoden dekrypter i Kryptografi
    }
}