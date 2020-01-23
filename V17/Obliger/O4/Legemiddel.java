//Skrevet av: Jonas Roppestad Olsen (Brukernavn: jonasrol)

class Legemiddel{

  protected int id; //int som holder paa legemiddelets unike ID
  protected static int idTeller = 0; //Teller som sier hvilken ID det neste legemiddelet skal ha
  protected String navn; //String som holder paa navnet til legemiddelet
  protected double pris; //double som holder paa prisen til legemiddelet
  protected double virkestoff; //double som holder paa antallet mg virkestoff i legemiddelet

  protected Legemiddel(String navn, double pris, double virkestoff){ //Konstruktoer for Legemiddel
    this.navn = navn;
    this.pris = pris;
    this.virkestoff = virkestoff;
    this.id = idTeller;
    idTeller++;
  }

  @Override //Overskriver toString()
  public String toString(){ //Returnerer en String med info
    return "Navn: " + navn + " ID: " + id + " Pris: " + pris + " virkestoff: " +
            virkestoff + " mg";
  }


  public int hentId() { //Returnerer legemiddelets ID
    return id;
  }

  public String hentNavn() { //Returnerer legemiddelets navn
    return navn;
  }

  public double hentPris() {  //Returnerer legemiddelets pris
    return pris;
  }

  public double hentVirkestoff() { //Returnerer legemiddelets dose med virkestoff
    return virkestoff;
  }
}


class LegemiddelA extends Legemiddel{ //LegemiddelA utvider Legemiddel

  private int narkotiskStyrke; //int som holder paa LegemiddelA sin narkotiske styrke

  public LegemiddelA(String navn, double pris, double virkestoff, int styrke){ //Konstruktoer for LegemiddelA
    super(navn, pris, virkestoff); //Kaller paa Legemiddel sin konstruktoer og sender med navn, pris og virkestoff
    this.narkotiskStyrke = styrke;
  }

  public int hentNarkotiskStyrke(){ //Returnerer legemiddelets narkotiske styrke
    return narkotiskStyrke;
  }
}


class LegemiddelB extends Legemiddel{ //LegemiddelB utvider Legemiddel

  private int vanedannendeStyrke; //int som holder paa legemiddelets vanedannende styrke

  public LegemiddelB(String navn, double pris, double virkestoff, int styrke){ //Konstruktoer for LegemiddelB
    super(navn, pris, virkestoff); //Kaller paa Legemiddel sin konstruktoer og sender med navn, pris og virkestoff
    this.vanedannendeStyrke = styrke;
  }

  public int hentVanedannendeStyrke(){ //Returnerer legemiddelets vanedannende styrke
    return vanedannendeStyrke;
  }
}


class LegemiddelC extends Legemiddel{ //LegemiddelC utvider Legemiddel
  //Gjoer ikke noe annet enn Legemiddel
  public LegemiddelC(String navn, double pris, double virkestoff){
    super(navn, pris, virkestoff); //Kaller paa Legemiddel sin konstruktoer og sender med navn, pris og virkestoff
  }
}