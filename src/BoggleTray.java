
// by Irene Moreno and Ruby Abrams
public class BoggleTray {
	private char[][] tray;

	// Constructor takes a 2D array of characters that represents the
	// Boggle BoggleTray with 16 dice already rolled in a known fixed state.
	public BoggleTray(char[][] array) {
		tray = new char[4][4];
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array[0].length; j++) {
				tray[i][j] = array[i][j];
			}
		}

		// stack = new Stack<Character>(); //not needed anymore
	}

	// Return true if str is found in the Boggle BoggleTray according to Boggle
	// rules.
	// Note: This method does NOT check to see if the word is in the list of
	// words.
	public boolean foundInBoggleTray(String str) {
		char[][] temp = tray;
		str.toUpperCase();
		int i = 0;
		int j = 0;
		if (str.length() == 0)
			return false;
		while (i < 4) {
			while (j < 4) { // iterate through the [][]array
				if (temp[i][j] == str.charAt(0))
					if (find(i, j, str, temp))
						return true;
				j++;
			}
			i++;
		}
		return false;
	}

	// this method will tell us if the entire string (ref) is
	// found in the [][] array
	public boolean find(int i, int j, String ref, char[][] board) {
		if (ref.length() == 0)
			return true;
		char temp = board[i][j];
		if (ref.length() == 1) {
			return true;
		}
		if (ref.charAt(0) == temp) { // the position of the first
		// character
			if (isNeighbor(temp, ref.charAt(1), board)) { // check to see if the
			// second character
			// is a neighbor
				board[i][j] = ' '; // change to blank space
				i = row(ref.substring(1), board);
				j = col(ref.substring(1), board);
				return find(i, j, ref.substring(1), board);
			}
		}// else position of first character is not found:
		return false;
	}

	private int col(String l, char[][] temp) { // returning col position of l
		char letter = l.charAt(0);
		for (int i = 0; i < temp.length; i++)
			for (int j = 0; j < temp[0].length; j++) {
				if (temp[i][j] == letter) {
					return j;
				}
			}
		return -1; // should not return this.. we know it already exists
	}

	private int row(String l, char[][] temp) { // return row position of l
		char letter = l.charAt(0);
		for (int i = 0; i < temp.length; i++)
			for (int j = 0; j < temp[0].length; j++) {
				if (temp[i][j] == letter) {
					return i;
				}
			}
		return -1; // should not return this.. we know it already exists
	}

	// will return true if first and next are neighbors on board
	// TESTED: this works too
	public boolean isNeighbor(char first, char next, char[][] board) {
		for (int row = 0; row < board.length; row++) {
			for (int col = 0; col < board[0].length; col++) {
				for (int i = row - 1; i < row + 2 && i < board.length; i++) {
					for (int j = col - 1; j < col + 2 && j < board[0].length; j++) {
						if (i >= 0 && j >= 0) {
							if (board[i][j] == next && board[row][col] == first) {
								return true;
							}

						}
					}

				}
			}
		}
		return false;
	}

}
