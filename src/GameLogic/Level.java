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
	
	public Level(Game g) {
	
		myGame = g;
		
		Factories = new LinkedList<MapFactory>();
		
		Factories.add(new MapFactoryA());
		Factories.add(new MapFactoryB());
		Factories.add(new MapFactoryC());
		Factories.add(new MapFactoryBonus());

		cantFactories = Factories.size();
		
		levelNumber = 0;
		
		System.out.println("Constructor level");
			
	}
	
	public void passLevel(int cellHeightPX, int cellWidthPX) {
		changeMap(cellHeightPX, cellWidthPX);
		levelNumber++;
		System.out.println("PassLevel");
	}
	
	private void changeMap(int cellHeightPX, int cellWidthPX) {
	
		Map newMap = Factories.get( levelNumber % cantFactories ).CreateMap(myGame, cellHeightPX, cellWidthPX);
		
		myGame.setMap(newMap);
	
		System.out.println("ChangeMap");
	}
	

}
