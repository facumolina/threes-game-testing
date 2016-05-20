package threes;

import java.util.LinkedList;
import java.util.List;

import org.junit.runner.RunWith;
import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.Theory;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

@RunWith(Theories.class)
public class MoveUpDifferentialTests {

	@Theory
	public void correctCombinationByEquals(@ThreesBoardGenerator(n=5) ThreesBoard board){
		ThreesController controller = new ThreesController(board);
		// Get the columns that allow a combination by equals with the row from which the combination 
		// is possible, and then get the values that allow the combination.
		List<ThreesTile> tilesThatMustBeCombined = determineCombinationalTiles(board);
		List<Integer> values = new LinkedList<Integer>();
		for (ThreesTile tile : tilesThatMustBeCombined){
			values.add(tile.getValue());
		}
		// Move up
		controller.move_up();
		// Ensure that for each column with combination by equals, the tiles value
		// is now the double than before
		int i =0;
		for (ThreesTile tile : tilesThatMustBeCombined) {
			assertThat(tile.getValue(),equalTo(values.get(i)*2));
			i++;
		}	
	}

	/**
	 * Returns the tiles in which a combination by equals must be done. 
	 */
	private List<ThreesTile> determineCombinationalTiles(ThreesBoard board) {
		List<ThreesTile> combinationalTiles = new LinkedList<ThreesTile>();
		
		for (int i=0; i < board.COLUMNS; i++) {
			boolean existCombination = false;
			// Check if the tiles in the first two rows can be combined by equals
			if ( combinableByEquals(board.get_tile(0, i),board.get_tile(1,i))) {
				if (!(board.get_tile(2, i).isFree() && !(board.get_tile(3, i).isFree()))) {
					combinationalTiles.add(board.get_tile(0, i));
					existCombination=true;
				}
			}
			if (!existCombination) {
				// Check if the tiles in the second and third row can be combined by equals
				if (!(board.get_tile(0, i).isFree())&&combinableByEquals(board.get_tile(1,i),board.get_tile(2, i))) {
					combinationalTiles.add(board.get_tile(1, i));
					existCombination=true;
				}
				if (!existCombination) {
					// Check if the tiles in the last two rows can be combined by equals
					if (!(board.get_tile(0, i).isFree()) && !(board.get_tile(1, i).isFree()) && 
							combinableByEquals(board.get_tile(2, i), board.get_tile(3, i))) {
						combinationalTiles.add(board.get_tile(2, i));
						existCombination=true;
					}
				}
			}
			
		}
		return combinationalTiles;
	}
	
	/**
	 * Returns true if the two tiles are combinable by equals values. 3,6,12,..
	 */
	private boolean combinableByEquals(ThreesTile t1,ThreesTile t2) {
		return t1.getValue()>2 && t1.getValue()==t2.getValue();
	}
	
}
