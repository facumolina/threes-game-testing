package threes;

import org.junit.Test;
import static org.junit.Assert.assertTrue;

public class ThreesControllerMoveUpTest {
	
	@Test
	public void justCanCombineTheFirstColumnWithDifferentCellValues() {
		// Input board:
		// [ 1 , 1 , 0 , 0]
		// [ 2 , 1 , 0 , 0]
		// [ 0 , 0 , 0 , 0]
		// [ 0 , 0 , 0 , 0]
		ThreesBoard board = new ThreesBoard();
		board.set_tile(0, 0, 1);
		board.set_tile(1, 0, 2);
		board.set_tile(0, 1, 1);
		board.set_tile(1, 1, 1);
		ThreesController threesController = new ThreesController(board);
		threesController.move_up();
		// Expected board:
		// [ 3 , 1 , 0 , 0]
		// [ 0 , 1 , 0 , 0]
		// [ 0 , 0 , 0 , 0]
		// [ 0 , 0 , 0 , 0]
		// Column 0
		assertTrue(threesController.getBoard().get_tile(0, 0).getValue()==3);
		assertTrue(threesController.getBoard().get_tile(1, 0).isFree());
		// Column 1
		assertTrue(threesController.getBoard().get_tile(0, 1).getValue()==1);
		assertTrue(threesController.getBoard().get_tile(1, 1).getValue()==1);
	}
	
	@Test
	public void justCanCombineTheFirstColumnWithEqualCellValues() {
		// Input board:
		// [ 3 , 0 , 1 , 0]
		// [ 3 , 0 , 0 , 0]
		// [ 0 , 0 , 2 , 0]
		// [ 0 , 0 , 0 , 0]
		ThreesBoard board = new ThreesBoard();
		board.set_tile(0, 0, 3);
		board.set_tile(1, 0, 3);
		board.set_tile(0, 2, 1);
		board.set_tile(2, 2, 2);
		ThreesController threesController = new ThreesController(board);
		threesController.move_up();
		// Expected board:
		// [ 6 , 0 , 1 , 0]
		// [ 0 , 0 , 2 , 0]
		// [ 0 , 0 , 0 , 0]
		// [ 0 , 0 , 0 , 0]
		// Column 0
		assertTrue(threesController.getBoard().get_tile(0, 0).getValue()==6);
		assertTrue(threesController.getBoard().get_tile(1, 0).isFree());
		// Column 2
		assertTrue(threesController.getBoard().get_tile(0, 2).getValue()==1);
		assertTrue(threesController.getBoard().get_tile(1, 2).getValue()==2);
	}
	
	@Test
	public void justCanCombineAMiddleColumnWithDifferentCellValues() {
		// Input board:
		// [ 0 , 1 , 0 , 0]
		// [ 0 , 2 , 0 , 0]
		// [ 0 , 0 , 1 , 0]
		// [ 0 , 0 , 2 , 0]
		ThreesBoard board = new ThreesBoard();
		board.set_tile(0, 1, 1);
		board.set_tile(1, 1, 2);
		board.set_tile(2, 2, 1);
		board.set_tile(3, 2, 2);
		ThreesController threesController = new ThreesController(board);
		threesController.move_up();
		// Expected board:
		// [ 0 , 3 , 0 , 0]
		// [ 0 , 0 , 1 , 0]
		// [ 0 , 0 , 2 , 0]
		// [ 0 , 0 , 0 , 0]
		// Column 1
		assertTrue(threesController.getBoard().get_tile(0, 1).getValue()==3);
		assertTrue(threesController.getBoard().get_tile(1, 1).isFree());
		// Column 2
		assertTrue(threesController.getBoard().get_tile(1, 2).getValue()==1);
		assertTrue(threesController.getBoard().get_tile(2, 2).getValue()==2);
	}
	
	@Test
	public void justCanCombineAMiddleColumnWithEqualCellValues() {
		// Input board:
		// [ 0 , 6 , 0 , 1]
		// [ 0 , 6 , 0 , 1]
		// [ 0 , 0 , 0 , 1]
		// [ 0 , 0 , 0 , 1]		
		ThreesBoard board = new ThreesBoard();
		board.set_tile(0, 1, 6);
		board.set_tile(1, 1, 6);
		board.set_tile(0, 3, 1);
		board.set_tile(1, 3, 1);
		board.set_tile(2, 3, 1);
		board.set_tile(3, 3, 1);
		ThreesController threesController = new ThreesController(board);
		threesController.move_up();
		// Expected board:
		// [ 0 , 12, 0 , 1]
		// [ 0 , 0 , 0 , 1]
		// [ 0 , 0 , 0 , 1]
		// [ 0 , 0 , 0 , 1]		
		// Column 1
		assertTrue(threesController.getBoard().get_tile(0, 1).getValue()==12);
		assertTrue(threesController.getBoard().get_tile(1, 1).isFree());
		// Column 3
		assertTrue(threesController.getBoard().get_tile(0, 3).getValue()==1);
		assertTrue(threesController.getBoard().get_tile(1, 3).getValue()==1);
		assertTrue(threesController.getBoard().get_tile(2, 3).getValue()==1);
		assertTrue(threesController.getBoard().get_tile(3, 3).getValue()==1);
	}
	
