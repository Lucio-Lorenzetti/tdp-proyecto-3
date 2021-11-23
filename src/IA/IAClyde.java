package IA;

import CharacterElements.Ghost;
import Elements.Element;
import GameLogic.Cell;
import GameLogic.Game;
import Maps.Map;
import java.lang.Math;

/**
*
* Class IAClyde.
* 
* Defines the applicable operations of a IAClyde.
* 
* @author Agust�n Cuello, Guillermo Rodriguez, Lucio Lorenzetti.
*
*/
public class IAClyde extends GhostGPS{
	
	boolean runningAway;

	public IAClyde(Map m, Ghost ghost) {
		super(m, ghost);
		runningAway = false;
		myObjective = Game.getPacMan();
	}

	@Override
	public void buildRoute() {

	
		Cell objectiveCell = myMap.getCellByPosition(myObjective.getPosX(), myObjective.getPosY());
		Cell clydeCell = myMap.getCellByPosition(myGhost.getPosX(), myGhost.getPosY());
		
		int distanceX = clydeCell.getColumn() - objectiveCell.getColumn();
		int distanceY = clydeCell.getRow() - objectiveCell.getRow();
		
		if(Math.abs(distanceX) < 2 && Math.abs(distanceY) < 2) {
			runningAway = !runningAway;
		}
		
		if(runningAway) {
			myObjective = calculateObjectiveClyde( Game.getPacMan() );	
		} else {
			myObjective = calculateObjectiveClyde( myMap.getCell( myMap.getHeight()-1, 0 ) );
		}
		 
		shortestRouteToObjective();
	}
	
	private Element calculateObjectiveClyde(Element objective) {
		
		 
		
		Cell objectiveCell = myMap.getCellByPosition(objective.getPosX(), objective.getPosY());
		
		int max = 2;
		int min = -2;
		
		int displacementX = (int) ((Math.random() * (max - min)) + min);
		int displacementY = (int) ((Math.random() * (max - min)) + min);
		
		
		return myMap.getCell(objectiveCell.getRow() + displacementY, objectiveCell.getColumn() + displacementX);
	}

}
