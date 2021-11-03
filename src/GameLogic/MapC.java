package GameLogic;

import PickeableElements.*;

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
	 public MapC(Game g){
	    	
	    	super(g);
	   
	    	
	    	Cell RoadPacdot = new Cell(0, 0, new PacDot(), true, 0);
	    	Cell RoadPowerPellet = new Cell(0, 0, new PacDot(), true, 0);
	    	Cell RoadFruit = new Cell(0, 0, new PacDot(), true, 0);
	    	Cell RoadBombPotion = new Cell(0, 0, new PacDot(), true, 0);
	    	Cell RoadSpeedPotion = new Cell(0, 0, new PacDot(), true, 0);
	    	
	    	Cell RoadEmpty = new Cell(0, 0, null, true, 0);
	    	
	    	Cell GhostHome = new Cell(0, 0, null, true, 0);
	    	
	    	Cell horizontalWall= new Cell(0, 0, null, false, 1);
	    
	    
	    
	}

    
}