	@Test
	public void justCanCombineTheLastColumnWithDifferentCellValues() {
		// Input board:
		// [ 0 , 0 , 0 , 1]
		// [ 0 , 0 , 0 , 2]
		// [ 0 , 0 , 0 , 0]
		// [ 0 , 0 , 0 , 0]
		ThreesBoard board = new ThreesBoard();
		board.set_tile(0, ThreesBoard.COLUMNS-1, 1);
		board.set_tile(1, ThreesBoard.COLUMNS-1, 2);
		ThreesController threesController = new ThreesController(board);
		threesController.move_up();
		// Expected board:
		// [ 0 , 0 , 0 , 1]
		// [ 0 , 0 , 0 , 2]
		// [ 0 , 0 , 0 , 0]
		// [ 0 , 0 , 0 , 0]		
		assertTrue(threesController.getBoard().get_tile(0, ThreesBoard.COLUMNS-1).getValue()==3);
		assertTrue(threesController.getBoard().get_tile(1, ThreesBoard.COLUMNS-1).isFree());
	}
	
	@Test
	public void justCanCombineTheLastColumnWithEqualCellValues() {
		// Input board:
		// [ 0 , 0 , 0 , 3]
		// [ 0 , 0 , 0 , 3]
		// [ 0 , 0 , 0 , 0]
		// [ 0 , 0 , 0 , 0]
		ThreesBoard board = new ThreesBoard();
		board.set_tile(0, ThreesBoard.COLUMNS-1, 3);
		board.set_tile(1, ThreesBoard.COLUMNS-1, 3);
		ThreesController threesController = new ThreesController(board);
		threesController.move_up();
		// Expected board:
		// [ 0 , 0 , 0 , 6]
		// [ 0 , 0 , 0 , 0]
		// [ 0 , 0 , 0 , 0]
		// [ 0 , 0 , 0 , 0]		
		// Column 3
		assertTrue(threesController.getBoard().get_tile(0, ThreesBoard.COLUMNS-1).getValue()==6);
		assertTrue(threesController.getBoard().get_tile(1, ThreesBoard.COLUMNS-1).isFree());
	}
	
	@Test 
	public void moreThanOneColumnCanBeCombined() {
		// Input board:
		// [ 1 , 0 , 0 , 3]
		// [ 2 , 0 , 0 , 3]
		// [ 0 , 0 , 0 , 0]
		// [ 0 , 0 , 0 , 0]
		ThreesBoard board = new ThreesBoard();
		board.set_tile(0, 0, 1);
		board.set_tile(1, 0, 2);
		board.set_tile(0, ThreesBoard.COLUMNS-1, 3);
		board.set_tile(1, ThreesBoard.COLUMNS-1, 3);
		ThreesController threesController = new ThreesController(board);
		threesController.move_up();
		// Expected board:
		// [ 3 , 0 , 0 , 6]
		// [ 0 , 0 , 0 , 0]
		// [ 0 , 0 , 0 , 0]
		// [ 0 , 0 , 0 , 0]		
		// Column 0
		assertTrue(threesController.getBoard().get_tile(0, 0).getValue()==3);
		assertTrue(threesController.getBoard().get_tile(1, 0).isFree());
		// Column 3
		assertTrue(threesController.getBoard().get_tile(0, ThreesBoard.COLUMNS-1).getValue()==6);
		assertTrue(threesController.getBoard().get_tile(1, ThreesBoard.COLUMNS-1).isFree());
	}
	
	@Test
	public void thereAreNoCombinableColumns () {
		// Input board:
		// [ 1 , 1 , 0 , 6]
		// [ 1 , 0 , 0 , 3]
		// [ 1 , 2 , 0 , 0]
		// [ 0 , 0 , 0 , 0]
		ThreesBoard board = new ThreesBoard();
		board.set_tile(0, 0, 1);
		board.set_tile(1, 0, 1);
		board.set_tile(2, 0, 1);
		board.set_tile(0, 1, 1);
		board.set_tile(2, 1, 2);
		board.set_tile(0, 3, 6);
		board.set_tile(1, 3, 3);
		ThreesController threesController = new ThreesController(board);
		threesController.move_up();
		// Expected board
		// [ 1 , 1 , 0 , 6]
		// [ 1 , 2 , 0 , 3]
		// [ 1 , 0 , 0 , 0]
		// [ 0 , 0 , 0 , 0]
		// Column 0
		assertTrue(threesController.getBoard().get_tile(0, 0).getValue()==1);
		assertTrue(threesController.getBoard().get_tile(1, 0).getValue()==1);
		assertTrue(threesController.getBoard().get_tile(2, 0).getValue()==1);
		// Column 1
		assertTrue(threesController.getBoard().get_tile(0, 1).getValue()==1);
		assertTrue(threesController.getBoard().get_tile(1, 1).getValue()==2);
		// Column 3
		assertTrue(threesController.getBoard().get_tile(0, 3).getValue()==6);
		assertTrue(threesController.getBoard().get_tile(1, 3).getValue()==3);
	}
	
}



