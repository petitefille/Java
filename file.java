

import java.util.ArrayList;
import java.lang.Object;

class Brett 
{
	
	private  int antallRaderKolonnerIBrett;
	private int antallRuterIBrett;
	private int antallRaderIBoks;
	private int antallKolonnerIBoks;
	private int antallRuterIBoks;
	private Rute [][] ruter; 
	private Rute [][] temp;  
		
	public Brett()
	{
	    
	}
	
	public int hentAntallRaderKolonnerIBrett()
	{
		return this.antallRaderKolonnerIBrett;
	}
	
	
	
	public void delInnIRuter()
	{
	    for (int i = 0; i < this.antallRaderKolonnerIBrett; i++ )
		{
			Rad raden = new Rad(this.ruter[i]);
            for (int j = 0; j < this.antallRaderKolonnerIBrett; j++)
            {
			    Rute r = this.ruter[i][j];
                r.settRad(raden);
          				
			}				
		}
     	for (int ii = 0; ii < this.antallRaderKolonnerIBrett; ii++)
		{
			Kolonne k = new Kolonne();
			k.lagNyKolonne(this.antallRaderKolonnerIBrett);
			for (int kk = 0; kk < this.antallRaderKolonnerIBrett; kk++)
			{
			    k.settInnRuteIKolonne(this.ruter[kk][ii], kk); 
            }
            for (int tro = 0; tro < this.antallRaderKolonnerIBrett; tro ++)
            {
				this.ruter[tro][ii].settKolonne(k);
			}				
		}	
		int s = 0; 
        int k = 0; 		
		int minRadS = 0;
		int maksRadS = 	this.antallRaderIBoks;	
		int minKolonneS = 0;
		int maksKolonneS = this.antallKolonnerIBoks;
        int x = 0;
		int y = 0; 		
		while (maksRadS <= this.antallRaderKolonnerIBrett)
		{
		    minKolonneS = 0;
			maksKolonneS = this.antallKolonnerIBoks;
		    while (maksKolonneS <= this.antallRaderKolonnerIBrett)
			{
				Boks boksen = new Boks();
				boksen.lagNyboks(this.antallRaderIBoks,this.antallKolonnerIBoks);
				for ( s = minRadS; s < maksRadS; s++)
				{
				    for (k = minKolonneS; k < maksKolonneS; k++) 
					{	
					    boksen.settInn(this.ruter[s][k], y, x);	
						x = x + 1;
					}
					y = y + 1;
				    x = 0;
                }
				y = 0;	
                for ( s = minRadS; s < maksRadS; s++)
				{
					for (k = minKolonneS; k < maksKolonneS; k++) 
					{
						this.ruter[s][k].settBoks(boksen);
					}	
				}	
				minKolonneS = minKolonneS + this.antallKolonnerIBoks;
				maksKolonneS = maksKolonneS + this.antallKolonnerIBoks; 
            }
            minRadS = minRadS + this.antallRaderIBoks;
			maksRadS = maksRadS + this.antallRaderIBoks;
		}
		
		
		
		
	}

        
	
     public static int randInt(int min, int max) {

    // NOTE: Usually this should be a field rather than a method
    // variable so that it is not re-seeded every call.
    Random rand = new Random();

    // nextInt is normally exclusive of the top value,
    // so add 1 to make it inclusive
    int randomNum = rand.nextInt((max - min) + 1) + min;

    return randomNum;
}

      public Rute nesteVikårligeTommeRute()
      {
           boolean check = false;
           Rute nesteVilkårligeTommeRute = null; 
           while (antallRuterIgjen != 0 && check != true)
           {
               int radNr = randInt( 0, this.feltStorrelse-1);
               int kolonneNr = randInt(0, this.feltSorrelse-1);
               Rute r = this.ruter[radNr][kolonneNr];
               if (r.hentVerdi() == 0)
                   check = true;
           }
           if (check == true & antallRuterigjen != 0) 
               return nesteVilkårligeTommeRute;
           else
               return null; 

      }

    public Rute nesteMedFærrestMulige()
    {
        boolean check = false;
        Ruter ruten = nesteVilkårligeTommeRute();
        ArrayList <integer> verdier = ruten.finnAlleMuligeKandidattall();
        for (int i = 0; i < this.antallRaderKolonnerIBrett; i++)
        {
            for (int j = 0; j < this.antallRaderKolonnerIBrett; j++)
            {
                Rute ruta = this.ruter[i][j];
                if (ruta == 0)
                    ArrayList<intefer> tall = ruta.finnAlleKandidattall();
                    if (tall.size() < verdier.size())
                        verdier = tall;
                        ruta = ruten;
            }
        }
        return ruten;
    }
                    

        
	
