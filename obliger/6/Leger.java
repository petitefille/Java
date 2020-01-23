//
class Leger implements Lik, Comparable<Leger>
{
    private String navn;
	private Leger l;

	
	public void navn(String n)
	{
		this.navn = n;
	}
	
	public String getNavn()
	{
		return this.navn;
	}
	
	
	public Leger l()
	{
		return (this.l = l);
	}
	
	public Leger(String na)
	{
	    this.navn = na;
	}
	
	
	public boolean samme(String s)
	{
	    return (this.navn == s);
    }
	
	public int compareTo(Leger t)
	{
		
		Leger l2 = (Leger) t;
		return (this.navn.compareTo(l2.navn));
		
		
	}
	
	public String toString()
	{
		return navn;
	}
	
	
	
	
	

}
