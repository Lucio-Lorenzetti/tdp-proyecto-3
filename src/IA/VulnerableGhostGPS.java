package IA;

import java.util.HashMap;
import java.util.Map.Entry;
import java.util.LinkedList;

import CharacterElements.Ghost;
import CharacterElements.Role;
import GameLogic.Cell;
import GameLogic.Directions;
import GameLogic.Game;

/**
*
* Class VulnerableGhostGPS.
* 
* Defines the applicable operations of a VulnerableGhostGPS.
* 
* @author Agustín Cuello, Guillermo Rodriguez, Lucio Lorenzetti.
*
*/
public class VulnerableGhostGPS extends GhostGPS {

	public VulnerableGhostGPS(Game g, Ghost ghost) {
		
		super(g, ghost);
		
		
		
	}

	@Override
	public void buildRoute() {
		
Role pacman = myGame.getPacMan();
		
		int myGhostX = myGhost.getPosX();
		int myGhostY = myGhost.getPosY();

		
		
		HashMap<Object, Cell> adjacentCells = myGame.getMap().getAdjacentCellsByPX(myGhostX, myGhostY); 
		
		
		LinkedList<Cell> walkableCells = new LinkedList<Cell>();

		Object chosenDirection = null;
		
		for( Entry<Object, Cell> e : adjacentCells.entrySet()) {
			
			if(e.getValue().getWalkable()) {
				walkableCells.add(e.getValue());
			}
			
		}
		
		int directionSelection = (int) (java.lang.System.currentTimeMillis() % walkableCells.size());
		
		chosenDirection = walkableCells.get(directionSelection);
		
		
		
		if(chosenDirection == null) {
			chosenDirection = Directions.getNeutral();
		}
		
		System.out.println("a");
		
		myGhost.setNextDirection(chosenDirection);
	}
	
}
