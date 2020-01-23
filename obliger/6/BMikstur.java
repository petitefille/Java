public class BMikstur extends Legemiddel implements Mikstur
{
	private int vanedannelse;
	private int mengde;
	private int virkestoff;
	
	
	public BMikstur(String na, int p, int n)
	{
	    super(na,p);
        this.vanedannelse = n;		
	}
	
	public void Mikstur(int m, int v)
	{
		this.mengde = m;
		this.virkestoff = v;
		
		
	}
	public String toString()
	{
			return super.toString() + ", mikstur, " + super.prisToString() + ", " + mengde + ", " + virkestoff + ", " + vanedannelse;
	}
   	
}

