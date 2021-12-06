package IA;

import java.util.LinkedList;

import CharacterElements.Ghost;
import GameLogic.Cell;
import Maps.Map;

public class NeutralGhostGPS extends AliveGhostGPS{

	public NeutralGhostGPS(Map m, Ghost ghost) {
		super(m, ghost);
	}
	
	public void setObjective() {
		
	}

	@Override
	public void buildRoute() {
	
		if(myObjective == null) {
			//Selects a random objective from the corners of the map upon being created 
			LinkedList<Cell> possibleObjectives = myMap.getCorners();
	
			int objectiveSelection = (int) Math.random() * (possibleObjectives.size()-1);
	
			if(objectiveSelection < 0) {
				objectiveSelection = 0;
			}
			
			myObjective = possibleObjectives.get(objectiveSelection);
		}
		
		shortestRouteToObjective();		
		
	}

}
