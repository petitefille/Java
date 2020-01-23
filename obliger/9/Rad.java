import java.lang.Object;

public class Rad 
{
	
    private String navn = "Rad ";
	private static int teller = 1;
	private int ID;
	public Rute [] rad;
	
	public Rad(Rute [] r)
	{
		this.rad = r; 
		this.ID = teller++; 
	}
	
	public Rute [] hentRad()
	{
		return this.rad; 
	}
	
	public String toString()
	{
		String IDen = Integer.toString(this.ID);
		return this.navn + IDen;
	}
	
}