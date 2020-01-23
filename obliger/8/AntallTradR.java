import java.util.concurrent.ForkJoinWorkerThread;

class AntallTradR extends Thread
{
    String[] wordsSublists;
    String givenWord = "";
    int counterWord;
    int antallOrdPerKInt;
    AntallMonitor mon;

    public AntallTradR(String[] wS, AntallMonitor m, int aOPKI, String gW)
    {
        wordsSublists = wS;
        mon = m; 
        antallOrdPerKInt = aOPKI;
        givenWord = gW; 		
    }
	
	public void run()
	{
		counterWord = 0;
	    for (int y = 0; y <= antallOrdPerKInt; y++)
		{
		    String wordIt = wordsSublists[y];
			 if (wordIt != null && wordIt.equals(givenWord))
			{
			    counterWord++;	
			}	
		}	
		mon.giAntallVerdi(counterWord);	
		
	}
}

