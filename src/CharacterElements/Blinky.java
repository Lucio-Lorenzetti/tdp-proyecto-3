package CharacterElements;
import javax.swing.ImageIcon;

import GUI.GraphicEntity;
import GameLogic.Directions;
import GameLogic.Game;
import Maps.Map;
import Visitor.*;
import IA.IABlinky;
import Images.ResourceManager;

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
    public Blinky(int posY, int posX, int width, int height, Map m){
        super(posY, posX, width, height, m, new GraphicEntity(ResourceManager.getProvider().getBlinkyImages()[1]), 4);

        
        myIA = new IABlinky(m, this);
        
        ghostState.add(myIA);

    }

	@Override
	protected void doOnDirectionChange() {
    	updateGraphics(nextDirection);
    }

	public void updateGraphics(Object direction) {
		
		ImageIcon[] images = null;
		
		if(indexState == aliveState || indexState == neutralState) {
			images = ResourceManager.getProvider().getBlinkyImages();
		} else if (indexState == vulnerableState) {
			images = ResourceManager.getProvider().getScaredImages();
		} else {
			images = ResourceManager.getProvider().getBlinkyDeathImages();
		} 
		
    	if(direction == Directions.getNeutral()) {
    		myGraphicEntity.setIcon( images[0] );
    	} else
    	if(direction == Directions.getLeft()) {
    		myGraphicEntity.setIcon( images[1] );
    	} else
    	if(direction == Directions.getUp()) {
    		myGraphicEntity.setIcon( images[2] );
    	} else
    	if(direction == Directions.getRight()) {
    		myGraphicEntity.setIcon( images[3] );
    	} else
    	if(direction == Directions.getDown()) {
    		myGraphicEntity.setIcon( images[4] );
    	}
    	
		
	}	
	
}
