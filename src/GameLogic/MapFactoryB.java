package GameLogic;

/**
 *
 * Class MapFactoryB.
 * 
 * Defines the applicable operations of a MapFactoryB.
 * 
 * @author Agustín Cuello, Guillermo Rodriguez, Lucio Lorenzetti.
 *
 */

public class MapFactoryB extends MapFactory{

	@Override
	public Map CreateMap(Game g, int cellHeightPX, int cellWidthPX) {

		Map newMap = new MapB(g, cellHeightPX, cellWidthPX);

		return newMap;
	}

}
