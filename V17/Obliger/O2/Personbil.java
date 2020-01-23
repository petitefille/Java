//INF 1010 Oblig2
//Skrevet av: Jonas Roppestad Olsen (Brukernavn: jonasrol)

class Personbil extends Fossil{ //Arver fra klassen Fossil som igjen arver fra Bil

  protected int seter; //int-variabel som holder paa antall seter i bilen

  public Personbil(String regNummer, double utslipp, int seter){ //konstruktoer med parametere
    super(regNummer, utslipp); //kaller paa klassen Fossil sin konstruktoer og sender med regNummer og utslipp
    this.seter = seter; //setter klassens seter til aa vaere lik parameteren
  }

  @Override //overstyrer klassen Fossil sin printInfo
  public void printInfo(){ //Skriver ut info om personbilen
    System.out.println("Type motorvogn:    Personbil");
    System.out.println("Reg.nr: " + regNummer);
    System.out.println("CO2-utslipp: " + utslipp + " g/km");
    System.out.println("Antall seter: " + seter);
  }
}