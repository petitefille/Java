abstract class Rute{

  private Labyrint l; //referanse til labyrinten ruten er en del av
  private int kolonnen, raden, x, y; //kolonnen og raden er hvor i arrayet. x og y er koordinatene som skrives ut
  private Rute nord = null, syd = null, vest= null, oest = null; //naboruter
  private static OrdnetLenkeliste<Utvei> utveier; //OrdnetLenkeliste med utveier fra denne ruten

  public Rute(Labyrint labyrint, int kol, int rad){ //konstruktoer for rute
    this.l = labyrint; //setter labyrint referansen
    this.kolonnen = kol; //setter kolonnen
    this.raden = rad; //setter raden
    this.x = kol + 1; //setter x koordinat
    this.y = rad + 1; //setter y koordinat
  }

  abstract public char tilTegn(); //abstract metode som defineres i subklassene.

  public void settNaboer(){ //metode som setter rutens naboer
    if(raden == 0){ //foerste rad
      if(kolonnen == 0){ //hvis den er helt til venstre paa foerste rad
        syd = l.hentRute(kolonnen, raden + 1); oest = l.hentRute(kolonnen + 1, raden);
      }
      else if(kolonnen == (l.hentKol() - 1)){ //hvis den er helt til hoeyre paa foerste rad
        syd = l.hentRute(kolonnen, raden + 1); vest = l.hentRute(kolonnen - 1, raden);
      }
      else{ //hvis den er mellom venstre og hoeyre paa foerste rad
        syd = l.hentRute(kolonnen, raden + 1); vest = l.hentRute(kolonnen - 1, raden); oest = l.hentRute(kolonnen + 1, raden);
      }
    }
    else if(raden == l.hentRader() - 1){ //hvis den er paa siste rad
      if(kolonnen == 0){ //hvis den er helt til venstre paa siste rad
        nord = l.hentRute(kolonnen, raden - 1); oest = l.hentRute(kolonnen + 1, raden);
      }
      else if(kolonnen == (l.hentKol() - 1)){ //hvis den er helt til hoeyre paa siste rad
        nord = l.hentRute(kolonnen, raden - 1); vest = l.hentRute(kolonnen - 1, raden);
      }
      else{ //hvis den er mellom venstre og hoeyre paa siste rad
        nord = l.hentRute(kolonnen, raden - 1); vest = l.hentRute(kolonnen - 1, raden); oest = l.hentRute(kolonnen + 1, raden);
      }
    }
    else{ //hvis ruten ikke er paa foerste eller siste rad
      if(kolonnen == 0){ //hvis den er helt til venstre
        nord = l.hentRute(kolonnen, raden - 1); syd = l.hentRute(kolonnen, raden + 1); oest = l.hentRute(kolonnen + 1, raden);
      }
      else if(kolonnen == l.hentKol() - 1){ //hvis den er helt til hoeyre
        nord = l.hentRute(kolonnen, raden - 1); syd = l.hentRute(kolonnen, raden + 1); vest = l.hentRute(kolonnen - 1, raden);
      }
      else{ //hvis den er mellom hoeyre og venstre
      nord = l.hentRute(kolonnen, raden - 1); syd = l.hentRute(kolonnen, raden + 1); vest = l.hentRute(kolonnen - 1, raden); oest = l.hentRute(kolonnen + 1, raden);
      }
    }
  }

  public void gaa(Rute fra, String vei, int lengde){ //den rekursive metoden som kaller seg selv i en annen rute
    lengde++;
    if(this instanceof Aapning){ //hvis ruten programmet befinner seg paa naa er en instanse av Aapning
      vei += "(" + x + "," + y + ") Utvei funnet."; //lagrer denne rutens koordinater og at en utvei er funnet
      utveier.settInn(new Utvei(vei, lengde)); //setter utveien inn i stabelen utveier
      return; //avslutter metoden ved aa returnere
    }

    vei += "(" + x + "," + y + ")" + " --> "; //hvis den er av saa lagrer den rutens koordinater i den medsendte String variabelen

    if(nord instanceof HvitRute && nord != fra){ //hvis nord er en instanse av HvitRute og ikke er den vi kom fra
      nord.gaa(this, vei, lengde); //kall gaa paa denne ruten og send med referanse til denne ruten og veien saa langt
    }
    if(syd instanceof HvitRute && syd != fra){ //samme som nord bare med syd
      syd.gaa(this, vei, lengde);
    }
    if(vest instanceof HvitRute && vest != fra){ //samme som nord bare med vest
      vest.gaa(this, vei, lengde);
    }
    if(oest instanceof HvitRute && oest != fra){ //samme som nord bare med oest
      oest.gaa(this, vei, lengde);
    }
  }

  public OrdnetLenkeliste<Utvei> finnUtvei(){ //metode som gjoer et kall paa gaa paa denne ruten og returnerer alle utveier herifra
    int lengde = 0;
    utveier = new OrdnetLenkeliste<Utvei>(); //Setter utveier til aa vaere en ny OrdnetLenkeliste som holder paa String variabler
    if(this instanceof SortRute){ //hvis den ruten man er paa er en instanse av SortRute
      return utveier; //returner variabelen utveier som er tom, siden vi startet paa en sort rute
    }
    this.gaa(this, "", lengde); //gjoer et kall paa metoden gaa paa denne ruten
    return utveier; //returner utveier
  }
}




class HvitRute extends Rute{ //subklasse av Rute

  public HvitRute(Labyrint labyrint, int kol, int rad){
    super(labyrint, kol, rad); //sender med parametere til superklassen sin konstruktoer
  }

  public char tilTegn(){ //den abstrakte metoden fra Rute blir definert her og returnerer et tegn
    return '.';
  }
}


class SortRute extends Rute{ //subklasse av Rute. Fungerer akkurat som HvitRute, men tilTegn() returnerer et annet tegn

  public SortRute(Labyrint labyrint, int kol, int rad){
    super(labyrint, kol, rad);
  }

  public char tilTegn(){
    return '#';
  }
}


class Aapning extends HvitRute{ //subklasse av HvitRute og tilTegn() returnerer samme tegn som superklassen
  public Aapning(Labyrint labyrint, int kol, int rad){
    super(labyrint, kol, rad);
  }
}