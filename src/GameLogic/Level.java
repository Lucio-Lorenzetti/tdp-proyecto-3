package GameLogic;

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
	
	private MapFactory[] Factories;
	private int cantFactories;
	
	private int levelNumber;
	
	
	
	private Game myGame;
	
	public Level(Game g) {
	
		myGame = g;
		
		cantFactories = 3;
		
		Factories = new MapFactory[cantFactories];
		
		Factories[0] = new MapFactoryA();
		Factories[1] = new MapFactoryB();
		Factories[2] = new MapFactoryC();
	
		levelNumber = 0;
		System.out.println("Constructor level");
			
	}
	
	public void passLevel(int cellHeightPX, int cellWidthPX) {
		changeMap(cellHeightPX, cellWidthPX);
		levelNumber++;
		System.out.println("PassLevel");
	}
	
	private void changeMap(int cellHeightPX, int cellWidthPX) {
	
		Map newMap = Factories[levelNumber % cantFactories].CreateMap(myGame, cellHeightPX, cellWidthPX);
		
		myGame.setMap(newMap);
	
		System.out.println("ChangeMap");
	}
	

}
