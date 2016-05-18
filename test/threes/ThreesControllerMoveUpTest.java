package threes;

import org.junit.Test;
import static org.junit.Assert.assertTrue;

/**
 * This class is a test suite with for the method move_up at the class ThreesController.
 * The test cases was generated using the input space partitioning technique.
 * @author Facundo Molina
 */
public class ThreesControllerMoveUpTest {
	
	/**
	 * Test base choice (>1,=,a):
	 * >1: More than one column is combinable
	 * = : Only exist combination by equal tiles
	 * a : Exist non-combination by non-combinable tiles and empty space 
	 */
	@Test
	public void testBaseChoice() {
		// Input board:
		// [ 3 , 1 , 6 , 1]
		// [ 3 , 1 , 6 , 2]
		// [ 0 , 1 , 0 , 0]
		// [ 0 , 0 , 0 , 2]
		ThreesBoard board = new ThreesBoard();
		board.set_tile(0, 0, 3);
		board.set_tile(1, 0, 3);
		board.set_tile(0, 1, 1);
		board.set_tile(1, 1, 1);
		board.set_tile(2, 1, 1);
		board.set_tile(0, 2, 6);
		board.set_tile(1, 2, 6);
		board.set_tile(0, 3, 1);
		board.set_tile(1, 3, 2);
		board.set_tile(3, 3, 2);
		ThreesController threesController = new ThreesController(board);
		threesController.move_up();
		// Expected board:
		// [ 6 , 1 , 12, 1]
		// [ 0 , 1 , 0 , 2]
		// [ 0 , 1 , 0 , 2]
		// [ 0 , 0 , 0 , 0]
		// Column 0
		assertTrue(threesController.getBoard().get_tile(0, 0).getValue()==6);
		assertTrue(threesController.getBoard().get_tile(1, 0).isFree());
		// Column 1
		assertTrue(threesController.getBoard().get_tile(0, 1).getValue()==1);
		assertTrue(threesController.getBoard().get_tile(1, 1).getValue()==1);
		assertTrue(threesController.getBoard().get_tile(2, 1).getValue()==1);
		// Column 2
		assertTrue(threesController.getBoard().get_tile(0, 2).getValue()==12);
		assertTrue(threesController.getBoard().get_tile(1, 2).isFree());
		// Column3
		assertTrue(threesController.getBoard().get_tile(0, 3).getValue()==1);
		assertTrue(threesController.getBoard().get_tile(1, 3).getValue()==2);
		assertTrue(threesController.getBoard().get_tile(2, 3).getValue()==2);
	}
	
	/**
	 * Test block1 (0,=,a):
	 * 0: Just the column 0 is combinable
	 * =: Only exist combination by equal tiles
	 * a: Exist non-combination by non-combinable tiles and empty space 
	 */
	@Test
	public void testBlock1() {
		// Input board:
		// [ 3 , 0 , 1 , 3]
		// [ 3 , 0 , 2 , 6]
		// [ 0 , 0 , 0 , 0]
		// [ 0 , 0 , 2 , 0]
		ThreesBoard board = new ThreesBoard();
		board.set_tile(0, 0, 3);
		board.set_tile(1, 0, 3);
		board.set_tile(0, 2, 1);
		board.set_tile(1, 2, 2);
		board.set_tile(3, 2, 2);
		board.set_tile(0, 3, 3);
		board.set_tile(1, 3, 6);
		ThreesController threesController = new ThreesController(board);
		threesController.move_up();
		// Expected board:
		// [ 6 , 0 , 1 , 3]
		// [ 0 , 0 , 2 , 6]
		// [ 0 , 0 , 2 , 0]
		// [ 0 , 0 , 0 , 0]
		// Column 0
		assertTrue(threesController.getBoard().get_tile(0, 0).getValue()==6);
		assertTrue(threesController.getBoard().get_tile(1, 0).isFree());
		// Column 2
		assertTrue(threesController.getBoard().get_tile(0, 2).getValue()==1);
		assertTrue(threesController.getBoard().get_tile(1, 2).getValue()==2);
		assertTrue(threesController.getBoard().get_tile(2, 2).getValue()==2);
		// Column 3
		assertTrue(threesController.getBoard().get_tile(0, 3).getValue()==3);
		assertTrue(threesController.getBoard().get_tile(1, 3).getValue()==6);
	}
	
