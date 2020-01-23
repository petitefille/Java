class OrdBuffer implements AntallMonitor
{
    private int antallFerdigeSubtrader = 0;
	private int k;
	
	public void settK(int n)
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
                System.out.println(antallFerdigeSubtrader + " ferdige subtraader ");
            }
            catch (InterruptedException e) 
		    {
                System.out.println(" Uventet avbrudd ");
                System.exit(1);
            }
        }
    }
}

