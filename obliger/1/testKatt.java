public class Katt
{
    private String navn;
    private int vekt;
    private int antMus;
    private boolean syk;

    public String navn()
    {
        return navn;
    }

    public int vekt()
    {
        return vekt;
    }

    public int antMus()
    {
        return antMus;
    }

    public boolean syk()
    { 
        return syk;
    }
    
    public Katt(String navn, int vekt, boolean sykdomstatus)
    {
        this.navn = navn;
        this.vekt = vekt;
        this.syk = sykdomstatus;
    }
    
    public Katt(String navn)
    {
        this.navn = navn;
        vekt = 5000;
        syk = false; 
    }

    public Mus gaaPaaJaktI(Bol <Mus> bol)
    {   
        if (bol.beboer().lever() == false)
        {
            return null;
        }
        else
        {
            if (this.antMus >= 2)
            {
                bol.beboer().bitt();
            } 

            if ( bol.beboer().lever() == true &&  this.antMus < 2)
            {
            
                this.vekt += bol.beboer().vekt();
                this.antMus += 1;
                if (bol.beboer().syk() == true)
                {
                this.syk = true;
                }
                bol.taUt();
             }      
            return bol.beboer();
    
        }
    }
}   
