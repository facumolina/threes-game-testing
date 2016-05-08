package threes;

import java.io.IOException;
import java.util.Map;

public interface ISaveManager {

    boolean setFolder(String folderName) throws IOException;
    
    boolean saveToFile(ThreesBoard b, int nextTile, String fileName) throws IOException;
    
    Map.Entry<ThreesBoard, Integer> loadFromFile(String fileName) throws IOException;

}
