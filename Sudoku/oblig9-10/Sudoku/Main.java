public class Main {
	public static void main(String[] args) {
		Sudoku sudoku = new Sudoku();

		if (args.length == 1) {
			System.out.println("Reading board from " + args[0]);
			sudoku.readFile(args[0]);
			sudoku.start();
			sudoku.printToScreen();
		} else if (args.length == 2) {
			System.out.println("Reading board from " + args[0] + " and saving to " + args[1]);
			sudoku.readFile(args[0]);
			sudoku.start();
			sudoku.printToScreen(args[1]);
		} else {
			System.out.println("Starting GUI");
		}
	}
}
