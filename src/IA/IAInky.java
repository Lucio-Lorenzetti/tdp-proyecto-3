package IA;

import CharacterElements.Ghost;
import CharacterElements.Role;
import Elements.Element;
import GameLogic.Cell;
import GameLogic.Game;
import Maps.Map;

/**
*
* Class IA.
* 
* Defines the applicable operations of a IA.
* 
* @author Agustín Cuello, Guillermo Rodriguez, Lucio Lorenzetti.
*
*/
public class IAInky extends AliveGhostGPS{

    public IAInky(Map m, Ghost ghost) {
		super(m, ghost);
	}
	
	@Override
	public void buildRoute() {
		
		myObjective = calculateInkyRoute(Game.getPacMan(), Game.getBlinky());
		
		shortestRouteToObjective();
		
	}

    private Element calculateInkyRoute(Element PacMan, Element blinky){
        
    	Cell PacManCell = myMap.getCellByPosition(PacMan.getPosX(), PacMan.getPosY());
    	Cell BlinkyCell = myMap.getCellByPosition(blinky.getPosX(), blinky.getPosY());
    	
    	int differenceX = PacManCell.getColumn() - BlinkyCell.getColumn(); 
    	int differenceY = PacManCell.getRow() - BlinkyCell.getRow();
    	
    	int posObjectiveCol = PacManCell.getColumn() - differenceX;
    	int posObjectiveRow = PacManCell.getRow() - differenceY;
    	
    			
    	
        return myMap.getCell(posObjectiveRow, posObjectiveCol);
        
    }

}
