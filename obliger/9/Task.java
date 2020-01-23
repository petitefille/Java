

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.lang.Object;

class Task 
{
	
	public Rute [][] brett;
	public Task()
	{
		
	}
	public void settBrett(Rute [][] r)
	{
		brett = r;
	}
	
	public void skrivUtRuteneIBrettet()
	{
	    for (int j = 0; j <6 ; j++)	
        {
			String word = ""; 
			for (int i = 0; i < 6; i++)
	    	{
				Rute r  = brett[j][i];
				String s = r.toString();
				word = word + s;
			}
			System.out.println(word);
		}				
	}
	
    public static void main (String[] args) 
    {	
	
	    Brett brettet = new Brett();
	    brettet.lesFil();
		brettet.skrivUtRuteneIBrettet();
		brettet.delInnIRuter();
		brettet.task();
		brettet.task2();
		Rute [][] ruter = brettet.hentBrett();
		
		Task oppg = new Task();
		
		oppg.settBrett(ruter);
		for (int i = 0; i < 6; i++)
		{
			for (int j = 0; j < 6; j++)
			{
				
				oppg.brett[i][j].settTask(oppg);
			}	
		}	
        		
		
		oppg.brett[0][0].fyllInnDenneOgNeste();
		//skrive ut dette brettet 
		//brettet.skrivUtRuteneIBrettet();
		
		
		//brettet.skrivUtRuteneIBrettet();
		}
}