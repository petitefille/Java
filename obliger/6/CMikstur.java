public class CMikstur extends Legemiddel implements Mikstur
{
	
	private int mengde;
	private int virkestoff;
	
    public CMikstur(String na, int p)
	{
	        super(na,p);
    }
	
	
	
	public void Mikstur(int m, int v)
	{
		this.mengde = m;
		this.virkestoff = v;
	}
	
	public String toString()
	{
			return super.toString() + ", mikstur, " + super.prisToString() + ", " + mengde + ", " + virkestoff;
	}
	
}



