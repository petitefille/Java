import java.util.*;


public class SudokuContainer {
	private int nrOfSolutions;
	private final int MAXI;
	private ArrayList<Solution> solutions;


	public SudokuBeholder() {
		this.nrOfSolutions = 0;
		MAXI = 2500;
		solutions =  new ArrayList<>(MAXI);
	}


 //***************************************************************************
	//Hvis flere enn 2500 løsninger skal kun teller gå opp
	public void settInn(Losning brett) {
		antallLosninger++;

		if (losninger.size() < 2500) {
			losninger.add(brett);
		}

	}

	public Losning taUt(int plass) {
		if (plass < losninger.size()) {
			return losninger.get(plass);
		}

		return null;
	}

	public int hentAntallLosninger() {
		return antallLosninger;
	}

	public ArrayList<Losning> getLosninger() {
		return losninger;
	}
}
