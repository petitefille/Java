//Skrevet av: Jonas Roppestad Olsen (Brukernavn: jonasrol)

class Pasient{

  private String navn; //String som holder paa navn
  private long fodselsnummer; //long som holder paa fodselsnummer
  private String gateadresse; //String som holder paa gateadresse
  private int postnummer; //int som holder paa postnummer
  private int id; //int som er denne pasientens unike ID
  private static int idTeller; //en teller som sier hvilken ID den neste nye personen skal ha

  private Stabel<Resept> resepter = new Stabel<Resept>(); //Oppretter en ny stabel som holder paa Resept

  public Pasient(String navn, long fodselsnummer, String gateadresse,
        int postnummer) { //Konstruktoer for Pasient
          this.navn = navn;
          this.fodselsnummer = fodselsnummer;
          this.gateadresse = gateadresse;
          this.postnummer = postnummer;
          this.id = this.idTeller;
          idTeller++;
        }

  @Override//Overskriver toString()
  public String toString(){ //Returnerer en String med info
    return "Navn: " + navn + " fodselsnummer: " + fodselsnummer;
  }

  public int hentId() { //Returnerer pasientens ID
    return id;
  }

  public String hentNavn() { //Returnerer pasientens navn
    return navn;
  }

  public long hentFodselsnummer() { //Returnerer pasientens fodselsnummer
    return fodselsnummer;
  }

  public String hentGateadresse() { //Returnerer pasientens gateadresse
    return gateadresse;
  }

  public int hentPostnummer() { //Returnerer pasientens postnummer
    return postnummer;
  }

  public void leggTilResept(Resept resept) { //Legger inn en resept i resepter
    resepter.settInn(resept);
  }

  public Stabel<Resept> hentReseptliste() { //Returnerer pasientens resepter
    return resepter;
  }

}