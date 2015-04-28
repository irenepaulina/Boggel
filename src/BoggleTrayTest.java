// A unit test for class BoggleTray, which is one important part of the final project
//
// 1) Irene Moreno
// 2) Ruby Abrams
//
import static org.junit.Assert.*;
import org.junit.Test;

public class BoggleTrayTest {

  private char[][] tray = {   // Always use upper case letters in the dice tray
      {'A', 'B', 'C', 'D' }, 
      {'E', 'F', 'G', 'H' },
      {'I', 'J', 'K', 'L' }, 
      {'M', 'N', 'O', 'P' } };

  @Test
  public void testStringFindWhenThereStartingInUpperLeftCorner() {
    BoggleTray bt = new BoggleTray(tray);
    assertTrue(bt.foundInBoggleTray("ABC"));  
    assertTrue(bt.foundInBoggleTray("abC"));  // Must be case insensitive
    assertTrue(bt.foundInBoggleTray("aBf"));
    assertTrue(bt.foundInBoggleTray("abc"));
    assertTrue(bt.foundInBoggleTray("ABCD"));
    // ... 
    assertTrue(bt.foundInBoggleTray("ABFEJINM"));
    assertTrue(bt.foundInBoggleTray("AbCdHgFeIjKLpONm"));
    assertTrue(bt.foundInBoggleTray("ABCDHLPOKJNMIEFG"));
  }

  @Test
  public void testStringFindWhenNotThere () {
    BoggleTray bt = new BoggleTray(tray);
    assertFalse(bt.foundInBoggleTray("acb"));
    assertFalse(bt.foundInBoggleTray("AiE"));
    // ... 
  }

  @Test
  public void testStringFindWhenAttemptIsMadeToUseALetterTwice () {
    BoggleTray bt = new BoggleTray(tray);
    assertFalse(bt.foundInBoggleTray("ABA"));
    assertFalse(bt.foundInBoggleTray("ABB"));
    assertFalse(bt.foundInBoggleTray("aEa"));
    // ... 
  }
  
  @Test
  public void testIsNeighbor(){
	  BoggleTray bt = new BoggleTray(tray);
	  assertTrue(bt.isNeighbor(0,0, 1));
  }


  // More tests will be necessary

}
