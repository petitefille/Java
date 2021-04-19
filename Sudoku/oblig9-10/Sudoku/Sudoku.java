import java.io.*;
import java.util.*;

class Sudoku {
	private int ROWS;
	private int COLUMNS;
	private final int MANY;

	private Board board;
	private Box[] boxes;
	private Row[] rows;
	private Column[] columns;
	private SudokuContainer solutionContainer;

	private Scanner sc = new Scanner(System.in);

	public Sudoku() {
		solutionContainer = new SudokuContainer();
		MANY = 5;
	}

	public void start() {
		System.out.println("Starting sudoku solver!");
		Square[][] r = board.getSquareBoard();
		long start = System.currentTimeMillis();
		r[0][0].fillInnThisSquareAndTheRest();
		long timeSpent = System.currentTimeMillis() - start;

    System.out.println("Found " + solutionContainer.fetchNrOfSolutions() + " nr of solutions() in " + tidBrukt + "ms.");
	}

	/**
	 *  create each square with value
	 * then save each square on the board
	 */
	public void readFile(String filename) {

		//Find file
		File file = new File(filename);
		Scanner read = null; // test ?
		try {
			read = new Scanner(file);
		} catch (FileNotFoundException e) {
			System.out.println("Could not find file.");
		}

		//read info
		ROWS = Integer.parseInt( read.nextLine() );
		COLUNMS = Integer.parseInt( read.nextLine() );
		int size = ROWS * COLUMNS;

		//BoardArray
		Square[][] squareBoard = new Square[size][size];

		//Read board
		int countingRow = 0;
		int countingCol = 0;
		try {
			while (les.hasNextLine()) {
				String line = read.nextLine();

				for (int i = 0; i < line.length(); i++) {
					if (line.charAt(i) == '.') {
						//System.out.println(linje.charAt(i));
						emptySquare square = new EmptySquare(0, ROWS*COLUMNS, this);
						squareBoard[countingRow][countingCol] = square;
					} else {
						//System.out.println(linje.charAt(i));
						SolidSquare square = new SolidSquare(Character.getNumericValue(line.charAt(i)), ROWS*COLUMNS, this);
						squareBoard[countingRow][countingCol] = square;
					}
					countingCol++;
				}
				countingCol = 0;
				countingRow++;
			}
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("Invalid file format.");
			System.exit(0);
		}

		//Create Board
		board = new Board(squareBoard);

		//Set next pointers and board in Square
		for (int i = 0; i < squareBoard.length; i++) {

		    Square[] sub = squareBoard[i];
		    for (int j = 0; j < sub.length; j++) {
		    	if (j+1 != sub.length) {

		    		sub[j].setNext(sub[j+1]);

		    	} else if (i+1 != squareBoard.length) {
		    		sub[j].setNext(squareBoard[i+1][0]);
		    	}
		    }
		}

		//Del inn ruter i felt
		distributeSquares();

	}


	public void printToFile(String filnavn) {
		PrintWriter pw = null;
		boolean ferdig = false;

		while (!ferdig) {
			try {
				File fil = new File(filnavn);
				pw = new PrintWriter(fil);
				ferdig = true;
			} catch (Exception e){
				System.out.println("Kunne ikke skrive til valgt fil");
			}
		}

		ArrayList<Losning> losninger = losningBeholder.getLosninger();

		int teller = 0;
		for (Losning losning : losninger) {

			Rute[][] brett = losning.getLosning();

			//Hvis få løsninger
			if (losninger.size() < MANGE) {
				pw.println("Løsning " + (++teller));
				for (int i = 0; i < brett.length; i++) {

				    Rute[] sub = brett[i];
				    for (int j = 0; j < sub.length; j++) {
				    	String verdi = Character.toUpperCase(Character.forDigit(sub[j].getVerdi(), 36)) + "";
			    		pw.print(verdi);
				    }
				    pw.println();
				}
			}
			//Hvis mange løsninger
			else {
				pw.print((++teller) + ": ");
				for (int i = 0; i < brett.length; i++) {

				    Rute[] sub = brett[i];
				    for (int j = 0; j < sub.length; j++) {
				    	String verdi = Character.toUpperCase(Character.forDigit(sub[j].getVerdi(), 36)) + "";
			    		pw.print(verdi);
				    }
				    pw.print("//");
				}
				pw.println();
			}

		}

		pw.close();
	}

