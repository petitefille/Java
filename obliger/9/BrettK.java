
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.lang.Object;
import java.util.*;
import java.lang.reflect.Method;  


class Brett extends LenkeListe<Rute>
{
	
	private  int antallRaderKolonnerIBrett;
	private int antallRuterIBrett;
	private int antallRaderIBoks;
	private int antallKolonnerIBoks;
	private int antallRuterIBoks;
	protected Rute [][] ruter; 
	private Rute [][] temp; 
    //protected Rute neste; 	
	//protected boolean harNeste;
	protected LenkeListe<Rute> beholder;
	protected Iterator<Rute> brettiterator; 
	private int x = 3; 
	
	
	
	public Brett()
	{
	    
	}
	
	public int hentAntallRaderKolonnerIBrett()
	{
		return this.antallRaderKolonnerIBrett;
	}
	
	
	public void skrivUtRuteneIBrettet()
	{
	    for (int j = 0; j <this.antallRaderKolonnerIBrett ; j++)	
        {
			String word = ""; 
			for (int i = 0; i < this.antallRaderKolonnerIBrett; i++)
	    	{
				Rute r  = this.ruter[j][i];
				String s = r.toString();
				word = word + s;
			}
			System.out.println(word);
		}				
	}
	
	public void lesFil()
	{
	    try
		{
			File inputFile = new File("data4.txt");
		    Scanner in = new Scanner(inputFile);
			String line = in.nextLine();
			line = line.trim();
			int len = line.length();
			String radString = line.substring(0,len);
			this.antallRaderIBoks = Integer.parseInt(radString);
			line = in.nextLine();
			line = line.trim();
			String kolonneString = line.substring(0, line.length());
			this.antallKolonnerIBoks = Integer.parseInt(kolonneString);
			this.antallRaderKolonnerIBrett = this.antallRaderIBoks*this.antallKolonnerIBoks;
    		this.ruter = new Rute[this.antallRaderKolonnerIBrett][this.antallRaderKolonnerIBrett];
			for (int j = 0; j < antallRaderKolonnerIBrett ; j++)
			{
				line = in.nextLine();
	     		line = line.trim();
				len = line.length();
				for (int i = 0; i < len; i++)
				{
				    String value = Character.toString(line.charAt(i));
					Rute r = new Rute(value);	
                    this.ruter[j][i] = r;					
				}	
			}
		}
		catch (FileNotFoundException exception)
		{
		    System.out.println("Could not open input file");
        }
	}
	
	public void delInnIRuter()
	{
	    for (int i = 0; i < this.antallRaderKolonnerIBrett; i++ )
		{
			Rad raden = new Rad(this.ruter[i]);
            for (int j = 0; j < this.antallRaderKolonnerIBrett; j++)
            {
			    Rute r = this.ruter[i][j];
                r.settRad(raden);
          				
			}				
		}
     	for (int ii = 0; ii < this.antallRaderKolonnerIBrett; ii++)
		{
			Kolonne k = new Kolonne();
			k.lagNyKolonne(this.antallRaderKolonnerIBrett);
			for (int kk = 0; kk < this.antallRaderKolonnerIBrett; kk++)
			{
			    k.settInnRuteIKolonne(this.ruter[kk][ii], kk); 
            }
            for (int tro = 0; tro < this.antallRaderKolonnerIBrett; tro ++)
            {
				this.ruter[tro][ii].settKolonne(k);
			}				
		}	
		int s = 0; 
        int k = 0; 		
		int minRadS = 0;
		int maksRadS = 	this.antallRaderIBoks;	
		int minKolonneS = 0;
		int maksKolonneS = this.antallKolonnerIBoks;
        int x = 0;
		int y = 0; 		
		while (maksRadS <= this.antallRaderKolonnerIBrett)
		{
		    minKolonneS = 0;
			maksKolonneS = this.antallKolonnerIBoks;
		    while (maksKolonneS <= this.antallRaderKolonnerIBrett)
			{
				Boks boksen = new Boks();
				boksen.lagNyboks(this.antallRaderIBoks,this.antallKolonnerIBoks);
				for ( s = minRadS; s < maksRadS; s++)
				{
				    for (k = minKolonneS; k < maksKolonneS; k++) 
					{	
					    boksen.settInn(this.ruter[s][k], y, x);	
						x = x + 1;
					}
					y = y + 1;
				    x = 0;
                }
				y = 0;	
                for ( s = minRadS; s < maksRadS; s++)
				{
					for (k = minKolonneS; k < maksKolonneS; k++) 
					{
						this.ruter[s][k].settBoks(boksen);
					}	
				}	
				minKolonneS = minKolonneS + this.antallKolonnerIBoks;
				maksKolonneS = maksKolonneS + this.antallKolonnerIBoks; 
            }
            minRadS = minRadS + this.antallRaderIBoks;
			maksRadS = maksRadS + this.antallRaderIBoks;
		}
		
		
		
		
		for (int skal = 0; skal < this.antallRaderKolonnerIBrett; skal ++)
		{
			for (int tar = 0; tar < this.antallRaderKolonnerIBrett; tar++)
			{
				Rute ror = this.ruter[skal][tar];
				String kano = ror.toString();
				System.out.println(" i "  + skal + "j " + tar + " ruten " +kano);
				Boks bratt = ror.finnBoks();
				Rad skade = ror.finnRad();
				Kolonne sketch = ror.finnKolonne();
				Rute [] so = skade.hentRad();
				Rute [] hurra = sketch.hentKolonne();
				String slem = skade.toString();
				String bad = sketch.toString();
				System.out.println(slem);
				for (int ia = 0; ia < this.antallRaderKolonnerIBrett; ia ++ )
				{
					Rute graa = so[ia];
					String hein = graa.toString();
                    System.out.println(hein);					
				}	
				
				System.out.println(bad);
				for (int no = 0; no < this.antallRaderKolonnerIBrett; no++)
				{
					Rute stop = hurra[no];
					String sally = stop.toString();
					System.out.println(sally);
				}	
				String hehe = bratt.toString();
				Rute [][] skatt = bratt.hentBoks();
				System.out.println(hehe);
				for (int vind = 0; vind < this.antallRaderIBoks; vind++)
				{
					for (int dra = 0; dra < this.antallKolonnerIBoks; dra ++)
					{
						Rute hoi = skatt[vind][dra];
						String seil = hoi.toString();
						System.out.println(" Boksen  " + seil );
					}	
				}
            }	
		}
	}
	
