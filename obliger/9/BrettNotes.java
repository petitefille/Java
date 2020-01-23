/*
Lag en metode
void d el I n nR u t e r ( )
som oppretter riktig antall rader, kolonner og bokser, for saa aa faa hvert ruteobjekt
i brettet til aa peke paa sine respektive rader, kolonner og bokser. For at
inndelingen i bokser skal bli riktig maa du ha tatt vare paa de 2 foerste verdiene
i fila som sier antall rader i hver boks og antall kolonner i hver boks.

Tips: Gi hver rad/kolonne/boks en unik ID, paa denne maaten kan du enkelt
lage en testutskrift som loeper gjennom brettet og skriver ut hvilken rad/kolonne/boks
hver rute tilhoerer. Da ser man fort om man har gjort en feil. 
Eller:
Lag en testmetode som loeper igjennom alle rutene og som for hver rute skriver
ut info om verdi, rad, kolonne og hvilke tall som er mulige loesningstall
(ved kall paa finnAlleMuligeTall)


*/
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.lang.Object;

class Brett //extends Rute 
{
	// antall rader/kolonner i brettet = antall ruter i hver boks, kolonne og rad 
	
	private  int antallRaderKolonnerIBrett;
	// antall ruter i brettet 
	private int antallRuterIBrett;
	// antall rader i hver boks
	private int antallRaderIBoks;
	// antall kolonner i hver boks 
    private int antallKolonnerIBoks;
	//antall ruter i hver boks, kolonne og rad 
	private int antallRuterIBoks;
	// 2D Array som skal inneholde alle rutene i brettet; 
    private Rute [][] ruter; 
	
	//private Rute [][] kolonner;
	//private Rute [][] rader; 
	private Rute [][] temp;  
	
	//private Rute rute; 
	//private Rute [][] ruter; 
	
	 

	
	
	//[][] Ruter
	public Brett()
	{
	    
	}
	
	public int hentAntallRaderKolonnerIBrett()
	{
		return this.antallRaderKolonnerIBrett;
	}
	
	/*
	public int [] hentBrett()
	{
		int [] BrettInfo = new int [3];
		BrettInfo[0] = this.antallRaderKolonnerIBrett;
		BrettInfo[1] = this.antallRaderIBoks;
		BrettInfo[2] = this.antallKolonnerIBoks;
		return BrettInfo; 
	}
	*/
	
	//public void settBrett(int r,int nrRows,int nrColumns)
	//{
		/*
		this.antallRaderKolonnerIBrett = r;
		this.antallRuterIBrett = r*r; 
		
		this.antallRaderIBoks = nrRows;
        this.antallKolonnerIBoks = nrColumns;	
        this.antallRuterIBoks = nrRows*nrColumns;	
	}
	*/
	
	// metode som lagrer 2D Rute Array som inneholder alle rutene i brettet
	//public void settRuter(Rute [][] r)
	//{
		//this.ruter = r; 
	//}
	
	// metode som returnerer 2D Rute Array
	//public Rute [][] hentRuter()
	//{
		//return this.ruter; 
	//}
	
	public void skrivUtRuteneIBrettet()
	{
		    //Brett brettet = new Brett();
			//Brett brettet = b; 
			//int [] brettInfo = brettet.hentBrett();
			//Rute [][] ruter2 = brettet.hentRuter();
			
			//Rute [][] ruter2 = r; 
			//int [] brettInfo = brettet.hentBrett();
			//int radBoks = brettInfo[1];
			//int kolonneBoks =brettInfo[2];
			//int antallRaderBrett = radBoks*kolonneBoks; 
			
            for (int j = 0; j <this.antallRaderKolonnerIBrett ; j++)	
            {
				//String word = "";
				String [] tmp = new String [this.antallRaderKolonnerIBrett];
				//String wordy = "";
				for (int i = 0; i < this.antallRaderKolonnerIBrett; i++)
				{
					
				    //String r = ruterString[j][i];
					Rute r  = this.ruter[j][i];
					String s = r.toString();
					System.out.println(s);
					
					//tmp[i] = s;
					//wordy = wordy + s; 
                    
					
					//Object vv = (Object) r; 
					
					//String pp = r.toString();
					//System.out.println(r);
					
					//System.out.println(s +  " Rute ");					
				}
				//System.out.println(tmp +  " Rute ");
				//System.out.println(wordy);
				//System.out.println("\n");
				
			}				
			
		
	}
	
	
	
