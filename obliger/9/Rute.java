import java.lang.Object;
import java.util.*;

public class Rute extends Brett// extends Brett 
{
   
	private String verdi;
	private boolean opptatt;
	private Boks boks; 
	private Rad rad; 
	private Kolonne kolonne; 
	private int antallKolonnerIBoks;
	private int antallRaderIBoks; 
	private int antallRaderKolonnerIBrett; 
	private String [] alfabet; 
	private Brett b; 
	private Rute neste; 
	private Task oppg;
	
	public void settTask(Task o)
	{
		this.oppg = o;
	}
	
	public void settNeste(Rute r)
	{
		this.neste = r;
	}
	public void settNesteSiste()
    {
		this.neste = null; 
	}	
	
	public void settRad(Rad r)
	{
		this.rad = r;
      		
	}
	public Rute hentNeste()
	{
		return this.neste; 
	}

	public void settKolonne(Kolonne k)
	{
		this.kolonne = k; 
	}
	
	public void settBoks(Boks b)
	{
		this.boks = b; 
	}
	
	public Rute(String r)
	{
	    if (r.equals("."))
		{
	    	this.opptatt = false;
        	this.verdi = r; 
		}
		else 
		{
			this.opptatt = true;
			this.verdi = r; 
		}
    } 
	
	public Rad finnRad()
	{
		return this.rad;
	}
	
	public Kolonne finnKolonne()
	{
		return this.kolonne; 
	}
	
	public Boks finnBoks()
	{
		return this.boks; 
	}
	
	public String toString()
	{
		return this.verdi; 
	}
	
	public int [] finnAlleMuligTall()
	{
		char[] alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
		String [] alfa = new String [26];
        for (int j = 0; j < 26; j ++)
        {
			char v = alphabet[j];
			String v2 = Character.toString(v);
			alfa[j] = v2; 
		}			
		this.alfabet = alfa; 	
	    String line = ""; 
	    Rute [][] boksen = this.boks.hentBoks();
	    int t = boksen.length;
	    this.antallRaderIBoks = t; 
	    int t2 = boksen[0].length;
	    this.antallKolonnerIBoks = t2; 
	    for (int ii = 0; ii < this.antallRaderIBoks ; ii++)
	    {
		    for(int j = 0; j < this.antallKolonnerIBoks; j++)
		    {
			    Rute r = boksen[ii][j];
			    String s = r.toString() ;
			    if (!s.equals("."))
			    {
				    line = line + s;    
			    }				   
		    } 
	    } 
	    Rute [] rad = this.rad.hentRad();
	    int l = rad.length;
	    this.antallRaderKolonnerIBrett = l;
        String [] tall = new String [this.antallRaderKolonnerIBrett];
		int count = 1; 
		int count2 = 0; 
		if (this.antallRaderKolonnerIBrett < 10)
		{
			for(int vv = 0; vv < this.antallRaderKolonnerIBrett; vv ++ )
			{
				int v3 = count; 
				String s3 = Integer.toString(v3);
				tall[vv] = s3; 
				count = count + 1;
			}	
		}
        else 
		{	
		    for (int qq = 0; qq < this.antallRaderKolonnerIBrett; qq++)
		    {
			    if (qq < 9)
			    {
			        int v4 = count; 
				    String s4 = Integer.toString(v4);
				    tall[qq] = s4; 
				    count = count + 1;	
			    }
                else
                {
					String v5 = this.alfabet[count2];
					tall[qq] = v5;
                    count2 = count2 + 1;					
				}					
		    }	
		}	
		for (int i = 0; i < this.antallRaderKolonnerIBrett; i++)
	    {
		    Rute r = rad[i];
		    String s = r.toString();
		    if (!s.equals("."))
		    {
			    line = line + s; 
		    }
	    }
	    Rute [] kolonne = this.kolonne.hentKolonne();
	    for (int i = 0; i < kolonne.length; i++)
	    {
		    Rute r = kolonne[i];
		    String s = r.toString();
		    if (!s.equals("."))
		    {
			    line = line + s; 
		    }
	    } 
	    line = line.trim();
	    int len = line.length();
	    for (int x = 0; x < len; x++)
	    {
		    String s6 = line.substring(x, x+1);
            for (int bb = 0; bb < tall.length; bb++ )
            {
				String s7 = tall[bb];
				if (s7 != null && s7.equals(s6))
				{
					tall[bb] = null;
				}	
			}				
	    }
	    int tt = 0; 
	    for (int vv = 0; vv < tall.length; vv++ )
	    {
		    if (tall[vv] != null)
		    {
			    tt = tt + 1;
		    }			   
	    }  
        int [] bingo = new int [tt];
        int counter = -1;
		for (int ww = 0;ww < tall.length; ww++)
        {
		    if (tall[ww] != null && this.antallRaderKolonnerIBrett < 10)
		    {
			    counter = counter +1; 
			    String bla = tall[ww];
			    int blabla = Integer.parseInt(bla);
			    bingo[counter] = blabla;
		    }   
		    else if (tall[ww] != null && this.antallRaderKolonnerIBrett > 10)
		    {
			    counter = counter +1; 
			    String bla = tall[ww];
			    char c = bla.charAt(0);;
			    if (Character.isDigit(c))
				{
				    int k = Integer.parseInt(bla);
			        bingo[counter] = k;   
				} 
				else
				{
					int num = ((int) c) - 55 ; 
				    bingo[counter] = num;  
				}	   
		    }		   
		}   
	return bingo;
	}   
    
	
	
	public void fyllInnDenneOgNeste()
	{
		int [] svar = finnAlleMuligTall();
		String [] svar2 = new String[svar.length];
		for (int i = 0; i < svar.length; i++)
		{
			int n = svar[i];
			if (n <= 9)
			{
				String s = Integer.toString(n);
				svar2[i] = s; 
			}
            else
            {
				int t = n-10;
				String ss = this.alfabet[t];
				svar2[i] = ss; 
				
			}				
		}	
		System.out.println(" ----------------------");
	    for (int j = 0; j < svar2.length; j++)
			{
				if (this.opptatt == false)
				{
					String s = svar2[j];
				
				    this.verdi = s;
				    this.opptatt = true;
					if (this.neste == null)
					{
					   this.oppg.skrivUtRuteneIBrettet();  	
					}
				    else 
					{
					    this.neste.fyllInnDenneOgNeste();	
					}	
			        this.opptatt = false;
			    }
			}
				
		    	
			    
				
				
				
				
			
	}
	
    
   
	
	
 
}

