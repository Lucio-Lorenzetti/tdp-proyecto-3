package IA;

import java.util.HashMap;
import java.util.Map.Entry;

import CharacterElements.Ghost;
import Elements.Element;
import GameLogic.Cell;
import GameLogic.Directions;
import Maps.Map;
import java.lang.Math;

/**
*
* Class GhostGPS.
* 
* Defines the applicable operations of a GhostGPS.
* 
* @author Agust�n Cuello, Guillermo Rodriguez, Lucio Lorenzetti.
*
*/
public abstract class GhostGPS {
	
	protected Map myMap;
	protected Ghost myGhost;
	protected GhostGPS myIA;
	protected Element myObjective;
	
	public GhostGPS(Map m, Ghost ghost) {
		myMap = m;
		myGhost = ghost;
	}
	
	public abstract void buildRoute();
	
	public void setMap(Map m) {
		myMap = m;
	}
	
	public void setObjective(Element e) {
		myObjective = e;
	}
	
	public void resetObjective() {
		myObjective = null;
	}
	
	protected void shortestRouteToObjective() {
		
		
		int objectiveX = myObjective.getPosX();
		int objectiveY = myObjective.getPosY();
		
		int myGhostX = myGhost.getPosX();
		int myGhostY = myGhost.getPosY();

		
		HashMap<Object, Cell> adjacentCells = myMap.getAdjacentCellsByPX(myGhostX, myGhostY); 
		
		adjacentCells.remove(Directions.getOpposite(myGhost.getActualDirection()));
		

		int hypotenuse = 0;
		int minValue = Integer.MAX_VALUE;
		Object chosenDirection = Directions.getNeutral();
		
		for( Entry<Object, Cell> e : adjacentCells.entrySet()) {
			
			if(e.getValue().getWalkable()) {
				hypotenuse = calculateHypotenuse( e.getValue().getPosX(), e.getValue().getPosY(), objectiveX, objectiveY);
				
				if( minValue > hypotenuse ) {
					minValue = hypotenuse;
					chosenDirection = e.getKey();
				}
			}
		}
		
		myGhost.setNextDirection(chosenDirection);
	}
	
	/**
	* Calculate the hypotenuse between 2 points.
	* @param posCellX pos X of the hunter.
	* @param posCellY pos Y of the hunter.
	* @param posTargetX pos X of the target.
	* @param posTargetY pos Y of the target.
	* @return the hypotenuse between 2 points.
	*/
	protected int calculateHypotenuse(int posCellX, int posCellY, int posTargetX, int posTargetY) {
		
		int distance = (int) Math.sqrt( Math.pow( (double) (posCellX - posTargetX), 2f  ) + Math.pow( (double) ( posCellY - posTargetY), 2f ) );
		
		return distance;
	}
	
}
