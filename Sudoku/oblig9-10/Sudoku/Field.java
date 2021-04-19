import java.util.*;

public class Field {
	private int id;
	private ArrayList<Square> squares = new ArrayList<>();
	private Board board;

	public Field(int id, Board board) {
		this.id = id;
		this.board = board;
	}

	public String toString() {
		return id + "";
	}

	public void setSquare(Square s) {
		squares.add(s);
	}

	public void settBrett(Brett b) {
		this.brett = b;
	}

	public Brett getBrett() {
		return brett;
	}

	//true hvis feltet inneholder verdien allerede
	public boolean inneholder(int verdi) {
		boolean finnes = false;
		for (Rute rute : ruter) {
			int ruteVerdi = rute.getVerdi();
			if (verdi == ruteVerdi && verdi != 0) {
				finnes = true;
			}
		}
		return finnes;
	}

}

class Column extends Field {
	public Column(int id, Board board) {
		super(id, board);
	}
}

class Row extends Field{
	public Row(int id, Board board) {
		super(id, board);
	}

}

class Box extends Field{
	public Box(int id, Brett board) {
		super(id, board);
	}
}