	/**
	 * Test block2 (mid,=,a):
	 * mid: Just a column between 0 and 3 is combinable
	 * =: Only exist combination by equal tiles
	 * a: Exist non-combination by non-combinable tiles and empty space
	 */
	@Test
	public void testBlock2() {
		// Input board:
		// [ 3 , 6 , 0 , 1]
		// [ 1 , 6 , 0 , 2]
		// [ 0 , 0 , 0 , 0]
		// [ 0 , 0 , 0 , 3]
		ThreesBoard board = new ThreesBoard();
		board.set_tile(0, 0, 3);
		board.set_tile(1, 0, 1);
		board.set_tile(0, 1, 6);
		board.set_tile(1, 1, 6);
		board.set_tile(0, 3, 1);
		board.set_tile(1, 3, 2);
		board.set_tile(3, 3, 3);
		ThreesController threesController = new ThreesController(board);
		threesController.move_up();
		// Expected board:
		// [ 3 , 12, 0 , 1]
		// [ 1 , 0 , 0 , 2]
		// [ 0 , 0 , 0 , 3]
		// [ 0 , 0 , 0 , 0]
		// Column 0
		assertTrue(threesController.getBoard().get_tile(0, 0).getValue()==3);
		assertTrue(threesController.getBoard().get_tile(1, 0).getValue()==1);
		// Column 1
		assertTrue(threesController.getBoard().get_tile(0, 1).getValue()==12);
		assertTrue(threesController.getBoard().get_tile(1, 1).isFree());
		// Column 3
		assertTrue(threesController.getBoard().get_tile(0, 3).getValue()==1);
		assertTrue(threesController.getBoard().get_tile(1, 3).getValue()==2);
		assertTrue(threesController.getBoard().get_tile(2, 3).getValue()==3);
	}
	
	/**
	 * Test block3 (3,=,a):
	 * 3: Just the column 3 is combinable
	 * =: Only exist combination by equal tiles
	 * a: Exist non-combination by non-combinable tiles and empty space
	 */
	@Test
	public void testBlock3() {
		// Input board:
		// [ 6 , 1 , 0 , 12]
		// [ 3 , 2 , 0 , 12]
		// [ 0 , 0 , 0 , 0]
		// [ 0 , 1 , 0 , 0]		
		ThreesBoard board = new ThreesBoard();
		board.set_tile(0, 0, 6);
		board.set_tile(1, 0, 3);
		board.set_tile(0, 1, 1);
		board.set_tile(1, 1, 2);
		board.set_tile(3, 1, 1);
		board.set_tile(0, 3, 12);
		board.set_tile(1, 3, 12);
		ThreesController threesController = new ThreesController(board);
		threesController.move_up();
		// Expected board:
		// [ 6 , 1 , 0 ,24]
		// [ 3 , 2 , 0 , 0]
		// [ 0 , 1 , 0 , 0]
		// [ 0 , 0 , 0 , 0]		
		// Column 0
		assertTrue(threesController.getBoard().get_tile(0, 0).getValue()==6);
		assertTrue(threesController.getBoard().get_tile(1, 0).getValue()==3);
		// Column 1
		assertTrue(threesController.getBoard().get_tile(0, 1).getValue()==1);
		assertTrue(threesController.getBoard().get_tile(1, 1).getValue()==2);
		assertTrue(threesController.getBoard().get_tile(2, 1).getValue()==1);
		// Column 3
		assertTrue(threesController.getBoard().get_tile(0, 3).getValue()==24);
		assertTrue(threesController.getBoard().get_tile(1, 3).isFree());
	}
	
