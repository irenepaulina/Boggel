import java.util.Stack;

public class BoggleTray {
	private char[][] tray;
	// private Stack<Character> stack; //not needed anymore
	private String input;

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
		input = str;
		int i = 0;
		int j = 0;
		while (i < 4) {
			while (j < 4) { // iterate through the [][]array
				find(i, j, input, temp); // will return true or false
				j++;
			}
			i++;
		}
		if (i == 4 && j == 4)
			return false;

		if (str.length() == 0)
			return true;
		return isNeighbor(i, j, 1);
	}

	// this method will tell us if the entire string (ref) is
	// found in the [][] array
	private boolean find(int i, int j, String ref, char[][] board) {
		char temp = board[i][j];
		if (ref.charAt(0) == temp) { // the position of the first
											// character
			if (isNeighbor(temp, ref.charAt(1), board)) { // check to see if the second character
															// is a neighbor
				board[i][j] = ' '; // change to blank space
				// a method to return the (i,j) coordinates
				// of the neighbor
				i = row(ref.substring(1), board);
				j = col(ref.substring(1), board);
				find(i, j, ref.substring(1), board); // recursion call for next
													// letter in string

				// we must somehow record each letter that is matched to the
				// input string
				// or have a base case that will return true when all letters
				// match the input string
				
				// is it enough to write here:
				// return true?
			} 
			else {
				board[i][j] = ' '; // change to blank space
				// the next letter is not a neighbour: search for the next
				// occurence of the first letter
				foundInBoggleTray(input);
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

	// given the position of letter in tray and index of next letter in word
	// this will return true if index of next letter in word is a neighbour of
	// the given position in tray
	// NOTE: changing to public so it can be tested
	public boolean isNeighbor(int i, int j, int indexOfNext) {
		if (i > 0 && j > 0 && tray[i - 1][j - 1] == input.charAt(indexOfNext))
			return true;
		if (j > 0 && tray[i][j - 1] == input.charAt(indexOfNext))
			return true;
		if (i < tray.length - 1 && j > 0
				&& tray[i + 1][j - 1] == input.charAt(indexOfNext))
			return true;
		if (i > 0 && tray[i - 1][j] == input.charAt(indexOfNext))
			return true;
		if (i < tray.length - 1 && tray[i + 1][j] == input.charAt(indexOfNext))
			return true;
		if (i > 0 && j < tray[0].length - 1
				&& tray[i - 1][j + 1] == input.charAt(indexOfNext))
			return true;
		if (j < tray[0].length - 1
				&& tray[i][j + 1] == input.charAt(indexOfNext))
			return true;
		if (i < tray.length - 1 && j < tray[0].length - 1
				&& tray[i + 1][j + 1] == input.charAt(indexOfNext))
			return true;
		else
			return false;

	}

	//will return true if first and next are neighbors on board
	//TESTED: this works too
	public boolean isNeighbor(char first, char next, char [][]board){
		for (int row = 0; row < board.length; row++) {
			for (int col = 0; col < board[0].length; col++) {

				for (int i = row -1; i < row+2 && i< board.length; i++) {
					for (int j = col-1; j < col+2 && j < board[0].length; j++) {
						
						if(i>=0 && j>=0){
							if (board[i][j]==next && board[row][col] == first){
								return true;
							}
								
						}
					}

				}
			}
		}
		return false;
	}
	
	
	// not necessary for the time being
	// private boolean foundInBoggle(String str, int i, int j, int index) {
	//
	// }
}
