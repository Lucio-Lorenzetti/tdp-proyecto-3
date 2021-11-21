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

	public IABlinky(Map m, Ghost ghost) {
		super(m, ghost);
	}
	
	@Override
	public void buildRoute() {
		
		myObjective = Game.getPacMan();
		
		shortestRouteToObjective();
		
	}
	
	
	
	
	
	
}





		