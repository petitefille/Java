// Import
import java.io.*;
import java.util.ArrayList;
//import java.awt.GraphicsEnvironment;
//import javax.swing.JFileChooser;


// 	Klasse: Sudoku
// =================================================================================
class Sudoku {
	// Konstanter
	//private static final boolean HAR_VINDUMILJO = !GraphicsEnvironment.getLocalGraphicsEnvironment().isHeadless();

	// Variabler
	private File inFile = null;
	private File outFile = null;

	private Brett brett;

	// Konstruktoer
	

	Sudoku(String inFilename, String outFilename) {
		// Brettfil
		this.inFile = this.finnFil(inFilename);

		if ((this.inFile != null) && (this.inFile.isFile())) {
			// Les brett
			this.brett = this.lesInnBrett();

			if (this.brett != null) {
				// Finn loesninger
				this.brett.finnLosninger();

				// Loesninger
				if (outFilname != null) {
					this.outFile = this.finnFil(outFilname);

					if (this.outFile != null) {
						// Skriv loesninger til fil
						this.lagreLosninger();
					}
					else {
						System.out.println("[X] Ingen gyldig loesningsfil angitt!");
					}
				}
				else {
					// Skriv til skjerm
					this.skrivLosninger();
				}
			}
		}
		else {
			System.out.println("[X] Ingen gyldig brettfil angitt!");
		}
	}

	// Les sudokubrett
	public Brett lesInnBrett() {
		//System.out.println("[*] Leser brettfil: \"" + this.innFil.getName() + "\"");

		int boksRader = 0;
		int boksKolonner = 0;

		try {
			//System.out.println("[*] Leser inn verdier...");

            BufferedReader data = new BufferedReader(new FileReader(this.innFil));
            
            String dataLinje;
            int linjeNr = 0;
            ArrayList<Rute> ruter = new ArrayList<Rute>();

            while ((dataLinje = data.readLine()) != null) {
            	linjeNr++;

                // Antall rader i boks
                if (linjeNr == 1) {
                	try {
                		boksRader = Integer.parseInt(dataLinje);
            		}
            		catch (NumberFormatException e) {
            			System.out.println("[X] Feil under brettinnlesing: Mulig feil format!");
            			return null;
            		}
        		}

                // Antall kolonner i boks
                if (linjeNr == 2) {
                	try {
                		boksKolonner = Integer.parseInt(dataLinje);
            		}
            		catch (NumberFormatException e) {
            			System.out.println("[X] Feil under brettinnlesing: Mulig feil format!");
            			return null;
            		}
        		}

                // Verdier
                if (linjeNr > 2) {
                	for (String v : dataLinje.split("")) {
                		// Variabel rute
						if (v.equals(".")) {
							ruter.add(new VariabelRute());
						}
						// Statisk rute
                		if ((!v.equals(".")) && (!v.equals(""))) {
	                		try {
								ruter.add(new StatiskRute(Integer.parseInt(v)));
							}
							catch (NumberFormatException e) {
								ruter.add(new StatiskRute(("ABCDEFGHIJKLMNOPQRSTUVWXYZ".indexOf(v) + 10)));
							}
						}
                	}
                }
            }
            
            data.close();

            // Brett
            return new Brett(boksRader, boksKolonner, ruter);

        } catch(IOException e) {
            System.out.println("[X] Kunne ikke lese brettfilen!");
        	return null;
        }
	}

	// Skriv loesninger til skjerm
	public void skrivLosninger() {
		// Skriv loesning til skjerm
		//System.out.println("[*] Skriver ut loesninger til skjerm (foerste " + this.brett.hentBeholder().hentMaks() + " vises)...\n");

		int i = 1;

		for (Losning l : this.brett.hentBeholder().hentLosninger())
			System.out.println("\t" + i++ + ": " + l);
	}

	// Lagre loesninger (til fil)
	public void lagreLosninger() {
		System.out.println("[*] Skriver ut loesninger til fil (maks " + this.brett.hentBeholder().hentMaks() + ")...");

		try {
            PrintWriter fil = new PrintWriter(new FileWriter(this.utFil));
            
            int i = 1;

            for (Losning l : this.brett.hentBeholder().hentLosninger())
            	fil.println(i++ + ": " + l);
                
            fil.close();

            System.out.println("[*] " + (i-1) + " loesning(er) skrevet til fil.");
        } catch (IOException e) {
            System.out.println("[X] Kunne ikke skrive til fil!");
        }
	}

	
	
	// Finn fil
	public File finnFil(String filnavn) {
		if ((filnavn != null) || (filnavn == "")) {
			return new File(filnavn);
		}

		return null;
	}
}