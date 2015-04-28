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
	  assertTrue(bt.isNeighbor('A', 'F', tray));
	  assertTrue(bt.isNeighbor('B', 'F', tray));
	  assertTrue(bt.isNeighbor('C', 'F', tray));
	  
	  assertTrue(bt.isNeighbor('E', 'F', tray));
	  assertTrue(bt.isNeighbor('G', 'F', tray));
	  
	  assertTrue(bt.isNeighbor('I', 'F', tray));
	  assertTrue(bt.isNeighbor('J', 'F', tray));
	  assertTrue(bt.isNeighbor('K', 'F', tray));
  }
  
  @Test
  public void testIsNeighborWhenCornerPiece(){
	  BoggleTray bt = new BoggleTray(tray);
	  assertTrue(bt.isNeighbor('A', 'B', tray));
	  assertTrue(bt.isNeighbor('A', 'E', tray));
	  assertTrue(bt.isNeighbor('A', 'F', tray));
  }
  
  @Test
  public void testIsNeighborWhenFalse(){
	  BoggleTray bt = new BoggleTray(tray);
	  assertFalse(bt.isNeighbor('A', 'C', tray));
  }

  @Test
  public void testFind(){
	  BoggleTray bt = new BoggleTray(tray);
	  assertTrue(bt.find(0,0,"A", tray));
  }

  // More tests will be necessary

}
