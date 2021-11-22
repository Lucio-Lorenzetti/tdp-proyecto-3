package IA;

import CharacterElements.Ghost;
import CharacterElements.Role;
import Elements.Element;
import GameLogic.Cell;
import GameLogic.Directions;
import GameLogic.Game;
import Maps.Map;

/**
*
* Class IAPinky.
* 
* Defines the applicable operations of a IAPinky.
* 
* @author Agust�n Cuello, Guillermo Rodriguez, Lucio Lorenzetti.
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
		
		Cell nextObj = null;
		
		int pacmanPosX = p.getPosX();
		int pacmanPosY = p.getPosY();
		
		int posXAux = pacmanPosX;
		int posYAux = pacmanPosY;
		
		if(p.getActualDirection() == Directions.getUp()){
			posXAux -= 4;
			posYAux -= 4;
		}
		if(p.getActualDirection() == Directions.getDown()){
			posYAux += 4;
		}
		if(p.getActualDirection() == Directions.getRight()){
			posXAux += 4;
		}
		if(p.getActualDirection() == Directions.getLeft()){
			posXAux -= 4;
		}
		if(myMap.getCell(posXAux, posYAux) != null) {
			nextObj = myMap.getCell(posXAux, posYAux);
		}
		
		return nextObj;
	}
	
}
