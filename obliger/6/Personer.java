class Personer

{
    private String navn;
	private String fodselsnummer;
    private String vei;	
	private String postnummer;
	private static int teller = 0;
	private int nummer;
	
	public Personer(String na, String f)
	{
	    this.navn = na;
		this.fodselsnummer = f;
		this.nummer = teller++;
	}
	
	public void adresse(String veinavn, String nummer, String postnr)
	{
	    this.vei = veinavn + " " +  nummer;
	    this.postnummer = postnr;
	}
	
	public void nummer(int n)
	{
		this.nummer = n;
	}
	
	public int getNummer()
	{
		return(this.nummer);
	}
	
	public String toString()
	{
			return nummer + ", " + navn + ", " + fodselsnummer + ", " + vei + ", " + postnummer;
	}
	
    
	
}




