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
    	
    	super(g, cellHeightPX, cellWidthPX, "src/Maps/MapA.txt");
    	
	}
}
    

