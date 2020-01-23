import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.lang.Object;
import java.lang.System;
import java.util.Arrays;
import java.lang.InterruptedException;
import java.lang.NumberFormatException;

public class AntallR
{
    AntallMonitor monitor;

    public static void main(String[ ] args) throws FileNotFoundException, NumberFormatException
	{
		String givenWord0;
		String fileName1;
		int k2;
		if (args.length > 2)
		{
			try
			{
			    givenWord0 = args[0];
                fileName1 = args[1];				
				k2 = Integer.parseInt(args[2]);
				new AntallR(givenWord0, fileName1, k2);
			}           			
            catch (NumberFormatException e) 
			{
                System.err.println("Argumentet" + args[0] + " må være ordet man skal telle (altså en String),\n argumentet" + args[1] + " må være navnet på filen (altså en String),\n og argumentet" + args[2]+ " må være antall tråder k (altså en integer)." );
                System.exit(1);
		    }
        }
        else
        {
			System.out.println("Man må oppgi det gitte ordet man vil telle, navnet på filen og antall tråder i kommando linjen!");
		}			
				
    }
	
	public AntallR(String gW, String f, int n )
	{
		try
		{
			String givenWord = gW;
			String filename = f;
			int k = n;
		    File inputFile = new File(filename);
            Scanner in = new Scanner(inputFile);
		    String line = in.nextLine();
		    String cS = Character.toString(line.charAt(0));
            int number = Integer.parseInt(cS);
            ArrayList<String> words = new ArrayList<String>(number);
	    	while (in.hasNextLine())
	    	{    
		        line = in.nextLine();
			    int lengde = line.length();
			    String w = line.substring(0,lengde);
                words.add(w);
            }	
            monitor = new AntallMonitorR();
		    monitor.setK(k);
	    	double antallOrdTotalt = words.size();
	    	int antallOrdTotaltInt = (int) antallOrdTotalt;
	    	double antallOrdPerK = (antallOrdTotalt/k);
	    	long antallOrdPerKL =(long)antallOrdPerK;
	    	int antallOrdPerKInt = (int) antallOrdPerKL;
		   	int task = antallOrdPerKInt+1;
	    	String[][] wordsSublists = new String[k][task];
		    if (k != 1 && antallOrdPerK == (int) antallOrdPerK)
		    {
		        int maxI = k;
			    int maxJ = k+1;
                for (int i = 0; i < k; i++) 
                {
				    ArrayList<String> time = new ArrayList<String>(words.subList(i*antallOrdPerKInt,((i+1)*(antallOrdPerKInt))));
				    Object[] times2 = time.toArray();
			        String[] times3 = Arrays.copyOf(times2, times2.length, String[].class);
				    int c = times3.length;
				    for (int m = 0; m < times3.length; m++)
				    {
				    	wordsSublists[i][m] = times3[m];
			        }
                }
                for (int z = 0; z < k; z++)
		    	{
			        new AntallTradR(wordsSublists[z], monitor, antallOrdPerKInt, givenWord).start();
			    }
			    monitor.vent();
                System.out.println("Antall ganger ordet: " + givenWord + " fantes var: " + monitor.hentAntall());
             
		    }
		    if (k!=1 && antallOrdPerK != (int) antallOrdPerK)
	    	{
			    int maxI = k-1;
			    int maxJ = k;
                for (int i = 0; i <= maxI; i++) 
                {
				    ArrayList<String> time = new ArrayList<String>(words.subList(i*antallOrdPerKInt,((i+1)*(antallOrdPerKInt))));
				    Object[] times2 = time.toArray();
				    String[] times3 = Arrays.copyOf(times2, times2.length, String[].class);
				    int c = times3.length;
			    	for (int m = 0; m < times3.length; m++)
				    {
					    wordsSublists[i][m] = times3[m];
				    }
                }
			    ArrayList<String> rest = new ArrayList<String>(words.subList(k*antallOrdPerKInt,(antallOrdTotaltInt )));
			    int x = k*antallOrdPerKInt;
			    int y =(antallOrdTotaltInt - 1);
			    Object[] rest2 = rest.toArray();
			    String[] rest3 = Arrays.copyOf(rest2, rest2.length, String[].class);
			    int rest3Lengde = rest3.length;
			    for (int i = 0; i< rest3Lengde; i++)
			    {
				    wordsSublists[i][antallOrdPerKInt] = rest3[i];
			    }
               for (int z = 0; z < k; z++)
		        {
		            new AntallTradR(wordsSublists[z], monitor,antallOrdPerKInt, givenWord).start();
		        }
			    monitor.vent();
                System.out.println("Antall ganger ordet: " + givenWord + " fantes var: " + monitor.hentAntall());			
		    }		
            if (k == 1)
		    {
		        Object[] words2 = words.toArray();
			    String[] words3 = Arrays.copyOf(words2, words2.length, String[].class);
		        int len = words3.length-1;
		        new AntallTradR(words3, monitor, len, givenWord).start();
		        monitor.vent();
                System.out.println("Antall ganger ordet: " + givenWord + " fantes var: " + monitor.hentAntall());
		    }
		}
		catch (FileNotFoundException exception)
		{
		    System.out.println("Could not open input file");
        }
    }
}