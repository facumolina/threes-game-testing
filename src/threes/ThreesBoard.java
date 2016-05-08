package threes;
import java.util.Random;

public class ThreesBoard {

	// Stores the game board. Indices for tiles must go from 1 to 4, both for rows and for columns.
	private ThreesTile [][] elements;
	
	
	// Number of rows in the board. Should be constantly 4
	public static final int ROWS = 4;
	
	// Number of columns in the board. Should be constantly 4
	public static final int COLUMNS = 4;
	
	public ThreesBoard(int total_tiles_to_set) {
		// Creates a board of 4x4 with free tiles.
		elements = new ThreesTile[ROWS][COLUMNS];
		for(int i = 0; i<ROWS; i++){
			for(int j = 0; i<COLUMNS; j++){
				elements[i][j] = new ThreesTile();
			}
		}
		// select 9 positions, and set with random numbers from 1, 2 or 3.
		for(int set_tiles=0; set_tiles < total_tiles_to_set; set_tiles++){
			int random_tile_row = getRandom(ROWS);
			int random_tile_col = getRandom(COLUMNS);
			while (!elements[random_tile_row][random_tile_col].isFree()){
				random_tile_row = getRandom(ROWS);
				random_tile_col = getRandom(COLUMNS);	
			}
			//set a random value
			int value = getRandom(3);
			set_tile(random_tile_row, random_tile_col, value);
		}
	}
	
	public ThreesBoard() {
		// Creates a board of 4x4 with free tiles.
		elements = new ThreesTile[ROWS][COLUMNS];
		for(int i = 0; i<ROWS; i++){
			for(int j = 0; j<COLUMNS; j++){
				elements[i][j] = new ThreesTile();
			}
		}
	}
	
	
	public int getRandom(int bound){
		Random randomGenerator = new Random();
	    int randomInt = randomGenerator.nextInt()%bound;
	    while(randomInt<0)
	    	randomInt = randomGenerator.nextInt()%bound;
	    return randomInt;
	}
	
	
	public boolean isFinished(){
		//Returns true iff there is no possible movement 
		return (!can_move_left() && !can_move_left() && !can_move_up() && !can_move_down());
	}
	
	public int numberOfSetTiles(){
		int set_tiles = 0;
		for(int i=0; i< ROWS; i++){
			for(int j=0; j<COLUMNS; j++){
				if(!elements[i][j].isFree())
					set_tiles++;
			}
		}
		return set_tiles;
	}
	
	public boolean can_move_left(){
		//Indicates whether the board would change through a movement to the left
		boolean can_move = false;
		//check if the current tile is empty 
		//or if some tiles can combine, when moving to the left
		for(int i = 0; (i<ROWS && !can_move); i++){
			for(int j = 0; (j < COLUMNS-1 && !can_move); j++){
				//if the tile is free or combines with the tile on the left
				if(elements[i][j].isFree() || tiles_can_combine(elements[i][j],elements[i][j+1]))
					can_move = true;
			}
		}
		return can_move;
	}
	
	public boolean can_move_right(){
		//Indicates whether the board would change through a movement to the right
		boolean can_move = false;
		//check if the current tile is empty 
		//or if some tiles can combine, when moving to the right
		for(int i = 0; (i<ROWS && !can_move); i++){
			for(int j = COLUMNS-1; (j > 0 && !can_move); j--){
				//if the tile is free or combines with the tile on the right
				if(elements[i][j].isFree() || tiles_can_combine(elements[i][j],elements[i][j-1]))
					can_move = true;
			}
		}
		return can_move;
	}
	
	public boolean can_move_up(){
		//Indicates whether the board would change through a movement upward
		boolean can_move = false;
		//check if the current tile is empty 
		//or if some tiles can combine, when moving upward
		for(int j =0; (j < COLUMNS && !can_move); j++){	
			for(int i = 0; (i<ROWS-1 && !can_move); i++){
				//if the tile is free or combines with the tile up
				if(elements[i][j].isFree() || tiles_can_combine(elements[i][j],elements[i+1][j]))
					can_move = true;
			}
		}
		return can_move;	
	}
	
	public boolean can_move_down(){
		//Indicates whether the board would change through a movement downward
		boolean can_move = false;
		//check if the current tile is empty 
		//or if some tiles can combine, when moving downward
		for(int j =0; (j < COLUMNS && !can_move); j++){	
			for(int i = ROWS-1; (i > 0 && !can_move); i--){
				//if the tile is free or combines with the tile down
				if(elements[i][j].isFree() || tiles_can_combine(elements[i][j],elements[i-1][j]))
					can_move = true;
			}
		}
		return can_move;
	}
	
	public boolean tiles_can_combine(ThreesTile t1, ThreesTile t2){
		boolean can_combine = false;
		int v1 = t1.getValue();
		int v2 = t2.getValue();
		if(v1==1){
			if(v2==2)
				can_combine = true;
		}
		else if (v1==2){
			if(v2==1)
				can_combine = true;
		}
		else{
			can_combine = (v1==v2);
		}
		return can_combine;
	}
	
	
	public void set_tile(int row, int col, int v){
		//Set cell in [row,col] position with a given value require
		if (0<row && row<ROWS && 0<=col && col<COLUMNS){
			elements[row][col].setValue(v);
		}
		else
			throw new IllegalArgumentException();
	}
	
	public ThreesTile get_tile(int row, int col){
		//Returns the tile at position [row,col]
		if (0<=row && row<ROWS && 0<=col && col<=COLUMNS){
			return elements[row][col];
		}
		else
			throw new IllegalArgumentException();
	}
	
	public int compute_score(){
		int score = 0;
		for (int i=0; i<ROWS; i++){
			for(int j=0; j<COLUMNS; j++){
				int v = elements[i][j].getValue();
				if(v==3){
					score += v;
				}
				else if(v>3){
					score += (v-3)*3;
				}
			}
		}
		return score;
	}
}