	/**
	 * Test block5 (>1,!=,a):
	 * >1: More than one column is combinable
	 * !=: Only exist combination by non-equal tiles
	 * a : Exist non-combination by non-combinable tiles and empty space
	 */
	@Test
	public void testBlock5() {
		// Input board:
		// [ 1 , 1 , 1 , 3]
		// [ 2 , 2 , 2 , 1]
		// [ 0 , 0 , 2 , 0]
		// [ 1 , 0 , 0 , 0]
		ThreesBoard board = new ThreesBoard();
		board.set_tile(0, 0, 1);
		board.set_tile(1, 0, 2);
		board.set_tile(3, 0, 1);
		board.set_tile(0, 1, 1);
		board.set_tile(1, 1, 2);
		board.set_tile(0, 2, 1);
		board.set_tile(1, 2, 2);
		board.set_tile(2, 2, 2);
		board.set_tile(0, 3, 3);
		board.set_tile(1, 3, 1);
		ThreesController threesController = new ThreesController(board);
		threesController.move_up();
		// Expected board:
		// [ 1 , 3 , 3 , 3]
		// [ 2 , 0 , 2 , 1]
		// [ 1 , 0 , 0 , 0]
		// [ 0 , 0 , 0 , 0]
		// Column 0
		assertTrue(threesController.getBoard().get_tile(0, 0).getValue()==1);
		assertTrue(threesController.getBoard().get_tile(1, 0).getValue()==2);
		assertTrue(threesController.getBoard().get_tile(2, 0).getValue()==1);
		// Column 1
		assertTrue(threesController.getBoard().get_tile(0, 1).getValue()==3);
		assertTrue(threesController.getBoard().get_tile(1, 1).isFree());
		// Column 2
		assertTrue(threesController.getBoard().get_tile(0, 2).getValue()==3);
		assertTrue(threesController.getBoard().get_tile(1, 2).getValue()==2);
		// Column 3
		assertTrue(threesController.getBoard().get_tile(0, 3).getValue()==3);
		assertTrue(threesController.getBoard().get_tile(1, 3).getValue()==1);
	}
	
	/**
	 * Test block6 (>1,= y !=,a):
	 * >1: More than one column is combinable
	 * = y !=: Exist combinations by non-equal tiles and by equal tiles
	 * a : Exist non-combination by non-combinable tiles and empty space
	 */
	@Test
	public void testBlock6() {
		// Input board:
		// [ 1 , 1 , 3 , 6]
		// [ 2 , 2 , 3 , 3]
		// [ 0 , 0 , 0 , 0]
		// [ 0 , 1 , 0 , 0]
		ThreesBoard board = new ThreesBoard();
		board.set_tile(0, 0, 1);
		board.set_tile(1, 0, 2);
		board.set_tile(0, 1, 1);
		board.set_tile(1, 1, 2);
		board.set_tile(3, 1, 1);
		board.set_tile(0, 2, 3);
		board.set_tile(1, 2, 3);
		board.set_tile(0, 3, 6);
		board.set_tile(1, 3, 3);
		ThreesController threesController = new ThreesController(board);
		threesController.move_up();
		// Expected board:
		// [ 3 , 1 , 6 , 6]
		// [ 0 , 2 , 0 , 3]
		// [ 0 , 1 , 0 , 0]
		// [ 0 , 0 , 0 , 0]		
		// Column 0
		assertTrue(threesController.getBoard().get_tile(0, 0).getValue()==3);
		assertTrue(threesController.getBoard().get_tile(1, 0).isFree());
		// Column 1
		assertTrue(threesController.getBoard().get_tile(0, 1).getValue()==1);
		assertTrue(threesController.getBoard().get_tile(1, 1).getValue()==2);
		assertTrue(threesController.getBoard().get_tile(2, 1).getValue()==1);
		// Column 2
		assertTrue(threesController.getBoard().get_tile(0, 2).getValue()==6);
		assertTrue(threesController.getBoard().get_tile(1, 2).isFree());
		// Column 3
		assertTrue(threesController.getBoard().get_tile(0, 3).getValue()==6);
		assertTrue(threesController.getBoard().get_tile(1, 3).getValue()==3);
	}
	
