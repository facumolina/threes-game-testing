package threes;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Test;
import org.junit.Before;

import static org.easymock.EasyMock.*;

public class SaveGameTests {

	private ISaveManager saveManager;
	ThreesBoard board;
	
	private static String FOLDER_NAME = "folder";
	private static String INCORRECT_FOLDER_NAME = ".";
	private static String CORRECT_FILE_NAME = "file";
	private static String INCORRECT_FILE_NAME = "file.t";
	
	@Before
	public void setUp() {
		board = new ThreesBoard();
		saveManager = createMock(ISaveManager.class);
		try {
			expect(saveManager.setFolder(FOLDER_NAME)).andReturn(true);
			expect(saveManager.setFolder(INCORRECT_FOLDER_NAME)).andThrow(new IOException());
			expect(saveManager.saveToFile(board, 1, CORRECT_FILE_NAME + ".ths")).andReturn(true);
			expect(saveManager.saveToFile(board, 2, CORRECT_FILE_NAME + ".ths")).andReturn(true);
			expect(saveManager.saveToFile(board, 3, CORRECT_FILE_NAME + ".ths")).andReturn(true);
			replay(saveManager);
		} catch(IOException e) {
			
		}
	}
	
	@Test
	public void testSaveGameSuccesfull() {
		ThreesController controller = new ThreesController(board);
		controller.setSaveManager(saveManager);
		assertTrue(controller.saveGame(FOLDER_NAME, CORRECT_FILE_NAME));
	}
	
	@Test
	public void testSaveGameIncorrectFileName() {
		ThreesController controller = new ThreesController(board);
		controller.setSaveManager(saveManager);
		assertTrue(!controller.saveGame(FOLDER_NAME, INCORRECT_FILE_NAME));
	}
	
	@Test
	public void testSaveGameIOException() {
		ThreesController controller = new ThreesController(board);
		controller.setSaveManager(saveManager);
		assertTrue(!controller.saveGame(INCORRECT_FOLDER_NAME, CORRECT_FILE_NAME));
	}
	
}
