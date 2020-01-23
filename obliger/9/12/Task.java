class Task {
	
	public static void main(String[] args) {
		
		

		
		String inputFilename = null;
		String outputFilename = null;
        if (args.length > 0)
		{
			inputFilename = args[0];
		}	
		if (args.length > 1)
        {
		    outputFilename = args[1];	
		}			

		Sudoku spill = new Sudoku(inputFilename, outputFilename);
		
	}
}