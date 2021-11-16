package CharacterElements;
import GUI.GraphicEntity;
import GameLogic.Directions;
import GameLogic.Game;
import Images.ResourceManager;
import Visitor.*;
import IA.IABlinky;

/**
*
* Class Blinky.
* 
* Defines the applicable operations of a Blinky.
* 
* @author Agustín Cuello, Guillermo Rodriguez, Lucio Lorenzetti.
*
*/
public class Blinky extends Ghost{
    /**
    * Creates and initialize a Blinky;
    * @param posY where the Blinky is created.
    * @param posX where the Blinky is created.
    * @param width of Blinky in pixels.
    * @param height of Blinky in pixels.
    * @param dead true if Blinky is dead, false otherwise. 
    * @param moving true if Blinky is moving, false otherwise.
    */
    public Blinky(int posY, int posX, int width, int height, boolean dead, boolean moving, Game game){
        super(posY, posX, width, height, dead, moving);
        
        myVisitor = new VisitorBlinky(this);
        
        myIA = new IABlinky(game, this);
        
        
        myGraphicEntity = new GraphicEntity(ResourceManager.getProvider().getBlinkyImages()[1]);
    }

	@Override
	protected void doOnDirectionChange() {
    	updateGraphics(nextDirection);
    }

	public void updateGraphics(Object direction) {
		if(!scared) {
	    	if(direction == Directions.getNeutral()) {
	    		myGraphicEntity.setIcon( ResourceManager.getProvider().getBlinkyImages()[0] );
	    	}
	    	if(direction == Directions.getLeft()) {
	    		myGraphicEntity.setIcon( ResourceManager.getProvider().getBlinkyImages()[1] );
	    	}
	    	if(direction == Directions.getUp()) {
	    		myGraphicEntity.setIcon( ResourceManager.getProvider().getBlinkyImages()[2] );
	    	}
	    	if(direction == Directions.getRight()) {
	    		myGraphicEntity.setIcon( ResourceManager.getProvider().getBlinkyImages()[3] );
	    	}
	    	if(direction == Directions.getDown()) {
	    		myGraphicEntity.setIcon( ResourceManager.getProvider().getBlinkyImages()[4] );
	    	}
    	} else {
    		if(direction == Directions.getNeutral()) {
	    		myGraphicEntity.setIcon( ResourceManager.getProvider().getScaredImages()[0] );
	    	}
	    	if(direction == Directions.getLeft()) {
	    		myGraphicEntity.setIcon( ResourceManager.getProvider().getScaredImages()[1] );
	    	}
	    	if(direction == Directions.getUp()) {
	    		myGraphicEntity.setIcon( ResourceManager.getProvider().getScaredImages()[2] );
	    	}
	    	if(direction == Directions.getRight()) {
	    		myGraphicEntity.setIcon( ResourceManager.getProvider().getScaredImages()[3] );
	    	}
	    	if(direction == Directions.getDown()) {
	    		myGraphicEntity.setIcon( ResourceManager.getProvider().getScaredImages()[4] );
	    	}
    	}
		
	}

	@Override
	public void accept(VisitorPacMan c) {
		
	}

	@Override
	public void calm(Game g) {
		myIA = new IABlinky(g, this);
		this.scared = false;
		
		updateGraphics(actualDirection);
	} 
}
