package IA;

import CharacterElements.Ghost;
import GameLogic.Game;

/**
*
* Class GhostGPS.
* 
* Defines the applicable operations of a GhostGPS.
* 
* @author Agustín Cuello, Guillermo Rodriguez, Lucio Lorenzetti.
*
*/
public abstract class GhostGPS {
	
	protected Game myGame;
	protected Ghost myGhost;
	protected GhostGPS myIA;
	
	public GhostGPS(Game g, Ghost ghost) {
		myGame = g;
		myGhost = ghost;
	}
	
	public abstract void buildRoute();
	
}
