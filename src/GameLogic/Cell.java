package GameLogic;

import Elements.*;

/**
*
* Class Cell.
* 
* Defines the applicable operations of a Cell.
* 
* @author Agustín Cuello, Guillermo Rodriguez, Lucio Lorenzetti.
*
*/
public class Cell {

	private Element myElement;
	private boolean walkable;
	private int column;
	private int row;

    /**
    * Creates and initialize a cell;
    * @param row where the cell is created.
    * @param col where the cell is created.
    * @param p which the cell contains.
    * @param walkable decides if the cell can be pass by a character.
    */
    public Cell(int row, int col, Pickeable p, boolean walkable){
    	myElement = p;
        this.walkable = walkable;
        this.row = row;
        column = col;
    }
    
    
    
    /**
    * Creates and initialize a cell;
    * @param row where the cell is created.
    * @param col where the cell is created.
    * @param walkable decides if the cell can be pass by a character.
    */
    public Cell(int row, int col, boolean walkable){
        this.walkable = walkable;
        this.row = row;
        column = col;
    }

    /**
    *Adds a pickeable to the cell.
    */
    public void addPickeable(){
        
    }

    /**
    * Removes the pickeable of the cell which is called.
    * @Returns the removed pickeable.
    */
    public Pickeable removePickeable(){
    	
        return null;
    }   
}
