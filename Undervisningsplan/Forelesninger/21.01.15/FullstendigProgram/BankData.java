import java.util.HashMap;
/**
 * BankData er modellen / dataene i banksystemet.
 * Denne klassen innehold er alle metoder som 
 * er noedvendige for aa manipulere kontoer.
 * En ny bank inneholder ingen kontoer.
 * Alle kontoenes eiere maa ha forskjellige navn
 */

class BankData {
    
    private HashMap <String,Konto> konti = new HashMap<String,Konto>();

    /**
     * Oppretter en ny konto i banken
     *
     * @param kunde navn paa kunden
     */

    public void lagBankKunde(String navn){
        konti.put(navn, new Konto(navn));
    }

    /**
     * Fjerne en konto fra banken
     * @ param navn   navn paa kunde
     */
    public void fjernBankKunde(String navn) {
        konti.remove(navn);
    }
   
    /**
     * Summerer saldoen fra alle kontoene i banken.
     *
     * @return    summen av saldo for alle kontoer
     */
    public double sumAlleKonti(){
        double sum = 0;
        for (Konto s: konti.values())
            sum += s.hentSaldo();
        return sum;
    }

  /**
    *
    * Setter inn penger paa en konto.
    *
    * @param navn paa kunde
    * @param belop beloepet som settes inn.
    */
    public void settInn(String navn, double belop)
    {
        Konto k = konti.get(navn);
        k.settInn(belop);
    }
}