	/*
Lag en metode
void d el I n nR u t e r ( )
som oppretter riktig antall rader, kolonner og bokser, 
for saa aa faa hvert ruteobjekt
i brettet til aa peke paa sine respektive rader, kolonner og bokser.

 For at
inndelingen i bokser skal bli riktig maa du ha tatt vare paa de 2 foerste verdiene
i fila som sier antall rader i hver boks og antall kolonner i hver boks.

Tips: Gi hver rad/kolonne/boks en unik ID, paa denne maaten kan du enkelt
lage en testutskrift som loeper gjennom brettet og skriver ut hvilken rad/kolonne/boks
hver rute tilhoerer. Da ser man fort om man har gjort en feil. 
Eller:
Lag en testmetode som loeper igjennom alle rutene og som for hver rute skriver
ut info om verdi, rad, kolonne og hvilke tall som er mulige loesningstall
(ved kall paa finnAlleMuligeTall)


*/ 
/*

    public void settInnRad()
    {
		
		Rute ra = this.ruter[3][3];
		Rad raden = ra.hentRad();
		Rute [] ja = raden.hentRad();
		for (int i = 0; i < 6; i ++ )
		{
			Rute prim = ja[i];
			String sissi = prim.toString();
			System.out.println("sissi "+sissi);
		}	
		/*
	    for (int i = 0; i < this.antallRaderKolonnerIBrett; i++ )
	    {
			Rute r = raden[i];
			String v = r.toString();
			System.out.println(v);
		} 
		//Rad rad = new Rad(this.ruter[i]);
			//int length = this.ruter[i].length;
			//Rute [] freek = this.ruter[i];
			/*
		for (int la = 0; la < 6; la++)
		{
		    Rute tro = raden[la];
			String fiat = tro.toString();
			System.out.println("TRO" + fiat);
		}
        Rad rad = new Rad(raden);		
			//System.out.println("length "+length);
		Rute [] radene = rad.hentRad();
		for (int lo = 0; lo < radene.length; lo++)
		{
			Rute gr = radene[lo];
			String free = gr.toString();
			System.out.println("free" + free);
				
		}
    }		
		*/
    
	
		public void lesFil()
	{
	    try
		{
			File inputFile = new File("data3.txt");
		    Scanner in = new Scanner(inputFile);
			//foerste linje som er antall rad i boks 
			String line = in.nextLine();
			//tar bort white space
			line = line.trim();
			// lengde paa linjen 
			int len = line.length();
			// antall rader i boks (2) i String
			String radString = line.substring(0,len);
			// gjoer om antall rader i hver boks til int?
			//int radBoks = Integer.parseInt(radString);
			this.antallRaderIBoks = Integer.parseInt(radString);
			//leser inn neste linje
			line = in.nextLine();
			// ta bort white space
			line = line.trim();
			// linjen representerer antall kolonner i en boks
			String kolonneString = line.substring(0, line.length());
			//gjoer om antall kolonner i en boks til int ?
			//int kolonneBoks = Integer.parseInt(kolonneString);
			this.antallKolonnerIBoks = Integer.parseInt(kolonneString);
			// regner antall rader/kolonner i brettet = antall rad i en boks x antall kolonner i en boks, dette
			// tallet er ogsaa antall ruter i en boks, kolonne og rad
			//int antallRaderBrett = radBoks*kolonneBoks;
			this.antallRaderKolonnerIBrett = this.antallRaderIBoks*this.antallKolonnerIBoks;
            // oppretter et nytt objekt av klassen Brett 			
			
			// lagrer den noedvendige informasjonen i objektet av klassen Brett brettet
			//brettet.settBrett(antallRaderBrett, radBoks, kolonneBoks);
			//2D array av Rute objekter
			this.ruter = new Rute[this.antallRaderKolonnerIBrett][this.antallRaderKolonnerIBrett];
			
			
			//String [][] ruterString = new String[antallRaderBrett][antallRaderBrett];
			//lese inn verdiene av rutene 
			for (int j = 0; j < antallRaderKolonnerIBrett ; j++)
			{
				// leser neste linje
				line = in.nextLine();
				// tar bort white space
				line = line.trim();
				// lengde paa linje 
				len = line.length();
				for (int i = 0; i < len; i++)
				{
					// for hver linje tar man hver char en for en og gjoer den om til String 
					String value = Character.toString(line.charAt(i));
					//saa opprettes et nytt rute objekt hvor man som String hvor typen enten er true eller false
					//this.rute = new Rute(value);
					// saa setter man in ruten i ruter arrayen 
                  
					Rute r = new Rute(value);	
                    this.ruter[j][i] = r;					
				}	
			}
			//Brett brettet = new Brett(ruter);
			
			// algrer ruter arrayen med alle rute objektene brette inneholder i objektet brettet
			//brettet.settRuter(ruter);
			// returnerer brettet for aa kunne skrive det ut 
			//return brettet; 
            			
				
			
		}
		// exception hvis filen ikke blir funnet
		catch (FileNotFoundException exception)
		{
		    System.out.println("Could not open input file");
        }
		// eventuelt for aa returnere noe hvis filen ikke skulle bli funnet 
		
	}
	public void delInnIRuter()
	{
		
		for (int i = 0; i < this.antallRaderKolonnerIBrett; i++ )
		{
			//System.out.println(" i " + i );
			Rad raden = new Rad(this.ruter[i]);
            for (int j = 0; j < this.antallRaderKolonnerIBrett; j++)
            {
			    Rute r = this.ruter[i][j];
                r.settRad(raden);
          				
			}				
		}
       // Rute a = this.ruter[0][0];
       // Rad aa = a.finnRad();
		//Rute [] b = aa.hentRad();
		//for (int h = 0; h < 6 ; h++)
		//{
			//Rute c = b[h];
			//String d = c.toString();
			//System.out.println(d);
		//}	
		
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
		/*
        for (int hh = 0; hh < 6; hh++)
        {
			for (int ll = 0; ll< 6; ll++)
			{
				Kolonne klone = this.ruter[hh][ll].finnKolonne();
				Rute [] finn = klone.hentKolonne();
				Rad radar = this.ruter[hh][ll].finnRad();
				Rute [] aske = radar.hentRad();
				for(int ha = 0; ha < 6; ha ++ )
				{
				    Rute bror = finn[ha];
                    String nesten = bror.toString();
                    System.out.println(" kolonne " + nesten);					
				}
                for (int steg = 0; steg < 6; steg++)
                {
					Rute mor = aske[steg];
					String kan = mor.toString();
					System.out.println(" RAD " + kan);
				}					
			}	
		}	
		*/

        int s = 0; 
        int k = 0; 		
		//Rute [][] temp = new Rute [this.antallRaderIBoks][this.antallKolonnerIBoks];
        //this.temp =  new Rute [this.antallRaderIBoks][this.antallKolonnerIBoks]; 		
	    //Rute [] tid = new Rute[this.antallKolonnerIBoks];
		int minRadS = 0;
		//System.out.println(minRadS + " minRadS");
		int maksRadS = 	this.antallRaderIBoks;	
		//System.out.println(maksRadS+ " maksRadS");
        int minKolonneS = 0;
		//System.out.println(" minKolonneS");
        int maksKolonneS = this.antallKolonnerIBoks;
        //System.out.println(maksKolonneS+ " maksKolonneS");		
        int x = 0;
		//System.out.println(x + " x");
        int y = 0; 		
		//System.out.println(y + " y"); 
	    while (maksRadS <= this.antallRaderKolonnerIBrett)
		{
			//System.out.println("while maksRadS <= this.antallRaderKolonnerIBrett");
            //System.out.println( " maksRad: " + maksRadS  + " antall Rader/Kolonner i Brett" + this.antallRaderKolonnerIBrett);
			minKolonneS = 0;
			maksKolonneS = this.antallKolonnerIBoks;
		    while (maksKolonneS <= this.antallRaderKolonnerIBrett)
			{
				Boks boksen = new Boks();
				//System.out.println("Boks bo = new Boks(); ");
				boksen.lagNyboks(this.antallRaderIBoks,this.antallKolonnerIBoks);
				//System.out.println("bo.lagNyboks(2,3); ");
				//System.out.println(" while maksKolonneS <= this.antallRaderKolonnerIBrett");
				//System.out.println(" maksKolonneS" + maksKolonneS+ "this.antallRaderKolonnerIBrett "+ this.antallRaderKolonnerIBrett);
			    for ( s = minRadS; s < maksRadS; s++)
				
				{
					//System.out.println("for (int s = minRadS; s < maksRadS; s++)");
                    //System.out.println(" minRadS "+ minRadS + " maksRadS " +maksRadS+ " s " + s);	
					
		            for (k = minKolonneS; k < maksKolonneS; k++) 
						
		     		{	
					
					    //System.out.println(" for (int k = minKolonneS; k < maksKolonneS; k++) ");
					  // System.out.println("minKolonneS " + minKolonneS);
						//System.out.println(" maksKolonneS "+ maksKolonneS);
						//System.out.println(" k " + k);
				        
						
                        //Rute r = this.ruter[s][k];
					     //String vag = r.toString();
						 
						//System.out.println("Rute r" + vag);
						//String zy = r.toString();
						//System.out.println("String zy = r.toString();" + zy );
						//System.out.println(" s "+ s + " k "+ k);
						
						boksen.settInn(this.ruter[s][k], y, x);	
						//this.ruter[s][k].settBoks();
						//System.out.println("bo.settInn(this.ruter[s][k], y, x");
                        //System.out.println(" y " + y +  " x " + x);						
				        //tid[x] = r;
						
						//System.out.println("this.ruter[s][k], y, x");
						//System.out.println("x "+x);
						x = x + 1;
						//System.out.println("x = x + 1;");
						//System.out.println(x);
						
			        }
					/*
					
					for (int g = 0; g < this.antallKolonnerIBoks; g++)
                    {
						this.temp[y][g] = tid[g];
					}	
*				
			        //this.temp[y ] = tid;
					for (int h = 0; h < this.antallKolonnerIBoks; h++ )
					{
						Rute r = this.temp[y][h];
						//System.out.println("y "+ y + " h " + h);
						//String hyh = r.toString();
						//System.out.println("String hyh = r.toString()"+ hyh);
					}	*/
						
					//System.out.println("temp[y ] = tid;");
					//System.out.println("y " + y);
					y = y + 1;
					//System.out.println("y = y + 1");
					//System.out.println("y: " + y);
                    x = 0;
                   // System.out.println("x = 0;");
                   //System.out.println("x "+ x);
					/*
					for (int h = 0; h < this.antallKolonnerIBoks; h++ )
					{
						Rute r = this.temp[0][h];
						//System.out.println("  h " + h);
						//String hyh = r.toString();
						//System.out.println("String smile = r.toString()"+ hyh);
					}	*/
                    					
				}
				
                y = 0;	
                //System.out.println("y = 0");
                //System.out.println("y " + y);
                //System.out.println(" Lager Boks");
				/*
				for (int h = 0; h < this.antallKolonnerIBoks; h++ )
					{
						Rute r = this.temp[y][h];
						//System.out.println("y "+ y + " h " + h);
						//String hyh = r.toString();
						//System.out.println("String hyh = r.toString()"+ hyh);
					}	/*
				
				Boks pakken = new Boks(this.temp);
				/*
			
				/*
				Rute [][] bing = pakken.hentBoks();
				for (int c = 0; c < 2; c++)
				{
					for (int d = 0; d < 3; d ++)
					{
						Rute r = bing[c][d];
						String foo = r.toString();
						System.out.println("boks " + foo);
					}	
				}	
				*//*
				for (int i = 0; i < this.antallRaderIBoks; i++)
				{
					for(int j = 0; j < this.antallKolonnerIBoks; j++)
					{
						Rute r = this.temp[i][j];
						//System.out.println("Rute r = temp[i][j];" + " i " + i + " j " + j );
						//String zi = r.toString(); 
						//System.out.println("String zi = r.toString;" + zi);
						r.settBoks(pakken);
						//String ss = r.toString();
						//System.out.println(ss);
					}	*/
				for ( s = minRadS; s < maksRadS; s++)
				{
					for (k = minKolonneS; k < maksKolonneS; k++) 
					{
						this.ruter[s][k].settBoks(boksen);
						//System.out.println("this.rute[s][k].settBoks(bo)");
						
					}	
				}	
					
                minKolonneS = minKolonneS + this.antallKolonnerIBoks;
				//System.out.println("minKolonneS = minKolonneS + this.antallKolonnerIBoks;");
				//System.out.println("minKolonneS " + minKolonneS + " antallKolonnerIBoks " + this.antallKolonnerIBoks);
                maksKolonneS = maksKolonneS + this.antallKolonnerIBoks; 
                //System.out.println( "maksKolonneS = maksKolonneS + this.antallKolonnerIBoks; ");
                //System.out.println("maksKolonneS " + maksKolonneS + "  this.antallKolonnerIBoks; " + this.antallKolonnerIBoks);
                

				
            }
            minRadS = minRadS + this.antallRaderIBoks;
			//System.out.println("minRadS = minRadS + this.antallRaderIBoks;");
			//System.out.println(" minRadS " + minRadS + " this.antallRaderIBoks; " +this.antallRaderIBoks);
            maksRadS = maksRadS + this.antallRaderIBoks;
			//System.out.println("maksRadS = maksRadS + this.antallRaderIBoks;");	
			//System.out.println("maksRadS " + maksRadS + " this.antallRaderIBoks " + this.antallRaderIBoks  );
			
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
		Rute r = this.ruter[2][1];
		int [] bingo = r.finnAlleMuligTall();
		for (int s = 0; s < bingo.length; s++)
	    {
		    int svar = bingo[s];
			System.out.println(svar);
	    }
	}


    
		   
}	
        

        		
	    /*
	
	
	
	    Rute [][] navn = new Rute [this.antallRaderKolonnerIBrett][this.antallRaderKolonnerIBrett]; 
	    for (int e = 0; e < this.antallRaderKolonnerIBrett; e ++)
		{
			for (int f = 0; f < this.antallRaderKolonnerIBrett; f++)
			{
				Rute r = this.ruter[f][e];
				navn[e][f] = r;
			}
		}	
		this.ruter = navn; 
		for (int ee = 0; ee < this.antallRaderKolonnerIBrett; ee++)
		{
			for (int ff = 0; ff < this.antallRaderKolonnerIBrett; ff++)
			{
				System.out.println(" ee " + ee + " ff " + ff );
				Rute fra = this.ruter[ee][ff];
				
				String zara = fra.toString();
				System.out.println("Ruten, kolonnen"+ zara);
				Rad glow = fra.finnRad();
				b = glow.hentRad();
				for(int q = 0; q < 6; q ++)
				{
					Rute grace = b[q];
					String snoopy = grace.toString();
					System.out.println("RAD " + snoopy);
				}	
			}	
		}
        for (int ii = 0; ii < this.antallRaderKolonnerIBrett; ii++ )
		{
			System.out.println(" i " + ii );
			Rute [] ris = this.ruter[ii];
			for(int bod = 0; bod < 6; bod ++)
			{
				System.out.println(" bod " + bod);
				Rute grei = ris[bod];
				String bris = grei.toString();
			    System.out.println("xoxo " + bris);
			}	
			
			Kolonne kolonnen = new Kolonne(this.ruter[ii]);
			Rute [] good = kolonnen.hentKolonne();
			for(int hy = 0; hy < 6; hy++)
			{
				System.out.println(" hy " + hy);
				Rute hest = good[hy];
				String brad = hest.toString();
				System.out.println(" hest  " + hest);
			}	
		    
            for (int jj = 0; jj < this.antallRaderKolonnerIBrett; jj++)
            {
				System.out.println("jj " + jj + " ii "  + ii);
			    Rute r = this.ruter[ii][jj];
				String ana = r.toString();
				System.out.println("hei " + ana);
                r.settKolonne(kolonnen);
				Kolonne tja  = r.finnKolonne();
				Rute [] hva = tja.hentKolonne();
				Rad rabbat = r.finnRad();
				Rute [] krok = rabbat.hentRad();
				
				for (int ned = 0; ned < 6; ned ++)
				{
					
					System.out.println(" ned " + ned);
					Rute vet = hva[ned];
					String lav = vet.toString();
					System.out.println(" Kolonne " + lav);
					Rute ikke = krok[ned];
					String kanskje = ikke.toString();
					System.out.println(" RAD " + kanskje);
				}	
          				
			}				
		}
		
		Rute [][] tid = new Rute [this.antallRaderKolonnerIBrett][this.antallRaderKolonnerIBrett]; 
	    for (int e = 0; e < this.antallRaderKolonnerIBrett; e ++)
		{
			for (int f = 0; f < this.antallRaderKolonnerIBrett; f++)
			{
				Rute r = this.ruter[e][f];
				tid[f][e] = r;
			}
		}	
		this.ruter = tid; 
		for(int iii = 0; iii < this.antallRaderKolonnerIBrett; iii++)
		{
			for( int jjj = 0; jjj < this.antallRaderKolonnerIBrett; jjj++)
			{
				Rute row = this.ruter[iii][jjj];
				String srsr = row.toString();
				System.out.println("Rute" + srsr );
				Rad rrx = row.finnRad();
				Kolonne kkx = row.finnKolonne();
				Rute [] cold = rrx.hentRad();
				for(int lool = 0; lool < 6; lool ++)
				{
					Rute bra = cold[lool];
					String srsr2 = bra.toString();
					System.out.println(" RAD " + srsr2);
				}	
				Rute [] warm = kkx.hentKolonne();
				for(int lool2 = 0; lool2 < 6; lool2 ++)
				{
					Rute bra2 = cold[lool2];
					String srsr22 = bra2.toString();
					System.out.println(" Kolonne " + srsr22);
				}	
			}
		}	
		
	
    }
/*    
        for (int i = 0; i < this.antallRaderKolonnerIBrett; i++ )
		{
			//Rute [] tmp = new Rute [this.antallRaderKolonnerIBrett];
			for (int j = 0; j < this.antallRaderKolonnerIBrett; j++)
			{
			   
			    //tmp[j] =
				this.ruter[j][i];
				
			}
			/*
			for (int h = 0; h < 6; h++)
			{
				Rute x = tmp[h];
				String y = x.toString();
				System.out.println(" y "+ y);
			}	
			*/
			
