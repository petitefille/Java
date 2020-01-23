public class AMikstur extends Legemiddel & implements Mikstur
{
	private int narkose;
	
	public AMikstur(String na, int f, int n)
	{
	    super(na,f);
        this.narkose = n;		
	}
   	
}
