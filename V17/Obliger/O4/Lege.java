//Skrevet av: Jonas Roppestad Olsen (Brukernavn: jonasrol)

class Lege implements Comparable<Lege>{ //Implementerer Comparable<Lege>

  protected String navn; //String som holder paa legens navn
  protected Koe<Resept> reseptliste = new Koe<Resept>(); //Koe som holder paa resptene legen har skrevet ut

  public Lege(String navn){ //Konstruktoer for Lege
    this.navn = navn;
  }

  public String toString(){
    return "Navn: " + navn;
  }

  public String hentNavn() { //Returnerer legens navn
    return navn;
  }

  public int compareTo(Lege annenLege) { //Sammenligner legens navn med navnet til en annen lege
    return this.navn.compareTo(annenLege.navn);
  }

  public void leggTilResept(Resept resept) { //Legger til en resept inn i reseptliste
    reseptliste.settInn(resept);
  }

  public Koe<Resept> hentReseptliste() { //Returnerer reseptliste
    return reseptliste;
  }
}


interface Kommuneavtale { //Interface som brukes av Fastlege
    public int hentAvtalenummer();
}


class Fastlege extends Lege implements Kommuneavtale{ //Utvider Lege og implementerer Kommuneavtale

  private int avtalenummer; //int som holder paa fastlegens avtalenummer

  public Fastlege(String navn, int avtalenummer){ //Konstruktoer for Fastlege
    super(navn); //Sender navn til Lege sin Konstruktoer
    this.avtalenummer = avtalenummer;
  }

  public String toString(){
    return "Navn: " + navn + " avtalenummer: " + avtalenummer;
  }

  public int hentAvtalenummer(){ //Returnerer avtalenummer
    return avtalenummer;
  }
}