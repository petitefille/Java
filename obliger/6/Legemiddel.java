public class Legemiddel      
{
	private String navn;
	private int nummer;
	private int pris;
	private static int teller = 0; 
	
	
	public void nummer(int n)
	{
		this.nummer = n;
	}
	
	public int getNummer()
	{
		return this.nummer;
	}
	
	
	public Legemiddel(String na, int p)
    {
        this.navn = na;
        this.pris = p;
        this.nummer = teller++;
	}
	
	
    public String prisToString()
	{
		String p = Integer.toString(this.pris);
		return p;
	}
	
    public String toString()
	{
			return nummer + ", " + navn;
	}	
	
	
}
