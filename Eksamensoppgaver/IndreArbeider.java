import java.io.*;
import java.lang.InterruptedException;

class IndreArbeider extends Arbeider
{
	private OrdBuffer neste; 
	
	
	public IndreArbeider(int heltall, OrdBuffer forrige, OrdBuffer neste)
	{
		super(heltall, forrige);
		this.neste = neste; 
	}
	
	public void run() 
	{
		String ord = null;
        ord = super.hentForrigeOrdBuffer().hentOrdFraForrigeOrdBuffer();	
		super.leggTilMinsteOrd(ord);
		ord = super.hentForrigeOrdBuffer().hentOrdFraForrigeOrdBuffer();
        
		while (ord != null) {    
	        if (ord.compareTo(super.hentMinsteOrd()) < 0) {
				   super.leggTilMinsteOrd(ord); 
			}
			else {
				neste.settInnOrdIOrdBuffer(ord);	
			}
		    ord = super.hentForrigeOrdBuffer().hentOrdFraForrigeOrdBuffer();
		}				
		System.out.println("Jeg er arbeider nummer: " + super.hentArbeiderNr() + ".");
		System.out.println("Det minste ordet som ble funnet var: " + super.hentMinsteOrd() + ".");
		neste.settInnNullPeker();	
	}

}
