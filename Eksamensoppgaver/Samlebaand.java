import java.lang.NumberFormatException;


public class Samlebaand
{
    

    public static void main(String[ ] args) throws NumberFormatException
	{
		String utfilNavn = null;
		String innfilNavn = null;
		int antallTraader = 0;
		if (args.length > 2)
		{
			try {
			    			
				antallTraader = Integer.parseInt(args[0]);
				innfilNavn = args[1];	
				utfilNavn = args[2];
				
		    } catch (NumberFormatException e) {
                System.err.println("Argumentet" + args[0] + " maa vaere antall traader(altsaa en int),\n argumentet" + args[1] + " maa vaere navnet paa input filen (altsaa en String),\n og argumentet" + args[2]+ " maa vaere navnet paa output filen (altsaa en String)." );
                System.exit(1);
		    }
        } else {
			System.out.println("Man maa oppgi antall traader, navnet paa input filen og navnet paa output filen i kommando linjen!");
		}	
        OrdBuffer forrige = new OrdBuffer();
        OrdBuffer neste = new OrdBuffer();			
		ForsteArbeider forstearbeider = new ForsteArbeider(1, forrige, innfilNavn);
		forstearbeider.start();
       
		if (antallTraader == 2) {
			    SisteArbeider sisteArbeider = new SisteArbeider(antallTraader, forrige, utfilNavn);
                sisteArbeider.start();				
		}	
		else {
            for (int i = 2; i < antallTraader; i++) {
                new IndreArbeider(i, forrige, neste).start();
				forrige = neste;
				neste = new OrdBuffer();
            }
			 SisteArbeider sisteArbeider = new SisteArbeider(antallTraader, forrige, utfilNavn);
			 sisteArbeider.start();
		}		
    }
}