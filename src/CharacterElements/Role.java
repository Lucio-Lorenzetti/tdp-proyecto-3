package CharacterElements;

import Elements.*;
import Visitor.*;
import GameLogic.*;

/**
*
* Class Character.
* 
* Defines the applicable operations of a Character.
* 
* @author Agustín Cuello, Guillermo Rodriguez, Lucio Lorenzetti.
*
*/
public abstract class Role extends Element {
    
    protected Visitor myVisitor;

    protected Object actualDirection;
    protected Object nextDirection;
    
    /**
    * Creates and initialize a Character;
    * @param posYPX where the Character is created.
    * @param posXPX where the Character is created.
    * @param width of the Character.
    * @param height of the Character.
    */
    public Role(int posYPX, int posXPX, int width, int height){
        
    	this.posXPX = posXPX;
        this.posYPX = posYPX;
        this.widthPX = width;
        this.heightPX = height;
    
        actualDirection = Directions.getLeft();
        nextDirection = Directions.getLeft();
    }
    
    /**
    * Moves the character depending on its actual direction.
    */
    public void move() {
    	
        if(actualDirection == Directions.getRight()) {
        	moveRight();
        } 
        if(actualDirection == Directions.getLeft()) {
        	moveLeft();
        } 
        if(actualDirection == Directions.getUp()) {
        	moveUp();
        } 
        if(actualDirection == Directions.getDown()) {
        	moveDown();
        }
        
        doOnMovement();
        
    }
    
    /**
    * Updates the direction of the character.
    */
    public void updateDirection() {
    	
    	doOnDirectionChange();
    	
    	actualDirection = nextDirection;
    	
    }
    


    /**
    * Moves the character up.
    */
    protected void moveUp() {
    	posYPX--;
    }
    
    /**
    * Moves the character down.
    */
     protected void moveDown() {
    	posYPX++;
     }
    
    /**
    * Moves the character left.
    */
     protected  void moveLeft() {
    	 posXPX--;
     }
    
    /**
    * Moves the character right.
    */
     protected  void moveRight() {
    	posXPX++;
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

}
