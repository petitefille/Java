/**
 * Bank er kontrollklassen for dette banksystemet
 * Her ligger ordrelokken som styrer det hele.
 * Denne klassen er bindeleddet mellom utsynet og datamodellen.
 *
 */

public class Bank{
   
    private BankData b; private BankUtsyn u;
    
    Bank(){
        b = new BankData();
        u = new BankUtsyn();
    }

    public static void main(String [] args){
        Bank bnk = new Bank();
        bnk.ordreloekke();
    }

  /**
    * Lager en ny konto.
    */
    void lagNyKunde(){
        String nvn = u.beOmOgHentNavn();
        b.lagBankKunde(nvn);
    }

  /**
    * Fjerner en konto
    */
    void fjernBankKunde(){
        String nvn = u.beOmOgHentNavn();
        b.fjernBankKunde(nvn);
    }

  /**
    * Setter inn penger paa en konto.
    * Noedvendig informasjon hentes via utsynet.
    */
    void settInn(){
        u.beOmNavnOgBeloep(); String navn = u.hentNavn();
        double bel = u.hentBelop(); b.settInn(navn,bel);
    }

  /**
    * Henter summen av saldo fra alle kontoer
    * og viser resultatet ved hjelp av utsyn
    */
    void sumAlleKonti(){
        double sum = 0; sum = b.sumAlleKonti();
        u.skrivSum(sum);
    }

  /**
    * Ordreloekken som styrer kommandoene.
    */
    void ordreloekke(){
        int valg;
        valg = u.lesKommando();
        while(valg != 0){
            switch (valg) {
                case 1:lagNyKunde(); break;
                case 2: fjernBankKunde(); break;
                case 3: settInn(); break;
                case 4: sumAlleKonti(); break;
                default: u.skrivFeil("Gi tall mellom 0-4");
            }
            valg = u.lesKommando();
        }
    } //end ordreloekke
} // end class Bank  

/*

Terminal> java Bank

Meny: 
0 - avslutt
1 - Opprett ny kunde
2 - Fjern kunde
3 - Sett inn penger
4 - Finn forvaltningskapital
 Velg funksjon: 
1

Gi navn: Emily

Meny: 
0 - avslutt
1 - Opprett ny kunde
2 - Fjern kunde
3 - Sett inn penger
4 - Finn forvaltningskapital
 Velg funksjon: 
2

Gi navn: Emily

Meny: 
0 - avslutt
1 - Opprett ny kunde
2 - Fjern kunde
3 - Sett inn penger
4 - Finn forvaltningskapital
 Velg funksjon: 
1

Gi navn: Mari

Meny: 
0 - avslutt
1 - Opprett ny kunde
2 - Fjern kunde
3 - Sett inn penger
4 - Finn forvaltningskapital
 Velg funksjon: 
1

Gi navn: Bjorn

Meny: 
0 - avslutt
1 - Opprett ny kunde
2 - Fjern kunde
3 - Sett inn penger
4 - Finn forvaltningskapital
 Velg funksjon: 
3

Gi navn og beloep (paa hver sin linje): 
Mari
2000

Meny: 
0 - avslutt
1 - Opprett ny kunde
2 - Fjern kunde
3 - Sett inn penger
4 - Finn forvaltningskapital
 Velg funksjon: 
3

Gi navn og beloep (paa hver sin linje): 
Bjorn
5000

Meny: 
0 - avslutt
1 - Opprett ny kunde
2 - Fjern kunde
3 - Sett inn penger
4 - Finn forvaltningskapital
 Velg funksjon: 
4 

Bankens forvaltningskapital: 7000.0

Meny: 
0 - avslutt
1 - Opprett ny kunde
2 - Fjern kunde
3 - Sett inn penger
4 - Finn forvaltningskapital
 Velg funksjon: 
0

*/

































       
