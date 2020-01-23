//INF 1010 Oblig2
//Skrevet av: Jonas Roppestad Olsen (Brukernavn: jonasrol)

class Elbil extends Bil{ //arver fra klassen Bil

  protected double batteri; //double-variabel som holder paa Batterikapasiteten

  public Elbil(String regNummer, double batteri){ //konstruktoer med parametere
    super(regNummer); //kaller paa klassen Bil sin konstruktoer og sender med bilens reg.nr
    this.batteri = batteri; //setter klassens batteri-variabel til aa vaere lik den medsendte parameteren
  }

  @Override //Overstyrer klassen Bil sin printInfo
  public void printInfo(){ //Skriver ut info om elbilen
    System.out.println("Type motorvogn:    Elbil");
    System.out.println("Reg.nr: " + regNummer);
    System.out.println("Batterikapasitet: " + batteri + "kWh");
  }
}