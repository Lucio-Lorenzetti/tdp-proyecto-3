package CharacterElements;
import javax.swing.ImageIcon;

import GUI.GraphicEntity;
import GameLogic.Directions;
import IA.IAPinky;
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
        super(posY, posX, width, height, dead, moving, m, new GraphicEntity(ResourceManager.getProvider().getPinkyImages()[1]));
        
        
        myVisitor = new VisitorPinky(this);
        
        myIA = new IAPinky(m, this);
        
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
			images = ResourceManager.getProvider().getPinkyImages();
		} else if (indexState == 1) {
			images = ResourceManager.getProvider().getScaredImages();
		} else {
			images = ResourceManager.getProvider().getScaredImages(); //CAMBIAR POR DEAD
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


    @Override
    public void accept(Visitor c){
		myVisitor.visitPinky(this);
    }


	
}
