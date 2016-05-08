package threes;

import java.io.IOException;
import java.util.LinkedList;
import java.util.Map;

public class ThreesController {
	
	//Stores the Threes board
	private ThreesBoard board;
	//Stores the next tile that will appear in the board.
	private int nextTileValue;
	
	//Stores the rows that move during the last movement
	private LinkedList<Integer> movedRows;
	//Stores the columns that move during the last movement
	private LinkedList<Integer>  movedColumns;
	
	public ThreesController() {
		//Create the initial board.
		//9 random tails set with 1, 2 or 3.
		board = new ThreesBoard(9);
		//Set randomly the next tile to appear in the board.
		nextTileValue = board.getRandom(3)+1;
		//initially no row or column has been moved.
		movedRows = new LinkedList<Integer>();
		movedColumns = new LinkedList<Integer>();
	}
	
	public ThreesController(ThreesBoard b) {
		this.board = b;
		//Set randomly the next tile to appear in the board.
		nextTileValue = board.getRandom(3)+1;
		//initially no row or column has been moved.
		movedRows = new LinkedList<Integer>();
		movedColumns = new LinkedList<Integer>();
	}
	
	public ThreesBoard getBoard(){
		return board;
	}
	
	public int getNextTileValue(){
		return nextTileValue;
	}
	
	//command move up
	public boolean move_up(){
		//TODO: Implemente esta rutina, que mueva las piezas del tablero hacia arriba,
		//      combinando las piezas linderas que cumplan con las reglas especificadas.
 
		return false;
	}
	
	//command move down
	public boolean move_down(){
		//clear last movements lists
		movedRows.clear();
		movedColumns.clear();
		
		if(!board.can_move_down())
			return false;
		
		boolean modified = false;
		for(int j=0; j<ThreesBoard.COLUMNS ; j++){
			
			//can_combine iff the last two tiles are not free and there is no free tile in the middle.
			boolean can_combine = !board.get_tile(3, j).isFree() &&
								  !board.get_tile(2, j).isFree() &&
								  !(board.get_tile(1, j).isFree() && !board.get_tile(0, j).isFree());
					
			if(!can_combine){//move the tile to fill the free spaces
				int i=ThreesBoard.ROWS-1;
				while(!board.get_tile(i, j).isFree())
					i--;
				for(int k=i-1; k>=0 ; k--){
					if(!board.get_tile(k, j).isFree())
						movedColumns.add(j);
					board.set_tile(k+1, j, board.get_tile(k, j).getValue());
				}			
			}
			else{//combine just once. Here there is no free tile in the middle
				boolean updated = false;
				for(int i=ThreesBoard.ROWS-1; i>0 && !updated ; i--){
					if(board.tiles_can_combine(board.get_tile(i, j), board.get_tile(i-1, j))){
						//produce first combination
						ThreesTile t = board.get_tile(i, j).combine_tile(board.get_tile(i-1, j));
						board.set_tile(i, j, t.getValue());
						//move anything else to left in the same row
						for(int k=i-2; k>=0; k--){
							board.set_tile(k+1, j, board.get_tile(k, j).getValue());
						}
						movedColumns.add(j);
						board.set_tile(0,j ,0);//empty the last position
						modified = true;
					}
				}
			}
		}
		loadNextTileOnColumns(false);
		return modified;
	}
		
	//command move left
	public boolean move_left(){
		//clear last movements lists
		movedRows.clear();
		movedColumns.clear();
		
		if(!board.can_move_left())
			return false;
		
		boolean modified = false;
		for(int i=0; i<ThreesBoard.ROWS ; i++){
			
			//can_combine iff the first two tiles are not free and there is no free tile in the middle.
			boolean can_combine = !board.get_tile(i, 0).isFree() &&
								  !board.get_tile(i, 1).isFree() &&
								  !(board.get_tile(i, 2).isFree() && !board.get_tile(i, 3).isFree());
					
			if(!can_combine){//move the tile to fill the free spaces
				int j=0;
				while(!board.get_tile(i, j).isFree())
					j++;
				for(int k=j+1; k<ThreesBoard.COLUMNS ; k++){
					if(!board.get_tile(i, k).isFree())
						movedRows.add(i);
					board.set_tile(i, k-1, board.get_tile(i, k).getValue());
				}
				board.set_tile(i,ThreesBoard.COLUMNS-1 ,0);//empty the last position
				
			}
			else{//combine just once. Here there is no free tile in the middle
				boolean updated = false;
				for(int j=0; j<ThreesBoard.COLUMNS-1 && !updated ; j++){
					if(board.tiles_can_combine(board.get_tile(i, j), board.get_tile(i, j+1))){
						//produce first combination
						ThreesTile t = board.get_tile(i, j).combine_tile(board.get_tile(i, j+1));
						board.set_tile(i, j, t.getValue());
						//move anything else to left in the same row
						for(int k=j+1; k<ThreesBoard.COLUMNS-1; k++){
							board.set_tile(i, k, board.get_tile(i, k+1).getValue());
						}
						movedRows.add(i);
						board.set_tile(i,ThreesBoard.COLUMNS-1 ,0);//empty the last position
						updated = true;
						modified = true;
					}
				}
			}
		}
		loadNextTileOnRows(true);
		return modified;
	}
	
