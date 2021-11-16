package IA;

import CharacterElements.Ghost;
import GameLogic.Game;

/**
*
* Class AliveGhostGPS.
* 
* Defines the applicable operations of a AliveGhostGPS.
* 
* @author Agustín Cuello, Guillermo Rodriguez, Lucio Lorenzetti.
*
*/
public abstract class AliveGhostGPS extends GhostGPS {

	public AliveGhostGPS(Game g, Ghost ghost) {
		super(g, ghost);
	}
	
}