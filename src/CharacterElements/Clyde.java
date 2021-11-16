package CharacterElements;
import GUI.GraphicEntity;
import GameLogic.Directions;
import Images.ResourceManager;
import Visitor.*;
/**
*
* Class Clyde.
* 
* Defines the applicable operations of a Clyde.
* 
* @author Agustín Cuello, Guillermo Rodriguez, Lucio Lorenzetti.
*
*/
public class Clyde extends Ghost{
    
    /**
    * Creates and initialize a Clyde;
    * @param posY where the Clyde is created.
    * @param posX where the Clyde is created.
    * @param width of Clyde in pixels.
    * @param height of Clyde in pixels.
    * @param dead true if Clyde is dead, false otherwise. 
    * @param moving true if Clyde is moving, false otherwise.
    */
    public Clyde(int posY, int posX, int width, int height, boolean dead, boolean moving){
        super(posY, posX, width, height, dead, moving);
        myVisitor = new VisitorBlinky(this);
        
        myGraphicEntity = new GraphicEntity(ResourceManager.getProvider().getClydeImages()[1]);
    
    }


	@Override
	protected void doOnDirectionChange() {
		if(nextDirection == Directions.getNeutral()) {
    		myGraphicEntity.setIcon( ResourceManager.getProvider().getClydeImages()[0] );
    	}
    	if(nextDirection == Directions.getLeft()) {
    		myGraphicEntity.setIcon( ResourceManager.getProvider().getClydeImages()[1] );
    	}
    	if(nextDirection == Directions.getUp()) {
    		myGraphicEntity.setIcon( ResourceManager.getProvider().getClydeImages()[2] );
    	}
    	if(nextDirection == Directions.getRight()) {
    		myGraphicEntity.setIcon( ResourceManager.getProvider().getClydeImages()[3] );
    	}
    	if(nextDirection == Directions.getDown()) {
    		myGraphicEntity.setIcon( ResourceManager.getProvider().getClydeImages()[4] );
    	}
	}

    @Override
    public void accept(VisitorPacMan c){

    }
}
