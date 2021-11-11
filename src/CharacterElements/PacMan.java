package CharacterElements;

import GUI.GraphicEntity;
import GameLogic.Directions;
import Visitor.*;
import Images.ResourceManager;
//import Images.ResourceProvider;

/**
*
* Class PacMan.
* 
* Defines the applicable operations of a PacMan.
* 
* @author Agustín Cuello, Guillermo Rodriguez, Lucio Lorenzetti.
*
*/
public class PacMan extends Role{

    /**
    * Creates and initialize a PacMan;
    * @param posX where the PacMan is created.
    * @param posY where the PacMan is created.
    * @param width of the PacMan.
    * @param heigth of the PacMan.
    */
    public PacMan(int posY, int posX, int width, int height){
    	
        super(posY, posX, width, height);
        
        
        myVisitor = new VisitorPacMan(this);
        
        myGraphicEntity = new GraphicEntity( ResourceManager.getProvider().getPacManImages()[0] );
        
    }

	
    
    @Override
    public void doOnMovement() {

    }
    
    @Override
    protected void doOnDirectionChange() {
    	
    	if(nextDirection == Directions.getNeutral()) {
    		myGraphicEntity.setIcon( ResourceManager.getProvider().getPacManImages()[0] );
    	}
    	if(nextDirection == Directions.getLeft()) {
    		myGraphicEntity.setIcon( ResourceManager.getProvider().getPacManImages()[1] );
    	}
    	if(nextDirection == Directions.getUp()) {
    		myGraphicEntity.setIcon( ResourceManager.getProvider().getPacManImages()[2] );
    	}
    	if(nextDirection == Directions.getRight()) {
    		myGraphicEntity.setIcon( ResourceManager.getProvider().getPacManImages()[3] );
    	}
    	if(nextDirection == Directions.getDown()) {
    		myGraphicEntity.setIcon( ResourceManager.getProvider().getPacManImages()[4] );
    	}
    	
    }
    
    /**
    * Makes the character die..
    */
    public  void die(){

    }
    
    

    
    /**
    * Accept the visitor of another Character passed by parameter
    */
    public  void accept(Visitor v){
        myVisitor.visitPacMan(this);
    }

}
