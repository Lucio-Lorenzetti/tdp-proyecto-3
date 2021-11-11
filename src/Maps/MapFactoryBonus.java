package Maps;

import GameLogic.Game;

/**
 *
 * Class MapFactoryBonus.
 * 
 * Defines the applicable operations of a MapFactoryB.
 * 
 * @author Agustín Cuello, Guillermo Rodriguez, Lucio Lorenzetti.
 *
 */

public class MapFactoryBonus extends MapFactory{

	@Override
	public Map CreateMap(Game g, int cellHeightPX, int cellWidthPX) {

		Map newMap = new MapBonus(g, cellHeightPX, cellWidthPX);

		return newMap;
	}

}