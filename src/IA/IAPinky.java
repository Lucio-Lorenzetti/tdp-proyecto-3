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
		
		myObjective = calculateObjectivePinky(Game.getPacMan());
		
		shortestRouteToObjective();
		
	}

	private Element calculateObjectivePinky(Role p){
		
		Cell nextObj = null;
		
		int pacmanPosX = p.getPosX();
		int pacmanPosY = p.getPosY();
		
		int posRow = myMap.getCellByPosition(pacmanPosX, pacmanPosY).getRow();
		int posColumn = myMap.getCellByPosition(pacmanPosX, pacmanPosY).getColumn();
		
		if(p.getActualDirection() == Directions.getUp()){
			posRow -= 4;
			posColumn -= 4;
		} else
		if(p.getActualDirection() == Directions.getDown()){
			posRow += 4;
		} else
		if(p.getActualDirection() == Directions.getRight()){
			posColumn += 4;
		} else
		if(p.getActualDirection() == Directions.getLeft()){
			posColumn -= 4;
		} 
		if(myMap.getCell(posRow, posColumn) != null) {
			nextObj = myMap.getCell(posRow, posColumn);
		}
		
		return nextObj;
	}
	
}
