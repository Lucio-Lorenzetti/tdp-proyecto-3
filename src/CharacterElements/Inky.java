package CharacterElements;
import GUI.GraphicEntity;
import GameLogic.Directions;
import Images.ResourceManager;
import Visitor.*;
/**
*
* Class Inky.
* 
* Defines the applicable operations of a Inky.
* 
* @author Agustín Cuello, Guillermo Rodriguez, Lucio Lorenzetti.
*
*/
public class Inky extends Ghost{
    
     /**
    * Creates and initialize a Inky;
    * @param posY where the Inky is created.
    * @param posX where the Inky is created.
    * @param width of Inky in pixels.
    * @param height of Inky in pixels.
    * @param dead true if Inky is dead, false otherwise. 
    * @param moving true if Inky is moving, false otherwise.
    */
    public Inky(int posY, int posX, int width, int height, boolean dead, boolean moving){
        super(posY, posX, width, height, dead, moving);
        myVisitor = new VisitorBlinky(this);
        
        myGraphicEntity = new GraphicEntity(ResourceManager.getProvider().getInkyImages()[1]);
    }

	@Override
	protected void doOnDirectionChange() {
		if(nextDirection == Directions.getNeutral()) {
    		myGraphicEntity.setIcon( ResourceManager.getProvider().getInkyImages()[0] );
    	}
    	if(nextDirection == Directions.getLeft()) {
    		myGraphicEntity.setIcon( ResourceManager.getProvider().getInkyImages()[1] );
    	}
    	if(nextDirection == Directions.getUp()) {
    		myGraphicEntity.setIcon( ResourceManager.getProvider().getInkyImages()[2] );
    	}
    	if(nextDirection == Directions.getRight()) {
    		myGraphicEntity.setIcon( ResourceManager.getProvider().getInkyImages()[3] );
    	}
    	if(nextDirection == Directions.getDown()) {
    		myGraphicEntity.setIcon( ResourceManager.getProvider().getInkyImages()[4] );
    	}
	}

    @Override
    public void accept(VisitorPacMan c){

    }
     
}