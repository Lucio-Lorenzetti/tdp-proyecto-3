package CharacterElements;
import javax.swing.ImageIcon;

import GUI.GraphicEntity;
import GameLogic.Directions;
import GameLogic.Game;
import IA.IAClyde;
import Images.ResourceManager;
import Maps.Map;
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
    public Clyde(int posY, int posX, int width, int height, Map m){
        super(posY, posX, width, height, m, new GraphicEntity(ResourceManager.getProvider().getClydeImages()[1]), 4);
        myVisitor = new VisitorGhost(this);
    
        myIA = new IAClyde(m, this);
        ghostState.add(myIA);
        
    }


	@Override
	protected void doOnDirectionChange() {
		updateGraphics(nextDirection);
	}
	

    public void updateGraphics(Object direction) {
		
		ImageIcon[] images = null;
		
		if(indexState == aliveState || indexState == neutralState) {
			images = ResourceManager.getProvider().getClydeImages();
		} else if (indexState == 1) {
			images = ResourceManager.getProvider().getScaredImages();
		} else {
			images = ResourceManager.getProvider().getClydeDeathImages();
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
