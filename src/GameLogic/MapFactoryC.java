package GameLogic;

/**
 *
 * Class MapFactoryC.
 * 
 * Defines the applicable operations of a MapFactoryC.
 * 
 * @author Agustín Cuello, Guillermo Rodriguez, Lucio Lorenzetti.
 *
 */
public class MapFactoryC extends MapFactory{

	@Override
	public Map CreateMap(Game g, int cellHeightPX, int cellWidthPX) {
		
		Map newMap = new MapC(g, cellHeightPX, cellWidthPX);
		
		return newMap;
	}

}