		//	Kolonne kolonne = new Kolonne(tmp);
			//Rute [] cool = kolonne.hentKolonne();
			//for (int h = 0; h < 6; h++)
				/*
			{
				Rute x = cool[h];
				String y = x.toString();
				System.out.println(" cool "+ y);
			}	
			*/
			//Rute [] kolonnen 
			/*
			for (int k = 0; k < this.antallRaderKolonnerIBrett; k++)
			{
				Rute r = this.ruter[k][i];
				r.settKolonne(kolonne);
			}	
				
			//}
			
		}
	
	public void delInnIRuter()
	{
		
		Rute [][] bully = new Rute [this.antallRaderKolonnerIBrett][this.antallRaderKolonnerIBrett];
		for (int gg = 0; gg < this.antallRaderKolonnerIBrett; gg++)
		{
			for (int ff = 0; ff < this.antallRaderKolonnerIBrett; ff++)
			{
				bully[gg][ff] = this.ruter[gg][ff];
			}	
		}	
		Rute [] freek = new Rute[this.antallRaderKolonnerIBrett];
	    for (int i = 0; i < 2; i++ )
		{
			for (int j = 0; j < 6; j++)
			{

				freek[j] = bully[i][j];
                Rute jh = freek[j];
                String ju = jh.toString();
                System.out.println(" hm "+ju);				
			}
            			
			Rad rad = new Rad(freek);
            //Rute [] oops = rad.hentRad();			
			// klasse Boks
			for (int g = 0; g < 6; g++)
		    {
				System.out.println("i " + i + " g " + g );
				//this.rute = this.ruter[i][g]; //
				//String s = this.rute.toString();
				//System.out.println(" Rute: " + s);
				Rute fu = bully[i][g];
				String plea = fu.toString();
				//Rute gaga = new Rute(plea);
				fu.settRad(rad);
				//bully[i][g] = gaga; 
				//bullt[i][g].settRadListe(freek);// klasse Rute alle rutene har samme kolonne og boks array, men ikke navn        her endres raden for alle ruter i this.ruter klasse ruter , ruter array i klassen 
				//gaga.finnRad(); // klasse Rute       denne raden som endres lagres som verdi for alle rutene 
				// Rute her settes raden jeg bruker til å være lik raden jeg satte i sted i 
				//this.ruter[5][4]   this.ruter[0][0]
				 // rute[0][0].settRad(rad)
				 Rute vgvgvgv = bully[0][0];
				Rad vfvf = vgvgvgv.finnRad();
				Rute [] prikk = vfvf.hentRad();
				
				for(int hj = 0; hj < 6; hj++)
				{
					Rute vgvg = prikk[hj];
					String jhg = vgvg.toString();
					System.out.println("yeay or neay" + jhg);
				}	
			}	
			
		}
		*/
    
	
	
				