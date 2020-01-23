//INF 1010 Oblig2
//Skrevet av: Jonas Roppestad Olsen (Brukernavn: jonasrol)

class Lastebil extends Fossil{ //arver fra klassen Fossil som igjen arver fra Bil

  protected double nyttevekt; //double-variabel som holder paa lastebilens nyttevekt

  public Lastebil(String regNummer, double utslipp, double nyttevekt){ //konstruktoer med parametere
    super(regNummer, utslipp); //kaller paa konstruktoeren til Fossil og sender med parametere
    this.nyttevekt = nyttevekt; //setter klassens nyttevekt til aa vaere lik parameteren
  }

  @Override //overstyrer Fossil klassen sin printInfo()
  public void printInfo(){ //skriver ut info om lastebilen
    System.out.println("Type motorvogn:    Lastebil");
    System.out.println("Reg.nr: " + regNummer);
    System.out.println("CO2-utslipp: " + utslipp + " g/km");
    System.out.println("Nyttevekt: " + nyttevekt + " kg");
  }
}