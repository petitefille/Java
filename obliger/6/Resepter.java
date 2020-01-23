class Resepter

{
    
	private int nummer;
	private static int teller = 0;
	private int reit;
	
	
	
	private Legemiddel legemiddelet;
	private Leger legen;
	private Personer personen;
	
	public int getNummer()
	{
		return this.nummer;
	}
	
	public boolean gyldighet()
	{
		String r = Integer.toString(this.reit);
        return (r != "0");
    }
	
        
	
	
	public Resepter(int p, String n, int l, int r)
	{
	  this.nummer = teller++;
	  this.reit = r;
	  this.legen.navn(n);
	  this.personen.nummer(p);
	  this.legemiddelet.nummer(l);
	  
	    
	}
	
	
	public String toStringNummer()
	{
		String n = Integer.toString(this.nummer);
		return n;
	}
	
	public String toStringPersNrLegeNavnLegemiddelNr()
	{
		String legeNavn = this.legen.getNavn();
		int persNr = this.personen.getNummer();
		int legemiddelNr = this.legemiddelet.getNummer();
		String persNrSt = Integer.toString(persNr);
		String legemiddelSt = Integer.toString(legemiddelNr);
		
		
		String r = Integer.toString(this.reit);
		
		
		return persNrSt + ", " + legeNavn + ", " + legemiddelSt + ", " + r;
	}
	
	public String toString()
	{
			String nr = Integer.toString(this.nummer) ;
			return nr;
	}	
	
	
	
}
