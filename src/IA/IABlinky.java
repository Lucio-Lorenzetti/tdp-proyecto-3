package IA;

import CharacterElements.Ghost;
import CharacterElements.Role;
import GameLogic.Game;
import Maps.Map;
import GameLogic.Cell;
import GameLogic.Directions;
import java.util.HashMap;
import java.util.Map.Entry;

/**
*
* Class IABlinky.
* 
* Defines the applicable operations of a IABlinky.
* 
* @author Agustín Cuello, Guillermo Rodriguez, Lucio Lorenzetti.
*
*/
public class IABlinky extends AliveGhostGPS{

	public IABlinky(Game g, Ghost ghost) {
		super(g, ghost);
	}
	
	@Override
	public void buildRoute() {
		
		Role pacman = myGame.getPacMan();
		
		int pacmanX = pacman.getPosX();
		int pacmanY = pacman.getPosY();
		
		int myGhostX = myGhost.getPosX();
		int myGhostY = myGhost.getPosY();

		
		
		HashMap<Object, Cell> adjacentCells = myGame.getMap().getAdjacentCellsByPX(myGhostX, myGhostY); 
		
		
		
		int hypotenuse = 0;
		int minValue = Integer.MAX_VALUE;
		Object chosenDirection = null;
		
		for( Entry<Object, Cell> e : adjacentCells.entrySet()) {
			
			if(e.getValue().getWalkable()) {
				hypotenuse = calculateHypotenuse( e.getValue().getPosX(), e.getValue().getPosY(), pacmanX, pacmanY);
				
				//System.out.println(e.getKey() + " hypotenusa " + hypotenuse );
				
				if( minValue > hypotenuse ) {
					minValue = hypotenuse;
					chosenDirection = e.getKey();
				}
			}
			
		}
		
		
		if(chosenDirection == null) {
			chosenDirection = Directions.getNeutral();
		}
		
		myGhost.setNextDirection(chosenDirection);
		
		//System.out.println("CAMBIO DIRECCION LA IA");
		
		//System.out.println(chosenDirection == Directions.getNeutral());
		
		
	}
	
	/**
	* Calculate the hypotenuse between 2 points.
	* @param posCellX pos X of the hunter.
	* @param posCellY pos Y of the hunter.
	* @param posTargetX pos X of the target.
	* @param posTargetY pos Y of the target.
	* @return the hypotenuse between 2 points.
	*/
	private int calculateHypotenuse(int posCellX, int posCellY, int posTargetX, int posTargetY) {
		
		int distance = (int) Math.sqrt( Math.pow( (double) (posCellX - posTargetX), 2f  ) + Math.pow( (double) ( posCellY - posTargetY), 2f ) );
		
		return distance;
	}
	
}





		