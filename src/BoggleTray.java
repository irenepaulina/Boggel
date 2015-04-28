import java.util.Stack;

public class BoggleTray {
	private char[][] tray;
	//private Stack<Character> stack; //not needed anymore
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

		//stack = new Stack<Character>(); //not needed anymore
	}

	// Return true if str is found in the Boggle BoggleTray according to Boggle
	// rules.
	// Note: This method does NOT check to see if the word is in the list of
	// words.
	public boolean foundInBoggleTray(String str) {
		if (str.length() == 0)// will edit
			return (Boolean) null;
		char[][] temp = tray;
		input = str;
		int i = 0;
		int j = 0;
		while (i < 4) {
			while (j < 4) { //iterate through the [][]array
				helper(i, j, input, temp); //will return true or false
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

	//this method will tell us if the entire string (ref) is
	//found in the [][] array
	private boolean helper(int i, int j, String ref, char[][] temp) {

		if (temp[i][j] == ref.charAt(0)) { //the position of the first character
			temp[i][j] = ' '; //change to blank space
			if (isNeighbor(ref.substring(1))) //check to see if the second character is a neighbor
				// a method to return the (i,j) coordinates
				// of the neighbor
				// int i = row(ref.substring(1));
				// int j = col(ref.substring(1));
				helper(i, j, ref.substring(1), temp); //recursion call for next letter in string
				//we must somehow record each letter that is matched to the input string
				//or hava base case that will return true when all letters match
				//the input string
				//is it enough to write here:
				//return true?
			else //the next letter is not a neighbour: search for next
				//occurence of the first letter
				foundInBoggleTray(input);
		}//else position of first character is not found:
		//return false;
	}

	private boolean isNeighbor(int i, int j, int index) {
		if (i > 0 && j > 0 && tray[i - 1][j - 1] == input.charAt(index))
			return true;
		if (j > 0 && tray[i][j - 1] == input.charAt(index))
			return true;
		if (i < tray.length - 1 && j > 0
				&& tray[i + 1][j - 1] == input.charAt(index))
			return true;
		if (i > 0 && tray[i - 1][j] == input.charAt(index))
			return true;
		if (i < tray.length - 1 && tray[i + 1][j] == input.charAt(index))
			return true;
		if (i > 0 && j < tray[0].length - 1
				&& tray[i - 1][j + 1] == input.charAt(index))
			return true;
		if (j < tray[0].length - 1 && tray[i][j + 1] == input.charAt(index))
			return true;
		if (i < tray.length - 1 && j < tray[0].length - 1
				&& tray[i + 1][j + 1] == input.charAt(index))
			return true;
		else
			return false;

	}

	private boolean foundInBoggle(String str, int i, int j, int index) {

	}
}
