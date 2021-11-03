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
	public Map CreateMap(Game g) {
		
		Map newMap = new MapC(g);
		
		return newMap;
	}

}
