package threes;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class MovementsModuleIntegrationTest {

	@Test
	public void testMoveUpMoveLeft() {
		// Input board:
		// [ 3 , 6 , 3 , 1]
		// [ 0 , 6 , 6 , 2]
		// [ 0 , 1 , 0 , 0]
		// [ 0 , 0 , 1 , 0]
		ThreesBoard board = new ThreesBoard();
		board.set_tile(0, 0, 3);
		board.set_tile(1, 0, 3);
		board.set_tile(0, 1, 6);
		board.set_tile(1, 1, 6);
		board.set_tile(2, 1, 1);
		board.set_tile(0, 2, 3);
		board.set_tile(1, 2, 6);
		board.set_tile(3, 2, 1);
		board.set_tile(0, 3, 1);
		board.set_tile(1, 3, 2);
		ThreesController threesController = new ThreesController(board);
		
		boolean movedUp = threesController.move_up();
		boolean movedLeft = threesController.move_left();
		
		// Expected board 
		// [ 6 , 12, 6 , 0]
		// [ 1 , 6 , 0 , 0]
		// [ 0 , 1 , 0 , 0]
		// [ 0 , 0 , 0 , 0]
		// Column 0
		assertTrue(threesController.getBoard().get_tile(0, 0).getValue()==6);
		assertTrue(threesController.getBoard().get_tile(1, 0).getValue()==1);
		// Column 1
		assertTrue(threesController.getBoard().get_tile(0, 1).getValue()==12);
		assertTrue(threesController.getBoard().get_tile(1, 1).getValue()==6);
		assertTrue(threesController.getBoard().get_tile(2, 1).getValue()==1);
		// Column 2
		assertTrue(threesController.getBoard().get_tile(0, 2).getValue()==6);
		// Moved
		assertTrue(movedUp);
		assertTrue(movedLeft);
	}
	
	@Test
	public void testMoveDownMoveRight() {
		// Input board:	
		// [ 0 , 1 , 0 , 0]
		// [ 0 , 0 , 1 , 0]
		// [ 2 , 6 , 6 , 3]
		// [ 1 , 3 , 6 , 3]
		ThreesBoard board = new ThreesBoard();
		board.set_tile(2, 0, 2);
		board.set_tile(3, 0, 1);
		board.set_tile(0, 1, 1);
		board.set_tile(2, 1, 6);
		board.set_tile(3, 1, 3);
		board.set_tile(1, 2, 1);
		board.set_tile(2, 2, 6);
		board.set_tile(3, 2, 6);
		board.set_tile(2, 3, 3);
		board.set_tile(3, 3, 3);
		ThreesController threesController = new ThreesController(board);
		
		boolean movedDown = threesController.move_down();
		boolean movedRight = threesController.move_right();
		
		// Expected board:
		// [ 0 , 0 , 0 , 0]
		// [ 0 , 0 , 1 , 0]
		// [ 0 , 0 , 6 , 1]
		// [ 0 , 6 , 12, 6]
		// Column 1
		assertTrue(threesController.getBoard().get_tile(3, 1).getValue()==6);
		// Column 2
		assertTrue(threesController.getBoard().get_tile(1, 2).getValue()==1);
		assertTrue(threesController.getBoard().get_tile(2, 2).getValue()==6);
		assertTrue(threesController.getBoard().get_tile(3, 2).getValue()==12);
		// Column3
		assertTrue(threesController.getBoard().get_tile(2, 3).getValue()==1);
		assertTrue(threesController.getBoard().get_tile(3, 3).getValue()==6);
		// Moved
		assertTrue(movedDown);
		assertTrue(movedRight);
	}
	
}