	public void task()
	{
		for (int i = 0; i < this.antallRaderKolonnerIBrett; i++)
		{
			for (int j = 0; j < this.antallRaderKolonnerIBrett; j++)
			{
			    Rute r = this.ruter[i][j];
				System.out.println(" i " + i + " j " + j);
                int [] bingo = r.finnAlleMuligTall();
		        for (int s = 0; s < bingo.length; s++)
	            {
					System.out.println(" s " + s);
		            int svar = bingo[s];
			        System.out.println(svar);
	            }				
			}	
		}	
		
	}
    
	
    public void task2()
	{
		int tall = this.antallRaderKolonnerIBrett-1; 
		for (int i = 0; i < this.antallRaderKolonnerIBrett; i++)
		{
			for (int j = 0; j < this.antallRaderKolonnerIBrett; j++)
			{
				if (j != tall && j != tall)
				{
				    Rute r = this.ruter[i][j];
					r.settNeste(this.ruter[i][j+1]);	
				}
                
				 else if (j == tall && i != tall)
				 {
					Rute rr = this.ruter[i][j];
					rr.settNeste(this.ruter[i+1][0]); 
				 }
				 else if (j == tall && i == tall)
				 {
					 Rute rrr = this.ruter[i][j];
					 rrr.settNesteSiste();
				 }
			}
		}
		for (int m = 0; m < this.antallRaderKolonnerIBrett; m++ )
		{
			for (int n = 0; n < this.antallRaderKolonnerIBrett; n++)
			{
				Rute rute = this.ruter[m][n];
				System.out.println(" m " +  m + " n " + n);
				System.out.println("rute: " + rute.toString());
				Rute neste = rute.hentNeste();
				System.out.println("neste: " + neste );
			}	
		}	
       this.ruter[0][0].fyllInnDenneOgNeste();		
	/*	
		this.beholder = new LenkeListe<Rute> ();
		for (int i = 0; i < this.antallRaderKolonnerIBrett; i++)
		{
			for (int j = 0; j < this.antallRaderKolonnerIBrett; j++)
			{
				this.beholder.settInnBak(this.ruter[i][j]);
			}	
		}
		
		this.brettiterator = this.beholder.iterator();
		this.brettiterator.next().tt(); */
		//this.brettiterator.next().tt(); 
		//brettiterator.next().fyllInnDenneOgNeste();
		//Rute r = new Rute(".");*/
		
		
		
		
		//Event e = this.ruter[0][0].tasktask(); 
		//this.ruter[0][0].fyllInnDenneOgNeste();
		//foran.obj.fyllInnDenneOgNeste();
		//.fyllInnDenneOgNeste();
		//Iterator<Rute> ruteiterator = beholder.iterator();
	    //while ( ruteiterator.hasNext() ) {
	   // ru = ruteiterator.next();
	   // System.out.println("Dette er et skattebelagt objekt ["
	//		       + sk + "] med skatt NOK " + sk.skatt());
	//}
	    //Rute r = ruteiterator.next();
        //r.fyllInnDenneOgNeste();
		//String s = this.ruter[0][0].toString();
		//System.out.println("s " + s);
	//}
	
	
		//r.settInnBeholder(beholder);
		//r.settInnIterator(ruteiterator);
		 
		//r.fyllInnDenneOgNeste();
		
		//Rute r = this.ruteiterator.next();
		
		//this.neste = this.ruteiterator.next();
		//this.harNeste = this.ruteiterator.hasNext();
		//Rute r2 = this.neste; 
		
		//System.out.println(r2.toString() + " here I am ");
		//Rute rs = this.ruteiterator.next();
			//String sr = rs.toString();
            //System.out.println(sr + " grr");	
		//if (this.harNeste)
		//{
			//System.out.println(" What !");
		//}	
		// teste om forste er . eller ikke 
		/*
        this.ruteiterator.next().fyllInnDenneOgNeste();
		for (int m = 0; m < this.antallRaderKolonnerIBrett; m++)
		{
			for (int n = 0; n < this.antallRaderKolonnerIBrett; n++)
			{
			     Rute r = this.ruter[m][n];
                 String s = r.toString();
				 System.out.println(s);
				 
			}	
		}
        
		*/
		
	}
	
    
		   
}	
        

        		