	public void fjernVerdier(Rute r) {
		if (r != null) {
			if (r instanceof IkkeFyltInnVerdiRute)
				r.settTall(0);

			this.tomBrett(r.neste);
		}
	}
	
	


    
		   
}	
        

        		
/** Hovedklassen for denne oppgaven. Klassen leser inn en sudokuoppgave
 * og finner alle løsninger. NB. Du skal bare programmere ferdig det det
 * spørres konkret etter i oppgavene.
 */


class Sudoku {

  /**
   * En peker til Brettet
   */

   private Brett brett; 

  
   public Rute [][] hentBrett()



  /**
   * Variabel som alltid inneholder antall tomme ruter (ruter uten
   * tallverdi) i brettet. Lik n x n når brettet er tomt. Lik 0 når
   * brettet inneholder en løsning.
   */
  int antallRuterIgjen;

  /**
   * Peker til en pekerkjedeliste (gjennom pekeren nesteRute) av ruter
   * som skal liste rutene historisk etter når de fikk tallverdi satt,
   * nyeste først, den elsdste sist.
   */
  Rute historikk;

  /**
   * Konstruktøren skisseres bare her og skal ikke lages ferdig i
   * oppgaven. Brettets dimensjon bestemmes her og brettet opprettes.
   */
  Sudoku (int dimensjon) { .... }  

   


   
    /* Datastruktur for kandidattall mm. deklareres her */
    .......

    /**
     * Metoder fra grensesnittet Rutegrensesnitt. Du skal bare
     * programmere metodene som har fått oppgavenummer.
     */
    int dimensjon(){...};
    int radNr(){...};
    int kolonneNr(){...};
    int lesTall(){...};
    void settTall(int j){...};
    Rute [] iSammeRad(){...};
    Rute [] iSammeKolonne()
    {
        Rute [][] brettet = this.sudoku.hentBrett();
        int lengde = brettet[0].length;
        Rute [] kolonne = new Rute [lengde];
	    int kolonneNr = this.hentKolonneNr();
           int radNummer = this.hentRadNr();
           for (int i = 0; i < lengde; i++)
               Rute ruta = brettet[i][radNummer-1];
               kolonne[i] = ruta;
       return kolonne; 
                
               
           
         
		String verdier;
        while nesteRute != null 
		{
		    Rute r = nesteRute;
			if nesteRute.hentKolonneNr == kolonneNr
			int verdi = nesteRute.hentVerdi();
			String i = Integer.toString(verdi);
			verdier = verdier + i;
		}
		int [] verdierKolonne = new int [verdier.length()];
		for (int k = 0; k < verdier.length(); k++)
		{
		    String i = verdier.substring(k,k+1);
            int value = integer.parseInt(i);
            verdierKolonne[k] = value;			
		}
		
		return verdierKolonne();
	
	}
	{ /* oppgave 2 */ };
    Rute [] iSammeBoks(){...};
    void oppdaterKandidattall(){ /* oppgave 3 */ };
    int nesteKandidatTall(){...};
    void varsleBerørteRuter(){...};
    void harFunnetLøsning(){...};
    Rute nesteMedFærrestMulige(){...};
    void provAlleSifferMegOgResten() { /* oppgave 1 */ };
    void provAlleKandidatTallMegOgResten() { /* oppgave 4 og 5 */ };
    void skrivLøsningsListe(Rute ruteListe) { /* oppgave 6 */ };
    void skrivRute(){...};
  } /** end Rute */
    
} /** end class Sudoku */

/**
 * Et grensesnitt for en klasse som skal implementere en rute i et
 * sudokubrett. Inneholder noen metoder du skal programmere ut (i
 * klassen Rute som implementerer Rutegrensesnitt) som en del av
 * besvarelsen. De andre metodene skal du ikke skrive, men du kan bruke
 * dem.
 */
interface Rutegrensesnitt {
  
  /**
   *verdien en rute har når den er tom
   */
  static final int TOM_RUTE = -999;
    
  /**
   * dimensjonen til sudokubrettet
   *
   * dimensjonen er lik antall rader og kolonner og lik antall ruter i en
   * boks for det brettet denne ruta hører til. For eks. for et 9 x 9 brett
   * er dimensjonen lik 9.
   *
   * @return sudokubrettets dimensjon
   */
  int dimensjon();

  /**
   * @return radnummeret til raden ruta hører til (nummerert ovenfra og
   * ned, 1, 2, ..., n).
   */
  int radNr();

  /**
   * @return kolonnenummeret til kolonnen ruta hører til (nummerert fra
   * venstre mot høyre, 1, 2, ..., n).
   */
  int kolonneNr();

