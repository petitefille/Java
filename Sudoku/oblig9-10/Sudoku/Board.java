public class Board {

	private Square[][] baord;

	public Board(Square[][] board) {
		this.board = board;
	}

	public Square[][] getSquareBoard() {
		return board;
	}

	public void angreVerdier(Rute r) {
		if (r != null) {
			if (r instanceof TomRute) {
				r.settVerdi(0);
			}

			this.angreVerdier(r.neste);
		}
	}

}
