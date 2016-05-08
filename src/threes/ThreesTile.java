package threes;
import java.util.Random;

public class ThreesTile {

	private int value;
	
	public ThreesTile() {
		 // Tile should be unset
		value=0;
	}
	
	public ThreesTile(int v) {
		if(is_valid_value(v))
			value = v;
		else
			throw new IllegalArgumentException("The value should be value is either 1, 2 or 3 * 2^i.");
	}
	
	
	public int getValue() {
		return value;
	}

	public void setValue(int v) {
		if(is_valid_value(v))
			value = v;
		else
			throw new IllegalArgumentException("The value should be value is either 1, 2 or 3 * 2^i.");
	}
	
	public void clear(){
		value = 0;
	}
	
	public void setRandomValue() {
		Random randomGenerator = new Random();
		randomGenerator.setSeed(System.currentTimeMillis());
	    int randomInt = randomGenerator.nextInt()%3;
	    value = randomInt+1;
	}

	public boolean is_valid_value (int v){
		//Returns true iff value is either 1, 2 or 3 * 2^i
		return (v==0) || (v==1) || (v==2) ||  (v>2 && (v%3==0) && is_power_of_two(v/3));
	}
	
	public boolean is_power_of_two (int v){
		if (v > 0) {
			boolean power_of_two = true;
			for (int i=v; (i <= 1 || !power_of_two); i=i%2){
				if (i % 2 != 0)
				power_of_two = false;
			
			}
			return power_of_two;
		}
		else
			return false;
	}
	
	public boolean isFree(){
		//Returns true iff the tail is free
		return (value==0);
	}
	
	public ThreesTile combine_tile(ThreesTile t){
		int v2 = t.getValue();
		if(is_valid_value(v2))
			return new ThreesTile(value+v2);
		else
			throw new IllegalArgumentException();
	}
	
	public String toString(){
		//Provides a string representation of the tail (shows its value as a string)
		return Integer.toString(value);
	}
}
