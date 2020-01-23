import java.lang.Object;

public class Kolonne 
{
	private String navn = "Kolonne ";
	private static int teller = 1;
	private int ID;
	private Rute [] kolonne;
	
	public Kolonne()
	{
	    this.ID = teller++;	
	}
	
	public void lagNyKolonne(int i)
	{
	    this.kolonne = new Rute[i];    	
	}
	
	public void settInnRuteIKolonne(Rute r, int i)
	{
	   this.kolonne[i] = r; 	
	}
	
	public Rute [] hentKolonne()
	{
		return this.kolonne; 
	}
	
	public String toString()
	{
		String IDen = Integer.toString(this.ID);
		return this.navn + IDen; 
	}
}