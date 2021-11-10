package Maps;

import javax.lang.model.util.Elements;
import java.util.LinkedList;


import CharacterElements.*;

import CharacterElements.Character;
import GameLogic.Cell;
import GameLogic.Directions;
import GameLogic.Game;
import PickeableElements.Pickeable;

/**
 *
 * Class Map.
 * 
 * Defines the applicable operations of a Map.
 * 
 * @author Agustín Cuello, Guillermo Rodriguez, Lucio Lorenzetti.
 *
 */
public class Map {
    
    protected Game game;
    protected static final int height = 20;
    protected static final int width = 20;
    protected Cell[][] cells;


    /**
     * Creates and initializes Map.
     */
    public Map(Game g){
   
    	game = g;
        cells = new Cell[height][width];
    
    }
    
    /**
    * Returns if the movement, depending on the direction, its possible.
    * @param posY to check.
    * @param posX to check.
    * @param direction to check.
    * @return true if its possible, false otherwise.
    */
    public boolean canMove( int posY, int posX, Object direction ){
    	
    	boolean result = true;

        if(direction == Directions.getLeft()) {
        	result = checkMovablePosition(posX - 1, posY);
        }
        if(direction == Directions.getRight()) {
        	result = checkMovablePosition(posX + 1, posY);
        }
        if(direction == Directions.getUp()) {
        	result = checkMovablePosition(posX, posY - 1);
        }
        if(direction == Directions.getDown()) {
        	result = checkMovablePosition(posX, posY + 1);
        }
        
        return result;
    
    }
    
    
    

    /**
    * Checks if right movement is possible.
    * @param row to check. 
    * @param col to check.
    * @return true if it's possible, false otherwise.
    */
    public boolean canMoveRight(int posY, int posX){
        boolean can = true;
       
        can = checkMovablePosition(posX + 1, posY);
        
        return can;
    }
    
    
    
    /**
    * Checks if left movement is possible.
    * @param row to check.
    * @param col to check
    * @return true if it's possible, false otherwise.
    */
    public boolean canMoveLeft(int posY, int posX){
        boolean can = true;
        
        can = checkMovablePosition(posX-1, posY);
        
        return can;
    }

    /**
    * Checks if up movement is possible.
    * @param row to check.
    * @param col to check
    * @return true if it's possible, false otherwise.
    */
    public boolean canMoveUp(int posY, int posX){
        boolean can = true;
        
        can = checkMovablePosition(posX, posY-1);
        
        return can;
    }
    /**
    * Checks if down movement is possible.
    * @param row to check.
    * @param col to check.
    * @return true if it's possible, false otherwise.
    */
    public boolean canMoveDown(int posY, int posX){
    	boolean can = true;
        
    	can = checkMovablePosition(posX, posY+1);
    	
        return can;
    }
    
    /**
     * Checks if the cell that contains the position posX posY is walkable.
     * @param posX position of the verification on the X axis.
     * @param posY position of the verification on the Y axis.
     * @return true if the cell is walkable, false if it is not.
     */
    private boolean checkMovablePosition(int posX, int posY) {
    	
    	boolean canMove = true;
    	
        
        canMove = getCellByPosition(posX, posY).getWalkable();
    	
        
    	return canMove;
    
    }


    private Cell getCellByPosition(int posX, int posY) {
    
    	int cellWidth = cells[0][0].getWidth();
        int cellHeight = cells[0][0].getHeight();
        
        int posCellX = posX - (posX % cellWidth);
        int posCellY = posY - (posY % cellHeight);
        
        int colCell = posCellX / cellWidth;
        int rowCell = posCellY / cellHeight;
        
        return cells[rowCell][colCell];    	
    	
    }
    

    public boolean checkIfInPath(int posX, int posY) {
    	
    	Cell obtainedCell = getCellByPosition(posX, posY);
    	
    	return obtainedCell.getPosX() == posX && obtainedCell.getPosY() == posY;
    	
    }
    
    
    
    /**
    * Return the cell located to the column and row passed by parameter.
    * @param row
    * @param col
    * @return the cell that it's called searched by it's position.
    */
    public Cell getCell(int row, int col){
        return cells[row][col];        
    }
    
    
    /**
    * Return the Map height in cells.
    */
    public int getHeight() {
    	return height;
    }
    
    
    /**
     * Return the Map width in cells.
     */
    public int getWidth() {
    	return width;
    }

    public boolean checkAllCollision(Character c) {
    	
    	
		
		
		return false;
	}
    
	public Pickeable checkPickeableCollision(Character c) {
		
		Pickeable result = null;
		
		LinkedList<Cell> cellList = new LinkedList<Cell>();
		
		Cell aux1 = getCellByPosition(c.getColumn(), c.getRow());     	
		
        cellList.add(aux1);
		
		Cell aux2 = getCellByPosition(c.getColumn() + c.getWidth(), c.getRow() + c.getHeight());
		
        if(aux1 != aux2) {
        	cellList.add(aux2);
        }

        for(Cell cellAux : cellList){
        	
        	if(c.collidesWith( cellAux.getPickup() ) || cellAux.getPickup().collidesWith( c )) {
        		result = cellAux.getPickup();
        	}
        	 	
        }
        
		return result;
	}
	
	
}
