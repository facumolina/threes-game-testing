package threes;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.AbstractMap;
import java.util.Map;

import org.junit.Test;
import org.junit.Before;

import static org.easymock.EasyMock.*;

public class LoadGameTests {

	private ISaveManager saveManager;
	ThreesBoard board;
	
	private static String FOLDER_NAME = "folder";
	private static String FILE_NAME = "file";
	private static String NONEXISTENT_FILE_NAME = "file1";
	
	@Before
	public void setUp() {
		board = new ThreesBoard();
		saveManager = createMock(ISaveManager.class);
		try {
			expect(saveManager.setFolder(FOLDER_NAME)).andReturn(true);
			expect(saveManager.setFolder(FOLDER_NAME)).andReturn(true);
			expect(saveManager.saveToFile(board, 1, FILE_NAME + ".ths")).andReturn(true);
			expect(saveManager.saveToFile(board, 2, FILE_NAME + ".ths")).andReturn(true);
			expect(saveManager.saveToFile(board, 3, FILE_NAME + ".ths")).andReturn(true);
			
			
			Map.Entry<ThreesBoard, Integer> map1 = new AbstractMap.SimpleEntry<ThreesBoard,Integer>(board,1);
			expect(saveManager.loadFromFile(FILE_NAME+".ths")).andReturn(map1);
			Map.Entry<ThreesBoard, Integer> map2 = new AbstractMap.SimpleEntry<ThreesBoard,Integer>(board,2);
			expect(saveManager.loadFromFile(FILE_NAME+".ths")).andReturn(map2);
			Map.Entry<ThreesBoard, Integer> map3 = new AbstractMap.SimpleEntry<ThreesBoard,Integer>(board,3);
			expect(saveManager.loadFromFile(FILE_NAME+".ths")).andReturn(map3);

			expect(saveManager.loadFromFile(NONEXISTENT_FILE_NAME+".ths")).andReturn(null);
			replay(saveManager);
		} catch(IOException e) {
			
		}
	}
	
	@Test
	public void testLoadGameSuccesfull() {
		ThreesController controller = new ThreesController(board);
		controller.setSaveManager(saveManager);
		controller.saveGame(FOLDER_NAME, FILE_NAME);
		assertTrue(controller.loadGame(FOLDER_NAME, FILE_NAME+".ths"));
	}
	
	@Test
	public void testLoadGameInvalidFileName() {
		ThreesController controller = new ThreesController(board);
		controller.setSaveManager(saveManager);
		controller.saveGame(FOLDER_NAME, FILE_NAME);
		assertTrue(!controller.loadGame(FOLDER_NAME,FILE_NAME+".th" ));
	}
	
	@Test
	public void testLoadGameNonExistentFileName() {
		ThreesController controller = new ThreesController(board);
		controller.setSaveManager(saveManager);
		controller.saveGame(FOLDER_NAME, FILE_NAME);
		assertTrue(!controller.loadGame(FOLDER_NAME,NONEXISTENT_FILE_NAME+".ths" ));
	}
	
	
}

