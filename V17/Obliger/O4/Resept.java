//Skrevet av: Jonas Roppestad Olsen (Brukernavn: jonasrol)

abstract class Resept{

  protected int id; //int som holder paa reseptens unike ID
  protected static int idTeller = 0; //int som holder paa den neste reseptens ID
  protected Legemiddel legemiddel; //Hvilket legemiddel resepten er skrevet ut paa
  protected Lege lege; //Legen som skrev ut resepten
  protected int pasientId; //int som holder paa IDen til pasienten som resepten tilhoerer
  protected int reit; //int som holder paa hvor mange ganger respeten kan brukes
  protected String farge;

  Resept(Legemiddel legemiddel, Lege utskrivendeLege, int pasientId, int reit){ //Konstruktoer for Resept
    this.legemiddel = legemiddel;
    this.lege = utskrivendeLege;
    this.pasientId = pasientId;
    this.reit = reit;
    this.id = idTeller;
    idTeller++;
  }

  @Override //Overskriver toString()
  public String toString(){ //Returnerer en String med info
    return "Legemiddel: " + legemiddel + " ID: " + id + " Lege: " + lege +
            " PasientID: " + pasientId + " Farge: " + farge + " Reit: " + reit;
  }

  public int hentId() { //Returnerer reseptens ID
    return id;
  }

  public Legemiddel hentLegemiddel() { // Returnerer reseptens legemiddel
    return legemiddel;
  }

  public Lege hentLege() { //Returnerer reseptens lege
    return lege;
  }

  public int hentPasientId() { //Returnerer pasientens ID
    return pasientId;
  }

  public int hentReit() { //Returnerer antall ganger resepten kan brukes
    return reit;
  }

  /**
  * Bruker resepten én gang. Returner false om resepten er
  * oppbrukt, ellers returnerer den true.
  * @return      om resepten kunne brukes
  */
  public boolean bruk() {
    if(reit > 0){
      reit--;
      return true;
    }
    return false;
  }

  /**
  * Returnerer reseptens farge. Enten "blaa" eller "hvit".
  * @return      reseptens farge
  */
  abstract public String farge();

  /**
  * Returnerer prisen pasienten maa betale.
  * @return      prisen pasienten maa betale
  */
  abstract public double prisAaBetale();

}


class BlaaResept extends Resept{ //BlaaResept utvider Resept

  public BlaaResept(Legemiddel legemiddel, Lege utskrivendeLege, int pasientId, int reit){ //Konstruktoer for BlaaResept
    super(legemiddel, utskrivendeLege, pasientId, reit); //Kaller paa Resept sin konstruktoer og sender med legemiddel, utskrivendeLege, pasientId og reit
  }

  @Override //Overskriver farge() i Resept
  public String farge(){ //Returnerer fargen til resepten
    farge = "blaa";
    return farge;
  }

  @Override //Overskriver prisAaBetale() i Resept
  public double prisAaBetale(){ //Returnerer prisen man skal betale
    return (legemiddel.hentPris() * 0.25);
  }
}


class HvitResept extends Resept{ //HvitResept utvider Resept

  public HvitResept(Legemiddel legemiddel, Lege utskrivendeLege, int pasientId, int reit){ //Konstruktoer for HvitResept
    super(legemiddel, utskrivendeLege, pasientId, reit); //Kaller paa Resept sin konstruktoer og sender med legemiddel, utskrivendeLege, pasientId og reit
  }

  @Override //Overskriver farge() i Resept
  public String farge(){ //Returnerer reseptens farge
    farge = "hvit";
    return farge;
  }

  @Override //Overskriver prisAaBetale() i Resept
  public double prisAaBetale(){ //Returnerer prisen man skal betale
    return legemiddel.hentPris();
  }
}