	//command move right
	public boolean move_right(){
		//clear last movements lists
		movedRows.clear();
		movedColumns.clear();
		
		if(!board.can_move_right())
			return false;
		
		boolean modified = false;
		for(int i=0; i<ThreesBoard.ROWS ; i++){
			
			//can_combine iff the first two tiles are not free and there is no free tile in the middle.
			boolean can_combine = !board.get_tile(i, 3).isFree() &&
								  !board.get_tile(i, 2).isFree() &&
								  !(board.get_tile(i, 1).isFree() && !board.get_tile(i, 0).isFree());
					
			if(!can_combine){//move the tile to fill the free spaces
				int j=ThreesBoard.COLUMNS-1;
				while(!board.get_tile(i, j).isFree())
					j--;
				for(int k=j-1; k>=0 ; k--){
					if(!board.get_tile(i, k).isFree())
						movedRows.add(i);
					board.set_tile(i, k+1, board.get_tile(i, k).getValue());
				}
				board.set_tile(i,0 ,0);//empty the first position
				
			}
			else{//combine just once. Here there is no free tile in the middle
				boolean updated = false;
				for(int j=ThreesBoard.COLUMNS-1; j>0 && !updated ; j--){
					if(board.tiles_can_combine(board.get_tile(i, j), board.get_tile(i, j-1))){
						//produce first combination
						ThreesTile t = board.get_tile(i, j).combine_tile(board.get_tile(i, j-1));
						board.set_tile(i, j, t.getValue());
						//move anything else to left in the same row
						for(int k=j-2; k>=0; k--){
							board.set_tile(i, k+1, board.get_tile(i, k).getValue());
						}
						movedRows.add(i);
						board.set_tile(i,0 ,0);//empty the last position
						updated = true;
						modified = true;
					}
				}
			}
		}
		loadNextTileOnRows(false);
		return modified;
	}
	
	private void loadNextTileOnColumns(boolean up) {
		//Assume an upward or downward was performed.
		if(!movedColumns.isEmpty()){
			int pos = board.getRandom(movedColumns.size());
			if(up)
				board.set_tile(ThreesBoard.ROWS-1, movedColumns.get(pos),nextTileValue);
			else
				board.set_tile(0, movedColumns.get(pos),nextTileValue);
			nextTileValue = board.getRandom(3)+1;
		}
	}
	
	private void loadNextTileOnRows(boolean left) {
		//Assume an upward or downward was performed.
		if(!movedRows.isEmpty()){
			int pos = board.getRandom(movedRows.size());
			if(left)
				board.set_tile(movedRows.get(pos),ThreesBoard.COLUMNS-1,nextTileValue);
			else
				board.set_tile(movedRows.get(pos),0,nextTileValue);
			nextTileValue = board.getRandom(3)+1;
		}
	}
	
	/* For mocking: */
	
	private ISaveManager savemanager;
	
	public void setSaveManager(ISaveManager m) {
		savemanager = m;
	}

	public boolean saveGame(String folderName, String fileName) {
		
		try {
			if (savemanager.setFolder(folderName) && !fileName.contains(".")) {
				String fileNameExt = fileName + ".ths";
				return savemanager.saveToFile(board, nextTileValue, fileNameExt);
			}
		} catch (IOException e) {
			System.out.println("Save failed!");
		}
		
		return false;
	}
	
	public boolean loadGame(String folderName, String fileName) {
		try {
			if (savemanager.setFolder(folderName) && fileName.endsWith(".ths")) {
				Map.Entry<ThreesBoard, Integer> res = savemanager.loadFromFile(fileName);
				if (res != null) {
					board = res.getKey();
					nextTileValue = res.getValue();
				}
			}
		} catch (IOException e) {
			System.out.println("Save failed!");
		}
		
		return false;
	}
}
