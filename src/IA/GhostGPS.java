package IA;

import CharacterElements.Ghost;
import Maps.Map;

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
	
	protected Map myMap;
	protected Ghost myGhost;
	protected GhostGPS myIA;
	
	public GhostGPS(Map m, Ghost ghost) {
		myMap = m;
		myGhost = ghost;
	}
	
	public abstract void buildRoute();
	
	public void setMap(Map m) {
		myMap = m;
	}
	
}
