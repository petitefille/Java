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
    private Rute [][] brett; 
	
	//private Rute [][] kolonner;
	//private Rute [][] rader; 
	private Rute [][] temp;  
	
	//private Rute rute; 
	//private Rute [][] ruter; 
	
	 

	
	
	//[][] Ruter
	public Brett(Rute [][] b)
	{
	    this.brett = new Rute [6][6];
        this.brett = b;		
	}
	
	public Rute [][] hentBrett()
	{
		return this.brett; 
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
	/*
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
				String word = "";
				String [] tmp = new String [this.antallRaderKolonnerIBrett];
				String wordy = "";
				for (int i = 0; i < this.antallRaderKolonnerIBrett; i++)
				{
					
				    //String r = ruterString[j][i];
					this.rute = this.ruter[j][i];
					String s = this.rute.toString();
					System.out.println(s + "\n");
					
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
		*//*
    }	
	

	
	public void delInnIRuter()
	{
		
		Rute [] freek = new Rute[this.antallRaderKolonnerIBrett];
	    for (int i = 0; i < 6; i++ )
		{
			for (int j = 0; j < 6; j++)
			{
				freek[j] = this.ruter[i][j]; //
			}	
			Rad rad = new Rad(freek); // rad
			for (int g = 0; g < 6; g++)
		    {
				System.out.println("i " + i + " g " + g );
				//this.rute = this.ruter[i][g]; //
				//String s = this.rute.toString();
				//System.out.println(" Rute: " + s);
				this.ruter[i][g].settRad(rad);// her endres raden for alle ruter i this.ruter klasse ruter , ruter array i klassen 
				this.ruter[i][g].hentRad(); // denne raden som endres lagres som verdi for alle rutene 
				// Rute her settes raden jeg bruker til å være lik raden jeg satte i sted i 
				//this.ruter[5][4]   this.ruter[0][0]
				 // rute[0][0].settRad(rad)
				Rad boo = this.ruter[0][0].hentRad();
				Rute [] vfvf = boo.hentRad();
				for(int hj = 0; hj < 6; hj++)
				{
					Rute vgvg = vfvf[hj];
					String jhg = vgvg.toString();
					System.out.println("yeay or neay" + jhg);
				}	
				
				/*
				//this.rute = this.ruter[0][0];
	            Rad radxx = this.rute.hentRad();
	            Rute [] liste = radxx.hentRad();
	           for(int u = 0; u < 6; u++)
	            {
		           Rute gr = liste[u];
		           String nei = gr.toString();
		          System.out.println("oh no!!!!!!! " + nei );
	            } 	
				
				 */
				
				
				//r.hentRad()
				//Rute [] dd = r.hentRad();
				//for (int ii = 0; ii < 6; ii++)
				//{
					//Rute k = dd[ii];
					//String fi = k.toString();
					//System.out.println(" Rad " + i + fi);
					
				//}	
	//		}
			//Rute [] free = rad.hentRad();
			//for (int h = 0; h < 6; h++)
			//{
				//Rute rrrrr = free[h];
				//String frr = rrrrr.toString();
				//System.out.println(" what " + frr);
			//}	
				
			
   //     }
/*		
			Rad rad = new Rad(this.ruter[i]);
			int length = this.ruter[i].length;
			Rute [] freek = this.ruter[i];
			for (int la = 0; la < 6; la++)
			{
				Rute tro = freek[la];
				String fiat = tro.toString();
				System.out.println("TRO" + fiat);
			}	
			System.out.println("length "+length);
			Rute [] raden = rad.hentRad();
			for (int lo = 0; lo < raden.length; lo++)
			{
				Rute gr = raden[i];
				String free = gr.toString();
				System.out.println("free" + free);
			}	
			for (int j = 0; j <this.antallRaderKolonnerIBrett; j ++)
			{
			   Rute rr = this.ruter[i][j];
			   rr.settRad(rad);	
			}
		}
		*//*
        
        for (int i = 0; i < this.antallRaderKolonnerIBrett; i++ )
		{
			Rute [] tmp = new Rute [this.antallRaderKolonnerIBrett];
			for (int j = 0; j < this.antallRaderKolonnerIBrett; j++)
			{
			   
			    tmp[j] = this.ruter[j][i];
				
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
				
		int s = 0; 
        int k = 0; 		
		//Rute [][] temp = new Rute [this.antallRaderIBoks][this.antallKolonnerIBoks];
        this.temp =  new Rute [this.antallRaderIBoks][this.antallKolonnerIBoks]; 		
	    Rute [] tid = new Rute[this.antallKolonnerIBoks];
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
				//System.out.println(" while maksKolonneS <= this.antallRaderKolonnerIBrett");
				//System.out.println(" maksKolonneS" + maksKolonneS+ "this.antallRaderKolonnerIBrett "+ this.antallRaderKolonnerIBrett);
			    for ( s = minRadS; s < maksRadS; s++)
				
				{
					//System.out.println("for (int s = minRadS; s < maksRadS; s++)");
                    //System.out.println(" minRadS "+ minRadS + " maksRadS " +maksRadS+ " s " + s);	
					
		            for (k = minKolonneS; k < maksKolonneS; k++) 
						
		     		{	
					
					    //System.out.println(" for (int k = minKolonneS; k < maksKolonneS; k++) ");
					   //System.out.println("minKolonneS " + minKolonneS);
						//System.out.println(" maksKolonneS "+ maksKolonneS);
						//System.out.println(" k " + k);
				        
						
                        Rute r = this.ruter[s][k];
					
						//System.out.println("Rute r = this.ruter[s][k];");
						//String zy = r.toString();
						//System.out.println("String zy = r.toString();" + zy );
						//System.out.println(" s "+ s + " k "+ k);
						if (this.temp[0][0] != null)
						{
						     for (int h = 0; h < this.antallKolonnerIBoks; h++ )
					            {
						        Rute rkik = this.temp[0][h];
						         //System.out.println("  h " + h);
						        //String hyh = rkik.toString();
						         //System.out.println("String smile = r.toString()"+ hyh);
					            }
						}		
								
				        tid[x] = r;
						//System.out.println("tid[x] = r;");
						//System.out.println("x "+x);
						x = x + 1;
						//System.out.println("x = x + 1;");
						//System.out.println(x);
						if (this.temp[0][0] != null)
						{
						     for (int h = 0; h < this.antallKolonnerIBoks; h++ )
					            {
						        Rute rhyh = this.temp[0][h];
						         //System.out.println("  h " + h);
						        //String hyh = rhyh.toString();
						        // System.out.println("String smile = r.toString()"+ hyh);
					            }
						}		
			        }
					
					for (int b = 0; b < this.antallKolonnerIBoks; b++ )
					{
							Rute r = tid[b];
							//String xyx = r.toString();
							//System.out.println(" Rute r = tid[b];" + xyx + " b " + b);
					}	
					for (int g = 0; g < this.antallKolonnerIBoks; g++)
                    {
						this.temp[y][g] = tid[g];
					}						
			        //this.temp[y ] = tid;
					for (int h = 0; h < this.antallKolonnerIBoks; h++ )
					{
						Rute r = this.temp[y][h];
						//System.out.println("y "+ y + " h " + h);
						//String hyh = r.toString();
						//System.out.println("String hyh = r.toString()"+ hyh);
					}	
						
					//System.out.println("temp[y ] = tid;");
					//System.out.println("y " + y);
					y = y + 1;
					//System.out.println("y = y + 1");
					//System.out.println("y: " + y);
                    x = 0;
                    //System.out.println("x = 0;");
                   // System.out.println("x "+ x);
					
					for (int h = 0; h < this.antallKolonnerIBoks; h++ )
					{
						Rute r = this.temp[0][h];
						//System.out.println("  h " + h);
						//String hyh = r.toString();
						//System.out.println("String smile = r.toString()"+ hyh);
					}	
                    					
				}
                y = 0;	
                //System.out.println("y = 0");
                //System.out.println("y " + y);
                //System.out.println(" Lager Boks");
				for (int h = 0; h < this.antallKolonnerIBoks; h++ )
					{
						Rute r = this.temp[y][h];
						//System.out.println("y "+ y + " h " + h);
						//String hyh = r.toString();
						//System.out.println("String hyh = r.toString()"+ hyh);
					}	
				
				Boks pakken = new Boks(this.temp);
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
			Rute r = this.ruter[0][0];
	       Rad rad = r.hentRad();
	       Rute [] liste = rad.hentRad();
	       for(int u = 0; u < 6; u++)
	        {
		       Rute en = liste[u];
		       String nei = en.toString();
		      System.out.println("??? :) " + nei );
	        } 		
		}
		
		   
		   
	
        Rute r = this.ruter[0][0];
	   Rad rad = r.hentRad();
	   Rute [] liste = rad.hentRad();
	   for(int u = 0; u < 6; u++)
	   {
		   Rute en = liste[u];
		   String nei = en.toString();
		   System.out.println("??? " + nei );
	   } 		

        		
			
			
			
			
			
		
		
	
	
	}
/*	
	public void task()
	{
		for (int i = 0; i < 6; i ++)
		{
			for (int j = 0; j < 6 ; j++)
			{
				Rute r = this.ruter[i][j];
				String s = r.toString();
				System.out.println(s);
			}	
		}
		Rute r = this.ruter[0][0];
		Rute [] rad = r.hentRad();
		for (int i = 0; i < rad.length; i ++)
		{
			if (rad[i] == null)
			{
				System.out.println(" i " + i + " null");
			}
            else
            {
				String s = r.toString();
				System.out.println(" String " + s);
			}				
		}	
	}
	*//*
	
	public void finnAlleMuligTall()
	{
		String [] tall = new String [6];
		tall[0] = "1";
		tall[1] = "2";
		tall[2] = "3";
		tall[3] = "4";
		tall[4] = "5";
		tall[5] = "6";
		Rute rue = this.ruter[0][0];
		
		
		//tall[6] = "7";
		//tall[7] = "8";
		//tall[8] = "9";
		//Rute [] svarene = new Rute [];	
	   String line = ""; 
	   Rute r = this.ruter[0][0];
	   Rad rad = r.hentRad();
	   Rute [] liste = rad.hentRad();
	   for(int u = 0; u < 6; u++)
	   {
		   Rute en = liste[u];
		   String nei = en.toString();
		   System.out.println("? " + nei );
	   } 
	   
	   
	   /*
	   Rute [][] boksen = rue.hentBoks();
	   
	   for (int i = 0; i < 2 ; i++)
	   {
		   for(int j = 0; j < 3; j++)
		   {
			   Rute r = boksen[i][j];
			   String s = r.toString() ;
			   System.out.println(s);
               if (!s.equals("."))
			   {
				    line = line + s;    
			   }				   
		   } 
	   } 
	  // System.out.println(line); 
	   */
	   
	   /*
       Rute [] rad = rue.hentRad();
	   for (int i = 0; i < 6; i++)
	   {
		   Rute r = rad[i];
		   String s = r.toString();
		   if (!s.equals("."))
		   {
			   line = line + s; 
		   }
	   } 
	   System.out.println("line " + line);
/*	   
       Rute [] kolonne = rue.hentKolonne();
	   for (int i = 0; i < kolonne.length; i++)
	   {
		   Rute r = kolonne[i];
		   if (r == null)
		   {
			   System.out.println(" i " + i + " null");
		   }   
	   } 
	   */
	   /*
	   for (int i = 0; i < 6; i++)
	   {
		   
		   Rute r = kolonne[i];
		   
		   String s = r.toString();
		   if (s != ".")
		   {
			   line = line + s; 
		   }
	   }
	   */
	   
	   /*
	   line = line.trim();
       int len = line.length();
	  System.out.println("line "+ line );
	   //String [] ta = new String [len];
	   String numbers = "";
       for (int i = 0; i < line.length(); i++)
       {
		   int a = i+ 1; 
		   System.out.println(" i " + i + " i+1 " + a);
		   String w = line.substring(i, i+1);
		   System.out.println(" w " + w);
		 
		 
			   for (int j = 0; j < tall.length; j++)
			   {
				   String o = tall[j];
				   if(w.equals(o)) 
				   {
					   String jS = Integer.toString(j); 
					   numbers =numbers + j; 
				   }					   
			   }
	   }
	   
	   
	   String yes = "";
	   System.out.println(" numbers " + numbers);
       for (int i = 0; i < numbers.length(); i++)
	   {
		    
		    String g = numbers.substring(i,i+1);
			System.out.println(" g " + g);
			int f = Integer.parseInt(g);
			for (int j = 0; j < tall.length; j++)
			if (j != f)
			{
			    String val = tall[j];  
                yes = yes + val;			
			}	
            
	   }  
       int [] bingo = new int [yes.length()];	   
	   for (int i = 0; i < yes.length(); i++)
	   {
		   String what = yes.substring(i, i+1);
		   int task = Integer.parseInt(what);
		   bingo[i] = task;
	   }   
		   
       
		
		for (int i = 0; i < bingo.length; i++)
		{
			int val = bingo[i];
			System.out.println(val);
		}	
*/		
//	}
	
   
	
		
		

			
		
}
	
	
	
	
	
//[][] Ruter  

    

//hele brettet representeres av et objekt som bl.a. ineholder en todimensjonal
//array av ruter.