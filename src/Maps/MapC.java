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
public class MapC extends Map{
    

    /**
     * Creates and initializes Map.
     */
	 public MapC(Game g, int cellHeightPX, int cellWidthPX){
    	
    	super(g, cellHeightPX, cellWidthPX, "src/Maps/MapCRoad.txt", "src/Maps/MapCPikeable.txt", "src/Maps/MapCRole.txt", 12,12);
    }

    
}
