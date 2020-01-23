class Fastlege extends Leger implements Avtalenummer
{
    private String avtalenummer;
	
	public Fastlege(String na)
	{
	    super(na);
        	
	}
	
   
	
	public void Avtalenummer(String a)
	{
	    this.avtalenummer =  a;
	}
	
	public String toString()
	{
			return super.toString() + ", "+ avtalenummer;
	}
	
}