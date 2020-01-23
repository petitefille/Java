/* 
pensum: 

objektorientert programmering
rekursjon
GUI
lenkelister



Lag en metode
void delInnRuter()
som oppretter riktig antall rader, kolonner og bokser,: oprette riktig antall nye objekter av Rad  i brettet,
oprette riktig antall kolonner som er i brettet 
og opprette riktig antall bokser som er i brettet 

 for saa aa faa  hvert ruteobjekt i brettet til aa peke paa sine respektive rader, kolonner og bokser.

 Hvert rute objekt i ruter arrayen skal da peke paa raden sin, kolonnen sin og boksen sin
 
 For at inndelingen i bokser skal bli riktig maa du ha tatt vare paa de 2 forste verdiene
i fila som sier antall rader i hver boks og antall kolonner i hver boks. (Gjort)



*/


import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.lang.Object;

class Sudoku
{
	
	private int antallRaderIBoks;
	private int antallKolonnerIBoks; 
	private int antallRaderKolonnerIBrett; 
	
	public void lesFil()
	{
	    try
		{
			File inputFile = new File("data.txt");
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
			Rute [][] ruter = new Rute[this.antallRaderKolonnerIBrett][this.antallRaderKolonnerIBrett];
			
			
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
                    ruter[j][i] = r;					
				}	
			}
			Brett brettet = new Brett(ruter);
			
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
	
	public Sudoku()
	{
		
	}
	
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
	
	
	
	
	
    
}   