  /**
   * @return rutas tallverdi hvis det er satt, TOM_RUTE hvis
   * ruta er tom.
   */
  int lesTall();

  /**
   * @param tallet ruta skal ha/verdien ruta skal settes til
   */
  void settTall(int j);

  /**
   * @return en array med pekere til de ruteobjektene som er i samme rad
   * som denne ruta.
   */
  Rute [] iSammeRad();

  /**
   * @return en array med pekere til de ruteobjektene som er i samme
   * kolonne som denne ruta.
   */
  Rute [] iSammeKolonne();

    /**
   * @return en array med pekere til de ruteobjektene som er i samme boks
   * som denne ruta.
   */
  Rute [] iSammeBoks();

  /**
   * oppdaterer kandidattallene til en rute ved å sjekke hvilke tall som
   * er satt i de berørte rutene.
   */
  void oppdaterKandidattall();
  {
      Rute verdierRad
	  Rute verdierKolonne
	  Rute verdierBoks
	  this.iSammeRad()
	  for 
	      finn alleMuligeKanditat
	  this.iSammeBoks()
	  this.iSammeKolonne()
	  
  }
  /**
   * @return neste kandidattall for denne ruta en etter en. Er det ingen
   * (igjen) returnerer den TOM_RUTE.
   */
  int nesteKandidatTall();

  /** 
   * sender et varsel til berørte ruter om at at det har skjedd en
   * endring (ny eller fjerning) av tall i denne ruta. Berørte ruter
   * kaller i sin tur oppdaterKandidattall for å fange opp denne
   * endringen. Etter kallet er alle ruters kandidattall korrekte.
   */
  void varsleBerørteRuter();

  /**
   * kalles når det er plassert et tall i alle ruter og programmet har
   * funnet en løsning på sudokuoppgaven
   */
  void harFunnetLøsning();

  /**
   * @return returnerer (en peker til) den ruta
   * med færrest kandidattall, evt. til en av dem hvis flere.
   */
  Rute nesteMedFærrestMulige();
{
    if (nesteRute != null && nesteRute.hentVerdi() == 999)
}

  /**
   * @return returnerer (en peker til) en (vilkårlig) tom rute.
   */
  Rute nesteVilkårligeTommeRute();
  {
  while this.nesteRute != null && this.nesteRute.hentVerdi() != 999
      
      if (nesteRute != null && nesteRute.hentVerdi() == 999)
	  {
	     return nesteRute;
	  }
    else if (nesteRute != null && nesteRute.hentVerdi() != 999)
    {
          
}
	  else if (nesteRute == null)
	  {
	      return null; 
	  }
  }

  /** Finner alle løsninger for et gitt brett ved å prøve alle mulige (kandidattall)
    * tall i denne ruta () og så kalle provAlleSifferMegOgResten i neste
    * tomme rute. Referanse til neste tomme rute fås ved å kalle
    * nesteVilkårligeTommeRute().
   */
  void provAlleSifferMegOgResten();
  {
       for(int verdi : this.finnMuligeKandidattall();)
	   {
	       this.settVerdi(verdi);
		   if (this.nesteVilkarligeTommeRute() != null)
		   {
		       this.nesteVilkarligeTommeRute().provAlleSifferMegOgResten();
		   }
	   }
       	   
  }
  
  
  /**
   * Finner alle løsninger for et gitt brett ved å prøve alle mulige
   * tall i denne ruta og så kalle provAlleKandidatTallMegOgResten i den
   * tomme ruta med færrest kandidattall. Referanse til denne fås ved å
   * kalle nesteMedFærrestMulige().
   */
  void provAlleKandidatTallMegOgResten();
{
       for(int verdi : this.finnMuligeKandidattall();)
	   {
	       this.settVerdi(verdi);
               this.oppdaterKandidattall();
		   if (this.nesteMedFærrestMulige() != null)
		   {
		       this.nesteMedFærrestMulige().provAlleSifferMegOgResten();
		   }
	   }
       	   
  }

  /** Skriver løsningshistorikken i kronologisk (historisk) orden.
   *
   * Lista som kommer inn som parameter peker på en pekerkjedliste av
   * ruter i omvendt rekkefølge som de skal skrives ut. Selve utskriften
   * skjer ved å kalle skrivRute().
   *
   * @param peker til liste av ruter i omvendt rekkefølge som de skal
   * skrives ut.
   */
  void skrivLøsningsListe(Rute ruteListe);

  /**
   * Metode som brukes av skrivLøsningsListe når en rute skal skrives
   * ut. Denne skal ikke programmeres i besvarelsen.
   */
  void skrivRute();
}
