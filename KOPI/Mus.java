public class Mus

{
    private boolean syk;
    private int vekt;
    private boolean lever = true;
    private static int counter = 1;
    private String navn;


    
    
    public boolean syk()
    {
        return syk;
    }

    public int vekt()
    {
        return vekt;
    }
   
    public boolean lever()
    {
        return lever;
    }
  
   
    public Mus(int v, boolean s)
    {
        vekt = v;
        syk = s;
        navn = "" + counter++;;
    }
// Denne metoden mÃ¥tte jeg lage fordi hvis katten hadde 2 eller fler mus i magen, sÃ¥ vil den bite musen som lever (men ikke spise den).
// Dette medfÃ¸rer at hvis musen er frisk, sÃ¥ blir den syk, og hvis musen er syk, sÃ¥ dÃ¸r den.
// Derfor har jeg da gjort det slik at metoden gaaPaaJaktI kaller pÃ¥ metoden bitt() nÃ¥r katten
// som gÃ¥r pÃ¥ jakt har 2 eller fler mus i magen, slik at musen som bor i musebolet vil da bli syk eller dÃ¸.
    public void bitt()
    {
        if (!syk) 
        {
            syk = true;
        }
        else 
        {
            lever = false;
            syk = false;
        }
    }
 
    public void sjekktilstand(String testid, String navn, boolean syk, int vekt, boolean lever)
     {
              
        String utfall;
        System.out.println("********* Test av musobjekt, testid: " + testid + " ***");
        System.out.println("** navn: " + navn + ", OK.");
        
        if (syk == this.syk)
        {
            utfall = "** syk: " + syk + ", OK.";
            System.out.println(utfall);
        }
        else
        { 
            utfall = "** syk: FEIL, aktuell verdi: " + this.syk + ", forventet verdi: " + syk; 
            System.out.println(utfall);
        }
        if (vekt == this.vekt)
        {
            utfall = "** vekt: " + vekt + ", OK.";
            System.out.println(utfall);
        }
        else
        { 
            utfall = "** vekt: FEIL, aktuell verdi: " + this.vekt + ", forventet verdi: " + vekt;
            System.out.println(utfall); 
        }
         if (this.lever == lever)
        {
            utfall = "** lever: " + lever + ", OK.";
            System.out.println(utfall);
        }
        else
        { 
            utfall = "** lever: FEIL, aktuell verdi: " + this.lever + ", forventet verdi: " + lever; 
            System.out.println(utfall);
        }
    }

    public void infoOmTilstand(String word)
    {
       String vektPrint = Integer.toString(vekt());
       String sykPrint = Boolean.toString(syk());
       String leverPrint = Boolean.toString(lever());
               
       System.out.println("--- " + word + " --- Info om mus: navn:musNr" + navn + ", vekt:" + vektPrint + ", syk:" + sykPrint + ", lever:" + leverPrint);

    }      

}    

