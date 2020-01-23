public class APiller extends Legemiddel implements Piller
{
	private int narkose;
	private int mengde;
	private int virkestoff;
	
	public APiller(String na, int p, int n)
	{
	    super(na,p);
        this.narkose = n;		
	}
	
	public void Piller(int m, int v)
	{
		this.mengde = m;
		this.virkestoff = v;
	}
	
	public String toString()
	{
			return super.toString() + ", piller, " + super.prisToString() + ", " + mengde + ", " + virkestoff + ", " + narkose;
	}
   	
}