package Ch16_Moderate.Q16_22_Langtons_Ant;

import java.util.HashSet;

class Board {
	private final HashSet<Position> whites = new HashSet<>();
	private final Ant ant = new Ant();
	private final Position topLeftCorner = new Position(0, 0);
	private final Position bottomRightCorner = new Position(0, 0);

	public Board() {
	}

	/* Move ant. */
	public void move() {
		ant.turn(isWhite(ant.position)); // Turn
		flip(ant.position); // flip
		ant.move(); // move
		ensureFit(ant.position);
	}

	/* Flip color of cells. */
	private void flip(Position position) {
		if (whites.contains(position)) {
			whites.remove(position);
		} else {
			whites.add(position.clone());
		}
	}

	/* "Grow" the grid by tracking the most top-left and 
	 * bottom-right position that we've seen. */
	private void ensureFit(Position position) {
		int row = position.row;
		int column = position.column;

		topLeftCorner.row = Math.min(topLeftCorner.row, row);
		topLeftCorner.column = Math.min(topLeftCorner.column, column);

		bottomRightCorner.row = Math.max(bottomRightCorner.row, row);
		bottomRightCorner.column = Math.max(bottomRightCorner.column, column);
	}

	/* Check if cell is white. */
	private boolean isWhite(Position p) {
		return whites.contains(p);
	}

	/* Check if cell is white. */
	private boolean isWhite(int row, int column) {
		return whites.contains(new Position(row, column));
	}

	/* Print board. */
	public String toString() {
		StringBuilder sb = new StringBuilder();
		int rowMin = topLeftCorner.row;
		int rowMax = bottomRightCorner.row;
		int colMin = topLeftCorner.column;
		int colMax = bottomRightCorner.column;
		for (int r = rowMin; r <= rowMax; r++) {
			for (int c = colMin; c <= colMax; c++) {
				if (r == ant.position.row && c == ant.position.column) {
					sb.append(ant.orientation);
				} else if (isWhite(r, c)) {
					sb.append("X");
				} else {
					sb.append("_");
				}
			}
			sb.append("\n");
		}
		sb.append("Ant: ").append(ant.orientation).append(". \n");
		return sb.toString();
	}
}