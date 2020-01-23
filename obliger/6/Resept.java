class Resept
//# Resepter (nr, hvit/blå, persNummer, legeNavn, legemiddelNummer, reit)
//0, blå, 4, Dr. Oz, 2, 2
{
    
	private int nummer;
	private static int teller = 0;
	private int reit;
	
	
	
	Legemiddel l;
	Leger le;
	Personer p;
	
	public boolean gyldighet()
	{
        return (this.reit != 0);
        }
	
        public int getNummer()
        {
            return nummer;
        }
	
	
	
	public Resept(int r)
	{
	  this.nummer = teller++;
	  this.reit = r;
	}
	
	public String toString()
	{
			return nummer + ", " + navn;
	}	
	
	
	
}