	/**
	 * Test block8 (>1,=,n):
	 * >1: More than one column is combinable
	 * = : Just exist combinations by equal tiles
	 * n : There are no non-combinable columns
	 */
	@Test 
	public void testBlock8() {
		// Input board:
		// [ 3 , 6 , 12, 3]
		// [ 3 , 6 , 12, 3]
		// [ 0 , 0 , 0 , 0]
		// [ 0 , 0 , 0 , 0]
		ThreesBoard board = new ThreesBoard();
		board.set_tile(0, 0, 3);
		board.set_tile(1, 0, 3);
		board.set_tile(0, 1, 6);
		board.set_tile(1, 1, 6);
		board.set_tile(0, 2, 12);
		board.set_tile(1, 2, 12);
		board.set_tile(0, 3, 3);
		board.set_tile(1, 3, 3);
		ThreesController threesController = new ThreesController(board);
		threesController.move_up();
		// Expected board:
		// [ 6 , 12, 24, 6]
		// [ 0 , 0 , 0 , 0]
		// [ 0 , 0 , 0 , 0]
		// [ 0 , 0 , 0 , 0]		
		// Column 0
		assertTrue(threesController.getBoard().get_tile(0, 0).getValue()==6);
		assertTrue(threesController.getBoard().get_tile(1, 0).isFree());
		// Column 1
		assertTrue(threesController.getBoard().get_tile(0, 1).getValue()==12);
		assertTrue(threesController.getBoard().get_tile(1, 1).isFree());
		// Column 2
		assertTrue(threesController.getBoard().get_tile(0, 2).getValue()==24);
		assertTrue(threesController.getBoard().get_tile(1, 2).isFree());
		// Column 3
		assertTrue(threesController.getBoard().get_tile(0, 3).getValue()==6);
		assertTrue(threesController.getBoard().get_tile(1, 3).isFree());
	}
	
	/**
	 * Test block9 (>1,=,2d):
	 * >1: More than one column is combinable
	 * = : Just exist combinations by equal tiles
	 * 2d: Exist non-combination just by non-combinable tiles
	 */
	@Test
	public void testBlock9() {
		// Input board:
		// [ 3 , 3 , 0 , 6]
		// [ 3 , 1 , 0 , 6]
		// [ 0 , 0 , 0 , 0]
		// [ 0 , 0 , 0 , 0]
		ThreesBoard board = new ThreesBoard();
		board.set_tile(0, 0, 3);
		board.set_tile(1, 0, 3);
		board.set_tile(0, 1, 3);
		board.set_tile(1, 1, 1);
		board.set_tile(0, 3, 6);
		board.set_tile(1, 3, 6);
		ThreesController threesController = new ThreesController(board);
		threesController.move_up();
		// Expected board
		// [ 6 , 3 , 0 ,12]
		// [ 0 , 1 , 0 , 0]
		// [ 0 , 0 , 0 , 0]
		// [ 0 , 0 , 0 , 0]
		// Column 0
		assertTrue(threesController.getBoard().get_tile(0, 0).getValue()==6);
		assertTrue(threesController.getBoard().get_tile(1, 0).isFree());
		// Column 1
		assertTrue(threesController.getBoard().get_tile(0, 1).getValue()==3);
		assertTrue(threesController.getBoard().get_tile(1, 1).getValue()==1);
		// Column 3
		assertTrue(threesController.getBoard().get_tile(0, 3).getValue()==12);
		assertTrue(threesController.getBoard().get_tile(1, 3).isFree());
	}
	
	/**
	 * Test block10 (>1,=,lv):
	 * >1: More than one column is combinable
	 * = : Just exist combinations by equal tiles
	 * lv: Exist non-combination just by empty space
	 */
	@Test
	public void testBlock10() {
		// Input board:
		// [ 3 , 1 , 0 , 6]
		// [ 3 , 2 , 0 , 6]
		// [ 0 , 0 , 0 , 0]
		// [ 0 , 1 , 0 , 0]
		ThreesBoard board = new ThreesBoard();
		board.set_tile(0, 0, 3);
		board.set_tile(1, 0, 3);
		board.set_tile(0, 1, 1);
		board.set_tile(1, 1, 2);
		board.set_tile(3, 1, 1);
		board.set_tile(0, 3, 6);
		board.set_tile(1, 3, 6);
		ThreesController threesController = new ThreesController(board);
		threesController.move_up();
		// Expected board:
		// [ 6 , 1 , 0 ,12]
		// [ 0 , 2 , 0 , 0]
		// [ 0 , 1 , 0 , 0]
		// [ 0 , 0 , 0 , 0]
		// Column 0
		assertTrue(threesController.getBoard().get_tile(0, 0).getValue()==6);
		assertTrue(threesController.getBoard().get_tile(1, 0).isFree());
		// Column 1
		assertTrue(threesController.getBoard().get_tile(0, 1).getValue()==1);
		assertTrue(threesController.getBoard().get_tile(1, 1).getValue()==2);
		assertTrue(threesController.getBoard().get_tile(2, 1).getValue()==1);
		// Column 3
		assertTrue(threesController.getBoard().get_tile(0, 3).getValue()==12);
		assertTrue(threesController.getBoard().get_tile(1, 3).isFree());
	}
	
}


