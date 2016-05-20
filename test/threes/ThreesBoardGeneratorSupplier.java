package threes;

import java.util.ArrayList;
import java.util.List;

import org.junit.experimental.theories.ParameterSupplier;
import org.junit.experimental.theories.PotentialAssignment;
import org.junit.experimental.theories.ParameterSignature;

public class ThreesBoardGeneratorSupplier extends ParameterSupplier {

	@Override
	public List<PotentialAssignment> getValueSources(ParameterSignature sig) {
		List<PotentialAssignment> values = new ArrayList<PotentialAssignment>();
		ThreesBoardGenerator annotation = sig.getAnnotation(ThreesBoardGenerator.class);
		int n = annotation.n();
		
		int cellsValues[] = {1,2,3,6,12};
		
		// Generate n boards
		for (int i = 0 ; i < n ; i++) {
			ThreesBoard board = new ThreesBoard();
			for (int k=0;k<board.ROWS;k++) {
				for (int j=0;j<board.COLUMNS;j++) {
					if (board.getRandom(2)==1) {
						board.set_tile(k,j,cellsValues[board.getRandom(5)]);
					}
				}
			}
			values.add(PotentialAssignment.forValue("board", board));
		}
		return values;
	}
}
