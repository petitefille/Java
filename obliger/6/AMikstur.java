public class AMikstur extends Legemiddel implements Mikstur
//# Legemidler (nr, navn, form, type, pris, antall/mengde, virkestoff [, styrke])
//0, Predizol, mikstur, a, 450, 50, 75, 8


{
	private int mengde;
	private int virkestoff;
	//private String form;
	private int narkose;
	
	
	
	public AMikstur(String na, int p,  int n)
	{
	    super(na,p);
		//this.form = f;
        this.narkose = n;		
	}
	
	public void Mikstur(int m, int v)
	{
		this.mengde = m;
		this.virkestoff = v;
		
		
	}
	
	public String toString()
	{
			return super.toString() + ", mikstur, " + super.prisToString() + ", " + mengde + ", " + virkestoff + ", " + narkose;
	}
	
	
	
   	
}