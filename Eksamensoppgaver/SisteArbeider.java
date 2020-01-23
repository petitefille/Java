import java.io.PrintWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.*;
import java.io.IOException;


class SisteArbeider extends Arbeider
{
	private File utFil;
	private String minsteOrd; 
	
	
	public SisteArbeider(int heltall, OrdBuffer forrige, String utFilnavn)
	{
	    super(heltall, forrige);
        utFil = finnFil(utFilnavn);		
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
		try { 
		    PrintWriter fil = new PrintWriter(new FileWriter(this.utFil));
		    String ord = null;
			ord = super.hentForrigeOrdBuffer().hentOrdFraForrigeOrdBuffer();
    	    super.leggTilMinsteOrd(ord);
            ord = super.hentForrigeOrdBuffer().hentOrdFraForrigeOrdBuffer();
             while (ord != null)    {    
	            if (ord.compareTo(super.hentMinsteOrd()) < 0) {
				       super.leggTilMinsteOrd(ord); 
			    } else {
			        fil.println(ord);    
			    }
                ord = super.hentForrigeOrdBuffer().hentOrdFraForrigeOrdBuffer(); 		
			}
		    fil.close();	
        } catch(IOException e) {
		    System.out.println("[X] Kunne ikke skrive til fil!");	
		}
		System.out.println("Jeg er arbeider nummer: " + super.hentArbeiderNr() + ".");
		System.out.println("Det minste ordet som ble funnet var: " + super.hentMinsteOrd() + ".");
				
	}
	
	
}
