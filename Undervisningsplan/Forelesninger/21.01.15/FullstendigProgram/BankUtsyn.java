import java.util.Scanner;

/**
 * BankUtsyn
 */

class BankUtsyn{
    private Scanner tast;
    // tast gir kortvarig oppvaring av lest data
    private String navn;
    private double belop;

  /**
    * Konstruktoer
    */
    BankUtsyn(){
        tast = new Scanner(System.in);
    }

  /**
    * Skriver ut menyen og leser inn kommandovalget.
    *
    * @return    kommandovalget
    */
    public int lesKommando() {
        System.out.println("\nMeny: ");
        System.out.println("0 - avslutt");
        System.out.println("1 - Opprett ny kunde");
        System.out.println("2 - Fjern kunde");
        System.out.println("3 - Sett inn penger");
        System.out.println("4 - Finn forvaltningskapital");
        System.out.println(" Velg funksjon: ");
        return (tast.nextInt());
    }

  /**
    * Ber om navn og beloep og lagrer.
    */

    public void beOmNavnOgBeloep(){
        System.out.println("\nGi navn og beloep (paa hver sin linje): ");
        navn = tast.next();
        belop = tast.nextDouble();
    }

  /**
    * Henter navnet som er lest inn.
    *
    * @ return    navnet
    *
    */
    public String hentNavn(){
        return navn;
    }

  /**
    * Henter beloepet som er lest inn
    *
    * @return  beloepet
    */
    public double hentBelop(){
        return belop;
    }

  /**
    * Ber om og henter et navn.
    *
    * @return beloepet
    */
    public String beOmOgHentNavn(){
        System.out.print("\nGi navn: ");
        return tast.next();
    }   

  /** 
    * Skriver ut bankens forvaltningskapital.
    *
    * @param sum kapitalen som skrives ut
    */
    public void skrivSum(double sum){
        System.out.println("\nBankens forvaltningskapital: " + sum);
    }

  /**
    * Skriver ut en feilmelding.
    *
    *@param feil   feilmelding
    */
    public void skrivFeil(String feil){
        System.out.println(feil);
    }
} // end BankUtsyn

   
  
