
import java.util.ArrayList;

/**
   * Rute representerer en av rutene på brettet og implementerer
   * Rutegrensesnitt og definerer de metodene som skal programmeres i
   * oppgavene sammen med de andre metodene du kanskje får bruk for i
   * disse. Du skal bare programmere de metodene som har et oppgavenr.
  */
class Rute
{

	/**
         *tallverdi inneholder denne rutas verdi
         */
	private int tallverdi;
	
        /**
         *pekere til rad, kolonne og boks slik
         * ruten tilhører
         */
	private Rad rad;
	private Kolonne kolonne;
	private Boks boks;

        /**
     * Pekerkjedevariabel som i denne oppgaven brukes til å lage en
     * liste av ruter for å holde orden på rekkefølgen rutene har fått
     * verdi.
     */
        private Rute nesteRute = null;
;  

	
	Rute(int tallverdi) 
        {
		this.tallverdi = tallverdi;
	}

	public void settTallverdi(int tallverdi)
        {
            this.tallverdi = tallverdi;
        }
   
        public int lesTallverdi()
        {
            return this.tallverdi;
        }

	protected void provAlleSifferMegOgResten()() 
        {
            /**
             * metoden fjernVerdider(Rute r) sørger for at alle verdiene som ikke har en 
             * verdi får tallverdi = 0
             */
		this.rad.hentBrett().fjernVerdier(this);
	}

	
	public void settRad(Rad r)
        {  
            this.rad = r;
        }
	public void settKolonne(Kolonne k)
        {  
            this.kolonne = k;
        }
	
        public void settBoks(Boks b)
        { 
            this.boks = b; 
        }

	public Rad hentRad()
        { 
            return this.rad; 
        }

        /**
         * i steden for å programmere Rute [] iSammeKolonne()
         * er det her mulig å hente Rute [] iSammeKolonne() gjennomm
         * pekeren this.kolonne, 
         * slik at Kolonne hentKolonne() henter kolonnen ruten peker på
         * og dermed vil det være mulig å hente Rute [] 
         * akkurat som i obligen 
         */
	public Kolonne hentKolonne() 
        {
            return this.kolonne;
        }

	public Boks hentBoks() 
        { 
            return this.boks;
        }

	
	public void settVerdi(int verdi)
        {
            this.verdi = verdi;
        }

	public int hentVerdi()
        { 
            return this.verdi;
        }
}



class FyltInnRute extends Rute implements Rutegrensesnitt 
{
        /**
         * Hvis ruta har en verdi er den et objekt av VerdiRute 
         */
	FyltInnRute(int tallverdi) 
        {
		super(tallverdi);
	}

	
	public void provAlleSifferMegOgResten()
        {
		super.provAlleSifferMegOgResten();
                Rute ruta = this.rad.hentBrett().nesteVilkårligeTommeRute();
                if (ruta != null)
                    ruta.provAlleSifferMegOgResten();
       }
}



class IkkeFyltInnRute extends Rute implements Rutegrensesnitt 
{
        /**
         * Hvis ruta ikke har en verdi er den et objekt av IkkeFyltInnRute
         * Når provAlleSifferMegOgResten() kalles, vil følgende kall super.provAlleSifferMegOgResten()
         * sørge for at de rutene som er objekter av IKkeFyltInnVerdi vil da få verdien 0.
         */ 
       
	
	IkkeFyltInnRute() {
		super(0);
	}
	IkkeFyltInnRute(int tallverdi) {
		super(tallverdi);
	}

	
	public void provAlleSifferMegOgResten()
       {
		super.provAlleSifferMegOgResten();

		
		for (int verdi : this.finnAlleMuligeKandidattall()) {
			this.settTall(tallverdi);

                         Rute ruta = this.rad.hentBrett().nesteVilkårligeTommeRute();
                         if (ruta != null)
                             ruta.provAlleSifferMegOgResten(); 
                         
         

		
		
	}

        public void oppdaterKandidattal()
        {
            for (int i = 0; i < this.rad.length; i++)
            {
                this.rad[i].finnAlleMuligeKandidattall();
                this.kolonne[i].finnAlleMuligeVerdier();
                this.boks[i].finnAlleMuligeVerdier();
            } 
        }



        public void provAlleKandidatTallMegOgResten() {
		super.provAlleSifferMegOgResten();

		
		for (int verdi : this.finnAlleKandidattall()) {
			this.settTall(tallverdi);
                        // sett inn forann 
                        nesteRute = this;
                        if (forrige != null)
		            forrige.this.nesteRute = this;
                            forrige = this;
                        this.oppdaterKandidattall();
                        Ruta neste = this.rad.hentBrett().nesteMedFærrestMulige();
                        if ( neste != null)
                        {
                            neste.provAlleKandidatTallMegOgResten();
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
  void skrivLøsningsListe(Rute ruteListe)
  {
    
        if (this.nesteRute != null)
            String verdi = this.nesteRute.skrivRute();
    }

    /**
   * Metode som brukes av skrivLøsningsListe når en rute skal skrives
   * ut. Denne skal ikke programmeres i besvarelsen.
   */
    public void SkrivRute()
    {
       
     	if ((this.lesTall() > 0) && (this.lesTall() < 10))
            System.out.println(this.lesTall());
	else
	    String verdiS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".charAt((this.lesTall()-10));

			        System.out.println(verdiS)
    }

		
	

      
            
        
     /* Datastruktur for kandidattall mm. deklareres her */
   

    public ArrayList<Integer> finnAlleMuligKandidattall()
    {
        ArrayList<Integer> verdier = new ArrayList<Integer>();
	for (int i = 1; i < = this.rad.hentRad().length; i++)
	{
	    boolean check = false;
		for (int j = 0; j < this.rad.hentRad().length; j++)
		{
		    
			if (i == this.rad.hentRad()[j].lesTallverdi() || i == this.kolonne.hentKolonne()[j].lesTallverdi() || i == this.boks.hentBoks()[j].lesTallverdi())
			{
			    check = true;
			}
			    
			
		
		}
		 if (check == false)
		{
		    verdier.add(i); 
		}
		
	}
	return verdier; 

	
}
}
