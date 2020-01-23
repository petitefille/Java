
import java.io.*;
import java.util.ArrayList;

class Sudoku {
	
	
	private File inFile = null;
	private File outFile = null;
	private Brett brett;

	

	Sudoku(String inFileName, String outFileName) {
		// Filen som skal leses og hvor brettene ligger
		this.inFile = this.testFile(inFileName);
        // sjekker at filen som skal leses inn ikke er null og ikke er ""
		if ((this.inFile != null) && (this.inFile.isFile())) {
			// da leses brettet (metoden finnes i Sudoku.java)
			this.brett = this.lesFil();
              // tester om brettet da er lest inn og eksisterer
			if (this.brett != null) {
				// da finner man loesningene til brettet , denne metoden er i Brett 
				this.brett.finnSvar();

				// tester om det er oppgitt en fil man skal skrive loesningene til 
				if (outFileName != null) {
					// tester da at filen ikke er null og ikke er ""
					this.outFile = this.testFile(outFileName);
                    // hvis dette da stemmer, 
					if (this.outFile != null) {
						// saa skal loesningene skrives til fil 
						this.skrivSvarTilFil();
					}
					else {
						// feilmelding hvis eventuelt filen ikke skulle vaere godkjent 
						System.out.println("Filen loesningene skal skrives til er ikke godkjent!");
					}
				}
				else {
					// ellers skiver man til skjerm 
					this.skrivSvar();
				}
			}
		}
		else {
			// feilmelding da input filen ikke skulle være feil 
			System.out.println("Filen som inneholder brettet er ikke godkjent!");
		}
	}

	// Les sudokubrett
	public Brett lesFil() {
		//System.out.println("[*] Leser brettfil: \"" + this.innFil.getName() + "\"");

		int antallRaderIBoks = 0;
		int antallKolonnerIBoks = 0;

		try {
			//System.out.println("[*] Leser inn verdier...");
            // man leser inn filen
            BufferedReader info = new BufferedReader(new FileReader(this.inFile));
            // linje 
            String infoLinje;
			// linjenummer
            int linjeNum = 0;
			// ArrayListe som skal inneholde verdiene til rutene 
            ArrayList<Rute> ruter = new ArrayList<Rute>();
            // filen skal leses saa lenge det finnes linjer
            while ((infoLinje = info.readLine()) != null) {
				//saa lenge linje ikker null, les inn en til linje
            	linjeNum++;

                // foerste linje som er antall rader i boks
                if (linjeNum == 1) {
                	try {
						// proever da aa sette inn antall rader i boks i variabel antallRaderIBoks
                		antallRaderIBoks = Integer.parseInt(infoLinje);
            		}
            		catch (NumberFormatException e) {
						// hvis ikke String antallRaderIBoks kan konverteres til Int, da skal man printe ut feilmelding
            			System.out.println("Feil under brettinnlesing: Mulig feil format!");
            			return null;
            		}
        		}

                // leser inn linje nr 2, som da er antall kolonner i boks, samme prinsipp som ovenfor 
                if (linjeNum == 2) {
                	try {
                		antallKolonnerIBoks = Integer.parseInt(infoLinje);
            		}
            		catch (NumberFormatException e) {
            			System.out.println("Feil under brettinnlesing: Mulig feil format!");
            			return null;
            		}
        		}

                // saa skal verdiene til ruter leses inn basert på om ruten er har en verdi eller ikke  
                if (linjeNum > 2) {
					// naar linjenummeret er stoerre enn 2
                	for (String o : infoLinje.split("")) {
						// separarer linje i antall karakterer
                		// lager en ny Variabel rute, som er en subklasse av Rute, hvis variabelen er "."
						if (o.equals(".")) {
							// verdien blir 0 
							ruter.add(new TomRute());
						}
						// lager en ny Statisk rute, som er en subklasse av Rute, dersom variabelen har en verdi
                		if ((!o.equals(".")) && (!o.equals(""))) {
	                		try {
								ruter.add(new OpptattRute(Integer.parseInt(o)));
							}
							// variabelen kunne ikke gjoeres om til String saa dette vil si at det er en String (bokstav)
							catch (NumberFormatException e) {
								// v er da en av bokstavene i foelgende alfabet, som man da kan finne indeksen til og addere 10 slik
								// at man faar A:, index 0+ 10 = 10, B: indeks 1 + 10 = 11, og saa videre...
								ruter.add(new OpptattRute(("ABCDEFGHIJKLMNOPQRSTUVWXYZ".indexOf(o) + 10)));
							}
						}
                	}
                }
            }
            //lukker filene 
            info.close();

            // og returnerer et nytt objekt av klassen Brett, med riktig rader, kolonner og bokser, se Brett.java klasse 
            return new Brett(antallRaderIBoks, antallKolonnerIBoks, ruter);

        } catch(IOException e) {
			// hvis ikke input fil kan leses, printe feilmedling 
            System.out.println("Input filen kan ikke leses!");
        	return null;
        }
	}

	// denne metoden skriver loesningene til skjerm
	public void skrivSvar() {
		// her skrives det til skjerm at loesningene skrives ut, men at kun de 2500 foerste vises 
		System.out.println("Skriver ut loesninger til skjerm (kun foerste " + this.brett.hentSudokuBeholder().hentMaks() + " vises)...\n");

		int i = 1;
		// sjekker om det er faa antall loesninger slik at disse kan printes som et brett 
		if (this.brett.hentSudokuBeholder().hentAntallSvar() < 10)
		{
			// henter beholder med loesninger som er en Losning arraylist, med alle loesninger l 
		    for (Svar s : this.brett.hentSudokuBeholder().hentSvar())
				//i:  antall loesning , 
			    System.out.println(i++ + ": "+ "\n" + s.snDtoString());
	            	
		}	
		    
        else
		{
		    for (Svar s : this.brett.hentSudokuBeholder().hentSvar())
			    System.out.println("\t" + i++ + ": " + s);	
		}	
		
	}

	// lagre loesninger (til fil)
	public void skrivSvarTilFil() {
		//System.out.println("[*] Skriver ut loesninger til fil (maks " + this.brett.hentBeholder().hentMaks() + ")...");

		try {
            PrintWriter file = new PrintWriter(new FileWriter(this.outFile));
            			
            int i = 1;
		
		    if (this.brett.hentSudokuBeholder().hentAntallSvar() < 10)
		    {
		        for (Svar s : this.brett.hentSudokuBeholder().hentSvar())
			        file.println(i++ + ": "+ "\n" + s.snDtoString());
	            	
		    }	
		    else
		    {
		        for (Svar s : this.brett.hentSudokuBeholder().hentSvar())
            	    file.println(i++ + ": " + s);
		    }	

             
            file.close();
             // skriver til skjerm  ut hvor mange loesninger som er skrevet ut 
            System.out.println((i-1) + " loesning(er) skrevet til fil.");
        } catch (IOException e) {
			// hvis ikke det ikke gaar ann aa skrive til fil 
            System.out.println("Kunne ikke skrive til fil!");
        }
	}

	
		
	// metode for aa teste at filnavnet ikker er null og filnavnet ikke er ""
	public File testFile(String fileName) {
		if ((fileName != null) || (fileName == "")) {
			return new File(fileName);
		}

		return null;
	}
}
