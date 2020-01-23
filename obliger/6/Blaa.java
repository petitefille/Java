class Blaa extends Resepter
{
	private String navn;
	
	public Blaa(String na, int p, String n, int l, int r)
	{
		super(p, n, l, r);
		this.navn = na;
		
	}
	
	public String toString()
	{
		return super.toStringNummer() + ", " + navn + ", " +  super.toStringPersNrLegeNavnLegemiddelNr();
	}

}
