public class CPiller extends Legemiddel implements Piller
{
	
	private int mengde;
	private int virkestoff;
	
    public CPiller(String na, int f)
	{
	    super(na,f);
    }
		
	public void Piller(int m, int v)
	{
		this.mengde = m;
		this.virkestoff = v;
	}	
	
	public String toString()
	{
			return super.toString() + ", piller, " + super.prisToString() + ", " + mengde + ", " + virkestoff;
	}
	
}
