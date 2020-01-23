



class Arbeider extends Thread 
{
	private OrdBuffer forrige;
	private int arbeiderNr;
	private String minsteOrd;
	
	public Arbeider(int arbeiderNr, OrdBuffer forrige)
	{
		this.arbeiderNr = arbeiderNr;
		this.forrige = forrige;
	}

    protected void leggTilMinsteOrd(String minsteOrd)
    {
            this.minsteOrd = minsteOrd;
    }

    protected String hentMinsteOrd()
    {
        return minsteOrd;
    }
	
	
	
	
	protected int hentArbeiderNr()
	{
		return this.arbeiderNr;
	}
	
	protected OrdBuffer hentForrigeOrdBuffer() {
		return forrige; 
	}	
	
	

	
	
	
}
