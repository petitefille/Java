class AntallMonitorR implements AntallMonitor
{
    private int counterWordTilNa = 0;
    private int antallFerdigeSubtrader = 0;
	private int k;
	
	public void setK(int n)
	{
		this.k = n;
	}
    public synchronized void vent() 
	{
        while (antallFerdigeSubtrader != k) 
	    {
            try 
			{
			    wait();
                System.out.println(antallFerdigeSubtrader + " ferdige subtråder ");
            }
            catch (InterruptedException e) 
		    {
                System.out.println(" Uventet avbrudd ");
                System.exit(1);
            }
        }
    }
    public synchronized void giAntallVerdi (int minVerdi) 
	{
        antallFerdigeSubtrader ++;
		this.counterWordTilNa = this.counterWordTilNa + minVerdi;
        if(antallFerdigeSubtrader == k)
		{
		    notify(); 
		}
	}
	
     public synchronized int hentAntall() 
	{
        return this.counterWordTilNa;
    }
}