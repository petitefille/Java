//Skrevet av: Jonas Roppestad Olsen (Brukernavn: jonasrol)

class Legeliste extends OrdnetLenkeliste<Lege>{

  /**
 * Soeker gjennom listen etter en lege med samme navn som `navn`
 * og returnerer legen (uten aa fjerne den fra listen).
 * Hvis ingen slik lege finnes, returneres `null`.
 * @param   navn    navnet til legen
 * @return  legen
 */
public Lege finnLege(String navn) {
    Lege legen = null; //Legen som skal returneres
    for(Lege leger : this){ //for-each loekke som gaar igjennom listen
      if(navn.compareTo(leger.hentNavn()) == 0){ //Bruker compareTo og hvis navnene er like
        legen = leger; //Sett legen til aa vaere den legen som loekken er paa naa
        break; //Bryter loekken
      }
    }
    return legen; //Returnerer legen
  }

/**
 * Returnerer et String[] med navnene til alle legene i listen
 * i samme rekkefoelge som de staar i listen.
 * @return array med navn til alle legene
 */
public String[] stringArrayMedNavn() {
    String[] navneliste = new String[storrelse()]; //Oppretter en array som har like mange plasser som det er elementer i lista
    int i = 0; //En teller for aa holde styr paa hvor langt vi har kommet i lista
    for(Lege leger : this){ //for each loekke som gaar igjennom listen
      navneliste[i] = leger.hentNavn(); //Setter navnet til en lege paa en plass i arrayen
      i++; //Oeker telleren med 1
      if(i == storrelse()){ //Hvis telleren er lik som antall leger i listen
        break; //Bryt loekken
      }
    }
    return navneliste; //Returner navneliste
  }
}