package GameLogic;

/**
 *
 * Class MapFactory.
 * 
 * Defines the applicable operations of a MapFactory.
 * 
 * @author Agustín Cuello, Guillermo Rodriguez, Lucio Lorenzetti.
 *
 */
public abstract class MapFactory {

    /**
    *
    * @param g
    */
   public abstract Map CreateMap(Game g, int cellHeightPX, int cellWidthPX);

}
