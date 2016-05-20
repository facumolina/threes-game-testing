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
		boolean moved = threesController.move_up();
		// Expected board:
		// [ 6 , 1 , 12, 1]
		// [ 0 , 1 , 0 , 2]
		// [ 0 , 1 , 0 , 2]
		// [ 0 , 0 , 0 , 0]
		// Column 0
		assertTrue(threesController.getBoard().get_tile(0, 0).getValue()==6);
		// Column 1
		assertTrue(threesController.getBoard().get_tile(0, 1).getValue()==1);
		assertTrue(threesController.getBoard().get_tile(1, 1).getValue()==1);
		assertTrue(threesController.getBoard().get_tile(2, 1).getValue()==1);
		// Column 2
		assertTrue(threesController.getBoard().get_tile(0, 2).getValue()==12);
		// Column3
		assertTrue(threesController.getBoard().get_tile(0, 3).getValue()==1);
		assertTrue(threesController.getBoard().get_tile(1, 3).getValue()==2);
		assertTrue(threesController.getBoard().get_tile(2, 3).getValue()==2);
		// Moved Columns
		assertTrue(threesController.getMovedColumns().contains(0));
		assertTrue(!threesController.getMovedColumns().contains(1));
		assertTrue(threesController.getMovedColumns().contains(2));
		assertTrue(threesController.getMovedColumns().contains(3));
		assertTrue(moved);
		assertTrue(freeCells(threesController.getBoard())==7);
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
		boolean moved = threesController.move_up();
		// Expected board:
		// [ 6 , 0 , 1 , 3]
		// [ 0 , 0 , 2 , 6]
		// [ 0 , 0 , 2 , 0]
		// [ 0 , 0 , 0 , 0]
		// Column 0
		assertTrue(threesController.getBoard().get_tile(0, 0).getValue()==6);
		// Column 2
		assertTrue(threesController.getBoard().get_tile(0, 2).getValue()==1);
		assertTrue(threesController.getBoard().get_tile(1, 2).getValue()==2);
		assertTrue(threesController.getBoard().get_tile(2, 2).getValue()==2);
		// Column 3
		assertTrue(threesController.getBoard().get_tile(0, 3).getValue()==3);
		assertTrue(threesController.getBoard().get_tile(1, 3).getValue()==6);
		// Moved columns
		assertTrue(threesController.getMovedColumns().contains(0));
		assertTrue(!threesController.getMovedColumns().contains(1));
		assertTrue(threesController.getMovedColumns().contains(2));
		assertTrue(!threesController.getMovedColumns().contains(3));
		assertTrue(moved);
		assertTrue(freeCells(threesController.getBoard())==9);
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
		boolean moved = threesController.move_up();
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
		// Column 3
		assertTrue(threesController.getBoard().get_tile(0, 3).getValue()==1);
		assertTrue(threesController.getBoard().get_tile(1, 3).getValue()==2);
		assertTrue(threesController.getBoard().get_tile(2, 3).getValue()==3);
		// Moved columns
		assertTrue(!threesController.getMovedColumns().contains(0));
		assertTrue(threesController.getMovedColumns().contains(1));
		assertTrue(!threesController.getMovedColumns().contains(2));
		assertTrue(threesController.getMovedColumns().contains(3));	
		assertTrue(moved);
		assertTrue(freeCells(threesController.getBoard())==9);
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
		boolean moved = threesController.move_up();
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
		// Moved columns
		assertTrue(!threesController.getMovedColumns().contains(0));
		assertTrue(threesController.getMovedColumns().contains(1));
		assertTrue(!threesController.getMovedColumns().contains(2));
		assertTrue(threesController.getMovedColumns().contains(3));	
		assertTrue(moved);
		assertTrue(freeCells(threesController.getBoard())==9);
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
		boolean moved = threesController.move_up();
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
		// Column 2
		assertTrue(threesController.getBoard().get_tile(0, 2).getValue()==3);
		assertTrue(threesController.getBoard().get_tile(1, 2).getValue()==2);
		// Column 3
		assertTrue(threesController.getBoard().get_tile(0, 3).getValue()==3);
		assertTrue(threesController.getBoard().get_tile(1, 3).getValue()==1);
		// Moved columns
		assertTrue(threesController.getMovedColumns().contains(0));
		assertTrue(threesController.getMovedColumns().contains(1));
		assertTrue(threesController.getMovedColumns().contains(2));
		assertTrue(!threesController.getMovedColumns().contains(3));	
		assertTrue(moved);
		assertTrue(freeCells(threesController.getBoard())==7);
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
		boolean moved = threesController.move_up();
		// Expected board:
		// [ 3 , 1 , 6 , 6]
		// [ 0 , 2 , 0 , 3]
		// [ 0 , 1 , 0 , 0]
		// [ 0 , 0 , 0 , 0]		
		// Column 0
		assertTrue(threesController.getBoard().get_tile(0, 0).getValue()==3);
		// Column 1
		assertTrue(threesController.getBoard().get_tile(0, 1).getValue()==1);
		assertTrue(threesController.getBoard().get_tile(1, 1).getValue()==2);
		assertTrue(threesController.getBoard().get_tile(2, 1).getValue()==1);
		// Column 2
		assertTrue(threesController.getBoard().get_tile(0, 2).getValue()==6);
		// Column 3
		assertTrue(threesController.getBoard().get_tile(0, 3).getValue()==6);
		assertTrue(threesController.getBoard().get_tile(1, 3).getValue()==3);
		// Moved columns
		assertTrue(threesController.getMovedColumns().contains(0));
		assertTrue(threesController.getMovedColumns().contains(1));
		assertTrue(threesController.getMovedColumns().contains(2));
		assertTrue(!threesController.getMovedColumns().contains(3));
		assertTrue(moved);
		assertTrue(freeCells(threesController.getBoard())==8);
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
		boolean moved = threesController.move_up();
		// Expected board:
		// [ 6 , 12, 24, 6]
		// [ 0 , 0 , 0 , 0]
		// [ 0 , 0 , 0 , 0]
		// [ 0 , 0 , 0 , 0]		
		// Column 0
		assertTrue(threesController.getBoard().get_tile(0, 0).getValue()==6);
		// Column 1
		assertTrue(threesController.getBoard().get_tile(0, 1).getValue()==12);
		// Column 2
		assertTrue(threesController.getBoard().get_tile(0, 2).getValue()==24);
		// Column 3
		assertTrue(threesController.getBoard().get_tile(0, 3).getValue()==6);
		// Moved columns
		assertTrue(threesController.getMovedColumns().contains(0));
		assertTrue(threesController.getMovedColumns().contains(1));
		assertTrue(threesController.getMovedColumns().contains(2));
		assertTrue(threesController.getMovedColumns().contains(3));
		assertTrue(moved);
		assertTrue(freeCells(threesController.getBoard())==11);
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
		boolean moved = threesController.move_up();
		// Expected board
		// [ 6 , 3 , 0 ,12]
		// [ 0 , 1 , 0 , 0]
		// [ 0 , 0 , 0 , 0]
		// [ 0 , 0 , 0 , 0]
		// Column 0
		assertTrue(threesController.getBoard().get_tile(0, 0).getValue()==6);
		// Column 1
		assertTrue(threesController.getBoard().get_tile(0, 1).getValue()==3);
		assertTrue(threesController.getBoard().get_tile(1, 1).getValue()==1);
		// Column 3
		assertTrue(threesController.getBoard().get_tile(0, 3).getValue()==12);
		// Moved columns
		assertTrue(threesController.getMovedColumns().contains(0));
		assertTrue(!threesController.getMovedColumns().contains(1));
		assertTrue(!threesController.getMovedColumns().contains(2));
		assertTrue(threesController.getMovedColumns().contains(3));
		assertTrue(moved);
		assertTrue(freeCells(threesController.getBoard())==11);
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
		boolean moved = threesController.move_up();
		// Expected board:
		// [ 6 , 1 , 0 ,12]
		// [ 0 , 2 , 0 , 0]
		// [ 0 , 1 , 0 , 0]
		// [ 0 , 0 , 0 , 0]
		// Column 0
		assertTrue(threesController.getBoard().get_tile(0, 0).getValue()==6);
		// Column 1
		assertTrue(threesController.getBoard().get_tile(0, 1).getValue()==1);
		assertTrue(threesController.getBoard().get_tile(1, 1).getValue()==2);
		assertTrue(threesController.getBoard().get_tile(2, 1).getValue()==1);
		// Column 3
		assertTrue(threesController.getBoard().get_tile(0, 3).getValue()==12);
		// Moved columns
		assertTrue(threesController.getMovedColumns().contains(0));
		assertTrue(threesController.getMovedColumns().contains(1));
		assertTrue(!threesController.getMovedColumns().contains(2));
		assertTrue(threesController.getMovedColumns().contains(3));
		assertTrue(moved);
		assertTrue(freeCells(threesController.getBoard())==10);
	}
	
	/**
	 * Test with a board that cannot be moved
	 */
	@Test
	public void boardNotAffectedByMoveUp() {
		// Input board:
		// [ 3 , 3 , 3 , 3]
		// [ 2 , 2 , 2 , 2]
		// [ 3 , 3 , 3 , 3]
		// [ 0 , 0 , 0 , 0]
		ThreesBoard board = new ThreesBoard();
		board.set_tile(0, 0, 3);
		board.set_tile(1, 0, 2);
		board.set_tile(2, 0, 3);
		board.set_tile(0, 1, 3);
		board.set_tile(1, 1, 2);
		board.set_tile(2, 1, 3);
		board.set_tile(0, 2, 3);
		board.set_tile(1, 2, 2);
		board.set_tile(2, 2, 3);
		board.set_tile(0, 3, 3);
		board.set_tile(1, 3, 2);
		board.set_tile(2, 3, 3);
		ThreesController threesController = new ThreesController(board);
		boolean moved = threesController.move_up();
		// Expected board:
		// [ 3 , 3 , 3 , 3]
		// [ 2 , 2 , 2 , 2]
		// [ 3 , 3 , 3 , 3]
		// [ 0 , 0 , 0 , 0]
		// Column 0
		assertTrue(threesController.getBoard().get_tile(0, 0).getValue()==3);
		assertTrue(threesController.getBoard().get_tile(1, 0).getValue()==2);
		assertTrue(threesController.getBoard().get_tile(2, 0).getValue()==3);
		// Column 1
		assertTrue(threesController.getBoard().get_tile(0, 1).getValue()==3);
		assertTrue(threesController.getBoard().get_tile(1, 1).getValue()==2);
		assertTrue(threesController.getBoard().get_tile(2, 1).getValue()==3);
		// Column 2
		assertTrue(threesController.getBoard().get_tile(0, 2).getValue()==3);
		assertTrue(threesController.getBoard().get_tile(1, 2).getValue()==2);
		assertTrue(threesController.getBoard().get_tile(2, 2).getValue()==3);
		// Column 3
		assertTrue(threesController.getBoard().get_tile(0, 3).getValue()==3);
		assertTrue(threesController.getBoard().get_tile(1, 3).getValue()==2);
		assertTrue(threesController.getBoard().get_tile(2, 3).getValue()==3);
		// Moved columns
		assertTrue(threesController.getMovedColumns().isEmpty());
		assertTrue(!moved);
		assertTrue(freeCells(threesController.getBoard())==4);
	}
	
	/**
	 * Test combine by equals in the middle
	 */
	@Test
	public void testCombineByEqualsInTheMiddle() {
		// Input board:
		// [ 6 , 0 , 1 , 3]
		// [ 3 , 0 , 2 , 6]
		// [ 3 , 0 , 0 , 0]
		// [ 0 , 0 , 2 , 0]
		ThreesBoard board = new ThreesBoard();
		board.set_tile(0, 0, 6);
		board.set_tile(1, 0, 3);
		board.set_tile(2, 0, 3);
		board.set_tile(0, 2, 1);
		board.set_tile(1, 2, 2);
		board.set_tile(3, 2, 2);
		board.set_tile(0, 3, 3);
		board.set_tile(1, 3, 6);
		ThreesController threesController = new ThreesController(board);
		boolean moved = threesController.move_up();
		// Expected board:
		// [ 6 , 0 , 1 , 3]
		// [ 6 , 0 , 2 , 6]
		// [ 0 , 0 , 2 , 0]
		// [ 0 , 0 , 0 , 0]
		// Column 0
		assertTrue(threesController.getBoard().get_tile(0, 0).getValue()==6);
		assertTrue(threesController.getBoard().get_tile(1, 0).getValue()==6);
		// Column 2
		assertTrue(threesController.getBoard().get_tile(0, 2).getValue()==1);
		assertTrue(threesController.getBoard().get_tile(1, 2).getValue()==2);
		assertTrue(threesController.getBoard().get_tile(2, 2).getValue()==2);
		// Column 3
		assertTrue(threesController.getBoard().get_tile(0, 3).getValue()==3);
		assertTrue(threesController.getBoard().get_tile(1, 3).getValue()==6);
		// Moved columns
		assertTrue(threesController.getMovedColumns().contains(0));
		assertTrue(!threesController.getMovedColumns().contains(1));
		assertTrue(threesController.getMovedColumns().contains(2));
		assertTrue(!threesController.getMovedColumns().contains(3));
		assertTrue(moved);
		assertTrue(freeCells(threesController.getBoard())==8);
	}
	
	/**
	 * Test move up without combinations
	 */
	@Test
	public void testCanMoveUpButNoCombination() {
		// Input board:
		// [ 0 , 0 , 0 , 0]
		// [ 0 , 0 , 0 , 0]
		// [ 1 , 2 , 2 , 1]
		// [ 2 , 2 , 2 , 2]
		ThreesBoard board = new ThreesBoard();
		board.set_tile(2, 0, 1);
		board.set_tile(3, 0, 2);
		board.set_tile(2, 1, 2);
		board.set_tile(3, 1, 2);
		board.set_tile(2, 2, 2);
		board.set_tile(3, 2, 2);
		board.set_tile(2, 3, 1);
		board.set_tile(3, 3, 2);
		ThreesController threesController = new ThreesController(board);
		boolean moved = threesController.move_up();
		// Expected board:
		// [ 0 , 0 , 0 , 0]
		// [ 1 , 2 , 2 , 1]
		// [ 2 , 2 , 2 , 2]
		// [ 0 , 0 , 0 , 0]
		// Column 0
		assertTrue(threesController.getBoard().get_tile(1, 0).getValue()==1);
		assertTrue(threesController.getBoard().get_tile(2, 0).getValue()==2);
		// Column 1
		assertTrue(threesController.getBoard().get_tile(1, 1).getValue()==2);
		assertTrue(threesController.getBoard().get_tile(2, 1).getValue()==2);
		// Column 2
		assertTrue(threesController.getBoard().get_tile(1, 2).getValue()==2);
		assertTrue(threesController.getBoard().get_tile(2, 2).getValue()==2);
		// Column 3
		assertTrue(threesController.getBoard().get_tile(1, 3).getValue()==1);
		assertTrue(threesController.getBoard().get_tile(2, 3).getValue()==2);
		// Moved columns
		assertTrue(threesController.getMovedColumns().contains(0));
		assertTrue(threesController.getMovedColumns().contains(1));
		assertTrue(threesController.getMovedColumns().contains(2));
		assertTrue(threesController.getMovedColumns().contains(3));
		assertTrue(moved);
		assertTrue(freeCells(threesController.getBoard())==7);
	}
	
	/**
	 * Test move up without combinations2
	 */
	@Test
	public void testCanMoveUpButNoCombination2() {
		// Input board:
		// [ 0 , 0 , 0 , 0]
		// [ 0 , 0 , 0 , 2]
		// [ 1 , 2 , 2 , 1]
		// [ 2 , 2 , 2 , 2]
		ThreesBoard board = new ThreesBoard();
		board.set_tile(2, 0, 1);
		board.set_tile(3, 0, 2);
		board.set_tile(2, 1, 2);
		board.set_tile(3, 1, 2);
		board.set_tile(2, 2, 2);
		board.set_tile(3, 2, 2);
		board.set_tile(1, 3, 2);
		board.set_tile(2, 3, 1);
		board.set_tile(3, 3, 2);
		ThreesController threesController = new ThreesController(board);
		boolean moved = threesController.move_up();
		// Expected board:
		// [ 0 , 0 , 0 , 2]
		// [ 1 , 2 , 2 , 1]
		// [ 2 , 2 , 2 , 2]
		// [ 0 , 0 , 0 , 0]
		// Column 0
		assertTrue(threesController.getBoard().get_tile(1, 0).getValue()==1);
		assertTrue(threesController.getBoard().get_tile(2, 0).getValue()==2);
		// Column 1
		assertTrue(threesController.getBoard().get_tile(1, 1).getValue()==2);
		assertTrue(threesController.getBoard().get_tile(2, 1).getValue()==2);
		// Column 2
		assertTrue(threesController.getBoard().get_tile(1, 2).getValue()==2);
		assertTrue(threesController.getBoard().get_tile(2, 2).getValue()==2);
		// Column 3
		assertTrue(threesController.getBoard().get_tile(0, 3).getValue()==2);
		assertTrue(threesController.getBoard().get_tile(1, 3).getValue()==1);
		assertTrue(threesController.getBoard().get_tile(2, 3).getValue()==2);
		// Moved columns
		assertTrue(threesController.getMovedColumns().contains(0));
		assertTrue(threesController.getMovedColumns().contains(1));
		assertTrue(threesController.getMovedColumns().contains(2));
		assertTrue(threesController.getMovedColumns().contains(3));
		assertTrue(moved);
		assertTrue(freeCells(threesController.getBoard())==6);
	}
	
	/**
	 * Count the free cells of a given board
	 * @return
	 */
	private int freeCells(ThreesBoard board) {
		int freeCells=0;
		for (int i=0;i<board.ROWS;i++) {
			for (int j=0;j<board.COLUMNS;j++) {
				if (board.get_tile(i, j).isFree()) {
					freeCells++;
				}
			}
		}
		return freeCells;
	}
	
}


