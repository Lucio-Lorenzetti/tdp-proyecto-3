package CharacterElements;
import GUI.GraphicEntity;
import GameLogic.Directions;
import GameLogic.Game;
import Images.ResourceManager;
import Visitor.*;
import Maps.Map;

/**
*
* Class Pinky.
* 
* Defines the applicable operations of a Pinky.
* 
* @author Agustín Cuello, Guillermo Rodriguez, Lucio Lorenzetti.
*
*/
public class Pinky extends Ghost{
    
     /**
    * Creates and initialize a Pinky;
    * @param posY where the Pinky is created.
    * @param posX where the Pinky is created.
    * @param width of Pinky in pixels.
    * @param height of Pinky in pixels.
    * @param dead true if Pinky is dead, false otherwise. 
    * @param moving true if Pinky is moving, false otherwise.
    */
    public Pinky(int posY, int posX, int width, int height, boolean dead, boolean moving, Map m){
        super(posY, posX, width, height, dead, moving, m);
        myVisitor = new VisitorBlinky(this);
        
        myGraphicEntity = new GraphicEntity(ResourceManager.getProvider().getPinkyImages()[1]);
    }


	@Override
	protected void doOnDirectionChange() {
		if(nextDirection == Directions.getNeutral()) {
    		myGraphicEntity.setIcon( ResourceManager.getProvider().getPinkyImages()[0] );
    	}
    	if(nextDirection == Directions.getLeft()) {
    		myGraphicEntity.setIcon( ResourceManager.getProvider().getPinkyImages()[1] );
    	}
    	if(nextDirection == Directions.getUp()) {
    		myGraphicEntity.setIcon( ResourceManager.getProvider().getPinkyImages()[2] );
    	}
    	if(nextDirection == Directions.getRight()) {
    		myGraphicEntity.setIcon( ResourceManager.getProvider().getPinkyImages()[3] );
    	}
    	if(nextDirection == Directions.getDown()) {
    		myGraphicEntity.setIcon( ResourceManager.getProvider().getPinkyImages()[4] );
    	}
	}

    @Override
    public void accept(VisitorPacMan c){

    }


	@Override
	public void updateGraphics(Object d) {
		// TODO Auto-generated method stub
		
	}
}
