package GameLogic;

import Maps.Map;
import Maps.MapFactory;
import Maps.MapFactoryA;
import Maps.MapFactoryB;
import Maps.MapFactoryC;
import Maps.MapFactoryBonus;

import java.util.LinkedList;

/**
 *
 * Class Level.
 * 
 * Defines the applicable operations of the level.
 * 
 * @author Agustín Cuello, Guillermo Rodriguez, Lucio Lorenzetti.
 *
 */
public class Level {
	
	private LinkedList<MapFactory> Factories;
	private int cantFactories;
	
	private int levelNumber;
	
	private Game myGame;
	
	/**
	 * Create and initialize a Level.
	 * @param g Game to be modified by the level object.
	 */
	public Level(Game g) {
	
		myGame = g;
		
		Factories = new LinkedList<MapFactory>();
		
		Factories.add(new MapFactoryA());
		Factories.add(new MapFactoryB());
		Factories.add(new MapFactoryC());

		cantFactories = Factories.size();
		
		levelNumber = 0;
		
		System.out.println("Constructor level");
			
	}
	
	/**
	 * Changes the current level to the next.
	 * @param cellHeightPX height of the map's cells.
	 * @param cellWidthPX width of the map's cells.
	 */
	public void passLevel(int cellHeightPX, int cellWidthPX) {
		myGame.endGame();
		changeMap(cellHeightPX, cellWidthPX);
		levelNumber++;
		myGame.startGame();
		System.out.println("PassLevel");
		
	}
	
	/**
	 * Changes the current map to the next.
	 * @param cellHeightPX height of the map's cells.
	 * @param cellWidthPX width of the map's cells.
	 */
	private void changeMap(int cellHeightPX, int cellWidthPX) {
	
		Map newMap = Factories.get( levelNumber % cantFactories ).CreateMap(myGame, cellHeightPX, cellWidthPX);
		
		myGame.setMap(newMap);
	
		System.out.println("ChangeMap");
	}
	

}
