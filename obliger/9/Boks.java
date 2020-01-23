import java.lang.Object;

public class Boks 
{
    private String navn = "Boks ";
	private static int teller = 1;
	private int ID;
	private Rute [][] boks;
	
	public Boks()
	{
		//this.boks = b; 
		this.ID = teller++; 
	}
	
	public void lagNyboks(int i, int j)
	{
	    this.boks = new Rute[i][j];    	
	}
	
	public void settInn(Rute r, int i, int j)
	{
	   this.boks[i][j] = r; 	
	}
	
	public Rute [][] hentBoks()
	{
		return this.boks; 
	}
	
	public String toString()
	{
		String IDen = Integer.toString(this.ID);
		return this.navn + IDen;
	}
}