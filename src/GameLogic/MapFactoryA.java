package GameLogic;

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
	public Map CreateMap(Game g) {
		
		Map newMap = new MapA(g);
		
		return newMap;
	}

}
