package Ch16_Moderate.Q16_04_Tic_Tac_Win;

public class QuestionA {

	private static int convertBoardToInt(Piece[][] board) {
		int sum = 0;
		for (Piece[] aBoard : board) {
			for (Piece anABoard : aBoard) {
				int value = anABoard.ordinal();
				sum = sum * 3 + value;
			}
		}
		return sum;
	}

	public static void main(String[] args) {
		Piece[][] board = {
				{Piece.Empty, Piece.Empty, Piece.Empty},
				{Piece.Empty, Piece.Empty, Piece.Empty},
				{Piece.Blue, Piece.Blue, Piece.Blue}};

		int v = convertBoardToInt(board);
		System.out.println(v);
	}

}