	public void printToScreen() {
		ArrayList<Losning> losninger = losningBeholder.getLosninger();

		for (Losning losning : losninger) {
			losning.skrivUt();
		}

	}

	public void saveBoard(Square[][] board) {
		Losning losning = new Losning(brett);

		losningBeholder.settInn(losning);
	}

	/**
	 * Skriv ut spillbrettet fra to-dim-array
	 */
	public void printBoard() {
		Rute[][] ruteBrett = brett.getRuteBrett();

		for (int i = 0; i < ruteBrett.length; i++) {

		    Rute[] sub = ruteBrett[i];
		    for (int j = 0; j < sub.length; j++) {
		    	String verdi = Character.toUpperCase(Character.forDigit(sub[j].getVerdi(), 36)) + "";
				System.out.print(verdi + " ");
		    }
		    System.out.println();
		}
	}

	/**
	 * Skriv ut spillbrettet fra to-dim-array
	 */
	public void skrivUtBrett(Rute[][] ruteBrett) {
		for (int i = 0; i < ruteBrett.length; i++) {

		    Rute[] sub = ruteBrett[i];
		    for (int j = 0; j < sub.length; j++) {
		    	String verdi = Character.toUpperCase(Character.forDigit(sub[j].getVerdi(), 36)) + "";
				System.out.print(verdi + " ");
		    }
		    System.out.println();
		}
	}

	//Brukt for debugging
	public void skrivUtDetaljert() {
		Rute[][] ruteBrett = brett.getRuteBrett();

		System.out.println("\nNeste pekre i Rute:");
		ruteBrett[0][0].skrivUtDenneOgNeste();

		System.out.print("\n \n");
		System.out.println("R: Rad. K: Kolonne. B: Boks. M: Mulige. V: Verdi");

		for (int i = 0; i < ruteBrett.length; i++) {

		    Rute[] sub = ruteBrett[i];
		    for (int j = 0; j < sub.length; j++) {
		    	Rute r = sub[j];
				System.out.print("R:" + r.getRad() + "K:" + r.getKolonne() + "B:" + r.getBoks() + "M:" + r.finnAlleMuligeTall().toString() + "V:" + Character.toUpperCase(Character.forDigit(sub[j].getVerdi(), 36)) + "  ");
		    }
		    System.out.println();
		}
	}

	//Kalles på etter lesFil
	public void distributeSquares() {
		boxes = new Box[ROWS*COLUMNS];
		rows = new Row[ROWS*COLUMNS];
		columns = new Column[ROWS*COLUMNS];

		Square[][] squareBoard = board.getSquareBoard();

		//Rader
		for (int i = 0; i < squareBoard.length; i++) {
			Row row = new Row(i+1, board);
			rows[i] = row;

		    Square[] sub = squareBoard[i];
		    for (int j = 0; j < sub.length; j++) {
		    	Square square = sub[j];
				  square.setRow(row);
				  row.setSquare(square);
		    }
		}

		//Columns
		for (int i = 0; i < columns.length; i++) {
			Column c = new Column(i+1, board);
			columns[i] = c;
		}

		for (int i = 0; i < squareBoard.length; i++) {

		    Square[] sub = squareBoard[i];
		    for (int j = 0; j < sub.length; j++) {
		    	Square square = sub[j];
		    	Column column = columns[j];
		    	square.setColumn(column);
		    	column.setSquare(square);
		    }
		}

		//Boxes
		for (int i = 0; i < boxes.length; i++) {
			Boxs b = new Boxs(i+1, board);
			boxes[i] = b;
		}

		int colCounter= 0;
		int rowCounter= 0;
		int boxCounter= 0;
		int counter = 0;

		for (int i = 0; i < squareBoard.length; i++) {
			if (counter == ROWS) {
	    		counter=0;
	    		rowCounter = rowCounter + ROWS;
	    	}

		    Square[] sub = squareBoard[i];
		    for (int j = 0; j < sub.length; j++) {

		    	if (colCounter == COLUMNS) {
		    		boxCounter++;
		    		colCounter = 0;
		    	}
		    	Square dquare = sub[j];
		    	Box box = boxes[(boxCounter + rowCounter)];
		    	square.setBox(box);
		    	box.setSquare(square);
		    	colCounter++;
		    }
		    boxCounter = 0;
		    colCounter = 0;
		    counter++;
		}

	}
}
