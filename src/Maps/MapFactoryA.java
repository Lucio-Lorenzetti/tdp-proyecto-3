package Maps;

import GameLogic.Game;

/**
 *
 * Class MapFactoryA.
 * 
 * Defines the applicable operations of a MapFactoryA.
 * 
 * @author Agustín Cuello, Guillermo Rodriguez, Lucio Lorenzetti.
 *
 */
public class MapFactoryA extends MapFactory{

	@Override
	public Map CreateMap(Game g, int cellHeightPX, int cellWidthPX) {
		
		Map newMap = new MapA(g, cellHeightPX, cellWidthPX);
		
		return newMap;
	}

}
