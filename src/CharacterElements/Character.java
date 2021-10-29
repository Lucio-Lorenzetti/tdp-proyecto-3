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

    protected int row;
    protected int col;
    protected Visitor myVisitor;

    
    /**
    * Creates and initialize a Character;
    * @param row where the Character is created.
    * @param col where the Character is created.
    * @param v the character´s visitor.
    */
    public Character(int col, int row){
        this.col = col;
        this.row = row;
    }

    /**
    * Moves the character up.
    */
    public abstract void moveUp();
    
    /**
    * Moves the character down.
    */
     public abstract void moveDown();
    
    /**
    * Moves the character left.
    */
     public abstract void moveLeft();
    
    /**
    * Moves the character right.
    */
    public abstract void moveRight();
    
    /**
    * The row where the Character is.
    * @return row.
    */
    public abstract int getRow();

    /**
    * The column where the Character is.
    * @return column.
    */
    public abstract int getColumn();
    /**
    * Accept the visitor of another Character passed by parameter.
    */
    public abstract void accept(Visitor v);
}
