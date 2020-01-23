//INF 1010 Oblig2
//Skrevet av: Jonas Roppestad Olsen (Brukernavn: jonasrol)

class Fossil extends Bil{ //arver fra klassen Bil

  protected double utslipp; //double-variabel som holder paa fossilbilens utslipp

  public Fossil(String regNummer, double utslipp){ //konstruktoer med parametere
    super(regNummer); //kaller paa klassen Bil sin konstruktoer og sender med regNummer som parameter
    this.utslipp = utslipp; //setter klassens utslipp til aa vaere lik parameteren
  }

  @Override //overstyrer Bil sin printInfo()
  public void printInfo(){ //skriver ut info om fossilbilen
    System.out.println("Type motorvogn:    Fossil");
    System.out.println("Reg.nr: " + regNummer);
    System.out.println("CO2-utslipp: " + utslipp + "g/km");
  }
}