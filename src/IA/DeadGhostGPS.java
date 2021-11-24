package IA;

import java.util.LinkedList;

import CharacterElements.Ghost;
import Elements.Element;
import GameLogic.Cell;
import Maps.Map;

public class DeadGhostGPS extends GhostGPS{

	
	
	public DeadGhostGPS(Map m, Ghost ghost) {
		super(m, ghost);
	}
	
	public DeadGhostGPS(Ghost g) {
		super(null,g);
	}
	
	@Override
	public void buildRoute() {
		
		
		
		if(myObjective == null) { //If the dead ghost has no objective, selects a random one from the list of ghost homes.
			
			LinkedList<Cell> possibleObjectiveList = myMap.getGhostHome();
			
			int objectiveSelection = (int) (java.lang.System.currentTimeMillis() % possibleObjectiveList.size());
			
			setObjective( possibleObjectiveList.get(objectiveSelection) );

		} else {	//If the dead ghost has an objective (A ghost home) check if it can revive

			myGhost.reviveCheck(myObjective);
			
		}

		shortestRouteToObjective();
		
		
	}

	
	
}
