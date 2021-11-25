package GameLogic;

import Maps.Map;
import Maps.MapFactory;
import Maps.MapFactoryA;
import Maps.MapFactoryB;
import Maps.MapFactoryC;

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
	private int widthOfCell;
	private int heightOfCell;
	
	/**
	 * Create and initialize a Level.
	 * @param g Game to be modified by the level object.
	 */
	public Level(Game g, int cellHeight, int cellWidth) {
	
		widthOfCell = cellWidth;
		heightOfCell = cellHeight;
		
		
		myGame = g;
		
		Factories = new LinkedList<MapFactory>();
		
		Factories.add(new MapFactoryA());
		Factories.add(new MapFactoryB());
		Factories.add(new MapFactoryC());

		cantFactories = Factories.size();
		
		levelNumber = 0;
			
	}
	
	/**
	 * Changes the current level to the next.
	 * @param cellHeightPX height of the map's cells.
	 * @param cellWidthPX width of the map's cells.
	 */
	public void passLevel() {
		
		changeMap();
		levelNumber++;	
	}
	
	
	public int getGhostDelay() {
		
		int minDelay = 50;
		int startDelay = 75;
		
		int ghostDelay = startDelay - 5 * levelNumber;
		
		if(ghostDelay <= minDelay) {
			ghostDelay = minDelay;
		}
		
		return ghostDelay;
	}
	
	
	/**
	 * Changes the current map to the next.
	 * @param cellHeightPX height of the map's cells.
	 * @param cellWidthPX width of the map's cells.
	 */
	public void changeMap() {
		myGame.pauseGame();
	
		Map newMap = Factories.get( levelNumber % cantFactories ).CreateMap(myGame, heightOfCell, widthOfCell);
		
		myGame.setMap(newMap);
	
		myGame.startGame();
	}
	
	
	
	
	

}
