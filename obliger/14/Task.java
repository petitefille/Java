class Task {
	
	public static void main(String[] args) {
		
		// leser inn innfilnavn og utfilnavn fra kommandolinja 
			String inFileName = null;
			String outFileName  = null;
            // innfilnavn skal uansett leses inn hvis lengde > 0 
			if (args.length > 0)
				inFileName = args[0];
            // hvis lengde er stoerre enn 1 skal utputfilnavn leses inn 
			if (args.length > 1)
				outFileName = args[1];

			// oppretter nytt objekt av klasse Sudoku med filnavn inn og filnavn ut
			Sudoku los = new Sudoku(inFileName, outFileName);
		

		
	}
}
