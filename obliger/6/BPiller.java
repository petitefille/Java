public class BPiller extends Legemiddel implements Piller
{
	private int vanedannelse;
	private int mengde;
	private int virkestoff;
	
	public BPiller(String na, int f, int n)
	{
	    super(na,f);
        this.vanedannelse = n;		
	}
	
	public void Piller(int m, int v)
	{
		this.mengde = m;
		this.virkestoff = v;
	}
	
	public String toString()
	{
			return super.toString() + ", piller, " + super.prisToString() + ", " + mengde + ", " + virkestoff + ", " + vanedannelse;
	}
   	
}