package CharacterElements;
import javax.swing.ImageIcon;

import GUI.GraphicEntity;
import GameLogic.Directions;
import IA.IAInky;
import Images.ResourceManager;
import Visitor.*;
import Maps.Map;
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
    public Inky(int posY, int posX, int width, int height, Map m){
        super(posY, posX, width, height, m, new GraphicEntity(ResourceManager.getProvider().getInkyImages()[1]), 3);
        myVisitor = new VisitorGhost(this);
        
        myIA = new IAInky(m, this);
        
        ghostState.add(myIA);

        
    }

	@Override
	protected void doOnDirectionChange() {
    	updateGraphics(nextDirection);
	}

	@Override	
	public void updateGraphics(Object direction) {
		
		ImageIcon[] images = null;
		
		if(indexState == 2) {
			images = ResourceManager.getProvider().getInkyImages();
		} else if (indexState == 1) {
			images = ResourceManager.getProvider().getScaredImages();
		} else {
			images = ResourceManager.getProvider().getInkyDeathImages();
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