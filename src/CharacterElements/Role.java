package CharacterElements;

import java.util.LinkedList;

import Elements.*;
import GUI.GraphicEntity;
import Visitor.Visitor;
import GameLogic.*;
import Maps.Map;

/**
*
* Class Character.
* 
* Defines the applicable operations of a Character.
* 
* @author Agust�n Cuello, Guillermo Rodriguez, Lucio Lorenzetti.
*
*/
public abstract class Role extends Element {
    
    protected Visitor myVisitor;

    protected Object actualDirection;
    protected Object nextDirection;

    protected Map myMap;
    
    protected int speed;
    protected int speedX;
    protected int speedY;

    
    /**
    * Creates and initialize a Character;
    * @param posYPX where the Character is created.
    * @param posXPX where the Character is created.
    * @param width of the Character.
    * @param height of the Character.
    */
    public Role(int posYPX, int posXPX, int width, int height, GraphicEntity graphicEntity, int characterSpeed, Map map){
        super(posYPX, posXPX, width, height, graphicEntity);
    
        myMap = map;
        
        speed = characterSpeed;
        
        actualDirection = Directions.getNeutral();
        nextDirection = Directions.getNeutral();
    }
    
    /**
    * Moves the character depending on its actual direction.
    */
    public boolean move() {
    	
    	boolean result = false;
    	
    	int[][] corners = this.calculateCorners();
    	
    	for(int[] i : corners) {			
    		
    		myMap.removeCharacterOnTop(this, i[0], i[1]);
    		
    	}
    	
    	int[] relevantCorner;
    	
    	if(actualDirection == Directions.getLeft() || actualDirection == Directions.getUp()) {
    		relevantCorner = getTopLeftCorner();
    	} else {
    		relevantCorner = getBottomRightCorner();
    	}
    	
    	
    	int newPosX = posXPX;
    	int newPosY = posYPX;
    	
    	
    	if(actualDirection == Directions.getLeft()) {
    		newPosX -= speed;
    		relevantCorner[0] -= speed;
    	} else if(actualDirection == Directions.getDown()) {
    		newPosY += speed;
    		relevantCorner[1] += speed;
    	} else if(actualDirection == Directions.getUp()) {
    		newPosY -= speed;
    		relevantCorner[1] -= speed;
    	} else if(actualDirection == Directions.getRight()) {
    		newPosX += speed;
    		relevantCorner[0] += speed;
    	}
    	
    	
    	if(myMap.canMove(relevantCorner[1], relevantCorner[0])) {
    		posXPX = newPosX;
    		posYPX = newPosY;
    		result = true;
    	}
    	
        
        
        
        for(int[] i : corners) {
    		
    		myMap.addCharacterOnTop(this, i[0], i[1]);
    		
    	}
        
        
        
        doOnMovement();
        
        
        return result;
    }
    
    public boolean checkDirectionChange() {
    	
    	boolean result = false;
    	
    	int[] relevantCorner;
    	
    	if(nextDirection == Directions.getLeft() || nextDirection == Directions.getUp()) {
    		relevantCorner = getTopLeftCorner();
    	} else {
    		relevantCorner = getBottomRightCorner();
    	}
    	
    	if(nextDirection != actualDirection) {
    	
    		if(myMap.checkIfInPath(posXPX, posYPX)  && myMap.canMove(relevantCorner[1], relevantCorner[0], nextDirection) ) {
    			updateDirection();
    			result = true;
    		}    		
    		
    	}

		return result;
    	
    }
    
    /**
    * Updates the direction of the character.
    */
    public void updateDirection() {
    	
    	doOnDirectionChange();
    	
    	actualDirection = nextDirection;
    	
    }
     
     
   
    /**
     * Does the required actions on a movement.
     */
    protected abstract void doOnMovement();
    
    /**
     * Does the required actions on a movement.
     */
    protected abstract void doOnDirectionChange();
	
    /**
     * Changes the state of the character to the state indicated.
     * @param index new state index.
     */
    public abstract void ChangeState(int index);
    
    public abstract void updateGraphics(Object d);
    
    
    /**
     * Sets the next direction of the character.
     * @param dir nextDirection of the character.
     */
     public void setNextDirection(Object dir){
         
        nextDirection = dir; 
     
     }
    
	 /**
	  * Return the actual direction of the character.
	  * @return Direction of the character.
	  */
	 public Object getActualDirection() {
		 return actualDirection;
	 }
	 
	 /**
	  * Return the next direction of the character.
	  * @return Next direction of the character.
	  */
	 public Object getNextDirection() {
		 return nextDirection;
	 }

    public Visitor getVisitor(){
        return myVisitor;
    }
    
    public void setMap(Map m) {
    	myMap = m;
    	onMapUpdate();
    }
    
    protected void checkColitions() {
    	
    	int[] topLeftCorner = getTopLeftCorner();
    	int[] bottomRightCorner = getBottomRightCorner();
    	
    	
    	LinkedList<Role> elementosColisionados1 = myMap.checkCharacterColitions(this, topLeftCorner[0], topLeftCorner[1]);
    	LinkedList<Role> elementosColisionados2 = myMap.checkCharacterColitions(this, bottomRightCorner[0], bottomRightCorner[1]);
    	
    	for(Role colision : elementosColisionados1) {
    		colision.accept(myVisitor); 
    	}
    	for(Role colision : elementosColisionados2) {
    		colision.accept(myVisitor);
    	}
    }
    
    public abstract void accept(Visitor v);
    
    //public abstract void resetStartingPosition();

    public abstract void onMapUpdate();
    
}
