package GameLogic;



import GUI.GraphicEntity;
import PickeableElements.Pickeable;
import java.util.LinkedList;

import javax.swing.ImageIcon;

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
	private boolean isIntersection;

	private int column;
	private int row;
    private int posXPX;
    private int posYPX;
    private int widthPX;
    private int heightPX;
	
    private LinkedList<CharacterElements.Role> charactersOnTop;
	
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
    public Cell(int row, int col, Pickeable p, boolean walkable, int height, int width, ImageIcon icon) {
    	
    	
        this.walkable = walkable;
        
        isIntersection = false;
        
        this.row = row;
        column = col;
        
        widthPX = width;
        heightPX = height;
        
        posXPX = widthPX * col;
        posYPX = heightPX * row;
        
        myGraphicEntity = new GraphicEntity(icon);
        
        if(walkable && p != null) {
            pickeable = p;
            this.adjustPickeable();
        } else {
        	pickeable = null;
        }
        
    }
    
    /**
     * Creates and initialize a cell;
     * @param row where the cell is created.
     * @param col where the cell is created.
     * @param p which the cell contains.
     * @param walkable decides whether the cell can be walked by a character.
     * @param intersection decides whether the cell is an intersection of 2 or more roads.
     * @param height height of the cell.
     * @param width width of the cell.
     */
    public Cell(int row, int col, Pickeable p, boolean walkable, boolean intersection, int height, int width, ImageIcon icon) {
    	
        this(row, col, p, walkable, height, width, icon);
        
        isIntersection = intersection;

    }
    
    
    /**
     * Adjusts the pickeable in the desired position depending on the width, height and position of the cell.
     */
    public void adjustPickeable() {
    	
    	if(pickeable != null) {
	    	int pickeableSizeX;
	    	int pickeableSizeY;
	    	
	    	int pickeablePosX;
	    	int pickeablePosY;
	    	
	    	
	    	pickeableSizeX = widthPX / 3;
	    	pickeableSizeX = pickeableSizeX * 2;

	    	pickeableSizeY = heightPX / 3 ;
	    	pickeableSizeY = pickeableSizeY * 2;
	    	
	    	pickeablePosX = posXPX + ((widthPX - pickeableSizeX) / 2); 
	    	pickeablePosY = posYPX + ((heightPX - pickeableSizeY) / 2); 
	    	
	    	
	    	pickeable.setHeight(pickeableSizeY);
	    	pickeable.setWidth(pickeableSizeX);
	    	
	    	pickeable.setPosY(pickeablePosY);
	    	pickeable.setPosX(pickeablePosX);
    	}
    }
    
    
    /**
    * Adds a pickeable to the cell.
    * @param p pickeable to add in the cell.
    */
    public void setPickeable(Pickeable p){
        pickeable = p;
        adjustPickeable();
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
     * Clones the values of the cell which is called.
     */
     public Cell clone() {
     	
     	Cell newCell;
     	
     	Pickeable pickeableClone = null;
     	
     	if(pickeable != null)
     		pickeableClone = pickeable.clone();
     	
     	newCell = new Cell(row, column, pickeableClone, walkable, isIntersection, heightPX, widthPX, myGraphicEntity.getIcon());
     	
     	return newCell;
     }
    
    /**
    * Clones the cell called by message and change the position of the cloned one.
    * @param r new row of the cloned cell.
    * @param c new column of the cloned cell.
    * @return the cloned cell with the new position.
    */
    public Cell cloneInPosition(int r, int c) {
    	
    	Cell newCell;
    	
    	newCell = this.clone();

    	newCell.setRow(r);
    	newCell.setColumn(c);
    	
    	if(newCell.getPickup() != null) {
    		newCell.adjustPickeable();
    	}
    	
    	
    	return newCell;
    }

    /**
    * Add a character above the cell.
    * @param ch character to add.
    */
    public void addCharacterOnTop(CharacterElements.Role ch) {
    	charactersOnTop.add(ch);
    }
    
    /**
    * Remove the character that was on the cell.
    * @param ch character to remove.
    */   
    public void removeCharacterOnTop(CharacterElements.Role ch) {
    	charactersOnTop.remove(ch);
    }
    
    
    /**
    * Returns the graphic entity of the cell.
    * @return graphic entity.
    */
    public GraphicEntity getGraphicEntity() {
    	return myGraphicEntity;
    }
    
    /**
     * Returns if the cell is an intersection.
     * @return true if the cell is an intersection, false if not.
     */
    public boolean isIntersection() {
    	return isIntersection;
    }
    
    /**
     * Returns the pickup contained in the cell
     * @return pickeable element.
     */
    public Pickeable getPickup() {
    	return pickeable;
    }
    /**
     * Returns the atributte heightPX
     * @return the height of the cell.
     */
    public int getHeight() {
    	return heightPX;
    }
    /**
     * Returns the atributte widthPX
     * @return the width of the cell.
     */
    public int getWidth() {
    	return widthPX;
    }
    
    /**
     * Returns the atributte posXPX
     * @return the position of the cell's pixel on the x-axis.
     */
    public int getPosX() {
    	return posXPX;
    }
    
    /**
     * Returns the atributte posYPX
     * @return the position of the cell's pixel on the y-axis.
     */
    public int getPosY() {
    	return posYPX;
    }
    
    /**
     * Returns the atributte walkable.
     * @return if the cell is walkable or not.
     */    
    public boolean getWalkable() {
    	return walkable;
    }
    
    /**
     * Returns the atributte row.
     * @return the row where the cell is.
     */ 
    public int getRow(){
        return row;
    }
    
    /**
     * Returns the atributte column.
     * @return the column where the cell is.
     */ 
    public int getColumn(){
        return column;
    }

    /**
    * Sets the row of the cell.
    * @param r row to be setted.
    */
    public void setRow(int r) {
    	row = r;
        posYPX = heightPX * r;	
    }
    
    /**
    * Sets the column of the cell.
    * @param c column to be setted.
    */
    public void setColumn(int c) {
    	column = c;
    	posXPX = widthPX * c;
    }
    
    /**
    * Sets the atributte pickeable.
    * @param p the pikeable element.
    */
    public void setPickup(Pickeable p) {
    	pickeable = p;
    }
    
}
