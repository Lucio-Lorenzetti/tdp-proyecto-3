package CharacterElements;

import Elements.*;
import Visitor.*;

/**
*
* Class Character.
* 
* Defines the applicable operations of a Character.
* 
* @author Agustín Cuello, Guillermo Rodriguez, Lucio Lorenzetti.
*
*/
public abstract class Character extends Element {

    protected int posXPX;
    protected int posYPX;
    protected int widthPX;
    protected int heightPX;
    protected Visitor myVisitor;

    
    /**
    * Creates and initialize a Character;
    * @param row where the Character is created.
    * @param col where the Character is created.
    * @param v the character´s visitor.
    */
    public Character(int posYPX, int posXPX, int width, int height){
        this.posXPX = posXPX;
        this.posYPX = posYPX;
        this.widthPX = width;
        this.heightPX = height;
    }

    /**
    * Moves the character up.
    */
    public  void moveUp() {
    	posYPX--;
        System.out.println("Posicion en y: "+posYPX);
    	doOnMovement();
    }
    
    /**
    * Moves the character down.
    */
     public void moveDown() {
    	posYPX++;
        System.out.println("Posicion en y: "+posYPX);
        doOnMovement();
     }
    
    /**
    * Moves the character left.
    */
     public  void moveLeft() {
    	 posXPX--;
        System.out.println("Posicion en x: "+posXPX);
    	 doOnMovement();
     }
    
    /**
    * Moves the character right.
    */
    public  void moveRight() {
    	posXPX++;
        System.out.println("Posicion en x: "+posXPX);
    	doOnMovement();
    }
    
   
    public abstract void doOnMovement();
    
    
    
    /**
     * The row where the Chacarter is.
     * @return row.
     */
     public  int getRow(){
         return posYPX;
     }

    /**
     * The column where the Chacarter is.
     * @return column.
     */
     public int getColumn(){
         return posXPX;
     }
     
     public int getWidth() {
    	 return widthPX;
     }
     
     public int getHeight() {
    	 return heightPX;
     }
     
    
    /**
    * Accept the visitor of another Character passed by parameter.
    */
    public abstract void accept(Visitor v);
}
