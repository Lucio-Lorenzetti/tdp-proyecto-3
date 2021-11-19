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
public class MapBonus extends Map {
    

    /**
     * Creates and initializes Map.
     */
    public MapBonus(Game g, int cellHeightPX, int cellWidthPX){
    	
    	super(g, cellHeightPX, cellWidthPX, "src/Maps/MapBonusRoad.txt","src/Maps/MapBonusPikeable.txt" , "src/Maps/MapBonusRole.txt");
	}
}
