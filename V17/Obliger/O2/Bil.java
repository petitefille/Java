//INF 1010 Oblig2
//Skrevet av: Jonas Roppestad Olsen (Brukernavn: jonasrol)

class Bil{

  protected String regNummer; //int variabel som holder paa bilens reg.nr

  public Bil(String regNummer){ //konstruktoer som har med reg.nr som parameter
    this.regNummer = regNummer; //setter klassens regnummer til aa vaere lik den medsendte
  }

  public void printInfo(){ //metode som skriver ut bilens reg.nummer
    System.out.println(regNummer);
  }

}