package CharacterElements;

import javax.swing.ImageIcon;

import GUI.GraphicEntity;
import GameLogic.Directions;
import Images.ResourceManager;
import Visitor.*;
import GameLogic.Game;
import Maps.Map;
import PickeableElements.Pickeable;

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

    private int state;
    
    private Game myGame;
    

    /**
    * Creates and initialize a PacMan;
    * @param posX where the PacMan is created.
    * @param posY where the PacMan is created.
    * @param width of the PacMan.
    * @param heigth of the PacMan.
    */
    public PacMan(int posY, int posX, int width, int height, Map map, Game game){
    	
        super(posY, posX, width, height, new GraphicEntity( ResourceManager.getProvider().getPacManImages()[0] ), 3, map);
        
        state = 0; 

        myVisitor = new VisitorPacMan(this);

        myGame = game;

        
        
    }

    public PacMan(Map map, Game game) {
    	
    	super(0, 0, 0, 0, new GraphicEntity( ResourceManager.getProvider().getPacManImages()[0] ), 4, map);
    	
    	myGame = game;
        
        state = 0;

    	myVisitor = new VisitorPacMan(this);
        
    }
	
    
    @Override
    public void doOnMovement() {
    	
    	Pickeable detectedPickeable = myMap.checkPickeableCollision(this);

    	if(detectedPickeable != null) {
    			
			myMap.consumePickeable(detectedPickeable);
    			
    	}
    	
    	checkColitions();
    	
    }
    
    @Override
    protected void doOnDirectionChange() {
    	
        updateGraphics(actualDirection);
    	
    }
  
    @Override
    public void ChangeState(int s){
        ImageIcon[] imageState = null;
        switch(state){
            case 0: {
                imageState = ResourceManager.getProvider().getPacManImages();
                if(s == 1){
                    myGraphicEntity.setIcon(imageState[7]);
                }else{
                    myGraphicEntity.setIcon(imageState[6]);
                }
                break;
            }
            case 1: {
                imageState = ResourceManager.getProvider().getPacManSPImages();
                if(s == 0){
                    myGraphicEntity.setIcon(imageState[6]);
                }else{
                    myGraphicEntity.setIcon(imageState[7]);
                }
                break;
            }
            case 2: {
                imageState = ResourceManager.getProvider().getPacManBPImages();
                if(s == 0){
                    myGraphicEntity.setIcon(imageState[6]);
                }else{
                    myGraphicEntity.setIcon(imageState[7]);
                }
                break;
            }

        }        
        state = s;
        
    }
    

	@Override
	public void updateGraphics(Object d) {
		
		ImageIcon[] imageState = null;
        
        
        switch(state){
            case 0: {
                imageState = ResourceManager.getProvider().getPacManImages();
                break;
            }
            case 1: {
                imageState = ResourceManager.getProvider().getPacManSPImages();
                break;
            }
            case 2: {
                imageState = ResourceManager.getProvider().getPacManBPImages();
                break;
            }

        }
    	
    	if(nextDirection == Directions.getNeutral()) {
    		myGraphicEntity.setIcon( imageState[0] );
    	}
    	if(nextDirection == Directions.getLeft()) {
    		myGraphicEntity.setIcon( imageState[1] );
    	}
    	if(nextDirection == Directions.getUp()) {
    		myGraphicEntity.setIcon( imageState[2] );
    	}
    	if(nextDirection == Directions.getRight()) {
    		myGraphicEntity.setIcon( imageState[3] );
    	}
    	if(nextDirection == Directions.getDown()) {
    		myGraphicEntity.setIcon( imageState[4] );
    	}
		
	}

	
	public void death() {

		myGame.pacmanDeath();	
		
	}
	
	public void accept(Visitor v) {
		v.visitPacMan(this);
	}


	@Override
	public void onMapUpdate() {
		heightPX = myMap.getCellHeight() - 1;
    	widthPX = myMap.getCellWidth() - 1;
    	posXPX = myMap.getPacmanPositionX();
    	posYPX = myMap.getPacmanPositionY();
	}
	

}
