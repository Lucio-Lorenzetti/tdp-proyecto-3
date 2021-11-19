package Maps;

import GameLogic.Game;

/**
 *
 * Class Map.
 * 
 * Defines the applicable operations of a Map.
 * 
 * @author Agustín Cuello, Guillermo Rodriguez, Lucio Lorenzetti.
 *
 */
public class MapB extends Map {

	/**
	 * Creates and initializes Map.
	 */
	public MapB(Game g, int cellHeightPX, int cellWidthPX) {
    	
    	super(g, cellHeightPX, cellWidthPX, "src/Maps/MapBRoad.txt", "src/Maps/MapBPikeable.txt", "src/Maps/MapBRole.txt");
	}	
	
}