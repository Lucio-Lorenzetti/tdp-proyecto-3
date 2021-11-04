package GameLogic;

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
    
    //			44		45		
    //   celdaPosicion  posX
    //					posX mod 22 -> 1
    // 44 = posX - (posX mod 22)
    // 		celdaPosicion / 22
    
    
    
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
    	
    	int cellWidth = cells[0][0].getWidth();
        int cellHeight = cells[0][0].getHeight();
        
        System.out.println("cellWidth: " + cellWidth);
        System.out.println("cellHeight: " + cellHeight);
        
        int posCellX = posX - (posX % cellWidth);
        int posCellY = posY - (posY % cellHeight);
        
        int colCell = posCellX / cellWidth;
        int rowCell = posCellY / cellHeight;
        
        canMove = cells[rowCell][colCell].getWalkable();
    	
    	return canMove;
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
     * Sets the cell located to the column and row passed by parameter.
     * @param row
     * @param col
     * @return the cell that it's called searched by it's position.
     */
    public void setCell(Cell cell) {
    	
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
    
}
