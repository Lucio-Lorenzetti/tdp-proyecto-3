package IA;

import CharacterElements.Ghost;
import CharacterElements.Role;
import Elements.Element;
import GameLogic.Directions;
import GameLogic.Game;
import Maps.Map;

/**
*
* Class IAPinky.
* 
* Defines the applicable operations of a IAPinky.
* 
* @author Agustín Cuello, Guillermo Rodriguez, Lucio Lorenzetti.
*
*/
public class IAPinky extends AliveGhostGPS {

	public IAPinky(Map m, Ghost ghost) {
		super(m, ghost);
	}
	
	@Override
	public void buildRoute() {
		
		myObjective = calculoObjetivoInky(Game.getPacMan());
		
		shortestRouteToObjective();
		
	}

	private Element calculoObjetivoInky(Role p){
		
		if(p.getActualDirection() == Directions.getDown()){
			
		}
		if(p.getActualDirection() == Directions.getRight()){
			
		}
		if(p.getActualDirection() == Directions.getLeft()){

		}
		if(p.getActualDirection() == Directions.getUp()){
			
		}
		return null;
	}
	
}
