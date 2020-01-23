import java.io.File;
import java.io.*;
import java.lang.InterruptedException;

//import java.util.Scanner;
import java.io.BufferedReader;
import java.io.PrintWriter;


//import java.lang.Object;
//import java.util.*;
//import java.lang.reflect.Method;  

class ForsteArbeider extends Arbeider
{
	private File innFil;
	

	
	
	public ForsteArbeider(int heltall, OrdBuffer forrige, String innFilnavn)
	{
		super(heltall, forrige);
		innFil = finnFil(innFilnavn);
	}
	
	public File finnFil(String filnavn) 
	{
		if ((filnavn != null) || (filnavn == "")) 
		{
			return new File(filnavn);
		}

		return null;
	}
	
	public void run() 
	{
	    lesFil();	
	}

	
	
    public void lesFil() 
    {
		BufferedReader tekst = null;
        try {
		    tekst = new BufferedReader(new FileReader(innFil));
			String ord;
		    int linjeNr = 0;
		    while ((ord = tekst.readLine()) != null) {
			    linjeNr++;
			    if (linjeNr == 1) {
			        super.leggTilMinsteOrd(ord);
			    }
			    if (linjeNr > 1) {
		            if (ord.compareTo(super.hentMinsteOrd()) < 0) {
				        super.leggTilMinsteOrd(ord); 
				    }
				    else {
					    super.hentForrigeOrdBuffer().settInnOrdIOrdBuffer(ord);
					}
				}	
			}
		} catch(IOException e) {
            System.out.println("[X] Kunne ikke lese filen!");
        }
        System.out.println("Jeg er arbeider nummer: " + super.hentArbeiderNr() + ".");
		System.out.println("Det minste ordet som ble funnet var: " + super.hentMinsteOrd() + ".");
		super.hentForrigeOrdBuffer().settInnNullPeker();
		try {
		    tekst.close(); 
        } catch (IOException e) {}			
	}				
				
		
	
}
