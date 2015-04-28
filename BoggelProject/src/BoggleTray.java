import java.util.Stack;

public class BoggleTray {
	private char[][] tray;
	private Stack<Character> stack;
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

		stack = new Stack<Character>();
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
			while (j < 4) {
				helper(i, j, input, temp);
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

	private boolean helper(int i, int j, String ref, char[][] temp) {

		if (temp[i][j] == ref.charAt(0)) {
			temp[i][j] = ' ';
			if (isNeighbor(ref.substring(1))) 
				// have neighbor return i and j
				helper(i, j, ref.substring(1), temp);
			else
				foundInBoggleTray(input);
		}
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
