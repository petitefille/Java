public provAlleMuligeSifferIMeg()
{
    Rute [] verdier = this.finnAlleMuligeTall();
	for (int i = 0; i < verdier.length; i++)
	{
	    this.settVerdi(verdier[0])
	}
	

}

public Rute nesteVilkarligeTommeRute()
{

}


public ArrayList<Integer> finnAlleMuligTall()
{
    ArrayList<Integer> verdier = new ArrayList<Integer>();
	for (int i = 0; i < = this.iSammeRad().length; i++)
	{
	    boolean check = false;
		for (int j = 1; j <= this.iSammeRad().length; j++)
		{
		    
			if (i == this.isammeRad()[j].hentVerdi() || i == this.sammeKolonne()[j].hentVerdi() || i == this.sammeBoks()[j].hentVerdi())
			{
			    check = true;
			}
			    
			
		
		}
		 if (check = false)
		{
		    verdier.add(i); 
		}
		
	}
	return verdier; 

	
}
