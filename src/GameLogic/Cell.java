package GameLogic;



import GUI.GraphicEntity;
import PickeableElements.Pickeable;
import java.util.LinkedList;
import CharacterElements.*;

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

	private boolean walkable;

	private int column;
	private int row;
    private int posXPX;
    private int posYPX;
    private int widthPX;
    private int heightPX;
	
    private LinkedList<CharacterElements.Character> charactersOnTop;
	
	private Pickeable pickeable;
	private GraphicEntity myGraphicEntity;
	
	
	
    /**
    * Creates and initialize a cell;
    * @param row where the cell is created.
    * @param col where the cell is created.
    * @param p which the cell contains.
    * @param walkable decides whether the cell can be walked by a character.
    * @param height height of the cell.
    * @param width width of the cell.
    */
    public Cell(int row, int col, Pickeable p, boolean walkable, int image, int height, int width) {
    	
    	
        this.walkable = walkable;
        this.row = row;
        column = col;
        
        
        widthPX = width;
        heightPX = height;
        
        posXPX = widthPX * col;
        posYPX = heightPX * row;
        
        myGraphicEntity = new GraphicEntity(image);
        
        if(walkable) {
            pickeable = p;
        } else {
        	pickeable = null;
        }
        
    }
    
    
    /**
    * Adds a pickeable to the cell.
    * @param p pickeable to add in the cell.
    */
    public void addPickeable(Pickeable p){
        pickeable = p;
    }

    /**
    * Removes the pickeable of the cell which is called.
    * @Returns the removed pickeable.
    */
    public Pickeable removePickeable(){
    	//hacer un pickeable.destroy();
        pickeable = null;
        return pickeable;
    }   
    
    
    

    /**
    * Returns the graphic entity of the cell.
    * @return graphic entity.
    */
    public GraphicEntity getGraphicEntity() {
    	return myGraphicEntity;
    }
    
    /**
     * Returns the pickup contained in the cell
     * @return pickeable element.
     */
    public Pickeable getPickup() {
    	return pickeable;
    }
    
    public int getHeight() {
    	return heightPX;
    }
    
    public int getWidth() {
    	return widthPX;
    }
    
    public int getPosX() {
    	return posXPX;
    }
    
    public int getPosY() {
    	return posYPX;
    }
    
    
    public boolean getWalkable() {
    	return walkable;
    }
    
    /**
    * Sets the row of the cell.
    * @param r row to be seted.
    */
    public void setRow(int r) {
    	row = r;
        posYPX = heightPX * r;	
    }
    
    /**
    * Sets the column of the cell.
    * @param c column to be seted.
    */
    public void setColumn(int c) {
    	column = c;
    	posXPX = widthPX * c;
    }
    
    /**
     * Clones the values of the cell which is called.
     */
     public Cell clone() {
     	
     	Cell newCell;
     	
     	Pickeable pickeableClone = null;
     	
     	if(pickeable != null)
     		pickeableClone = pickeable.clone();
     	
     	newCell = new Cell(row, column, pickeableClone, walkable, myGraphicEntity.getIndex(), heightPX, widthPX);
     	
     	return newCell;
     }
    
    /**
    * Clones the cell called by messega and change the position of the cloned one.
    * @param r new row of the cloned cell.
    * @param c new column of the cloned cell.
    * @return the cloned cell with the new position.
    */
    public Cell cloneInPosition(int r, int c) {
    	
    	Cell newCell;
    	
    	newCell = this.clone();

    	newCell.setRow(r);
    	newCell.setColumn(c);
    	
    	
    	
    	return newCell;
    }

    
    public void addCharacterOnTop(CharacterElements.Character ch) {
    	charactersOnTop.add(ch);
    }
    
    public void removeCharacterOnTop(CharacterElements.Character ch) {
    	charactersOnTop.remove(ch);
    }
    
}
