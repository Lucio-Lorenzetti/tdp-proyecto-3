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
public class MapA extends Map {
    

    /**
     * Creates and initializes Map.
     */
    public MapA(Game g, int cellHeightPX, int cellWidthPX){
    	
    	super(g, cellHeightPX, cellWidthPX, "src/Maps/MapARoad.txt", "src/Maps/MapAPickeable.txt", "src/Maps/MapRole.txt", 12, 12);
    	
	}
}
    

